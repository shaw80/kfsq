package com.jzhl.kfsq.dto.fm;

import com.jzhl.kfsq.common.base.PageListCondition;

/**
 * 交易记录红包领取dto
 * 
 * @author Shaw
 *
 */
public class EnvelopeDealDto extends PageListCondition {

	private Integer memberId;// 会员编号

	public Integer getMemberId() {
		return memberId;
	}

	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}

}
