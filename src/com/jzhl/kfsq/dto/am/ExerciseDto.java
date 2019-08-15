package com.jzhl.kfsq.dto.am;

import java.sql.Timestamp;

public class ExerciseDto {
	private java.lang.Integer exerciseId; // 活动编号，主键
	private java.lang.String title; // 活动主题
	private Timestamp beginTime; // 开始时间
	private Timestamp endTime; // 结束时间
	private java.lang.String content; // 内容
	private java.lang.String url; // 链接地址
	private java.lang.String image; // 图片
	private java.lang.Integer joinCount;
	private java.lang.Integer isValid; // 0：无效，1：有效
	private java.lang.Integer creatorUserId;
	private Timestamp createTime;
	private java.lang.Integer updateUserId;
	private Timestamp updateTime;

	public java.lang.Integer getExerciseId() {
		return exerciseId;
	}

	public void setExerciseId(java.lang.Integer exerciseId) {
		this.exerciseId = exerciseId;
	}

	public java.lang.String getTitle() {
		return title;
	}

	public void setTitle(java.lang.String title) {
		this.title = title;
	}

	public Timestamp getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(Timestamp beginTime) {
		this.beginTime = beginTime;
	}

	public Timestamp getEndTime() {
		return endTime;
	}

	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;
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

	public java.lang.String getImage() {
		return image;
	}

	public void setImage(java.lang.String image) {
		this.image = image;
	}

	public java.lang.Integer getJoinCount() {
		return joinCount;
	}

	public void setJoinCount(java.lang.Integer joinCount) {
		this.joinCount = joinCount;
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

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public java.lang.Integer getUpdateUserId() {
		return updateUserId;
	}

	public void setUpdateUserId(java.lang.Integer updateUserId) {
		this.updateUserId = updateUserId;
	}

	public Timestamp getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}

	@Override
	public String toString() {
		return "ExerciseDto [exerciseId=" + exerciseId + ", title=" + title + ", beginTime=" + beginTime + ", endTime=" + endTime
				+ ", content=" + content + ", url=" + url + ", image=" + image + ", joinCount=" + joinCount + ", isValid=" + isValid
				+ ", creatorUserId=" + creatorUserId + ", createTime=" + createTime + ", updateUserId=" + updateUserId + ", updateTime="
				+ updateTime + "]";
	}

}
