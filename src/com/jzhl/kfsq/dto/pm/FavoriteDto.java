package com.jzhl.kfsq.dto.pm;

public class FavoriteDto {
	
	private java.lang.String isFavorite;
	
	private java.lang.String memberName;
	
	private java.lang.String userId;
	
	private java.lang.String salerCustomerId;// 客户表主键

	public java.lang.String getIsFavorite() {
		return isFavorite;
	}

	public void setIsFavorite(java.lang.String isFavorite) {
		this.isFavorite = isFavorite;
	}

	public java.lang.String getMemberName() {
		return memberName;
	}

	public void setMemberName(java.lang.String memberName) {
		this.memberName = memberName;
	}

	public java.lang.String getUserId() {
		return userId;
	}

	public void setUserId(java.lang.String userId) {
		this.userId = userId;
	}

	public java.lang.String getSalerCustomerId() {
		return salerCustomerId;
	}

	public void setSalerCustomerId(java.lang.String salerCustomerId) {
		this.salerCustomerId = salerCustomerId;
	}

	@Override
	public String toString() {
		return "FavoriteDto [isFavorite=" + isFavorite + ", memberName="
				+ memberName + ", userId=" + userId + ", salerCustomerId="
				+ salerCustomerId + "]";
	}

}
