package com.jzhl.kfsq.service.bm;

import com.jzhl.kfsq.dataset.bm.BuildingDetail;
import com.jzhl.kfsq.dataset.bm.BuildingInfoDataSet;
import com.jzhl.kfsq.dto.pm.IsVisitDto;

/**
 * 楼盘详情业务层接口
 * 
 * @author Shaw
 *
 */
public interface IBuildingDetailService {

	/**
	 * 根据楼盘编号查询楼盘详情
	 * 
	 * @param buildingId
	 * @return
	 */
	public BuildingDetail getBuildingDetail(IsVisitDto dto);

	/**
	 * 根据楼盘编号查询楼盘信息
	 * 
	 * @param buildingId
	 * @return
	 */
	public BuildingInfoDataSet getBuildingInfoDataSet(int buildingId);

}
