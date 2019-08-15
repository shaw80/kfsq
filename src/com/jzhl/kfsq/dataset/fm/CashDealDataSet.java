package com.jzhl.kfsq.dataset.fm;

import java.math.BigDecimal;

/**
 * 交易记录提现详情结果集
 * 
 * @author Shaw
 *
 */
public class CashDealDataSet {
	
	private String applicationId;// 申请编号
	
	private String serviceTime;// 申请时间
	
	private String type;// 提现方式
	
	private BigDecimal price;// 提现金额
	
	private String serviceStatus;// 提现状态

	public String getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(String applicationId) {
		this.applicationId = applicationId;
	}

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

	public String getServiceStatus() {
		return serviceStatus;
	}

	public void setServiceStatus(String serviceStatus) {
		this.serviceStatus = serviceStatus;
	}

}
