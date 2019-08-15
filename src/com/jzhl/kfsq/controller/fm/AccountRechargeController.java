package com.jzhl.kfsq.controller.fm;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jzhl.kfsq.common.base.ListResult;
import com.jzhl.kfsq.common.base.ResponseBean;
import com.jzhl.kfsq.dao.fm.IEnvelopeRechargeMapper;
import com.jzhl.kfsq.dto.fm.AccountRechargeDto;
import com.jzhl.kfsq.entity.fm.AccountRecharge;
import com.jzhl.kfsq.entity.fm.EnvelopeRecharge;
import com.jzhl.kfsq.service.fm.IAccountRechargeService;

/**
 * 账户充值表
 * 
 * @author zhouzy
 *
 */
@Controller
public class AccountRechargeController {

	@Autowired
	private IAccountRechargeService accountRechargeService;

	@Autowired
	private IEnvelopeRechargeMapper envelopeRechargeDao;

	/**
	 * 代理商充值记录
	 * 
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "/serv/accountrecharge/accountrechargelist", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean findAccountRechargeList(AccountRechargeDto accountRechargeDto) throws Exception {

		// 日期
		String dateFlag = accountRechargeDto.getDateFlag();
		String dateFlag7d = null;
		String dateFlag1m = null;
		String dateFlag3m = null;
		if (dateFlag != null && dateFlag.equals("1")) {
			dateFlag7d = "1";
		} else if (dateFlag != null && dateFlag.equals("2")) {
			dateFlag1m = "2";
		} else if (dateFlag != null && dateFlag.equals("3")) {
			dateFlag3m = "3";
		}
		
		// 分页查询参数
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("rowstart", accountRechargeDto.getRowStart());
		map.put("offset", accountRechargeDto.getOffset());
		// 条件查询参数
		map.put("keyword", accountRechargeDto.getKeyword());
		map.put("dateFlag7d", dateFlag7d);
		map.put("dateFlag1m", dateFlag1m);
		map.put("dateFlag3m", dateFlag3m);
		map.put("dateStart", accountRechargeDto.getDateStart());
		map.put("dateEnd", accountRechargeDto.getDateEnd());
		map.put("isDownFlag", accountRechargeDto.getIsDownFlag());

		List<AccountRecharge> accountRecharge = accountRechargeService.findAccountRechargeList(map);

		// 分页返回
		ListResult listResult = new ListResult();
		listResult.setDataList(accountRecharge);

		// 总页数
		int dataCount = accountRechargeService.getAccountRechargeDataCount(map);
		listResult.setDataCount(dataCount);

		ResponseBean<ListResult> result = new ResponseBean<ListResult>(listResult);
		result.operateSuccess();
		return result;
	}

	/**
	 * 代理商立刻充值
	 * 
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "/serv/accountrecharge/insertaccountrecharge", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean insertAccountRecharge(AccountRechargeDto accountRechargeDto) throws Exception {

		AccountRecharge accountRecharge = new AccountRecharge();
		BeanUtils.copyProperties(accountRechargeDto, accountRecharge);

		// 总后台管理端充值默认参数
		accountRecharge.setRechargeWay("1");// '充值方式（0：线上，1：线下）'
		accountRecharge.setRechargeType("0");// 充值类型（0：代理商充值，1：楼盘充值）
		// 用户充值表中插入数据
		accountRechargeService.insertAccountRecharge(accountRecharge);

		// 红包表中也要插入数据
		EnvelopeRecharge envelopeRecharge = new EnvelopeRecharge();
		envelopeRecharge.setInvestor("1"); // '红包来源类型（0：平台出资，1：代理商出资，2：楼盘出资）',
		envelopeRecharge.setBranchId(accountRechargeDto.getPayAccountId()); // 代理商ID
		envelopeRecharge.setType((short) 1); // '红包类型（0：看房红包，1：评论红包）'
		envelopeRecharge.setTotalSum(accountRecharge.getPrice());
		envelopeRecharge.setCreatorUserId(accountRecharge.getCreatorUserId());
		envelopeRecharge.setIsValid((short) 1);
		envelopeRechargeDao.insertEnvelopeRecharge(envelopeRecharge);

		ResponseBean result = new ResponseBean();
		result.operateSuccess();
		return result;
	}

	/**
	 * 楼盘立刻充值
	 * 
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "/serv/accountrecharge/insertaccountrechargebybuilding", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean insertAccountRechargeByBuilding(AccountRechargeDto accountRechargeDto) throws Exception {

		AccountRecharge accountRecharge = new AccountRecharge();
		BeanUtils.copyProperties(accountRechargeDto, accountRecharge);

		// 代理商管理端楼盘充值默认参数
		accountRecharge.setRechargeWay("1"); // '充值方式（0：线上，1：线下）'
		accountRecharge.setRechargeType("1"); // 充值类型（0：代理商充值，1：楼盘充值）
		// 用户充值表中插入数据
		accountRechargeService.insertAccountRecharge(accountRecharge);

		// 红包表中也要插入数据
		EnvelopeRecharge envelopeRecharge = new EnvelopeRecharge();
		envelopeRecharge.setInvestor("2"); // '红包来源类型（0：平台出资，1：代理商出资，2：楼盘出资）
		envelopeRecharge.setBranchId(accountRechargeDto.getReceiveAccountId()); // 代理商ID
		envelopeRecharge.setBuildingId(accountRechargeDto.getPayAccountId()); // 楼盘编号
		envelopeRecharge.setType((short) 0); // '红包类型（0：看房红包，1：评论红包）'
		envelopeRecharge.setTotalSum(accountRecharge.getPrice());
		envelopeRecharge.setCreatorUserId(accountRecharge.getCreatorUserId());
		envelopeRecharge.setIsValid((short) 1);
		envelopeRechargeDao.insertEnvelopeRecharge(envelopeRecharge);

		ResponseBean result = new ResponseBean();
		result.operateSuccess();
		return result;
	}

	/**
	 * 楼盘充值记录
	 * 
	 * @author zhouzy
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "/serv/accountrecharge/accountrechargebybuildinglist", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean findAccountRechargeByBuildingList(AccountRechargeDto accountRechargeDto) throws Exception {

		// 分页查询参数
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("rowstart", accountRechargeDto.getRowStart());
		map.put("offset", accountRechargeDto.getOffset());

		// 条件查询参数
		map.put("userId", accountRechargeDto.getUserId()); // 代理商登录ID;或销售总监登录ID
		map.put("appUserType", accountRechargeDto.getAppUserType()); // 区分登录人角色
		map.put("keyword", accountRechargeDto.getKeyword());

		List<EnvelopeRecharge> accountRecharge = accountRechargeService.findAccountRechargeByBuildingList(map);

		// 分页返回
		ListResult listResult = new ListResult();
		listResult.setDataList(accountRecharge);

		// 总页数
		int dataCount = accountRechargeService.getAccountRechargeByBuildingDataCount(map);
		listResult.setDataCount(dataCount);

		ResponseBean<ListResult> result = new ResponseBean<ListResult>(listResult);
		result.operateSuccess();
		return result;
	}

}
