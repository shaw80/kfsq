package com.jzhl.kfsq.dto.cm;

import com.jzhl.kfsq.common.base.PageListCondition;

public class AppRemindPageDto extends PageListCondition  {
	private java.lang.Integer replyParentUserId;
	private java.lang.Long lastTime;
	public java.lang.Integer getReplyParentUserId() {
		return replyParentUserId;
	}
	public void setReplyParentUserId(java.lang.Integer replyParentUserId) {
		this.replyParentUserId = replyParentUserId;
	}
	public java.sql.Timestamp getLastTime() {
		if(lastTime == null) {
			return null;
		}
		return new java.sql.Timestamp(lastTime);
	}
	public void setLastTime(java.lang.Long lastTime) {
		this.lastTime = lastTime;
	}
}
