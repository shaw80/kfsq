package com.jzhl.kfsq.dataset.pm;

public class PlanDataSet {

	private java.lang.Integer planId;
	private java.lang.Integer buildingId; // 楼盘编号，外键
	private java.util.Date appointmentTime; // 预约看房时间
	private java.lang.Integer creatorUserId; // 创建者：记录用户的创建人员的名称。
	private java.util.Date createTime; // 数据创建时间
	private java.lang.Integer updateUserId; //
	private java.util.Date updateTime; //
	private java.lang.Integer isValid; // 0：无效，1：有效
	private java.lang.String planStatus;
	private java.math.BigDecimal scancodePrice;
	private java.lang.String phone; // 创建用户电话号

	public java.lang.Integer getPlanId() {
		return planId;
	}

	public void setPlanId(java.lang.Integer planId) {
		this.planId = planId;
	}

	public java.lang.Integer getBuildingId() {
		return buildingId;
	}

	public void setBuildingId(java.lang.Integer buildingId) {
		this.buildingId = buildingId;
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

	public java.lang.String getPlanStatus() {
		return planStatus;
	}

	public void setPlanStatus(java.lang.String planStatus) {
		this.planStatus = planStatus;
	}

	public java.math.BigDecimal getScancodePrice() {
		return scancodePrice;
	}

	public void setScancodePrice(java.math.BigDecimal scancodePrice) {
		this.scancodePrice = scancodePrice;
	}

	public java.lang.String getPhone() {
		return phone;
	}

	public void setPhone(java.lang.String phone) {
		this.phone = phone;
	}

}
