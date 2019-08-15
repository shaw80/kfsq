package com.jzhl.kfsq.dto.cm;

import java.io.Serializable;

import com.jzhl.kfsq.common.base.PageListCondition;

/**
 * 查询我的评价DTO
 * 
 * @author Shaw
 *
 */
public class MyCommentDto extends PageListCondition implements Serializable {

	private static final long serialVersionUID = 7322688869054058472L;// 序列化

	private String buildingId;// 楼盘编号

	private String memberId;// 会员编号
	
	private Integer commentType; // 评论类型
	
	private Integer comparisonValue; // 好评差评比较值
	
	private Integer comparisonType;// 比较类型  1好评，2差评

	public String getBuildingId() {
		return buildingId;
	}

	public void setBuildingId(String buildingId) {
		this.buildingId = buildingId;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
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

}
