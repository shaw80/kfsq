package com.jzhl.kfsq.entity.bm;

import java.io.Serializable;

/**
 * 
 * BM_Building表
 * 
 * @author zhouzy
 *
 */
public class Building implements Serializable {
	private static final long serialVersionUID = 1986594770209231857L;
	private java.lang.Integer buildingId; // 楼盘编号
	private java.lang.String buildingName; // 楼盘名称
	private java.lang.Integer agentId; // 代理商用户ID
	private java.lang.String developer; // 开发商
	private java.lang.String property; // 物业
	private java.lang.Integer decorationSituation;// 装修情况（0：毛坯，1：精装）
	private java.lang.String phone; // 电话
	private java.lang.Integer averagePrice; // 均价
	private java.lang.Integer sectionMin; // 区间最小值
	private java.lang.Integer sectionMax; // 区间最大值
	private java.lang.String address; // 地址
	private java.lang.String position; // 置位
	private java.lang.Integer county; // 区县
	private java.lang.Integer secondAreaId; // 二级区域编号，外键
	private java.lang.String longitude; // 经度
	private java.lang.String latitude; // 纬度
	private java.lang.String surrounding; // 周边配套
	private java.lang.String buildingInfo; // 楼盘信息
	private java.lang.String banner; // banner图片
	private java.lang.Integer salesType; // 销售状态（0：预售，1：在售，2：售罄）
	private java.lang.String buildingType; // '建筑类别，逗号分割（0：多层，1：高层，2：花园洋房，3：别墅，4：商铺）'
	private java.lang.String goodsType; // 商品类型，逗号分割（0：现房，1：期房）
	private java.lang.Integer creatorUserId; // 创建者：记录用户的创建人员的名称。
	private java.util.Date createTime; // 创建时间：记录用户的创建时间。
	private java.lang.Integer updateUserId; //
	private java.util.Date updateTime; // 数据更新时间
	private java.lang.Short isValid; // 0：无效，1：有效
	private java.lang.String buildingNo;
	private java.lang.Integer isSynchronous = 0; // 1是楼盘同步操作，不更新经纬度；0非同步操作

	public java.lang.Integer getBuildingId() {
		return buildingId;
	}

	public void setBuildingId(java.lang.Integer buildingId) {
		this.buildingId = buildingId;
	}

	public java.lang.String getBuildingName() {
		return buildingName;
	}

	public void setBuildingName(java.lang.String buildingName) {
		this.buildingName = buildingName;
	}

	public java.lang.Integer getAgentId() {
		return agentId;
	}

	public void setAgentId(java.lang.Integer agentId) {
		this.agentId = agentId;
	}

	public java.lang.String getDeveloper() {
		return developer;
	}

	public void setDeveloper(java.lang.String developer) {
		this.developer = developer;
	}

	public java.lang.String getProperty() {
		return property;
	}

	public void setProperty(java.lang.String property) {
		this.property = property;
	}

	public java.lang.Integer getDecorationSituation() {
		return decorationSituation;
	}

	public void setDecorationSituation(java.lang.Integer decorationSituation) {
		this.decorationSituation = decorationSituation;
	}

	public java.lang.String getPhone() {
		return phone;
	}

	public void setPhone(java.lang.String phone) {
		this.phone = phone;
	}

	public java.lang.Integer getAveragePrice() {
		return averagePrice;
	}

	public void setAveragePrice(java.lang.Integer averagePrice) {
		this.averagePrice = averagePrice;
	}

	public java.lang.Integer getSectionMin() {
		return sectionMin;
	}

	public void setSectionMin(java.lang.Integer sectionMin) {
		this.sectionMin = sectionMin;
	}

	public java.lang.Integer getSectionMax() {
		return sectionMax;
	}

	public void setSectionMax(java.lang.Integer sectionMax) {
		this.sectionMax = sectionMax;
	}

	public java.lang.String getAddress() {
		return address;
	}

	public void setAddress(java.lang.String address) {
		this.address = address;
	}

	public java.lang.String getPosition() {
		return position;
	}

	public void setPosition(java.lang.String position) {
		this.position = position;
	}

	public java.lang.Integer getCounty() {
		return county;
	}

	public void setCounty(java.lang.Integer county) {
		this.county = county;
	}

	public java.lang.Integer getSecondAreaId() {
		return secondAreaId;
	}

	public void setSecondAreaId(java.lang.Integer secondAreaId) {
		this.secondAreaId = secondAreaId;
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

	public java.lang.String getSurrounding() {
		return surrounding;
	}

	public void setSurrounding(java.lang.String surrounding) {
		this.surrounding = surrounding;
	}

	public java.lang.String getBuildingInfo() {
		return buildingInfo;
	}

	public void setBuildingInfo(java.lang.String buildingInfo) {
		this.buildingInfo = buildingInfo;
	}

	public java.lang.String getBanner() {
		return banner;
	}

	public void setBanner(java.lang.String banner) {
		this.banner = banner;
	}

	public java.lang.Integer getSalesType() {
		return salesType;
	}

	public void setSalesType(java.lang.Integer salesType) {
		this.salesType = salesType;
	}

	public java.lang.String getBuildingType() {
		return buildingType;
	}

	public void setBuildingType(java.lang.String buildingType) {
		this.buildingType = buildingType;
	}

	public java.lang.String getGoodsType() {
		return goodsType;
	}

	public void setGoodsType(java.lang.String goodsType) {
		this.goodsType = goodsType;
	}

	public java.lang.Integer getCreatorUserId() {
		return creatorUserId;
	}

	public void setCreatorUserId(java.lang.Integer creatorUserId) {
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

	public void setUpdateUserId(java.lang.Integer updateUserId) {
		this.updateUserId = updateUserId;
	}

	public java.util.Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(java.util.Date updateTime) {
		this.updateTime = updateTime;
	}

	public java.lang.Short getIsValid() {
		return isValid;
	}

	public void setIsValid(java.lang.Short isValid) {
		this.isValid = isValid;
	}

	public java.lang.String getBuildingNo() {
		return buildingNo;
	}

	public void setBuildingNo(java.lang.String buildingNo) {
		this.buildingNo = buildingNo;
	}

	public java.lang.Integer getIsSynchronous() {
		return isSynchronous;
	}

	public void setIsSynchronous(java.lang.Integer isSynchronous) {
		this.isSynchronous = isSynchronous;
	}

}