package com.jzhl.kfsq.service.bm;

import java.util.Map;

import com.jzhl.kfsq.entity.sm.UnitMapFeature;

/**
 * 户型标签表
 * 
 * @author zhouzy
 *
 */
public interface IUnitMapFeatureService {

	/**
	 * 根据户型ID删除对应数据列表
	 * 
	 */
	public void deleteUnitMapFeature(Map<String, Object> map);

	/**
	 * 保存数据
	 * 
	 */
	public void saveUnitMapFeature(UnitMapFeature unitMapFeature);

}
