package com.jzhl.kfsq.dto.sm;

import java.io.Serializable;

/**
 * 验证用户账户是否存在DTO
 * 
 * @author Shaw
 *
 */
public class ValiAccountDto implements Serializable {

	private static final long serialVersionUID = 3092069060276419176L;// 序列化
	
	private String account;// 用户账户

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	@Override
	public String toString() {
		return "ValiAccountDto [account=" + account + "]";
	}

}
