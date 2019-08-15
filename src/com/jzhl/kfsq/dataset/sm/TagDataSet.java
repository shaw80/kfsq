package com.jzhl.kfsq.dataset.sm;

import java.io.Serializable;

/**
 * 
 * SM_Tag表
 * 
 * @author zhouzy
 *
 */
public class TagDataSet implements Serializable {
	private static final long serialVersionUID = -7044773381536185613L;
	private java.lang.Integer tagId; // 标签编号
	private java.lang.String tagName; // 标签名称
	private java.lang.Integer tagType; // 签标类型，例如：1 楼盘标签、2 户型标签、3 周边娱乐标签等
	private java.lang.String tagTypeName; // 标签类型名称
	private java.lang.Integer isFeature; // 是否为特色，0：否，1：是
	private java.lang.Integer isValid; // 0：无效，1：有效
	private java.lang.Integer creatorUserId; // 创建者：记录用户的创建人员的名称。
	private java.sql.Timestamp createTime; // 创建时间
	private java.lang.Integer updateUserId; //
	private java.sql.Timestamp updateTime; // 数据更新时间
	private java.lang.Integer isShow; // 否是需要显示，0：不显示，1：好评，2：差评'
	private java.lang.Integer isUsed; // '是否启用过，默认未启用过为0，1为启用过',
	private java.lang.Integer isScore; // 否是作为评分标准，1 是 0 否

	public java.lang.Integer getTagId() {
		return tagId;
	}

	public void setTagId(java.lang.Integer tagId) {
		this.tagId = tagId;
	}

	public java.lang.String getTagName() {
		return tagName;
	}

	public void setTagName(java.lang.String tagName) {
		this.tagName = tagName;
	}

	public java.lang.Integer getTagType() {
		return tagType;
	}

	public void setTagType(java.lang.Integer tagType) {
		this.tagType = tagType;
	}

	public java.lang.String getTagTypeName() {
		return tagTypeName;
	}

	public void setTagTypeName(java.lang.String tagTypeName) {
		this.tagTypeName = tagTypeName;
	}

	public java.lang.Integer getIsFeature() {
		return isFeature;
	}

	public void setIsFeature(java.lang.Integer isFeature) {
		this.isFeature = isFeature;
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

	public java.lang.Integer getIsShow() {
		return isShow;
	}

	public void setIsShow(java.lang.Integer isShow) {
		this.isShow = isShow;
	}

	public java.lang.Integer getIsUsed() {
		return isUsed;
	}

	public void setIsUsed(java.lang.Integer isUsed) {
		this.isUsed = isUsed;
	}

	public java.lang.Integer getIsScore() {
		return isScore;
	}

	public void setIsScore(java.lang.Integer isScore) {
		this.isScore = isScore;
	}

}