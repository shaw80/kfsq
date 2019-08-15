package com.jzhl.kfsq.dataset.ba;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 维度结果集
 * 
 * @author Shaw
 *
 */
public class DimensionDataSet implements Serializable {

	private static final long serialVersionUID = -4409828347700254712L;// 序列化

	private Integer dimensionId;// 维度编号
	
	private BigDecimal beginValue;// 维度范围开始值

	private BigDecimal endValue;// 维度范围截止值

	private Integer weight;// 权重

	private Integer score;// 分数

	public Integer getDimensionId() {
		return dimensionId;
	}

	public void setDimensionId(Integer dimensionId) {
		this.dimensionId = dimensionId;
	}

	public BigDecimal getBeginValue() {
		return beginValue;
	}

	public void setBeginValue(BigDecimal beginValue) {
		this.beginValue = beginValue;
	}

	public BigDecimal getEndValue() {
		return endValue;
	}

	public void setEndValue(BigDecimal endValue) {
		this.endValue = endValue;
	}

	public Integer getWeight() {
		return weight;
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return "DimensionDataSet [dimensionId=" + dimensionId + ", beginValue="
				+ beginValue + ", endValue=" + endValue + ", weight=" + weight
				+ ", score=" + score + "]";
	}

}
