package com.jzhl.kfsq.dao.bm;

import java.util.List;

import com.jzhl.kfsq.dataset.sm.BuildingStatisticalDataSet;
import com.jzhl.kfsq.dto.bm.BuildingAreaDto;
import com.jzhl.kfsq.dto.bm.BuildingDto;

public interface IBuildingAreaDtoMapper {

	public List<BuildingAreaDto> findBuildingAreaDto(BuildingAreaDto buildingAreaDto);

	/**
	 * 按照月份分组统计楼盘数量
	 * 
	 * @author zhouzy
	 */
	public List<BuildingStatisticalDataSet> findBuildingStatistical(BuildingDto buildingDto);

	/**
	 * 按照月份分组统计已充值楼盘数量；
	 * 
	 * @author zhouzy 20160120;
	 * @param
	 * @return ResponseBean
	 */
	public int getRechargeBuildingNum(BuildingDto buildingDto);

}
