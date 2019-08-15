package com.jzhl.kfsq.entity.sm;

import java.io.Serializable;
import java.sql.Date;

/**
 * 用户实体类
 * 
 * @author Shaw
 *
 */

public class User implements Serializable {

	private static final long serialVersionUID = -670560038317867095L;// 序列化

	private Integer userId;// 用户编号，主键
	private Integer branchId;// 分站编号
	private String account;// 用户登录ID：用户登录系统的标识，一般是英文字符或者数字
	private String password;// 用户密码：用户登录系统的验证密码
	private String name;// 名字
	private Integer userType;// 0.运营平台用户 1.B端用户
	private Integer appUserType; // 0.营销总监 1.销售经理 2.置业顾问
	private Integer roleId;// 角色编号
	private String mobilePhone;// 用户移动电话：用户移动电话号码
	private Integer isValid;// 0：无效，1：有效
	private Integer leaderUserId;// 上级领导编号
	private String headPortrait;// 头像
	private Integer creatorUserId;// 创建者：记录用户的创建人员的名称
	private Date createTime;// 创建时间
	private Integer updateUserId;// 更新人
	private Date updateTime;// 更新时间
	private String IDCardImg; // 身份证照片

	private java.lang.String roleName; // 角色名称
	private java.lang.Short roleStatus; // 角色状态
	private java.lang.Integer buildingId; // 楼盘编号
	private String buildingName;// 楼盘名称
	private String comanyName; // 公司名称
	private java.lang.Integer buildingNum; // 楼盘总数
	private java.lang.Integer userNum; // 管理员总数
	private java.lang.Integer memberNum; // 接待会员总数
	private java.lang.String leaderName; // 上级领导姓名
	private java.lang.Integer loginUserId; // 登录人userID
	private java.lang.String roleCode; // 角色编码

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getBranchId() {
		return branchId;
	}

	public void setBranchId(Integer branchId) {
		this.branchId = branchId;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getUserType() {
		return userType;
	}

	public void setUserType(Integer userType) {
		this.userType = userType;
	}

	public Integer getAppUserType() {
		return appUserType;
	}

	public void setAppUserType(Integer appUserType) {
		this.appUserType = appUserType;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public String getMobilePhone() {
		return mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	public Integer getIsValid() {
		return isValid;
	}

	public void setIsValid(Integer isValid) {
		this.isValid = isValid;
	}

	public Integer getLeaderUserId() {
		return leaderUserId;
	}

	public void setLeaderUserId(Integer leaderUserId) {
		this.leaderUserId = leaderUserId;
	}

	public String getHeadPortrait() {
		return headPortrait;
	}

	public void setHeadPortrait(String headPortrait) {
		this.headPortrait = headPortrait;
	}

	public Integer getCreatorUserId() {
		return creatorUserId;
	}

	public void setCreatorUserId(Integer creatorUserId) {
		this.creatorUserId = creatorUserId;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Integer getUpdateUserId() {
		return updateUserId;
	}

	public void setUpdateUserId(Integer updateUserId) {
		this.updateUserId = updateUserId;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getIDCardImg() {
		return IDCardImg;
	}

	public void setIDCardImg(String iDCardImg) {
		IDCardImg = iDCardImg;
	}

	public java.lang.String getRoleName() {
		return roleName;
	}

	public void setRoleName(java.lang.String roleName) {
		this.roleName = roleName;
	}

	public java.lang.Short getRoleStatus() {
		return roleStatus;
	}

	public void setRoleStatus(java.lang.Short roleStatus) {
		this.roleStatus = roleStatus;
	}

	public java.lang.Integer getBuildingId() {
		return buildingId;
	}

	public void setBuildingId(java.lang.Integer buildingId) {
		this.buildingId = buildingId;
	}

	public String getBuildingName() {
		return buildingName;
	}

	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}

	public java.lang.Integer getBuildingNum() {
		return buildingNum;
	}

	public void setBuildingNum(java.lang.Integer buildingNum) {
		this.buildingNum = buildingNum;
	}

	public java.lang.Integer getUserNum() {
		return userNum;
	}

	public void setUserNum(java.lang.Integer userNum) {
		this.userNum = userNum;
	}

	public java.lang.Integer getMemberNum() {
		return memberNum;
	}

	public void setMemberNum(java.lang.Integer memberNum) {
		this.memberNum = memberNum;
	}

	public String getComanyName() {
		return comanyName;
	}

	public void setComanyName(String comanyName) {
		this.comanyName = comanyName;
	}

	public java.lang.String getLeaderName() {
		return leaderName;
	}

	public void setLeaderName(java.lang.String leaderName) {
		this.leaderName = leaderName;
	}

	public java.lang.Integer getLoginUserId() {
		return loginUserId;
	}

	public void setLoginUserId(java.lang.Integer loginUserId) {
		this.loginUserId = loginUserId;
	}

	public java.lang.String getRoleCode() {
		return roleCode;
	}

	public void setRoleCode(java.lang.String roleCode) {
		this.roleCode = roleCode;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", branchId=" + branchId + ", account=" + account + ", password=" + password + ", name=" + name
				+ ", userType=" + userType + ", appUserType=" + appUserType + ", roleId=" + roleId + ", mobilePhone=" + mobilePhone
				+ ", isValid=" + isValid + ", leaderUserId=" + leaderUserId + ", headPortrait=" + headPortrait + ", creatorUserId="
				+ creatorUserId + ", createTime=" + createTime + ", updateUserId=" + updateUserId + ", updateTime=" + updateTime
				+ ", IDCardImg=" + IDCardImg + ", roleName=" + roleName + ", roleStatus=" + roleStatus + ", buildingId=" + buildingId
				+ ", buildingName=" + buildingName + ", comanyName=" + comanyName + ", buildingNum=" + buildingNum + ", userNum=" + userNum
				+ ", memberNum=" + memberNum + ", leaderName=" + leaderName + ", loginUserId=" + loginUserId + ", roleCode=" + roleCode
				+ "]";
	}

}
