package com.jzhl.kfsq.service.bm;

import com.jzhl.kfsq.entity.bm.BuildingExtendContent;

/**
 * 楼盘扩展信息楼盘内容业务层接口
 * 
 * @author zhouzy
 *
 */
public interface IBuildingExtendContentService {

	/**
	 * 添加楼盘扩展信息楼盘内容
	 */
	public void insertBuildingExtendContent(BuildingExtendContent buildingExtendContent);

	/**
	 * 楼盘扩展信息楼盘内容详情编辑
	 */
	public void updateBuildingExtendContent(BuildingExtendContent buildingExtendContent);

}
