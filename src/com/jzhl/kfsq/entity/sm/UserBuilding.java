package com.jzhl.kfsq.entity.sm;

import java.io.Serializable;

/**
 * 
 * SM_UserBuilding表
 * 
 * @author zhouzy
 *
 */
public class UserBuilding implements Serializable {

	private static final long serialVersionUID = 6479918846721415600L;
	private java.lang.Integer userBuildingId; // 用户编号
	private java.lang.Integer userId; // 用户编号
	private java.lang.Integer buildingId; // 楼盘编号
	private java.lang.Short isValid; // 0：无效，1：有效
	private java.lang.Integer creatorUserId; // 创建者：记录用户的创建人员的名称。
	private java.util.Date createTime; // 数据创建时间
	private java.lang.Integer updateUserId; // 更新者
	private java.util.Date updateTime; // 更新时间
	private java.lang.Short status; // 用户状态（0：禁用，1：默认开通）

	/**
	 * 获取用户编号属性
	 *
	 * @return userBuildingId
	 */
	public java.lang.Integer getUserbuildingid() {
		return userBuildingId;
	}

	/**
	 * 设置用户编号属性
	 *
	 * @param userBuildingId
	 */
	public void setUserbuildingid(java.lang.Integer userBuildingId) {
		this.userBuildingId = userBuildingId;
	}

	/**
	 * 获取用户编号属性
	 *
	 * @return userId
	 */
	public java.lang.Integer getUserid() {
		return userId;
	}

	/**
	 * 设置用户编号属性
	 *
	 * @param userId
	 */
	public void setUserid(java.lang.Integer userId) {
		this.userId = userId;
	}

	/**
	 * 获取楼盘编号属性
	 *
	 * @return buildingId
	 */
	public java.lang.Integer getBuildingid() {
		return buildingId;
	}

	/**
	 * 设置楼盘编号属性
	 *
	 * @param buildingId
	 */
	public void setBuildingid(java.lang.Integer buildingId) {
		this.buildingId = buildingId;
	}

	/**
	 * 获取0：无效，1：有效属性
	 *
	 * @return isValid
	 */
	public java.lang.Short getIsvalid() {
		return isValid;
	}

	/**
	 * 设置0：无效，1：有效属性
	 *
	 * @param isValid
	 */
	public void setIsvalid(java.lang.Short isValid) {
		this.isValid = isValid;
	}

	/**
	 * 获取创建者：记录用户的创建人员的名称。属性
	 *
	 * @return creatorUserId
	 */
	public java.lang.Integer getCreatoruserid() {
		return creatorUserId;
	}

	/**
	 * 设置创建者：记录用户的创建人员的名称。属性
	 *
	 * @param creatorUserId
	 */
	public void setCreatoruserid(java.lang.Integer creatorUserId) {
		this.creatorUserId = creatorUserId;
	}

	/**
	 * 获取数据创建时间属性
	 *
	 * @return createTime
	 */
	public java.util.Date getCreatetime() {
		return createTime;
	}

	/**
	 * 设置数据创建时间属性
	 *
	 * @param createTime
	 */
	public void setCreatetime(java.util.Date createTime) {
		this.createTime = createTime;
	}

	/**
	 * 获取更新者属性
	 *
	 * @return updateUserId
	 */
	public java.lang.Integer getUpdateuserid() {
		return updateUserId;
	}

	/**
	 * 设置更新者属性
	 *
	 * @param updateUserId
	 */
	public void setUpdateuserid(java.lang.Integer updateUserId) {
		this.updateUserId = updateUserId;
	}

	/**
	 * 获取更新时间属性
	 *
	 * @return updateTime
	 */
	public java.util.Date getUpdatetime() {
		return updateTime;
	}

	/**
	 * 设置更新时间属性
	 *
	 * @param updateTime
	 */
	public void setUpdatetime(java.util.Date updateTime) {
		this.updateTime = updateTime;
	}

	/**
	 * 获取用户状态（0：禁用，1：默认开通）属性
	 *
	 * @return status
	 */
	public java.lang.Short getStatus() {
		return status;
	}

	/**
	 * 设置用户状态（0：禁用，1：默认开通）属性
	 *
	 * @param status
	 */
	public void setStatus(java.lang.Short status) {
		this.status = status;
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append("SmUserbuilding");
		sb.append("{userBuildingId=").append(userBuildingId);
		sb.append(", userId=").append(userId);
		sb.append(", buildingId=").append(buildingId);
		sb.append(", isValid=").append(isValid);
		sb.append(", creatorUserId=").append(creatorUserId);
		sb.append(", createTime=").append(createTime);
		sb.append(", updateUserId=").append(updateUserId);
		sb.append(", updateTime=").append(updateTime);
		sb.append(", status=").append(status);
		sb.append('}');
		return sb.toString();
	}
}