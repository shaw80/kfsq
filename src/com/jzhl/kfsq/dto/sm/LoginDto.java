package com.jzhl.kfsq.dto.sm;

import java.io.Serializable;

/**
 * 登录dto
 * 
 * @author Shaw
 *
 */
public class LoginDto implements Serializable {

	private static final long serialVersionUID = 7550238874541918098L;// 序列化
	
	private String account;// 账户
	
	private String password;// 密码

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "LoginDto [account=" + account + ", password=" + password + "]";
	}

}
