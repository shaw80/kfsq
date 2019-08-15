package com.jzhl.kfsq.scheduler;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.jzhl.kfsq.service.sm.IMarkingService;

/**
 * 楼盘评分定时任务
 * 
 * @author Shaw
 *
 */
@Component
public class BuildingScoreScheduler {
	
	Logger log = Logger.getLogger(BuildingScoreScheduler.class);
	
	@Autowired
	private IMarkingService markingService;
	
	// 设置系统评分计算，在每天23：00开始运行
//	@Scheduled(cron = "0 0 23 * * ?")
	public void planScheduler() throws Exception {
		log.debug("*****计算系统评分开始*****");
		long start = System.currentTimeMillis();
		markingService.sumScore();
		long end = System.currentTimeMillis();
		log.debug("*****计算系统评分结束*****");
		log.debug("*****计算系统评分共耗时【" + (end - start) + "】毫秒*****");
	}

}
