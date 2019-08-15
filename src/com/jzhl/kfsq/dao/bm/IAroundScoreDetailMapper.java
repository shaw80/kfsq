package com.jzhl.kfsq.dao.bm;

import java.util.List;
import java.util.Map;

import com.jzhl.kfsq.dataset.bm.AroundScoreDataSet;
import com.jzhl.kfsq.dataset.bm.AroundScoreDetail;

/**
 * 教育分数详情数据访问层
 * 
 * @author mac
 *
 */
public interface IAroundScoreDetailMapper {

	/**
	 * 根据楼盘编号查询教育分数详情
	 * 
	 * @param buildingId
	 * @return
	 */
	public AroundScoreDetail getAroundScoreDetail(int buildingId);
	
	/**
	 * 根据楼盘编号和周边信息类型查询周边信息
	 * @param params
	 * @return
	 */
	public List<AroundScoreDataSet> findAroundDataSetByBuildingIdAndType(Map<String, Object> params);
	
	/**
	 * 根据楼盘编号和环境标签查询周边信息
	 * @param params
	 * @return
	 */
	public List<AroundScoreDataSet> findAroundDataSetByBuildingIdAndTagType(Map<String, Object> params);

}
