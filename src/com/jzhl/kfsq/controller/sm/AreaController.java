package com.jzhl.kfsq.controller.sm;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jzhl.kfsq.common.base.ListResult;
import com.jzhl.kfsq.common.base.ResponseBean;
import com.jzhl.kfsq.dataset.sm.AreaDataSet;
import com.jzhl.kfsq.dto.sm.AreaDto;
import com.jzhl.kfsq.entity.sm.Area;
import com.jzhl.kfsq.service.sm.IAreaService;

@Controller
public class AreaController {

	private static final Logger logger = Logger.getLogger(AreaController.class);

	@Autowired
	private IAreaService areaService;

	@RequestMapping(value = "/serv/findArea", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean<Map<String, Object>> findBuildingEnvelopeDto(Area area) {
		logger.debug("[查询区域]--查询");
		List<Area> areaList = areaService.findArea(area);
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("dataList", areaList);
		logger.debug("[查询区域]--查询成功");
		return new ResponseBean<Map<String, Object>>(param);
	}

	@RequestMapping(value = "/serv/area/cityName", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean<Map<String, Object>> findBuildingEnvelopeDto(AreaDto dto) {
		logger.debug("[查询区域]--查询");
		List<Area> areaList = areaService.findAreaByCityName(dto);
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("dataList", areaList);
		logger.debug("[查询区域]--查询成功");
		return new ResponseBean<Map<String, Object>>(param);
	}

	@SuppressWarnings({ "rawtypes" })
	@RequestMapping(value = "/serv/area/findArea", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean findAreaDto(AreaDto areaDto) {

		// 分页查询参数
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("rowstart", areaDto.getRowStart());
		map.put("offset", areaDto.getOffset());

		// 查询条件参数
		Integer creatorUserId = areaDto.getCreatorUserId();
		map.put("creatorUserId", creatorUserId);

		List<Area> areaList = areaService.findAreaList(map);

		// 分页返回
		ListResult listResult = new ListResult();
		listResult.setDataList(areaList);

		// 总页数
		int dataCount = areaService.getAreaDataCount(map);
		listResult.setDataCount(dataCount);

		ResponseBean<ListResult> result = new ResponseBean<ListResult>(listResult);
		result.operateSuccess();
		return result;
	}

	/**
	 * 参数设置-区域列表-新增
	 */
	@SuppressWarnings({ "rawtypes" })
	@RequestMapping(value = "/serv/area/insertArea", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean insertArea(Area area) throws Exception {

		area.setIsValid((short) 1);
		// 编辑
		areaService.insertArea(area);

		ResponseBean result = new ResponseBean<Area>();
		result.operateSuccess();
		return result;
	}

	/**
	 * 参数设置-区域列表-新增
	 */
	@SuppressWarnings({ "rawtypes" })
	@RequestMapping(value = "/serv/area/updateArea", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean updateArea(Area area) throws Exception {

		// 编辑
		areaService.updateArea(area);

		ResponseBean result = new ResponseBean<Area>();
		result.operateSuccess();
		return result;
	}

	@RequestMapping(value = "/serv/getArea", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean<Area> findBuildingEnvelopeDto(Integer areaId) {
		logger.debug("[查询区域]--查询");
		Area area = areaService.getArea(areaId);
		logger.debug("[查询区域]--查询成功");
		return new ResponseBean<Area>(area);
	}

	/**
	 * 根据城市编号查询App首页楼盘列表时的区域属性列表
	 * 
	 * @param cityId
	 * @return
	 */
	@RequestMapping(value = "/serv/findAreaDataSet", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean<List<AreaDataSet>> findAreaDataSet(Integer cityId) {
		List<AreaDataSet> list = areaService.findAreaDateSet(cityId);
		ResponseBean<List<AreaDataSet>> result = new ResponseBean<List<AreaDataSet>>(list);
		result.operateSuccess("查询成功");
		return result;
	}

	/**
	 * 根据一级区域 areaId 获取二级区域列表
	 * 
	 * @param areaId
	 * @return
	 */
	@SuppressWarnings({ "rawtypes" })
	@RequestMapping(value = "/serv/area/findScecondAreaList", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean findScecondAreaList(AreaDto areaDto) {

		// 分页查询参数
		Map<String, Object> map = new HashMap<String, Object>();
		// 一级区域ID
		map.put("areaId", areaDto.getAreaId());
		// 查询二级区域
		List<Area> scecondAreaList = areaService.findScecondAreaList(map);
		// 分页返回
		ListResult listResult = new ListResult();
		listResult.setDataList(scecondAreaList);
		// 总页数
		listResult.setDataCount(scecondAreaList.size());

		ResponseBean<ListResult> result = new ResponseBean<ListResult>(listResult);
		result.operateSuccess();
		return result;
	}

	/**
	 * 根据一级区域 areaId 获取二级区域列表-分页
	 * 
	 * @return ResponseBean
	 */
	@SuppressWarnings({ "rawtypes" })
	@RequestMapping(value = "/serv/area/findSecondAreaListByPage", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean findSecondAreaListByPage(AreaDto areaDto) throws Exception {

		Map<String, Object> param = new HashMap<String, Object>();

		param.put("rowstart", areaDto.getRowStart());
		param.put("offset", areaDto.getOffset());

		param.put("areaId", areaDto.getAreaId());

		// 标签查询
		List<Area> areaList = areaService.findSecondAreaListByPage(param);
		// 返回
		ListResult listResult = new ListResult();
		listResult.setDataList(areaList);

		// 总页数
		int dataCount = areaService.findSecondAreaListByPageDataCount(param);
		listResult.setDataCount(dataCount);

		ResponseBean<ListResult> result = new ResponseBean<ListResult>(listResult);
		result.operateSuccess();
		return result;

	}

}
