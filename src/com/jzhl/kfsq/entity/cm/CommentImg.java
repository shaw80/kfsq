package com.jzhl.kfsq.entity.cm;

public class CommentImg {
	private java.lang.Integer imgId; // 图片编号
	private java.lang.Integer commentId; // 楼盘编号，外键
	private java.lang.Integer commentType; // 评论类型（0：看房圈，1：杂谈）
	private java.lang.String imgName; // 图片名称（如：A户型）
	private java.lang.String imgDes; // 图片描述（如：两室一厅）
	private java.lang.String path; // 路径
	private java.lang.String createTime; // 创建时间：记录用户的创建时间
	private java.lang.String isUse = "0"; 
	
	public CommentImg() {
		
	}

	public java.lang.Integer getImgId() {
		return imgId;
	}

	public void setImgId(int imgId) {
		this.imgId = imgId;
	}

	public java.lang.Integer getCommentId() {
		return commentId;
	}

	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}

	public java.lang.Integer getCommentType() {
		return commentType;
	}

	public void setCommentType(int commentType) {
		this.commentType = commentType;
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

	public java.lang.String getPath() {
		return path;
	}

	public void setPath(java.lang.String path) {
		this.path = path;
	}

	public java.lang.String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(java.lang.String createTime) {
		this.createTime = createTime;
	}

	public java.lang.String getIsUse() {
		return isUse;
	}

	public void setIsUse(java.lang.String isUse) {
		this.isUse = isUse;
	}
	
}
