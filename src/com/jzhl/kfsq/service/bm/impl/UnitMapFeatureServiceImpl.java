package com.jzhl.kfsq.service.bm.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jzhl.kfsq.dao.bm.IUnitMapFeatureMapper;
import com.jzhl.kfsq.entity.sm.UnitMapFeature;
import com.jzhl.kfsq.service.bm.IUnitMapFeatureService;

/**
 * 户型标签表管理
 * 
 * @author zhouzy
 *
 */
@Service
public class UnitMapFeatureServiceImpl implements IUnitMapFeatureService {

	@Autowired
	private IUnitMapFeatureMapper unitMapFeatureDao;

	/**
	 * 根据户型ID删除对应数据列表
	 * 
	 */
	@Override
	public void deleteUnitMapFeature(Map<String, Object> map) {
		unitMapFeatureDao.deleteUnitMapFeature(map);
	}

	/**
	 * 保存数据
	 * 
	 */
	@Override
	public void saveUnitMapFeature(UnitMapFeature unitMapFeature) {
		unitMapFeatureDao.saveUnitMapFeature(unitMapFeature);
	}

}
