package com.jzhl.kfsq.dto.sm;

import java.io.Serializable;

public class AccountReceiveDto implements Serializable {

	private static final long serialVersionUID = -5073785811620468268L;// 序列化

	private java.lang.String accountId;// 账户编号

	private java.lang.String accountType; // 账户类型（0：支付宝，1：银行卡）

	private java.lang.String userType; // 用户类型（0：user，1：member）

	private java.lang.String userId; // 用户编号，当用户类型为user，则关联user表的userId；当用户类型为member，则关联member的memberId

	private java.lang.String accountNum; // 账户

	private java.lang.String accountName; // 账户姓名

	private java.lang.String openBank; // 开户行

	private java.lang.String isDefault; // 是否默认（0：非默认，1：默认）

	private java.lang.String isValid; // 0：无效，1：有效

	private java.lang.String creatorUserId; // 创建者：记录用户的创建人员的名称

	private java.lang.String updateUserId; // 更新人

	public java.lang.String getAccountId() {
		return accountId;
	}

	public void setAccountId(java.lang.String accountId) {
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

	public java.lang.String getUserId() {
		return userId;
	}

	public void setUserId(java.lang.String userId) {
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

	public java.lang.String getIsDefault() {
		return isDefault;
	}

	public void setIsDefault(java.lang.String isDefault) {
		this.isDefault = isDefault;
	}

	public java.lang.String getIsValid() {
		return isValid;
	}

	public void setIsValid(java.lang.String isValid) {
		this.isValid = isValid;
	}

	public java.lang.String getCreatorUserId() {
		return creatorUserId;
	}

	public void setCreatorUserId(java.lang.String creatorUserId) {
		this.creatorUserId = creatorUserId;
	}

	public java.lang.String getUpdateUserId() {
		return updateUserId;
	}

	public void setUpdateUserId(java.lang.String updateUserId) {
		this.updateUserId = updateUserId;
	}

	@Override
	public String toString() {
		return "AccountDto [accountId=" + accountId + ", accountType="
				+ accountType + ", userType=" + userType + ", userId=" + userId
				+ ", accountNum=" + accountNum + ", accountName=" + accountName
				+ ", openBank=" + openBank + ", isDefault=" + isDefault
				+ ", isValid=" + isValid + ", creatorUserId=" + creatorUserId
				+ ", updateUserId=" + updateUserId + "]";
	}

}
