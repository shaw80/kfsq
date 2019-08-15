package com.jzhl.kfsq.dataset.fm;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;

/**
 * 支付宝回调函数红包领取结果集
 * 
 * @author Shaw
 *
 */
public class EnvelopeReceiveWebDataSet implements Serializable {

	private static final long serialVersionUID = -1225066730889001352L;// 序列化
	
	private Integer receiveId;// 领取编号，主键
	private Integer memberId;// 会员编号
	private Integer envelopeId;// 红包编号
	private BigDecimal price;// 领取金额
	private Integer receiveStatus;// 红包状态（0：待激活，1：已激活未领取，2：已领取）
	private Date createTime;// 创建时间
	private Date updateTime;// 更新时间
	private Integer isValid;// 0：无效，1：有效
	
	public Integer getReceiveId() {
		return receiveId;
	}
	public void setReceiveId(Integer receiveId) {
		this.receiveId = receiveId;
	}
	public Integer getMemberId() {
		return memberId;
	}
	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}
	public Integer getEnvelopeId() {
		return envelopeId;
	}
	public void setEnvelopeId(Integer envelopeId) {
		this.envelopeId = envelopeId;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public Integer getReceiveStatus() {
		return receiveStatus;
	}
	public void setReceiveStatus(Integer receiveStatus) {
		this.receiveStatus = receiveStatus;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public Integer getIsValid() {
		return isValid;
	}
	public void setIsValid(Integer isValid) {
		this.isValid = isValid;
	}
	@Override
	public String toString() {
		return "EnvelopeReceiveWebDataSet [receiveId=" + receiveId
				+ ", memberId=" + memberId + ", envelopeId=" + envelopeId
				+ ", price=" + price + ", receiveStatus=" + receiveStatus
				+ ", createTime=" + createTime + ", updateTime=" + updateTime
				+ ", isValid=" + isValid + "]";
	}

}
