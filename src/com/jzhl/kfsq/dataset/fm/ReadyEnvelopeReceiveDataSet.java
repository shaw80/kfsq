package com.jzhl.kfsq.dataset.fm;

/**
 * 现金红包收入查询结果集
 * 
 * @author Shaw
 *
 */
public class ReadyEnvelopeReceiveDataSet {
	
	private Integer price;// 红包金额
	
	private String buildingName;// 楼盘名称
	
	private String Type;// 红包类型

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public String getBuildingName() {
		return buildingName;
	}

	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}

	public String getType() {
		return Type;
	}

	public void setType(String type) {
		Type = type;
	}
	
}
