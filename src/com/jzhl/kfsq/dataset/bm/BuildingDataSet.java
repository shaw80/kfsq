package com.jzhl.kfsq.dataset.bm;

import java.io.Serializable;

/**
 * 
 * BM_Building表
 * 
 * @author zhouzy
 *
 */
public class BuildingDataSet implements Serializable {
	private static final long serialVersionUID = 1986594770209231857L;
	private java.lang.Integer buildingId; // 楼盘编号
	private java.lang.String buildingName; // 楼盘名称
	private java.lang.Integer agentId; // 代理商用户ID
	private java.lang.String developer; // 开发商
	private java.lang.String phone; // 电话
	private java.lang.Integer averagePrice; // 均价
	private java.lang.Integer sectionMin; // 区间最小值
	private java.lang.Integer sectionMax; // 区间最大值
	private java.lang.String address; // 地址
	private java.lang.String position; // 置位
	private java.lang.Integer county; // 区县
	private java.lang.String longitude; // 经度
	private java.lang.String latitude; // 纬度
	private java.lang.String surrounding; // 周边配套
	private java.lang.String buildingInfo; // 楼盘信息
	private java.lang.String banner; // banner图片
	private java.lang.Integer creatorUserId; // 创建者：记录用户的创建人员的名称。
	private java.util.Date createTime; // 创建时间：记录用户的创建时间。
	private java.lang.Integer updateUserId; //
	private java.util.Date updateTime; // 数据更新时间
	private java.lang.Short isValid; // 0：无效，1：有效

	private java.lang.Integer userId; // 用户ID
	private java.lang.String account; // 账号
	private java.lang.String name; // 名称
	private java.util.Date userCreateTime; // 用户创建时间
	private java.lang.Short userIsValid; // 用户有效、无效0：无效，1：有效

	/**
	 * 获取楼盘编号属性
	 *
	 * @return buildingId
	 */
	public java.lang.Integer getbuildingId() {
		return buildingId;
	}

	/**
	 * 设置楼盘编号属性
	 *
	 * @param buildingId
	 */
	public void setbuildingId(java.lang.Integer buildingId) {
		this.buildingId = buildingId;
	}

	/**
	 * 获取楼盘名称属性
	 *
	 * @return buildingName
	 */
	public java.lang.String getbuildingName() {
		return buildingName;
	}

	/**
	 * 设置楼盘名称属性
	 *
	 * @param buildingName
	 */
	public void setbuildingName(java.lang.String buildingName) {
		this.buildingName = buildingName;
	}

	/**
	 * 获取代理商用户ID属性
	 *
	 * @return agentId
	 */
	public java.lang.Integer getagentId() {
		return agentId;
	}

	/**
	 * 设置代理商用户ID属性
	 *
	 * @param agentId
	 */
	public void setagentId(java.lang.Integer agentId) {
		this.agentId = agentId;
	}

	/**
	 * 获取开发商属性
	 *
	 * @return developer
	 */
	public java.lang.String getdeveloper() {
		return developer;
	}

	/**
	 * 设置开发商属性
	 *
	 * @param developer
	 */
	public void setdeveloper(java.lang.String developer) {
		this.developer = developer;
	}

	/**
	 * 获取电话属性
	 *
	 * @return phone
	 */
	public java.lang.String getPhone() {
		return phone;
	}

	/**
	 * 设置电话属性
	 *
	 * @param phone
	 */
	public void setPhone(java.lang.String phone) {
		this.phone = phone;
	}

	/**
	 * 获取均价属性
	 *
	 * @return averagePrice
	 */
	public java.lang.Integer getaveragePrice() {
		return averagePrice;
	}

	/**
	 * 设置均价属性
	 *
	 * @param averagePrice
	 */
	public void setaveragePrice(java.lang.Integer averagePrice) {
		this.averagePrice = averagePrice;
	}

	/**
	 * 获取区间最小值属性
	 *
	 * @return sectionMin
	 */
	public java.lang.Integer getsectionMin() {
		return sectionMin;
	}

	/**
	 * 设置区间最小值属性
	 *
	 * @param sectionMin
	 */
	public void setsectionMin(java.lang.Integer sectionMin) {
		this.sectionMin = sectionMin;
	}

	/**
	 * 获取区间最大值属性
	 *
	 * @return sectionMax
	 */
	public java.lang.Integer getsectionMax() {
		return sectionMax;
	}

	/**
	 * 设置区间最大值属性
	 *
	 * @param sectionMax
	 */
	public void setsectionMax(java.lang.Integer sectionMax) {
		this.sectionMax = sectionMax;
	}

	/**
	 * 获取地址属性
	 *
	 * @return address
	 */
	public java.lang.String getAddress() {
		return address;
	}

	/**
	 * 设置地址属性
	 *
	 * @param address
	 */
	public void setAddress(java.lang.String address) {
		this.address = address;
	}

	/**
	 * 获取置位属性
	 *
	 * @return position
	 */
	public java.lang.String getPosition() {
		return position;
	}

	/**
	 * 设置置位属性
	 *
	 * @param position
	 */
	public void setPosition(java.lang.String position) {
		this.position = position;
	}

	/**
	 * 获取区县属性
	 *
	 * @return county
	 */
	public java.lang.Integer getCounty() {
		return county;
	}

