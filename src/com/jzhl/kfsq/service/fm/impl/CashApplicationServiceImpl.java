package com.jzhl.kfsq.service.fm.impl;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jzhl.kfsq.common.base.ListResult;
import com.jzhl.kfsq.common.util.IDGenerator;
import com.jzhl.kfsq.common.util.MyMath;
import com.jzhl.kfsq.dao.fm.ICashApplicationMapper;
import com.jzhl.kfsq.dao.fm.IEnvelopeCashMapper;
import com.jzhl.kfsq.dao.fm.IEnvelopeReceiveMapper;
import com.jzhl.kfsq.dao.mm.IMemberMapper;
import com.jzhl.kfsq.dao.sm.IAccountMapper;
import com.jzhl.kfsq.dataset.fm.CashDataSet;
import com.jzhl.kfsq.dataset.fm.CashDealDataSet;
import com.jzhl.kfsq.dataset.fm.CashDealReceiveDataSet;
import com.jzhl.kfsq.dataset.fm.CashDetailDataSet;
import com.jzhl.kfsq.dataset.fm.CashDetailReceiveDataSet;
import com.jzhl.kfsq.dataset.fm.CashReceiveDataSet;
import com.jzhl.kfsq.dto.fm.CashAgentDto;
import com.jzhl.kfsq.dto.fm.CashApplicationInsertDto;
import com.jzhl.kfsq.dto.fm.CashParamDto;
import com.jzhl.kfsq.entity.fm.CashApplication;
import com.jzhl.kfsq.entity.fm.EnvelopeCash;
import com.jzhl.kfsq.entity.fm.EnvelopeReceive;
import com.jzhl.kfsq.entity.mm.Member;
import com.jzhl.kfsq.entity.sm.Account;
import com.jzhl.kfsq.service.fm.ICashApplicationService;


/**
 * 提现申请业务层实现类
 * 
 * @author Shaw
 *
 */
@Service
public class CashApplicationServiceImpl implements ICashApplicationService {

	@Autowired
	private ICashApplicationMapper cashApplicationDao;

	@Autowired
	private IAccountMapper accountDao;

	@Autowired
	private IMemberMapper memberDao;
	
	@Autowired
	private IEnvelopeReceiveMapper envelopeReceiveDao;
	
	@Autowired
	private IEnvelopeCashMapper envelopeCashDao;

