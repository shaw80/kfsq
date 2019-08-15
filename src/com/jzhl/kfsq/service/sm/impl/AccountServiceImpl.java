package com.jzhl.kfsq.service.sm.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jzhl.kfsq.dao.sm.IAccountMapper;
import com.jzhl.kfsq.dto.sm.AccountNumDto;
import com.jzhl.kfsq.entity.mm.Member;
import com.jzhl.kfsq.entity.sm.Account;
import com.jzhl.kfsq.service.sm.IAccountService;

/**
 * 账号管理
 * 
 * @author zhouzy
 *
 */
@Service
public class AccountServiceImpl implements IAccountService {

	@Autowired
	private IAccountMapper accountDao;

	/**
	 * 添加账户信息
	 * 
	 * @param AccountDto
	 */
	@Override
	public void insertAccount(Account Account) {
		accountDao.insertAccount(Account);
	}

	/**
	 * 删除账户信息
	 * 
	 * @param accountId
	 */
	@Override
	public void deleteAccount(int accountId) {
		accountDao.deleteAccount(accountId);
	}

	/**
	 * 更新账户信息
	 * 
	 * @param Account
	 */
	@Override
	public void updateAccount(Account Account) {
		accountDao.updateAccount(Account);
	}

	/**
	 * 根据账户编号查询账户信息
	 * 
	 * @param accountId
	 * @return
	 */
	@Override
	public Account getAccount(int accountId) {
		Account account = accountDao.getAccount(accountId);
		return account;
	}

	/**
	 * 根据用户编号查询账户信息
	 * 
	 * @param userId
	 * @return
	 */
	@Override
	public Account getAccountByUserId(int userId, String userType, String accountType) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("userId", userId);
		map.put("userType", userType);
		map.put("accountType", accountType);
		Account account = accountDao.getAccountByUserId(map);
		return account;
	}

	/**
	 * 根据支付宝等账户查询账户信息
	 * @param accountNum
	 * @return
	 */
	@Override
	public Member getMemberByAccountNum(AccountNumDto dto) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("accountNum", dto.getAccountNum());
		param.put("userType", 1);
		param.put("accountType", 0);
		Member member = accountDao.getMemberByAccountNum(param);
		return member;
	}
}
