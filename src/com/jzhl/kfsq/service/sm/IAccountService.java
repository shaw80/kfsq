package com.jzhl.kfsq.service.sm;

import com.jzhl.kfsq.dto.sm.AccountNumDto;
import com.jzhl.kfsq.entity.mm.Member;
import com.jzhl.kfsq.entity.sm.Account;

/**
 * 账号管理接口
 * 
 * @author zhouzy
 *
 */
public interface IAccountService {

	/**
	 * 添加账户信息
	 * 
	 * @param AccountDto
	 */
	public void insertAccount(Account Account);

	/**
	 * 删除账户信息
	 * 
	 * @param accountId
	 */
	public void deleteAccount(int accountId);

	/**
	 * 更新账户信息
	 * 
	 * @param Account
	 */
	public void updateAccount(Account Account);

	/**
	 * 根据账户编号查询账户信息
	 * 
	 * @param accountId
	 * @return
	 */
	public Account getAccount(int accountId);

	/**
	 * 根据用户编号查询账户信息
	 * 
	 * @param userId
	 * @return
	 */
	public Account getAccountByUserId(int userId, String userType, String accountType);
	
	/**
	 * 根据支付宝等账户查询账户信息
	 * @param accountNum
	 * @return
	 */
	public Member getMemberByAccountNum(AccountNumDto dto);

}
