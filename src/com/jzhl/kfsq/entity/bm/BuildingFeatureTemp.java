package com.jzhl.kfsq.entity.bm;

import java.io.Serializable;

public class BuildingFeatureTemp implements Serializable {
	private static final long serialVersionUID = 7898590469735961257L;
	private Integer id;
	private Integer buildingId;
	private String featureName;
	private java.sql.Timestamp createTime;
	private java.sql.Timestamp updateTime;
	private java.sql.Timestamp lastSynchronousTime;
	private Short isSynchronous;
	private Short isValid;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getBuildingId() {
		return buildingId;
	}
	public void setBuildingId(Integer buildingId) {
		this.buildingId = buildingId;
	}
	public String getFeatureName() {
		return featureName;
	}
	public void setFeatureName(String featureName) {
		this.featureName = featureName;
	}
	public java.sql.Timestamp getCreateTime() {
		return createTime;
	}
	public void setCreateTime(java.sql.Timestamp createTime) {
		this.createTime = createTime;
	}
	public java.sql.Timestamp getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(java.sql.Timestamp updateTime) {
		this.updateTime = updateTime;
	}
	public java.sql.Timestamp getLastSynchronousTime() {
		return lastSynchronousTime;
	}
	public void setLastSynchronousTime(java.sql.Timestamp lastSynchronousTime) {
		this.lastSynchronousTime = lastSynchronousTime;
	}
	public Short getIsSynchronous() {
		return isSynchronous;
	}
	public void setIsSynchronous(Short isSynchronous) {
		this.isSynchronous = isSynchronous;
	}
	public Short getIsValid() {
		return isValid;
	}
	public void setIsValid(Short isValid) {
		this.isValid = isValid;
	}
	
}
