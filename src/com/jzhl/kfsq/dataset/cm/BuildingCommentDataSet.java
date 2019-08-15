package com.jzhl.kfsq.dataset.cm;

import java.io.Serializable;

public class BuildingCommentDataSet implements Serializable {
	private static final long serialVersionUID = 6249199124220970442L;
	private java.lang.Integer commentId;
	private java.lang.Integer parentCommentId; // 父ID
	private java.lang.Integer buildingId; // 楼盘编号
	private java.lang.String content; // 评论内容
	private java.lang.String headPortrait; // 头像
	private java.lang.String nickName; // 昵称
	private java.lang.String dimenWeightSumValue; // 维度权重总值
	private java.lang.Integer isTop; // 0：不置顶，1：置顶
	private java.lang.Integer auditStatus; // 0：未审批，1：审批通过，2：审批不通过
	private java.lang.Integer isValid; // 0：无效，1：有效
	private java.lang.Integer creatorUserId; // 创建者：记录用户的创建人员的名称
	private java.lang.Integer replyParentUserId; // 回复的父级发布人编号
	private java.sql.Timestamp createTime;
	private java.lang.Integer updateUserId; // 更新人
	private java.sql.Timestamp updateTime;
	private java.lang.Integer commentCount;
	private java.sql.Timestamp planTime;

	private java.lang.String buildingName; // 楼盘名称
	private java.lang.String account; // 用户账号
	private java.lang.Integer imgNum; // 关联照片数量
	private java.lang.Integer replyCommentNum; // 回复数
	private java.lang.Integer unapprovedReplyCommentNum; // 未审批回复数
	private java.lang.String commentTypeList; // 类别 '评论类型（1：户型，2：社区品质，3：交通，4：教育，5：周边设施）'

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

	public java.lang.String getContent() {
		return content;
	}

	public void setContent(java.lang.String content) {
		this.content = content;
	}

	public java.lang.String getHeadPortrait() {
		return headPortrait;
	}

	public void setHeadPortrait(java.lang.String headPortrait) {
		this.headPortrait = headPortrait;
	}

	public java.lang.String getNickName() {
		return nickName;
	}

	public void setNickName(java.lang.String nickName) {
		this.nickName = nickName;
	}

	public java.lang.String getDimenWeightSumValue() {
		return dimenWeightSumValue;
	}

	public void setDimenWeightSumValue(java.lang.String dimenWeightSumValue) {
		this.dimenWeightSumValue = dimenWeightSumValue;
	}

	public java.lang.Integer getIsTop() {
		return isTop;
	}

	public void setIsTop(java.lang.Integer isTop) {
		this.isTop = isTop;
	}

	public java.lang.Integer getAuditStatus() {
		return auditStatus;
	}

	public void setAuditStatus(java.lang.Integer auditStatus) {
		this.auditStatus = auditStatus;
	}

	public java.lang.Integer getIsValid() {
		return isValid;
	}

	public void setIsValid(java.lang.Integer isValid) {
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

	public java.sql.Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(java.sql.Timestamp createTime) {
		this.createTime = createTime;
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

	public java.lang.String getBuildingName() {
		return buildingName;
	}

	public void setBuildingName(java.lang.String buildingName) {
		this.buildingName = buildingName;
	}

	public java.lang.String getAccount() {
		return account;
	}

	public void setAccount(java.lang.String account) {
		this.account = account;
	}

	public java.lang.Integer getImgNum() {
		return imgNum;
	}

	public void setImgNum(java.lang.Integer imgNum) {
		this.imgNum = imgNum;
	}

	public java.lang.Integer getCommentCount() {
		return commentCount;
	}

	public void setCommentCount(java.lang.Integer commentCount) {
		this.commentCount = commentCount;
	}

	public java.sql.Timestamp getPlanTime() {
		return planTime;
	}

	public void setPlanTime(java.sql.Timestamp planTime) {
		this.planTime = planTime;
	}

	public java.lang.String getCommentTypeList() {
		return commentTypeList;
	}

	public void setCommentTypeList(java.lang.String commentTypeList) {
		this.commentTypeList = commentTypeList;
	}

	public java.lang.Integer getReplyCommentNum() {
		return replyCommentNum;
	}

	public void setReplyCommentNum(java.lang.Integer replyCommentNum) {
		this.replyCommentNum = replyCommentNum;
	}

	public java.lang.Integer getUnapprovedReplyCommentNum() {
		return unapprovedReplyCommentNum;
	}

	public void setUnapprovedReplyCommentNum(java.lang.Integer unapprovedReplyCommentNum) {
		this.unapprovedReplyCommentNum = unapprovedReplyCommentNum;
	}

}