	/**
	 * 添加提现申请
	 * 
	 * @param ca
	 */
	@Override
	public void insertCashApplication(CashApplicationInsertDto dto)
			throws Exception {

		CashApplication ca = new CashApplication();

		Map<String, Object> map = new HashMap<String, Object>();

		map.put("userId", dto.getMemberId());

		map.put("userType", "1");

		Account account = accountDao.getAccountByUserId(map);// 根据用户编号获取账户信息 

		if (account != null) {// 数据库中已存在用户的账户信息

			if (dto.getAccount() != null) {// 如果用户填写了账户信息

				account.setAccountNum(dto.getAccount());

				account.setAccountType(dto.getAccountType());

				account.setIsDefault(new Short(dto.getIsDefault()));
				
				if(dto.getAccountName() != null){
					account.setAccountName(dto.getAccountName());
				}

				accountDao.updateAccount(account);

				Member param = new Member();

				param.setMemberId(dto.getMemberId());

				Member member = memberDao.getMember(param);// 根据用户编号获取用户信息

				ca.setApplicationId(IDGenerator.generateID());

				ca.setReceiveAccountId(account.getAccountId());

				ca.setPrice(new BigDecimal(dto.getPrice()));

				ca.setStatus(0);

				ca.setApplicationPersonId(dto.getMemberId());

				ca.setApplicationPersonName(member.getNickName());

			} else {// 用户未添加账户信息

				Member param = new Member();

				param.setMemberId(dto.getMemberId());

				Member member = memberDao.getMember(param);// 根据用户编号获取用户信息

				ca.setApplicationId(IDGenerator.generateID());

				ca.setReceiveAccountId(account.getAccountId());

				ca.setPrice(new BigDecimal(dto.getPrice()));

				ca.setStatus(0);

				ca.setApplicationPersonId(dto.getMemberId());

				ca.setApplicationPersonName(member.getNickName());

			}

		} else {// 数据库中不存在用户的账户信息

			if (dto.getAccount() != null) {// 如果用户填写了账户信息

				Account account_new = new Account();

				account_new.setAccountNum(dto.getAccount());
				
				account_new.setAccountName(dto.getAccountName());

				account_new.setAccountType(dto.getAccountType());

				account_new.setIsDefault(new Short(dto.getIsDefault()));
				
				account_new.setUserType("1");
				
				account_new.setUserId(dto.getMemberId());
				
				account_new.setCreatorUserId(dto.getMemberId());
				
				account_new.setCreateTime(new Timestamp(System.currentTimeMillis()));

				accountDao.insertAccount(account_new);

				Member param = new Member();

				param.setMemberId(dto.getMemberId());

				Member member = memberDao.getMember(param);// 根据用户编号获取用户信息

				ca.setApplicationId(IDGenerator.generateID());

				ca.setReceiveAccountId(account_new.getAccountId());

				ca.setPrice(new BigDecimal(dto.getPrice()));

				ca.setStatus(0);

				ca.setApplicationPersonId(dto.getMemberId());

				ca.setApplicationPersonName(member.getNickName());

			} else {// 如果用户未填写账户信息

				throw new Exception("请设置提现账户信息");

			}

		}
		
		int overdraw = new BigDecimal(dto.getPrice()).compareTo(getSum(dto));
		
		if(overdraw <= 0){// 如果提现金额小于等于红包领取表的金额总和，即未透支
			
			cashApplicationDao.insertCashApplication(ca);
			
			BigDecimal cashPrice = new BigDecimal(dto.getPrice());
			
			BigDecimal toReceive = new BigDecimal(dto.getPrice());
			
			List<EnvelopeReceive> envelopeReceives = envelopeReceiveDao.findEnvelopeReceiveByMemberIdAndStatus(dto.getMemberId());
			
			for (EnvelopeReceive envelopeReceive : envelopeReceives) {// 遍历领取表结果集
				
				if(envelopeReceive.getStatus() == 1){// status = 1
					
					int comp1 = cashPrice.compareTo(envelopeReceive.getPrice());// 提现金额与红包领取表prive比较
					
					if(comp1 > 0){
						
						int comp2 = toReceive.compareTo(envelopeReceive.getPrice());
						
						if(comp2 > 0){
							
							EnvelopeCash ec = new EnvelopeCash();
							
							ec.setReceiveId(envelopeReceive.getReceiveId());
							
							ec.setApplicationId(ca.getApplicationId());
							
							ec.setPrice(envelopeReceive.getPrice());
							
							envelopeCashDao.insertEnvelopeCash(ec);// 添加中间表
							
							envelopeReceive.setStatus(3);// status = 3
							
							envelopeReceiveDao.updateEnvelopeReceive(envelopeReceive);
							
							toReceive = new BigDecimal(MyMath.sub(toReceive.doubleValue(), envelopeReceive.getPrice().doubleValue()));// toReceive = toReceive - envelopeReceive.getPrice()
							
						}else if(comp2 == 0){
							
							EnvelopeCash ec = new EnvelopeCash();
							
							ec.setReceiveId(envelopeReceive.getReceiveId());
							
							ec.setApplicationId(ca.getApplicationId());
							
							ec.setPrice(toReceive);
							
							envelopeCashDao.insertEnvelopeCash(ec);// 添加中间表
							
							envelopeReceive.setStatus(3);// status = 3
							
							envelopeReceiveDao.updateEnvelopeReceive(envelopeReceive);
							
							break;
							
						}else{
							
							EnvelopeCash ec = new EnvelopeCash();
							
							ec.setReceiveId(envelopeReceive.getReceiveId());
							
							ec.setApplicationId(ca.getApplicationId());
							
							ec.setPrice(toReceive);
							
							envelopeCashDao.insertEnvelopeCash(ec);// 添加中间表
							
							envelopeReceive.setStatus(2);// status = 2
							
							envelopeReceiveDao.updateEnvelopeReceive(envelopeReceive);
							
							break;
							
						}
						
					}else if(comp1 == 0){
						
						EnvelopeCash ec = new EnvelopeCash();
						
						ec.setReceiveId(envelopeReceive.getReceiveId());
						
						ec.setApplicationId(ca.getApplicationId());
						
						ec.setPrice(envelopeReceive.getPrice());
						
						envelopeCashDao.insertEnvelopeCash(ec);// 添加中间表
						
						envelopeReceive.setStatus(3);// status = 3
						
						envelopeReceiveDao.updateEnvelopeReceive(envelopeReceive);
						
						break;
						
					}else{
						
						EnvelopeCash ec = new EnvelopeCash();
						
						ec.setReceiveId(envelopeReceive.getReceiveId());
						
						ec.setApplicationId(ca.getApplicationId());
						
						ec.setPrice(new BigDecimal(dto.getPrice()));
						
						envelopeCashDao.insertEnvelopeCash(ec);// 添加中间表
						
						envelopeReceive.setStatus(2);// status = 2
						
						envelopeReceiveDao.updateEnvelopeReceive(envelopeReceive);
						
						break;
						
					}
					
				}else{// status = 2
					
					List<EnvelopeCash> envelopeCashs = envelopeCashDao.findEnvelopeCashByReceiveId(envelopeReceive.getReceiveId());
					
					for (EnvelopeCash envelopeCash : envelopeCashs) {
						
						BigDecimal margin = new BigDecimal(MyMath.sub(envelopeReceive.getPrice().doubleValue(), envelopeCash.getPrice().doubleValue()));
						
						int comp3 = toReceive.compareTo(margin);
						
						if(comp3 > 0){
							
							EnvelopeCash ec = new EnvelopeCash();
							
							ec.setReceiveId(envelopeReceive.getReceiveId());
							
							ec.setApplicationId(ca.getApplicationId());
							
							ec.setPrice(margin);
							
							envelopeCashDao.insertEnvelopeCash(ec);// 添加中间表
							
							envelopeReceive.setStatus(3);// status = 3
							
							envelopeReceiveDao.updateEnvelopeReceive(envelopeReceive);
							
							toReceive = new BigDecimal(MyMath.sub(toReceive.doubleValue(), margin.doubleValue()));// toReceive = toReceive - margin
							
						}else if(comp3 == 0){
							
							EnvelopeCash ec = new EnvelopeCash();
							
							ec.setReceiveId(envelopeReceive.getReceiveId());
							
							ec.setApplicationId(ca.getApplicationId());
							
							ec.setPrice(margin);
							
							envelopeCashDao.insertEnvelopeCash(ec);// 添加中间表
							
							envelopeReceive.setStatus(3);// status = 3
							
							envelopeReceiveDao.updateEnvelopeReceive(envelopeReceive);
							
							break;
							
						}else{
							
							EnvelopeCash ec = new EnvelopeCash();
							
							ec.setReceiveId(envelopeReceive.getReceiveId());
							
							ec.setApplicationId(ca.getApplicationId());
							
							ec.setPrice(margin);
							
							envelopeCashDao.insertEnvelopeCash(ec);// 添加中间表
							
							break;
							
						}
						
					}
					
				}
				
			}
			
		}else{// 如果已透支
			
			throw new RuntimeException("超出可提现金额");
			
		}

	}
	
