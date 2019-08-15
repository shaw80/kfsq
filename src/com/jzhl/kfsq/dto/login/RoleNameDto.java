package com.jzhl.kfsq.dto.login;

import java.io.Serializable;

/**
 * 查询角色名称dto
 * 
 * @author Shaw
 *
 */
public class RoleNameDto implements Serializable {

	private static final long serialVersionUID = 7390243405084420228L;// 序列化
	
	private Integer userId;// 用户编号

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "RoleNameDto [userId=" + userId + "]";
	}

}
