package com.jzhl.kfsq.entity.fm;

import java.io.Serializable;

/**
 * 
 * FM_EnvelopeRecharge表
 * 
 * @author zhouzy
 *
 */
public class EnvelopeRecharge implements Serializable {

	private static final long serialVersionUID = 7953697354170603769L;
	private java.lang.Integer envelopeId; // 红包编号
	private java.lang.Integer ruleId; // 规则编号
	private java.lang.String investor; // 红包来源类型（0：平台出资，1：开发商出资）
	private java.lang.Integer developerId; // 发放红包的开发商
	private java.lang.Integer branchId; // 分站编号
	private java.lang.Integer buildingId; // 楼盘编号
	private java.lang.Short type; // 红包类型（0：看房红包，1：评论红包）
	private java.math.BigDecimal totalSum; // 总金额
	private java.lang.Integer creatorUserId; // 创建者：记录用户的创建人员的名称。
	private java.util.Date createTime; // 数据创建时间
	private java.lang.Integer updateUserId; //
	private java.util.Date updateTime; // 数据更新时间
	private java.lang.Short isValid; // 0：无效，1：有效

	private java.lang.String buildingName; // 楼盘名称
	private java.lang.String saleLeaderName; // 楼盘联系人（销售总监）名称
	private java.lang.String saleLeaderPhone; // 楼盘联系人电话
	private java.lang.String proName; // 操作人名称

	public java.lang.Integer getEnvelopeId() {
		return envelopeId;
	}

	public void setEnvelopeId(java.lang.Integer envelopeId) {
		this.envelopeId = envelopeId;
	}

	public java.lang.Integer getRuleId() {
		return ruleId;
	}

	public void setRuleId(java.lang.Integer ruleId) {
		this.ruleId = ruleId;
	}

	public java.lang.String getInvestor() {
		return investor;
	}

	public void setInvestor(java.lang.String investor) {
		this.investor = investor;
	}

	public java.lang.Integer getDeveloperId() {
		return developerId;
	}

	public void setDeveloperId(java.lang.Integer developerId) {
		this.developerId = developerId;
	}

	public java.lang.Integer getBranchId() {
		return branchId;
	}

	public void setBranchId(java.lang.Integer branchId) {
		this.branchId = branchId;
	}

	public java.lang.Integer getBuildingId() {
		return buildingId;
	}

	public void setBuildingId(java.lang.Integer buildingId) {
		this.buildingId = buildingId;
	}

	public java.lang.Short getType() {
		return type;
	}

	public void setType(java.lang.Short type) {
		this.type = type;
	}

	public java.math.BigDecimal getTotalSum() {
		return totalSum;
	}

	public void setTotalSum(java.math.BigDecimal totalSum) {
		this.totalSum = totalSum;
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

	public java.lang.String getBuildingName() {
		return buildingName;
	}

	public void setBuildingName(java.lang.String buildingName) {
		this.buildingName = buildingName;
	}

	public java.lang.String getSaleLeaderName() {
		return saleLeaderName;
	}

	public void setSaleLeaderName(java.lang.String saleLeaderName) {
		this.saleLeaderName = saleLeaderName;
	}

	public java.lang.String getSaleLeaderPhone() {
		return saleLeaderPhone;
	}

	public void setSaleLeaderPhone(java.lang.String saleLeaderPhone) {
		this.saleLeaderPhone = saleLeaderPhone;
	}

	public java.lang.String getProName() {
		return proName;
	}

	public void setProName(java.lang.String proName) {
		this.proName = proName;
	}

	@Override
	public String toString() {
		return "EnvelopeRecharge [envelopeId=" + envelopeId + ", ruleId=" + ruleId + ", investor=" + investor + ", developerId="
				+ developerId + ", branchId=" + branchId + ", buildingId=" + buildingId + ", type=" + type + ", totalSum=" + totalSum
				+ ", creatorUserId=" + creatorUserId + ", createTime=" + createTime + ", updateUserId=" + updateUserId + ", updateTime="
				+ updateTime + ", isValid=" + isValid + ", buildingName=" + buildingName + ", saleLeaderName=" + saleLeaderName
				+ ", saleLeaderPhone=" + saleLeaderPhone + ", proName=" + proName + "]";
	}

}