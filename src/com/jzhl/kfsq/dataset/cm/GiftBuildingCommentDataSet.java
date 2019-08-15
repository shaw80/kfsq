package com.jzhl.kfsq.dataset.cm;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 发表有礼看房圈评论结果集
 * 
 * @author Shaw
 *
 */
public class GiftBuildingCommentDataSet implements Serializable {
	
	private static final long serialVersionUID = 5635685786922932932L;// 序列化

	private int commentId;// 评论编号
	
	private String buildingName;// 楼盘名称
	
	private String content;// 评论内容
	
	private String createTime;// 创建时间
	
	private List<CommentImgDataSet> imgs = new ArrayList<CommentImgDataSet>();

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

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public List<CommentImgDataSet> getImgs() {
		return imgs;
	}

	public void setImgs(List<CommentImgDataSet> imgs) {
		this.imgs = imgs;
	}

	@Override
	public String toString() {
		return "GiftBuildingCommentDataSet [commentId=" + commentId
				+ ", buildingName=" + buildingName + ", content=" + content
				+ ", createTime=" + createTime + ", imgs=" + imgs + "]";
	}

}
