package com.jzhl.kfsq.entity.ba;

import java.io.Serializable;

public class MemberEvaluate implements Serializable{
	private static final long serialVersionUID = 8741448399329300011L;
	private java.lang.Integer meId; // 用户信息评价ID
	private java.lang.Integer commentId; // 评价ID
	private java.lang.Integer memberId; // 用户编号
	private java.lang.Integer buildingId; // 楼盘编号
	private java.lang.String dimensionCode;// 维度代码
	private java.lang.Integer dimensionValue; // 分数
	private java.util.Date createTime; // 
	private java.util.Date updateTime; // 
	private java.lang.Integer createUserId; // 创建者：记录用户的创建人员的名称
	private java.lang.Integer updateUserId; // 更新人
	private java.lang.Short isValid = 1; // 0：无效，1：有效
	
	public java.lang.Integer getMeId() {
		return meId;
	}
	public void setMeId(java.lang.Integer meId) {
		this.meId = meId;
	}
	public java.lang.Integer getCommentId() {
		return commentId;
	}
	public void setCommentId(java.lang.Integer commentId) {
		this.commentId = commentId;
	}
	public java.lang.Integer getMemberId() {
		return memberId;
	}
	public void setMemberId(java.lang.Integer memberId) {
		this.memberId = memberId;
	}
	public java.lang.Integer getBuildingId() {
		return buildingId;
	}
	public void setBuildingId(java.lang.Integer buildingId) {
		this.buildingId = buildingId;
	}
	public java.lang.Integer getDimensionValue() {
		return dimensionValue;
	}
	public void setDimensionValue(java.lang.Integer dimensionValue) {
		this.dimensionValue = dimensionValue;
	}
	public java.util.Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(java.util.Date createTime) {
		this.createTime = createTime;
	}
	public java.util.Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(java.util.Date updateTime) {
		this.updateTime = updateTime;
	}
	
	public java.lang.Integer getCreateUserId() {
		return createUserId;
	}
	public void setCreateUserId(java.lang.Integer createUserId) {
		this.createUserId = createUserId;
	}
	public java.lang.Integer getUpdateUserId() {
		return updateUserId;
	}
	public void setUpdateUserId(java.lang.Integer updateUserId) {
		this.updateUserId = updateUserId;
	}
	public java.lang.Short getIsValid() {
		return isValid;
	}
	public void setIsValid(java.lang.Short isValid) {
		this.isValid = isValid;
	}
	public java.lang.String getDimensionCode() {
		return dimensionCode;
	}
	public void setDimensionCode(java.lang.String dimensionCode) {
		this.dimensionCode = dimensionCode;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
