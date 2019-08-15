package com.jzhl.kfsq.service.bm;

import java.util.List;

import com.jzhl.kfsq.dataset.bm.BuildingTempInfoDataSet;
import com.jzhl.kfsq.entity.bm.BuildingFeatureTemp;
import com.jzhl.kfsq.entity.bm.BuildingTemp;
import com.jzhl.kfsq.entity.bm.UnitMapTemp;

public interface IBuildingTempService {

	/**
	 * 保存楼盘信息数据(BM_BuildingTemp表)
	 * @param buildingTempDto
	 */
	public BuildingTemp insertBuildingTemp(BuildingTemp buildingTemp);
	
	/**
	 * 更新楼盘信息
	 * @param buildingTemp
	 */
	public void updateBuildingTemp(BuildingTemp buildingTemp);
	
	/**
	 * 将楼盘信息设为无效
	 * @param buildingIds
	 */
	public void updateBuildingTempInValid(String[] buildingIds);
	
	/**
	 * 保存楼盘特色数据(BM_BuildingFeatureTemp表)
	 * @param buildingTempDto
	 */
	public void insertBuildingFeatureTemp(BuildingFeatureTemp buildingTempDto);
	
	/**
	 * 更新楼盘特色数据(BM_BuildingFeatureTemp表)
	 * @param buildingTempDto
	 */
	public void updateBuildingFeatureTemp(BuildingFeatureTemp buildingTempDto);
	
	/**
	 * 将特色信息设为无效
	 * @param featureIds
	 */
	public void updateBuildingFeatureTempInValid(String[] featureIds);

	/**
	 * 保存户型图数据(BM_UnitMapTemp表)
	 * @param unitMapTemp
	 */
	public void insertUnitMapTemp(UnitMapTemp unitMapTemp);
	
	/**
	 * 更新户型图数据(BM_UnitMapTemp表)
	 * @param unitMapTemp
	 */
	public void updateUnitMapTemp(UnitMapTemp unitMapTemp);

	/**
	 * 设置户型图为无效
	 * @param unitMapIds
	 */
	public void updateUnitMapTempInValid(String[] unitMapIds);
	
	/**
	 * 按条件查询楼盘详情列表
	 * @param cityId
	 * @return
	 */
	public List<BuildingTempInfoDataSet> findBuildingTempInfo(BuildingTemp buildingTemp);

	/**
	 * 更改楼盘信息状态为已同步
	 * @param buildingId
	 */
	public void updateBuildingInfoSynchronized(Integer buildingId);

	/**
	 * 按条件查询楼盘数量
	 * @param cityId
	 * @return
	 */
	public int getBuildingTempCount(BuildingTemp buildingTemp);

}
