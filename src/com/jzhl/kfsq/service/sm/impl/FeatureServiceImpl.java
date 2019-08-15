package com.jzhl.kfsq.service.sm.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jzhl.kfsq.dao.sm.IFeatureMapper;
import com.jzhl.kfsq.dataset.sm.FeatureDataSet;
import com.jzhl.kfsq.entity.sm.Feature;
import com.jzhl.kfsq.service.sm.IFeatureService;

/**
 * 特色对外接口类
 * 
 * @author zhouzy
 *
 */
@Service
public class FeatureServiceImpl implements IFeatureService {

	@Autowired
	private IFeatureMapper featureDao;

	/**
	 * 特色列表
	 */
	@Override
	public List<Feature> findFeatureList(Map<String, Object> map) {
		List<Feature> result = featureDao.findFeatureList(map);
		return result;
	}

	/**
	 * 特色列表总数
	 */
	@Override
	public int getFeatureDataCount(Map<String, Object> map) {
		int dataCount = featureDao.getFeatureDataCount(map);
		return dataCount;
	}

	/**
	 * 参数设置-特色列表-编辑
	 */
	@Override
	public void updateFeature(Feature feature) {
		featureDao.updateFeature(feature);
	}

	/**
	 * 参数设置-特色-新增
	 */
	@Override
	public void insertFeature(Feature feature) {
		featureDao.insertFeature(feature);
	}

	/**
	 * 查询所有特色
	 */
	@Override
	public List<Feature> findAllFeature() {
		return featureDao.findAllFeature();
	}

	/**
	 * 查询特色结果集
	 */
	@Override
	public List<FeatureDataSet> findFeatureDataSet() {
		List<FeatureDataSet> result = featureDao.findFeatureDataSet();
		return result;
	}
}
