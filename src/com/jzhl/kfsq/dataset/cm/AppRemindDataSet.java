package com.jzhl.kfsq.dataset.cm;

public class AppRemindDataSet{
	private java.lang.Integer commentId;
	private java.lang.String content;
	private java.sql.Timestamp createTime;
	private java.lang.Integer creatorUserId;
	private java.lang.String nickName;
	private java.lang.String headPortrait;
	private java.lang.String type; //楼盘评论提醒：building,杂谈评论提醒：chat

	public java.lang.Integer getCommentId() {
		return commentId;
	}
	public void setCommentId(java.lang.Integer commentId) {
		this.commentId = commentId;
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
	public java.lang.Integer getCreatorUserId() {
		return creatorUserId;
	}
	public void setCreatorUserId(java.lang.Integer creatorUserId) {
		this.creatorUserId = creatorUserId;
	}
	public java.lang.String getNickName() {
		return nickName;
	}
	public void setNickName(java.lang.String nickName) {
		this.nickName = nickName;
	}
	public java.lang.String getHeadPortrait() {
		return headPortrait;
	}
	public void setHeadPortrait(java.lang.String headPortrait) {
		this.headPortrait = headPortrait;
	}
	public java.lang.String getType() {
		return type;
	}
	public void setType(java.lang.String type) {
		this.type = type;
	}
	
}
