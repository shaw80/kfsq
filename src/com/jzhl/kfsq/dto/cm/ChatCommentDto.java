package com.jzhl.kfsq.dto.cm;

import com.jzhl.kfsq.common.base.PageListCondition;

public class ChatCommentDto extends PageListCondition {
	private java.lang.Integer commentId;
	private java.lang.Integer parentCommentId;// 父ID
	private java.lang.Integer replyCommentId; // 回复的二级评论ID
	private java.lang.String content; // 评论内容
	private java.lang.Integer creatorUserId; // 创建者：记录用户的创建人员的名称

	private java.lang.Short isTop; // 0：不置顶，1：置顶
	private java.lang.String configValue; // 0：未审批，1：审批通过，2：审批不通过
	private java.lang.Integer updateUserId; // 更新人
	private java.lang.Integer isValid; // 0：无效，1：有效
	private java.lang.String keyword; // 关键字

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

	public java.lang.Integer getReplyCommentId() {
		return replyCommentId;
	}

	public void setReplyCommentId(java.lang.Integer replyCommentId) {
		this.replyCommentId = replyCommentId;
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

	public java.lang.Integer getUpdateUserId() {
		return updateUserId;
	}

	public void setUpdateUserId(java.lang.Integer updateUserId) {
		this.updateUserId = updateUserId;
	}

	public java.lang.Integer getIsValid() {
		return isValid;
	}

	public void setIsValid(java.lang.Integer isValid) {
		this.isValid = isValid;
	}

	public java.lang.String getKeyword() {
		return keyword;
	}

	public void setKeyword(java.lang.String keyword) {
		this.keyword = keyword;
	}

	@Override
	public String toString() {
		return "ChatCommentDto [commentId=" + commentId + ", parentCommentId=" + parentCommentId + ", replyCommentId=" + replyCommentId
				+ ", content=" + content + ", creatorUserId=" + creatorUserId + ", isTop=" + isTop + ", configValue=" + configValue
				+ ", updateUserId=" + updateUserId + ", isValid=" + isValid + ", keyword=" + keyword + "]";
	}

}
