package com.jzhl.kfsq.dataset.bm;

import java.io.Serializable;
import java.util.List;

public class UnitMapDataListSet implements Serializable{
	/**
	 * 查询楼盘信息列表返回的信息
	 */
	private static final long serialVersionUID = 1L;

	protected List<UnitMapDataSet> dataList = null;

	protected int dataCount = 0;

	protected int pageRowCnt = 0;

	public List<UnitMapDataSet> getDataList() {
		return dataList;
	}

	public void setDataList(List<UnitMapDataSet> dataList) {
		this.dataList = dataList;
	}

	public int getDataCount() {
		return dataCount;
	}

	public void setDataCount(int dataCount) {
		this.dataCount = dataCount;
	}

	public int getPageRowCnt() {
		return pageRowCnt;
	}

	public void setPageRowCnt(int pageRowCnt) {
		this.pageRowCnt = pageRowCnt;
	}
	
	
}
