package com.jzhl.kfsq.dto.sm;

import java.io.Serializable;

import com.jzhl.kfsq.common.base.PageListCondition;

/**
 * 
 * SM_Feedback表
 * 
 * @author zhouzy
 *
 */
public class FeedbackDto extends PageListCondition implements Serializable {
	private static final long serialVersionUID = 1L;
	private java.lang.Integer contentId; //
	private java.lang.String contentValue; // 内容
	private java.lang.Integer memberId; // 创建者：记录用户的创建人员的名称。
	private java.sql.Timestamp createTime; // 创建时间：记录用户的创建时间。

	public java.lang.Integer getContentId() {
		return contentId;
	}

	public void setContentId(java.lang.Integer contentId) {
		this.contentId = contentId;
	}

	public java.lang.String getContentValue() {
		return contentValue;
	}

	public void setContentValue(java.lang.String contentValue) {
		this.contentValue = contentValue;
	}

	public java.lang.Integer getMemberId() {
		return memberId;
	}

	public void setMemberId(java.lang.Integer memberId) {
		this.memberId = memberId;
	}

	public java.sql.Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(java.sql.Timestamp createTime) {
		this.createTime = createTime;
	}

	@Override
	public String toString() {
		return "FeedbackDto [contentId=" + contentId + ", contentValue=" + contentValue + ", memberId=" + memberId + ", createTime="
				+ createTime + "]";
	}

}