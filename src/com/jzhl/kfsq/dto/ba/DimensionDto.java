package com.jzhl.kfsq.dto.ba;

import java.io.Serializable;

public class DimensionDto implements Serializable {
	
	private static final long serialVersionUID = -8323599850792035706L;
	private java.lang.Integer dimensionId; // 主键，维度编号
	private java.lang.Integer dimensionType; // 维度类型，目前主要区分系统维度和用户维度
	private java.lang.String dimensionName; // 维度名称
	private java.lang.String dimensionCode; // 维度代码
	private java.lang.Integer parentId; // 父维度ID，根为0
	private java.lang.Integer weight; // 评分权重
	private java.lang.Integer evaluateType; //  
	private java.lang.Integer ddTypeId; // 字典类型ID，用于进行区间比较时根据此值查询区间的字典数据 
	private java.math.BigDecimal beginValue; // 维度范围开始值
	private java.math.BigDecimal endValue; // 维度范围截止值
	private java.lang.Integer score; // 分数，当符合当前维度条件时应该得到的分数
	private java.lang.Integer cityId; // 字典信息所属城市
	private java.util.Date createTime; // 创建时间
	private java.util.Date updateTime; // 更新时间
	private java.lang.Integer createUserId; // 创建者编号
	private java.lang.Integer updateUserId; // 更新者编号
	private java.lang.Short isValid = 1; // 0：无效，1：有效
	
	public java.lang.Integer getDimensionId() {
		return dimensionId;
	}
	public void setDimensionId(java.lang.Integer dimensionId) {
		this.dimensionId = dimensionId;
	}
	public java.lang.Integer getDimensionType() {
		return dimensionType;
	}
	public void setDimensionType(java.lang.Integer dimensionType) {
		this.dimensionType = dimensionType;
	}
	public java.lang.String getDimensionName() {
		return dimensionName;
	}
	public void setDimensionName(java.lang.String dimensionName) {
		this.dimensionName = dimensionName;
	}
	public java.lang.String getDimensionCode() {
		return dimensionCode;
	}
	public void setDimensionCode(java.lang.String dimensionCode) {
		this.dimensionCode = dimensionCode;
	}
	public java.lang.Integer getParentId() {
		return parentId;
	}
	public void setParentId(java.lang.Integer parentId) {
		this.parentId = parentId;
	}
	public java.lang.Integer getWeight() {
		return weight;
	}
	public void setWeight(java.lang.Integer weight) {
		this.weight = weight;
	}
	public java.lang.Integer getEvaluateType() {
		return evaluateType;
	}
	public void setEvaluateType(java.lang.Integer evaluateType) {
		this.evaluateType = evaluateType;
	}
	public java.lang.Integer getDdTypeId() {
		return ddTypeId;
	}
	public void setDdTypeId(java.lang.Integer ddTypeId) {
		this.ddTypeId = ddTypeId;
	}
	public java.math.BigDecimal getBeginValue() {
		return beginValue;
	}
	public void setBeginValue(java.math.BigDecimal beginValue) {
		this.beginValue = beginValue;
	}
	public java.math.BigDecimal getEndValue() {
		return endValue;
	}
	public void setEndValue(java.math.BigDecimal endValue) {
		this.endValue = endValue;
	}
	public java.lang.Integer getScore() {
		return score;
	}
	public void setScore(java.lang.Integer score) {
		this.score = score;
	}
	public java.lang.Integer getCityId() {
		return cityId;
	}
	public void setCityId(java.lang.Integer cityId) {
		this.cityId = cityId;
	}
	public java.util.Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(java.util.Date createTime) {
		this.createTime = createTime;
	}
	public java.util.Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(java.util.Date updateTime) {
		this.updateTime = updateTime;
	}
	public java.lang.Integer getCreateUserId() {
		return createUserId;
	}
	public void setCreateUserId(java.lang.Integer createUserId) {
		this.createUserId = createUserId;
	}
	public java.lang.Integer getUpdateUserId() {
		return updateUserId;
	}
	public void setUpdateUserId(java.lang.Integer updateUserId) {
		this.updateUserId = updateUserId;
	}
	public java.lang.Short getIsValid() {
		return isValid;
	}
	public void setIsValid(java.lang.Short isValid) {
		this.isValid = isValid;
	}

}
