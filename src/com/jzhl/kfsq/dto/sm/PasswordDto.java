package com.jzhl.kfsq.dto.sm;

import java.io.Serializable;

/**
 * 修改用户密码dto
 * @author Shaw
 *
 */
public class PasswordDto implements Serializable {

	private static final long serialVersionUID = 1472228193951440527L;// 序列化
	
	private Integer userId;// 用户编号
	
	private String oldPassword;// 旧密码
	
	private String newPassword;// 新密码

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	@Override
	public String toString() {
		return "PasswordDto [userId=" + userId + ", oldPassword=" + oldPassword
				+ ", newPassword=" + newPassword + "]";
	}

}
