package com.jzhl.kfsq.dataset.sm;

import java.io.Serializable;

/**
 * 
 * 
 * @author zhouzy
 *
 */
public class BuildingStatisticalDataSet implements Serializable {

	private static final long serialVersionUID = 2428820641700845959L;

	private java.lang.Integer buildingNum; // 楼盘数量
	private java.lang.Integer rechargeBuildingNum; // 已充值楼盘数量
	private java.lang.Integer branchBalance;// 平台剩余金额
	private java.lang.String month; // 月份

	private java.lang.Integer buildingNumYesterday; // 昨日新增楼盘数量
	private java.lang.Integer rechargeBuildingNumYesterday; // 昨日充值楼盘数量
	private java.lang.Integer branchRechargeYesterday;// 平台昨日充值金额

	public java.lang.Integer getBuildingNum() {
		return buildingNum;
	}

	public void setBuildingNum(java.lang.Integer buildingNum) {
		this.buildingNum = buildingNum;
	}

	public java.lang.Integer getRechargeBuildingNum() {
		return rechargeBuildingNum;
	}

	public void setRechargeBuildingNum(java.lang.Integer rechargeBuildingNum) {
		this.rechargeBuildingNum = rechargeBuildingNum;
	}

	public java.lang.Integer getBranchBalance() {
		return branchBalance;
	}

	public void setBranchBalance(java.lang.Integer branchBalance) {
		this.branchBalance = branchBalance;
	}

	public java.lang.String getMonth() {
		return month;
	}

	public void setMonth(java.lang.String month) {
		this.month = month;
	}

	public java.lang.Integer getBuildingNumYesterday() {
		return buildingNumYesterday;
	}

	public void setBuildingNumYesterday(java.lang.Integer buildingNumYesterday) {
		this.buildingNumYesterday = buildingNumYesterday;
	}

	public java.lang.Integer getRechargeBuildingNumYesterday() {
		return rechargeBuildingNumYesterday;
	}

	public void setRechargeBuildingNumYesterday(java.lang.Integer rechargeBuildingNumYesterday) {
		this.rechargeBuildingNumYesterday = rechargeBuildingNumYesterday;
	}

	public java.lang.Integer getBranchRechargeYesterday() {
		return branchRechargeYesterday;
	}

	public void setBranchRechargeYesterday(java.lang.Integer branchRechargeYesterday) {
		this.branchRechargeYesterday = branchRechargeYesterday;
	}

	@Override
	public String toString() {
		return "BuildingStatisticalDataSet [buildingNum=" + buildingNum + ", rechargeBuildingNum=" + rechargeBuildingNum
				+ ", branchBalance=" + branchBalance + ", month=" + month + ", buildingNumYesterday=" + buildingNumYesterday
				+ ", rechargeBuildingNumYesterday=" + rechargeBuildingNumYesterday + ", branchRechargeYesterday=" + branchRechargeYesterday
				+ "]";
	}

}