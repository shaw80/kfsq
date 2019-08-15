package com.jzhl.kfsq.dao.bm;

import java.util.List;

import com.jzhl.kfsq.dataset.bm.BuildingFeatureMsgDataSet;
import com.jzhl.kfsq.dto.bm.BuildingFeatureDto;


public interface IBuildingFeatureDtoMapper {
	
	public List<BuildingFeatureDto> findBuildingFeatureDto(BuildingFeatureDto buildingFeatureDto);
	
	public List<BuildingFeatureMsgDataSet> findBuildingFeatureMsgDataSet(Integer buildingId);

}
