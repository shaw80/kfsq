package com.jzhl.kfsq.service.pm.impl;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jzhl.kfsq.common.base.ListResult;
import com.jzhl.kfsq.common.util.TimeUtil;
import com.jzhl.kfsq.dao.pm.ISalesManagerCountMapper;
import com.jzhl.kfsq.dataset.pm.CustomerDataSet;
import com.jzhl.kfsq.dataset.pm.SalesManagerCountDataSet;
import com.jzhl.kfsq.dataset.pm.SevenDayDataSet;
import com.jzhl.kfsq.dataset.pm.SevenDayReceiveDataSet;
import com.jzhl.kfsq.dataset.pm.TeamCustomerDataSet;
import com.jzhl.kfsq.dataset.pm.UserCustomerDataSet;
import com.jzhl.kfsq.dataset.pm.VisitCommonBean;
import com.jzhl.kfsq.dataset.pm.VisitCommonDataSet;
import com.jzhl.kfsq.dataset.pm.VisitCommonTeamDataSet;
import com.jzhl.kfsq.dataset.sm.ManagerDataSet;
import com.jzhl.kfsq.dataset.sm.ManagerReceiveDataSet;
import com.jzhl.kfsq.dataset.sm.SalerDataSet;
import com.jzhl.kfsq.service.pm.ISalesManagerCountService;

/**
 * 销售经理统计页面业务层实现类
 * 
 * @author Shaw
 *
 */
@Service
public class SalesManagerCountServiceImpl implements ISalesManagerCountService {

	@Autowired
	private ISalesManagerCountMapper salesManagerDao;

	/**
	 * 统计销售经理页面数据
	 * 
	 * @param userId
	 * @return
	 */
	@SuppressWarnings("deprecation")
	@Override
	public SalesManagerCountDataSet getCount(int userId) {
		Map<String, Object> salesManager = new HashMap<String, Object>();
		Timestamp monthBeginTime = new Timestamp(
				TimeUtil.getCurrentMonthStartTime());
		Timestamp monthEndTime = new Timestamp(
				TimeUtil.getCurrentMonthEndTime());
		salesManager.put("monthBeginTime", monthBeginTime);
		salesManager.put("monthEndTime", monthEndTime);
		salesManager.put("userId", userId);
		SalesManagerCountDataSet dataSet = salesManagerDao
				.getCount(salesManager);
		List<SevenDayDataSet> sevenDayList = new ArrayList<SevenDayDataSet>();
		SimpleDateFormat sdf = new SimpleDateFormat("dd");
		Map<String, Object> sevenDay = new HashMap<String, Object>();
		for (int i = 7; i > 0; i--) {
			sevenDay.put("userId", userId);
			sevenDay.put("day", i);
			SevenDayReceiveDataSet dataSet_receive = salesManagerDao
					.getSevenDay(sevenDay);
			SevenDayDataSet dataSet_sevenDay = new SevenDayDataSet();
			dataSet_sevenDay.setCount(dataSet_receive.getCount());
			int day = dataSet_receive.getDay().getDay();
			switch (day) {
			case 1:
				dataSet_sevenDay.setDay("一");
				break;
			case 2:
				dataSet_sevenDay.setDay("二");
				break;
			case 3:
				dataSet_sevenDay.setDay("三");
				break;
			case 4:
				dataSet_sevenDay.setDay("四");
				break;
			case 5:
				dataSet_sevenDay.setDay("五");
				break;
			case 6:
				dataSet_sevenDay.setDay("六");
				break;
			default:
				dataSet_sevenDay.setDay("日");
				break;
			}
			dataSet_sevenDay.setDate(sdf.format(dataSet_receive.getDay()));
			sevenDayList.add(dataSet_sevenDay);
			dataSet.setDays(sevenDayList);
		}
		return dataSet;
	}

	/**
	 * 根据销售经理编号查询所有下属的今日到访业绩及今日总到访量
	 * 
	 * @param userId
	 * @param begin
	 * @param length
	 * @return
	 */
	@Override
	public VisitCommonDataSet getVisitTodayPerson(int userId, int begin,
			int length) {
		VisitCommonDataSet result = new VisitCommonDataSet();
		ListResult listResult = new ListResult();
		Map<String, Object> visitToday = new HashMap<String, Object>();
		Timestamp today = new Timestamp(System.currentTimeMillis());
		visitToday.put("userId", userId);
		visitToday.put("beginTime", today);
		visitToday.put("endTime", today);
		Integer visitTotal = salesManagerDao.getVisit(visitToday);// 统计今日到访量
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("userId", userId);
		params.put("begin", begin);
		params.put("length", length);
		params.put("beginTime", today);
		params.put("endTime", today);
		List<VisitCommonBean> dataList = (List<VisitCommonBean>) salesManagerDao
				.findVisitPerson(params);// 查询到访业绩数据
		if (dataList != null) {
			for (int i = 0; i < dataList.size(); i++) {
				if (begin == 0) {
					dataList.get(i).setRank(i + 1);
				}
				if (begin > 0) {
					dataList.get(i).setRank(begin + i + 1);
				}
			}
		}
		Integer dataCount = salesManagerDao.countVisitPerson(visitToday);// 统计到访业绩数据量
		listResult.setDataCount(dataCount);
		listResult.setDataList(dataList);
		result.setTotalVisit(visitTotal);
		result.setPerformances(listResult);
		return result;
	}

