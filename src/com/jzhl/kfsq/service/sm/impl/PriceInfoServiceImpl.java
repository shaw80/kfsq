package com.jzhl.kfsq.service.sm.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jzhl.kfsq.dao.sm.IPriceInfoMapper;
import com.jzhl.kfsq.dto.sm.PriceInfoDto;
import com.jzhl.kfsq.entity.sm.PriceInfo;
import com.jzhl.kfsq.service.sm.IPriceInfoService;

/**
 * 价格信息业务层实现类
 * 
 * @author Shaw
 *
 */
@Service
public class PriceInfoServiceImpl implements IPriceInfoService {

	@Autowired
	private IPriceInfoMapper priceInfoDao;

	/**
	 * 查询全部价格信息
	 * 
	 * @return
	 */
	@Override
	public List<PriceInfo> findPriceInfo() {

		List<PriceInfo> result = priceInfoDao.findPriceInfo();

		return result;
	}

	/**
	 * 参数设置-单价-编辑
	 * 
	 * @author zhouzy
	 */
	@Override
	public void updatePriceInfo(PriceInfo priceInfo) {
		priceInfoDao.updatePriceInfo(priceInfo);
	}

	/**
	 * 参数设置-单价-新增
	 * 
	 * @author zhouzy
	 */
	@Override
	public void insertPriceInfo(PriceInfo priceInfo) {
		priceInfoDao.insertPriceInfo(priceInfo);
	}

	/**
	 * 参数设置-单价-单价列表
	 * 
	 * @author zhouzy
	 */
	@Override
	public List<PriceInfo> findPriceInfoList(Map<String, Object> map) {
		List<PriceInfo> result = priceInfoDao.findPriceInfoList(map);
		return result;
	}

	/**
	 * 参数设置-单价-单价列表总数
	 * 
	 * @author zhouzy
	 */
	@Override
	public int getPriceInfoDataCount(Map<String, Object> map) {
		int dataCount = priceInfoDao.getPriceInfoDataCount(map);
		return dataCount;
	}

	/**
	 * 参数设置-单价-查询价格区间列表
	 * 
	 * @author zhouzy
	 */
	@Override
	public List<PriceInfo> findPriceList(PriceInfoDto priceInfoDto) {
		List<PriceInfo> list = priceInfoDao.findPriceList(priceInfoDto);
		return list;
	}

}
