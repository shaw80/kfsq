package com.jzhl.kfsq.dataset.sm;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CommentTagBean {
	private java.lang.Integer goodCommentNum; // 好评数量
	private java.lang.Integer badCommentNum; // 差评数量
	private List<CommentTagDataSet> goodCommentTags = new ArrayList<CommentTagDataSet>();// 好评标签列表
	private List<CommentTagDataSet> badCommentTags = new ArrayList<CommentTagDataSet>();// 差评标签列表

	public java.lang.Integer getGoodCommentNum() {
		return goodCommentNum;
	}

	public void setGoodCommentNum(java.lang.Integer goodCommentNum) {
		this.goodCommentNum = goodCommentNum;
	}

	public java.lang.Integer getBadCommentNum() {
		return badCommentNum;
	}

	public void setBadCommentNum(java.lang.Integer badCommentNum) {
		this.badCommentNum = badCommentNum;
	}

	public List<CommentTagDataSet> getGoodCommentTags() {
		return goodCommentTags;
	}

	public void setGoodCommentTags(List<CommentTagDataSet> goodCommentTags) {
		this.goodCommentTags = goodCommentTags;
	}

	public List<CommentTagDataSet> getBadCommentTags() {
		return badCommentTags;
	}

	public void setBadCommentTags(List<CommentTagDataSet> badCommentTags) {
		this.badCommentTags = badCommentTags;
	}

}
