package com.jzhl.kfsq.dto.em;

public class EncyclopediaClassDto {
	private java.lang.Integer classId;
	private java.lang.Integer parentId;
	private java.lang.String className;
	private java.lang.Integer joinUpdateCount;
	private java.lang.Integer creatorUserId;
	private java.util.Date createTime;
	private java.lang.Integer updateUserId;
	private java.util.Date updateTime;
	private java.lang.Integer isValid;
	private java.lang.String icon;

	public java.lang.Integer getClassId() {
		return classId;
	}

	public void setClassId(java.lang.Integer classId) {
		this.classId = classId;
	}

	public java.lang.Integer getParentId() {
		return parentId;
	}

	public void setParentId(java.lang.Integer parentId) {
		this.parentId = parentId;
	}

	public java.lang.String getClassName() {
		return className;
	}

	public void setClassName(java.lang.String className) {
		this.className = className;
	}

	public java.lang.Integer getJoinUpdateCount() {
		return joinUpdateCount;
	}

	public void setJoinUpdateCount(java.lang.Integer joinUpdateCount) {
		this.joinUpdateCount = joinUpdateCount;
	}

	public java.lang.Integer getCreatorUserId() {
		return creatorUserId;
	}

	public void setCreatorUserId(java.lang.Integer creatorUserId) {
		this.creatorUserId = creatorUserId;
	}

	public java.util.Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(java.util.Date createTime) {
		this.createTime = createTime;
	}

	public java.lang.Integer getUpdateUserId() {
		return updateUserId;
	}

	public void setUpdateUserId(java.lang.Integer updateUserId) {
		this.updateUserId = updateUserId;
	}

	public java.util.Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(java.util.Date updateTime) {
		this.updateTime = updateTime;
	}

	public java.lang.Integer getIsValid() {
		return isValid;
	}

	public void setIsValid(java.lang.Integer isValid) {
		this.isValid = isValid;
	}

	public java.lang.String getIcon() {
		return icon;
	}

	public void setIcon(java.lang.String icon) {
		this.icon = icon;
	}

	@Override
	public String toString() {
		return "EncyclopediaClassDto [classId=" + classId + ", parentId=" + parentId + ", className=" + className + ", joinUpdateCount="
				+ joinUpdateCount + ", creatorUserId=" + creatorUserId + ", createTime=" + createTime + ", updateUserId=" + updateUserId
				+ ", updateTime=" + updateTime + ", isValid=" + isValid + ", icon=" + icon + "]";
	}

}
