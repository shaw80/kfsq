package com.jzhl.kfsq.dto.cm;

import java.io.Serializable;

/**
 * 
 * CM_CommentType表
 * 
 * @author zhouzy
 *
 */
public class CommentTypeDto implements Serializable {
	private static final long serialVersionUID = -3880135340330851736L;
	private java.lang.Integer commentTypeId; // 主键
	private java.lang.Integer commentId; // 评论ID
	private java.lang.Integer commentType; // 评论类型（1：户型，2：社区品质，3：交通，4：教育，5：周边设施）
	private java.lang.Integer creatorUserId; // 创建者编号
	private java.util.Date createTime; // 创建时间

	private java.lang.String commentTypeList; // 分类,'评论类型（1：户型，2：社区品质，3：交通，4：教育，5：周边设施）',用“，”分割

	public java.lang.Integer getCommentTypeId() {
		return commentTypeId;
	}

	public void setCommentTypeId(java.lang.Integer commentTypeId) {
		this.commentTypeId = commentTypeId;
	}

	public java.lang.Integer getCommentId() {
		return commentId;
	}

	public void setCommentId(java.lang.Integer commentId) {
		this.commentId = commentId;
	}

	public java.lang.Integer getCommentType() {
		return commentType;
	}

	public void setCommentType(java.lang.Integer commentType) {
		this.commentType = commentType;
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

	public java.lang.String getCommentTypeList() {
		return commentTypeList;
	}

	public void setCommentTypeList(java.lang.String commentTypeList) {
		this.commentTypeList = commentTypeList;
	}

}