package com.jzhl.kfsq.dto.sm;

import java.io.Serializable;

/**
 * 
 * SM_Account表
 * 
 * @author zhouzy
 *
 */
public class AccountDto implements Serializable {

	private static final long serialVersionUID = 1L;
	private java.lang.Integer accountId; // 账户编号
	private java.lang.String accountType; // 账户类型（0：支付宝，1：微信，2：银行卡）
	private java.lang.String userType; // 用户类型（0：user，1：member）
	private java.lang.Integer userId; // 用户编号，当用户类型为user，则关联user表的userId；当用户类型为member，则关联member的memberId
	private java.lang.String accountNum; // 账户
	private java.lang.String accountName; // 账户姓名
	private java.lang.String openBank; // 开户行
	private java.lang.Short isDefault; // 是否默认（0：非默认，1：默认）
	private java.lang.Short isValid; // 0：无效，1：有效
	private java.lang.Integer creatorUserId; // 创建者：记录用户的创建人员的名称
	private java.sql.Timestamp createTime; // 创建时间：记录用户的创建时间
	private java.lang.Integer updateUserId; // 更新人
	private java.sql.Timestamp updateTime; // 数据更新时间

	public java.lang.Integer getAccountId() {
		return accountId;
	}

	public void setAccountId(java.lang.Integer accountId) {
		this.accountId = accountId;
	}

	public java.lang.String getAccountType() {
		return accountType;
	}

	public void setAccountType(java.lang.String accountType) {
		this.accountType = accountType;
	}

	public java.lang.String getUserType() {
		return userType;
	}

	public void setUserType(java.lang.String userType) {
		this.userType = userType;
	}

	public java.lang.Integer getUserId() {
		return userId;
	}

	public void setUserId(java.lang.Integer userId) {
		this.userId = userId;
	}

	public java.lang.String getAccountNum() {
		return accountNum;
	}

	public void setAccountNum(java.lang.String accountNum) {
		this.accountNum = accountNum;
	}

	public java.lang.String getAccountName() {
		return accountName;
	}

	public void setAccountName(java.lang.String accountName) {
		this.accountName = accountName;
	}

	public java.lang.String getOpenBank() {
		return openBank;
	}

	public void setOpenBank(java.lang.String openBank) {
		this.openBank = openBank;
	}

	public java.lang.Short getIsDefault() {
		return isDefault;
	}

	public void setIsDefault(java.lang.Short isDefault) {
		this.isDefault = isDefault;
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

	public java.sql.Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(java.sql.Timestamp createTime) {
		this.createTime = createTime;
	}

	public java.lang.Integer getUpdateUserId() {
		return updateUserId;
	}

	public void setUpdateUserId(java.lang.Integer updateUserId) {
		this.updateUserId = updateUserId;
	}

	public java.sql.Timestamp getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(java.sql.Timestamp updateTime) {
		this.updateTime = updateTime;
	}

	@Override
	public String toString() {
		return "AccountDto [accountId=" + accountId + ", accountType=" + accountType + ", userType=" + userType + ", userId=" + userId
				+ ", accountNum=" + accountNum + ", accountName=" + accountName + ", openBank=" + openBank + ", isDefault=" + isDefault
				+ ", isValid=" + isValid + ", creatorUserId=" + creatorUserId + ", createTime=" + createTime + ", updateUserId="
				+ updateUserId + ", updateTime=" + updateTime + "]";
	}

}