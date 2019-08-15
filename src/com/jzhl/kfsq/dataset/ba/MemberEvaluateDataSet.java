package com.jzhl.kfsq.dataset.ba;

import java.io.Serializable;

import com.jzhl.kfsq.common.base.ListResult;

/**
 * 用户评分结果集
 * 
 * @author Shaw
 *
 */
public class MemberEvaluateDataSet implements Serializable {

	private static final long serialVersionUID = -777657021195526512L;// 序列化

	private Integer count;// 参与用户总数

	private ListResult listResult;// 用户评分集合

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public ListResult getListResult() {
		return listResult;
	}

	public void setListResult(ListResult listResult) {
		this.listResult = listResult;
	}

	@Override
	public String toString() {
		return "MemberEvaluateDataSet [count=" + count + ", listResult="
				+ listResult + "]";
	}

}
