package com.jzhl.kfsq.dataset.pm;

import java.io.Serializable;
import java.math.BigDecimal;

import com.jzhl.kfsq.common.util.SystemConfig;

/**
 * 客户到访结果集
 * 
 * @author Shaw
 *
 */
public class CustomerDataSet implements Serializable {

	private static final long serialVersionUID = -3600056792253088163L;// 序列化
	
	private String headPortrait;// 头像
	
	private String memberName;// 客户名称
	
	private String visitTime;// 到访时间
	
	private String salerName;// 置业顾问名称
	
	private BigDecimal price;// 红包金额

	public String getHeadPortrait() {
		if(headPortrait == null || headPortrait.isEmpty()) {
			return "";
		}
		return SystemConfig.getHttpBasePath() + headPortrait;
	}

	public void setHeadPortrait(String headPortrait) {
		this.headPortrait = headPortrait;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getVisitTime() {
		return visitTime;
	}

	public void setVisitTime(String visitTime) {
		this.visitTime = visitTime;
	}

	public String getSalerName() {
		return salerName;
	}

	public void setSalerName(String salerName) {
		this.salerName = salerName;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "CustomerDataSet [headPortrait=" + headPortrait
				+ ", memberName=" + memberName + ", visitTime=" + visitTime
				+ ", salerName=" + salerName + ", price=" + price + "]";
	}

}
