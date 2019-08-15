package com.jzhl.kfsq.entity.sc;

import java.io.Serializable;

public class SchedulerInfo implements Serializable {
	private static final long serialVersionUID = -213105167909836617L;
	private java.lang.Integer schedulerId; // 定时任务编号
	private java.lang.String schedulerName; // 定时任务名称
	private java.lang.String className; // 定时任务名称
	private java.lang.Integer timeInterval; // 执行时间间隔(单位:小时)
	private java.sql.Timestamp lastExecuteTime; // “定时”任务最后执行时间
	private java.sql.Timestamp finishExecuteTime; // 执行完成时间
	private java.lang.Integer creatorUserId; // 创建者：记录用户的创建人员的ID。
	private java.sql.Timestamp createTime; // 创建时间：记录用户的创建时间。
	private java.lang.Integer updateUserId; // 更新者：记录用户的更新人员的ID。
	private java.sql.Timestamp updateTime; // 数据更新时间
	private java.lang.Short isValid; //0：无效，1：有效
	public java.lang.Integer getSchedulerId() {
		return schedulerId;
	}
	public void setSchedulerId(java.lang.Integer schedulerId) {
		this.schedulerId = schedulerId;
	}
	public java.lang.String getSchedulerName() {
		return schedulerName;
	}
	public void setSchedulerName(java.lang.String schedulerName) {
		this.schedulerName = schedulerName;
	}
	public java.lang.String getClassName() {
		return className;
	}
	public void setClassName(java.lang.String className) {
		this.className = className;
	}
	public java.lang.Integer getTimeInterval() {
		return timeInterval;
	}
	public void setTimeInterval(java.lang.Integer timeInterval) {
		this.timeInterval = timeInterval;
	}
	public java.sql.Timestamp getLastExecuteTime() {
		return lastExecuteTime;
	}
	public void setLastExecuteTime(java.sql.Timestamp lastExecuteTime) {
		this.lastExecuteTime = lastExecuteTime;
	}
	public java.lang.Integer getCreatorUserId() {
		return creatorUserId;
	}
	public void setCreatorUserId(java.lang.Integer creatorUserId) {
		this.creatorUserId = creatorUserId;
	}
	public java.sql.Timestamp getCreateTime() {
		return createTime;
	}
	public void setCreateTime(java.sql.Timestamp createTime) {
		this.createTime = createTime;
	}
	public java.lang.Integer getUpdateUserId() {
		return updateUserId;
	}
	public void setUpdateUserId(java.lang.Integer updateUserId) {
		this.updateUserId = updateUserId;
	}
	public java.sql.Timestamp getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(java.sql.Timestamp updateTime) {
		this.updateTime = updateTime;
	}
	public java.lang.Short getIsValid() {
		return isValid;
	}
	public void setIsValid(java.lang.Short isValid) {
		this.isValid = isValid;
	}
	public java.sql.Timestamp getFinishExecuteTime() {
		return finishExecuteTime;
	}
	public void setFinishExecuteTime(java.sql.Timestamp finishExecuteTime) {
		this.finishExecuteTime = finishExecuteTime;
	}
	@Override
	public String toString() {
		return "SchedulerInfo [schedulerId=" + schedulerId + ", schedulerName="
				+ schedulerName + ", className=" + className
				+ ", timeInterval=" + timeInterval + ", lastExecuteTime="
				+ lastExecuteTime + ", finishExecuteTime=" + finishExecuteTime
				+ ", creatorUserId=" + creatorUserId + ", createTime="
				+ createTime + ", updateUserId=" + updateUserId
				+ ", updateTime=" + updateTime + ", isValid=" + isValid + "]";
	}
	
}
