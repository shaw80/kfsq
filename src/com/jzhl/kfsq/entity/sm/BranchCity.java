package com.jzhl.kfsq.entity.sm;

import java.io.Serializable;

/**
 * 
 * SM_BranchCity表
 * 
 * @author mew
 *
 */
public class BranchCity implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer id;// 主键
	private java.lang.Integer branchCityId; //
	private java.lang.Integer status; // 0：未开通、1：开通
	private java.lang.Integer updateUserId; // 更新人
	private java.sql.Timestamp updateTime; // 数据更新时间
	private java.lang.Integer creatorUserId; // 创建者：记录用户的创建人员的名称
	private java.sql.Timestamp createTime; //

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public java.lang.Integer getBranchCityId() {
		return branchCityId;
	}

	public void setBranchCityId(java.lang.Integer branchCityId) {
		this.branchCityId = branchCityId;
	}

	public java.lang.Integer getStatus() {
		return status;
	}

	public void setStatus(java.lang.Integer status) {
		this.status = status;
	}

	public java.lang.Integer getUpdateUserId() {
		return updateUserId;
	}

	public void setUpdateUserId(java.lang.Integer updateUserId) {
		this.updateUserId = updateUserId;
	}

	public java.sql.Timestamp getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(java.sql.Timestamp updateTime) {
		this.updateTime = updateTime;
	}

	public java.lang.Integer getCreatorUserId() {
		return creatorUserId;
	}

	public void setCreatorUserId(java.lang.Integer creatorUserId) {
		this.creatorUserId = creatorUserId;
	}

	public java.sql.Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(java.sql.Timestamp createTime) {
		this.createTime = createTime;
	}

	@Override
	public String toString() {
		return "BranchCity [id=" + id + ", branchCityId=" + branchCityId
				+ ", status=" + status + ", updateUserId=" + updateUserId
				+ ", updateTime=" + updateTime + ", creatorUserId="
				+ creatorUserId + ", createTime=" + createTime + "]";
	}
	
}