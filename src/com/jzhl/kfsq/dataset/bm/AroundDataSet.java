package com.jzhl.kfsq.dataset.bm;

import java.io.Serializable;

/**
 * 楼盘详情周边结果集
 * 
 * @author Shaw
 *
 */
public class AroundDataSet implements Serializable {

	private static final long serialVersionUID = 306082149817985386L;// 序列化
	
	private String dimensionName;// 维度名称
	
	private String score;// 分数
	
	private String countHealthCare;// 医疗设施数量
	
	private String countBank;// 银行数量
	
	private String countEntertainment;// 娱乐设施数量
	
	private String countBusiness;// 商业设施数量
	
	private String countSurroundingEnvironment;// 周边环境设施数量
	
	private String countUnfavorableFactors;// 不利因素数量

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

	public String getCountHealthCare() {
		return countHealthCare;
	}

	public void setCountHealthCare(String countHealthCare) {
		this.countHealthCare = countHealthCare;
	}

	public String getCountBank() {
		return countBank;
	}

	public void setCountBank(String countBank) {
		this.countBank = countBank;
	}

	public String getCountEntertainment() {
		return countEntertainment;
	}

	public void setCountEntertainment(String countEntertainment) {
		this.countEntertainment = countEntertainment;
	}

	public String getCountBusiness() {
		return countBusiness;
	}

	public void setCountBusiness(String countBusiness) {
		this.countBusiness = countBusiness;
	}

	public String getCountSurroundingEnvironment() {
		return countSurroundingEnvironment;
	}

	public void setCountSurroundingEnvironment(String countSurroundingEnvironment) {
		this.countSurroundingEnvironment = countSurroundingEnvironment;
	}

	public String getCountUnfavorableFactors() {
		return countUnfavorableFactors;
	}

	public void setCountUnfavorableFactors(String countUnfavorableFactors) {
		this.countUnfavorableFactors = countUnfavorableFactors;
	}

	@Override
	public String toString() {
		return "AroundDataSet [dimensionName=" + dimensionName + ", score="
				+ score + ", countHealthCare=" + countHealthCare
				+ ", countBank=" + countBank + ", countEntertainment="
				+ countEntertainment + ", countBusiness=" + countBusiness
				+ ", countSurroundingEnvironment="
				+ countSurroundingEnvironment + ", countUnfavorableFactors="
				+ countUnfavorableFactors + "]";
	}

}
