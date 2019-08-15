package com.jzhl.kfsq.dto.pm;

import com.jzhl.kfsq.common.base.PageListCondition;

public class SalerCustomerDto extends PageListCondition {
	private java.lang.Short isFavorites;
	private java.lang.String memberName;
	private java.lang.Integer userId;
	private java.lang.Integer salerCustomerId;
	public java.lang.Short getIsFavorites() {
		return isFavorites;
	}
	public void setIsFavorites(java.lang.Short isFavorites) {
		this.isFavorites = isFavorites;
	}
	public java.lang.String getMemberName() {
		return memberName;
	}
	public void setMemberName(java.lang.String memberName) {
		this.memberName = memberName;
	}
	public java.lang.Integer getUserId() {
		return userId;
	}
	public void setUserId(java.lang.Integer userId) {
		this.userId = userId;
	}
	public java.lang.Integer getSalerCustomerId() {
		return salerCustomerId;
	}
	public void setSalerCustomerId(java.lang.Integer salerCustomerId) {
		this.salerCustomerId = salerCustomerId;
	}
}
