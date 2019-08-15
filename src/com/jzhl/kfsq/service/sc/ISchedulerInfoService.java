package com.jzhl.kfsq.service.sc;

import java.util.List;

import com.jzhl.kfsq.dto.sc.SchedulerDto;
import com.jzhl.kfsq.entity.sc.SchedulerInfo;

public interface ISchedulerInfoService {

	/**
	 * 按条件查询定时任务配置
	 * @param schedulerInfo
	 * @return
	 */
	public List<SchedulerInfo> findSchedulerInfoToDo(SchedulerDto schedulerDto);

	/**
	 * 更新定时任务配置
	 * @param schedulerInfo
	 */
	public void updateSchedulerInfo(SchedulerInfo schedulerInfo);

	/**
	 * 查询定时任务配置
	 * @return
	 */
	public List<SchedulerInfo> findSchedulerInfo(SchedulerInfo schedulerInfo);

	/**
	 * 更新定时任务配置lastExecuteTime和finishExecuteTime
	 * @param schedulerInfo
	 */
	public void updateSchedulerInfoFinish(SchedulerInfo schedulerInfo);
	
}
