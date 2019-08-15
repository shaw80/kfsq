package com.jzhl.kfsq.entity.sm;

import java.io.Serializable;

/**
 * 
 * SM_BuildingRemindInfo表
 * 
 * @author zhouzy
 *
 */
public class BuildingRemindInfo implements Serializable {

	private static final long serialVersionUID = -1182994430907333261L;
	private java.lang.Integer buildingRemindId; // 主键
	private java.lang.Integer branchId; // 分站编号
	private java.lang.Integer buildingId; // 分站编号
	private java.lang.String content; // 提醒内容
	private java.lang.Integer creatorUserId; // 创建人编号
	private java.util.Date createTime; // 创建时间
	private java.lang.String buildingName; // 楼盘名称
	private java.lang.String name; // 销售总监名称
	private java.lang.String mobilePhone; // 销售总监电话

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

	public java.lang.String getBuildingName() {
		return buildingName;
	}

	public void setBuildingName(java.lang.String buildingName) {
		this.buildingName = buildingName;
	}

	public java.lang.String getName() {
		return name;
	}

	public void setName(java.lang.String name) {
		this.name = name;
	}

	public java.lang.String getMobilePhone() {
		return mobilePhone;
	}

	public void setMobilePhone(java.lang.String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	@Override
	public String toString() {
		return "BuildingRemindInfo [buildingRemindId=" + buildingRemindId + ", branchId=" + branchId + ", buildingId=" + buildingId
				+ ", content=" + content + ", creatorUserId=" + creatorUserId + ", createTime=" + createTime + ", buildingName="
				+ buildingName + ", name=" + name + ", mobilePhone=" + mobilePhone + "]";
	}

}