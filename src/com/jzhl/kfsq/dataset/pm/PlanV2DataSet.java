package com.jzhl.kfsq.dataset.pm;

import java.io.Serializable;
import java.sql.Timestamp;

import com.jzhl.kfsq.common.util.SystemConfig;

/**
 * 想看和已看的共用结果集
 * 
 * @author Shaw
 *
 */
public class PlanV2DataSet implements Serializable {

	private static final long serialVersionUID = 7543975205809215782L;// 序列化

	private Integer buildingId;// 楼盘编号
	
	private String banner;// 楼盘大图

	private String buildingName;// 楼盘名称

	private Integer averagePrice;// 楼盘均价

	private String address;// 地址
	
	private String appointmentTime;// 预约看房时间，格式为 mm-dd
	
	private Timestamp createTime;// 创建时间

	private String planStatus;// 看房状态（0：默认未看房，1：已看房未评论，2：已看房已评论）

	public Integer getBuildingId() {
		return buildingId;
	}

	public void setBuildingId(Integer buildingId) {
		this.buildingId = buildingId;
	}

	public String getBanner() {
		if(banner == null || "".equals(banner)) {
			return "";
		}
		return SystemConfig.getHttpBasePath() + banner;
	}

	public void setBanner(String banner) {
		this.banner = banner;
	}

	public String getBuildingName() {
		return buildingName;
	}

	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}

	public Integer getAveragePrice() {
		return averagePrice;
	}

	public void setAveragePrice(Integer averagePrice) {
		this.averagePrice = averagePrice;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAppointmentTime() {
		return appointmentTime;
	}

	public void setAppointmentTime(String appointmentTime) {
		this.appointmentTime = appointmentTime;
	}

	public String getPlanStatus() {
		return planStatus;
	}

	public void setPlanStatus(String planStatus) {
		this.planStatus = planStatus;
	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	@Override
	public String toString() {
		return "PlanV2DataSet [buildingId=" + buildingId + ", banner=" + banner
				+ ", buildingName=" + buildingName + ", averagePrice="
				+ averagePrice + ", address=" + address + ", appointmentTime="
				+ appointmentTime + ", createTime=" + createTime
				+ ", planStatus=" + planStatus + "]";
	}
	
}
