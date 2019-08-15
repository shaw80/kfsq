package com.jzhl.kfsq.dataset.bm;

import java.io.Serializable;

/**
 * 教育结果集
 * 
 * @author Shaw
 *
 */
public class EducationDataSet implements Serializable {

	private static final long serialVersionUID = -5676896781853146384L;// 序列化
	
	private String dimensionName;// 维度名称
	
	private String score;// 分数
	
	private String education;// 教育结果集

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
	
	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	@Override
	public String toString() {
		return "EducationDataSet [dimensionName=" + dimensionName + ", score="
				+ score + ", education=" + education + "]";
	}

}
