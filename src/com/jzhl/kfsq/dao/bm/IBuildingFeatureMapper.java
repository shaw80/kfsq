package com.jzhl.kfsq.dao.bm;

import java.util.List;

import com.jzhl.kfsq.dataset.bm.BuildingFeatureDataSet;
import com.jzhl.kfsq.entity.bm.BuildingFeature;

public interface IBuildingFeatureMapper {
	/**
	 * 添加楼盘特色
	 * 
	 * @author chih
	 */
	public void insert(BuildingFeature buildingfeature);
	/**
	 * 查询楼盘特色
	 * 
	 * @author chih
	 */
	public List<BuildingFeatureDataSet> getBuildingFeature(BuildingFeature buildingfeature);
	
	/**
	 * 删除楼盘特色
	 * 
	 * @author chih
	 */
	public void delete(BuildingFeature buildingfeature);
	
	/**
	 * 禁用楼盘特色关系
	 * @param buildingFeature
	 */
	public void inValid(BuildingFeature buildingFeature);
	
	/**
	 * 禁用楼盘特色关系
	 * @param buildingFeature
	 * @return
	 */
	public List<BuildingFeature> findBuildingFeature(BuildingFeature buildingFeature);
}
