package com.jzhl.kfsq.service.bm.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jzhl.kfsq.dao.bm.IBuildingExtendContentMapper;
import com.jzhl.kfsq.entity.bm.BuildingExtendContent;
import com.jzhl.kfsq.service.bm.IBuildingExtendContentService;

/**
 * 楼盘扩展信息楼盘内容业务层接口
 * 
 * @author zhouzy
 *
 */
@Service
public class BuildingExtendContentServiceImpl implements IBuildingExtendContentService {

	@Autowired
	private IBuildingExtendContentMapper buildingExtendContentDto;

	/**
	 * 添加楼盘扩展信息楼盘内容
	 */
	@Override
	public void insertBuildingExtendContent(BuildingExtendContent buildingExtendContent) {
		buildingExtendContentDto.insertBuildingExtendContent(buildingExtendContent);
	}

	/**
	 * 楼盘扩展信息楼盘内容详情编辑
	 */
	@Override
	public void updateBuildingExtendContent(BuildingExtendContent buildingExtendContent) {
		buildingExtendContentDto.updateBuildingExtendContent(buildingExtendContent);
	}

}
