package com.jzhl.kfsq.entity.pm;

import java.io.Serializable;

public class SalerCustomer implements Serializable{
	private static final long serialVersionUID = 92863642556481382L;
	private java.lang.Integer salerCustomerId;
	private java.lang.Integer userId;
	private java.lang.Integer memberId;
	private java.lang.Integer buildingId;
	private java.lang.Short isFavorite;
	private java.sql.Timestamp createTime;
	private java.lang.Short isValid;
	private java.sql.Timestamp updateTime;
	public java.lang.Integer getSalerCustomerId() {
		return salerCustomerId;
	}
	public void setSalerCustomerId(java.lang.Integer salerCustomerId) {
		this.salerCustomerId = salerCustomerId;
	}
	public java.lang.Integer getUserId() {
		return userId;
	}
	public void setUserId(java.lang.Integer userId) {
		this.userId = userId;
	}
	public java.lang.Integer getMemberId() {
		return memberId;
	}
	public void setMemberId(java.lang.Integer memberId) {
		this.memberId = memberId;
	}
	public java.lang.Integer getBuildingId() {
		return buildingId;
	}
	public void setBuildingId(java.lang.Integer buildingId) {
		this.buildingId = buildingId;
	}
	public java.lang.Short getIsFavorite() {
		return isFavorite;
	}
	public void setIsFavorite(java.lang.Short isFavorite) {
		this.isFavorite = isFavorite;
	}
	public java.sql.Timestamp getCreateTime() {
		return createTime;
	}
	public void setCreateTime(java.sql.Timestamp createTime) {
		this.createTime = createTime;
	}
	public java.lang.Short getIsValid() {
		return isValid;
	}
	public void setIsValid(java.lang.Short isValid) {
		this.isValid = isValid;
	}
	public java.sql.Timestamp getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(java.sql.Timestamp updateTime) {
		this.updateTime = updateTime;
	}
	@Override
	public String toString() {
		return "SalerCustomer [salerCustomerId=" + salerCustomerId
				+ ", userId=" + userId + ", memberId=" + memberId
				+ ", buildingId=" + buildingId + ", isFavorite=" + isFavorite
				+ ", createTime=" + createTime + ", isValid=" + isValid
				+ ", updateTime=" + updateTime + "]";
	}
	
}
