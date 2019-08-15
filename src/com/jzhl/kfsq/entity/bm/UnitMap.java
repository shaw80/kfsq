package com.jzhl.kfsq.entity.bm;

import java.math.BigDecimal;

import com.jzhl.kfsq.common.util.MyMath;

public class UnitMap {
	private java.lang.Integer unitMapId; // 图片编号
	private java.lang.Integer buildingId; // 楼盘编号，外键
	private java.lang.String imgName; // 图片名称（如：A户型）
	private java.lang.String imgDes; // 图片描述（如：两室一厅）
	private java.lang.String path; //路径
	private java.lang.Integer imgType; // imgType
	private java.lang.Integer numOfRoom;// 居室数量
	private java.lang.String turned;// 朝向
	private java.lang.Float acreage;// 面积，单位：平方米
	private java.math.BigDecimal unitPrice;// 单价，单位：元/平方米
	private java.math.BigDecimal totalPrice;// 总价，单位：万元/套
	private java.lang.Integer roomRate;// 得房率，百分比
	private java.lang.Integer creatorUserId; // 创建者：记录用户的创建人员的名称。
	private java.util.Date createTime; // 创建时间：记录用户的创建时间。
	private java.lang.Integer updateUserId;
	private java.util.Date updateTime; // 数据更新时间
	private java.lang.Integer isValid; // 0：无效，1：有效
	private java.lang.String unitMapNo;
	public UnitMap() {
		
	}
	public java.lang.Integer getUnitMapId() {
		return unitMapId;
	}
	public void setUnitMapId(java.lang.Integer unitMapId) {
		this.unitMapId = unitMapId;
	}
	public java.lang.Integer getBuildingId() {
		return buildingId;
	}
	public void setBuildingId(java.lang.Integer buildingId) {
		this.buildingId = buildingId;
	}
	public java.lang.String getImgName() {
		return imgName;
	}
	public void setImgName(java.lang.String imgName) {
		this.imgName = imgName;
	}
	public java.lang.String getImgDes() {
		return imgDes;
	}
	public void setImgDes(java.lang.String imgDes) {
		this.imgDes = imgDes;
	}
	public java.lang.String getPath() {
		return path;
	}
	public void setPath(java.lang.String path) {
		this.path = path;
	}
	public java.lang.Integer getImgType() {
		return imgType;
	}
	public void setImgType(java.lang.Integer imgType) {
		this.imgType = imgType;
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
	public java.lang.Integer getIsValid() {
		return isValid;
	}
	public void setIsValid(java.lang.Integer isValid) {
		this.isValid = isValid;
	}
	public java.lang.String getUnitMapNo() {
		return unitMapNo;
	}
	public void setUnitMapNo(java.lang.String unitMapNo) {
		this.unitMapNo = unitMapNo;
	}
	public java.lang.String getTurned() {
		return turned;
	}
	public void setTurned(java.lang.String turned) {
		this.turned = turned;
	}
	public java.lang.Float getAcreage() {
		return acreage;
	}
	public void setAcreage(java.lang.Float acreage) {
		this.acreage = acreage;
	}
	public java.math.BigDecimal getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(java.math.BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}
	public java.math.BigDecimal getTotalPrice() {
		Integer b = 10000;
		return getTotalPriceDiv(totalPrice.doubleValue(), b.doubleValue(), 1);
	}
	public void setTotalPrice(java.math.BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}
	public java.lang.Integer getRoomRate() {
		return roomRate;
	}
	public void setRoomRate(java.lang.Integer roomRate) {
		this.roomRate = roomRate;
	}
	public java.lang.Integer getNumOfRoom() {
		return numOfRoom;
	}
	public void setNumOfRoom(java.lang.Integer numOfRoom) {
		this.numOfRoom = numOfRoom;
	}
	
	private BigDecimal getTotalPriceDiv(double a, double b, int len){
		double result = MyMath.div(a, b, len);
		return new BigDecimal(result);
	}
}
