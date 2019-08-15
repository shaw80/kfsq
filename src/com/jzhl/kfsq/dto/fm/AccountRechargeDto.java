package com.jzhl.kfsq.dto.fm;

import java.io.Serializable;

import com.jzhl.kfsq.common.base.PageListCondition;

/**
 * 
 * FM_AccountRecharge表
 * 
 * @author zhouzy
 *
 */
public class AccountRechargeDto extends PageListCondition implements Serializable {
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

	private java.lang.String keyword; // 关键字
	private java.lang.String dateStart; // 支付时间
	private java.lang.String dateEnd; // 支付时间
	private java.lang.Integer userId; // 代理商Id;登录者ID
	private java.lang.Short appUserType; // 是否是销售总监，用来区分登录者信息；是代理商还是销售总监；
	private java.lang.String isDownFlag; // 是否为excel导出

	private java.lang.String dateFlag; // 日期筛选；1:7天 ，2:1个月，3：三个月

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

	public java.lang.String getKeyword() {
		return keyword;
	}

	public void setKeyword(java.lang.String keyword) {
		this.keyword = keyword;
	}

	public java.lang.String getDateStart() {
		return dateStart;
	}

	public void setDateStart(java.lang.String dateStart) {
		this.dateStart = dateStart;
	}

	public java.lang.String getDateEnd() {
		return dateEnd;
	}

	public void setDateEnd(java.lang.String dateEnd) {
		this.dateEnd = dateEnd;
	}

	public java.lang.Integer getUserId() {
		return userId;
	}

	public void setUserId(java.lang.Integer userId) {
		this.userId = userId;
	}

	public java.lang.Short getAppUserType() {
		return appUserType;
	}

	public void setAppUserType(java.lang.Short appUserType) {
		this.appUserType = appUserType;
	}

	public java.lang.String getIsDownFlag() {
		return isDownFlag;
	}

	public void setIsDownFlag(java.lang.String isDownFlag) {
		this.isDownFlag = isDownFlag;
	}

	public java.lang.String getDateFlag() {
		return dateFlag;
	}

	public void setDateFlag(java.lang.String dateFlag) {
		this.dateFlag = dateFlag;
	}

	@Override
	public String toString() {
		return "AccountRechargeDto [rechargeId=" + rechargeId + ", rechargeWay=" + rechargeWay + ", rechargeType=" + rechargeType
				+ ", receiveAccountId=" + receiveAccountId + ", payAccountId=" + payAccountId + ", price=" + price + ", status=" + status
				+ ", serialNum=" + serialNum + ", failInfo=" + failInfo + ", contractNum=" + contractNum + ", isValid=" + isValid
				+ ", creatorUserId=" + creatorUserId + ", payTime=" + payTime + ", keyword=" + keyword + ", dateStart=" + dateStart
				+ ", dateEnd=" + dateEnd + ", userId=" + userId + ", appUserType=" + appUserType + ", isDownFlag=" + isDownFlag
				+ ", dateFlag=" + dateFlag + "]";
	}

}