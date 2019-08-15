package com.jzhl.kfsq.dataset.pm;

import java.io.Serializable;

import com.jzhl.kfsq.common.base.ListResult;

/**
 * 团队客户结果集
 * 
 * @author Shaw
 *
 */
public class TeamCustomerDataSet implements Serializable {

	private static final long serialVersionUID = 240710764536420484L;// 序列化
	
	private Integer count;// 总到访量
	
	private ListResult customers;// 客户数据

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public ListResult getCustomers() {
		return customers;
	}

	public void setCustomers(ListResult customers) {
		this.customers = customers;
	}

	@Override
	public String toString() {
		return "TeamCustomerDataSet [count=" + count + ", customers="
				+ customers + "]";
	}

}
