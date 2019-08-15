package com.jzhl.kfsq.dataset.cm;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 楼盘详情评论结果集
 * 
 * @author Shaw
 *
 */
public class BuildingCommentV3DataSet implements Serializable {

	private static final long serialVersionUID = 1033131438089224842L;// 序列化
	
	private Integer commentId;// 评论编号
	
	private String nickName;// 昵称
	
	private String headPortrait;// 头像
	
	private String score;// 分数
	
	private String content;// 评论内容
	
	private String createTime;// 创建时间
	
	private String countRepay;// 回复数量
	
	private List<MyCommentImg> imgs = new ArrayList<MyCommentImg>();// 图片集合

	public Integer getCommentId() {
		return commentId;
	}

	public void setCommentId(Integer commentId) {
		this.commentId = commentId;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getHeadPortrait() {
		if(headPortrait == null || "".equals(headPortrait)) {
			return "";
		}
		return headPortrait;
	}

	public void setHeadPortrait(String headPortrait) {
		this.headPortrait = headPortrait;
	}

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
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

	public String getCountRepay() {
		return countRepay;
	}

	public void setCountRepay(String countRepay) {
		this.countRepay = countRepay;
	}

	public List<MyCommentImg> getImgs() {
		return imgs;
	}

	public void setImgs(List<MyCommentImg> imgs) {
		this.imgs = imgs;
	}

	@Override
	public String toString() {
		return "BuildingCommentV3DataSet [commentId=" + commentId
				+ ", nickName=" + nickName + ", headPortrait=" + headPortrait
				+ ", score=" + score + ", content=" + content + ", createTime="
				+ createTime + ", countRepay=" + countRepay + ", imgs=" + imgs
				+ "]";
	}

}
