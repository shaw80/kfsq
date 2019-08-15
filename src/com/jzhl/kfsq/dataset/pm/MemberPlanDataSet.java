package com.jzhl.kfsq.dataset.pm;

import java.io.Serializable;

public class MemberPlanDataSet implements Serializable {
	
	private static final long serialVersionUID = 8912661730101609141L;
	private java.lang.String clientName; // 客户姓名
	private java.lang.String clientPhone; // 客户电话
	private java.lang.String clientHeaderImg; // 客户头像
	private java.lang.String planId; // 看房计划ID
	private java.lang.String buildingName; // 预约楼盘
	private java.lang.String applyTime; // 计划时间
	private java.lang.String visitTime; // 实际到访时间
	private java.lang.String planStatus; // 看房状态
	private java.math.BigDecimal scancodePrice; // 红包金额
	private java.lang.String clientSex; // 性别
	public java.lang.String getClientName() {
		return clientName;
	}
	public void setClientName(java.lang.String clientName) {
		this.clientName = clientName;
	}
	public java.lang.String getClientPhone() {
		return clientPhone;
	}
	public void setClientPhone(java.lang.String clientPhone) {
		this.clientPhone = clientPhone;
	}
	public java.lang.String getClientHeaderImg() {
		return clientHeaderImg;
	}
	public void setClientHeaderImg(java.lang.String clientHeaderImg) {
		this.clientHeaderImg = clientHeaderImg;
	}
	public java.lang.String getPlanId() {
		return planId;
	}
	public void setPlanId(java.lang.String planId) {
		this.planId = planId;
	}
	public java.lang.String getBuildingName() {
		return buildingName;
	}
	public void setBuildingName(java.lang.String buildingName) {
		this.buildingName = buildingName;
	}
	public java.lang.String getApplyTime() {
		return applyTime;
	}
	public void setApplyTime(java.lang.String applyTime) {
		this.applyTime = applyTime;
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
	public java.lang.String getVisitTime() {
		return visitTime;
	}
	public void setVisitTime(java.lang.String visitTime) {
		this.visitTime = visitTime;
	}
	public java.lang.String getClientSex() {
		return clientSex;
	}
	public void setClientSex(java.lang.String clientSex) {
		this.clientSex = clientSex;
	}

}
