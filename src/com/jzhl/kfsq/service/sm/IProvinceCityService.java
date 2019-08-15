package com.jzhl.kfsq.service.sm;

import java.util.List;
import java.util.Map;

import com.jzhl.kfsq.dataset.sm.CityInfoDataSet;
import com.jzhl.kfsq.dto.sm.BranchCityDto;
import com.jzhl.kfsq.entity.sm.ProvinceCity;

/**
 * 省市列表接口
 * 
 * @author zhouzy
 *
 */
public interface IProvinceCityService {

	/**
	 * 省市列表
	 * 
	 * @return 省市列表
	 */
	public List<ProvinceCity> findProvinceCityList(Map<String, Object> map);

	/**
	 * 省市列表;添加代理商时，一个城市只有一个代理商；查询城市列表时，要把已经添加过代理商的城市去除；
	 * 
	 * @param
	 * @return ResponseBean
	 */
	public List<ProvinceCity> findBranchProvinceCityList(Map<String, Object> map);
	
	/**
	 * 根据分站编号查询分站城市信息
	 * 
	 * @param dto
	 * @return
	 */
	public CityInfoDataSet getCityByBranchId(BranchCityDto dto);

}
