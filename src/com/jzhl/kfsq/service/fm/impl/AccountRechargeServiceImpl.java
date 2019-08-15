package com.jzhl.kfsq.service.fm.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jzhl.kfsq.dao.fm.IAccountRechargeMapper;
import com.jzhl.kfsq.entity.fm.AccountRecharge;
import com.jzhl.kfsq.entity.fm.EnvelopeRecharge;
import com.jzhl.kfsq.service.fm.IAccountRechargeService;

/**
 * 充值记录
 * 
 * @author zhouzy
 *
 */
@Service
public class AccountRechargeServiceImpl implements IAccountRechargeService {

	@Autowired
	private IAccountRechargeMapper accountRechargeDao;

	/**
	 * 获取充值记录列表
	 */
	@Override
	public List<AccountRecharge> findAccountRechargeList(Map<String, Object> map) {
		List<AccountRecharge> result = accountRechargeDao.findAccountRechargeList(map);
		return result;
	}

	/**
	 * 立刻充值
	 */
	@Override
	public void insertAccountRecharge(AccountRecharge accountRecharge) {
		accountRechargeDao.insertAccountRecharge(accountRecharge);
	}

	/**
	 * 获取充值记录列表总页数
	 */
	@Override
	public int getAccountRechargeDataCount(Map<String, Object> map) {
		int dataCount = accountRechargeDao.getAccountRechargeDataCount(map);
		return dataCount;
	}

	/**
	 * 楼盘充值记录
	 * 
	 * @author zhouzy
	 */
	@Override
	public List<EnvelopeRecharge> findAccountRechargeByBuildingList(Map<String, Object> map) {
		List<EnvelopeRecharge> result = accountRechargeDao.findAccountRechargeByBuildingList(map);
		return result;
	}

	/**
	 * 楼盘充值记录总页数
	 * 
	 * @author zhouzy
	 */
	@Override
	public int getAccountRechargeByBuildingDataCount(Map<String, Object> map) {
		int dataCount = accountRechargeDao.getAccountRechargeByBuildingDataCount(map);
		return dataCount;
	}

}
