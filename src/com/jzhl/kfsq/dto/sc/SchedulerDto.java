package com.jzhl.kfsq.dto.sc;

import java.io.Serializable;

public class SchedulerDto implements Serializable {
	private static final long serialVersionUID = -2105676994698946315L;
	private java.lang.String className; // 定时任务名称
	private java.lang.String isScheduler = "1"; // 是否是定时任务，1是，0否
	public java.lang.String getClassName() {
		return className;
	}
	public void setClassName(java.lang.String className) {
		this.className = className;
	}
	public java.lang.String getIsScheduler() {
		return isScheduler;
	}
	public void setIsScheduler(java.lang.String isScheduler) {
		this.isScheduler = isScheduler;
	}
}
