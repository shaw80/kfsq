package com.jzhl.kfsq.dto.fm;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 红包领取统计DTO
 * 
 * @author Shaw
 *
 */
public class EnvelopeReceiveCountDto implements Serializable {

	private static final long serialVersionUID = -3894954542534491239L;// 序列化
	
	private BigDecimal cashAmount;// 可提金额
	
	private BigDecimal notActivation;// 待激活
	
	private BigDecimal gain;// 累计收益

	public BigDecimal getCashAmount() {
		return cashAmount;
	}

	public void setCashAmount(BigDecimal cashAmount) {
		this.cashAmount = cashAmount;
	}

	public BigDecimal getNotActivation() {
		return notActivation;
	}

	public void setNotActivation(BigDecimal notActivation) {
		this.notActivation = notActivation;
	}

	public BigDecimal getGain() {
		return gain;
	}

	public void setGain(BigDecimal gain) {
		this.gain = gain;
	}

	@Override
	public String toString() {
		return "EnvelopeReceiveCountDto [cashAmount=" + cashAmount
				+ ", notActivation=" + notActivation + ", gain=" + gain + "]";
	}

}
