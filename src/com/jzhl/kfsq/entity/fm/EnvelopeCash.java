package com.jzhl.kfsq.entity.fm;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * 红包、提现中间表实体类
 * 
 * @author Shaw
 *
 */
public class EnvelopeCash implements Serializable {

	private static final long serialVersionUID = 865351961900986920L;// 序列化
	
	private int envelopeCashId;// 中间表主键
	
	private int receiveId;// 领取编号
	
	private String applicationId;// 取现编号
	
	private BigDecimal price;// 取现金额
	
	private Timestamp createTime;// 创建时间
	
	private int isValid;// 是否有效（0：无效，1：有效）

	public int getEnvelopeCashId() {
		return envelopeCashId;
	}

	public void setEnvelopeCashId(int envelopeCashId) {
		this.envelopeCashId = envelopeCashId;
	}

	public int getReceiveId() {
		return receiveId;
	}

	public void setReceiveId(int receiveId) {
		this.receiveId = receiveId;
	}

	public String getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(String applicationId) {
		this.applicationId = applicationId;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public int getIsValid() {
		return isValid;
	}

	public void setIsValid(int isValid) {
		this.isValid = isValid;
	}

	@Override
	public String toString() {
		return "EnvelopeCash [envelopeCashId=" + envelopeCashId
				+ ", receiveId=" + receiveId + ", applicationId="
				+ applicationId + ", price=" + price + ", createTime="
				+ createTime + ", isValid=" + isValid + "]";
	}

}
