package com.jzhl.kfsq.dto.sm;

import java.io.Serializable;

/**
 * 根据支付宝等账户查询账户信息DTO
 * 
 * @author Shaw
 *
 */
public class AccountNumDto implements Serializable {
	
	private static final long serialVersionUID = -1753688833040806447L;
	
	private String accountNum;// 支付宝等账户

	public String getAccountNum() {
		return accountNum;
	}

	public void setAccountNum(String accountNum) {
		this.accountNum = accountNum;
	}

	@Override
	public String toString() {
		return "AccountNumDto [accountNum=" + accountNum + "]";
	}

}
