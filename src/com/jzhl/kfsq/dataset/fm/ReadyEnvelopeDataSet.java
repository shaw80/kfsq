package com.jzhl.kfsq.dataset.fm;

/**
 * 现金红包收入结果集
 * 
 * @author Shaw
 *
 */
public class ReadyEnvelopeDataSet {
	
	private String price;// 红包金额
	
	private String source;// 红包来源
	
	private String type;// 红包类型（0：看房红包，1：评论红包）

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

}
