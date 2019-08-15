package com.jzhl.kfsq.dataset.cm;

import java.io.Serializable;
import java.util.List;

public class AgentCommentListDataSet implements Serializable{
     
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	List<AgentCommentDataSet> dataList = null;
	protected int dataCount = 0;

	protected int pageRowCnt = 0;

	public List<AgentCommentDataSet> getDataList() {
		return dataList;
	}

	public void setDataList(List<AgentCommentDataSet> dataList) {
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
