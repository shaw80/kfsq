package com.jzhl.kfsq.dataset.sm;

import java.io.Serializable;

/**
 * 
 * 
 * @author zhouzy
 *
 */
public class BranchStatisticalDataSet implements Serializable {

	private static final long serialVersionUID = 1L;

	private java.lang.String comanyName; // 代理商公司名称
	private java.lang.Integer buildingNum; // 楼盘数量
	private java.lang.String areaName; // 所在城市
	private java.sql.Timestamp createTime; // 代理商创建时间

	public java.lang.String getComanyName() {
		return comanyName;
	}

	public void setComanyName(java.lang.String comanyName) {
		this.comanyName = comanyName;
	}

	public java.lang.Integer getBuildingNum() {
		return buildingNum;
	}

	public void setBuildingNum(java.lang.Integer buildingNum) {
		this.buildingNum = buildingNum;
	}

	public java.lang.String getAreaName() {
		return areaName;
	}

	public void setAreaName(java.lang.String areaName) {
		this.areaName = areaName;
	}

	public java.sql.Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(java.sql.Timestamp createTime) {
		this.createTime = createTime;
	}

	@Override
	public String toString() {
		return "BranchStatisticalDataSet [comanyName=" + comanyName + ", buildingNum=" + buildingNum + ", areaName=" + areaName
				+ ", createTime=" + createTime + "]";
	}

}