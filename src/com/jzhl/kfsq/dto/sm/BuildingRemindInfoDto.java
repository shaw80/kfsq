package com.jzhl.kfsq.dto.sm;

import java.io.Serializable;

import com.jzhl.kfsq.common.base.PageListCondition;

/**
 * 
 * SM_BuildingRemindInfo表
 * 
 * @author zhouzy
 *
 */
public class BuildingRemindInfoDto extends PageListCondition implements Serializable {

	private static final long serialVersionUID = -3278523247043493447L;

	private java.lang.Integer buildingRemindId; // 主键
	private java.lang.Integer branchId; // 分站编号
	private java.lang.Integer buildingId; // 楼盘编号
	private java.lang.String content; // 提醒内容
	private java.lang.Integer creatorUserId; // 创建者编号
	private java.util.Date createTime; // 创建时间

	public java.lang.Integer getBuildingRemindId() {
		return buildingRemindId;
	}

	public void setBuildingRemindId(java.lang.Integer buildingRemindId) {
		this.buildingRemindId = buildingRemindId;
	}

	public java.lang.Integer getBranchId() {
		return branchId;
	}

	public void setBranchId(java.lang.Integer branchId) {
		this.branchId = branchId;
	}

	public java.lang.Integer getBuildingId() {
		return buildingId;
	}

	public void setBuildingId(java.lang.Integer buildingId) {
		this.buildingId = buildingId;
	}

	public java.lang.String getContent() {
		return content;
	}

	public void setContent(java.lang.String content) {
		this.content = content;
	}

	public java.lang.Integer getCreatorUserId() {
		return creatorUserId;
	}

	public void setCreatorUserId(java.lang.Integer creatorUserId) {
		this.creatorUserId = creatorUserId;
	}

	public java.util.Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(java.util.Date createTime) {
		this.createTime = createTime;
	}

	@Override
	public String toString() {
		return "Buildingremindinfo [buildingRemindId=" + buildingRemindId + ", branchId=" + branchId + ", buildingId=" + buildingId
				+ ", content=" + content + ", creatorUserId=" + creatorUserId + ", createTime=" + createTime + "]";
	}

}
