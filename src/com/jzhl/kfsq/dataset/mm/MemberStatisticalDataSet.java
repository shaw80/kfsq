package com.jzhl.kfsq.dataset.mm;

import java.io.Serializable;

/**
 * 
 * 
 * @author zhouzy
 *
 */
public class MemberStatisticalDataSet implements Serializable {

	private static final long serialVersionUID = 1L;

	private java.lang.Integer memberNum; // 用户总数
	private java.lang.Integer planNum; // 加入计划数
	private java.lang.Integer visitNum; // 到访数
	private java.lang.Integer followNum; // 关注数
	private java.lang.Integer buildingCommentNum; // 看房圈评论数
	private java.lang.String month; // 月份
	private java.lang.String days; // 天
	private java.lang.String weeks; // 周

	public java.lang.Integer getMemberNum() {
		return memberNum;
	}

	public void setMemberNum(java.lang.Integer memberNum) {
		this.memberNum = memberNum;
	}

	public java.lang.Integer getPlanNum() {
		return planNum;
	}

	public void setPlanNum(java.lang.Integer planNum) {
		this.planNum = planNum;
	}

	public java.lang.Integer getFollowNum() {
		return followNum;
	}

	public void setFollowNum(java.lang.Integer followNum) {
		this.followNum = followNum;
	}

	public java.lang.Integer getBuildingCommentNum() {
		return buildingCommentNum;
	}

	public void setBuildingCommentNum(java.lang.Integer buildingCommentNum) {
		this.buildingCommentNum = buildingCommentNum;
	}

	public java.lang.Integer getVisitNum() {
		return visitNum;
	}

	public void setVisitNum(java.lang.Integer visitNum) {
		this.visitNum = visitNum;
	}

	public java.lang.String getMonth() {
		return month;
	}

	public void setMonth(java.lang.String month) {
		this.month = month;
	}

	public java.lang.String getDays() {
		return days;
	}

	public void setDays(java.lang.String days) {
		this.days = days;
	}

	public java.lang.String getWeeks() {
		return weeks;
	}

	public void setWeeks(java.lang.String weeks) {
		this.weeks = weeks;
	}

	@Override
	public String toString() {
		return "MemberStatisticalDataSet [memberNum=" + memberNum + ", planNum=" + planNum + ", visitNum=" + visitNum + ", followNum="
				+ followNum + ", buildingCommentNum=" + buildingCommentNum + ", month=" + month + ", days=" + days + ", weeks=" + weeks
				+ "]";
	}

}