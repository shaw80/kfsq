package com.jzhl.kfsq.dto.fm;

import java.io.Serializable;

import com.jzhl.kfsq.common.base.PageListCondition;

/**
 * 红包领取实体类
 * 
 * @author zhouzy
 *
 */
public class EnvelopeReceiveDto extends PageListCondition implements Serializable {

	private static final long serialVersionUID = 1274006094189342252L;// 序列化

	private java.lang.Integer receiveId;// 领取编号，主键
	private java.lang.Integer userId; // 登录ID
	private java.lang.String keyword; // 检索关键字
	private java.lang.String dateStart; // 检索开始日期
	private java.lang.String dateEnd; // 检索结束日期

	public java.lang.Integer getReceiveId() {
		return receiveId;
	}

	public void setReceiveId(java.lang.Integer receiveId) {
		this.receiveId = receiveId;
	}

	public java.lang.Integer getUserId() {
		return userId;
	}

	public java.lang.String getKeyword() {
		return keyword;
	}

	public void setKeyword(java.lang.String keyword) {
		this.keyword = keyword;
	}

	public void setUserId(java.lang.Integer userId) {
		this.userId = userId;
	}

	public java.lang.String getDateStart() {
		return dateStart;
	}

	public void setDateStart(java.lang.String dateStart) {
		this.dateStart = dateStart;
	}

	public java.lang.String getDateEnd() {
		return dateEnd;
	}

	public void setDateEnd(java.lang.String dateEnd) {
		this.dateEnd = dateEnd;
	}

	@Override
	public String toString() {
		return "EnvelopeReceiveDto [receiveId=" + receiveId + ", userId=" + userId + ", keyword=" + keyword + ", dateStart=" + dateStart
				+ ", dateEnd=" + dateEnd + "]";
	}

}
