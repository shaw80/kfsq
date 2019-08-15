package com.jzhl.kfsq.controller.sm;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jzhl.kfsq.common.base.ResponseBean;
import com.jzhl.kfsq.dataset.sm.CityInfoDataSet;
import com.jzhl.kfsq.dto.sm.BranchCityDto;
import com.jzhl.kfsq.dto.sm.ProvinceCityDto;
import com.jzhl.kfsq.entity.sm.ProvinceCity;
import com.jzhl.kfsq.service.sm.IProvinceCityService;

/**
 * 省市列表接口类
 * 
 * @author zhouzy
 *
 */
@Controller
public class ProvinceCityController {

	@Autowired
	private IProvinceCityService provinceCityService;

	/**
	 * 省市列表
	 * 
	 * @param
	 * @return ResponseBean
	 */
	@SuppressWarnings({ "rawtypes" })
	@RequestMapping(value = "/serv/provincecity/findprovincecitylist", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean findProvinceCityList(ProvinceCityDto provinceCityDto) throws Exception {

		Map<String, Object> map = new HashMap<String, Object>();
		Integer parentAreaId = provinceCityDto.getparentAreaId();
		// 根据父类ID查子类；0为省的父类；
		map.put("parentAreaId", parentAreaId);
		List<ProvinceCity> provinceCityList = provinceCityService.findProvinceCityList(map);
		
		// 返回参数
		Map<String, Object> queryResult = new HashMap<String, Object>();
		queryResult.put("dataList", provinceCityList);
		ResponseBean<Map<String, Object>> result = new ResponseBean<Map<String, Object>>(queryResult);
		result.operateSuccess();
		return result;
	}
	
	/**
	 * 省市列表;添加代理商时，一个城市只有一个代理商；查询城市列表时，要把已经添加过代理商的城市去除；
	 * 
	 * @param
	 * @return ResponseBean
	 */
	@SuppressWarnings({ "rawtypes" })
	@RequestMapping(value = "/serv/provincecity/findBranchProvinceCityList", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean findBranchProvinceCityList(ProvinceCityDto provinceCityDto) throws Exception {

		Map<String, Object> map = new HashMap<String, Object>();
		Integer parentAreaId = provinceCityDto.getparentAreaId();
		// 根据父类ID查子类；0为省的父类；
		map.put("parentAreaId", parentAreaId);
		List<ProvinceCity> provinceCityList = provinceCityService.findBranchProvinceCityList(map);
		
		// 返回参数
		Map<String, Object> queryResult = new HashMap<String, Object>();
		queryResult.put("dataList", provinceCityList);
		ResponseBean<Map<String, Object>> result = new ResponseBean<Map<String, Object>>(queryResult);
		result.operateSuccess();
		return result;
	}
	
	/**
	 * 根据分站编号查询分站城市信息
	 * 
	 * @param dto
	 * @return
	 */
	@RequestMapping(value = "/serv/v2/city/branchId", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean<CityInfoDataSet> getCityByBranchId(BranchCityDto dto){
		CityInfoDataSet data = provinceCityService.getCityByBranchId(dto);
		ResponseBean<CityInfoDataSet> result = new ResponseBean<CityInfoDataSet>(data);
		result.operateSuccess("查询成功");
		return result;
	}
}
