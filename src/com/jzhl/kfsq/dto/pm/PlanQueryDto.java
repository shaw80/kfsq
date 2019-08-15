package com.jzhl.kfsq.dto.pm;

public class PlanQueryDto {
	private java.lang.Integer planId;
	private java.lang.Integer buildingId;
	private java.lang.String buildingName; // 楼盘名称
	private java.lang.String longitude; // 经度
	private java.lang.String latitude; // 纬度
	private java.lang.Integer averagePrice; // 均价
	private java.lang.String buildingPhone; // 电话
	private java.lang.String position; // 置位
	private java.lang.Integer creatorUserId;
	private java.lang.String appointmentTime;
	private java.lang.String status;
	private java.lang.String address;
	private java.lang.String createTime;
	private java.lang.Integer flag = 0; //"0"代表status取值全部;1代表status取值1,2
	public PlanQueryDto() {
		
	}
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
	public java.lang.Integer getAveragePrice() {
		return averagePrice;
	}
	public void setAveragePrice(int averagePrice) {
		this.averagePrice = averagePrice;
	}
	public java.lang.String getBuildingPhone() {
		return buildingPhone;
	}
	public void setBuildingPhone(java.lang.String buildingPhone) {
		this.buildingPhone = buildingPhone;
	}
	public java.lang.String getPosition() {
		return position;
	}
	public void setPosition(java.lang.String position) {
		this.position = position;
	}
	public java.lang.Integer getCreatorUserId() {
		return creatorUserId;
	}
	public void setCreatorUserId(int creatorUserId) {
		this.creatorUserId = creatorUserId;
	}
	public java.lang.String getAppointmentTime() {
		return appointmentTime;
	}
	public void setAppointmentTime(java.lang.String appointmentTime) {
		this.appointmentTime = appointmentTime;
	}
	public java.lang.String getStatus() {
		return status;
	}
	public void setStatus(java.lang.String status) {
		this.status = status;
	}
	public java.lang.String getAddress() {
		return address;
	}
	public void setAddress(java.lang.String address) {
		this.address = address;
	}
	public java.lang.String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(java.lang.String createTime) {
		this.createTime = createTime;
	}
	public java.lang.Integer getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
	public java.lang.Integer getBuildingId() {
		return buildingId;
	}
	public void setBuildingId(java.lang.Integer buildingId) {
		this.buildingId = buildingId;
	}
	public java.lang.Integer getPlanId() {
		return planId;
	}
	public void setPlanId(java.lang.Integer planId) {
		this.planId = planId;
	}
	public void setAveragePrice(java.lang.Integer averagePrice) {
		this.averagePrice = averagePrice;
	}
	public void setCreatorUserId(java.lang.Integer creatorUserId) {
		this.creatorUserId = creatorUserId;
	}
	public void setFlag(java.lang.Integer flag) {
		this.flag = flag;
	}
	
}
