package com.jzhl.kfsq.dto.bm;

public class BuildingEnvelopeDto {
	private java.lang.Integer buildingId; // 楼盘ID
	private java.lang.String buildingName; // 楼盘名称
	private java.lang.String longitude; // 楼盘经度
	private java.lang.String latitude; // 楼盘纬度
	private java.lang.String averagePrice; // 楼盘均价
	private java.lang.String section; // 楼盘面积区间
	private java.lang.String position; // 楼盘位置
	private java.lang.String scancodePrice;// 楼盘看房红包金额
	private java.lang.String developer; // 楼盘开发商
	private java.lang.String banner;
	private java.lang.String phone;
	private java.math.BigDecimal balance;// 楼盘余额
	private java.lang.String isPlan;// 是否加入计划（0：未加入，1：已加入）
	private java.lang.String feature;// 楼盘特色
	private java.lang.String hasEnvelope = "false";// true：有红包，false：没有红包
	private java.lang.String isLook; // 是否看房（0：未看，1：已看）

	private java.lang.String totalScore; // 总评分
	private java.lang.String goodTagList; // 优质标签
	private java.lang.String badTagList; // 劣质标签
	private java.lang.Integer commentNum; // 评价数
	private java.lang.String isSchoolHouse; // 是否为学区房
	private java.lang.String isSubwayHouse; // 是否为地铁房
	private java.lang.Integer switchStatus; // 红包状态
	private java.lang.Integer salesType; // '销售状态（0：预售，1：在售，2：售罄）',

	public java.lang.String getBuildingName() {
		return buildingName;
	}

	public void setBuildingName(java.lang.String buildingName) {
		this.buildingName = buildingName;
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

	public java.lang.String getAveragePrice() {
		return averagePrice;
	}

	public void setAveragePrice(java.lang.String averagePrice) {
		this.averagePrice = averagePrice;
	}

	public java.lang.String getSection() {
		return section;
	}

	public void setSection(java.lang.String section) {
		this.section = section;
	}

	public java.lang.String getPosition() {
		return position;
	}

	public void setPosition(java.lang.String position) {
		this.position = position;
	}

	public java.lang.String getScancodePrice() {
		return scancodePrice;
	}

	public void setScancodePrice(java.lang.String scancodePrice) {
		this.scancodePrice = scancodePrice;
	}

	public java.lang.String getDeveloper() {
		return developer;
	}

	public void setDeveloper(java.lang.String developer) {
		this.developer = developer;
	}

	public java.lang.String getBanner() {
		return banner;
	}

	public void setBanner(java.lang.String banner) {
		this.banner = banner;
	}

	public java.lang.String getPhone() {
		return phone;
	}

	public void setPhone(java.lang.String phone) {
		this.phone = phone;
	}

	public java.lang.Integer getBuildingId() {
		return buildingId;
	}

	public void setBuildingId(java.lang.Integer buildingId) {
		this.buildingId = buildingId;
	}

	public java.math.BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(java.math.BigDecimal balance) {
		this.balance = balance;
	}

	public java.lang.String getIsPlan() {
		return isPlan;
	}

	public void setIsPlan(java.lang.String isPlan) {
		this.isPlan = isPlan;
	}

	public java.lang.String getFeature() {
		return feature;
	}

	public void setFeature(java.lang.String feature) {
		this.feature = feature;
	}

	public java.lang.String getHasEnvelope() {
		return hasEnvelope;
	}

	public void setHasEnvelope(java.lang.String hasEnvelope) {
		this.hasEnvelope = hasEnvelope;
	}

	public java.lang.String getTotalScore() {
		return totalScore;
	}

	public void setTotalScore(java.lang.String totalScore) {
		this.totalScore = totalScore;
	}

	public java.lang.String getIsLook() {
		return isLook;
	}

	public void setIsLook(java.lang.String isLook) {
		this.isLook = isLook;
	}

	public java.lang.String getGoodTagList() {
		return goodTagList;
	}

	public void setGoodTagList(java.lang.String goodTagList) {
		this.goodTagList = goodTagList;
	}

	public java.lang.String getBadTagList() {
		return badTagList;
	}

	public void setBadTagList(java.lang.String badTagList) {
		this.badTagList = badTagList;
	}

	public java.lang.Integer getCommentNum() {
		return commentNum;
	}

	public void setCommentNum(java.lang.Integer commentNum) {
		this.commentNum = commentNum;
	}

	public java.lang.String getIsSchoolHouse() {
		return isSchoolHouse;
	}

	public void setIsSchoolHouse(java.lang.String isSchoolHouse) {
		this.isSchoolHouse = isSchoolHouse;
	}

	public java.lang.String getIsSubwayHouse() {
		return isSubwayHouse;
	}

	public void setIsSubwayHouse(java.lang.String isSubwayHouse) {
		this.isSubwayHouse = isSubwayHouse;
	}

	public java.lang.Integer getSwitchStatus() {
		return switchStatus;
	}

	public void setSwitchStatus(java.lang.Integer switchStatus) {
		this.switchStatus = switchStatus;
	}

	public java.lang.Integer getSalesType() {
		return salesType;
	}

	public void setSalesType(java.lang.Integer salesType) {
		this.salesType = salesType;
	}

}
