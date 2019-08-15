package com.jzhl.kfsq.dataset.sm;

import java.io.Serializable;

public class CommentTagDataSet implements Serializable {

	private static final long serialVersionUID = -4941569779638518593L;// 序列化

	private java.lang.Integer tagId;// 标签编号

	private java.lang.String tagName;// 标签特色名称

	public java.lang.Integer getTagId() {
		return tagId;
	}

	public void setTagId(java.lang.Integer tagId) {
		this.tagId = tagId;
	}

	public java.lang.String getTagName() {
		return tagName;
	}

	public void setTagName(java.lang.String tagName) {
		this.tagName = tagName;
	}

	@Override
	public String toString() {
		return "FeatureTagDataSet [tagId=" + tagId + ", tagName=" + tagName + "]";
	}

}
