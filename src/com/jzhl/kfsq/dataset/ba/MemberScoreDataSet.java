package com.jzhl.kfsq.dataset.ba;

import java.io.Serializable;

/**
 * 用户评分
 * 
 * @author zhouzy
 *
 */
public class MemberScoreDataSet implements Serializable {

	private static final long serialVersionUID = -802443743985933132L;

	private java.lang.String dimensionCode; // 维度
	private double weightSumValue; // 用户评分*维度后的实际评分

	public java.lang.String getDimensionCode() {
		return dimensionCode;
	}

	public void setDimensionCode(java.lang.String dimensionCode) {
		this.dimensionCode = dimensionCode;
	}

	public double getWeightSumValue() {
		return weightSumValue;
	}

	public void setWeightSumValue(double weightSumValue) {
		this.weightSumValue = weightSumValue;
	}

}
