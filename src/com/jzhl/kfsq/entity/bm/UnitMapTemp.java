package com.jzhl.kfsq.entity.bm;

import java.io.Serializable;

public class UnitMapTemp implements Serializable {
	private static final long serialVersionUID = 3447584317687514941L;
	private Integer unitMapId;
	private Integer buildingId;
	private String imgDes;
	private String path;
	private String sourcePath;
	private java.sql.Timestamp createTime;
	private java.sql.Timestamp updateTime;
	private java.sql.Timestamp lastSynchronousTime;
	private Short isSynchronous;
	private Short isValid;
	private String unitMapNo; 
	public Integer getUnitMapId() {
		return unitMapId;
	}
	public void setUnitMapId(Integer unitMapId) {
		this.unitMapId = unitMapId;
	}
	public Integer getBuildingId() {
		return buildingId;
	}
	public void setBuildingId(Integer buildingId) {
		this.buildingId = buildingId;
	}
	public String getImgDes() {
		return imgDes;
	}
	public void setImgDes(String imgDes) {
		this.imgDes = imgDes;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getSourcePath() {
		return sourcePath;
	}
	public void setSourcePath(String sourcePath) {
		this.sourcePath = sourcePath;
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
	public String getUnitMapNo() {
		return unitMapNo;
	}
	public void setUnitMapNo(String unitMapNo) {
		this.unitMapNo = unitMapNo;
	}

}
