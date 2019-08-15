package com.jzhl.kfsq.dataset.fm;

import java.io.Serializable;

/**
 * 
 * 
 * @author zhouzy
 *
 */
public class EnvelopeStatisticalDatoSet implements Serializable {

	private static final long serialVersionUID = 1L;

	private java.lang.String areaName; // 城市名称
	private java.lang.Integer planNum; // 加入计划数量
	private java.lang.Integer visitNum; // 到访数量
	private java.math.BigDecimal sumPriceNum; // 红包消耗数量
	private java.lang.String month; // 月份

	public java.lang.String getAreaName() {
		return areaName;
	}

	public void setAreaName(java.lang.String areaName) {
		this.areaName = areaName;
	}

	public java.lang.Integer getPlanNum() {
		return planNum;
	}

	public void setPlanNum(java.lang.Integer planNum) {
		this.planNum = planNum;
	}

	public java.lang.Integer getVisitNum() {
		return visitNum;
	}

	public void setVisitNum(java.lang.Integer visitNum) {
		this.visitNum = visitNum;
	}

	public java.math.BigDecimal getSumPriceNum() {
		return sumPriceNum;
	}

	public void setSumPriceNum(java.math.BigDecimal sumPriceNum) {
		this.sumPriceNum = sumPriceNum;
	}

	public java.lang.String getMonth() {
		return month;
	}

	public void setMonth(java.lang.String month) {
		this.month = month;
	}

	@Override
	public String toString() {
		return "EnvelopeStatisticalDatoSet [areaName=" + areaName + ", planNum=" + planNum + ", visitNum=" + visitNum + ", sumPriceNum="
				+ sumPriceNum + ", month=" + month + "]";
	}

}