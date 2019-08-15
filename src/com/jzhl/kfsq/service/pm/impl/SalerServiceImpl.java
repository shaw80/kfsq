package com.jzhl.kfsq.service.pm.impl;

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
import com.jzhl.kfsq.common.util.ValidateUtil;
import com.jzhl.kfsq.dao.fm.IEnvelopeReceiveMapper;
import com.jzhl.kfsq.dao.mm.IMemberMapper;
import com.jzhl.kfsq.dao.pm.ISalerCustomerMapper;
import com.jzhl.kfsq.dao.pm.ISalerMapper;
import com.jzhl.kfsq.dao.sm.IEnvelopeRuleMapper;
import com.jzhl.kfsq.dataset.fm.Amount;
import com.jzhl.kfsq.dataset.pm.SalerCustomerDataSet;
import com.jzhl.kfsq.dataset.pm.VisitCommonBean;
import com.jzhl.kfsq.dataset.pm.VisitCommonDataSet;
import com.jzhl.kfsq.dataset.pm.VisitDataSet;
import com.jzhl.kfsq.dataset.pm.VisitMonthDataSet;
import com.jzhl.kfsq.dto.fm.SalerMemberDto;
import com.jzhl.kfsq.dto.pm.FavoriteDBDto;
import com.jzhl.kfsq.dto.pm.SalerCustomerDto;
import com.jzhl.kfsq.dto.pm.VisitQueryDto;
import com.jzhl.kfsq.entity.mm.Member;
import com.jzhl.kfsq.entity.pm.SalerCustomer;
import com.jzhl.kfsq.service.pm.ISalerService;

@Service
public class SalerServiceImpl implements ISalerService {

	@Autowired
	private ISalerMapper salerDao;
	@Autowired
	private ISalerCustomerMapper salerCustomerDao;
	@Autowired
	private IMemberMapper memberDao;
	@Autowired
	private IEnvelopeReceiveMapper envelopeReceiveDao;
	@Autowired
	private IEnvelopeRuleMapper envelopeRuleDao;
	
	@Override
	public java.lang.Integer getVisitCount(VisitQueryDto visitQueryDto) {
		return salerDao.getVisitCount(visitQueryDto);
	}

	@Override
	public List<VisitDataSet> getDayVisitCountList(VisitQueryDto visitQueryDto) {
		return salerDao.getDayVisitCountList(visitQueryDto);
	}

