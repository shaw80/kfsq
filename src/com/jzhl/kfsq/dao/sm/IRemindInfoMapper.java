package com.jzhl.kfsq.dao.sm;

import java.util.List;
import java.util.Map;

import com.jzhl.kfsq.entity.sm.RemindInfo;

/**
 * 提醒列表接口
 * 
 * @author zhouzy
 *
 */
public interface IRemindInfoMapper {

	/**
	 * 提醒列表
	 */
	public List<RemindInfo> findRemindInfoList(Map<String, Object> map);

	/**
	 * 提醒列表总数
	 */
	public int getRemindInfoDataCount(Map<String, Object> map);

	/**
	 * 清空表数据
	 */
	public void deleteData();

	/**
	 * 插入数据
	 */
	public void insertData(RemindInfo remindInfo);

}
