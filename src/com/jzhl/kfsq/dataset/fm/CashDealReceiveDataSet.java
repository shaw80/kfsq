package com.jzhl.kfsq.dataset.fm;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * 取现交易详情从数据库中取值结果集
 * 
 * @author Shaw
 *
 */
public class CashDealReceiveDataSet {
	
	private String applicationId;// 申请编号
	
	private Timestamp applicationTime;// 申请时间
	
	private String cashMode;// 提现方式
	
	private BigDecimal price;// 提现金额
	
	private int status;// 提现状态

	public String getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(String applicationId) {
		this.applicationId = applicationId;
	}

	public Timestamp getApplicationTime() {
		return applicationTime;
	}

	public void setApplicationTime(Timestamp applicationTime) {
		this.applicationTime = applicationTime;
	}

	public String getCashMode() {
		return cashMode;
	}

	public void setCashMode(String cashMode) {
		this.cashMode = cashMode;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}
