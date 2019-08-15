package com.jzhl.kfsq.entity.fm;

import java.io.Serializable;

/**
 * 
 * FM_CommentEnvelopeChance表
 * 
 * @author zhouzy
 *
 */
public class CommentEnvelopeChance implements Serializable {
	private static final long serialVersionUID = -8990903714138619508L;
	private java.lang.Integer chanceId; // 概率编号，主键
	private java.lang.Integer branchId; // 分站Id
	private java.sql.Timestamp beginTime; // 开始时间
	private java.sql.Timestamp endTime; // 结束时间
	private java.math.BigDecimal price; // 奖励金额
	private java.lang.Integer chance; // 概率，百分比
	private java.lang.Integer createUserId; // 创建人编号
	private java.sql.Timestamp createTime; // 创建时间
	private java.lang.Integer updateUserId; // 更新人编号
	private java.sql.Timestamp updateTime; // 更新时间
	private java.lang.Short isValid; // 是否有效（0：无效，1：默认有效）

	/**
	 * 获取概率编号，主键属性
	 *
	 * @return chanceId
	 */
	public java.lang.Integer getchanceId() {
		return chanceId;
	}

	/**
	 * 设置概率编号，主键属性
	 *
	 * @param chanceId
	 */
	public void setchanceId(java.lang.Integer chanceId) {
		this.chanceId = chanceId;
	}

	public java.lang.Integer getBranchId() {
		return branchId;
	}

	public void setBranchId(java.lang.Integer branchId) {
		this.branchId = branchId;
	}

	/**
	 * 获取开始时间属性
	 *
	 * @return beginTime
	 */
	public java.sql.Timestamp getbeginTime() {
		return beginTime;
	}

	/**
	 * 设置开始时间属性
	 *
	 * @param beginTime
	 */
	public void setbeginTime(java.sql.Timestamp beginTime) {
		this.beginTime = beginTime;
	}

	/**
	 * 获取结束时间属性
	 *
	 * @return endTime
	 */
	public java.sql.Timestamp getendTime() {
		return endTime;
	}

	/**
	 * 设置结束时间属性
	 *
	 * @param endTime
	 */
	public void setendTime(java.sql.Timestamp endTime) {
		this.endTime = endTime;
	}

	/**
	 * 获取奖励金额属性
	 *
	 * @return price
	 */
	public java.math.BigDecimal getPrice() {
		return price;
	}

	/**
	 * 设置奖励金额属性
	 *
	 * @param price
	 */
	public void setPrice(java.math.BigDecimal price) {
		this.price = price;
	}

	/**
	 * 获取概率，百分比属性
	 *
	 * @return chance
	 */
	public java.lang.Integer getChance() {
		return chance;
	}

	/**
	 * 设置概率，百分比属性
	 *
	 * @param chance
	 */
	public void setChance(java.lang.Integer chance) {
		this.chance = chance;
	}

	/**
	 * 获取创建人编号属性
	 *
	 * @return createUserId
	 */
	public java.lang.Integer getcreateUserId() {
		return createUserId;
	}

	/**
	 * 设置创建人编号属性
	 *
	 * @param createUserId
	 */
	public void setcreateUserId(java.lang.Integer createUserId) {
		this.createUserId = createUserId;
	}

	/**
	 * 获取创建时间属性
	 *
	 * @return createTime
	 */
	public java.sql.Timestamp getcreateTime() {
		return createTime;
	}

	/**
	 * 设置创建时间属性
	 *
	 * @param createTime
	 */
	public void setcreateTime(java.sql.Timestamp createTime) {
		this.createTime = createTime;
	}

	/**
	 * 获取更新人编号属性
	 *
	 * @return updateUserId
	 */
	public java.lang.Integer getupdateUserId() {
		return updateUserId;
	}

	/**
	 * 设置更新人编号属性
	 *
	 * @param updateUserId
	 */
	public void setupdateUserId(java.lang.Integer updateUserId) {
		this.updateUserId = updateUserId;
	}

	/**
	 * 获取更新时间属性
	 *
	 * @return updateTime
	 */
	public java.sql.Timestamp getupdateTime() {
		return updateTime;
	}

	/**
	 * 设置更新时间属性
	 *
	 * @param updateTime
	 */
	public void setupdateTime(java.sql.Timestamp updateTime) {
		this.updateTime = updateTime;
	}

	/**
	 * 获取是否有效（0：无效，1：默认有效）属性
	 *
	 * @return isValid
	 */
	public java.lang.Short getisValid() {
		return isValid;
	}

	/**
	 * 设置是否有效（0：无效，1：默认有效）属性
	 *
	 * @param isValid
	 */
	public void setisValid(java.lang.Short isValid) {
		this.isValid = isValid;
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append("CommentEnvelopeChance");
		sb.append("{chanceId=").append(chanceId);
		sb.append(", branchId=").append(branchId);
		sb.append(", beginTime=").append(beginTime);
		sb.append(", endTime=").append(endTime);
		sb.append(", price=").append(price);
		sb.append(", chance=").append(chance);
		sb.append(", createUserId=").append(createUserId);
		sb.append(", createTime=").append(createTime);
		sb.append(", updateUserId=").append(updateUserId);
		sb.append(", updateTime=").append(updateTime);
		sb.append(", isValid=").append(isValid);
		sb.append('}');
		return sb.toString();
	}
}