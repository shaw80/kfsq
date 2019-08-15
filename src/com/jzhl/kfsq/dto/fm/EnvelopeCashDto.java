package com.jzhl.kfsq.dto.fm;

import java.io.Serializable;

/**
 * 红包、提现中间表DTO
 * 
 * @author Shaw
 *
 */
public class EnvelopeCashDto implements Serializable {

	private static final long serialVersionUID = 2146798977056042207L;// 序列化
	
	private int envelopeCashId;// 中间表主键
	
	private String applicationId;// 申请编号

	public int getEnvelopeCashId() {
		return envelopeCashId;
	}

	public void setEnvelopeCashId(int envelopeCashId) {
		this.envelopeCashId = envelopeCashId;
	}

	public String getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(String applicationId) {
		this.applicationId = applicationId;
	}

	@Override
	public String toString() {
		return "EnvelopeCashDto [envelopeCashId=" + envelopeCashId
				+ ", applicationId=" + applicationId + "]";
	}

}
