package com.jzhl.kfsq.dao.bm;

import java.util.List;
import java.util.Map;

import com.jzhl.kfsq.dataset.bm.TrafficDataSet;
import com.jzhl.kfsq.dataset.bm.TrafficScoreDetail;

/**
 * 交通分数详情数据访问层
 * 
 * @author Shaw
 *
 */
public interface ITrafficScoreDetailMapper {

	/**
	 * 根据楼盘编号查询交通分数详情
	 * 
	 * @param buildingId
	 * @return
	 */
	public TrafficScoreDetail getTrafficScoreDetail(int buildingId);

	/**
	 * 根据楼盘编号和交通工具类型查询交通信息
	 * 
	 * @param params
	 * @return
	 */
	public List<TrafficDataSet> findTrafficDataSetByBuildingIdAndType(
			Map<String, Object> params);

	/**
	 * 根据楼盘编号和类型统计交通工具数量
	 * 
	 * @param params
	 * @return
	 */
	public int countTrafficByBuildingIdAndType(Map<String, Object> params);

}
