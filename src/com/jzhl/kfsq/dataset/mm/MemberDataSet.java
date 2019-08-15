package com.jzhl.kfsq.dataset.mm;

import java.util.List;

public class MemberDataSet {

	protected List<?> dataList = null;

	protected int dataCount = 0;

	private java.lang.Integer planListNum; // 所有人加入计划总数
	private java.lang.Integer visitListNum; // 所有人到访数
	private java.lang.Integer followListNum; // 所有人关注数
	private java.lang.Integer buildingCommentListNum; // 所有人看房圈评论数

	public List<?> getDataList() {
		return dataList;
	}

	public void setDataList(List<?> dataList) {
		this.dataList = dataList;
	}

	public int getDataCount() {
		return dataCount;
	}

	public void setDataCount(int dataCount) {
		this.dataCount = dataCount;
	}

	public java.lang.Integer getPlanListNum() {
		return planListNum;
	}

	public void setPlanListNum(java.lang.Integer planListNum) {
		this.planListNum = planListNum;
	}

	public java.lang.Integer getVisitListNum() {
		return visitListNum;
	}

	public void setVisitListNum(java.lang.Integer visitListNum) {
		this.visitListNum = visitListNum;
	}

	public java.lang.Integer getFollowListNum() {
		return followListNum;
	}

	public void setFollowListNum(java.lang.Integer followListNum) {
		this.followListNum = followListNum;
	}

	public java.lang.Integer getBuildingCommentListNum() {
		return buildingCommentListNum;
	}

	public void setBuildingCommentListNum(java.lang.Integer buildingCommentListNum) {
		this.buildingCommentListNum = buildingCommentListNum;
	}

}
