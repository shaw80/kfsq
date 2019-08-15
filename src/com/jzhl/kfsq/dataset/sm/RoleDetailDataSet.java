package com.jzhl.kfsq.dataset.sm;

import java.io.Serializable;

/**
 * 角色详情结果集
 * 
 * @author Shaw
 *
 */
public class RoleDetailDataSet implements Serializable {

	private static final long serialVersionUID = -2322226242233354389L;// 序列化
	
	private Integer roleId;// 角色编号
	
	private String roleCode;// 角色编码
	
	private String roleName;// 角色名称

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public String getRoleCode() {
		return roleCode;
	}

	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	@Override
	public String toString() {
		return "RoleDetailDataSet [roleId=" + roleId + ", roleCode=" + roleCode
				+ ", roleName=" + roleName + "]";
	}

}
