package com.jzhl.kfsq.service.bm;

import java.util.Map;

import com.jzhl.kfsq.entity.bm.BuildingTag;

/**
 * 楼盘标签表
 * 
 * @author zhouzy
 *
 */
public interface IBuildingTagService {

	/**
	 * 根据楼盘ID删除楼盘ID关联标签列表
	 * 
	 */
	public void deleteTag(Map<String, Object> param);

	/**
	 * 新增楼盘ID关联标签
	 * 
	 */
	public void saveBuildingTag(BuildingTag buildingTag);

}