	/**
	 * 置业顾问分页查询到访客户
	 */
	@Override
	public ListResult findSalerCustomerDataSet(SalerCustomerDto salerCustomerDto) {
		ListResult result = new ListResult();
		try {
			List<SalerCustomerDataSet> dataList = new ArrayList<SalerCustomerDataSet>();
			int dataCount = 0;
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("userId", salerCustomerDto.getUserId());
			params.put("isFavorite", salerCustomerDto.getIsFavorites());
			params.put("rowStart", salerCustomerDto.getRowStart());
			params.put("offset", salerCustomerDto.getOffset());
			List<SalerCustomer> salerCustomers = salerCustomerDao.findSalerCustomerByUserId(params);// 根据userId分页查询客户到访记录
			SimpleDateFormat sdf = new SimpleDateFormat("MM-dd HH:mm");
			if(ValidateUtil.isNotEmpty(salerCustomerDto.getMemberName())){// 有模糊查询
				for (SalerCustomer sc : salerCustomers) {
					Map<String, Object> param = new HashMap<String, Object>();
					param.put("nickName", salerCustomerDto.getMemberName());
					List<Member> members = memberDao.findMemberByName(param);
					for (Member member : members) {
						if(member.getMemberId() == sc.getMemberId()){
							SalerCustomerDataSet data = new SalerCustomerDataSet();
							data.setSalerCustomerId(String.valueOf(sc.getSalerCustomerId()));
							data.setIsFavorite(String.valueOf(sc.getIsFavorite()));
							data.setClientTime(sdf.format(sc.getUpdateTime()));
							data.setClientHeadPortrait(member.getHeadPortrait());
							data.setClientName(member.getNickName());
							data.setClientPhone(member.getPhone());
							SalerMemberDto dto = new SalerMemberDto();
							dto.setUserId(salerCustomerDto.getUserId());
							dto.setMemberId(sc.getMemberId());
							Amount amount = envelopeReceiveDao.getEnvelopeBySalerAndMember(dto);
							data.setEnvelope(String.valueOf(amount.getPrice()));
							dataList.add(data);
						}
					}
				}
				dataCount = dataList.size();
			}else{// 无模糊查询
				for (SalerCustomer sc : salerCustomers) {
					SalerCustomerDataSet data = new SalerCustomerDataSet();
					data.setSalerCustomerId(String.valueOf(sc.getSalerCustomerId()));
					data.setIsFavorite(String.valueOf(sc.getIsFavorite()));
					data.setClientTime(sdf.format(sc.getUpdateTime()));
					Member param_member = new Member();
					param_member.setMemberId(sc.getMemberId());
					param_member.setIsValidParam(new Short("1"));
					Member member = memberDao.getMember(param_member);// 根据memberId查询会员信息
					if(member != null){
						data.setClientHeadPortrait(member.getHeadPortrait());
						data.setClientName(member.getNickName());
						data.setClientPhone(member.getPhone());
						Map<String, Object> params_receive = new HashMap<String, Object>();
						params_receive.put("memberId", member.getMemberId());
						params_receive.put("buildingId", sc.getBuildingId());
						SalerMemberDto dto = new SalerMemberDto();
						dto.setUserId(salerCustomerDto.getUserId());
						dto.setMemberId(sc.getMemberId());
						Amount amount = envelopeReceiveDao.getEnvelopeBySalerAndMember(dto);
						data.setEnvelope(String.valueOf(amount.getPrice()));
						dataList.add(data);
					}
				}
				Map<String, Object> param_count = new HashMap<String, Object>();
				param_count.put("userId", salerCustomerDto.getUserId());
				param_count.put("isFavorite", salerCustomerDto.getIsFavorites());
				dataCount = dataList.size();
			}
			result.setDataList(dataList);
			result.setDataCount(dataCount);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public void updateFavorite(FavoriteDBDto dto) {
		salerCustomerDao.updateFavorite(dto);
	}

	@Override
	public List<VisitMonthDataSet> getMonthVisitCountList(VisitQueryDto visitQueryDto) {
		return salerDao.getMonthVisitCountList(visitQueryDto);
	}

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
		Integer visitTotal = salerDao.getVisit(visitToday);// 统计今日到访量
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("userId", userId);
		params.put("begin", begin);
		params.put("length", length);
		params.put("beginTime", today);
		params.put("endTime", today);
		List<VisitCommonBean> dataList = (List<VisitCommonBean>) salerDao
				.findVisitPerson(params);// 查询到访业绩数据
		if (dataList != null) {
			for (int i = 0; i < dataList.size(); i++) {
				if (begin == 0) {
					dataList.get(i).setRank(i + 1);
				}
				if (begin > 0) {
					dataList.get(i).setRank(begin + i + 1);
				}
				
				if(dataList.get(i).getUserId() == userId) {
					dataList.get(i).setIsSelf("1");
				} else {
					dataList.get(i).setIsSelf("0");
				}
			}
		}
		Integer dataCount = salerDao.countVisitPerson(visitToday);// 统计到访业绩数据量
		listResult.setDataCount(dataCount);
		listResult.setDataList(dataList);
		result.setTotalVisit(visitTotal);
		result.setPerformances(listResult);
		return result;
	}

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
		Integer visitTotal = salerDao.getVisit(visitToday);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("userId", userId);
		params.put("begin", begin);
		params.put("length", length);
		params.put("beginTime", beginTime);
		params.put("endTime", endTime);
		List<VisitCommonBean> dataList = (List<VisitCommonBean>) salerDao
				.findVisitPerson(params);
		if (dataList != null) {
			for (int i = 0; i < dataList.size(); i++) {
				if (begin == 0) {
					dataList.get(i).setRank(i + 1);
				}
				if (begin > 0) {
					dataList.get(i).setRank(begin + i + 1);
				}
				
				if(dataList.get(i).getUserId() == userId) {
					dataList.get(i).setIsSelf("1");
				} else {
					dataList.get(i).setIsSelf("0");
				}
			}
		}
		Integer dataCount = salerDao.countVisitPerson(visitToday);
		listResult.setDataCount(dataCount);
		listResult.setDataList(dataList);
		result.setTotalVisit(visitTotal);
		result.setPerformances(listResult);
		return result;
	}

	@Override
	public VisitCommonDataSet getVisitTotalPerson(int userId, int begin,
			int length) {
		VisitCommonDataSet result = new VisitCommonDataSet();
		ListResult listResult = new ListResult();
		Map<String, Object> visitToday = new HashMap<String, Object>();
		visitToday.put("userId", userId);
		Integer visitTotal = salerDao.getVisit(visitToday);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("userId", userId);
		params.put("begin", begin);
		params.put("length", length);
		List<VisitCommonBean> dataList = (List<VisitCommonBean>) salerDao
				.findVisitPerson(params);
		if (dataList != null) {
			for (int i = 0; i < dataList.size(); i++) {
				if (begin == 0) {
					dataList.get(i).setRank(i + 1);
				}
				if (begin > 0) {
					dataList.get(i).setRank(begin + i + 1);
				}
				
				if(dataList.get(i).getUserId() == userId) {
					dataList.get(i).setIsSelf("1");
				} else {
					dataList.get(i).setIsSelf("0");
				}
			}
		}
		Integer dataCount = salerDao.countVisitPerson(visitToday);
		listResult.setDataCount(dataCount);
		listResult.setDataList(dataList);
		result.setTotalVisit(visitTotal);
		result.setPerformances(listResult);
		return result;
	}
	
	@Override
	public SalerCustomer addSalerCustomer(SalerCustomer salerCustomer) {
		salerCustomerDao.insertSalerCustomer(salerCustomer);
		return salerCustomer;
	}
	
	@Override
	public SalerCustomer getCustomerLastTime(SalerCustomer salerCustomer) {
		return salerCustomerDao.getCustomerLastTime(salerCustomer);
	}

	@Override
	public void modifySalerCustomer(SalerCustomer salerCustomer) {
		salerCustomerDao.updateSalerCustomer(salerCustomer);
	}
	
	@Override
	public SalerCustomer getSalerCustomer(int salerCustomerId){
		SalerCustomer sc = salerCustomerDao.getSalerCustomer(salerCustomerId);
		return sc;
	}
	
}
