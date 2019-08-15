package com.jzhl.kfsq.dataset.cm;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.jzhl.kfsq.common.util.SystemConfig;

/**
 * 我的评价结果集
 * 
 * @author Shaw
 *
 */
public class MyComment implements Serializable {

	private static final long serialVersionUID = -2453448515837888918L;// 序列化
	
	private Integer commentId;// 评论编号
	
	private String buildingId;// 楼盘编号
	
	private String dimensionWeightSumValue;// 维度权重总值
	
	private String headPortrait;// 头像
	
	private String nickName;// 昵称
	
	private String content;// 内容
	
	private String createTime;// 创建时间
	
	private Integer count;// 回复数量
	
	private List<MyCommentImg> imgs = new ArrayList<MyCommentImg>();

	public Integer getCommentId() {
		return commentId;
	}

	public void setCommentId(Integer commentId) {
		this.commentId = commentId;
	}

	public String getHeadPortrait() {
		if(headPortrait == null || "".equals(headPortrait)) {
			return "";
		}
		return SystemConfig.getHttpBasePath() + headPortrait;
	}

	public void setHeadPortrait(String headPortrait) {
		this.headPortrait = headPortrait;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	
	public String getDimensionWeightSumValue() {
		return dimensionWeightSumValue;
	}

	public void setDimensionWeightSumValue(String dimensionWeightSumValue) {
		this.dimensionWeightSumValue = dimensionWeightSumValue;
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

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public List<MyCommentImg> getImgs() {
		return imgs;
	}

	public void setImgs(List<MyCommentImg> imgs) {
		this.imgs = imgs;
	}

	public String getBuildingId() {
		return buildingId;
	}

	public void setBuildingId(String buildingId) {
		this.buildingId = buildingId;
	}

	@Override
	public String toString() {
		return "MyComment [commentId=" + commentId + ", buildingId="
				+ buildingId + ", headPortrait=" + headPortrait + ", nickName="
				+ nickName + ", content=" + content + ", createTime="
				+ createTime + ", count=" + count + ", imgs=" + imgs + "]";
	}

}
