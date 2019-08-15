package com.jzhl.kfsq.dataset.bm;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 楼盘后台管理页面共用楼盘信息结果集
 * 
 * @author Shaw
 *
 */
public class BuildingInfo implements Serializable {

	private static final long serialVersionUID = -3235322872821206934L;// 序列化

	private String buildingName;// 楼盘名称

	private BigDecimal balance;// 楼盘余额

	public String getBuildingName() {
		return buildingName;
	}

	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "BuildingInfo [buildingName=" + buildingName + ", balance="
				+ balance + "]";
	}

}
