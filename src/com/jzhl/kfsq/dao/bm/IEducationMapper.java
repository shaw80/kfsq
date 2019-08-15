package com.jzhl.kfsq.dao.bm;

import java.util.Map;

/**
 * 教育数据访问层接口
 * 
 * @author Shaw
 *
 */
public interface IEducationMapper {

	/**
	 * 根据楼盘统计优质小学
	 * 
	 * @param buildingId
	 * @return
	 */
	public int countGreatPrimarySchool(int buildingId);

	/**
	 * 根据楼盘编号统计普通小学
	 * 
	 * @param buildingId
	 * @return
	 */
	public int countOrdinaryPrimarySchool(int buildingId);

	/**
	 * 根据楼盘编号和类型统计学校数量
	 * 
	 * @param params
	 * @return
	 */
	public int countSchool(Map<String, Object> params);

}
