package com.jzhl.kfsq.dataset.fm;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * 提现详情查询结果集
 * 
 * @author Shaw
 *
 */
public class CashDetailReceiveDataSet {
	
	private String applicationId;// 申请编号
	
	private BigDecimal price;// 提现金额
	
	private Timestamp applicationTime;// 申请时间
	
	private int status;// 申请状态
	
	private String cashType;// 提现类型

	public String getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(String applicationId) {
		this.applicationId = applicationId;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Timestamp getApplicationTime() {
		return applicationTime;
	}

	public void setApplicationTime(Timestamp applicationTime) {
		this.applicationTime = applicationTime;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getCashType() {
		return cashType;
	}

	public void setCashType(String cashType) {
		this.cashType = cashType;
	}

	@Override
	public String toString() {
		return "CashDetailReceiveDataSet [applicationId=" + applicationId
				+ ", price=" + price + ", applicationTime=" + applicationTime
				+ ", status=" + status + ", cashType=" + cashType + "]";
	}

}
