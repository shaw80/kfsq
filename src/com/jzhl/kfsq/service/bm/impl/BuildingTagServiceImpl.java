package com.jzhl.kfsq.service.bm.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jzhl.kfsq.dao.bm.IBuildingTagMapper;
import com.jzhl.kfsq.entity.bm.BuildingTag;
import com.jzhl.kfsq.service.bm.IBuildingTagService;

/**
 * 标签管理
 * 
 * @author zhouzy
 *
 */
@Service
public class BuildingTagServiceImpl implements IBuildingTagService {

	@Autowired
	private IBuildingTagMapper buildingTagDao;

	/**
	 * 根据楼盘ID删除楼盘ID关联标签列表
	 * 
	 */
	@Override
	public void deleteTag(Map<String, Object> param) {
		buildingTagDao.deleteTag(param);
	}

	/**
	 * 新增楼盘ID关联标签
	 * 
	 */
	@Override
	public void saveBuildingTag(BuildingTag buildingTag) {
		buildingTagDao.saveBuildingTag(buildingTag);
	}

}
