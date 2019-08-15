package com.jzhl.kfsq.entity.sm;

import java.io.Serializable;
import java.sql.Date;

/**
 * 角色权限中间表实体类
 * 
 * @author Shaw
 *
 */
public class RoleRight implements Serializable {

	private static final long serialVersionUID = -6684280242003134177L;// 序列化
	
	private Integer roleRightId;// 中间表编号，主键
	
	private Integer roleId;// 角色编号
	
	private Integer rightId;// 权限编号
	
	private Integer isValid;// 状态（0：无效、1：有效）
	
	private Integer creatorUserId;// 创建者编号
	
	private Date createTime;// 创建时间
	
	private Integer updateUserId;// 更新者编号
	
	private Date updateTime;// 更新时间

	public Integer getRoleRightId() {
		return roleRightId;
	}

	public void setRoleRightId(Integer roleRightId) {
		this.roleRightId = roleRightId;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public Integer getRightId() {
		return rightId;
	}

	public void setRightId(Integer rightId) {
		this.rightId = rightId;
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

	@Override
	public String toString() {
		return "RoleRight [roleRightId=" + roleRightId + ", roleId=" + roleId
				+ ", rightId=" + rightId + ", isValid=" + isValid
				+ ", creatorUserId=" + creatorUserId + ", createTime="
				+ createTime + ", updateUserId=" + updateUserId
				+ ", updateTime=" + updateTime + "]";
	}

}
