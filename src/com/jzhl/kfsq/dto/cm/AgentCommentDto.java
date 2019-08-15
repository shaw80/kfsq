package com.jzhl.kfsq.dto.cm;

import java.io.Serializable;

import com.jzhl.kfsq.common.base.PageListCondition;

public class AgentCommentDto extends PageListCondition implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private java.lang.Short isValid; // 0：无效，1：有效
	private java.lang.String content; // 楼盘名称
	private java.lang.String userName;//用户名
	private java.lang.String headPortrait;//用户头像
	private java.lang.Integer parentCommentId; // 上级id
	private java.lang.Integer creatorUserId; // 创建人id
	private java.lang.Short auditStatus; // 0：未审批，1：审批通过，2：审批不通过
	private java.lang.Short isTop; // '0：不置顶，1：置顶',
	private java.lang.String imgurl;//评论图片
	private java.lang.String imgName;//图片名称
	private java.lang.String  imgDes;//图片描述
	private java.lang.Short isUse;
	private java.lang.Integer commentId; // 论评编号
	private java.lang.Integer buildingId; // 楼盘编号
	private java.lang.Integer replyParentUserId; // 回复的父级发布人编号
	private java.util.Date createTime; // 
	private java.lang.Integer updateUserId; // 更新人
	private java.util.Date updateTime;
	private java.lang.Short readStatus;
	public java.lang.Short getIsValid() {
		return isValid;
	}
	public void setIsValid(java.lang.Short isValid) {
		this.isValid = isValid;
	}
	public java.lang.String getContent() {
		return content;
	}
	public void setContent(java.lang.String content) {
		this.content = content;
	}
	public java.lang.Integer getParentCommentId() {
		return parentCommentId;
	}
	public void setParentCommentId(java.lang.Integer parentCommentId) {
		this.parentCommentId = parentCommentId;
	}
	public java.lang.Integer getCreatorUserId() {
		return creatorUserId;
	}
	public void setCreatorUserId(java.lang.Integer creatorUserId) {
		this.creatorUserId = creatorUserId;
	}
	public java.lang.Short getAuditStatus() {
		return auditStatus;
	}
	public void setAuditStatus(java.lang.Short auditStatus) {
		this.auditStatus = auditStatus;
	}
	public java.lang.Short getIsTop() {
		return isTop;
	}
	public void setIsTop(java.lang.Short isTop) {
		this.isTop = isTop;
	}
	public java.lang.String getImgurl() {
		return imgurl;
	}
	public void setImgurl(java.lang.String imgurl) {
		this.imgurl = imgurl;
	}
	public java.lang.String getImgName() {
		return imgName;
	}
	public void setImgName(java.lang.String imgName) {
		this.imgName = imgName;
	}
	public java.lang.String getImgDes() {
		return imgDes;
	}
	public void setImgDes(java.lang.String imgDes) {
		this.imgDes = imgDes;
	}
	public java.lang.Short getIsUse() {
		return isUse;
	}
	public void setIsUse(java.lang.Short isUse) {
		this.isUse = isUse;
	}
	public java.lang.String getUserName() {
		return userName;
	}
	public void setUserName(java.lang.String userName) {
		this.userName = userName;
	}
	public java.lang.String getHeadPortrait() {
		return headPortrait;
	}
	public void setHeadPortrait(java.lang.String headPortrait) {
		this.headPortrait = headPortrait;
	}
	public java.lang.Integer getCommentId() {
		return commentId;
	}
	public void setCommentId(java.lang.Integer commentId) {
		this.commentId = commentId;
	}
	public java.lang.Integer getBuildingId() {
		return buildingId;
	}
	public void setBuildingId(java.lang.Integer buildingId) {
		this.buildingId = buildingId;
	}
	public java.lang.Integer getReplyParentUserId() {
		return replyParentUserId;
	}
	public void setReplyParentUserId(java.lang.Integer replyParentUserId) {
		this.replyParentUserId = replyParentUserId;
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
	public java.lang.Short getReadStatus() {
		return readStatus;
	}
	public void setReadStatus(java.lang.Short readStatus) {
		this.readStatus = readStatus;
	}
	
}
