package com.jzhl.kfsq.dto.sm;

import java.io.Serializable;

/**
 * 评分系统参数
 * 
 * @author Shaw
 *
 */
public class ScoreParams implements Serializable {

	private static final long serialVersionUID = -2307856567440643748L;// 序列化
	
	private Double score = 0.0;// 分数
	
	private Integer firstScore = 0;// 一级分数
	
	private Integer secondScore = 0;// 二级分数
	
	private Integer thirdScore = 0;// 三级分数
	
	private Integer fouthScore = 0;// 四级分数
	
	private Double firstWeight = 1.0;// 一级维度权重
	
	private Double secondWeight = 1.0;// 二级维度权重
	
	private Double thirdWeight = 1.0;// 三级维度权重
	
	private Double fouthWeight = 1.0;// 四级维度权重

	public Double getScore() {
		return score;
	}

	public void setScore(Double score) {
		this.score = score;
	}

	public Double getFirstWeight() {
		return firstWeight;
	}

	public void setFirstWeight(Double firstWeight) {
		this.firstWeight = firstWeight;
	}

	public Double getSecondWeight() {
		return secondWeight;
	}

	public void setSecondWeight(Double secondWeight) {
		this.secondWeight = secondWeight;
	}

	public Double getThirdWeight() {
		return thirdWeight;
	}

	public void setThirdWeight(Double thirdWeight) {
		this.thirdWeight = thirdWeight;
	}

	public Double getFouthWeight() {
		return fouthWeight;
	}

	public void setFouthWeight(Double fouthWeight) {
		this.fouthWeight = fouthWeight;
	}

	public Integer getFirstScore() {
		return firstScore;
	}

	public void setFirstScore(Integer firstScore) {
		this.firstScore = firstScore;
	}

	public Integer getSecondScore() {
		return secondScore;
	}

	public void setSecondScore(Integer secondScore) {
		this.secondScore = secondScore;
	}

	public Integer getThirdScore() {
		return thirdScore;
	}

	public void setThirdScore(Integer thirdScore) {
		this.thirdScore = thirdScore;
	}

	public Integer getFouthScore() {
		return fouthScore;
	}

	public void setFouthScore(Integer fouthScore) {
		this.fouthScore = fouthScore;
	}

}
