package com.jzhl.kfsq.dataset.bm;

import java.io.Serializable;

/**
 * 星图评分结果集
 * 
 * @author Shaw
 *
 */
public class StarMapScoreDataSet implements Serializable {

	private static final long serialVersionUID = 476429611193853705L;// 序列化
	
	private String dimensionName;// 维度名称
	
	private String Score;// 维度评分

	public String getDimensionName() {
		return dimensionName;
	}

	public void setDimensionName(String dimensionName) {
		this.dimensionName = dimensionName;
	}

	public String getScore() {
		return Score;
	}

	public void setScore(String score) {
		Score = score;
	}

	@Override
	public String toString() {
		return "StarMapScoreDataSet [dimensionName=" + dimensionName
				+ ", Score=" + Score + "]";
	}

}
