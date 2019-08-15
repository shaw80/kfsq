package com.jzhl.kfsq.controller.bm;

import java.util.ArrayList;
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
import com.jzhl.kfsq.common.util.TimeUtil;
import com.jzhl.kfsq.dataset.bm.BuildingDataSet;
import com.jzhl.kfsq.dataset.bm.BuildingFeatureMsgDataSet;
import com.jzhl.kfsq.dataset.bm.BuildingInfo;
import com.jzhl.kfsq.dataset.bm.RecommendBuildingsDataSet;
import com.jzhl.kfsq.dataset.sm.BuildingStatisticalDataSet;
import com.jzhl.kfsq.dto.bm.BuildingAreaDto;
import com.jzhl.kfsq.dto.bm.BuildingDto;
import com.jzhl.kfsq.dto.bm.BuildingFeatureDto;
import com.jzhl.kfsq.dto.bm.BuildingPriceDto;
import com.jzhl.kfsq.dto.sm.BuildingManagerDto;
import com.jzhl.kfsq.dto.sm.UserDto;
import com.jzhl.kfsq.entity.bm.Building;
import com.jzhl.kfsq.entity.bm.BuildingFeature;
import com.jzhl.kfsq.entity.bm.UnitMap;
import com.jzhl.kfsq.service.bm.IBuildingService;

/**
 * 楼盘信息对外接口类
 * 
 * @author henan
 */
@Controller
public class BuildingController {

	@Autowired
	private IBuildingService buildingService;

	private static final Logger logger = Logger.getLogger(BuildingController.class);

