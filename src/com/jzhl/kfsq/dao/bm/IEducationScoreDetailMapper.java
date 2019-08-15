package com.jzhl.kfsq.dao.bm;

import java.util.List;
import java.util.Map;

import com.jzhl.kfsq.dataset.bm.EducationScoreDataSet;
import com.jzhl.kfsq.dataset.bm.EducationScoreDetail;

/**
 * 教育分数详情数据访问层
 * 
 * @author mac
 *
 */
public interface IEducationScoreDetailMapper {

	/**
	 * 根据楼盘编号查询教育分数详情
	 * 
	 * @param buildingId
	 * @return
	 */
	public EducationScoreDetail getEducationScoreDetail(int buildingId);
	
	/**
	 * 根据楼盘编号和学校类型查询教育信息
	 * @param params
	 * @return
	 */
	public List<EducationScoreDataSet> findEducationDataSetByBuildingIdAndType(Map<String, Object> params);
	
	/**
	 * 根据楼盘编号查询优质学校信息
	 * @param params
	 * @return
	 */
	public List<EducationScoreDataSet> findHighQualitySchoolDataSetBybuildingId(Map<String, Object> params);
	
	/**
	 * 根据楼盘编号查询普通学校信息
	 * @param params
	 * @return
	 */
	public List<EducationScoreDataSet> findNormalSchoolDataSetBybuildingId(Map<String, Object> params);

}
