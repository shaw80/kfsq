package com.jzhl.kfsq.dataset.pm;

public class PlanQueryDataSet {
	private String buildingId;
	private String planId;
	private String buildingName; // 楼盘名称
	private String longitude; // 经度
	private String latitude; // 纬度
	private int averagePrice; // 均价
	private String buildingPhone; // 电话
	private String position; // 置位
	private int creatorUserId;
	private String appointmentTime;
	private String status;
	private String address;
	private String createTime;
	private String banner;
	private int flag = 0; //"0"代表status取值全部;1代表status取值1,2
	private java.math.BigDecimal scancodePrice;
	public PlanQueryDataSet() {
		
	}
	public String getBuildingName() {
		return buildingName;
	}
	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public int getAveragePrice() {
		return averagePrice;
	}
	public void setAveragePrice(int averagePrice) {
		this.averagePrice = averagePrice;
	}
	public String getBuildingPhone() {
		return buildingPhone;
	}
	public void setBuildingPhone(String buildingPhone) {
		this.buildingPhone = buildingPhone;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public int getCreatorUserId() {
		return creatorUserId;
	}
	public void setCreatorUserId(int creatorUserId) {
		this.creatorUserId = creatorUserId;
	}
	public String getAppointmentTime() {
		return appointmentTime;
	}
	public void setAppointmentTime(String appointmentTime) {
		this.appointmentTime = appointmentTime;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
	public String getBuildingId() {
		return buildingId;
	}
	public void setBuildingId(String buildingId) {
		this.buildingId = buildingId;
	}
	public String getPlanId() {
		return planId;
	}
	public void setPlanId(String planId) {
		this.planId = planId;
	}
	public String getBanner() {
		return banner;
	}
	public void setBanner(String banner) {
		this.banner = banner;
	}
	public java.lang.String getScancodePrice() {
		return scancodePrice.toPlainString();
	}
	public void setScancodePrice(java.math.BigDecimal scancodePrice) {
		this.scancodePrice = scancodePrice;
	}
	
}
