package com.jzhl.kfsq.dataset.fm;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * web端提现结果集
 * 
 * @author Shaw
 *
 */
public class CashDataSet implements Serializable {

	private static final long serialVersionUID = -97985288997412364L;// 序列化
	
	private String applicationId;// 申请编号
	
	private String nickName;// 会员名称
	
	private String account;// 会员账户
	
	private String applicationTime;// 提现申请时间
	
	private String accountType;// 账户类型
	
	private BigDecimal price;// 提现金额
	
	private BigDecimal balance;// 账户余额
	
	private String status;// 提现状态
	
	private String statusCode;// 支付状态码

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	public String getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(String applicationId) {
		this.applicationId = applicationId;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getApplicationTime() {
		return applicationTime;
	}

	public void setApplicationTime(String applicationTime) {
		this.applicationTime = applicationTime;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "CashDataSet [applicationId=" + applicationId + ", nickName="
				+ nickName + ", account=" + account + ", applicationTime="
				+ applicationTime + ", accountType=" + accountType + ", price="
				+ price + ", balance=" + balance + ", status=" + status
				+ ", statusCode=" + statusCode + "]";
	}

}
