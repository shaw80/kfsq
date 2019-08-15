package com.jzhl.kfsq.dto.sm;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.jzhl.kfsq.common.base.PageListCondition;

/**
 * 用户Dto
 * 
 * @author Shaw
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDto extends PageListCondition implements Serializable {

	private static final long serialVersionUID = -2795483893310794583L;// 序列化

	@JsonProperty(value = "userId")
	private Integer userId = null;// 用户编号
	private Integer userType = null;
	private String account = null;
	private String password = null;
	private Integer isValid = null;
	private Integer branchId;// 分站编号

	private java.lang.String name; // 用户名称
	private java.lang.String mobilePhone; // 电话
	private java.lang.Integer roleId; // 角色编号
	private java.lang.Integer leaderUserId; // 上级领导编号
	private java.lang.String roleName; // 角色名称
	private java.lang.String keyword; // 关键字
	private java.lang.Short roleStatus; // 角色状态 '0：无效、1：有效'
	private java.lang.Integer buildingId; // 楼盘编号
	private java.lang.Integer appUserType; // 0.营销总监 1.销售经理 2.置业顾问
	private java.lang.Integer loginUserId; // 登录人userID
	private java.lang.String roleCode; // 角色编码
	private java.lang.String buildingName; // 楼盘名称

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getUserType() {
		return userType;
	}

	public void setUserType(Integer userType) {
		this.userType = userType;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getIsValid() {
		return isValid;
	}

	public void setIsValid(Integer isValid) {
		this.isValid = isValid;
	}

	public java.lang.String getRoleName() {
		return roleName;
	}

	public void setRoleName(java.lang.String roleName) {
		this.roleName = roleName;
	}

	public java.lang.String getKeyword() {
		return keyword;
	}

	public void setKeyword(java.lang.String keyword) {
		this.keyword = keyword;
	}

	public java.lang.Short getRoleStatus() {
		return roleStatus;
	}

	public void setRoleStatus(java.lang.Short roleStatus) {
		this.roleStatus = roleStatus;
	}

	public java.lang.String getName() {
		return name;
	}

	public void setName(java.lang.String name) {
		this.name = name;
	}

	public java.lang.Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(java.lang.Integer roleId) {
		this.roleId = roleId;
	}

	public java.lang.Integer getLeaderUserId() {
		return leaderUserId;
	}

	public void setLeaderUserId(java.lang.Integer leaderUserId) {
		this.leaderUserId = leaderUserId;
	}

	public java.lang.String getMobilePhone() {
		return mobilePhone;
	}

	public void setMobilePhone(java.lang.String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	public java.lang.Integer getBuildingId() {
		return buildingId;
	}

	public void setBuildingId(java.lang.Integer buildingId) {
		this.buildingId = buildingId;
	}

	public java.lang.Integer getAppUserType() {
		return appUserType;
	}

	public void setAppUserType(java.lang.Integer appUserType) {
		this.appUserType = appUserType;
	}

	public java.lang.Integer getLoginUserId() {
		return loginUserId;
	}

	public void setLoginUserId(java.lang.Integer loginUserId) {
		this.loginUserId = loginUserId;
	}

	public Integer getBranchId() {
		return branchId;
	}

	public void setBranchId(Integer branchId) {
		this.branchId = branchId;
	}

	public java.lang.String getRoleCode() {
		return roleCode;
	}

	public void setRoleCode(java.lang.String roleCode) {
		this.roleCode = roleCode;
	}

	public java.lang.String getBuildingName() {
		return buildingName;
	}

	public void setBuildingName(java.lang.String buildingName) {
		this.buildingName = buildingName;
	}

	@Override
	public String toString() {
		return "UserDto [userId=" + userId + ", userType=" + userType + ", account=" + account + ", password=" + password + ", isValid="
				+ isValid + ", branchId=" + branchId + ", name=" + name + ", mobilePhone=" + mobilePhone + ", roleId=" + roleId
				+ ", leaderUserId=" + leaderUserId + ", roleName=" + roleName + ", keyword=" + keyword + ", roleStatus=" + roleStatus
				+ ", buildingId=" + buildingId + ", appUserType=" + appUserType + ", loginUserId=" + loginUserId + ", roleCode=" + roleCode
				+ ", buildingName=" + buildingName + "]";
	}

}
