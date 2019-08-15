package com.jzhl.kfsq.entity.sm;

import java.io.Serializable;

public class Feature implements Serializable{
      
	/**
	 * Feature特色表
	 */
	private static final long serialVersionUID = 1L;
	private java.lang.Integer featureId;
	private java.lang.String featureName;
	private java.lang.Short isValid;
	private java.lang.Integer creatorUserId;
	private java.sql.Timestamp createTime;
	private java.lang.Integer updateUserId;
	private java.sql.Timestamp updateTime;
	public java.lang.Integer getFeatureId() {
		return featureId;
	}
	public void setFeatureId(java.lang.Integer featureId) {
		this.featureId = featureId;
	}
	public java.lang.String getFeatureName() {
		return featureName;
	}
	public void setFeatureName(java.lang.String featureName) {
		this.featureName = featureName;
	}
	public java.lang.Short getIsValid() {
		return isValid;
	}
	public void setIsValid(java.lang.Short isValid) {
		this.isValid = isValid;
	}
	public java.lang.Integer getCreatorUserId() {
		return creatorUserId;
	}
	public void setCreatorUserId(java.lang.Integer creatorUserId) {
		this.creatorUserId = creatorUserId;
	}
	public java.sql.Timestamp getCreateTime() {
		return createTime;
	}
	public void setCreateTime(java.sql.Timestamp createTime) {
		this.createTime = createTime;
	}
	public java.lang.Integer getUpdateUserId() {
		return updateUserId;
	}
	public void setUpdateUserId(java.lang.Integer updateUserId) {
		this.updateUserId = updateUserId;
	}
	public java.sql.Timestamp getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(java.sql.Timestamp updateTime) {
		this.updateTime = updateTime;
	}
	
	
}
