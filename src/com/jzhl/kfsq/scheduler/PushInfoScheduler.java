package com.jzhl.kfsq.scheduler;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.jzhl.kfsq.service.pm.IPlanService;
import com.jzhl.kfsq.service.sm.IPushInfoService;

@Component
public class PushInfoScheduler {

	Logger log = Logger.getLogger(PushInfoScheduler.class);

	@Autowired
	private IPushInfoService pushInfoService;

	@Autowired
	private IPlanService planService;

	@Scheduled(cron = "0 0/7 * * * ?")
	public void pushInfoScheduler() {
		log.debug("*****推送定时器检查定时发送任务 开始*****");
		long start = System.currentTimeMillis();
		long count = pushInfoService.timingPush();
		long end = System.currentTimeMillis();
		log.debug("*****推送定时器检查定时发送任务 结束*****");
		log.debug("*****推送定时器检查定时发送任务 发送了【" + count + "】条数据，耗时【" + (end - start) + "】毫秒*****");
	}

	// "0 0 21 * * ?"情况3:按看房规划日期，提示用户有楼盘要看。(日期前一天晚9点提醒)
	@Scheduled(cron = "0 0 21 * * ?")
	public void planScheduler() {
		log.debug("*****提示用户有楼盘要看 开始*****");
		long start = System.currentTimeMillis();
		long count = planService.planPush();
		long end = System.currentTimeMillis();
		log.debug("*****提示用户有楼盘要看 结束*****");
		log.debug("*****提示用户有楼盘要看 发送了【" + count + "】条数据，耗时【" + (end - start) + "】毫秒*****");
	}
}
