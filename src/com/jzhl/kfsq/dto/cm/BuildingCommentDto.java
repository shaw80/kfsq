package com.jzhl.kfsq.dto.cm;

import com.jzhl.kfsq.common.base.PageListCondition;

public class BuildingCommentDto extends PageListCondition {
	private java.lang.Integer commentId; // 论评编号
	private java.lang.Integer parentCommentId; // 父ID
	private java.lang.Integer buildingId; // 楼盘编号
	private java.lang.Short isTop; // 0：不置顶，1：置顶
	private java.lang.Short auditStatus; // 0：未审批，1：审批通过，2：审批不通过
	private java.lang.Short isValid; // 0：无效，1：有效
	private java.lang.Integer creatorUserId; // 创建者：记录用户的创建人员的名称
	private java.lang.Integer replyParentUserId; // 回复的父级发布人编号
	private java.lang.Integer updateUserId; // 更新人
	private java.util.Date lastTime; // 用于查询该时间之后的数据
	private java.lang.String buildingName; // 楼盘名称
	private java.lang.Integer agentId; // 代理商ID

	private java.lang.String isCommentType; // 是否分类
	private java.lang.String unApprovedReplyNum; // 未审核回复数0,0条未审核；1：大于等于1条未审核

	public java.lang.Integer getCommentId() {
		return commentId;
	}

	public void setCommentId(java.lang.Integer commentId) {
		this.commentId = commentId;
	}

	public java.lang.Integer getParentCommentId() {
		return parentCommentId;
	}

	public void setParentCommentId(java.lang.Integer parentCommentId) {
		this.parentCommentId = parentCommentId;
	}

	public java.lang.Integer getBuildingId() {
		return buildingId;
	}

	public void setBuildingId(java.lang.Integer buildingId) {
		this.buildingId = buildingId;
	}

	public java.lang.Short getIsTop() {
		return isTop;
	}

	public void setIsTop(java.lang.Short isTop) {
		this.isTop = isTop;
	}

	public java.lang.Short getAuditStatus() {
		return auditStatus;
	}

	public void setAuditStatus(java.lang.Short auditStatus) {
		this.auditStatus = auditStatus;
	}

	public java.lang.Short getIsValid() {
		return isValid;
	}

	public void setIsValid(java.lang.Short isValid) {
		this.isValid = isValid;
	}

	public java.lang.Integer getCreatorUserId() {
		return creatorUserId;
	}

	public void setCreatorUserId(java.lang.Integer creatorUserId) {
		this.creatorUserId = creatorUserId;
	}

	public java.lang.Integer getReplyParentUserId() {
		return replyParentUserId;
	}

	public void setReplyParentUserId(java.lang.Integer replyParentUserId) {
		this.replyParentUserId = replyParentUserId;
	}

	public java.lang.Integer getUpdateUserId() {
		return updateUserId;
	}

	public void setUpdateUserId(java.lang.Integer updateUserId) {
		this.updateUserId = updateUserId;
	}

	public java.util.Date getLastTime() {
		return lastTime;
	}

	public void setLastTime(java.util.Date lastTime) {
		this.lastTime = lastTime;
	}

	public java.lang.String getBuildingName() {
		return buildingName;
	}

	public void setBuildingName(java.lang.String buildingName) {
		this.buildingName = buildingName;
	}

	public java.lang.Integer getAgentId() {
		return agentId;
	}

	public void setAgentId(java.lang.Integer agentId) {
		this.agentId = agentId;
	}

	public java.lang.String getIsCommentType() {
		return isCommentType;
	}

	public void setIsCommentType(java.lang.String isCommentType) {
		this.isCommentType = isCommentType;
	}

	public java.lang.String getUnApprovedReplyNum() {
		return unApprovedReplyNum;
	}

	public void setUnApprovedReplyNum(java.lang.String unApprovedReplyNum) {
		this.unApprovedReplyNum = unApprovedReplyNum;
	}

}
