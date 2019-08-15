package com.jzhl.kfsq.dto.fm;

import com.jzhl.kfsq.common.base.PageListCondition;

public class CashAppliQueryDto extends PageListCondition {
	
	private Integer memberId;// 会员编号

	public Integer getMemberId() {
		return memberId;
	}

	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}

}
