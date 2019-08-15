package com.jzhl.kfsq.dao.ba;

import java.util.Map;

import com.jzhl.kfsq.dataset.ba.DimensionDataSet;
import com.jzhl.kfsq.entity.ba.Dimension;

public interface IDimensionMapper {

	/**
	 * 检索维度字典表
	 * 
	 * @param
	 * @return Dimension
	 */
	public Dimension getDimension();

	/**
	 * 根据维度代码和城市编号查询维度信息
	 * 
	 * @param param
	 * @return
	 */
	public Dimension getDimensionByDimensionCodeAndCityId(
			Map<String, Object> param);

	/**
	 * 根据楼盘编号和城市编号查询维度信息（查询其他标签数量对应的维度信息）
	 * 
	 * @param param
	 * @return
	 */
	public Dimension getDimensionByCodeAndCityIdAndSize(Map<String, Object> param);

	/**
	 * 根据开发商排名查询维度信息
	 * 
	 * @param name
	 * @return
	 */
	public Dimension getDimensionByDevelopers(String name);

	/**
	 * 根据物业排名查询维度信息
	 * 
	 * @param name
	 * @return
	 */
	public Dimension getDimensionByProperty(String name);

	/**
	 * 根据地段排名查询维度信息
	 * 
	 * @param name
	 * @return
	 */
	public Dimension getDimensionByArea(Integer areaId);

	/**
	 * 根据绿化率查询维度信息
	 * 
	 * @param param
	 * @return
	 */
	public DimensionDataSet getDimensionDataSetByGreenRates(int buildingId);

	/**
	 * 根据车位比查询维度信息
	 * 
	 * @param param
	 * @return
	 */
	public DimensionDataSet getDimensionDataSetByRatioOfSpaces(Map<String, Object> param);

	/**
	 * 根据周边配套查询维度信息
	 * 
	 * @param param
	 * @return
	 */
	public DimensionDataSet getDimensionDataSetByParkFacilities(int count);

	/**
	 * 根据是否人车分流查询维度信息
	 * 
	 * @param param
	 * @return
	 */
	public DimensionDataSet getDimensionDataSetByIsSeparation(int buildingId);

	/**
	 * 根据是否有公交查询公交维度信息
	 * 
	 * @param param
	 * @return
	 */
	public DimensionDataSet getDimensionDataSetByBus(int buildingId);

	/**
	 * 根据公交距离查询公交维度信息
	 * 
	 * @param param
	 * @return
	 */
	public DimensionDataSet getDimensionDataSetByBusDistance(int buildingId);

	/**
	 * 根据最短距离查询对应维度区间的公交数量
	 * 
	 * @param param
	 * @return
	 */
	public int countTrafficDataSetByBusNum(int buildingId);

	/**
	 * 根据最短距离对应维度区间的公交数量查询维度信息
	 * 
	 * @param param
	 * @return
	 */
	public DimensionDataSet getDimensionDataSetByBusNum(int buildingId);

	/**
	 * 根据是否有轨道交通工具查询轨道维度信息
	 * 
	 * @param param
	 * @return
	 */
	public DimensionDataSet getDimensionDataSetByTrack(int buildingId);

	/**
	 * 根据轨道距离查询轨道维度信息
	 * 
	 * @param param
	 * @return
	 */
	public DimensionDataSet getDimensionDataSetByTrackDistance(int buildingId);
	
	/**
	 * 根据最短距离对应维度区间的轨道数量查询维度信息
	 * 
	 * @param param
	 * @return
	 */
	public DimensionDataSet getDimensionDataSetByTrackNum(int buildingId);

	/**
	 * 根据楼盘编号、维度编码和城市编号查询学校最短距离对应维度信息
	 * 
	 * @param param
	 * @return
	 */
	public DimensionDataSet getDimensionDataSetByBuildingIdAndCodeAndCityIdForSchoolDistance(
			Map<String, Object> param);
	
	/**
	 * 根据楼盘编号、维度编码和城市编号查询学校最短距离对应维度信息
	 * 
	 * @param param
	 * @return
	 */
	public DimensionDataSet getDimensionDataSetByCollege(
			int count);
	
	/**
	 * 根据楼盘编号、维度编码和城市编号查询学校最短距离学校数量对应维度信息
	 * 
	 * @param param
	 * @return
	 */
	public DimensionDataSet getDimensionDataSetByBuildingIdAndCodeAndCityIdForSchoolCount(
			Map<String, Object> param);
	
	/**
	 * 根据楼盘编号和城市编号查询普通小学最短距离对应维度信息
	 * 
	 * @param param
	 * @return
	 */
	public DimensionDataSet getDimensionDataSetByBuildingIdAndCityIdForGradeSchoolDistance(
			Map<String, Object> param);
	
	/**
	 * 根据楼盘编号和城市编号查询最短距离普通小学数量对应维度信息
	 * 
	 * @param param
	 * @return
	 */
	public DimensionDataSet getDimensionDataSetByBuildingIdAndCityIdForGradeSchoolCount(
			int count);
	
