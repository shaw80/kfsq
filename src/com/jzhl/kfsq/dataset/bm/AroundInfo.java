package com.jzhl.kfsq.dataset.bm;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 周边结果集
 * 
 * @author mac
 *
 */
public class AroundInfo implements Serializable {

	private static final long serialVersionUID = 2926190002085061972L;

	private String type;// 周边类型
	
	private List<AroundScoreDataSet> data = new ArrayList<AroundScoreDataSet>();// 周边集合

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<AroundScoreDataSet> getData() {
		return data;
	}

	public void setData(List<AroundScoreDataSet> data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "AroundList [type=" + type + ", data=" + data + "]";
	}

}
