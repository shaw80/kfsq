package com.jzhl.kfsq.dataset.bm;

import java.io.Serializable;

/**
 * 户型标签结果集
 * 
 * @author Shaw
 *
 */
public class UnitMapTagDataSet implements Serializable {

	private static final long serialVersionUID = 1194231223088830412L;// 序列化

	private Integer tagId;// 字典编号

	private String name;// 标签名称

	public Integer getTagId() {
		return tagId;
	}

	public void setTagId(Integer tagId) {
		this.tagId = tagId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "UnitMapTagDataSet [tagId=" + tagId + ", name=" + name + "]";
	}

}
