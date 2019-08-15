package com.jzhl.kfsq.service.ba.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jzhl.kfsq.dao.ba.IBuildingQueryHistoryMapper;
import com.jzhl.kfsq.entity.ba.BuildingQueryHistory;
import com.jzhl.kfsq.service.ba.IBuildingQueryHistoryService;

@Service
public class BuildingQueryHistoryServiceImpl implements IBuildingQueryHistoryService {

	@Autowired
	private IBuildingQueryHistoryMapper buildingQueryHistoryDao;

	/**
	 * 添加检索条件数据
	 * 
	 * @author zhouzy
	 */
	@Override
	public void insertBuildingQueryHistory(BuildingQueryHistory buildingQueryHistory) {
		buildingQueryHistoryDao.insertBuildingQueryHistory(buildingQueryHistory);
	}

}
