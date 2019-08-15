package com.jzhl.kfsq.dao.bm;

import java.util.List;
import java.util.Map;

import com.jzhl.kfsq.entity.bm.BuildingTemp;

public interface IBuildingTempMapper {

	public void insertBuildingTemp(BuildingTemp buildingTemp);
	
	public List<BuildingTemp> findBuildingTemp(BuildingTemp buildingTemp);

	public void updateBuildingTemp(BuildingTemp buildingTemp);
	
	public void updateBuildingTempInValid(Map<String, Object> map);
	
	public void updateBuildingTempSynchronized(Integer buildingId);

	public int getBuildingTempCount(BuildingTemp buildingTemp);
	
}
