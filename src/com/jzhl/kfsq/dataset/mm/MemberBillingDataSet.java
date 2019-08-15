package com.jzhl.kfsq.dataset.mm;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 账单详情页面会员信息结果集
 * 
 * @author Shaw
 *
 */
public class MemberBillingDataSet implements Serializable {

	private static final long serialVersionUID = -6375358332460036184L;// 序列化
	
	private String regTime;// 注册时间
	
	private String cityName;// 城市名称
	
	private String nickName;// 会员名称
	
	private String phone;// 联系电话
	
	private BigDecimal price;// 转账金额

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getRegTime() {
		return regTime;
	}

	public void setRegTime(String regTime) {
		this.regTime = regTime;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "MemberBillingDataSet [regTime=" + regTime + ", cityName="
				+ cityName + ", nickName=" + nickName + ", phone=" + phone
				+ ", price=" + price + "]";
	}

}
