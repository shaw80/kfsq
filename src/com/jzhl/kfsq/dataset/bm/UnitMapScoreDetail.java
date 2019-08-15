package com.jzhl.kfsq.dataset.bm;

import java.io.Serializable;

import com.jzhl.kfsq.common.base.ListResult;

/**
 * 户型分数详情结果集
 * 
 * @author Shaw
 *
 */
public class UnitMapScoreDetail implements Serializable {

	private static final long serialVersionUID = 2806866157260714308L;

	private String unitMapScore = "0";// 分数
	
	private String countMember = "0";// 参数评分人数
	
	private String countUintMap = "0";// 主力户型数量
	
	ListResult listResult = new ListResult();

	public String getUnitMapScore() {
		return unitMapScore;
	}

	public void setUnitMapScore(String unitMapScore) {
		this.unitMapScore = unitMapScore;
	}

	public String getCountMember() {
		return countMember;
	}

	public void setCountMember(String countMember) {
		this.countMember = countMember;
	}

	public String getCountUintMap() {
		return countUintMap;
	}

	public void setCountUintMap(String countUintMap) {
		this.countUintMap = countUintMap;
	}

	public ListResult getListResult() {
		return listResult;
	}

	public void setListResult(ListResult listResult) {
		this.listResult = listResult;
	}

	@Override
	public String toString() {
		return "UnitMapScoreDetail [unitMapScore=" + unitMapScore
				+ ", countMember=" + countMember + ", countUintMap="
				+ countUintMap + ", listResult=" + listResult + "]";
	}

}
