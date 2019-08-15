package com.jzhl.kfsq.dataset.pm;

import java.io.Serializable;

import com.jzhl.kfsq.common.base.ListResult;

/**
 * 团队成员客户到访
 * 
 * @author Shaw
 *
 */
public class UserCustomerDataSet implements Serializable {

	private static final long serialVersionUID = 6095249520377469933L;// 序列化
	
	private String salerName;// 置业顾问名称
	
	private ListResult customers;// 客户到访数据

	public String getSalerName() {
		return salerName;
	}

	public void setSalerName(String salerName) {
		this.salerName = salerName;
	}

	public ListResult getCustomers() {
		return customers;
	}

	public void setCustomers(ListResult customers) {
		this.customers = customers;
	}

	@Override
	public String toString() {
		return "UserCustomerDataSet [salerName=" + salerName + ", customers="
				+ customers + "]";
	}

}