	/**
	 * 根据销售经理编号查询所有下属的总到访业绩及总到访量
	 * 
	 * @param userId
	 * @param begin
	 * @param length
	 * @return
	 */
	@Override
	public VisitCommonDataSet getVisitMonthPerson(int userId, int begin,
			int length) {
		VisitCommonDataSet result = new VisitCommonDataSet();
		ListResult listResult = new ListResult();
		Map<String, Object> visitToday = new HashMap<String, Object>();
		Timestamp beginTime = new Timestamp(TimeUtil.getCurrentMonthStartTime());
		Timestamp endTime = new Timestamp(TimeUtil.getCurrentMonthEndTime());
		visitToday.put("userId", userId);
		visitToday.put("beginTime", beginTime);
		visitToday.put("endTime", endTime);
		Integer visitTotal = salesManagerDao.getVisit(visitToday);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("userId", userId);
		params.put("begin", begin);
		params.put("length", length);
		params.put("beginTime", beginTime);
		params.put("endTime", endTime);
		List<VisitCommonBean> dataList = (List<VisitCommonBean>) salesManagerDao
				.findVisitPerson(params);
		if (dataList != null) {
			for (int i = 0; i < dataList.size(); i++) {
				if (begin == 0) {
					dataList.get(i).setRank(i + 1);
				}
				if (begin > 0) {
					dataList.get(i).setRank(begin + i + 1);
				}
			}
		}
		Integer dataCount = salesManagerDao.countVisitPerson(visitToday);
		listResult.setDataCount(dataCount);
		listResult.setDataList(dataList);
		result.setTotalVisit(visitTotal);
		result.setPerformances(listResult);
		return result;
	}

	/**
	 * 根据销售经理编号查询所有下属的总到访业绩及总到访量
	 * 
	 * @param userId
	 * @param begin
	 * @param length
	 * @return
	 */
	@Override
	public VisitCommonDataSet getVisitTotalPerson(int userId, int begin,
			int length) {
		VisitCommonDataSet result = new VisitCommonDataSet();
		ListResult listResult = new ListResult();
		Map<String, Object> visitToday = new HashMap<String, Object>();
		visitToday.put("userId", userId);
		Integer visitTotal = salesManagerDao.getVisit(visitToday);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("userId", userId);
		params.put("begin", begin);
		params.put("length", length);
		List<VisitCommonBean> dataList = (List<VisitCommonBean>) salesManagerDao
				.findVisitPerson(params);
		if (dataList != null) {
			for (int i = 0; i < dataList.size(); i++) {
				if (begin == 0) {
					dataList.get(i).setRank(i + 1);
				}
				if (begin > 0) {
					dataList.get(i).setRank(begin + i + 1);
				}
			}
		}
		Integer dataCount = salesManagerDao.countVisitPerson(visitToday);
		listResult.setDataCount(dataCount);
		listResult.setDataList(dataList);
		result.setTotalVisit(visitTotal);
		result.setPerformances(listResult);
		return result;
	}

