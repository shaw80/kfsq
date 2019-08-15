package com.jzhl.kfsq.service.fm;

import java.util.List;
import java.util.Map;

import com.jzhl.kfsq.entity.fm.EnvelopeRecharge;

/**
 * 红包充值接口
 * 
 * @author zhouzy
 *
 */
public interface IEnvelopeRechargeService {

	/**
	 * 立刻充值
	 */
	public void insertEnvelopeRecharge(EnvelopeRecharge envelopeRecharge);

	/**
	 * 已充值楼盘个数
	 */
	public int getBuildingRechargeCount(Map<String, Object> mapb);

	/**
	 * 算出总的代理商充值、楼盘充值金额
	 */
	public int totalPrice(Map<String, Object> mapb);

	/**
	 * 算出楼盘已赎回成功的金额
	 */
	public int totalRedemptionApplicationPrice(Map<String, Object> mapb);

	/**
	 * 算出评论红包消耗金额
	 */
	public int totalEnvelopeUsePrice(Map<String, Object> mapb);
	
	/**
	 * 昨日充值楼盘个数
	 */
	public int getBuildingRechargeCountYesterday(Map<String, Object> mapb);

	/**
	 * 昨日代理商充值金额
	 */
	public int totalPriceYesterday(Map<String, Object> map);

	/**
	 * 根据代理商ID查询旗下已经充值的楼盘
	 */
	public List<EnvelopeRecharge> getEnvelopeBuildingList(Map<String, Object> map);

}
