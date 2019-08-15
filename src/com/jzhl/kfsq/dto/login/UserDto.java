package com.jzhl.kfsq.dto.login;

import java.io.Serializable;

/**
 * shiro底层用户dto
 * 
 * @author Shaw
 *
 */
public class UserDto implements Serializable {

	private static final long serialVersionUID = 977382193382967359L;// 序列化
	
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
		return "ShiroUserDto [account=" + account + ", password=" + password
				+ "]";
	}

}
