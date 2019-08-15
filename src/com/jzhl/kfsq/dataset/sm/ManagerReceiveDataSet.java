package com.jzhl.kfsq.dataset.sm;

import java.io.Serializable;

import com.jzhl.kfsq.common.util.SystemConfig;

/**
 * 销售经理接收结果集
 * 
 * @author Shaw
 *
 */
public class ManagerReceiveDataSet implements Serializable {
	
	private static final long serialVersionUID = -6274982623243338353L;

	private Integer userId;// 用户编号
	
	private String name;// 用户名称
	
	private Integer appUserType;// 职位
	
	private String headPortrait;//头像
	
	private String buildingName;// 楼盘名称
	
	private String superiorName;// 上级名称

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAppUserType() {
		return appUserType;
	}

	public void setAppUserType(Integer appUserType) {
		this.appUserType = appUserType;
	}

	public String getHeadPortrait() {
		if(headPortrait == null || headPortrait.isEmpty()) {
			return "";
		}
		return SystemConfig.getHttpBasePath() + headPortrait;
	}

	public void setHeadPortrait(String headPortrait) {
		this.headPortrait = headPortrait;
	}

	public String getBuildingName() {
		return buildingName;
	}

	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}
	
	public String getSuperiorName() {
		return superiorName;
	}

	public void setSuperiorName(String superiorName) {
		this.superiorName = superiorName;
	}

	@Override
	public String toString() {
		return "ManagerReceiveDataSet [userId=" + userId + ", name=" + name
				+ ", appUserType=" + appUserType + ", headPortrait="
				+ headPortrait + ", buildingName=" + buildingName
				+ ", superiorName=" + superiorName + "]";
	}

}