	/**
	 * 多条件分页查询楼盘
	 * 
	 * @param BuildingDto
	 * @return
	 */
	@RequestMapping(value = "/serv/buildings", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean<ListResult> findBuildingEnvelopeDto(BuildingDto dto) {

		ListResult listResult = buildingService.findBuildingEnvelopeDto(dto);

		return new ResponseBean<ListResult>(listResult);
	}

	/**
	 * 查询推荐楼盘结果集
	 * 
	 * @param dto
	 * @return
	 */
	@RequestMapping(value = "/serv/v2/buildings", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean<RecommendBuildingsDataSet> findRecommendBuindings(BuildingDto dto) {

		RecommendBuildingsDataSet dataSet = buildingService.getRecommendBuildings(dto);

		ResponseBean<RecommendBuildingsDataSet> result = new ResponseBean<RecommendBuildingsDataSet>(dataSet);

		result.operateSuccess("查询成功");

		return result;
	}

	/**
	 * 查询楼盘户型
	 * 
	 * @param unitMap
	 * @return
	 */
	@RequestMapping(value = "/serv/findUnitMap", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean<Map<String, Object>> findUnitMap(UnitMap unitMap) {

		List<UnitMap> unitMapList = buildingService.findUnitMap(unitMap);

		Map<String, Object> param = new HashMap<String, Object>();
		param.put("dataList", unitMapList);

		return new ResponseBean<Map<String, Object>>(param);
	}

	/**
	 * 查询楼盘特色
	 * 
	 * @param buildingFeatureDto
	 * @return
	 */
	@RequestMapping(value = "/serv/findBuildingFeature", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean<Map<String, Object>> findBuildingFeatureDto(BuildingFeatureDto buildingFeatureDto) {

		List<BuildingFeatureDto> buildingFeatureDtoList = buildingService.findBuildingFeatureDto(buildingFeatureDto);

		Map<String, Object> param = new HashMap<String, Object>();
		param.put("dataList", buildingFeatureDtoList);

		return new ResponseBean<Map<String, Object>>(param);
	}

	@RequestMapping(value = "/serv/findBuildingFeatureDataSet", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean<Map<String, Object>> findBuildingFeature(Integer buildingId) {
		logger.debug("[楼盘信息]--查询楼盘特色");
		Map<String, Object> map = new HashMap<String, Object>();
		List<BuildingFeatureMsgDataSet> dataList = buildingService.findBuildingFeatureMsgDataSet(buildingId);
		map.put("dataList", dataList);
		return new ResponseBean<Map<String, Object>>(map);
	}

	/**
	 * 查询楼盘信息
	 * 
	 * @param buildingId
	 * @return
	 */
	@RequestMapping(value = "/serv/getBuildingPriceDto", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean<BuildingPriceDto> getBuildingPriceDto(int buildingId) {

		BuildingPriceDto building = buildingService.getBuildingPriceDto(buildingId);

		return new ResponseBean<BuildingPriceDto>(building);
	}

	/**
	 * 查询各区域楼盘数
	 * 
	 * @param buildingId
	 * @return
	 */
	@RequestMapping(value = "/serv/findBuildingAreaDto", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean<Map<String, Object>> findBuildingAreaDto(BuildingAreaDto buildingAreaDto) {
		logger.debug("[查询各区域楼盘数]--查询");

		List<BuildingAreaDto> buildingAreaDtoList = buildingService.findBuildingAreaDto(buildingAreaDto);
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("dataList", buildingAreaDtoList);

		logger.debug("[查询各区域楼盘数]--查询成功");

		return new ResponseBean<Map<String, Object>>(param);
	}

	/**
	 * 按照月份分组统计楼盘数量
	 * 
	 * @author zhouzy
	 * @param
	 * @return ResponseBean
	 */
	@SuppressWarnings({ "rawtypes" })
	@RequestMapping(value = "/serv/building/buildingstatistical", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean findBuildingStatistical(BuildingDto buildingDto) {

		// 获取时间横坐标；近12个月
		List<String> monthList = TimeUtil.dataResult();

		// 按照月份分组查询用户数量
		List<BuildingStatisticalDataSet> sbuildingNumList = buildingService.findBuildingStatistical(buildingDto);

		// 查询近12月的数据后，把为null的月份添加默认数据
		List<BuildingStatisticalDataSet> buildingNumList = new ArrayList<BuildingStatisticalDataSet>();
		for (int i = 0; i < monthList.size(); i++) {
			BuildingStatisticalDataSet buildingNumDataSet = new BuildingStatisticalDataSet();
			buildingNumDataSet.setMonth(TimeUtil.dataResult().get(i));

			// 如果没有数据，则默认楼盘为0
			if (sbuildingNumList.size() == 0) {
				buildingNumDataSet.setBuildingNum(0);
			} else {
				for (int j = 0; j < sbuildingNumList.size(); j++) {
					if (sbuildingNumList.get(j).getMonth().equals(monthList.get(i))) {
						buildingNumDataSet.setBuildingNum(sbuildingNumList.get(j).getBuildingNum());
						break;
					} else {
						buildingNumDataSet.setBuildingNum(0);
					}
				}
			}

			buildingNumList.add(buildingNumDataSet);
		}

		Map<String, Object> queryResult = new HashMap<String, Object>();
		// 返回数据添加
		queryResult.put("dataList", buildingNumList);
		ResponseBean<Map<String, Object>> result = new ResponseBean<Map<String, Object>>(queryResult);
		result.operateSuccess();
		return result;
	}

	/**
	 * 按照月份分组统计已充值楼盘数量；
	 * 
	 * @author zhouzy 20160120;
	 * @param
	 * @return ResponseBean
	 */
	@SuppressWarnings({ "rawtypes" })
	@RequestMapping(value = "/serv/building/rechargebuildingstatistical", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean findRechargeBuildingStatistical(BuildingDto buildingDto) {

		// 获取时间横坐标；近12个月
		List<String> monthList = TimeUtil.dataResult();

		// 查询近12月的数据后，把为null的月份添加默认数据
		List<BuildingStatisticalDataSet> rechargeBuildingNumList = new ArrayList<BuildingStatisticalDataSet>();
		for (int i = 0; i < monthList.size(); i++) {
			// 按照月份分组查询用户数量
			buildingDto.setMonth(monthList.get(i));
			int buildingNum = buildingService.getRechargeBuildingNum(buildingDto);
			BuildingStatisticalDataSet rechargeBuildingNumDataSet = new BuildingStatisticalDataSet();
			rechargeBuildingNumDataSet.setMonth(TimeUtil.dataResult().get(i));
			rechargeBuildingNumDataSet.setBuildingNum(buildingNum);
			rechargeBuildingNumList.add(rechargeBuildingNumDataSet);
		}

		Map<String, Object> queryResult = new HashMap<String, Object>();
		// 返回数据添加
		queryResult.put("dataList", rechargeBuildingNumList);
		ResponseBean<Map<String, Object>> result = new ResponseBean<Map<String, Object>>(queryResult);
		result.operateSuccess();
		return result;
	}

	/**
	 * 根据代理商userid查询其下销售总监列表
	 */
	@SuppressWarnings({ "rawtypes" })
	@RequestMapping(value = "/serv/building/findbuildinguserlist", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean findBuildingUserList(UserDto userDto) throws Exception {

		// 分页查询参数
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("rowstart", userDto.getRowStart());
		map.put("offset", userDto.getOffset());

		// 查询参数
		map.put("userId", userDto.getUserId());
		map.put("keyword", userDto.getKeyword());
		map.put("isValid", userDto.getIsValid());
		map.put("buildingId", userDto.getBuildingId());

		List<BuildingDataSet> buildingList = buildingService.findBuildingUserList(map);

		// 分页返回
		ListResult listResult = new ListResult();
		listResult.setDataList(buildingList);

		// 总页数
		int dataCount = buildingService.getBuildingDataCount(map);
		listResult.setDataCount(dataCount);

		ResponseBean<ListResult> result = new ResponseBean<ListResult>(listResult);
		result.operateSuccess();
		return result;
	}

	/**
	 * 根据代理商userid查询其下楼盘列表
	 */
	@SuppressWarnings({ "rawtypes" })
	@RequestMapping(value = "/serv/building/findbuildinglist", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean findBuildingList(UserDto userDto) throws Exception {

		Map<String, Object> map = new HashMap<String, Object>();

		// 查询参数
		map.put("userId", userDto.getUserId());
		// 模糊查询参数
		map.put("buildingName", userDto.getBuildingName());

		List<BuildingDataSet> buildingList = buildingService.findBuildingList(map);

		// 返回
		ListResult listResult = new ListResult();
		listResult.setDataList(buildingList);

		ResponseBean<ListResult> result = new ResponseBean<ListResult>(listResult);
		result.operateSuccess();
		return result;
	}

	/**
	 * 根据代理商userid查询其下楼盘列表;从楼盘列表中过滤掉已经添加过的楼盘，用于添加楼盘营销总监用，因为一个楼盘只有一个营销总监；
	 */
	@SuppressWarnings({ "rawtypes" })
	@RequestMapping(value = "/serv/building/findnewbuildinglist", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean findNewBuildingList(UserDto userDto) throws Exception {

		Map<String, Object> map = new HashMap<String, Object>();

		// 查询参数
		map.put("userId", userDto.getUserId());

		List<BuildingDataSet> buildingList = buildingService.findNewBuildingList(map);

		// 返回
		ListResult listResult = new ListResult();
		listResult.setDataList(buildingList);

		ResponseBean<ListResult> result = new ResponseBean<ListResult>(listResult);
		result.operateSuccess();
		return result;
	}

	@RequestMapping(value = "/serv/building/insert", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean<Building> insertBuilding(Building building) {
		logger.debug("[楼盘信息]--新增楼盘信息");
		Building result = buildingService.insertBuilding(building);
		return new ResponseBean<Building>(result);
	}

	@SuppressWarnings({ "rawtypes" })
	@RequestMapping(value = "/serv/building/update", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean updateBuilding(Building building) {
		logger.debug("[楼盘信息]--更新楼盘信息");
		buildingService.updateBuilding(building);
		return new ResponseBean();
	}

	@SuppressWarnings({ "rawtypes" })
	@RequestMapping(value = "/serv/building/inValid", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean inVaildBuilding(Building building) {
		logger.debug("[楼盘信息]--禁用楼盘信息");
		buildingService.inVaildBuilding(building);
		return new ResponseBean();
	}

	@RequestMapping(value = "/serv/building/findBuilding", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean<Map<String, Object>> findBuilding(Building building) {
		logger.debug("[楼盘信息]--查询楼盘信息");
		Map<String, Object> map = new HashMap<String, Object>();
		List<Building> dataList = buildingService.findBuilding(building);
		map.put("dataList", dataList);
		return new ResponseBean<Map<String, Object>>(map);
	}

	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "/serv/building/addBuildingFeature", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean insertBuildingFeature(BuildingFeature buildingFeature) {
		logger.debug("[楼盘信息]--新增楼盘特色关系");
		buildingService.insertBuildingFeature(buildingFeature);
		return new ResponseBean();
	}

	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "/serv/building/updateBuildingFeatureInValid", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean updateBuildingFeatureInValid(BuildingFeature buildingFeature) {
		logger.debug("[楼盘信息]--禁用楼盘特色关系");
		buildingService.updateBuildingFeatureInValid(buildingFeature);
		return new ResponseBean();
	}

	@RequestMapping(value = "/serv/building/findBuildingFeature", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean<Map<String, Object>> findBuildingFeature(BuildingFeature buildingFeature) {
		logger.debug("[楼盘信息]--查询楼盘特色");
		Map<String, Object> map = new HashMap<String, Object>();
		List<BuildingFeature> dataList = buildingService.findBuildingFeature(buildingFeature);
		map.put("dataList", dataList);
		return new ResponseBean<Map<String, Object>>(map);
	}

	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "/serv/building/addUnitMap", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean insertUnitMap(UnitMap unitMap) {
		logger.debug("[楼盘信息]--添加楼盘户型图");
		buildingService.insertUnitMap(unitMap);
		return new ResponseBean();
	}

	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "/serv/building/updateUnitMap", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean updateUnitMap(UnitMap unitMap) {
		logger.debug("[楼盘信息]--更新楼盘户型图");
		buildingService.updateUnitMap(unitMap);
		return new ResponseBean();
	}

	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "/serv/building/updateUnitMapInValid", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean updateUnitMapInValid(UnitMap unitMap) {
		logger.debug("[楼盘信息]--禁用楼盘户型图");
		buildingService.updateUnitMapInValid(unitMap);
		return new ResponseBean();
	}

	/**
	 * 楼盘后台管理通用获取楼盘信息方法
	 * 
	 * @return
	 */
	@RequestMapping(value = "/serv/v2/building/getBuildingInfo", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean<BuildingInfo> getBuildingInfo(BuildingManagerDto dto) {
		logger.debug("[楼盘信息]--楼盘后台管理获取楼盘信息");
		BuildingInfo buildingInfo = buildingService.getBuildingInfo(dto.getUserId());
		ResponseBean<BuildingInfo> result = new ResponseBean<BuildingInfo>(buildingInfo);
		result.operateSuccess("查询成功");
		return result;
	}

}
