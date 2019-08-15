package com.jzhl.kfsq.dataset.bm;

import java.io.Serializable;

/**
 * 周边结果集
 * 
 * @author Shaw
 *
 */
public class AroundV2DataSet implements Serializable {

	private static final long serialVersionUID = 3470409836831575654L;// 序列化
	
	private String dimensionName;// 维度名称
	
	private String score;// 分数
	
	private String around;// 周边结果集

	public String getDimensionName() {
		return dimensionName;
	}

	public void setDimensionName(String dimensionName) {
		this.dimensionName = dimensionName;
	}

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}

	public String getAround() {
		return around;
	}

	public void setAround(String around) {
		this.around = around;
	}

	@Override
	public String toString() {
		return "AroundV2DataSet [dimensionName=" + dimensionName + ", score="
				+ score + ", around=" + around + "]";
	}

}