	/**
	 * 设置区县属性
	 *
	 * @param county
	 */
	public void setCounty(java.lang.Integer county) {
		this.county = county;
	}

	/**
	 * 获取经度属性
	 *
	 * @return longitude
	 */
	public java.lang.String getLongitude() {
		return longitude;
	}

	/**
	 * 设置经度属性
	 *
	 * @param longitude
	 */
	public void setLongitude(java.lang.String longitude) {
		this.longitude = longitude;
	}

	/**
	 * 获取纬度属性
	 *
	 * @return latitude
	 */
	public java.lang.String getLatitude() {
		return latitude;
	}

	/**
	 * 设置纬度属性
	 *
	 * @param latitude
	 */
	public void setLatitude(java.lang.String latitude) {
		this.latitude = latitude;
	}

	/**
	 * 获取周边配套属性
	 *
	 * @return surrounding
	 */
	public java.lang.String getSurrounding() {
		return surrounding;
	}

	/**
	 * 设置周边配套属性
	 *
	 * @param surrounding
	 */
	public void setSurrounding(java.lang.String surrounding) {
		this.surrounding = surrounding;
	}

	/**
	 * 获取楼盘信息属性
	 *
	 * @return buildingInfo
	 */
	public java.lang.String getbuildingInfo() {
		return buildingInfo;
	}

	/**
	 * 设置楼盘信息属性
	 *
	 * @param buildingInfo
	 */
	public void setbuildingInfo(java.lang.String buildingInfo) {
		this.buildingInfo = buildingInfo;
	}

	/**
	 * 获取banner图片属性
	 *
	 * @return banner
	 */
	public java.lang.String getBanner() {
		return banner;
	}

	/**
	 * 设置banner图片属性
	 *
	 * @param banner
	 */
	public void setBanner(java.lang.String banner) {
		this.banner = banner;
	}

	/**
	 * 获取创建者：记录用户的创建人员的名称。属性
	 *
	 * @return creatorUserId
	 */
	public java.lang.Integer getcreatorUserId() {
		return creatorUserId;
	}

	/**
	 * 设置创建者：记录用户的创建人员的名称。属性
	 *
	 * @param creatorUserId
	 */
	public void setcreatorUserId(java.lang.Integer creatorUserId) {
		this.creatorUserId = creatorUserId;
	}

	/**
	 * 获取创建时间：记录用户的创建时间。属性
	 *
	 * @return createTime
	 */
	public java.util.Date getcreateTime() {
		return createTime;
	}

	/**
	 * 设置创建时间：记录用户的创建时间。属性
	 *
	 * @param createTime
	 */
	public void setcreateTime(java.util.Date createTime) {
		this.createTime = createTime;
	}

	/**
	 * 获取属性
	 *
	 * @return updateUserId
	 */
	public java.lang.Integer getupdateUserId() {
		return updateUserId;
	}

	/**
	 * 设置属性
	 *
	 * @param updateUserId
	 */
	public void setupdateUserId(java.lang.Integer updateUserId) {
		this.updateUserId = updateUserId;
	}

	/**
	 * 获取数据更新时间属性
	 *
	 * @return updateTime
	 */
	public java.util.Date getupdateTime() {
		return updateTime;
	}

	/**
	 * 设置数据更新时间属性
	 *
	 * @param updateTime
	 */
	public void setupdateTime(java.util.Date updateTime) {
		this.updateTime = updateTime;
	}

	/**
	 * 获取0：无效，1：有效属性
	 *
	 * @return isValid
	 */
	public java.lang.Short getisValid() {
		return isValid;
	}

	/**
	 * 设置0：无效，1：有效属性
	 *
	 * @param isValid
	 */
	public void setisValid(java.lang.Short isValid) {
		this.isValid = isValid;
	}

	public java.lang.String getAccount() {
		return account;
	}

	public void setAccount(java.lang.String account) {
		this.account = account;
	}

	public java.lang.String getName() {
		return name;
	}

	public void setName(java.lang.String name) {
		this.name = name;
	}

	public java.util.Date getUserCreateTime() {
		return userCreateTime;
	}

	public void setUserCreateTime(java.util.Date userCreateTime) {
		this.userCreateTime = userCreateTime;
	}

	public java.lang.Short getUserIsValid() {
		return userIsValid;
	}

	public void setUserIsValid(java.lang.Short userIsValid) {
		this.userIsValid = userIsValid;
	}

	public java.lang.Integer getUserId() {
		return userId;
	}

	public void setUserId(java.lang.Integer userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "BuildingDataSet [buildingId=" + buildingId + ", buildingName=" + buildingName + ", agentId=" + agentId + ", developer="
				+ developer + ", phone=" + phone + ", averagePrice=" + averagePrice + ", sectionMin=" + sectionMin + ", sectionMax="
				+ sectionMax + ", address=" + address + ", position=" + position + ", county=" + county + ", longitude=" + longitude
				+ ", latitude=" + latitude + ", surrounding=" + surrounding + ", buildingInfo=" + buildingInfo + ", banner=" + banner
				+ ", creatorUserId=" + creatorUserId + ", createTime=" + createTime + ", updateUserId=" + updateUserId + ", updateTime="
				+ updateTime + ", isValid=" + isValid + ", userId=" + userId + ", account=" + account + ", name=" + name
				+ ", userCreateTime=" + userCreateTime + ", userIsValid=" + userIsValid + "]";
	}

}