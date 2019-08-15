package com.jzhl.kfsq.dto.login;

import java.io.Serializable;

/**
 * 角色切换Dto
 * 
 * @author Shaw
 *
 */
public class RoleChangeDto implements Serializable {

	private static final long serialVersionUID = -3922306698284997614L;// 序列化
	
	private Integer userId;// 用户编号

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "RoleChangeDto [userId=" + userId + "]";
	}

}
