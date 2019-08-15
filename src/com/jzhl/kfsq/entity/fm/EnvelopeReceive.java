package com.jzhl.kfsq.entity.fm;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;

/**
 * 红包领取实体类
 * 
 * @author Shaw
 *
 */
public class EnvelopeReceive implements Serializable {

	private static final long serialVersionUID = 1274006094199342252L;// 序列化

	private Integer receiveId;// 领取编号，主键
	private Integer memberId;// 会员编号
	private Integer envelopeId;// 红包编号
	private Integer salerCustomerId;// 客户到访编号（客户到访表主键）
	private BigDecimal price;// 领取金额
	private Integer status;// 红包状态（0：待激活，1：已激活未领取，2：已领取）
	private Date createTime;// 创建时间
	private Date updateTime;// 更新时间
	private Integer isValid;// 0：无效，1：有效

	private java.lang.String account; // 账号
	private java.lang.String nickName; // 会员昵称
	private java.lang.String name; // 售楼员名称
	private Integer envelopeType;// 红包类型
	
	
	private Integer buildingId; // 楼盘ID

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

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
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

	public java.lang.String getAccount() {
		return account;
	}

	public void setAccount(java.lang.String account) {
		this.account = account;
	}

	public java.lang.String getNickName() {
		return nickName;
	}

	public void setNickName(java.lang.String nickName) {
		this.nickName = nickName;
	}

	public java.lang.String getName() {
		return name;
	}

	public void setName(java.lang.String name) {
		this.name = name;
	}
	
	public Integer getBuildingId() {
		return buildingId;
	}

	public void setBuildingId(Integer buildingId) {
		this.buildingId = buildingId;
	}

	public Integer getEnvelopeType() {
		return envelopeType;
	}

	public void setEnvelopeType(Integer envelopeType) {
		this.envelopeType = envelopeType;
	}

	public Integer getSalerCustomerId() {
		return salerCustomerId;
	}

	public void setSalerCustomerId(Integer salerCustomerId) {
		this.salerCustomerId = salerCustomerId;
	}

	@Override
	public String toString() {
		return "EnvelopeReceive [receiveId=" + receiveId + ", memberId="
				+ memberId + ", envelopeId=" + envelopeId
				+ ", salerCustomerId=" + salerCustomerId + ", price=" + price
				+ ", status=" + status + ", createTime=" + createTime
				+ ", updateTime=" + updateTime + ", isValid=" + isValid
				+ ", account=" + account + ", nickName=" + nickName + ", name="
				+ name + ", envelopeType=" + envelopeType + ", buildingId="
				+ buildingId + "]";
	}

}
