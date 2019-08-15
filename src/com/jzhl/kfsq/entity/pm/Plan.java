package com.jzhl.kfsq.entity.pm;

public class Plan {
	private java.lang.String planId; // 计划编号，主键
	private java.lang.Integer buildingId; // 楼盘编号，外键
	private java.lang.String status; // 看房状态（0：默认未看房，1：已看房未评论，2：已看房已评论）
	private java.util.Date appointmentTime; // 预约看房时间
	private java.lang.Integer creatorUserId; // 创建者：记录用户的创建人员的名称。
	private java.util.Date createTime; // 数据创建时间
	private java.lang.Integer updateUserId; //
	private java.util.Date updateTime; //
	private java.lang.Integer isValid; // 0：无效，1：有效
	private String[] planIdList; // 批量操作时使用
	private java.lang.String isValidParam; // 做查询条件
	
	public Plan() {
		
	}

	public java.lang.String getPlanId() {
		return planId;
	}

	public void setPlanId(java.lang.String planId) {
		this.planId = planId;
	}

	public java.lang.Integer getBuildingId() {
		return buildingId;
	}

	public void setBuildingId(java.lang.Integer buildingId) {
		this.buildingId = buildingId;
	}

	public java.lang.String getStatus() {
		return status;
	}

	public void setStatus(java.lang.String status) {
		this.status = status;
	}

	public java.util.Date getAppointmentTime() {
		return appointmentTime;
	}

	public void setAppointmentTime(java.util.Date appointmentTime) {
		this.appointmentTime = appointmentTime;
	}

	public java.lang.Integer getCreatorUserId() {
		return creatorUserId;
	}

	public void setCreatorUserId(java.lang.Integer creatorUserId) {
		this.creatorUserId = creatorUserId;
	}

	public java.util.Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(java.util.Date createTime) {
		this.createTime = createTime;
	}

	public java.lang.Integer getUpdateUserId() {
		return updateUserId;
	}

	public void setUpdateUserId(java.lang.Integer updateUserId) {
		this.updateUserId = updateUserId;
	}

	public java.util.Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(java.util.Date updateTime) {
		this.updateTime = updateTime;
	}

	public java.lang.Integer getIsValid() {
		return isValid;
	}

	public void setIsValid(java.lang.Integer isValid) {
		this.isValid = isValid;
	}

	public String[] getPlanIdList() {
		return planIdList;
	}

	public void setPlanIdList(String[] planIdList) {
		this.planIdList = planIdList;
	}

	public java.lang.String getIsValidParam() {
		return isValidParam;
	}

	public void setIsValidParam(java.lang.String isValidParam) {
		this.isValidParam = isValidParam;
	}
	
}
