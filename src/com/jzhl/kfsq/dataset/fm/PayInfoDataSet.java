package com.jzhl.kfsq.dataset.fm;

import java.io.Serializable;
import java.math.BigDecimal;

public class PayInfoDataSet implements Serializable {
	
	private static final long serialVersionUID = -7959706846510799675L;// 序列化

	private int payInfoId;// 支付编号
	
	private String serialNum;// 交易流水号
	
	private int countPerson;// 打款人数
	
	private BigDecimal payPrice;// 支付金额
	
	private BigDecimal managePrice;// 管理费用（批量支付的费用）
	
	private String createTime;// 创建时间

	public int getPayInfoId() {
		return payInfoId;
	}

	public void setPayInfoId(int payInfoId) {
		this.payInfoId = payInfoId;
	}

	public String getSerialNum() {
		return serialNum;
	}

	public void setSerialNum(String serialNum) {
		this.serialNum = serialNum;
	}

	public int getCountPerson() {
		return countPerson;
	}

	public void setCountPerson(int countPerson) {
		this.countPerson = countPerson;
	}

	public BigDecimal getPayPrice() {
		return payPrice;
	}

	public void setPayPrice(BigDecimal payPrice) {
		this.payPrice = payPrice;
	}

	public BigDecimal getManagePrice() {
		return managePrice;
	}

	public void setManagePrice(BigDecimal managePrice) {
		this.managePrice = managePrice;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	@Override
	public String toString() {
		return "PayInfoDataSet [payInfoId=" + payInfoId + ", serialNum="
				+ serialNum + ", countPerson=" + countPerson + ", payPrice="
				+ payPrice + ", managePrice=" + managePrice + ", createTime="
				+ createTime + "]";
	}

}
