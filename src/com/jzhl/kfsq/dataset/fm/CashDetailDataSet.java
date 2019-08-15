package com.jzhl.kfsq.dataset.fm;

/**
 * 提现详情结果集
 * 
 * @author Shaw
 *
 */
public class CashDetailDataSet {
	
	private String applicationId;// 申请编号
	
	private String price;// 提现金额
	
	private String applicationTime;// 申请时间
	
	private String cashStatus;// 申请状态
	
	private String DBStatus;// 申请状态（数据库原值）
	
	private String cashType;// 提现类型

	public String getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(String applicationId) {
		this.applicationId = applicationId;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getApplicationTime() {
		return applicationTime;
	}

	public void setApplicationTime(String applicationTime) {
		this.applicationTime = applicationTime;
	}

	public String getCashStatus() {
		return cashStatus;
	}

	public void setCashStatus(String cashStatus) {
		this.cashStatus = cashStatus;
	}

	public String getCashType() {
		return cashType;
	}

	public void setCashType(String cashType) {
		this.cashType = cashType;
	}

	public String getDBStatus() {
		return DBStatus;
	}

	public void setDBStatus(String dBStatus) {
		DBStatus = dBStatus;
	}

	@Override
	public String toString() {
		return "CashDetailDataSet [applicationId=" + applicationId + ", price="
				+ price + ", applicationTime=" + applicationTime
				+ ", cashStatus=" + cashStatus + ", DBStatus=" + DBStatus
				+ ", cashType=" + cashType + "]";
	}

}
