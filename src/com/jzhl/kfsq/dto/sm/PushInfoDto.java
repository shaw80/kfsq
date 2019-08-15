package com.jzhl.kfsq.dto.sm;

import java.io.Serializable;

import com.jzhl.kfsq.common.base.PageListCondition;

/**
 * 
 * SM_PushInfo表
 * 
 * @author zhouzy
 *
 */
public class PushInfoDto extends PageListCondition implements Serializable {
	private static final long serialVersionUID = -5467812254076307950L;
	private java.lang.Integer pushId; // 主键
	private java.lang.String title; // 标题
	private java.lang.String content; // 推送内容
	private java.lang.String targetGroup; // 目标人群（0：全部，1：用户端用户，2：商户端用户（售楼员，销售经理）
	private java.lang.Integer cityId; // 城市编号
	private java.lang.Short pushType; // 发送方式（0：立即发送，1：定时发送）
	private java.lang.Short isOffLine; // 是否离线推送（0：否，1：是）
	private java.lang.Short isSuccess; // 是否成功（0：失败，1：成功）
	private java.sql.Timestamp customTime; // 自定义时间
	private java.sql.Timestamp createTime; // 创建时间
	private java.lang.Integer creatorUserId; // 创建人编号
	private java.lang.Integer memberId; // 会员ID

	/**
	 * 获取主键属性
	 *
	 * @return pushId
	 */
	public java.lang.Integer getpushId() {
		return pushId;
	}

	/**
	 * 设置主键属性
	 *
	 * @param pushId
	 */
	public void setpushId(java.lang.Integer pushId) {
		this.pushId = pushId;
	}

	/**
	 * 获取标题属性
	 *
	 * @return title
	 */
	public java.lang.String getTitle() {
		return title;
	}

	/**
	 * 设置标题属性
	 *
	 * @param title
	 */
	public void setTitle(java.lang.String title) {
		this.title = title;
	}

	/**
	 * 获取推送内容属性
	 *
	 * @return content
	 */
	public java.lang.String getContent() {
		return content;
	}

	/**
	 * 设置推送内容属性
	 *
	 * @param content
	 */
	public void setContent(java.lang.String content) {
		this.content = content;
	}

	/**
	 * 获取目标人群（0：全部，1：会员，2：售楼员，3：销售经理），可多选，用','间隔属性
	 *
	 * @return targetGroup
	 */
	public java.lang.String gettargetGroup() {
		return targetGroup;
	}

	/**
	 * 设置目标人群（0：全部，1：会员，2：售楼员，3：销售经理），可多选，用','间隔属性
	 *
	 * @param targetGroup
	 */
	public void settargetGroup(java.lang.String targetGroup) {
		this.targetGroup = targetGroup;
	}

	/**
	 * 获取城市编号属性
	 *
	 * @return cityId
	 */
	public java.lang.Integer getcityId() {
		return cityId;
	}

	/**
	 * 设置城市编号属性
	 *
	 * @param cityId
	 */
	public void setcityId(java.lang.Integer cityId) {
		this.cityId = cityId;
	}

	/**
	 * 获取发送方式（0：立即发送，1：定时发送）属性
	 *
	 * @return pushType
	 */
	public java.lang.Short getpushType() {
		return pushType;
	}

	/**
	 * 设置发送方式（0：立即发送，1：定时发送）属性
	 *
	 * @param pushType
	 */
	public void setpushType(java.lang.Short pushType) {
		this.pushType = pushType;
	}

	/**
	 * 获取是否离线推送（0：否，1：是）属性
	 *
	 * @return isOffLine
	 */
	public java.lang.Short getisOffLine() {
		return isOffLine;
	}

	/**
	 * 设置是否离线推送（0：否，1：是）属性
	 *
	 * @param isOffLine
	 */
	public void setisOffLine(java.lang.Short isOffLine) {
		this.isOffLine = isOffLine;
	}

	/**
	 * 获取自定义时间属性
	 *
	 * @return customTime
	 */
	public java.sql.Timestamp getcustomTime() {
		return customTime;
	}

	/**
	 * 设置自定义时间属性
	 *
	 * @param customTime
	 */
	public void setcustomTime(java.sql.Timestamp customTime) {
		this.customTime = customTime;
	}

	/**
	 * 获取创建时间属性
	 *
	 * @return createTime
	 */
	public java.sql.Timestamp getcreateTime() {
		return createTime;
	}

	/**
	 * 设置创建时间属性
	 *
	 * @param createTime
	 */
	public void setcreateTime(java.sql.Timestamp createTime) {
		this.createTime = createTime;
	}

	/**
	 * 获取创建人编号属性
	 *
	 * @return creatorUserId
	 */
	public java.lang.Integer getcreatorUserId() {
		return creatorUserId;
	}

	/**
	 * 设置创建人编号属性
	 *
	 * @param creatorUserId
	 */
	public void setcreatorUserId(java.lang.Integer creatorUserId) {
		this.creatorUserId = creatorUserId;
	}

	public java.lang.Short getIsSuccess() {
		return isSuccess;
	}

	public void setIsSuccess(java.lang.Short isSuccess) {
		this.isSuccess = isSuccess;
	}

	public java.lang.Integer getMemberId() {
		return memberId;
	}

	public void setMemberId(java.lang.Integer memberId) {
		this.memberId = memberId;
	}

	@Override
	public String toString() {
		return "PushInfoDto [pushId=" + pushId + ", title=" + title + ", content=" + content + ", targetGroup=" + targetGroup + ", cityId="
				+ cityId + ", pushType=" + pushType + ", isOffLine=" + isOffLine + ", isSuccess=" + isSuccess + ", customTime="
				+ customTime + ", createTime=" + createTime + ", creatorUserId=" + creatorUserId + ", memberId=" + memberId + "]";
	}

}