package com.jzhl.kfsq.dataset.mm;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 
 * MM_Member表
 * 
 * @author zhouzy
 *
 */
public class MemberVisitDataSet implements Serializable {

	private static final long serialVersionUID = 1L;

	private java.lang.String areaName; // 会员所在城市
	private java.lang.String nickName; // 名字
	private java.lang.String buildingName; // 楼盘名称
	private java.sql.Timestamp planTime; // 计划时间
	private BigDecimal price; // 领取金额
	private java.sql.Timestamp visitTime; // 到访时间
	private java.lang.String userName; // 售楼员名称；验证员工

	public java.lang.String getAreaName() {
		return areaName;
	}

	public void setAreaName(java.lang.String areaName) {
		this.areaName = areaName;
	}

	public java.lang.String getNickName() {
		return nickName;
	}

	public void setNickName(java.lang.String nickName) {
		this.nickName = nickName;
	}

	public java.lang.String getBuildingName() {
		return buildingName;
	}

	public void setBuildingName(java.lang.String buildingName) {
		this.buildingName = buildingName;
	}

	public java.sql.Timestamp getPlanTime() {
		return planTime;
	}

	public void setPlanTime(java.sql.Timestamp planTime) {
		this.planTime = planTime;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public java.sql.Timestamp getVisitTime() {
		return visitTime;
	}

	public void setVisitTime(java.sql.Timestamp visitTime) {
		this.visitTime = visitTime;
	}

	public java.lang.String getUserName() {
		return userName;
	}

	public void setUserName(java.lang.String userName) {
		this.userName = userName;
	}

}