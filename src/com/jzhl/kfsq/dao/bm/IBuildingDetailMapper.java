package com.jzhl.kfsq.dao.bm;

import com.jzhl.kfsq.dataset.bm.BuildingDetail;
import com.jzhl.kfsq.dataset.bm.BuildingInfoDataSet;

/**
 * 楼盘详情数据访问层接口
 * 
 * @author Shaw
 *
 */
public interface IBuildingDetailMapper {

	/**
	 * 根据楼盘编号查询楼盘详情
	 * 
	 * @param buildingId
	 * @return
	 */
	public BuildingDetail getBuildingDetail(int buildingId);

	/**
	 * 根据楼盘编号查询楼盘信息
	 * 
	 * @param buildingId
	 * @return
	 */
	public BuildingInfoDataSet getBuildingInfoDataSet(int buildingId);

}
