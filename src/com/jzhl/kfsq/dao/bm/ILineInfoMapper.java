package com.jzhl.kfsq.dao.bm;

import java.util.List;
import java.util.Map;

import com.jzhl.kfsq.dataset.bm.Station;

/**
 * 线路表数据访问层接口
 * 
 * @author Shaw
 *
 */
public interface ILineInfoMapper {
	
	/**
	 * 根据楼盘编号查询公交的最短距离
	 * @param buildingId
	 * @return
	 */
	public Integer getBusMinDistance(int buildingId);
	
	/**
	 * 根据楼盘编号、最短距离和最大距离统计公交的数量
	 * @param param
	 * @return
	 */
	public int countBusByBuildIdAndBeginAndEnd(Map<String, Object> param);

	/**
	 * 根据楼盘编号查询轨道交通工具的最短距离
	 * @param buildingId
	 * @return
	 */
	public Integer getTrackMinDistance(int buildingId);
	
	/**
	 * 根据楼盘编号、最短距离和最大距离统计轨道交通工具的数量
	 * @param param
	 * @return
	 */
	public int countLineByBuildIdAndBeginAndEnd(Map<String, Object> param);
	
	/**
	 * 根据楼盘编号、交通工具类型和距离查询站点信息
	 * @param param
	 * @return
	 */
	public List<Station> findStationByBuildingIdAndTypeAndDistance(Map<String, Object> param);

}
