package com.jzhl.kfsq.dto.mm;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.jzhl.kfsq.common.base.PageListCondition;

public class MemberDto extends PageListCondition {

	@JsonProperty(value = "memberId")
	private java.lang.Integer memberId; // 会员编号，主键
	private java.lang.String account; // 用户登录ID：用户登录系统的标识，一般是英文字符或者数字。
	private java.lang.String sex; // 性别（0：男，1：女）
	private java.lang.String password; // 密码
	private java.lang.String nickName; // 名字
	private java.lang.String headPortrait; // 头像
	private java.lang.String phone; // 手机
	private java.lang.String createTime; // 数据创建时间
	private java.lang.String updateTime; // 数据更新时间
	private java.lang.String lastLoginTime; // 最后登录时间
	private java.lang.Short isValid; // 0：无效，1：有效
	private java.lang.String isValidParam; // 指定要操作的会员信息类型，app端传1
	private java.lang.String cityFlag; // 城市筛选
	private java.lang.String dateFlag; // 日期筛选；1:7天 ，2:1个月，3：三个月
	private java.lang.String dateStart; // 自定义时间开始日期
	private java.lang.String dateEnd; // 自定义时间结束时间
	private java.lang.String keyword; // 关键字
	private java.lang.Integer branchId; // 分站ID
	private java.lang.String companyAddr;
	private java.lang.String companyLongitude;
	private java.lang.String companyLatitude;
	private java.lang.String homeAddr;
	private java.lang.String homeLongitude;
	private java.lang.String homeLatitude;

	private java.lang.String isDownFlag; // 判断是否为excel导出
	
	private java.lang.Integer cityId;

	public java.lang.Integer getMemberId() {
		return memberId;
	}

	public void setMemberId(java.lang.Integer memberId) {
		this.memberId = memberId;
	}

	public java.lang.String getAccount() {
		return account;
	}

	public void setAccount(java.lang.String account) {
		this.account = account;
	}

	public java.lang.String getSex() {
		return sex;
	}

	public void setSex(java.lang.String sex) {
		this.sex = sex;
	}

	public java.lang.String getPassword() {
		return password;
	}

	public void setPassword(java.lang.String password) {
		this.password = password;
	}

	public java.lang.String getNickName() {
		return nickName;
	}

	public void setNickName(java.lang.String nickName) {
		this.nickName = nickName;
	}

	public java.lang.String getHeadPortrait() {
		return headPortrait;
	}

	public void setHeadPortrait(java.lang.String headPortrait) {
		this.headPortrait = headPortrait;
	}

	public java.lang.String getPhone() {
		return phone;
	}

	public void setPhone(java.lang.String phone) {
		this.phone = phone;
	}

	public java.lang.String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(java.lang.String createTime) {
		this.createTime = createTime;
	}

	public java.lang.String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(java.lang.String updateTime) {
		this.updateTime = updateTime;
	}

	public java.lang.String getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLastLoginTime(java.lang.String lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	public java.lang.Short getIsValid() {
		return isValid;
	}

	public void setIsValid(java.lang.Short isValid) {
		this.isValid = isValid;
	}

	public java.lang.String getIsValidParam() {
		return isValidParam;
	}

	public void setIsValidParam(java.lang.String isValidParam) {
		this.isValidParam = isValidParam;
	}

	public java.lang.String getCityFlag() {
		return cityFlag;
	}

	public void setCityFlag(java.lang.String cityFlag) {
		this.cityFlag = cityFlag;
	}

	public java.lang.String getDateFlag() {
		return dateFlag;
	}

	public void setDateFlag(java.lang.String dateFlag) {
		this.dateFlag = dateFlag;
	}

	public java.lang.String getDateStart() {
		return dateStart;
	}

	public void setDateStart(java.lang.String dateStart) {
		this.dateStart = dateStart;
	}

	public java.lang.String getDateEnd() {
		return dateEnd;
	}

	public void setDateEnd(java.lang.String dateEnd) {
		this.dateEnd = dateEnd;
	}

	public java.lang.String getKeyword() {
		return keyword;
	}

	public void setKeyword(java.lang.String keyword) {
		this.keyword = keyword;
	}

	public java.lang.Integer getBranchId() {
		return branchId;
	}

	public void setBranchId(java.lang.Integer branchId) {
		this.branchId = branchId;
	}

	public java.lang.String getCompanyAddr() {
		return companyAddr;
	}

	public void setCompanyAddr(java.lang.String companyAddr) {
		this.companyAddr = companyAddr;
	}

	public java.lang.String getCompanyLongitude() {
		return companyLongitude;
	}

	public void setCompanyLongitude(java.lang.String companyLongitude) {
		this.companyLongitude = companyLongitude;
	}

	public java.lang.String getCompanyLatitude() {
		return companyLatitude;
	}

	public void setCompanyLatitude(java.lang.String companyLatitude) {
		this.companyLatitude = companyLatitude;
	}

	public java.lang.String getHomeAddr() {
		return homeAddr;
	}

	public void setHomeAddr(java.lang.String homeAddr) {
		this.homeAddr = homeAddr;
	}

	public java.lang.String getHomeLongitude() {
		return homeLongitude;
	}

	public void setHomeLongitude(java.lang.String homeLongitude) {
		this.homeLongitude = homeLongitude;
	}

	public java.lang.String getHomeLatitude() {
		return homeLatitude;
	}

	public void setHomeLatitude(java.lang.String homeLatitude) {
		this.homeLatitude = homeLatitude;
	}

	public java.lang.String getIsDownFlag() {
		return isDownFlag;
	}

	public void setIsDownFlag(java.lang.String isDownFlag) {
		this.isDownFlag = isDownFlag;
	}

	public java.lang.Integer getCityId() {
		return cityId;
	}

	public void setCityId(java.lang.Integer cityId) {
		this.cityId = cityId;
	}

}
