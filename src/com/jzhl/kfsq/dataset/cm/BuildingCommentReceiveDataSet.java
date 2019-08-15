package com.jzhl.kfsq.dataset.cm;

import java.sql.Timestamp;

/**
 * 看房圈评论查询结果集
 * 
 * @author Shaw
 *
 */
public class BuildingCommentReceiveDataSet {
	
	private int commentId;// 评论编号
	
	private String buildingName;// 楼盘名称
	
	private String content;// 评论内容
	
	private Timestamp createTime;// 创建时间

	public int getCommentId() {
		return commentId;
	}

	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}

	public String getBuildingName() {
		return buildingName;
	}

	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	@Override
	public String toString() {
		return "BuildingCommentReceiveDataSet [commentId=" + commentId
				+ ", buildingName=" + buildingName + ", content=" + content
				+ ", createTime=" + createTime + "]";
	}

}
