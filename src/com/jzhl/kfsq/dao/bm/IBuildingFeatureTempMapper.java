package com.jzhl.kfsq.dao.bm;

import java.util.List;
import java.util.Map;

import com.jzhl.kfsq.entity.bm.BuildingFeatureTemp;

public interface IBuildingFeatureTempMapper {

	public void insertBuildingFeatureTemp(BuildingFeatureTemp buildingFeatureTemp);
	
	public List<BuildingFeatureTemp> findBuildingFeatureTemp(BuildingFeatureTemp buildingFeatureTemp);
	
	public void updateBuildingFeatureTemp(BuildingFeatureTemp buildingFeatureTemp);

	public void updateBuildingFeatureTempInValid(Map<String, Object> map);
	
	public void updateBuildingFeatureTempSynchronized(Integer buildingId);

}
