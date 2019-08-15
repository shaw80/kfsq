package com.jzhl.kfsq.dto.pm;

import com.jzhl.kfsq.common.base.PageListCondition;

/**
 * 个人今日到访dto
 * @author Shaw
 *
 */
public class VisitTodayPersonDto extends PageListCondition {
	
	private Integer userId;// 用户编号

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "VisitTodayPersonDto [userId=" + userId + "]";
	}
	
}
