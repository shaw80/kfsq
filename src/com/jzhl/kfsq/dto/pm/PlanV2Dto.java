package com.jzhl.kfsq.dto.pm;

import java.io.Serializable;

import com.jzhl.kfsq.common.base.PageListCondition;

/**
 * 查询想看和已看列表参数DTO
 * 
 * @author Shaw
 *
 */
public class PlanV2Dto extends PageListCondition implements Serializable {

	private static final long serialVersionUID = -8166056270041058403L;

	private Integer memberId;// 会员编号

	public Integer getMemberId() {
		return memberId;
	}

	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}

}