	/**
	 * 根据楼盘编号和城市编号查询优质小学最短距离对应维度信息
	 * 
	 * @param param
	 * @return
	 */
	public DimensionDataSet getDimensionDataSetByBuildingIdAndCityIdForGoodGradeSchoolDistance(
			Map<String, Object> param);
	
	/**
	 * 根据楼盘编号和城市编号查询最短距离优质小学数量对应维度信息
	 * 
	 * @param param
	 * @return
	 */
	public DimensionDataSet getDimensionDataSetByBuildingIdAndCityIdForGoodGradeSchoolCount(
			Map<String, Object> param);
	
	/**
	 * 根据楼盘编号和城市编号查询医院最短距离对应维度信息
	 * 
	 * @param param
	 * @return
	 */
	public DimensionDataSet getDimensionDataSetByBuildingIdAndCityIdForHospitalDistance(
			Map<String, Object> param);
	
	/**
	 * 根据楼盘编号和城市编号查询最短距离医院数量对应维度信息
	 * 
	 * @param param
	 * @return
	 */
	public DimensionDataSet getDimensionDataSetByBuildingIdAndCityIdForHospitalCount(
			int count);
	
	/**
	 * 根据楼盘编号和城市编号查询诊所最短距离对应维度信息
	 * 
	 * @param param
	 * @return
	 */
	public DimensionDataSet getDimensionDataSetByBuildingIdAndCityIdForClinicDistance(
			Map<String, Object> param);
	
	/**
	 * 根据楼盘编号和城市编号查询最短距离诊所数量对应维度信息
	 * 
	 * @param param
	 * @return
	 */
	public DimensionDataSet getDimensionDataSetByBuildingIdAndCityIdForClinicCount(
			int count);
	
	/**
	 * 根据楼盘编号和城市编号查询药房最短距离对应维度信息
	 * 
	 * @param param
	 * @return
	 */
	public DimensionDataSet getDimensionDataSetByBuildingIdAndCityIdForPharmacyDistance(
			Map<String, Object> param);
	
	/**
	 * 根据楼盘编号和城市编号查询最短距离药房数量对应维度信息
	 * 
	 * @param param
	 * @return
	 */
	public DimensionDataSet getDimensionDataSetByBuildingIdAndCityIdForPharmacyCount(
			int count);
	
	/**
	 * 根据楼盘编号和城市编号查询银行最短距离对应维度信息
	 * 
	 * @param param
	 * @return
	 */
	public DimensionDataSet getDimensionDataSetByBuildingIdAndCityIdForBankDistance(
			Map<String, Object> param);
	
	/**
	 * 根据楼盘编号和城市编号查询最短距离银行数量对应维度信息
	 * 
	 * @param param
	 * @return
	 */
	public DimensionDataSet getDimensionDataSetByBuildingIdAndCityIdForBankCount(
			int count);
	
	/**
	 * 根据楼盘编号和城市编号查询娱乐设施最短距离对应维度信息
	 * 
	 * @param param
	 * @return
	 */
	public DimensionDataSet getDimensionDataSetByBuildingIdAndCityIdForEntertainmentDistance(
			Map<String, Object> param);
	
	/**
	 * 根据楼盘编号和城市编号查询最短距离娱乐设施数量对应维度信息
	 * 
	 * @param param
	 * @return
	 */
	public DimensionDataSet getDimensionDataSetByBuildingIdAndCityIdForEntertainmentCount(
			int count);
	
	/**
	 * 根据楼盘编号和城市编号查询商业设施最短距离对应维度信息
	 * 
	 * @param param
	 * @return
	 */
	public DimensionDataSet getDimensionDataSetByBuildingIdAndCityIdForBusinessDistance(
			Map<String, Object> param);
	
	/**
	 * 根据楼盘编号和城市编号查询最短距离商业设施数量对应维度信息
	 * 
	 * @param param
	 * @return
	 */
	public DimensionDataSet getDimensionDataSetByBuildingIdAndCityIdForBusinessCount(
			int count);
	
	/**
	 * 根据楼盘编号和城市编号查询周边环境最短距离对应维度信息
	 * 
	 * @param param
	 * @return
	 */
	public DimensionDataSet getDimensionDataSetByBuildingIdAndCityIdForEnvironmentDistance(
			Map<String, Object> param);
	
	/**
	 * 根据楼盘编号和城市编号查询最短距离周边环境数量对应维度信息
	 * 
	 * @param param
	 * @return
	 */
	public DimensionDataSet getDimensionDataSetByBuildingIdAndCityIdForEnvironmentCount(
			int count);
	
	/**
	 * 根据楼盘编号和城市编号查询不利因素最短距离对应维度信息
	 * 
	 * @param param
	 * @return
	 */
	public DimensionDataSet getDimensionDataSetByBuildingIdAndCityIdForBadFactorDistance(
			Map<String, Object> param);
	
	/**
	 * 根据楼盘编号和城市编号查询最短距离不利因素数量对应维度信息
	 * 
	 * @param param
	 * @return
	 */
	public DimensionDataSet getDimensionDataSetByBuildingIdAndCityIdForBadFactorCount(
			int count);
	
	/**
	 * 根据城市编号和维度编码查询分数
	 * @param param
	 * @return
	 */
	public int getScoreByCityIdAndCode(Map<String, Object> param);


}
