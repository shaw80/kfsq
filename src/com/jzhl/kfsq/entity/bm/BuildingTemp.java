package com.jzhl.kfsq.entity.bm;

import java.io.Serializable;

public class BuildingTemp implements Serializable {
	private static final long serialVersionUID = 8817125620196689297L;
	private Integer buildingId;
	private String buildingName; // 楼盘名称
	private String developer; // 开发商
	private String phone; // 电话
	private String averagePrice; // 均价
	private Integer sectionMin; // 区间最小值
	private Integer sectionMax; // 区间最大值
	private String address; // 地址
	private String position; // 置位
	private String areaName; // 区县
	private String surrounding; // 周边配套
	private String buildingInfo; // 楼盘信息
	private String banner; // banner图片
	private String sourceBanner; // banner图片源地址
	private Short isSynchronous; // 是否已经同步(0:未同步，1:已同步)
	private java.sql.Timestamp createTime; // 创建时间
	private java.sql.Timestamp updateTime; // 更新时间
	private java.sql.Timestamp lastSynchronousTime; // 同步时间
	private java.lang.Short isValid;
	private java.lang.Integer cityId;
	private java.lang.String buildingNo; // 唯一标识，仅为同步数据时匹配使用

	public Integer getBuildingId() {
		return buildingId;
	}
	public void setBuildingId(Integer buildingId) {
		this.buildingId = buildingId;
	}
	public String getBuildingName() {
		return buildingName;
	}
	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}
	public String getDeveloper() {
		return developer;
	}
	public void setDeveloper(String developer) {
		this.developer = developer;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAveragePrice() {
		return averagePrice;
	}
	public void setAveragePrice(String averagePrice) {
		this.averagePrice = averagePrice;
	}
	public Integer getSectionMin() {
		return sectionMin;
	}
	public void setSectionMin(Integer sectionMin) {
		this.sectionMin = sectionMin;
	}
	public Integer getSectionMax() {
		return sectionMax;
	}
	public void setSectionMax(Integer sectionMax) {
		this.sectionMax = sectionMax;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getAreaName() {
		return areaName;
	}
	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}
	public String getSurrounding() {
		return surrounding;
	}
	public void setSurrounding(String surrounding) {
		this.surrounding = surrounding;
	}
	public String getBuildingInfo() {
		return buildingInfo;
	}
	public void setBuildingInfo(String buildingInfo) {
		this.buildingInfo = buildingInfo;
	}
	public String getBanner() {
		return banner;
	}
	public void setBanner(String banner) {
		this.banner = banner;
	}
	public String getSourceBanner() {
		return sourceBanner;
	}
	public void setSourceBanner(String sourceBanner) {
		this.sourceBanner = sourceBanner;
	}
	public Short getIsSynchronous() {
		return isSynchronous;
	}
	public void setIsSynchronous(Short isSynchronous) {
		this.isSynchronous = isSynchronous;
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
	public java.lang.Short getIsValid() {
		return isValid;
	}
	public void setIsValid(java.lang.Short isValid) {
		this.isValid = isValid;
	}
	public java.lang.Integer getCityId() {
		return cityId;
	}
	public void setCityId(java.lang.Integer cityId) {
		this.cityId = cityId;
	}
	public java.lang.String getBuildingNo() {
		return buildingNo;
	}
	public void setBuildingNo(java.lang.String buildingNo) {
		this.buildingNo = buildingNo;
	}
	@Override
	public String toString() {
		return "BuildingTemp [buildingId=" + buildingId + ", buildingName="
				+ buildingName + ", developer=" + developer + ", phone="
				+ phone + ", averagePrice=" + averagePrice + ", sectionMin="
				+ sectionMin + ", sectionMax=" + sectionMax + ", address="
				+ address + ", position=" + position + ", areaName=" + areaName
				+ ", surrounding=" + surrounding + ", buildingInfo="
				+ buildingInfo + ", banner=" + banner + ", sourceBanner="
				+ sourceBanner + ", isSynchronous=" + isSynchronous
				+ ", createTime=" + createTime + ", updateTime=" + updateTime
				+ ", lastSynchronousTime=" + lastSynchronousTime + ", isValid="
				+ isValid + ", cityId=" + cityId + ", buildingNo=" + buildingNo
				+ "]";
	}
	
}
