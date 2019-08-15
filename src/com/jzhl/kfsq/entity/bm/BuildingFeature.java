package com.jzhl.kfsq.entity.bm;

public class BuildingFeature {
	private java.lang.Integer id;
	private java.lang.Integer buildingId;
	private java.lang.Integer featureId;
	private java.lang.Integer creatorUserId;
	private java.util.Date createTime;
	private java.lang.Integer updateUserId;
	private java.util.Date updateTime;
	private java.lang.Integer isValid = 1;
	
	public java.lang.Integer getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public java.lang.Integer getBuildingId() {
		return buildingId;
	}
	public void setBuildingId(int buildingId) {
		this.buildingId = buildingId;
	}
	public java.lang.Integer getFeatureId() {
		return featureId;
	}
	public void setFeatureId(int featureId) {
		this.featureId = featureId;
	}
	public java.lang.Integer getCreatorUserId() {
		return creatorUserId;
	}
	public void setCreatorUserId(int creatorUserId) {
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
	public void setUpdateUserId(int updateUserId) {
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
	public void setIsValid(int isValid) {
		this.isValid = isValid;
	}
	
}
