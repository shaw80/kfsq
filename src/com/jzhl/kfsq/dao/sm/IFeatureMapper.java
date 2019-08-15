package com.jzhl.kfsq.dao.sm;

import java.util.List;
import java.util.Map;

import com.jzhl.kfsq.dataset.sm.FeatureDataSet;
import com.jzhl.kfsq.entity.sm.Feature;

/**
 * 特色接口
 * 
 * @author chih
 *
 */
public interface IFeatureMapper {
	/**
	 * 查询特色接口
	 * 
	 * @author chih
	 *
	 */
	public List<Feature> findFeature();

	/**
	 * 特色列表
	 * 
	 * @author zhouzy
	 */
	public List<Feature> findFeatureList(Map<String, Object> map);

	/**
	 * 特色列表总数
	 * 
	 * @author zhouzy
	 */
	public int getFeatureDataCount(Map<String, Object> map);

	/**
	 * 参数设置-特色列表-编辑
	 * 
	 * @author zhouzy
	 */
	public void updateFeature(Feature feature);

	/**
	 * 参数设置-特色列表-新增
	 * 
	 * @author zhouzy
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
