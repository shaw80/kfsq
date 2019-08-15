package com.jzhl.kfsq.controller.sc;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jzhl.kfsq.common.base.ResponseBean;
import com.jzhl.kfsq.dto.sc.SchedulerDto;
import com.jzhl.kfsq.entity.sc.SchedulerInfo;
import com.jzhl.kfsq.service.sc.ISchedulerInfoService;

/**
 * 定时任务配置管理类
 * @author henan
 */
@Controller
public class SchedulerInfoController {
	
	private static final Logger logger = Logger.getLogger(SchedulerInfoController.class);
	
	@Autowired
	private ISchedulerInfoService schedulerInfoService;
	
	
	/**
	 * 仅供web端定时任务使用
	 * @param schedulerInfo
	 * @return
	 */
	@RequestMapping(value = "/serv/findSchedulerInfoToDo", method = RequestMethod.POST)
	@ResponseBody
	public synchronized ResponseBean<Map<String, Object>> findSchedulerInfoToDo(SchedulerDto schedulerDto) {
		logger.debug("[定时任务配置]--获取定时任务并更新时间");
		Map<String, Object> map = new HashMap<String, Object>();
		List<SchedulerInfo> dataList = schedulerInfoService.findSchedulerInfoToDo(schedulerDto);
		map.put("dataList", dataList);
		for(SchedulerInfo scInfo : dataList) {
			Date now = new Date();
			java.sql.Timestamp lastExecuteTime = new java.sql.Timestamp(now.getTime());
			SchedulerInfo schedulerInfo = new SchedulerInfo();
			schedulerInfo.setSchedulerId(scInfo.getSchedulerId());
			schedulerInfo.setLastExecuteTime(lastExecuteTime);
			schedulerInfo.setFinishExecuteTime(null);
			schedulerInfoService.updateSchedulerInfoFinish(schedulerInfo);
		}
		return new ResponseBean<Map<String, Object>>(map);
	}
	
	
	/**
	 * 获取定时任务配置
	 * @param schedulerInfo
	 * @return
	 */
	@RequestMapping(value = "/serv/findSchedulerInfo", method = RequestMethod.POST)
	@ResponseBody
	public synchronized ResponseBean<Map<String, Object>> findSchedulerInfo(SchedulerInfo schedulerInfo) {
		logger.debug("[定时任务配置]--获取定时任务配置");
		Map<String, Object> map = new HashMap<String, Object>();
		List<SchedulerInfo> dataList = schedulerInfoService.findSchedulerInfo(schedulerInfo);
		map.put("dataList", dataList);
		return new ResponseBean<Map<String, Object>>(map);
	}
	
	
	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "/serv/updateSchedulerInfo", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean updateSchedulerInfo(SchedulerInfo schedulerInfo) {
		logger.debug("[定时任务配置]--更新定时任务配置");
		schedulerInfoService.updateSchedulerInfo(schedulerInfo);
		return new ResponseBean();
	}
	
	
	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "/serv/updateSchedulerInfoFinish", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean updateSchedulerInfoFinish(SchedulerInfo schedulerInfo) {
		logger.debug("[定时任务配置]--更新定时任务配置--");
		schedulerInfo.setFinishExecuteTime(new Timestamp((new Date()).getTime()));
		schedulerInfoService.updateSchedulerInfoFinish(schedulerInfo);
		return new ResponseBean();
	}

}
