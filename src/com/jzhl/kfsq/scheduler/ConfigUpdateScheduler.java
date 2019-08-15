package com.jzhl.kfsq.scheduler;


// import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ConfigUpdateScheduler {
	
//	@Scheduled(cron="0 0/3 * * * ?")
	public void reloadConfig() {
		System.out.println("Scheduler-------->OK");
	}

}
