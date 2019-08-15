package com.jzhl.kfsq.dto.login;

import java.io.Serializable;

/**
 * shiro底层角色查询dto
 * 
 * @author Shaw
 *
 */
public class RoleDto implements Serializable {

	private static final long serialVersionUID = 2306363406003085640L;// 序列化

	private Integer roleId;// 角色编号

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	@Override
	public String toString() {
		return "RoleDto [roleId=" + roleId + "]";
	}

}