	/**
	 * 根据销售经理编号分页查询今天本楼盘所有团队到访业绩
	 * 
	 * @param userId
	 * @param begin
	 * @param length
	 * @return
	 */
	@Override
	public VisitCommonTeamDataSet getVisitTodayTeam(int userId, int begin,
			int length) {
		VisitCommonTeamDataSet result = new VisitCommonTeamDataSet();
		ListResult listResult = new ListResult();
		Map<String, Object> visitToday = new HashMap<String, Object>();
		visitToday.put("userId", userId);
		Integer visitTotal = salesManagerDao.countVisitTeam(visitToday);
		listResult.setDataCount(visitTotal);
		Timestamp today = new Timestamp(System.currentTimeMillis());
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("userId", userId);
		params.put("begin", begin);
		params.put("length", length);
		params.put("beginTime", today);
		params.put("endTime", today);
		List<VisitCommonBean> dataList = salesManagerDao.findVisitTeam(params);
		if (dataList != null) {
			for (int i = 0; i < dataList.size(); i++) {
				if (dataList.get(i).getUserId() == userId) {
					if (begin == 0) {
						result.setRank(i + 1);
						dataList.get(i).setRank(i + 1);
						dataList.get(i).setIsSelf("1");
						dataList.get(i).setUserName("我的团队");
					}
					if (begin > 0) {
						result.setRank(begin + i + 1);
						dataList.get(i).setRank(begin + i + 1);
						dataList.get(i).setIsSelf("1");
						dataList.get(i).setUserName("我的团队");
					}
				} else {
					if (begin == 0) {
						dataList.get(i).setRank(i + 1);
						dataList.get(i).setIsSelf("0");
						dataList.get(i).setUserName(
								dataList.get(i).getUserName() + "的团队");
					}
					if (begin > 0) {
						dataList.get(i).setRank(begin + i + 1);
						dataList.get(i).setIsSelf("0");
						dataList.get(i).setUserName(
								dataList.get(i).getUserName() + "的团队");
					}

				}
			}
			listResult.setDataList(dataList);
			result.setPerformances(listResult);
		}
		return result;
	}

	/**
	 * 根据销售经理编号分页查询本月本楼盘所有团队到访业绩
	 * 
	 * @param userId
	 * @param begin
	 * @param length
	 * @return
	 */
	@Override
	public VisitCommonTeamDataSet getVisitMonthTeam(int userId, int begin,
			int length) {
		VisitCommonTeamDataSet result = new VisitCommonTeamDataSet();
		ListResult listResult = new ListResult();
		Map<String, Object> visitMonth = new HashMap<String, Object>();
		visitMonth.put("userId", userId);
		Integer visitTotal = salesManagerDao.countVisitTeam(visitMonth);
		listResult.setDataCount(visitTotal);
		Timestamp beginTime = new Timestamp(TimeUtil.getCurrentMonthStartTime());
		Timestamp endTime = new Timestamp(TimeUtil.getCurrentMonthEndTime());
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("userId", userId);
		params.put("begin", begin);
		params.put("length", length);
		params.put("beginTime", beginTime);
		params.put("endTime", endTime);
		List<VisitCommonBean> dataList = salesManagerDao.findVisitTeam(params);
		if (dataList != null) {
			for (int i = 0; i < dataList.size(); i++) {
				if (dataList.get(i).getUserId() == userId) {
					if (begin == 0) {
						result.setRank(i + 1);
						dataList.get(i).setRank(i + 1);
						dataList.get(i).setIsSelf("1");
						dataList.get(i).setUserName("我的团队");
					}
					if (begin > 0) {
						result.setRank(begin + i + 1);
						dataList.get(i).setRank(begin + i + 1);
						dataList.get(i).setIsSelf("1");
						dataList.get(i).setUserName("我的团队");
					}
				} else {
					if (begin == 0) {
						dataList.get(i).setRank(i + 1);
						dataList.get(i).setIsSelf("0");
						dataList.get(i).setUserName(
								dataList.get(i).getUserName() + "的团队");
					}
					if (begin > 0) {
						dataList.get(i).setRank(begin + i + 1);
						dataList.get(i).setIsSelf("0");
						dataList.get(i).setUserName(
								dataList.get(i).getUserName() + "的团队");
					}

				}
			}
			listResult.setDataList(dataList);
			result.setPerformances(listResult);
		}
		return result;
	}

	/**
	 * 根据销售经理编号分页查询本楼盘所有团队总到访业绩
	 * 
	 * @param userId
	 * @param begin
	 * @param length
	 * @return
	 */
	@Override
	public VisitCommonTeamDataSet getVisitTotalTeam(int userId, int begin,
			int length) {
		VisitCommonTeamDataSet result = new VisitCommonTeamDataSet();
		ListResult listResult = new ListResult();
		Map<String, Object> visit = new HashMap<String, Object>();
		visit.put("userId", userId);
		Integer visitTotal = salesManagerDao.countVisitTeam(visit);
		listResult.setDataCount(visitTotal);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("userId", userId);
		params.put("begin", begin);
		params.put("length", length);
		List<VisitCommonBean> dataList = salesManagerDao.findVisitTeam(params);
		if (dataList != null) {
			for (int i = 0; i < dataList.size(); i++) {
				if (dataList.get(i).getUserId() == userId) {
					if (begin == 0) {
						result.setRank(i + 1);
						dataList.get(i).setRank(i + 1);
						dataList.get(i).setIsSelf("1");
						dataList.get(i).setUserName("我的团队");
					}
					if (begin > 0) {
						result.setRank(begin + i + 1);
						dataList.get(i).setRank(begin + i + 1);
						dataList.get(i).setIsSelf("1");
						dataList.get(i).setUserName("我的团队");
					}
				} else {
					if (begin == 0) {
						dataList.get(i).setRank(i + 1);
						dataList.get(i).setIsSelf("0");
						dataList.get(i).setUserName(
								dataList.get(i).getUserName() + "的团队");
					}
					if (begin > 0) {
						dataList.get(i).setRank(begin + i + 1);
						dataList.get(i).setIsSelf("0");
						dataList.get(i).setUserName(
								dataList.get(i).getUserName() + "的团队");
					}

				}
			}
			listResult.setDataList(dataList);
			result.setPerformances(listResult);
		}
		return result;
	}

