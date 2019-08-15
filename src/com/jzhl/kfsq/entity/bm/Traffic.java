package com.jzhl.kfsq.entity.bm;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 交通实体类
 * 
 * @author Shaw
 *
 */
public class Traffic implements Serializable {

	private static final long serialVersionUID = -4301132946220514935L;
	
	private Integer trafficId;// 交通编号
	
	private Integer buildingId;// 楼盘编号
	
	private Integer type;// 交通工具类型（0：公交，1：地铁，2：轻轨）
	
	private String lineName;// 线路名称
	
	private String distance;// 距离，单位米
	
	private Timestamp createTime;// 创建时间
	
	private Timestamp updateTime;// 更新时间
	
	private Integer createUserId;// 创建者编号
	
	private Integer updateUserId;// 更新者编号
	
	private Integer isValid;// 0：无效，1：有效

	public Integer getTrafficId() {
		return trafficId;
	}

	public void setTrafficId(Integer trafficId) {
		this.trafficId = trafficId;
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

	public String getLineName() {
		return lineName;
	}

	public void setLineName(String lineName) {
		this.lineName = lineName;
	}

	public String getDistance() {
		return distance;
	}

	public void setDistance(String distance) {
		this.distance = distance;
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
		return "Traffic [trafficId=" + trafficId + ", buildingId=" + buildingId
				+ ", type=" + type + ", lineName=" + lineName + ", distance="
				+ distance + ", createTime=" + createTime + ", updateTime="
				+ updateTime + ", createUserId=" + createUserId
				+ ", updateUserId=" + updateUserId + ", isValid=" + isValid
				+ "]";
	}

}
