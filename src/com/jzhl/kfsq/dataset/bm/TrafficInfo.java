package com.jzhl.kfsq.dataset.bm;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 交通结果集
 * 
 * @author Shaw
 *
 */
public class TrafficInfo implements Serializable {

	private static final long serialVersionUID = -7436557918079375672L;// 序列化
	
	private String type;// 交通工具类型
	
	private List<TrafficDataSet> data = new ArrayList<TrafficDataSet>();// 交通线路集合

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<TrafficDataSet> getData() {
		return data;
	}

	public void setData(List<TrafficDataSet> data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "TrafficList [type=" + type + ", data=" + data + "]";
	}

}
