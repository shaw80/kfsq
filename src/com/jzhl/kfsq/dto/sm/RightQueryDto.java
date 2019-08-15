package com.jzhl.kfsq.dto.sm;

import java.io.Serializable;

/**
 * WEB端权限查询DTO
 * 
 * @author Shaw
 *
 */
public class RightQueryDto implements Serializable {

	private static final long serialVersionUID = 9064657474858082451L;// 序列化
	
	private Integer roleId;// 角色编号
	
	private Integer parentId;// 父编号
	
	private String roleCode;// 角色编码
	
	private String roleName;// 角色名称

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
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
		return "RightQueryDto [roleId=" + roleId + ", parentId=" + parentId
				+ ", roleCode=" + roleCode + ", roleName=" + roleName + "]";
	}

}
