package com.jzhl.kfsq.entity.sm;

import java.io.Serializable;

public class Area implements Serializable {
	private static final long serialVersionUID = 5019543738474532073L;
	private java.lang.Integer areaId;
	private java.lang.String areaName;
	private java.lang.Integer cityId;
	private java.lang.Short isValid;
	private java.lang.String longitude;
	private java.lang.String latitude;
	private java.lang.Integer parentId;
	private java.lang.Integer creatorUserId;
	private java.sql.Timestamp createTime;
	private java.lang.Integer updateUserId;
	private java.sql.Timestamp updateTime;
	private java.lang.String cityName;

	public Area() {

	}

	public java.lang.Integer getAreaId() {
		return areaId;
	}

	public void setAreaId(java.lang.Integer areaId) {
		this.areaId = areaId;
	}

	public java.lang.String getAreaName() {
		return areaName;
	}

	public void setAreaName(java.lang.String areaName) {
		this.areaName = areaName;
	}

	public java.lang.Integer getCityId() {
		return cityId;
	}

	public void setCityId(java.lang.Integer cityId) {
		this.cityId = cityId;
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

	public java.lang.String getLongitude() {
		return longitude;
	}

	public void setLongitude(java.lang.String longitude) {
		this.longitude = longitude;
	}

	public java.lang.String getLatitude() {
		return latitude;
	}

	public void setLatitude(java.lang.String latitude) {
		this.latitude = latitude;
	}

	public java.lang.String getCityName() {
		return cityName;
	}

	public void setCityName(java.lang.String cityName) {
		this.cityName = cityName;
	}

	public java.lang.Integer getParentId() {
		return parentId;
	}

	public void setParentId(java.lang.Integer parentId) {
		this.parentId = parentId;
	}

	@Override
	public String toString() {
		return "Area [areaId=" + areaId + ", areaName=" + areaName + ", cityId=" + cityId + ", isValid=" + isValid + ", longitude="
				+ longitude + ", latitude=" + latitude + ", parentId=" + parentId + ", creatorUserId=" + creatorUserId + ", createTime="
				+ createTime + ", updateUserId=" + updateUserId + ", updateTime=" + updateTime + ", cityName=" + cityName + "]";
	}

}
