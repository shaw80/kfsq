package com.jzhl.kfsq.dataset.fm;

import java.io.Serializable;
import java.math.BigDecimal;

import com.jzhl.kfsq.common.base.ListResult;

/**
 * 红包领取统计结果集
 * 
 * @author Shaw
 *
 */
public class EnvelopeReceiveCountDataSet implements Serializable {

	private static final long serialVersionUID = -3894954542534491239L;// 序列化

	private BigDecimal cashAmount;// 可提金额

	private BigDecimal notActivation;// 待激活

	private BigDecimal gain;// 累计收益

	private ListResult incomeList;// 收入结果集

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

	public ListResult getIncomeList() {
		return incomeList;
	}

	public void setIncomeList(ListResult incomeList) {
		this.incomeList = incomeList;
	}

}
