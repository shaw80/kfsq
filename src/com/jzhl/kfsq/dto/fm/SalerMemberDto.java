package com.jzhl.kfsq.dto.fm;

import java.io.Serializable;

/**
 * 查询置业顾问的客户红包
 * @author Shaw
 *
 */
public class SalerMemberDto implements Serializable {

	private static final long serialVersionUID = 1032712475784958519L;// 序列化
	
	private Integer userId;// 置业顾问编号
	
	private Integer memberId;// 会员编号

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getMemberId() {
		return memberId;
	}

	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}

	@Override
	public String toString() {
		return "SalerMemberDto [userId=" + userId + ", memberId=" + memberId
				+ "]";
	}

}
