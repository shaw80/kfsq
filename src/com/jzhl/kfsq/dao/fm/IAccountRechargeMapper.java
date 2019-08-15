package com.jzhl.kfsq.dao.fm;

import java.util.List;
import java.util.Map;

import com.jzhl.kfsq.entity.fm.AccountRecharge;
import com.jzhl.kfsq.entity.fm.EnvelopeRecharge;

/**
 * 充值记录
 * 
 * @author zhouzy
 *
 */
public interface IAccountRechargeMapper {

	/**
	 * 获取充值记录列表
	 */
	public List<AccountRecharge> findAccountRechargeList(Map<String, Object> map);

	/**
	 * 立刻充值
	 */
	public void insertAccountRecharge(AccountRecharge accountRecharge);

	/**
	 * 获取充值记录列表总页数
	 */
	public int getAccountRechargeDataCount(Map<String, Object> map);

	/**
	 * 楼盘充值记录
	 * 
	 * @author zhouzy
	 */
	public List<EnvelopeRecharge> findAccountRechargeByBuildingList(Map<String, Object> map);

	/**
	 * 楼盘充值记录总页数
	 * 
	 * @author zhouzy
	 */
	public int getAccountRechargeByBuildingDataCount(Map<String, Object> map);

}
