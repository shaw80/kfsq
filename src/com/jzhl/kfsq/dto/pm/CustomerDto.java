package com.jzhl.kfsq.dto.pm;

import java.io.Serializable;

import com.jzhl.kfsq.common.base.PageListCondition;

/**
 * 客户查询dto
 * @author Shaw
 *
 */
public class CustomerDto extends PageListCondition implements Serializable {

	private static final long serialVersionUID = 321234019646131328L;// 序列化
	
	private Integer userId;// 用户编号
	
	private String memberName;// 客户名称
	
	private Integer leaderId;// 领导编号

	public Integer getLeaderId() {
		return leaderId;
	}

	public void setLeaderId(Integer leaderId) {
		this.leaderId = leaderId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	@Override
	public String toString() {
		return "CustomerDto [userId=" + userId + ", memberName=" + memberName
				+ ", leaderId=" + leaderId + "]";
	}

}
