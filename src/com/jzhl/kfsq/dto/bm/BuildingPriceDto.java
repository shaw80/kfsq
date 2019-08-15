package com.jzhl.kfsq.dto.bm;

import java.io.Serializable;

public class BuildingPriceDto implements Serializable {
	private static final long serialVersionUID = -1257850328174106425L;// 序列化
	private java.lang.String buildingId;
	private java.lang.String buildingName;
	private java.lang.String averagePrice;
	private java.lang.String address;
	private java.lang.String phone;
	private java.lang.String banner;
	private java.lang.String surrounding;
	private java.lang.String buildingInfo;
	private java.lang.String county;
	private java.lang.Integer priceId;
	private java.lang.String scancodePrice;
	private java.lang.String hasEnvelope;
	public java.lang.String getBuildingId() {
		return buildingId;
	}
	public void setBuildingId(java.lang.String buildingId) {
		this.buildingId = buildingId;
	}
	public java.lang.String getBuildingName() {
		return buildingName;
	}
	public void setBuildingName(java.lang.String buildingName) {
		this.buildingName = buildingName;
	}
	public java.lang.String getAveragePrice() {
		return averagePrice;
	}
	public void setAveragePrice(java.lang.String averagePrice) {
		this.averagePrice = averagePrice;
	}
	public java.lang.String getAddress() {
		return address;
	}
	public void setAddress(java.lang.String address) {
		this.address = address;
	}
	public java.lang.String getPhone() {
		return phone;
	}
	public void setPhone(java.lang.String phone) {
		this.phone = phone;
	}
	public java.lang.String getBanner() {
		return banner;
	}
	public void setBanner(java.lang.String banner) {
		this.banner = banner;
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
	public java.lang.String getCounty() {
		return county;
	}
	public void setCounty(java.lang.String county) {
		this.county = county;
	}
	public java.lang.Integer getPriceId() {
		return priceId;
	}
	public void setPriceId(java.lang.Integer priceId) {
		this.priceId = priceId;
	}
	public java.lang.String getScancodePrice() {
		return scancodePrice;
	}
	public void setScancodePrice(java.lang.String scancodePrice) {
		this.scancodePrice = scancodePrice;
	}
	public java.lang.String getHasEnvelope() {
		return hasEnvelope;
	}
	public void setHasEnvelope(java.lang.String hasEnvelope) {
		this.hasEnvelope = hasEnvelope;
	}
	
}