	/**
	 * 计算红包领取表，金额总和
	 * @param dto
	 * @return
	 */
	private BigDecimal getSum(CashApplicationInsertDto dto){
		List<EnvelopeReceive> envelopeReceives = envelopeReceiveDao.findEnvelopeReceiveByMemberIdAndStatus(dto.getMemberId());
		BigDecimal sum = new BigDecimal("0.00");
		for (EnvelopeReceive envelopeReceive : envelopeReceives) {
			sum = new BigDecimal(MyMath.add(sum.doubleValue(), envelopeReceive.getPrice().doubleValue()));
		}
		return sum;
	}

	/**
	 * 删除提现申请
	 * 
	 * @param applicationId
	 */
	@Override
	public void deleteCashApplication(String applicationId) {
		cashApplicationDao.deleteCashApplication(applicationId);
	}

	/**
	 * 重新提交提现申请
	 * 
	 * @param ca
	 */
	@Override
	public void updateCashApplication(CashApplication ca) {
		ca.setStatus(0);
		cashApplicationDao.updateCashApplication(ca);
	}
	
	/**
	 * 支付宝回调函数更新提现申请
	 * 
	 * @param ca
	 */
	public void callBackUpdateCash(CashApplication ca){
		cashApplicationDao.updateCashApplication(ca);
	}
	
