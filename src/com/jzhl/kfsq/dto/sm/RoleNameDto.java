package com.jzhl.kfsq.dto.sm;

import java.io.Serializable;

/**
 * 查询角色名称是否唯一DTO
 * @author Shaw
 *
 */
public class RoleNameDto implements Serializable {

	private static final long serialVersionUID = 6185968992611571444L;// 序列化
	
	private String roleName;// 角色名称
	
	private String managerType;// 管理端类型（0：admin后台，1：楼盘后台，2：代理商后台）
	
	private Integer roleId;// 角色编号

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getManagerType() {
		return managerType;
	}

	public void setManagerType(String managerType) {
		this.managerType = managerType;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	@Override
	public String toString() {
		return "RoleNameDto [roleName=" + roleName + ", managerType="
				+ managerType + ", roleId=" + roleId + "]";
	}

}
