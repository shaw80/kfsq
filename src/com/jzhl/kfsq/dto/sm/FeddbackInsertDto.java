package com.jzhl.kfsq.dto.sm;

import java.io.Serializable;

/**
 * 添加反馈dto
 * 
 * @author Shaw
 *
 */
public class FeddbackInsertDto implements Serializable {

	private static final long serialVersionUID = -4721196405248786720L;
	
	private java.lang.String contentValue; // 内容
	
	private java.lang.Integer memberId; // 创建者：记录用户的创建人员的名称。

	public java.lang.String getContentValue() {
		return contentValue;
	}

	public void setContentValue(java.lang.String contentValue) {
		this.contentValue = contentValue;
	}

	public java.lang.Integer getMemberId() {
		return memberId;
	}

	public void setMemberId(java.lang.Integer memberId) {
		this.memberId = memberId;
	}

	@Override
	public String toString() {
		return "FeddbackInsertDto [contentValue=" + contentValue
				+ ", memberId=" + memberId + "]";
	}

}
