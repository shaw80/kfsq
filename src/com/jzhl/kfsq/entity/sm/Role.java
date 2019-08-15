package com.jzhl.kfsq.entity.sm;

import java.io.Serializable;
import java.sql.Date;

/**
 * 角色实体类
 * 
 * @author Shaw
 *
 */
public class Role implements Serializable {

	private static final long serialVersionUID = -7850476795599218850L;// 序列化

	private Integer roleId;// 角色编号（主键）

	private String roleName;// 角色名称
	
	private String roleCode;// 角色编码
	
	private String roleType;// 角色类型（0：系统，1：用户自定义）
	
	private String managerType;// 管理端类型（0：admin后台，1：楼盘后台，2：代理商后台）

	private Integer isValid;// 状态（0：无效、1：有效）

	private Integer creatorUserId;// 创建者编号

	private Date createTime;// 创建时间

	private Integer updateUserId;// 更新者编号

	private Date updateTime;// 更新时间

	private String rightName; // 权限名称

	private Integer rightId; // 权限ID

	public String getRoleCode() {
		return roleCode;
	}

	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}

	public String getRoleType() {
		return roleType;
	}

	public void setRoleType(String roleType) {
		this.roleType = roleType;
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

	public Integer getIsValid() {
		return isValid;
	}

	public void setIsValid(Integer isValid) {
		this.isValid = isValid;
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

	public String getRightName() {
		return rightName;
	}

	public void setRightName(String rightName) {
		this.rightName = rightName;
	}

	public Integer getRightId() {
		return rightId;
	}

	public void setRightId(Integer rightId) {
		this.rightId = rightId;
	}

	public String getManagerType() {
		return managerType;
	}

	public void setManagerType(String managerType) {
		this.managerType = managerType;
	}

	@Override
	public String toString() {
		return "Role [roleId=" + roleId + ", roleName=" + roleName
				+ ", roleCode=" + roleCode + ", roleType=" + roleType
				+ ", managerType=" + managerType + ", isValid=" + isValid
				+ ", creatorUserId=" + creatorUserId + ", createTime="
				+ createTime + ", updateUserId=" + updateUserId
				+ ", updateTime=" + updateTime + ", rightName=" + rightName
				+ ", rightId=" + rightId + "]";
	}

}
