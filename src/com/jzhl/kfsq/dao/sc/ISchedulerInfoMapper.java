package com.jzhl.kfsq.dao.sc;

import java.util.List;

import com.jzhl.kfsq.dto.sc.SchedulerDto;
import com.jzhl.kfsq.entity.sc.SchedulerInfo;

public interface ISchedulerInfoMapper {
	
	public List<SchedulerInfo> findSchedulerInfoToDo(SchedulerDto schedulerDto);

	public void updateSchedulerInfo(SchedulerInfo schedulerInfo);

	public List<SchedulerInfo> findSchedulerInfo(SchedulerInfo schedulerInfo);
	
	public void updateSchedulerInfoFinish(SchedulerInfo schedulerInfo);
	
}
