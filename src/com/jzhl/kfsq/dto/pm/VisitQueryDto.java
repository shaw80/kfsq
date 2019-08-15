package com.jzhl.kfsq.dto.pm;

import java.io.Serializable;

public class VisitQueryDto implements Serializable{
	private static final long serialVersionUID = -8791748890175366153L;
	private java.lang.Integer userId;
	private java.lang.String beginDate;
	private java.lang.String endDate;
	private java.lang.String appUserType;
	public java.lang.Integer getUserId() {
		return userId;
	}
	public void setUserId(java.lang.Integer userId) {
		this.userId = userId;
	}
	public java.lang.String getBeginDate() {
		return beginDate;
	}
	public void setBeginDate(java.lang.String beginDate) {
		this.beginDate = beginDate;
	}
	public java.lang.String getEndDate() {
		return endDate;
	}
	public void setEndDate(java.lang.String endDate) {
		this.endDate = endDate;
	}
	public java.lang.String getAppUserType() {
		return appUserType;
	}
	public void setAppUserType(java.lang.String appUserType) {
		this.appUserType = appUserType;
	}
	
}
