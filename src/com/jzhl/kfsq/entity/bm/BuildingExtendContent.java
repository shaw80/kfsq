package com.jzhl.kfsq.entity.bm;

import java.io.Serializable;

/**
 * 
 * BM_BuildingExtendContent表
 * 
 * @author zhouzy
 *
 */
public class BuildingExtendContent implements Serializable {
	private static final long serialVersionUID = -7014926095157568476L;
	private java.lang.Integer contentId; // 主键，内容编号
	private java.lang.Integer buildingId; // 外键，楼盘编号
	private java.lang.String traffic; // 交通内容
	private java.lang.String education; // 教育内容
	private java.lang.String arround; // 周边内容
	private java.lang.String discount; // 销售折扣内容
	private java.lang.Integer creatorUserId; // 创建人
	private java.lang.Integer updateUserId; // 更新人
	private java.util.Date createTime; // 创建时间
	private java.util.Date updateTime; // 更新时间
	private java.lang.Integer isValid; // 0：无效，1：有效

	public java.lang.Integer getContentId() {
		return contentId;
	}

	public void setContentId(java.lang.Integer contentId) {
		this.contentId = contentId;
	}

	public java.lang.Integer getBuildingId() {
		return buildingId;
	}

	public void setBuildingId(java.lang.Integer buildingId) {
		this.buildingId = buildingId;
	}

	public java.lang.String getTraffic() {
		return traffic;
	}

	public void setTraffic(java.lang.String traffic) {
		this.traffic = traffic;
	}

	public java.lang.String getEducation() {
		return education;
	}

	public void setEducation(java.lang.String education) {
		this.education = education;
	}

	public java.lang.String getArround() {
		return arround;
	}

	public void setArround(java.lang.String arround) {
		this.arround = arround;
	}

	public java.lang.String getDiscount() {
		return discount;
	}

	public void setDiscount(java.lang.String discount) {
		this.discount = discount;
	}

	public java.lang.Integer getCreatorUserId() {
		return creatorUserId;
	}

	public void setCreatorUserId(java.lang.Integer creatorUserId) {
		this.creatorUserId = creatorUserId;
	}

	public java.lang.Integer getUpdateUserId() {
		return updateUserId;
	}

	public void setUpdateUserId(java.lang.Integer updateUserId) {
		this.updateUserId = updateUserId;
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

	public java.lang.Integer getIsValid() {
		return isValid;
	}

	public void setIsValid(java.lang.Integer isValid) {
		this.isValid = isValid;
	}

}