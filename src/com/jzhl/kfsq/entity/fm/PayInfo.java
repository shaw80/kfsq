package com.jzhl.kfsq.entity.fm;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * 支付信息实体类
 * 
 * @author Shaw
 *
 */
public class PayInfo implements Serializable {
	
	private static final long serialVersionUID = 7278547049080896695L;

	private int payInfoId;// 支付编号
	
	private String serialNum;// 交易流水号
	
	private int countPerson;// 打款人数
	
	private String payStatus;// 支付状态
	
	private String failReason;// 失败原因
	
	private BigDecimal payPrice;// 支付金额
	
	private BigDecimal managePrice;// 管理费用（批量支付的费用）
	
	private int createUserId;// 创建人编号
	
	private Timestamp createTime;// 创建时间
	
	private int updateUserId;// 更新人编号
	
	private Timestamp updateTime;// 更新时间

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

	public String getPayStatus() {
		return payStatus;
	}

	public void setPayStatus(String payStatus) {
		this.payStatus = payStatus;
	}

	public String getFailReason() {
		return failReason;
	}

	public void setFailReason(String failReason) {
		this.failReason = failReason;
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

	public int getCreateUserId() {
		return createUserId;
	}

	public void setCreateUserId(int createUserId) {
		this.createUserId = createUserId;
	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public int getUpdateUserId() {
		return updateUserId;
	}

	public void setUpdateUserId(int updateUserId) {
		this.updateUserId = updateUserId;
	}

	public Timestamp getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}

	@Override
	public String toString() {
		return "PayInfo [payInfoId=" + payInfoId + ", serialNum=" + serialNum
				+ ", countPerson=" + countPerson + ", payStatus=" + payStatus
				+ ", failReason=" + failReason + ", payPrice=" + payPrice
				+ ", managePrice=" + managePrice + ", createUserId="
				+ createUserId + ", createTime=" + createTime
				+ ", updateUserId=" + updateUserId + ", updateTime="
				+ updateTime + "]";
	}

}
