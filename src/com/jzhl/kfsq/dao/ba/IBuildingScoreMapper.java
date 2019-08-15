package com.jzhl.kfsq.dao.ba;

import com.jzhl.kfsq.entity.ba.BuildingScore;

/**
 * 楼盘分数数据访问层接口
 * 
 * @author Shaw
 *
 */
public interface IBuildingScoreMapper {

	/**
	 * 根据楼盘编号查询楼盘评分
	 * 
	 * @param buildingId
	 * @return
	 */
	public BuildingScore getBuildingScoreByBuildingId(int buildingId);
	
	/**
	 * 保存评分信息
	 * @param sbs
	 */
	public void insertBuildingScore(BuildingScore bs);
	
	/**
	 * 更新评分
	 * @param bs
	 */
	public void updateBuildingScore(BuildingScore bs);

}
