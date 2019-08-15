package com.jzhl.kfsq.dao.bm;

import java.util.Map;

import com.jzhl.kfsq.entity.sm.UnitMapFeature;

public interface IUnitMapFeatureMapper {

	/**
	 * 根据户型ID删除对应数据列表
	 * 
	 * @author zhouzy
	 * 
	 */
	public void deleteUnitMapFeature(Map<String, Object> map);

	/**
	 * 保存数据
	 * 
	 */
	public void saveUnitMapFeature(UnitMapFeature unitMapFeature);
}
