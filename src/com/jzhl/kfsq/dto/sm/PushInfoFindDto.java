package com.jzhl.kfsq.dto.sm;

import com.jzhl.kfsq.common.base.PageListCondition;

/**
 * 
 * @author Shaw
 *
 */
public class PushInfoFindDto extends PageListCondition {

	private Integer memberId;// 会员编号

	public Integer getMemberId() {
		return memberId;
	}

	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}

	@Override
	public String toString() {
		return "PushInfoFindDto [memberId=" + memberId + "]";
	}

}
