package com.jzhl.kfsq.service.fm.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jzhl.kfsq.dao.fm.IEnvelopeRechargeMapper;
import com.jzhl.kfsq.entity.fm.EnvelopeRecharge;
import com.jzhl.kfsq.service.fm.IEnvelopeRechargeService;

/**
 * 红包充值
 * 
 * @author zhouzy
 *
 */
@Service
public class EnvelopeRechargeServiceImpl implements IEnvelopeRechargeService {

	@Autowired
	private IEnvelopeRechargeMapper envelopeRechargeDao;

	/**
	 * 立刻充值
	 */
	@Override
	public void insertEnvelopeRecharge(EnvelopeRecharge envelopeRecharge) {
		envelopeRechargeDao.insertEnvelopeRecharge(envelopeRecharge);

	}

	/**
	 * 已充值楼盘个数
	 */
	@Override
	public int getBuildingRechargeCount(Map<String, Object> map) {
		int dataCount = envelopeRechargeDao.getBuildingRechargeCount(map);
		return dataCount;
	}

	/**
	 * 算出总的代理商充值、楼盘充值金额
	 */
	@Override
	public int totalPrice(Map<String, Object> map) {
		int dataCount = envelopeRechargeDao.totalPrice(map);
		return dataCount;
	}

	/**
	 * 算出楼盘已赎回成功的金额
	 */
	@Override
	public int totalRedemptionApplicationPrice(Map<String, Object> map) {
		int dataCount = envelopeRechargeDao.totalRedemptionApplicationPrice(map);
		return dataCount;
	}

	/**
	 * 算出评论红包消耗金额
	 */
	@Override
	public int totalEnvelopeUsePrice(Map<String, Object> map) {
		int dataCount = envelopeRechargeDao.totalEnvelopeUsePrice(map);
		return dataCount;
	}

	/**
	 * 昨日充值楼盘个数
	 */
	@Override
	public int getBuildingRechargeCountYesterday(Map<String, Object> map) {
		int dataCount = envelopeRechargeDao.getBuildingRechargeCountYesterday(map);
		return dataCount;
	}

	/**
	 * 昨日代理商充值金额
	 */
	@Override
	public int totalPriceYesterday(Map<String, Object> map) {
		int dataCount = envelopeRechargeDao.totalPriceYesterday(map);
		return dataCount;
	}

	/**
	 * 根据代理商ID查询旗下已经充值的楼盘
	 */
	@Override
	public List<EnvelopeRecharge> getEnvelopeBuildingList(Map<String, Object> map) {
		List<EnvelopeRecharge> result = envelopeRechargeDao.getEnvelopeBuildingList(map);
		return result;
	}

}
