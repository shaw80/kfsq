package com.jzhl.kfsq.service.sm;

import java.util.List;
import java.util.Map;

import com.jzhl.kfsq.dataset.sm.FeatureDataSet;
import com.jzhl.kfsq.entity.sm.Feature;

/**
 * 特色对外接口类
 * 
 * @author zhouzy
 *
 */
public interface IFeatureService {

	/**
	 * 特色列表
	 */
	public List<Feature> findFeatureList(Map<String, Object> map);

	/**
	 * 特色列表总数
	 */
	public int getFeatureDataCount(Map<String, Object> map);

	/**
	 * 参数设置-特色列表-编辑
	 */
	public void updateFeature(Feature feature);

	/**
	 * 参数设置-特色-新增
	 */
	public void insertFeature(Feature feature);

	/**
	 * 查询所有特色
	 * 
	 * @return
	 */
	public List<Feature> findAllFeature();

	/**
	 * 查询特色结果集
	 * 
	 * @return
	 */
	public List<FeatureDataSet> findFeatureDataSet();

}
