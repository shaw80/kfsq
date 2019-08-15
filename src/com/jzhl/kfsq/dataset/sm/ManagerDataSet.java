package com.jzhl.kfsq.dataset.sm;

import java.io.Serializable;

/**
 * 销售经理结果集
 * 
 * @author Shaw
 *
 */
public class ManagerDataSet implements Serializable {

	private static final long serialVersionUID = 1268341187502188705L;// 序列化
	
	private Integer userId;// 用户编号
	
	private String name;// 用户名称
	
	private String position;// 职位
	
	private String headPortrait;//头像
	
	private String buildingName;// 楼盘名称
	
	private String superiorName; // 所属主管，置业顾问使用

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

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getHeadPortrait() {
		return headPortrait;
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
		return "ManagerDataSet [userId=" + userId + ", name=" + name
				+ ", position=" + position + ", headPortrait=" + headPortrait
				+ ", buildingName=" + buildingName + ", superiorName="
				+ superiorName + "]";
	}

}
