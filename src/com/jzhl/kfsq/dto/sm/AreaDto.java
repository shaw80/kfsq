package com.jzhl.kfsq.dto.sm;

import java.io.Serializable;

import com.jzhl.kfsq.common.base.PageListCondition;

/**
 * 区域查询DTO
 * 
 * @author Shaw
 *
 */
public class AreaDto extends PageListCondition implements Serializable {

	private static final long serialVersionUID = -7202951091581436104L;// 序列化

	private java.lang.Integer areaId; // 区域Id
	private String cityName;// 城市名称
	private java.lang.Integer creatorUserId; // 登录人

	public java.lang.Integer getAreaId() {
		return areaId;
	}

	public void setAreaId(java.lang.Integer areaId) {
		this.areaId = areaId;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public java.lang.Integer getCreatorUserId() {
		return creatorUserId;
	}

	public void setCreatorUserId(java.lang.Integer creatorUserId) {
		this.creatorUserId = creatorUserId;
	}

}
