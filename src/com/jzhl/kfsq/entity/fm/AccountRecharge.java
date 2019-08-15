package com.jzhl.kfsq.entity.fm;

import java.io.Serializable;

/**
 * 
 * FM_AccountRecharge表
 * 
 * @author zhouzy
 *
 */
public class AccountRecharge implements Serializable {
	private static final long serialVersionUID = 1L;
	private java.lang.Integer rechargeId; // 充值编号
	private java.lang.String rechargeWay; // 充值方式（0：线上，1：线下）
	private java.lang.String rechargeType; // 充值类型（0：平台代充，1：代理商代充，2：开发商充值）
	private java.lang.Integer receiveAccountId; // 接收账户编号
	private java.lang.Integer payAccountId; // 支付账户编号
	private java.math.BigDecimal price; // 充值金额
	private java.lang.Short status; // 充值状态（0：成功，1：失败）
	private java.lang.String serialNum; // 交易流水号（支付宝流水号，微信交易号，网银流水号）
	private java.lang.String failInfo; // 失败信息
	private java.lang.String contractNum; // 合同号
	private java.lang.Short isValid; // 0：无效，1：有效
	private java.lang.Integer creatorUserId; // 创建者：记录用户的创建人员的名称。
	private java.sql.Timestamp payTime; // 支付时间

	private java.lang.String areaName; // 城市
	private java.lang.String comanyName; // 代理商名称
	private java.lang.String leadName; // 负责人
	private java.lang.String phone; // 联系方式
	private java.lang.Integer branchId; // 代理商ID

	public java.lang.Integer getRechargeId() {
		return rechargeId;
	}

	public void setRechargeId(java.lang.Integer rechargeId) {
		this.rechargeId = rechargeId;
	}

	public java.lang.String getRechargeWay() {
		return rechargeWay;
	}

	public void setRechargeWay(java.lang.String rechargeWay) {
		this.rechargeWay = rechargeWay;
	}

	public java.lang.String getRechargeType() {
		return rechargeType;
	}

	public void setRechargeType(java.lang.String rechargeType) {
		this.rechargeType = rechargeType;
	}

	public java.lang.Integer getReceiveAccountId() {
		return receiveAccountId;
	}

	public void setReceiveAccountId(java.lang.Integer receiveAccountId) {
		this.receiveAccountId = receiveAccountId;
	}

	public java.lang.Integer getPayAccountId() {
		return payAccountId;
	}

	public void setPayAccountId(java.lang.Integer payAccountId) {
		this.payAccountId = payAccountId;
	}

	public java.math.BigDecimal getPrice() {
		return price;
	}

	public void setPrice(java.math.BigDecimal price) {
		this.price = price;
	}

	public java.lang.Short getStatus() {
		return status;
	}

	public void setStatus(java.lang.Short status) {
		this.status = status;
	}

	public java.lang.String getSerialNum() {
		return serialNum;
	}

	public void setSerialNum(java.lang.String serialNum) {
		this.serialNum = serialNum;
	}

	public java.lang.String getFailInfo() {
		return failInfo;
	}

	public void setFailInfo(java.lang.String failInfo) {
		this.failInfo = failInfo;
	}

	public java.lang.String getContractNum() {
		return contractNum;
	}

	public void setContractNum(java.lang.String contractNum) {
		this.contractNum = contractNum;
	}

	public java.lang.Short getIsValid() {
		return isValid;
	}

	public void setIsValid(java.lang.Short isValid) {
		this.isValid = isValid;
	}

	public java.lang.Integer getCreatorUserId() {
		return creatorUserId;
	}

	public void setCreatorUserId(java.lang.Integer creatorUserId) {
		this.creatorUserId = creatorUserId;
	}

	public java.sql.Timestamp getPayTime() {
		return payTime;
	}

	public void setPayTime(java.sql.Timestamp payTime) {
		this.payTime = payTime;
	}

	public java.lang.String getAreaName() {
		return areaName;
	}

	public void setAreaName(java.lang.String areaName) {
		this.areaName = areaName;
	}

	public java.lang.String getComanyName() {
		return comanyName;
	}

	public void setComanyName(java.lang.String comanyName) {
		this.comanyName = comanyName;
	}

	public java.lang.String getLeadName() {
		return leadName;
	}

	public void setLeadName(java.lang.String leadName) {
		this.leadName = leadName;
	}

	public java.lang.String getPhone() {
		return phone;
	}

	public void setPhone(java.lang.String phone) {
		this.phone = phone;
	}

	public java.lang.Integer getBranchId() {
		return branchId;
	}

	public void setBranchId(java.lang.Integer branchId) {
		this.branchId = branchId;
	}

	@Override
	public String toString() {
		return "AccountRecharge [rechargeId=" + rechargeId + ", rechargeWay=" + rechargeWay + ", rechargeType=" + rechargeType
				+ ", receiveAccountId=" + receiveAccountId + ", payAccountId=" + payAccountId + ", price=" + price + ", status=" + status
				+ ", serialNum=" + serialNum + ", failInfo=" + failInfo + ", contractNum=" + contractNum + ", isValid=" + isValid
				+ ", creatorUserId=" + creatorUserId + ", payTime=" + payTime + ", areaName=" + areaName + ", comanyName=" + comanyName
				+ ", leadName=" + leadName + ", phone=" + phone + ", branchId=" + branchId + "]";
	}

}