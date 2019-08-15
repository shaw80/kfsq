package com.jzhl.kfsq.dataset.fm;

import java.math.BigDecimal;

/**
 * 交易记录红包领取结果集
 * 
 * @author Shaw
 *
 */
public class EnvelopeDealDataSet {
	
	private String serviceTime;// 领取时间
	
	private String type;// 红包类型
	
	private BigDecimal price;// 领取金额

	public String getServiceTime() {
		return serviceTime;
	}

	public void setServiceTime(String serviceTime) {
		this.serviceTime = serviceTime;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

}
