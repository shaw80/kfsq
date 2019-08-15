package com.jzhl.kfsq.dto.pm;

import com.jzhl.kfsq.common.base.PageListCondition;

public class SalesDirectorCountDto extends PageListCondition{
	private java.lang.Integer userId;
	private java.lang.String beginDate;
	private java.lang.String endDate;

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
	
}
