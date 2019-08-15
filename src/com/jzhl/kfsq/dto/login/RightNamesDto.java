package com.jzhl.kfsq.dto.login;

import java.io.Serializable;

/**
 * 权限名称dto
 * 
 * @author Shaw
 *
 */
public class RightNamesDto implements Serializable {

	private static final long serialVersionUID = -6821240031370370658L;// 序列化

	private Integer roleId;// 角色编号

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	@Override
	public String toString() {
		return "RightNamesDto [roleId=" + roleId + "]";
	}

}
