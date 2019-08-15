package com.jzhl.kfsq.dto.cm;

import com.jzhl.kfsq.common.base.PageListCondition;

/**
 * 发表有礼看房圈评论dto
 * 
 * @author Shaw
 *
 */
public class GiftBuildingCommentDto extends PageListCondition {
	
	private String memberId;// 会员编号

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

}
