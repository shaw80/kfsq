package com.jzhl.kfsq.dto.em;

import com.jzhl.kfsq.common.base.PageListCondition;

public class EncyclopediaDto extends PageListCondition {
	private java.lang.Integer firstClassId;
	private java.lang.String firstClassName;
	private java.lang.Integer secondClassId;
	private java.lang.String secondClassName;
	private java.lang.Integer encyclopediaId;
	private java.lang.String title;
	private java.sql.Timestamp updateTime;
	private java.lang.Integer readCount;
	private java.lang.Integer updateUserId;
	private java.lang.String updateUserName;
	private java.lang.String content;
	private java.lang.String url;

	private java.lang.Integer creatorUserId; // '创建者：记录用户的创建人员的名称。
	private java.lang.Integer parentId; // 父类编号
	private java.lang.Integer classId; // 分类编号
	private java.lang.Integer isValid; // 0：无效，1：有效

	public java.lang.Integer getFirstClassId() {
		return firstClassId;
	}

	public void setFirstClassId(java.lang.Integer firstClassId) {
		this.firstClassId = firstClassId;
	}

	public java.lang.String getFirstClassName() {
		return firstClassName;
	}

	public void setFirstClassName(java.lang.String firstClassName) {
		this.firstClassName = firstClassName;
	}

	public java.lang.Integer getSecondClassId() {
		return secondClassId;
	}

	public void setSecondClassId(java.lang.Integer secondClassId) {
		this.secondClassId = secondClassId;
	}

	public java.lang.String getSecondClassName() {
		return secondClassName;
	}

	public void setSecondClassName(java.lang.String secondClassName) {
		this.secondClassName = secondClassName;
	}

	public java.lang.Integer getEncyclopediaId() {
		return encyclopediaId;
	}

	public void setEncyclopediaId(java.lang.Integer encyclopediaId) {
		this.encyclopediaId = encyclopediaId;
	}

	public java.lang.String getTitle() {
		return title;
	}

	public void setTitle(java.lang.String title) {
		this.title = title;
	}

	public java.sql.Timestamp getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(java.sql.Timestamp updateTime) {
		this.updateTime = updateTime;
	}

	public java.lang.Integer getReadCount() {
		return readCount;
	}

	public void setReadCount(java.lang.Integer readCount) {
		this.readCount = readCount;
	}

	public java.lang.Integer getUpdateUserId() {
		return updateUserId;
	}

	public void setUpdateUserId(java.lang.Integer updateUserId) {
		this.updateUserId = updateUserId;
	}

	public java.lang.String getUpdateUserName() {
		return updateUserName;
	}

	public void setUpdateUserName(java.lang.String updateUserName) {
		this.updateUserName = updateUserName;
	}

	public java.lang.String getContent() {
		return content;
	}

	public void setContent(java.lang.String content) {
		this.content = content;
	}

	public java.lang.String getUrl() {
		return url;
	}

	public void setUrl(java.lang.String url) {
		this.url = url;
	}

	public java.lang.Integer getParentId() {
		return parentId;
	}

	public void setParentId(java.lang.Integer parentId) {
		this.parentId = parentId;
	}

	public java.lang.Integer getClassId() {
		return classId;
	}

	public void setClassId(java.lang.Integer classId) {
		this.classId = classId;
	}

	public java.lang.Integer getCreatorUserId() {
		return creatorUserId;
	}

	public void setCreatorUserId(java.lang.Integer creatorUserId) {
		this.creatorUserId = creatorUserId;
	}

	public java.lang.Integer getIsValid() {
		return isValid;
	}

	public void setIsValid(java.lang.Integer isValid) {
		this.isValid = isValid;
	}

	@Override
	public String toString() {
		return "EncyclopediaDto [firstClassId=" + firstClassId + ", firstClassName=" + firstClassName + ", secondClassId=" + secondClassId
				+ ", secondClassName=" + secondClassName + ", encyclopediaId=" + encyclopediaId + ", title=" + title + ", updateTime="
				+ updateTime + ", readCount=" + readCount + ", updateUserId=" + updateUserId + ", updateUserName=" + updateUserName
				+ ", content=" + content + ", url=" + url + ", creatorUserId=" + creatorUserId + ", parentId=" + parentId + ", classId="
				+ classId + ", isValid=" + isValid + "]";
	}

}
