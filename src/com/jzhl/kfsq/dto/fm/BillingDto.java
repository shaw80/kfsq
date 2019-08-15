package com.jzhl.kfsq.dto.fm;

import java.io.Serializable;

import com.jzhl.kfsq.common.base.PageListCondition;

/**
 * 账单dto
 * 
 * @author Shaw
 *
 */
public class BillingDto extends PageListCondition implements Serializable {

	private static final long serialVersionUID = -2886904146606066325L;// 序列化

	private String serialNum;// 交易流水号

	private java.lang.String isDownFlag; // 是否为excel导出

	public String getSerialNum() {
		return serialNum;
	}

	public void setSerialNum(String serialNum) {
		this.serialNum = serialNum;
	}

	public java.lang.String getIsDownFlag() {
		return isDownFlag;
	}

	public void setIsDownFlag(java.lang.String isDownFlag) {
		this.isDownFlag = isDownFlag;
	}

	@Override
	public String toString() {
		return "BillingDto [serialNum=" + serialNum + ", isDownFlag=" + isDownFlag + "]";
	}

}
