package com.jzhl.kfsq.entity.sm;

import java.io.Serializable;

/**
 * 
 * SM_ProvinceCity表
 * 
 * @author zhouzy
 *
 */
public class ProvinceCity implements Serializable {
	private static final long serialVersionUID = 3545903942728711545L;
	private java.lang.Integer areaId; // 参数编号
	private java.lang.String areaName; // 区域名称
	private java.lang.Integer parentAreaId; //
	private java.lang.Integer creatorUserId; // 创建者：记录用户的创建人员的名称。
	private java.util.Date createTime; // 数据创建时间

	/**
	 * 获取参数编号属性
	 *
	 * @return areaId
	 */
	public java.lang.Integer getareaId() {
		return areaId;
	}

	/**
	 * 设置参数编号属性
	 *
	 * @param areaId
	 */
	public void setareaId(java.lang.Integer areaId) {
		this.areaId = areaId;
	}

	/**
	 * 获取区域名称属性
	 *
	 * @return areaName
	 */
	public java.lang.String getareaName() {
		return areaName;
	}

	/**
	 * 设置区域名称属性
	 *
	 * @param areaName
	 */
	public void setareaName(java.lang.String areaName) {
		this.areaName = areaName;
	}

	/**
	 * 获取属性
	 *
	 * @return parentAreaId
	 */
	public java.lang.Integer getparentAreaId() {
		return parentAreaId;
	}

	/**
	 * 设置属性
	 *
	 * @param parentAreaId
	 */
	public void setparentAreaId(java.lang.Integer parentAreaId) {
		this.parentAreaId = parentAreaId;
	}

	/**
	 * 获取创建者：记录用户的创建人员的名称。属性
	 *
	 * @return creatorUserId
	 */
	public java.lang.Integer getcreatorUserId() {
		return creatorUserId;
	}

	/**
	 * 设置创建者：记录用户的创建人员的名称。属性
	 *
	 * @param creatorUserId
	 */
	public void setcreatorUserId(java.lang.Integer creatorUserId) {
		this.creatorUserId = creatorUserId;
	}

	/**
	 * 获取数据创建时间属性
	 *
	 * @return createTime
	 */
	public java.util.Date getcreateTime() {
		return createTime;
	}

	/**
	 * 设置数据创建时间属性
	 *
	 * @param createTime
	 */
	public void setcreateTime(java.util.Date createTime) {
		this.createTime = createTime;
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append("ProvinceCity");
		sb.append("{areaId=").append(areaId);
		sb.append(", areaName=").append(areaName);
		sb.append(", parentAreaId=").append(parentAreaId);
		sb.append(", creatorUserId=").append(creatorUserId);
		sb.append(", createTime=").append(createTime);
		sb.append('}');
		return sb.toString();
	}
}