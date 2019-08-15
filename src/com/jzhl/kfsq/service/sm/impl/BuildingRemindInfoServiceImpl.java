package com.jzhl.kfsq.service.sm.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jzhl.kfsq.dao.sm.IBuildingRemindInfoMapper;
import com.jzhl.kfsq.entity.sm.BuildingRemindInfo;
import com.jzhl.kfsq.service.sm.IBuildingRemindInfoService;

/**
 * 楼盘提醒列表
 * 
 * @author zhouzy
 *
 */
@Service
public class BuildingRemindInfoServiceImpl implements IBuildingRemindInfoService {

	@Autowired
	private IBuildingRemindInfoMapper buildingRemindInfoDao;

	/**
	 * 提醒列表
	 */
	@Override
	public List<BuildingRemindInfo> findBuildingRemindInfoList(Map<String, Object> map) {
		List<BuildingRemindInfo> result = buildingRemindInfoDao.findBuildingRemindInfoList(map);
		return result;
	}

	/**
	 * 提醒列表总数
	 */
	@Override
	public int getBuildingRemindInfoDataCount(Map<String, Object> map) {
		int dataCount = buildingRemindInfoDao.getBuildingRemindInfoDataCount(map);
		return dataCount;
	}

	/**
	 * 清空表数据
	 */
	@Override
	public void deleteData() {
		buildingRemindInfoDao.deleteData();
	}

	/**
	 * 插入数据
	 */
	@Override
	public void insertData(BuildingRemindInfo BuildingRemindInfo) {
		buildingRemindInfoDao.insertData(BuildingRemindInfo);
	}

}
