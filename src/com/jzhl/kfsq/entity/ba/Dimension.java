package com.jzhl.kfsq.entity.ba;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * 维度表实体类
 * 
 * @author Shaw
 *
 */
public class Dimension implements Serializable {

	private static final long serialVersionUID = 5623818713625300615L;// 序列化

	private Integer dimensionId;// 主键，维度编号

	private Integer dimensionType;// 维度类型，目前主要区分系统维度和用户维度

	private String dimensionName;// 维度名称

	private String dimensionCode;// 维度代码

	private Integer parentId;// 父维度ID，根为0

	private Integer weight;// 评分权重

	private Integer evaluateType;// 1 是否，是100，否0；2 区间判断类评分(需要数据字典) 3
									// 区间判断类评分(从原始数据统计) 4 区间数判断类评分（标签表） 5 维度值

	private Integer ddTypeId;// 字典类型ID，用于进行区间比较时根据此值查询区间的字典数据

	private BigDecimal beginValue;// 维度范围开始值

	private BigDecimal endValue;// 维度范围截止值

	private Integer score;// 分数，当符合当前维度条件时应该得到的分数

	private Integer cityId;// 字典信息所属城市

	private Timestamp createTime;// 创建时间

	private Timestamp updateTime;// 更新时间

	private Integer createUserId;// 创建者编号

	private Integer updateUserId;// 更新者编号

	private Integer isValid;// 0：无效，1：有效

	public Integer getDimensionId() {
		return dimensionId;
	}

	public void setDimensionId(Integer dimensionId) {
		this.dimensionId = dimensionId;
	}

	public Integer getDimensionType() {
		return dimensionType;
	}

	public void setDimensionType(Integer dimensionType) {
		this.dimensionType = dimensionType;
	}

	public String getDimensionName() {
		return dimensionName;
	}

	public void setDimensionName(String dimensionName) {
		this.dimensionName = dimensionName;
	}

	public String getDimensionCode() {
		return dimensionCode;
	}

	public void setDimensionCode(String dimensionCode) {
		this.dimensionCode = dimensionCode;
	}

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public Integer getWeight() {
		return weight;
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
	}

	public Integer getEvaluateType() {
		return evaluateType;
	}

	public void setEvaluateType(Integer evaluateType) {
		this.evaluateType = evaluateType;
	}

	public Integer getDdTypeId() {
		return ddTypeId;
	}

	public void setDdTypeId(Integer ddTypeId) {
		this.ddTypeId = ddTypeId;
	}

	public BigDecimal getBeginValue() {
		return beginValue;
	}

	public void setBeginValue(BigDecimal beginValue) {
		this.beginValue = beginValue;
	}

	public BigDecimal getEndValue() {
		return endValue;
	}

	public void setEndValue(BigDecimal endValue) {
		this.endValue = endValue;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public Integer getCityId() {
		return cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public Timestamp getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}

	public Integer getCreateUserId() {
		return createUserId;
	}

	public void setCreateUserId(Integer createUserId) {
		this.createUserId = createUserId;
	}

	public Integer getUpdateUserId() {
		return updateUserId;
	}

	public void setUpdateUserId(Integer updateUserId) {
		this.updateUserId = updateUserId;
	}

	public Integer getIsValid() {
		return isValid;
	}

	public void setIsValid(Integer isValid) {
		this.isValid = isValid;
	}

}
