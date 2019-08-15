package com.jzhl.kfsq.service.sm.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jzhl.kfsq.dao.sm.IRemindInfoMapper;
import com.jzhl.kfsq.entity.sm.RemindInfo;
import com.jzhl.kfsq.service.sm.IRemindInfoService;

/**
 * 提醒列表
 * 
 * @author zhouzy
 *
 */
@Service
public class RemindInfoServiceImpl implements IRemindInfoService {

	@Autowired
	private IRemindInfoMapper remindInfoDao;

	/**
	 * 提醒列表
	 */
	@Override
	public List<RemindInfo> findRemindInfoList(Map<String, Object> map) {
		List<RemindInfo> result = remindInfoDao.findRemindInfoList(map);
		return result;
	}

	/**
	 * 提醒列表总数
	 */
	@Override
	public int getRemindInfoDataCount(Map<String, Object> map) {
		int dataCount = remindInfoDao.getRemindInfoDataCount(map);
		return dataCount;
	}

	/**
	 * 清空表数据
	 */
	@Override
	public void deleteData() {
		remindInfoDao.deleteData();
	}

	/**
	 * 插入数据
	 */
	@Override
	public void insertData(RemindInfo remindInfo) {
		remindInfoDao.insertData(remindInfo);
	}

}
