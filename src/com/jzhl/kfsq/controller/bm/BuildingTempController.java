package com.jzhl.kfsq.controller.bm;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jzhl.kfsq.common.base.ResponseBean;
import com.jzhl.kfsq.dataset.bm.BuildingTempInfoDataSet;
import com.jzhl.kfsq.entity.bm.BuildingFeatureTemp;
import com.jzhl.kfsq.entity.bm.BuildingTemp;
import com.jzhl.kfsq.entity.bm.UnitMapTemp;
import com.jzhl.kfsq.service.bm.IBuildingTempService;

@Controller
public class BuildingTempController {
	
	private static final Logger logger = Logger.getLogger(BuildingTempController.class);
	@Autowired
	private IBuildingTempService buildingTempService;
	
	@RequestMapping(value = "/serv/buildingTemp/addBuildingTemp", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean<BuildingTemp> addBuildingTemp(BuildingTemp buildingTemp) {
		logger.debug("[楼盘信息抓取]--保存楼盘信息");
		BuildingTemp result = buildingTempService.insertBuildingTemp(buildingTemp);
		return new ResponseBean<BuildingTemp>(result);
	}
	
	
	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "/serv/buildingTemp/updateBuildingTemp", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean updateBuildingTemp(BuildingTemp buildingTemp) {
		logger.debug("[楼盘信息抓取]--更新楼盘信息");
		buildingTempService.updateBuildingTemp(buildingTemp);
		return new ResponseBean();
	}
	
	
	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "/serv/buildingTemp/updateBuildingTempInValid", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean updateBuildingTempInValid(String buildingIds) {
		logger.debug("[楼盘信息抓取]--禁用楼盘信息");
		buildingTempService.updateBuildingTempInValid(buildingIds.split(","));
		return new ResponseBean();
	}
	
	
	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "/serv/buildingTemp/addBuildingFeatureTemp", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean addBuildingFeatureTemp(BuildingFeatureTemp buildingTempDto) {
		logger.debug("[楼盘信息抓取]--保存楼盘特色");
		buildingTempService.insertBuildingFeatureTemp(buildingTempDto);
		return new ResponseBean();
	}
	
	
	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "/serv/buildingTemp/updateBuildingFeatureTemp", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean updateBuildingFeatureTemp(BuildingFeatureTemp buildingTempDto) {
		logger.debug("[楼盘信息抓取]--更新楼盘特色");
		buildingTempService.updateBuildingFeatureTemp(buildingTempDto);
		return new ResponseBean();
	}
	
	
	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "/serv/buildingTemp/updateBuildingFeatureTempInValid", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean updateBuildingFeatureTempInValid(String featureIds) {
		logger.debug("[楼盘信息抓取]--禁用楼盘特色");
		buildingTempService.updateBuildingFeatureTempInValid(featureIds.split(","));
		return new ResponseBean();
	}
	
	
	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "/serv/buildingTemp/addUnitMapTemp", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean addUnitMapTemp(UnitMapTemp unitMapTemp) {
		logger.debug("[楼盘信息抓取]--保存楼盘户型图信息");
		buildingTempService.insertUnitMapTemp(unitMapTemp);
		return new ResponseBean();
	}
	
	
	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "/serv/buildingTemp/updateUnitMapTemp", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean updateUnitMapTemp(UnitMapTemp unitMapTemp) {
		logger.debug("[楼盘信息抓取]--更新楼盘户型图信息");
		buildingTempService.updateUnitMapTemp(unitMapTemp);
		return new ResponseBean();
	}
	
	
	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "/serv/buildingTemp/updateUnitMapTempInValid", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean updateUnitMapTempInValid(@RequestParam("unitMapIds") String unitMapIds) {
		logger.debug("[楼盘信息抓取]--禁用楼盘户型图信息");
		buildingTempService.updateUnitMapTempInValid(unitMapIds.split(","));
		return new ResponseBean();
	}
	
	
	@RequestMapping(value = "/serv/buildingTemp/findBuildingTempInfo", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean<Map<String, Object>> findBuildingTempInfo(BuildingTemp buildingTemp) {
		logger.debug("[楼盘信息抓取]--按条件查询楼盘详情信息");
		Map<String, Object> param = new HashMap<String, Object>();
		List<BuildingTempInfoDataSet> dataList = buildingTempService.findBuildingTempInfo(buildingTemp);
		param.put("dataList", dataList);
		return new ResponseBean<Map<String, Object>>(param);
	}
	
	
	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "/serv/buildingTemp/updateBuildingInfoSynchronized", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean updateBuildingInfoSynchronized(Integer buildingId) {
		logger.debug("[楼盘信息抓取]--更新楼盘所有信息为已同步");
		buildingTempService.updateBuildingInfoSynchronized(buildingId);
		return new ResponseBean();
	}
	

	@RequestMapping(value = "/serv/buildingTemp/getBuildingTempCount", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean<Map<String, Object>> getBuildingTempCount(BuildingTemp buildingTemp) {
		logger.debug("[楼盘信息抓取]--按条件查询楼盘数量");
		Map<String, Object> map = new HashMap<String, Object>();
		int dataCount = buildingTempService.getBuildingTempCount(buildingTemp);
		map.put("dataCount", dataCount);
		return new ResponseBean<Map<String, Object>>(map);
	}
	
}
