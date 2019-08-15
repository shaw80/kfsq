package com.jzhl.kfsq.dto.sm;

import java.io.Serializable;

import com.jzhl.kfsq.common.base.PageListCondition;

/**
 * 
 * SM_RemindInfo表
 * 
 * @author zhouzy
 *
 */
public class RemindInfoDto extends PageListCondition implements Serializable {

	private static final long serialVersionUID = -1182994430907333261L;
	private java.lang.Integer remindId; // 主键
	private java.lang.Integer branchId; // 分站编号
	private java.lang.String content; // 提醒内容
	private java.lang.Integer creatorUserId; // 创建人编号
	private java.util.Date createTime; // 创建时间

	/**
	 * 获取主键属性
	 *
	 * @return remindId
	 */
	public java.lang.Integer getremindId() {
		return remindId;
	}

	/**
	 * 设置主键属性
	 *
	 * @param remindId
	 */
	public void setremindId(java.lang.Integer remindId) {
		this.remindId = remindId;
	}

	/**
	 * 获取分站编号属性
	 *
	 * @return branchId
	 */
	public java.lang.Integer getbranchId() {
		return branchId;
	}

	/**
	 * 设置分站编号属性
	 *
	 * @param branchId
	 */
	public void setbranchId(java.lang.Integer branchId) {
		this.branchId = branchId;
	}

	/**
	 * 获取提醒内容属性
	 *
	 * @return content
	 */
	public java.lang.String getcontent() {
		return content;
	}

	/**
	 * 设置提醒内容属性
	 *
	 * @param content
	 */
	public void setcontent(java.lang.String content) {
		this.content = content;
	}

	/**
	 * 获取创建人编号属性
	 *
	 * @return creatorUserId
	 */
	public java.lang.Integer getcreatorUserId() {
		return creatorUserId;
	}

	/**
	 * 设置创建人编号属性
	 *
	 * @param creatorUserId
	 */
	public void setcreatorUserId(java.lang.Integer creatorUserId) {
		this.creatorUserId = creatorUserId;
	}

	/**
	 * 获取创建时间属性
	 *
	 * @return createTime
	 */
	public java.util.Date getcreateTime() {
		return createTime;
	}

	/**
	 * 设置创建时间属性
	 *
	 * @param createTime
	 */
	public void setcreateTime(java.util.Date createTime) {
		this.createTime = createTime;
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append("RemindInfoDto");
		sb.append("{remindId=").append(remindId);
		sb.append(", branchId=").append(branchId);
		sb.append(", content=").append(content);
		sb.append(", creatorUserId=").append(creatorUserId);
		sb.append(", createTime=").append(createTime);
		sb.append('}');
		return sb.toString();
	}
}