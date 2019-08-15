package com.jzhl.kfsq.dataset.bm;

import java.io.Serializable;

/**
 * 楼盘标签结果集
 * 
 * @author Shaw
 *
 */
public class BuildingTagDataSet implements Serializable {

	private static final long serialVersionUID = -570748602654594085L;// 序列化
	
	private Integer tagId;// 标签编号
	
	private String tagName;// 标签名称
	
	private String icon;// 图标

	public Integer getTagId() {
		return tagId;
	}

	public void setTagId(Integer tagId) {
		this.tagId = tagId;
	}

	public String getTagName() {
		return tagName;
	}

	public void setTagName(String tagName) {
		this.tagName = tagName;
	}

	public String getIcon() {
		if(icon == null || "".equals(icon)) {
			return "";
		}
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	@Override
	public String toString() {
		return "BuildingTagDataSet [tagId=" + tagId + ", tagName=" + tagName
				+ ", icon=" + icon + "]";
	}

}
