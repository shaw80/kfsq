package com.jzhl.kfsq.entity.cm;

import java.io.Serializable;

public class ChatComment implements Serializable {
	private static final long serialVersionUID = -8288455360563153802L;
	private java.lang.Integer commentId;
	private java.lang.String commentTitle;
	private java.lang.Integer parentCommentId;
	private java.lang.String content;
	private java.lang.String configValue;
	private java.lang.Short isTop; // '0：不置顶，1：置顶'
	private java.lang.Short readStatus; // '阅读状态（0：未读，1：已读）'
	private java.lang.Short isValid;
	private java.lang.Integer creatorUserId;
	private java.lang.Integer replyParentUserId;
	private java.sql.Timestamp createTime;
	private java.lang.Integer updateUserId;
	private java.sql.Timestamp updateTime;

	public java.lang.Integer getCommentId() {
		return commentId;
	}

	public void setCommentId(java.lang.Integer commentId) {
		this.commentId = commentId;
	}

	public java.lang.String getCommentTitle() {
		return commentTitle;
	}

	public void setCommentTitle(java.lang.String commentTitle) {
		this.commentTitle = commentTitle;
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

	public java.lang.String getConfigValue() {
		return configValue;
	}

	public void setConfigValue(java.lang.String configValue) {
		this.configValue = configValue;
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

	public java.lang.Integer getReplyParentUserId() {
		return replyParentUserId;
	}

	public void setReplyParentUserId(java.lang.Integer replyParentUserId) {
		this.replyParentUserId = replyParentUserId;
	}

	public java.lang.Short getIsTop() {
		return isTop;
	}

	public void setIsTop(java.lang.Short isTop) {
		this.isTop = isTop;
	}

	public java.lang.Short getReadStatus() {
		return readStatus;
	}

	public void setReadStatus(java.lang.Short readStatus) {
		this.readStatus = readStatus;
	}

}
