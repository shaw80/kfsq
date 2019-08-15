package com.jzhl.kfsq.dataset.sm;

import java.io.Serializable;

/**
 * 用户实体类
 * 
 * @author zhouzy
 *
 */
public class UserDataSet implements Serializable {

	private static final long serialVersionUID = -670560038317867095L;// 序列化

	private java.lang.Integer userId; // 用户编号，主键
	private java.lang.String name; // 用户名称
	private java.lang.Integer branchId; // 代理商ID

	private String comanyName; // 公司名称
	private java.lang.Integer buildingNum; // 楼盘总数
	private java.lang.Integer userNum; // 管理员总数
	private java.lang.Integer memberNum; // 接待会员总数

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getComanyName() {
		return comanyName;
	}

	public void setComanyName(String comanyName) {
		this.comanyName = comanyName;
	}

	public java.lang.Integer getBuildingNum() {
		return buildingNum;
	}

	public void setBuildingNum(java.lang.Integer buildingNum) {
		this.buildingNum = buildingNum;
	}

	public java.lang.Integer getUserNum() {
		return userNum;
	}

	public void setUserNum(java.lang.Integer userNum) {
		this.userNum = userNum;
	}

	public java.lang.String getName() {
		return name;
	}

	public void setName(java.lang.String name) {
		this.name = name;
	}

	public java.lang.Integer getMemberNum() {
		return memberNum;
	}

	public void setMemberNum(java.lang.Integer memberNum) {
		this.memberNum = memberNum;
	}

	public java.lang.Integer getBranchId() {
		return branchId;
	}

	public void setBranchId(java.lang.Integer branchId) {
		this.branchId = branchId;
	}

	@Override
	public String toString() {
		return "UserDataSet [userId=" + userId + ", name=" + name + ", branchId=" + branchId + ", comanyName=" + comanyName
				+ ", buildingNum=" + buildingNum + ", userNum=" + userNum + ", memberNum=" + memberNum + "]";
	}

}
