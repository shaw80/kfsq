package com.jzhl.kfsq.dataset.cm;

import java.io.Serializable;

public class ChatCommentDataSet implements Serializable {
	private static final long serialVersionUID = 8237019081845643872L;
	private java.lang.Integer commentId;
	private java.lang.Integer parentCommentId;
	private java.lang.String content;
	private java.sql.Timestamp createTime;
	private java.lang.String headPortrait; // 头像
	private java.lang.String nickName; // 昵称
	private java.lang.Integer commentCount;
	private java.lang.Integer creatorUserId;

	private java.lang.String account; // 用户账号
	private java.lang.Integer imgNum; // 关联照片数量
	private java.lang.Short isTop; // 0：不置顶，1：置顶
	private java.lang.String configValue; // 0：未审批，1：审批通过，2：审批不通过

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

	public java.lang.String getContent() {
		return content;
	}

	public void setContent(java.lang.String content) {
		this.content = content;
	}

	public java.sql.Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(java.sql.Timestamp createTime) {
		this.createTime = createTime;
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

	public java.lang.Integer getCommentCount() {
		return commentCount;
	}

	public void setCommentCount(java.lang.Integer commentCount) {
		this.commentCount = commentCount;
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

	public java.lang.Short getIsTop() {
		return isTop;
	}

	public void setIsTop(java.lang.Short isTop) {
		this.isTop = isTop;
	}

	public java.lang.String getConfigValue() {
		return configValue;
	}

	public void setConfigValue(java.lang.String configValue) {
		this.configValue = configValue;
	}

	public java.lang.Integer getCreatorUserId() {
		return creatorUserId;
	}

	public void setCreatorUserId(java.lang.Integer creatorUserId) {
		this.creatorUserId = creatorUserId;
	}
	
	

}