	/**
	 * 批量支付更新提现申请
	 * @param ca
	 */
	public void batchPayUpdateCash(CashApplication ca){
		String[] cashs = ca.getApplicationId().split(",");
		List<CashApplication> list = new ArrayList<CashApplication>();
		for (String applicationId : cashs) {
			CashApplication cashApplication = new CashApplication();
			cashApplication.setApplicationId(applicationId);
			cashApplication.setStatus(ca.getStatus());
			cashApplication.setAuditingPersonId(ca.getAuditingPersonId());
			cashApplication.setBatchNum(ca.getBatchNum());
			cashApplication.setPayPersonId(ca.getPayPersonId());
			list.add(cashApplication);
		}
		cashApplicationDao.updateBatchCash(list);
	}

	/**
	 * 根据申请编号查询提现详情
	 * 
	 * @param applicationId
	 * @return 提现详情
	 */
	@Override
	public CashDetailDataSet getCashDetailDataSet(String applicationId) {

		CashDetailDataSet cd = new CashDetailDataSet();

		CashDetailReceiveDataSet cdrds = cashApplicationDao
				.getCashDetailReceiveDataSet(applicationId);

		cd.setApplicationId(cdrds.getApplicationId());

		cd.setPrice("-" + cdrds.getPrice());

		SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");

		cd.setApplicationTime(sdf.format(cdrds.getApplicationTime()));
		
		cd.setDBStatus(Integer.toString(cdrds.getStatus()));

		Integer status = cdrds.getStatus();

		switch (status) {

		case 1:

			cd.setCashStatus("处理中");

			break;

		case 2:

			cd.setCashStatus("提现成功");

			break;

		case 3:

			cd.setCashStatus("提现失败");

			break;

		default:

			cd.setCashStatus("待处理");

			break;
		}

		String cashType = cdrds.getCashType();

		if (cashType.equals("0")) {

			cd.setCashType("支付宝提现");

		} else {

			cd.setCashType("银行卡提现");

		}

		return cd;
	}

	/**
	 * 根据会员编号分页查询提现申请
	 * 
	 * @param param
	 * @return
	 */
	@SuppressWarnings("deprecation")
	@Override
	public ListResult findCashAppliByMemberIdByPage(int memberId, int begin,
			int length) {

		Map<String, Object> map = new HashMap<String, Object>();

		map.put("applicationPersonId", memberId);

		map.put("begin", begin);

		map.put("length", length);

		List<CashDealReceiveDataSet> applis = new ArrayList<>();

		Integer count = 0;

		applis = cashApplicationDao.findCashByAppliPersonIdByPage(map);

		List<CashDealDataSet> list_dataset = new ArrayList<CashDealDataSet>();

		for (int i = 0; i < applis.size(); i++) {

			CashDealDataSet cdds = new CashDealDataSet();

			cdds.setApplicationId(applis.get(i).getApplicationId());

			cdds.setPrice(applis.get(i).getPrice());

			int appli_date = applis.get(i).getApplicationTime().getDate();// 获取支付日期

			int appli_day = applis.get(i).getApplicationTime().getDay(); // 获取申请时间是周几（周日是0，周一是1，以此类推）

			String appliTime = "";

			switch (appli_day) {

			case 1:

				appliTime = String.valueOf(appli_date) + "日-" + "星期一";

				break;

			case 2:

				appliTime = String.valueOf(appli_date) + "日-" + "星期二";

				break;

			case 3:

				appliTime = String.valueOf(appli_date) + "日-" + "星期三";

				break;

			case 4:

				appliTime = String.valueOf(appli_date) + "日-" + "星期四";

				break;

			case 5:

				appliTime = String.valueOf(appli_date) + "日-" + "星期五";

				break;

			case 6:

				appliTime = String.valueOf(appli_date) + "日-" + "星期六";

				break;

			default:

				appliTime = String.valueOf(appli_date) + "日-" + "星期日";

				break;
			}

			cdds.setServiceTime(appliTime);

			String cashMode = applis.get(i).getCashMode();

			if (cashMode.equals("0")) {

				cdds.setType("支付宝");

			} else {

				cdds.setType("银行卡");

			}

			int status = applis.get(i).getStatus();

			String msg = "";

			switch (status) {

			case 0:

				msg = "待处理";

				break;

			case 1:

				msg = "处理中";

				break;

			case 2:

				msg = "提现成功";

				break;

			default:

				msg = "处理失败";

				break;
			}

			cdds.setServiceStatus(msg);

			list_dataset.add(cdds);

		}

		count = cashApplicationDao.countCashByAppliPersonId(memberId);

		ListResult result = new ListResult();

		result.setDataCount(count);

		result.setDataList(list_dataset);

		return result;
	}

