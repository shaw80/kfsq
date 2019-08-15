package com.jzhl.kfsq.entity.bm;

import java.io.Serializable;

/**
 * 
 * BM_BuildingTag表
 * 
 * @author zhouzy
 *
 */
public class BuildingTag implements Serializable {
	private static final long serialVersionUID = 6060229381175852562L;
	private java.lang.Integer id; // 中间表主键
	private java.lang.Integer buildingId; // 楼盘编号
	private java.lang.Integer tagId; // 标签编号
	private java.lang.Integer isShow; // 否是需要显示，0：不显示，1：显示
	private java.lang.Integer isValid; // 0：无效，1：有效
	private java.lang.Integer creatorUserId; // 创建者：记录用户的创建人员的名称
	private java.sql.Timestamp createTime; //
	private java.lang.Integer updateUserId; // 更新人ID
	private java.sql.Timestamp updateTime; // 数据更新时间

	public java.lang.Integer getId() {
		return id;
	}

	public void setId(java.lang.Integer id) {
		this.id = id;
	}

	public java.lang.Integer getBuildingId() {
		return buildingId;
	}

	public void setBuildingId(java.lang.Integer buildingId) {
		this.buildingId = buildingId;
	}

	public java.lang.Integer getTagId() {
		return tagId;
	}

	public void setTagId(java.lang.Integer tagId) {
		this.tagId = tagId;
	}

	public java.lang.Integer getIsShow() {
		return isShow;
	}

	public void setIsShow(java.lang.Integer isShow) {
		this.isShow = isShow;
	}

	public java.lang.Integer getIsValid() {
		return isValid;
	}

	public void setIsValid(java.lang.Integer isValid) {
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

	public void setUpdateTime(java.sql.Timestamp updateTime) {
		this.updateTime = updateTime;
	}

	public java.lang.Integer getUpdateUserId() {
		return updateUserId;
	}

	public void setUpdateUserId(java.lang.Integer updateUserId) {
		this.updateUserId = updateUserId;
	}

	@Override
	public String toString() {
		return "BuildingTag [id=" + id + ", buildingId=" + buildingId + ", tagId=" + tagId + ", isShow=" + isShow + ", isValid=" + isValid
				+ ", creatorUserId=" + creatorUserId + ", createTime=" + createTime + ", updateUserId=" + updateUserId + ", updateTime="
				+ updateTime + "]";
	}

}