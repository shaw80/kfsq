package com.jzhl.kfsq.dataset.bm;

import java.io.Serializable;

/**
 * 楼盘信息结果集
 * 
 * @author Shaw
 *
 */
public class BuildingInfoDataSet implements Serializable {

	private static final long serialVersionUID = -303498009167261997L;
	
	private Integer buildingId;// 楼盘编号
	
	private String buildingName;// 楼盘名称
	
	private String address;// 地址
	
	private String salesType;// 销售状态
	
	private String buildingType;// 建筑类别
	
	private String decorationSituation;// 装修情况
	
	private String goodsType;// 商品类型
	
	private String openTime;// 开盘时间
	
	private String launchTime; // 交房时间
	
	private String periodOfPropertyRights;// 产权年限
	
	private String volumeRatio;// 容积率,百分比
	
	private String developer;// 开发商
	
	private String property;// 物业
	
	private String propertyFee;// 物业费
	
	private String greenRates;// 绿化率，百分比
	
	private String ratioOfSpaces;// 车位比
	
	private String parkFacilities;// 园区配套
	
	private String IsSeparation;// 是否人车分流

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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getSalesType() {
		return salesType;
	}

	public void setSalesType(String salesType) {
		this.salesType = salesType;
	}

	public String getBuildingType() {
		return buildingType;
	}

	public void setBuildingType(String buildingType) {
		this.buildingType = buildingType;
	}

	public String getDecorationSituation() {
		return decorationSituation;
	}

	public void setDecorationSituation(String decorationSituation) {
		this.decorationSituation = decorationSituation;
	}

	public String getGoodsType() {
		return goodsType;
	}

	public void setGoodsType(String goodsType) {
		this.goodsType = goodsType;
	}

	public String getOpenTime() {
		return openTime;
	}

	public void setOpenTime(String openTime) {
		this.openTime = openTime;
	}

	public String getLaunchTime() {
		return launchTime;
	}

	public void setLaunchTime(String launchTime) {
		this.launchTime = launchTime;
	}

	public String getPeriodOfPropertyRights() {
		return periodOfPropertyRights;
	}

	public void setPeriodOfPropertyRights(String periodOfPropertyRights) {
		this.periodOfPropertyRights = periodOfPropertyRights;
	}

	public String getVolumeRatio() {
		return volumeRatio;
	}

	public void setVolumeRatio(String volumeRatio) {
		this.volumeRatio = volumeRatio;
	}

	public String getDeveloper() {
		return developer;
	}

	public void setDeveloper(String developer) {
		this.developer = developer;
	}

	public String getProperty() {
		return property;
	}

	public void setProperty(String property) {
		this.property = property;
	}

	public String getPropertyFee() {
		return propertyFee;
	}

	public void setPropertyFee(String propertyFee) {
		this.propertyFee = propertyFee;
	}

	public String getGreenRates() {
		return greenRates;
	}

	public void setGreenRates(String greenRates) {
		this.greenRates = greenRates;
	}

	public String getRatioOfSpaces() {
		return ratioOfSpaces;
	}

	public void setRatioOfSpaces(String ratioOfSpaces) {
		this.ratioOfSpaces = ratioOfSpaces;
	}

	public String getParkFacilities() {
		return parkFacilities;
	}

	public void setParkFacilities(String parkFacilities) {
		this.parkFacilities = parkFacilities;
	}

	public String getIsSeparation() {
		return IsSeparation;
	}

	public void setIsSeparation(String isSeparation) {
		IsSeparation = isSeparation;
	}

	@Override
	public String toString() {
		return "BuildingInfoDataSet [buildingId=" + buildingId
				+ ", buildingName=" + buildingName + ", address=" + address
				+ ", salesType=" + salesType + ", buildingType=" + buildingType
				+ ", decorationSituation=" + decorationSituation
				+ ", goodsType=" + goodsType + ", openTime=" + openTime
				+ ", launchTime=" + launchTime + ", periodOfPropertyRights="
				+ periodOfPropertyRights + ", volumeRatio=" + volumeRatio
				+ ", developer=" + developer + ", property=" + property
				+ ", propertyFee=" + propertyFee + ", greenRates=" + greenRates
				+ ", ratioOfSpaces=" + ratioOfSpaces + ", parkFacilities="
				+ parkFacilities + ", IsSeparation=" + IsSeparation + "]";
	}

}
