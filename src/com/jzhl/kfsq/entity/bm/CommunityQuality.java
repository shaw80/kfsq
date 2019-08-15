package com.jzhl.kfsq.entity.bm;

import java.io.Serializable;

/**
 * 
 * BM_CommunityQuality表
 * 
 * @author zhouzy
 *
 */
public class CommunityQuality implements Serializable {
	private static final long serialVersionUID = 4301613633591204839L;
	private java.lang.Integer communityQualityId; // 主键，社区品质编号
	private java.lang.Integer buildingId; // 外键，楼盘编号
	private java.lang.Integer developerId; // 外键，字典编号，开发商编号
	private java.lang.Integer propertyId; // 外键，字典编号，物业编号
	private java.lang.Integer locationId; // 外键，字典编号，地段编号
	private java.lang.Integer greenRates; // 园区绿化率
	private java.lang.Integer carNumber; // 车位数
	private java.lang.String ratioOfSpaces; // 车位比
	private java.lang.Integer IsSeparation; // 是否人车分流（0：不分流，1：分流）
	private java.lang.String spaceOfCarImg; // 车位图
	private java.lang.String greenImg; // 绿化图
	private java.lang.String parkFacilitiesImg; // 园区配套图
	private java.util.Date createTime; // 创建时间
	private java.util.Date updateTime; // 更新时间
	private java.lang.Integer createUserId; // 创建者编号
	private java.lang.Integer updateUserId; // 更新者编号
	private java.lang.Integer isValid; // 0：无效，1：有效

	public java.lang.Integer getCommunityQualityId() {
		return communityQualityId;
	}

	public void setCommunityQualityId(java.lang.Integer communityQualityId) {
		this.communityQualityId = communityQualityId;
	}

	public java.lang.Integer getBuildingId() {
		return buildingId;
	}

	public void setBuildingId(java.lang.Integer buildingId) {
		this.buildingId = buildingId;
	}

	public java.lang.Integer getDeveloperId() {
		return developerId;
	}

	public void setDeveloperId(java.lang.Integer developerId) {
		this.developerId = developerId;
	}

	public java.lang.Integer getPropertyId() {
		return propertyId;
	}

	public void setPropertyId(java.lang.Integer propertyId) {
		this.propertyId = propertyId;
	}

	public java.lang.Integer getLocationId() {
		return locationId;
	}

	public void setLocationId(java.lang.Integer locationId) {
		this.locationId = locationId;
	}

	public java.lang.Integer getGreenRates() {
		return greenRates;
	}

	public void setGreenRates(java.lang.Integer greenRates) {
		this.greenRates = greenRates;
	}

	public java.lang.Integer getCarNumber() {
		return carNumber;
	}

	public void setCarNumber(java.lang.Integer carNumber) {
		this.carNumber = carNumber;
	}

	public java.lang.String getRatioOfSpaces() {
		return ratioOfSpaces;
	}

	public void setRatioOfSpaces(java.lang.String ratioOfSpaces) {
		this.ratioOfSpaces = ratioOfSpaces;
	}

	public java.lang.Integer getIsSeparation() {
		return IsSeparation;
	}

	public void setIsSeparation(java.lang.Integer isSeparation) {
		IsSeparation = isSeparation;
	}

	public java.lang.String getSpaceOfCarImg() {
		return spaceOfCarImg;
	}

	public void setSpaceOfCarImg(java.lang.String spaceOfCarImg) {
		this.spaceOfCarImg = spaceOfCarImg;
	}

	public java.lang.String getGreenImg() {
		return greenImg;
	}

	public void setGreenImg(java.lang.String greenImg) {
		this.greenImg = greenImg;
	}

	public java.lang.String getParkFacilitiesImg() {
		return parkFacilitiesImg;
	}

	public void setParkFacilitiesImg(java.lang.String parkFacilitiesImg) {
		this.parkFacilitiesImg = parkFacilitiesImg;
	}

	public java.util.Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(java.util.Date createTime) {
		this.createTime = createTime;
	}

	public java.util.Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(java.util.Date updateTime) {
		this.updateTime = updateTime;
	}

	public java.lang.Integer getCreateUserId() {
		return createUserId;
	}

	public void setCreateUserId(java.lang.Integer createUserId) {
		this.createUserId = createUserId;
	}

	public java.lang.Integer getUpdateUserId() {
		return updateUserId;
	}

	public void setUpdateUserId(java.lang.Integer updateUserId) {
		this.updateUserId = updateUserId;
	}

	public java.lang.Integer getIsValid() {
		return isValid;
	}

	public void setIsValid(java.lang.Integer isValid) {
		this.isValid = isValid;
	}

}