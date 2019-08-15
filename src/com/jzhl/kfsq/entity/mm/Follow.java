package com.jzhl.kfsq.entity.mm;

public class Follow {
	private java.lang.Integer followId; // 关注编号
	private java.lang.Integer memberId; // 会员编号，外键
	private java.lang.Integer buildingId; // 楼盘编号，外键
	private java.lang.Short isValid; // 0：无效，1：有效
	private java.lang.Integer creatorUserId; // 创建者：记录用户的创建人员的名称。
	private java.sql.Timestamp createTime; // 数据创建时间
	private java.lang.Integer updateUserId; 
	private java.sql.Timestamp updateTime; 
	
	public Follow() {
		
	}

	public java.lang.Integer getFollowId() {
		return followId;
	}

	public void setFollowId(java.lang.Integer followId) {
		this.followId = followId;
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

	public java.lang.Short getIsValid() {
		return isValid;
	}

	public void setIsValid(java.lang.Short isValid) {
		this.isValid = isValid;
	}

	public java.lang.Integer getCreatorUserId() {
		return creatorUserId;
	}

	public void setCreatorUserId(java.lang.Integer creatorUserId) {
		this.creatorUserId = creatorUserId;
	}

	public java.sql.Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(java.sql.Timestamp createTime) {
		this.createTime = createTime;
	}

	public java.lang.Integer getUpdateUserId() {
		return updateUserId;
	}

	public void setUpdateUserId(java.lang.Integer updateUserId) {
		this.updateUserId = updateUserId;
	}

	public java.sql.Timestamp getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(java.sql.Timestamp updateTime) {
		this.updateTime = updateTime;
	}
	
}
