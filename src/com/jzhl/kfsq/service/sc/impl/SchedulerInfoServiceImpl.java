package com.jzhl.kfsq.service.sc.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jzhl.kfsq.dao.sc.ISchedulerInfoMapper;
import com.jzhl.kfsq.dto.sc.SchedulerDto;
import com.jzhl.kfsq.entity.sc.SchedulerInfo;
import com.jzhl.kfsq.service.sc.ISchedulerInfoService;

@Service
public class SchedulerInfoServiceImpl implements ISchedulerInfoService{
	
	@Autowired
	private ISchedulerInfoMapper schedulerInfoDao;
	
	@Override
	public List<SchedulerInfo> findSchedulerInfoToDo(SchedulerDto schedulerDto) {
		return schedulerInfoDao.findSchedulerInfoToDo(schedulerDto);
	}

	@Override
	public void updateSchedulerInfo(SchedulerInfo schedulerInfo) {
		schedulerInfoDao.updateSchedulerInfo(schedulerInfo);
	}

	@Override
	public List<SchedulerInfo> findSchedulerInfo(SchedulerInfo schedulerInfo) {
		return schedulerInfoDao.findSchedulerInfo(schedulerInfo);
	}
	
	@Override
	public void updateSchedulerInfoFinish(SchedulerInfo schedulerInfo) {
		schedulerInfoDao.updateSchedulerInfoFinish(schedulerInfo);
	}
}
