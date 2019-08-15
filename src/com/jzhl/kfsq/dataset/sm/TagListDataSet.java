package com.jzhl.kfsq.dataset.sm;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * SM_Tag表
 * 
 * @author zhouzy
 *
 */
public class TagListDataSet implements Serializable {

	private static final long serialVersionUID = 1116277815755620151L;

	private List<TagDataSet> dataList = new ArrayList<TagDataSet>();

	public List<TagDataSet> getDataList() {
		return dataList;
	}

	public void setDataList(List<TagDataSet> dataList) {
		this.dataList = dataList;
	}

}