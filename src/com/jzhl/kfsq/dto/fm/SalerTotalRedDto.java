package com.jzhl.kfsq.dto.fm;

import java.io.Serializable;

public class SalerTotalRedDto implements Serializable{
	private static final long serialVersionUID = 5261577092840122806L;
	private java.lang.Integer userId;
	private java.lang.Integer appUserType;
	private java.lang.String beginDate;
	private java.lang.String endDate;
	public java.lang.Integer getUserId() {
		return userId;
	}
	public void setUserId(java.lang.Integer userId) {
		this.userId = userId;
	}
	public java.lang.Integer getAppUserType() {
		return appUserType;
	}
	public void setAppUserType(java.lang.Integer appUserType) {
		this.appUserType = appUserType;
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
}
