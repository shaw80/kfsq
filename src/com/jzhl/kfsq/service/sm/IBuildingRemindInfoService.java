package com.jzhl.kfsq.service.sm;

import java.util.List;
import java.util.Map;

import com.jzhl.kfsq.entity.sm.BuildingRemindInfo;

/**
 * 楼盘提醒列表接口
 * 
 * @author zhouzy
 *
 */
public interface IBuildingRemindInfoService {

	/**
	 * 提醒列表
	 * 
	 * @return 提醒列表
	 */
	public List<BuildingRemindInfo> findBuildingRemindInfoList(Map<String, Object> map);

	/**
	 * 提醒列表总数
	 */
	public int getBuildingRemindInfoDataCount(Map<String, Object> map);

	/**
	 * 清空表数据
	 */
	public void deleteData();

	/**
	 * 插入数据
	 */
	public void insertData(BuildingRemindInfo buildingRemindInfo);

}
