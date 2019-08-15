package com.jzhl.kfsq.dataset.sm;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 查询角色详情结果集
 * 
 * @author Shaw
 *
 */
public class RightDetailDataSet implements Serializable {
	
	private static final long serialVersionUID = -2470665192915902097L;// 序列化

	private Integer roleId;// 角色编号
	
	private String roleName;// 角色名称
	
	private String roleCode;// 角色编码
	
	private String roleType;// 角色类型（0：系统自带，1：自定义）
	
	private List<RightDataSet> first = new ArrayList<RightDataSet>();// 第一级菜单
	
	private List<RightDataSet> second = new ArrayList<RightDataSet>();// 第二级菜单

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleCode() {
		return roleCode;
	}

	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}

	public List<RightDataSet> getFirst() {
		return first;
	}

	public void setFirst(List<RightDataSet> first) {
		this.first = first;
	}

	public List<RightDataSet> getSecond() {
		return second;
	}

	public void setSecond(List<RightDataSet> second) {
		this.second = second;
	}

	public String getRoleType() {
		return roleType;
	}

	public void setRoleType(String roleType) {
		this.roleType = roleType;
	}

	@Override
	public String toString() {
		return "RightDetailDataSet [roleId=" + roleId + ", roleName="
				+ roleName + ", roleCode=" + roleCode + ", roleType="
				+ roleType + ", first=" + first + ", second=" + second + "]";
	}

}
