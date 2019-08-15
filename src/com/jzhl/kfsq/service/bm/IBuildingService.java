package com.jzhl.kfsq.service.bm;

import java.util.List;
import java.util.Map;

import com.jzhl.kfsq.common.base.ListResult;
import com.jzhl.kfsq.dataset.bm.BuildingDataSet;
import com.jzhl.kfsq.dataset.bm.BuildingFeatureMsgDataSet;
import com.jzhl.kfsq.dataset.bm.BuildingInfo;
import com.jzhl.kfsq.dataset.bm.RecommendBuildingsDataSet;
import com.jzhl.kfsq.dataset.sm.BuildingStatisticalDataSet;
import com.jzhl.kfsq.dto.bm.BuildingAreaDto;
import com.jzhl.kfsq.dto.bm.BuildingDto;
import com.jzhl.kfsq.dto.bm.BuildingFeatureDto;
import com.jzhl.kfsq.dto.bm.BuildingPriceDto;
import com.jzhl.kfsq.entity.bm.Building;
import com.jzhl.kfsq.entity.bm.BuildingFeature;
import com.jzhl.kfsq.entity.bm.UnitMap;

public interface IBuildingService {

	/**
	 * 查询根据条件分页查询楼盘列表
	 * 
	 * @param BuildingDto
	 * @return
	 */
	public ListResult findBuildingEnvelopeDto(BuildingDto buildingDto);

	/**
	 * 查询推荐楼盘
	 * 
	 * @param buildingDto
	 * @return
	 */
	public RecommendBuildingsDataSet getRecommendBuildings(
			BuildingDto buildingDto);

	/**
	 * 查询户型
	 * 
	 * @param UnitMap
	 * @return
	 */
	public List<UnitMap> findUnitMap(UnitMap unitMap);

	/**
	 * 查询楼盘特色
	 * 
	 * @param BuildingFeatureDto
	 * @return
	 */
	public List<BuildingFeatureDto> findBuildingFeatureDto(
			BuildingFeatureDto buildingFeatureDto);

	/**
	 * 查询楼盘信息
	 * 
	 * @param buildingId
	 * @return
	 */
	public BuildingPriceDto getBuildingPriceDto(java.lang.Integer buildingId);

	/**
	 * 查询各区域楼盘数
	 * 
	 * @param buildingAreaDto
	 * @return
	 */
	public List<BuildingAreaDto> findBuildingAreaDto(
			BuildingAreaDto buildingAreaDto);

	/**
	 * 按照月份分组统计楼盘数量
	 * 
	 * @author zhouzy
	 */
	public List<BuildingStatisticalDataSet> findBuildingStatistical(
			BuildingDto buildingDto);

	/**
	 * 查询楼盘权限列表
	 * 
	 * @author zhouzy
	 */
	public List<BuildingDataSet> findBuildingList(Map<String, Object> map);

	/**
	 * 查询楼盘权限列表总数
	 * 
	 * @author zhouzy
	 */
	public int getBuildingDataCount(Map<String, Object> map);

	/**
	 * 根据代理商userid查询其下销售总监列表
	 */
	public List<BuildingDataSet> findBuildingUserList(Map<String, Object> map);

	/**
	 * 更新楼盘信息
	 * 
	 * @param building
	 */
	public void updateBuilding(Building building);

	/**
	 * 新增楼盘信息
	 * 
	 * @param building
	 */
	public Building insertBuilding(Building building);

	/**
	 * 禁用楼盘
	 * 
	 * @param building
	 */
	public void inVaildBuilding(Building building);

	/**
	 * 根据条件查询楼盘信息
	 * 
	 * @param building
	 * @return
	 */
	public List<Building> findBuilding(Building building);

	/**
	 * 新增楼盘特色关系
	 * 
	 * @param buildingFeature
	 */
	public void insertBuildingFeature(BuildingFeature buildingFeature);

	/**
	 * 更新楼盘特色关系为无效
	 * 
	 * @param buildingFeature
	 */
	public void updateBuildingFeatureInValid(BuildingFeature buildingFeature);

	/**
	 * 查询楼盘特色
	 * 
	 * @param buildingFeature
	 * @return
	 */
	public List<BuildingFeature> findBuildingFeature(
			BuildingFeature buildingFeature);

	/**
	 * 查询楼盘特色
	 * 
	 * @param buildingFeature
	 * @return
	 */
	public List<BuildingFeatureMsgDataSet> findBuildingFeatureMsgDataSet(Integer buildingId);

	/**
	 * 添加楼盘户型图
	 * 
	 * @param unitMap
	 */
	public void insertUnitMap(UnitMap unitMap);

	/**
	 * 更新楼盘户型图
	 * 
	 * @param unitMap
	 */
	public void updateUnitMap(UnitMap unitMap);

	/**
	 * 禁用楼盘户型图
	 * 
	 * @param unitMapId
	 */
	public void updateUnitMapInValid(UnitMap unitMap);

	/**
	 * 根据代理商userid查询其下楼盘列表;从楼盘列表中过滤掉已经添加过的楼盘，用于添加楼盘营销总监用，因为一个楼盘只有一个营销总监；
	 * 
	 * @author zhouzy
	 */
	public List<BuildingDataSet> findNewBuildingList(Map<String, Object> map);

	/**
	 * 按照月份分组统计已充值楼盘数量；
	 * 
	 * @author zhouzy 20160120;
	 * @param
	 * @return ResponseBean
	 */
	public int getRechargeBuildingNum(BuildingDto buildingDto);
	
	/**
	 * 根据营销总监userId查询buildingInfo信息，包含楼盘名称和楼盘余额
	 * @param userId
	 * @return
	 */
	public BuildingInfo getBuildingInfo(int userId);

}