	/**
	 * 代理商后台-财务管理-红包消耗
	 * 
	 * @author zhouzy
	 */
	@Override
	public List<CashApplication> findCashApplicationList(Map<String, Object> map) {
		List<CashApplication> result = cashApplicationDao
				.findCashApplicationList(map);
		return result;
	}

	/**
	 * 代理商后台-财务管理-红包消耗总页数
	 * 
	 * @author zhouzy
	 */
	@Override
	public int findCashApplicationDataCount(Map<String, Object> map) {
		int dataCount = cashApplicationDao.findCashApplicationDataCount(map);
		return dataCount;
	}

	/**
	 * 代理商后台-财务管理-评论消耗
	 * 
	 * @author zhouzy
	 */
	@Override
	public List<CashApplication> findBuildingCommentCashApplicationList(
			Map<String, Object> map) {
		List<CashApplication> result = cashApplicationDao
				.findBuildingCommentCashApplicationList(map);
		return result;
	}

	/**
	 * 代理商后台-财务管理-评论消耗总数
	 * 
	 * @author zhouzy
	 */
	@Override
	public int findBuildingCommentCashApplicationDataCount(
			Map<String, Object> map) {
		int dataCount = cashApplicationDao
				.findBuildingCommentCashApplicationDataCount(map);
		return dataCount;
	}

	/**
	 * 根据代理商编号分页查询提现申请记录
	 * 
	 * @param map
	 * @return
	 */
	@Override
	public ListResult findCashDateSet(CashAgentDto dto) {
		ListResult result = new ListResult();
		List<CashReceiveDataSet> receives = new ArrayList<CashReceiveDataSet>();
		CashParamDto param = new CashParamDto();
		param.setUserId(dto.getUserId());
		param.setStatus(dto.getStatus());
		
		// addby zhouzy 判断是否为excel下载
		param.setIsDownFlag(dto.getIsDownFlag());
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		
		if(dto.getBeginTime() != null){
			try {
				param.setBeginTime(new Timestamp(format.parse(dto.getBeginTime()).getTime()));
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		if(dto.getEndTime() != null){
			try {
				param.setEndTime(new Timestamp(format.parse(dto.getEndTime()).getTime()));
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		param.setRowStart(dto.getRowStart());
		param.setOffset(dto.getOffset());
		try {
			Integer dataCount = cashApplicationDao.countCashDataSet(param);
			result.setDataCount(dataCount);
			receives = cashApplicationDao.findCashDateSet(param);
		} catch (Exception e) {
			e.printStackTrace();
		}
		List<CashDataSet> dataList = new ArrayList<CashDataSet>(); 
		for (CashReceiveDataSet receive : receives) {
			CashDataSet data = new CashDataSet();
			data.setApplicationId(receive.getApplicationId());
			data.setNickName(receive.getNickName());
			data.setApplicationTime(receive.getApplicationTime());
			data.setPrice(receive.getPrice());
			data.setAccount(receive.getAccount());
			data.setBalance(receive.getBalance());
			if(receive.getAccountType().equals("0")){
				data.setAccountType("支付宝");
			}
			switch (receive.getStatus()) {
			case 1:
				data.setStatus("处理中");
				data.setStatusCode("1");
				break;
			case 2:
				data.setStatus("处理成功");
				data.setStatusCode("2");
				break;
			case 3:
				data.setStatus("处理失败");
				data.setStatusCode("3");
				break;
			default:
				data.setStatus("待处理");
				data.setStatusCode("0");
				break;
			}
			dataList.add(data);
		}
		result.setDataList(dataList);
		return result;
	}

	/**
	 * 根据申请编号查询待处理的申请
	 * @param appliIds
	 * @return
	 */
	@Override
	public List<CashApplication> findCashByCashIdAndStatus(String[] appliIds) {
		List<CashApplication> result = cashApplicationDao.findCashByCashIdAndStatus(appliIds);
		return result;
	}
	
}
