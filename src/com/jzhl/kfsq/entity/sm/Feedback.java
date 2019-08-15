package com.jzhl.kfsq.entity.sm;

import java.io.Serializable;

/**
 * 
 * SM_Feedback表
 * 
 * @author zhouzy
 *
 */
public class Feedback implements Serializable {
	private static final long serialVersionUID = 1L;
	private java.lang.Integer contentId; //
	private java.lang.String contentValue; // 内容
	private java.lang.Integer memberId; // 创建者：记录用户的创建人员的名称。
	private java.sql.Timestamp createTime; // 创建时间：记录用户的创建时间。
	private java.lang.String nickName; // 名称
	private java.lang.String phone; // 名称

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

	public java.lang.String getNickName() {
		return nickName;
	}

	public void setNickName(java.lang.String nickName) {
		this.nickName = nickName;
	}

	public java.lang.String getPhone() {
		return phone;
	}

	public void setPhone(java.lang.String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "Feedback [contentId=" + contentId + ", contentValue=" + contentValue + ", memberId=" + memberId + ", createTime="
				+ createTime + ", niceName=" + nickName + ", phone=" + phone + "]";
	}

}