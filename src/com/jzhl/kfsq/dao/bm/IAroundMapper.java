package com.jzhl.kfsq.dao.bm;

import java.util.Map;

import com.jzhl.kfsq.dataset.bm.AroundDataSet;

/**
 * 楼盘详情周边配套数据访问层接口
 * 
 * @author Shaw
 *
 */
public interface IAroundMapper {

	/**
	 * 根据楼盘编号查询周边配套信息
	 * 
	 * @param buildingId
	 * @return
	 */
	public AroundDataSet getAroundDataSet(int buildingId);

	/**
	 * 根据楼盘编号和标签类型统计周边信息数量
	 * 
	 * @param map
	 * @return
	 */
	public int countParkFacilitiesByBuildingId(int buildingId);
	
	/**
	 * 根据楼盘编号和类型统计周边信息的个数
	 * @param param
	 * @return
	 */
	public int countAround(Map<String, Object> param);

}
