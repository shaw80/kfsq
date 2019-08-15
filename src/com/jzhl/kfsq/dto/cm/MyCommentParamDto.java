package com.jzhl.kfsq.dto.cm;

import java.io.Serializable;

import com.jzhl.kfsq.common.base.PageListCondition;

/**
 * 查询我的评价时的入参
 * 
 * @author Shaw
 *
 */
public class MyCommentParamDto extends PageListCondition implements Serializable {

	private static final long serialVersionUID = 5029044999886415388L;// 序列化

	private Integer buildingId;// 楼盘编号

	private Integer memberId;// 会员编号

	private Integer commentType; // 评论类型

	private Integer comparisonValue; // 好评差评比较值

	private Integer comparisonType;// 比较类型 1好评，2差评

	private java.lang.Integer commentId; // 评论ID

	public Integer getBuildingId() {
		return buildingId;
	}

	public void setBuildingId(Integer buildingId) {
		this.buildingId = buildingId;
	}

	public Integer getMemberId() {
		return memberId;
	}

	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}

	public Integer getCommentType() {
		return commentType;
	}

	public void setCommentType(Integer commentType) {
		this.commentType = commentType;
	}

	public Integer getComparisonValue() {
		return comparisonValue;
	}

	public void setComparisonValue(Integer comparisonValue) {
		this.comparisonValue = comparisonValue;
	}

	public Integer getComparisonType() {
		return comparisonType;
	}

	public void setComparisonType(Integer comparisonType) {
		this.comparisonType = comparisonType;
	}

	public java.lang.Integer getCommentId() {
		return commentId;
	}

	public void setCommentId(java.lang.Integer commentId) {
		this.commentId = commentId;
	}

}
