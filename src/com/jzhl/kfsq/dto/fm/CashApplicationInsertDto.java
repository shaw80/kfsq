package com.jzhl.kfsq.dto.fm;

/**
 * 添加提现申请dto
 * 
 * @author Shaw
 *
 */
public class CashApplicationInsertDto {
	
	private String price;// 提现金额
	
	private String account;// 账户信息
	
	private Integer memberId;// 会员编号
	
	private String accountType;// 账户类型
	
	private String isDefault;// 是否默认
	
	private String accountName;//  账户姓名（真实姓名）

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getIsDefault() {
		return isDefault;
	}

	public void setIsDefault(String isDefault) {
		this.isDefault = isDefault;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public Integer getMemberId() {
		return memberId;
	}

	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

}
