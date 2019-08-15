package com.jzhl.kfsq.dataset.fm;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * 交易记录红包领取结果集
 * 
 * @author Shaw
 *
 */
public class EnvelopeDealReceiveDataSet {
	
	private Timestamp receiveTime;// 领取时间
	
	private Integer envelopeType;// 红包类型
	
	private BigDecimal price;// 领取金额

	public Timestamp getReceiveTime() {
		return receiveTime;
	}

	public void setReceiveTime(Timestamp receiveTime) {
		this.receiveTime = receiveTime;
	}

	public Integer getEnvelopeType() {
		return envelopeType;
	}

	public void setEnvelopeType(Integer envelopeType) {
		this.envelopeType = envelopeType;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

}
