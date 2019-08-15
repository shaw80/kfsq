package com.jzhl.kfsq.dto.bm;

import java.io.Serializable;

import com.jzhl.kfsq.common.base.PageListCondition;

public class BuildingMsgDto extends PageListCondition implements Serializable {

	private static final long serialVersionUID = -8282387983564638983L;
	private java.lang.Integer buildingId; // 楼盘编号
	private java.lang.String position;// 楼盘区域名称
	private java.lang.String featureId;// 特色编号
	private java.lang.String banner;// 首图banner相对地址
	private java.lang.String buildingName;// 楼盘名称
	private java.lang.Integer agentId; // 代理商ID
	private java.lang.Integer county; // 区域id
	private java.lang.String developer;// 开发商
	private java.lang.String phone;// 联系方式
	private java.lang.String address;// 地址
	private java.lang.String longitude;// 经度
	private java.lang.String latitude;// 纬度
	private java.lang.Integer averagePrice;// 均价
	private java.lang.String averagePriceToString;// 均价区间
	private java.lang.Integer minPrice;// 价格区间
	private java.lang.Integer maxPrice;// 价格区间/
	private java.lang.String buildingInfo;// 楼盘信息
	private java.lang.String surrounding;// 周边配套
	private java.lang.Integer branchId;// 分站id
	private java.lang.Short isValid; // 0：无效，1：有效
	private java.lang.Short priceisValid; // 红包状态0：无效，1：有效
	private java.lang.Integer creatorUserId; // 创建者：记录用户的创建人员的名称。
	private java.util.Date createTime; // 创建时间：记录用户的创建时间。
	private java.lang.Integer updateUserId; //
	private java.util.Date updateTime; // 数据更新时间
	private java.lang.Integer sectionMin; // 区间最小值
	private java.lang.Integer sectionMax; // 区间最大值
	private java.lang.Integer rechargeFlag; // 充值状态标志位；null全部，0已充值，1未充值

	private java.lang.Integer secondAreaId; // 二级区域
	private java.lang.Integer decorationSituation; // '装修情况（0：毛坯，1：精装）'
	private java.lang.Integer greenRates; // 绿化率
	private java.lang.String greenImg; // 绿化率图
	private java.lang.String ratioOfSpaces; // 车位比
	private java.lang.String spaceOfCarImg; // 车位图
	private java.lang.String parkFacilitiesImg; // 园区配套图
	private java.lang.Integer IsSeparation; // 是否人车分流（0：不分流，1：分流）
	private java.lang.Integer tagIsShowNum; // 前端可见标签数量
	private java.lang.String tagList; // 标签列表

	private java.lang.Integer salesType; // 销售状态（0：预售，1：在售，2：售罄）
	private java.lang.String buildingType; // '建筑类别，逗号分割（0：多层，1：高层，2：花园洋房，3：别墅，4：商铺）'
	private java.lang.String goodsType; // 商品类型，逗号分割（0：现房，1：期房）
	private java.lang.String property; // 物业

	private java.lang.String traffic; // 交通内容
	private java.lang.String education; // 教育内容
	private java.lang.String arround; // 周边内容
	private java.lang.String discount; // 销售折扣内容

	public java.lang.String getPosition() {
		return position;
	}

	public void setPosition(java.lang.String position) {
		this.position = position;
	}

	public java.lang.String getFeatureId() {
		return featureId;
	}

	public void setFeatureId(java.lang.String featureId) {
		this.featureId = featureId;
	}

	public java.lang.String getBanner() {
		return banner;
	}

	public void setBanner(java.lang.String banner) {
		this.banner = banner;
	}

	public java.lang.String getBuildingName() {
		return buildingName;
	}

	public void setBuildingName(java.lang.String buildingName) {
		this.buildingName = buildingName;
	}

	public java.lang.String getDeveloper() {
		return developer;
	}

	public void setDeveloper(java.lang.String developer) {
		this.developer = developer;
	}

	public java.lang.String getPhone() {
		return phone;
	}

	public void setPhone(java.lang.String phone) {
		this.phone = phone;
	}

	public java.lang.String getAddress() {
		return address;
	}

