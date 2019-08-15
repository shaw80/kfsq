package com.jzhl.kfsq.scheduler;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.jzhl.kfsq.service.sm.IBranchService;

@Component
public class RemindInfoScheduler {

	Logger log = Logger.getLogger(RemindInfoScheduler.class);

	@Autowired
	private IBranchService ibranchService;

	// admin端，代理商余额提醒；每天半夜1：15执行
	@Scheduled(cron = "0 15 1 ? * *")
	public void remindInfoScheduler() {
		log.info("*****代理商余额提醒任务插入数据开始*****");
		long start = System.currentTimeMillis();
		long count = ibranchService.remindInfoInsert();
		long end = System.currentTimeMillis();
		log.info("*****代理商余额提醒任务插入数据结束*****");
		log.info("*****代理商余额提醒任务插入了【" + count + "】条数据，耗时【" + (end - start) + "】毫秒*****");
	}

	// 代理商端，楼盘余额提醒；每天半夜 2：15执行
	@Scheduled(cron = "0 15 2 ? * *")
	public void buildingRemindInfoScheduler() {
		log.info("*****楼盘余额提醒任务插入数据开始*****");
		long start = System.currentTimeMillis();
		long count = ibranchService.buildingRemindInfoInsert();
		long end = System.currentTimeMillis();
		log.info("*****楼盘余额提醒任务插入数据结束*****");
		log.info("*****楼盘余额提醒任务插入了【" + count + "】条数据，耗时【" + (end - start) + "】毫秒*****");
	}
}
