package com.jzhl.kfsq.dto.sm;

import java.io.Serializable;

/**
 * 角色权限中间表DTO
 * 
 * @author Shaw
 *
 */
public class RoleRightDto implements Serializable {

	private static final long serialVersionUID = -7332127218978108600L;
	
	private String roleId;// 角色编号
	
	private String rightId;// 权限编号，用","间隔的字符串
	
	private Integer creatorUserId;// 创建者编号
	
	private String roleName;// 权限名称
	
	private String roleCode;// 角色编码

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getRightId() {
		return rightId;
	}

	public void setRightId(String rightId) {
		this.rightId = rightId;
	}

	public Integer getCreatorUserId() {
		return creatorUserId;
	}

	public void setCreatorUserId(Integer creatorUserId) {
		this.creatorUserId = creatorUserId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleCode() {
		return roleCode;
	}

	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}

	@Override
	public String toString() {
		return "RoleRightDto [roleId=" + roleId + ", rightId=" + rightId
				+ ", creatorUserId=" + creatorUserId + ", roleName=" + roleName
				+ ", roleCode=" + roleCode + "]";
	}

}
