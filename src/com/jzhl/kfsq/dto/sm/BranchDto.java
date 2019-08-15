package com.jzhl.kfsq.dto.sm;

import java.io.Serializable;

import com.jzhl.kfsq.common.base.PageListCondition;

/**
 * 
 * SM_Branch表
 * 
 * @author mew
 *
 */
public class BranchDto extends PageListCondition implements Serializable {
	private static final long serialVersionUID = 1L;
	private java.lang.Integer branchId; // 分站编号
	private java.lang.String comanyName; // 公司名称
	private java.lang.String comanyAddress; // 公司地址
	private java.lang.String phone; // 电话
	private java.lang.String licence; // 执照图片
	private java.lang.String leadName; // 负责人姓名
	private java.lang.Short branchType; // 分站类型
	private java.lang.Integer branchCityId; //
	private java.lang.Integer contractTime; // 合同时间（1、2年）
	private java.math.BigDecimal upperPrive; // 领取上限金额
	private java.lang.Short status; // 0：无效、1：有效
	private java.lang.Integer creatorUserId; // 创建时间：记录用户的创建时间
	private java.sql.Timestamp createTime; //
	private java.lang.Integer updateUserId; // 更新人
	private java.sql.Timestamp updateTime; // 数据更新时间
	private java.lang.String areaName; // 所在城市
	private java.lang.String IDCardImg; // 负责人身份证图片
	private java.lang.String account; // 负责人身份证图片
	private java.lang.String password; // 负责人身份证图片

	private java.lang.Integer userId; // 代理商对应userId

	/**
	 * 获取分站编号属性
	 *
	 * @return branchid
	 */
	public java.lang.Integer getBranchId() {
		return branchId;
	}

	/**
	 * 设置分站编号属性
	 *
	 * @param branchid
	 */
	public void setBranchId(java.lang.Integer branchId) {
		this.branchId = branchId;
	}

	/**
	 * 获取公司名称属性
	 *
	 * @return comanyname
	 */
	public java.lang.String getComanyName() {
		return comanyName;
	}

	/**
	 * 设置公司名称属性
	 *
	 * @param comanyname
	 */
	public void setComanyName(java.lang.String comanyName) {
		this.comanyName = comanyName;
	}

	/**
	 * 获取公司地址属性
	 *
	 * @return comanyaddress
	 */
	public java.lang.String getComanyAddress() {
		return comanyAddress;
	}

	/**
	 * 设置公司地址属性
	 *
	 * @param comanyaddress
	 */
	public void setComanyAddress(java.lang.String comanyAddress) {
		this.comanyAddress = comanyAddress;
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
	 * 获取执照编号属性
	 *
	 * @return licence
	 */
	public java.lang.String getLicence() {
		return licence;
	}

	/**
	 * 设置执照编号属性
	 *
	 * @param licence
	 */
	public void setLicence(java.lang.String licence) {
		this.licence = licence;
	}

	/**
	 * 获取分站类型属性
	 *
	 * @return branchtype
	 */
	public java.lang.Short getBranchType() {
		return branchType;
	}

	/**
	 * 设置分站类型属性
	 *
	 * @param branchtype
	 */
	public void setBranchType(java.lang.Short branchType) {
		this.branchType = branchType;
	}

	/**
	 * 获取属性
	 *
	 * @return branchcityid
	 */
	public java.lang.Integer getBranchCityId() {
		return branchCityId;
	}

	/**
	 * 设置属性
	 *
	 * @param branchcityid
	 */
	public void setBranchCityId(java.lang.Integer branchCityId) {
		this.branchCityId = branchCityId;
	}

	/**
	 * 获取合同时间（1、2年）属性
	 *
	 * @return contracttime
	 */
	public java.lang.Integer getContractTime() {
		return contractTime;
	}

	/**
	 * 设置合同时间（1、2年）属性
	 *
	 * @param contracttime
	 */
	public void setContractTime(java.lang.Integer contractTime) {
		this.contractTime = contractTime;
	}

	/**
	 * 获取0：无效、1：有效属性
	 *
	 * @return status
	 */
	public java.lang.Short getStatus() {
		return status;
	}

	/**
	 * 设置0：无效、1：有效属性
	 *
	 * @param status
	 */
	public void setStatus(java.lang.Short status) {
		this.status = status;
	}

	/**
	 * 获取创建时间：记录用户的创建时间属性
	 *
	 * @return creatoruserid
	 */
	public java.lang.Integer getCreatorUserId() {
		return creatorUserId;
	}

	/**
	 * 设置创建时间：记录用户的创建时间属性
	 *
	 * @param creatoruserid
	 */
	public void setCreatorUserId(java.lang.Integer creatorUserId) {
		this.creatorUserId = creatorUserId;
	}

	/**
	 * 获取属性
	 *
	 * @return createtime
	 */
	public java.sql.Timestamp getCreateTime() {
		return createTime;
	}

	/**
	 * 设置属性
	 *
	 * @param createtime
	 */
	public void setCreateTime(java.sql.Timestamp createTime) {
		this.createTime = createTime;
	}

	/**
	 * 获取更新人属性
	 *
	 * @return updateuserid
	 */
	public java.lang.Integer getUpdateUserId() {
		return updateUserId;
	}

	/**
	 * 设置更新人属性
	 *
	 * @param updateuserid
	 */
	public void setUpdateUserId(java.lang.Integer updateUserId) {
		this.updateUserId = updateUserId;
	}

	/**
	 * 获取数据更新时间属性
	 *
	 * @return updatetime
	 */
	public java.sql.Timestamp getUpdateTime() {
		return updateTime;
	}

	/**
	 * 设置数据更新时间属性
	 *
	 * @param updatetime
	 */
	public void setUpdateTime(java.sql.Timestamp updateTime) {
		this.updateTime = updateTime;
	}

	public java.lang.String getLeadName() {
		return leadName;
	}

	public void setLeadName(java.lang.String leadName) {
		this.leadName = leadName;
	}

	public java.lang.String getAreaName() {
		return areaName;
	}

	public void setAreaName(java.lang.String areaName) {
		this.areaName = areaName;
	}

	public java.lang.String getIDCardImg() {
		return IDCardImg;
	}

	public void setIDCardImg(java.lang.String iDCardImg) {
		IDCardImg = iDCardImg;
	}

	public java.lang.String getAccount() {
		return account;
	}

	public void setAccount(java.lang.String account) {
		this.account = account;
	}

	public java.lang.String getPassword() {
		return password;
	}

	public void setPassword(java.lang.String password) {
		this.password = password;
	}

	public java.lang.Integer getUserId() {
		return userId;
	}

	public void setUserId(java.lang.Integer userId) {
		this.userId = userId;
	}

	public java.math.BigDecimal getUpperPrive() {
		return upperPrive;
	}

	public void setUpperPrive(java.math.BigDecimal upperPrive) {
		this.upperPrive = upperPrive;
	}

	@Override
	public String toString() {
		return "BranchDto [branchId=" + branchId + ", comanyName=" + comanyName + ", comanyAddress=" + comanyAddress + ", phone=" + phone
				+ ", licence=" + licence + ", leadName=" + leadName + ", branchType=" + branchType + ", branchCityId=" + branchCityId
				+ ", contractTime=" + contractTime + ", upperPrive=" + upperPrive + ", status=" + status + ", creatorUserId="
				+ creatorUserId + ", createTime=" + createTime + ", updateUserId=" + updateUserId + ", updateTime=" + updateTime
				+ ", areaName=" + areaName + ", IDCardImg=" + IDCardImg + ", account=" + account + ", password=" + password + ", userId="
				+ userId + "]";
	}

}