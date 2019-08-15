package com.jzhl.kfsq.dataset.cm;

import java.io.Serializable;

public class CommentReplyDataSet implements Serializable{
	private static final long serialVersionUID = -7084623317124477934L;
	private java.lang.String replycommentId;
	private java.lang.String replyContent;
	private java.lang.String replyMemberName;
	private java.lang.String replyMemberHeadPortrait;
	private java.lang.String replyParentMemberName;
	public java.lang.String getReplycommentId() {
		return replycommentId;
	}
	public void setReplycommentId(java.lang.String replycommentId) {
		this.replycommentId = replycommentId;
	}
	public java.lang.String getReplyContent() {
		return replyContent;
	}
	public void setReplyContent(java.lang.String replyContent) {
		this.replyContent = replyContent;
	}
	public java.lang.String getReplyMemberName() {
		return replyMemberName;
	}
	public void setReplyMemberName(java.lang.String replyMemberName) {
		this.replyMemberName = replyMemberName;
	}
	public java.lang.String getReplyMemberHeadPortrait() {
		return replyMemberHeadPortrait;
	}
	public void setReplyMemberHeadPortrait(java.lang.String replyMemberHeadPortrait) {
		this.replyMemberHeadPortrait = replyMemberHeadPortrait;
	}
	public java.lang.String getReplyParentMemberName() {
		return replyParentMemberName;
	}
	public void setReplyParentMemberName(java.lang.String replyParentMemberName) {
		this.replyParentMemberName = replyParentMemberName;
	}
	
}
