package com.jzhl.kfsq.entity.bm;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 教育实体类
 * 
 * @author mac
 *
 */
public class Around implements Serializable {
	
	private static final long serialVersionUID = 3078813305220072670L;

	private Integer aroundId;// 周边编号
	
	private Integer buildingId;// 楼盘编号
	
	private Integer type;// 学校类型（0：幼儿园，1：小学，2：中学，3：大学）
	
	private String unitName;// 单位（机构）名称
	
	private String distance;// 距离，单位米
	
	private String longitude;// 经度
	
	private String latitude;// 纬度
	
	private Timestamp createTime;// 创建时间
	
	private Timestamp updateTime;// 更新时间
	
	private Integer createUserId;// 创建者编号
	
	private Integer updateUserId;// 更新者编号
	
	private Integer isValid;// 0：无效，1：有效

	public Integer getAroundId() {
		return aroundId;
	}

	public void setAroundId(Integer aroundId) {
		this.aroundId = aroundId;
	}

	public Integer getBuildingId() {
		return buildingId;
	}

	public void setBuildingId(Integer buildingId) {
		this.buildingId = buildingId;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getUnitName() {
		return unitName;
	}

	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}

	public String getDistance() {
		return distance;
	}

	public void setDistance(String distance) {
		this.distance = distance;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
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

	@Override
	public String toString() {
		return "Around [aroundId=" + aroundId + ", buildingId=" + buildingId
				+ ", type=" + type + ", unitName=" + unitName + ", distance="
				+ distance + ", longitude=" + longitude +", latitude=" + latitude
				+", createTime=" + createTime + ", updateTime=" + updateTime 
				+ ", createUserId=" + createUserId + ", updateUserId=" 
				+ updateUserId + ", isValid=" + isValid
				+ "]";
	}

}
