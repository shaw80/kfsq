package com.jzhl.kfsq.dao.sm;

import java.util.Map;

import com.jzhl.kfsq.entity.mm.Member;
import com.jzhl.kfsq.entity.sm.Account;

/**
 * 账号管理接口
 * 
 * @author zhouzy
 *
 */
public interface IAccountMapper {

	/**
	 * 添加账户信息
	 * 
	 * @param AccountDto
	 */
	public Integer insertAccount(Account Account);

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
	public Account getAccountByUserId(Map<String, Object> map);
	
	/**
	 * 根据支付宝等账户查询账户信息
	 * @param accountNum
	 * @return
	 */
	public Member getMemberByAccountNum(Map<String, Object> map);

}
