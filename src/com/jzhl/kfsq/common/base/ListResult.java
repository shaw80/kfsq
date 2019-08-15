package com.jzhl.kfsq.common.base;

import java.util.List;

public class ListResult {

	protected List<?> dataList = null;

	protected int dataCount = 0;
	
	public List<?> getDataList() {
		return dataList;
	}

	public void setDataList(List<?> dataList) {
		this.dataList = dataList;
	}

	public int getDataCount() {
		return dataCount;
	}

	public void setDataCount(int dataCount) {
		this.dataCount = dataCount;
	}

	@Override
	public String toString() {
		return "ListResult [dataList=" + dataList + ", dataCount=" + dataCount
				+ "]";
	}

}