	public void setAddress(java.lang.String address) {
		this.address = address;
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

	public java.lang.Integer getAveragePrice() {
		return averagePrice;
	}

	public void setAveragePrice(java.lang.Integer averagePrice) {
		this.averagePrice = averagePrice;
	}

	public java.lang.String getBuildingInfo() {
		return buildingInfo;
	}

	public void setBuildingInfo(java.lang.String buildingInfo) {
		this.buildingInfo = buildingInfo;
	}

	public java.lang.String getSurrounding() {
		return surrounding;
	}

	public void setSurrounding(java.lang.String surrounding) {
		this.surrounding = surrounding;
	}

	public java.lang.Integer getAgentId() {
		return agentId;
	}

	public void setAgentId(java.lang.Integer agentId) {
		this.agentId = agentId;
	}

	public java.lang.Integer getCounty() {
		return county;
	}

	public void setCounty(java.lang.Integer county) {
		this.county = county;
	}

	public java.lang.Integer getBranchId() {
		return branchId;
	}

	public void setBranchId(java.lang.Integer branchId) {
		this.branchId = branchId;
	}

	public java.lang.Short getPriceisValid() {
		return priceisValid;
	}

	public void setPriceisValid(java.lang.Short priceisValid) {
		this.priceisValid = priceisValid;
	}

	public java.lang.Short getIsValid() {
		return isValid;
	}

	public void setIsValid(java.lang.Short isValid) {
		this.isValid = isValid;
	}

	public java.lang.Integer getMinPrice() {
		return minPrice;
	}

	public void setMinPrice(java.lang.Integer minPrice) {
		this.minPrice = minPrice;
	}

	public java.lang.Integer getMaxPrice() {
		return maxPrice;
	}

	public void setMaxPrice(java.lang.Integer maxPrice) {
		this.maxPrice = maxPrice;
	}

	public java.lang.Integer getBuildingId() {
		return buildingId;
	}

	public void setBuildingId(java.lang.Integer buildingId) {
		this.buildingId = buildingId;
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

	public java.lang.String getAveragePriceToString() {
		return averagePriceToString;
	}

	public void setAveragePriceToString(java.lang.String averagePriceToString) {
		this.averagePriceToString = averagePriceToString;
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

	public java.lang.Integer getRechargeFlag() {
		return rechargeFlag;
	}

	public void setRechargeFlag(java.lang.Integer rechargeFlag) {
		this.rechargeFlag = rechargeFlag;
	}

	public java.lang.Integer getSecondAreaId() {
		return secondAreaId;
	}

	public void setSecondAreaId(java.lang.Integer secondAreaId) {
		this.secondAreaId = secondAreaId;
	}

	public java.lang.Integer getDecorationSituation() {
		return decorationSituation;
	}

	public void setDecorationSituation(java.lang.Integer decorationSituation) {
		this.decorationSituation = decorationSituation;
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

	public java.lang.String getParkFacilitiesImg() {
		return parkFacilitiesImg;
	}

	public void setParkFacilitiesImg(java.lang.String parkFacilitiesImg) {
		this.parkFacilitiesImg = parkFacilitiesImg;
	}

	public java.lang.Integer getIsSeparation() {
		return IsSeparation;
	}

	public void setIsSeparation(java.lang.Integer isSeparation) {
		IsSeparation = isSeparation;
	}

	public java.lang.Integer getTagIsShowNum() {
		return tagIsShowNum;
	}

	public void setTagIsShowNum(java.lang.Integer tagIsShowNum) {
		this.tagIsShowNum = tagIsShowNum;
	}

	public java.lang.String getTagList() {
		return tagList;
	}

	public void setTagList(java.lang.String tagList) {
		this.tagList = tagList;
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

	public java.lang.String getProperty() {
		return property;
	}

	public void setProperty(java.lang.String property) {
		this.property = property;
	}

	public java.lang.String getTraffic() {
		return traffic;
	}

	public void setTraffic(java.lang.String traffic) {
		this.traffic = traffic;
	}

	public java.lang.String getEducation() {
		return education;
	}

	public void setEducation(java.lang.String education) {
		this.education = education;
	}

	public java.lang.String getArround() {
		return arround;
	}

	public void setArround(java.lang.String arround) {
		this.arround = arround;
	}

	public java.lang.String getDiscount() {
		return discount;
	}

	public void setDiscount(java.lang.String discount) {
		this.discount = discount;
	}

}
