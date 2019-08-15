package com.jzhl.kfsq.dto.sm;

import java.io.Serializable;
import java.sql.Date;

import com.jzhl.kfsq.common.base.PageListCondition;

/**
 * 角色实体类
 * 
 * @author zhouzy
 *
 */
public class RoleDto extends PageListCondition implements Serializable {

	private static final long serialVersionUID = -7850476795599218850L;// 序列化

	private Integer roleId;// 角色编号

	private String roleName;// 角色名称
	
	private String roleCode;// 角色编码

	private Integer status;// 状态（0：无效、1：有效）

	private Integer creatorUserId;// 创建者编号

	private Date createTime;// 创建时间

	private Integer updateUserId;// 更新者编号

	private Date updateTime;// 更新时间

	private String rightList; // 权限字符串rightId列表，用“，”分开

	public String getRoleCode() {
		return roleCode;
	}

	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getCreatorUserId() {
		return creatorUserId;
	}

	public void setCreatorUserId(Integer creatorUserId) {
		this.creatorUserId = creatorUserId;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Integer getUpdateUserId() {
		return updateUserId;
	}

	public void setUpdateUserId(Integer updateUserId) {
		this.updateUserId = updateUserId;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getRightList() {
		return rightList;
	}

	public void setRightList(String rightList) {
		this.rightList = rightList;
	}

	@Override
	public String toString() {
		return "RoleDto [roleId=" + roleId + ", roleName=" + roleName
				+ ", roleCode=" + roleCode + ", status=" + status
				+ ", creatorUserId=" + creatorUserId + ", createTime="
				+ createTime + ", updateUserId=" + updateUserId
				+ ", updateTime=" + updateTime + ", rightList=" + rightList
				+ "]";
	}

}
