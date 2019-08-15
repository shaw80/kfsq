package com.jzhl.kfsq.dataset.fm;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 可生成红包金额结果集
 * 
 * @author Shaw
 *
 */
public class Amount implements Serializable {

	private static final long serialVersionUID = 249909422099606569L;// 序列化

	private BigDecimal price;// 可生成红包金额

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Amount [price=" + price + "]";
	}

}
