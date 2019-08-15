package com.jzhl.kfsq.dataset.bm;

import java.io.Serializable;

/**
 * 
 * BM_CommunityQuality表
 * 
 * @author zhouzy
 *
 */
public class CommunityQualityDataSet implements Serializable {
	private static final long serialVersionUID = 3277586207527547002L;
	private java.lang.Integer buildingId; // 外键，楼盘编号
	private java.lang.Float communityScore; // 社区品质评分
	private java.lang.Integer memberNum; // 参与打分用户数
	private java.lang.String developer; // 开发商
	private java.lang.Integer developerRanking; // 开发商排名
	private java.lang.String property; // 物业
	private java.lang.Integer propertyRanking; // 物业排名
	private java.lang.String areaName; // 地段；二级地域
	private java.lang.Integer areaRanking; // 地段排名
	private java.lang.Integer IsSeparation; // 是否人车分流（0：不分流，1：分流）
	private java.lang.String ratioOfSpaces; // 车位比
	private java.lang.String spaceOfCarImg; // 车位图
	private java.lang.Integer greenRates; // 园区绿化率
	private java.lang.String greenImg; // 绿化图
	private java.lang.String parkFacilitiesImg; // 园区配套图

	public java.lang.Integer getBuildingId() {
		return buildingId;
	}

	public void setBuildingId(java.lang.Integer buildingId) {
		this.buildingId = buildingId;
	}

	public java.lang.Float getCommunityScore() {
		return communityScore;
	}

	public void setCommunityScore(java.lang.Float communityScore) {
		this.communityScore = communityScore;
	}

	public java.lang.Integer getMemberNum() {
		return memberNum;
	}

	public void setMemberNum(java.lang.Integer memberNum) {
		this.memberNum = memberNum;
	}

	public java.lang.String getDeveloper() {
		return developer;
	}

	public void setDeveloper(java.lang.String developer) {
		this.developer = developer;
	}

	public java.lang.Integer getDeveloperRanking() {
		return developerRanking;
	}

	public void setDeveloperRanking(java.lang.Integer developerRanking) {
		this.developerRanking = developerRanking;
	}

	public java.lang.String getProperty() {
		return property;
	}

	public void setProperty(java.lang.String property) {
		this.property = property;
	}

	public java.lang.Integer getPropertyRanking() {
		return propertyRanking;
	}

	public void setPropertyRanking(java.lang.Integer propertyRanking) {
		this.propertyRanking = propertyRanking;
	}

	public java.lang.String getAreaName() {
		return areaName;
	}

	public void setAreaName(java.lang.String areaName) {
		this.areaName = areaName;
	}

	public java.lang.Integer getAreaRanking() {
		return areaRanking;
	}

	public void setAreaRanking(java.lang.Integer areaRanking) {
		this.areaRanking = areaRanking;
	}

	public java.lang.Integer getIsSeparation() {
		return IsSeparation;
	}

	public void setIsSeparation(java.lang.Integer isSeparation) {
		IsSeparation = isSeparation;
	}

	public java.lang.String getRatioOfSpaces() {
		return ratioOfSpaces;
	}

	public void setRatioOfSpaces(java.lang.String ratioOfSpaces) {
		this.ratioOfSpaces = ratioOfSpaces;
	}

	public java.lang.String getSpaceOfCarImg() {
		return spaceOfCarImg;
	}

	public void setSpaceOfCarImg(java.lang.String spaceOfCarImg) {
		this.spaceOfCarImg = spaceOfCarImg;
	}

	public java.lang.Integer getGreenRates() {
		return greenRates;
	}

	public void setGreenRates(java.lang.Integer greenRates) {
		this.greenRates = greenRates;
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

	@Override
	public String toString() {
		return "CommunityQualityDataSet [buildingId=" + buildingId
				+ ", communityScore=" + communityScore + ", memberNum="
				+ memberNum + ", developer=" + developer
				+ ", developerRanking=" + developerRanking + ", property="
				+ property + ", propertyRanking=" + propertyRanking
				+ ", areaName=" + areaName + ", areaRanking=" + areaRanking
				+ ", IsSeparation=" + IsSeparation + ", ratioOfSpaces="
				+ ratioOfSpaces + ", spaceOfCarImg=" + spaceOfCarImg
				+ ", greenRates=" + greenRates + ", greenImg=" + greenImg
				+ ", parkFacilitiesImg=" + parkFacilitiesImg + "]";
	}

}