	/**
	 * 根据置业顾问编号分页查询客户信息
	 * 
	 * @param userId
	 * @param memberName
	 * @param begin
	 * @param length
	 * @return
	 */
	@Override
	public UserCustomerDataSet getUserCustomerDataSet(int userId, int begin,
			int length) {
		UserCustomerDataSet result = new UserCustomerDataSet();
		ListResult listResult = new ListResult();
		Map<String, Object> params_Integer = new HashMap<String, Object>();
		params_Integer.put("userId", userId);
		Integer dataCount = salesManagerDao
				.countCustomerDataSet(params_Integer);
		listResult.setDataCount(dataCount);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("userId", userId);
		params.put("begin", begin);
		params.put("length", length);
		List<CustomerDataSet> dataList = salesManagerDao
				.findCustomerDataSet(params);
		// add by henan 2015/12/23 begin
		// if(dataList != null){
		if(dataList != null && dataList.size() > 0){
		// add by henan 2015/12/23 end
			result.setSalerName(dataList.get(0).getSalerName());
		}
		listResult.setDataList(dataList);
		result.setCustomers(listResult);
		return result;
	}

	/**
	 * 分页查询团队客户信息
	 * @param memberName
	 * @param begin
	 * @param length
	 * @return
	 */
	@Override
	public TeamCustomerDataSet findCustomerDataSet(String memberName, int leaderId,
			int begin, int length) {
		TeamCustomerDataSet result = new TeamCustomerDataSet();
		ListResult listResult = new ListResult();
		Map<String, Object> params_Integer = new HashMap<String, Object>();
		params_Integer.put("memberName", memberName);
		params_Integer.put("leaderId", leaderId);
		Integer dataCount = salesManagerDao
				.countCustomerDataSet(params_Integer);
		listResult.setDataCount(dataCount);
		result.setCount(dataCount);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("memberName", memberName);
		params.put("leaderId", leaderId);
		params.put("begin", begin);
		params.put("length", length);
		List<CustomerDataSet> dataList = salesManagerDao
				.findCustomerDataSet(params);
		for (CustomerDataSet customerDataSet : dataList) {
			if(customerDataSet.getPrice() == null){
				customerDataSet.setPrice(new BigDecimal(0));
			}
		}
		listResult.setDataList(dataList);
		result.setCustomers(listResult);
		return result;
	}

	/**
	 * 根据销售经理编号查询销售经理信息
	 * @param userId
	 * @return
	 */
	@Override
	public ManagerDataSet getManagerDataSet(int userId) {
		ManagerReceiveDataSet receive = salesManagerDao.getManagerDataSet(userId);
		ManagerDataSet result = new ManagerDataSet();
		result.setUserId(receive.getUserId());
		result.setName(receive.getName());
		int type = receive.getAppUserType();
		switch (type) {
		case 1:
			result.setPosition("销售经理");
			break;
		case 2:
			result.setPosition("置业顾问");
			break;
		default:
			result.setPosition("营销总监");
			break;
		}
		result.setHeadPortrait(receive.getHeadPortrait());
		result.setBuildingName(receive.getBuildingName());
		result.setSuperiorName(receive.getSuperiorName());
		return result;
	}

	/**
	 * 根据销售经理编号分页查询下属置业顾问信息
	 * @param userId
	 * @param begin
	 * @param length
	 * @return
	 */
	@Override
	public ListResult findSalerDataSet(int userId, int begin, int length) {
		ListResult result = new ListResult();
		Integer dataCount = salesManagerDao.countSalerDataSet(userId);
		result.setDataCount(dataCount);
		Map<String, Object> params_list = new HashMap<String, Object>();
		params_list.put("userId", userId);
		params_list.put("begin", begin);
		params_list.put("length", length);
		List<SalerDataSet> dataList = salesManagerDao.findSalerDataSet(params_list);
		result.setDataList(dataList);
		return result;
	}

}
