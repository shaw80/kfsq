package com.jzhl.kfsq.dao.fm;

import java.util.List;
import java.util.Map;

import com.jzhl.kfsq.entity.fm.EnvelopeRecharge;

/**
 * 红包充值
 * 
 * @author zhouzy
 *
 */
public interface IEnvelopeRechargeMapper {

	/**
	 * 立刻充值
	 */
	public void insertEnvelopeRecharge(EnvelopeRecharge envelopeRecharge);

	/**
	 * 已充值楼盘个数
	 */
	public int getBuildingRechargeCount(Map<String, Object> map);

	/**
	 * 算出总的代理商充值、楼盘充值金额
	 */
	public int totalPrice(Map<String, Object> map);

	/**
	 * 算出楼盘已赎回成功的金额
	 */
	public int totalRedemptionApplicationPrice(Map<String, Object> map);

	/**
	 * 算出评论红包消耗金额
	 */
	public int totalEnvelopeUsePrice(Map<String, Object> map);

	public int getCommentbalance();

	/**
	 * 昨日充值楼盘个数
	 */
	public int getBuildingRechargeCountYesterday(Map<String, Object> map);

	/**
	 * 昨日代理商充值金额
	 */
	public int totalPriceYesterday(Map<String, Object> map);

	/**
	 * 根据代理商ID查询旗下已经充值的楼盘
	 */
	public List<EnvelopeRecharge> getEnvelopeBuildingList(
			Map<String, Object> map);

	/**
	 * 根据楼盘编号计算楼盘充值余额
	 * 
	 * @param buildingId
	 * @return
	 */
	public Integer getBalance(int buildingId);

}
