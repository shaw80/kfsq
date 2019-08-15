package com.jzhl.kfsq.entity.sm;

import java.io.Serializable;

/**
 * 
 * SM_EnvelopeRule表
 * 
 * @author zhouzy
 *
 */
public class EnvelopeRule implements Serializable {
	private static final long serialVersionUID = -2628240931155675839L;
	private java.lang.Integer ruleId; // 规则编号
	private java.lang.Integer buildingId; // 楼盘ID
	private java.math.BigDecimal scancodePrice; // 扫码金额
	private java.lang.Integer creatorUserId; // 创建者：记录用户的创建人员的名称。
	private java.util.Date createTime; // 数据创建时间
	private java.lang.Integer updateUserId; //
	private java.util.Date updateTime; // 数据更新时间
	private java.lang.Short isValid; // 0：无效，1：有效
	public java.lang.Integer getRuleId() {
		return ruleId;
	}
	public void setRuleId(java.lang.Integer ruleId) {
		this.ruleId = ruleId;
	}
	public java.lang.Integer getBuildingId() {
		return buildingId;
	}
	public void setBuildingId(java.lang.Integer buildingId) {
		this.buildingId = buildingId;
	}
	public java.math.BigDecimal getScancodePrice() {
		return scancodePrice;
	}
	public void setScancodePrice(java.math.BigDecimal scancodePrice) {
		this.scancodePrice = scancodePrice;
	}
	public java.lang.Integer getCreatorUserId() {
		return creatorUserId;
	}
	public void setCreatorUserId(java.lang.Integer creatorUserId) {
		this.creatorUserId = creatorUserId;
	}
	public java.util.Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(java.util.Date createTime) {
		this.createTime = createTime;
	}
	public java.lang.Integer getUpdateUserId() {
		return updateUserId;
	}
	public void setUpdateUserId(java.lang.Integer updateUserId) {
		this.updateUserId = updateUserId;
	}
	public java.util.Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(java.util.Date updateTime) {
		this.updateTime = updateTime;
	}
	public java.lang.Short getIsValid() {
		return isValid;
	}
	public void setIsValid(java.lang.Short isValid) {
		this.isValid = isValid;
	}


}