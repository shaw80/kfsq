package com.jzhl.kfsq.service.sm;

import java.util.List;
import java.util.Map;

import com.jzhl.kfsq.dto.sm.PriceInfoDto;
import com.jzhl.kfsq.entity.sm.PriceInfo;

/**
 * 价格信息业务层接口
 * 
 * @author Shaw
 *
 */
public interface IPriceInfoService {

	/**
	 * 查询全部价格信息
	 * 
	 * @return
	 */
	public List<PriceInfo> findPriceInfo();

	/**
	 * 参数设置-单价-编辑
	 * 
	 * @author zhouzy
	 */
	public void updatePriceInfo(PriceInfo priceInfo);

	/**
	 * 参数设置-单价-新增
	 * 
	 * @author zhouzy
	 */
	public void insertPriceInfo(PriceInfo priceInfo);

	/**
	 * 参数设置-单价-单价列表
	 * 
	 * @author zhouzy
	 */
	public List<PriceInfo> findPriceInfoList(Map<String, Object> map);

	/**
	 * 参数设置-单价-单价列表总数
	 * 
	 * @author zhouzy
	 */
	public int getPriceInfoDataCount(Map<String, Object> map);

	/**
	 * 参数设置-单价-查询价格区间列表
	 * 
	 * @author zhouzy
	 */
	public List<PriceInfo> findPriceList(PriceInfoDto priceInfoDto);

}
