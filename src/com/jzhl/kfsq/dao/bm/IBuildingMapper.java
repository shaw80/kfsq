package com.jzhl.kfsq.dao.bm;

import java.util.List;
import java.util.Map;

import com.jzhl.kfsq.dataset.bm.BuildingDataSet;
import com.jzhl.kfsq.dataset.bm.BuildingInfo;
import com.jzhl.kfsq.dataset.bm.BuildingMsgDataSet;
import com.jzhl.kfsq.dataset.bm.RecommendBuildingsV3DataSet;
import com.jzhl.kfsq.entity.bm.Building;

public interface IBuildingMapper {

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
	 * 根据代理商userid保存楼盘信息
	 * 
	 * @author chih
	 */
	public int insert(Building building);

	/**
	 * 根据楼盘id修改楼盘信息
	 * 
	 * @author chih
	 */
	public void update(Building building);

	/**
	 * 查询楼盘信息列表
	 * 
	 * @author chih
	 */
	public List<BuildingMsgDataSet> findMsgBuildingList(Map<String, Object> map);

	/**
	 * 查询楼盘信息总数分页用
	 * 
	 * @author chih
	 */
	public int findMsgBuildingListCount(Map<String, Object> map);

	/**
	 * 查询楼盘信息详情
	 * 
	 * @author chih
	 */
	public BuildingMsgDataSet getBuildingMsg(Building building);

	/**
	 * 修改楼盘信息详情
	 * 
	 * @author chih
	 */
	public void updateBuildingMsg(Building building);

	/**
	 * 禁用楼盘
	 * 
	 * @param building
	 */
	public void inVaild(Building building);

	/**
	 * 根据条件查询楼盘信息
	 * 
	 * @param building
	 * @return
	 */
	public List<Building> find(Building building);

	/**
	 * 根据代理商userid查询其下楼盘列表;从楼盘列表中过滤掉已经添加过的楼盘，用于添加楼盘营销总监用，因为一个楼盘只有一个营销总监；
	 */
	public List<BuildingDataSet> findNewBuildingList(Map<String, Object> map);

	/**
	 * 根据营销总监userId查询buildingInfo信息，包含楼盘名称和楼盘余额
	 * 
	 * @param userId
	 * @return
	 */
	public BuildingInfo getBuildingInfo(int userId);

	/**
	 * 根据编号查询楼盘
	 * 
	 * @param buildingId
	 * @return
	 */
	public Building getBuildingByBuildingId(int buildingId);

	/**
	 * 同地段的4个推荐楼盘
	 * 
	 * @param buildingId
	 * @return
	 */
	public List<RecommendBuildingsV3DataSet> findRecommendBuildingsV3DataSetByArea(
			int buildingId);
	
	/**
	 * 同价位的4个推荐楼盘
	 * 
	 * @param buildingId
	 * @return
	 */
	public List<RecommendBuildingsV3DataSet> findRecommendBuildingsV3DataSetByPrice(
			int buildingId);
	
	/**
	 * 同特色的4个推荐楼盘
	 * 
	 * @param buildingId
	 * @return
	 */
	public List<RecommendBuildingsV3DataSet> findRecommendBuildingsV3DataSetByTag(
			int buildingId);
	
	/**
	 * 根据分站编号查询楼盘
	 * @param branchId
	 * @return
	 */
	public List<Building> findBuildingByBranchId(int branchId);
}
