package com.jzhl.kfsq.dto.pm;

import java.io.Serializable;

/**
 * 设置想看时间DTO
 * 
 * @author Shaw
 *
 */
public class AppointmentTimeDto implements Serializable {

	private static final long serialVersionUID = -2175447342742438499L;// 序列化
	
	private String appointmentTime;// 计划时间，格式（YYYY-MM-dd）
	
	private Integer buildingId;// 楼盘编号
	
	private Integer memberId;// 会员编号

	public String getAppointmentTime() {
		return appointmentTime;
	}

	public void setAppointmentTime(String appointmentTime) {
		this.appointmentTime = appointmentTime;
	}

	public Integer getBuildingId() {
		return buildingId;
	}

	public void setBuildingId(Integer buildingId) {
		this.buildingId = buildingId;
	}

	public Integer getMemberId() {
		return memberId;
	}

	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}

	@Override
	public String toString() {
		return "AppointmentTimeDto [appointmentTime=" + appointmentTime
				+ ", buildingId=" + buildingId + ", memberId=" + memberId + "]";
	}

}
