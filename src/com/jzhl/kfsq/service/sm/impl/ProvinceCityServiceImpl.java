package com.jzhl.kfsq.service.sm.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jzhl.kfsq.dao.sm.IProvinceCityMapper;
import com.jzhl.kfsq.dataset.sm.CityInfoDataSet;
import com.jzhl.kfsq.dto.sm.BranchCityDto;
import com.jzhl.kfsq.entity.sm.ProvinceCity;
import com.jzhl.kfsq.service.sm.IProvinceCityService;

/**
 * 省市列表
 * 
 * @author zhouzy
 *
 */
@Service
public class ProvinceCityServiceImpl implements IProvinceCityService {

	@Autowired
	private IProvinceCityMapper provinceCityDao;

	/**
	 * 省市列表
	 */
	@Override
	public List<ProvinceCity> findProvinceCityList(Map<String, Object> map) {
		List<ProvinceCity> result = provinceCityDao.findProvinceCityList(map);
		return result;
	}

	/**
	 * 省市列表;添加代理商时，一个城市只有一个代理商；查询城市列表时，要把已经添加过代理商的城市去除；
	 * 
	 * @param
	 * @return ResponseBean
	 */
	@Override
	public List<ProvinceCity> findBranchProvinceCityList(Map<String, Object> map) {
		List<ProvinceCity> result = provinceCityDao.findBranchProvinceCityList(map);
		return result;
	}

	/**
	 * 根据分站编号查询分站城市信息
	 * 
	 * @param dto
	 * @return
	 */
	@Override
	public CityInfoDataSet getCityByBranchId(BranchCityDto dto) {
		CityInfoDataSet result = provinceCityDao.getCityByBranchId(dto);
		return result;
	}

}
