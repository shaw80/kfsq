package com.jzhl.kfsq.dto.bm;

import java.io.Serializable;

/**
 * 
 * BM_BuildingTag表
 * 
 * @author mew
 *
 */
public class BuildingTagDto implements Serializable {
	private static final long serialVersionUID = 6060229381175852562L;
	private java.lang.Integer id; // 中间表主键
	private java.lang.Integer buildingId; // 楼盘编号
	private java.lang.Integer tagId; // 标签编号
	private java.lang.Integer isShow; // 否是需要显示，0：不显示，1：好评，2：差评'
	private java.lang.Integer isValid; // 0：无效，1：有效
	private java.lang.Integer creatorUserId; // 创建者：记录用户的创建人员的名称
	private java.sql.Timestamp createTime; //
	private java.lang.Integer updateUserId; // 更新人ID
	private java.sql.Timestamp updateTime; // 数据更新时间
	private java.lang.Integer memberId; // 会员编号
	private java.lang.Integer tagType; // '签标类型，1 用户标签、2 房源标签、3 房源标签、4 户型标签、
										// 5园区配套标签、6 娱乐设施标签、7 周边商业标签、8 周边环境标签、
										// 9周边不利因素标签'

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

	public java.sql.Timestamp getUpdateTime() {
		return updateTime;
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

	public java.lang.Integer getMemberId() {
		return memberId;
	}

	public void setMemberId(java.lang.Integer memberId) {
		this.memberId = memberId;
	}

	public java.lang.Integer getTagType() {
		return tagType;
	}

	public void setTagType(java.lang.Integer tagType) {
		this.tagType = tagType;
	}

	@Override
	public String toString() {
		return "BuildingTagDto [id=" + id + ", buildingId=" + buildingId
				+ ", tagId=" + tagId + ", isShow=" + isShow + ", isValid="
				+ isValid + ", creatorUserId=" + creatorUserId
				+ ", createTime=" + createTime + ", updateUserId="
				+ updateUserId + ", updateTime=" + updateTime + ", memberId="
				+ memberId + ", tagType=" + tagType + "]";
	}

}