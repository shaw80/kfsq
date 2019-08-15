package com.jzhl.kfsq.entity.mm;

import java.io.Serializable;
import java.math.BigDecimal;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * 
 * MM_Member表
 * 
 * @author zhouzy
 *
 */
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class Member implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 2730705975914377794L;
	private java.lang.Integer memberId; // 会员编号，主键
	private java.lang.String account; // 用户登录ID：用户登录系统的标识，一般是英文字符或者数字。
	private java.lang.String sex; // 性别（0：男，1：女）
	private java.lang.String password; // 密码
	private java.lang.String nickName; // 名字
	private java.lang.String headPortrait; // 头像
	private java.lang.String phone; // 手机
	private java.sql.Timestamp createTime; // 数据创建时间
	private java.sql.Timestamp updateTime; // 数据更新时间
	private java.sql.Timestamp lastLoginTime; // 最后登录时间
	private java.lang.Short isValid; // 0：无效，1：有效
	private java.lang.Integer planNum; // 加入计划数
	private java.lang.Integer visitNum; // 到访数
	private java.lang.Integer followNum; // 关注数
	private java.lang.Integer buildingCommentNum; // 看房圈评论数
	private java.lang.Integer commentEnveloppe; // 评论红包
	private java.lang.Integer lookEnveloppe; // 看房红包
	private java.lang.Integer restEnveloppe; // 剩余红包额度
	private java.lang.String buildingName; // 楼盘名称
	private java.sql.Timestamp planTime; // 计划时间
	private BigDecimal price; // 领取金额
	private java.sql.Timestamp visitTime; // 到访时间
	private java.lang.String userName; // 售楼员名称；验证员工
	private java.lang.Short isValidParam;

	private java.lang.Integer planListNum; // 所有人加入计划总数
	private java.lang.Integer visitListNum; // 所有人到访数
	private java.lang.Integer followListNum; // 所有人关注数
	private java.lang.Integer buildingCommentListNum; // 所有人看房圈评论数
	private java.lang.String areaName; // 会员所在城市
	private java.lang.Integer upperPrive; // 所在城市每人领取红包上限；从代理商表中获取

	private java.lang.String companyAddr;
	private java.lang.String companyLongitude;
	private java.lang.String companyLatitude;
	private java.lang.String homeAddr;
	private java.lang.String homeLongitude;
	private java.lang.String homeLatitude;
	private java.lang.Integer cityId;

	/**
	 * 获取会员编号，主键属性
	 *
	 * @return memberid
	 */
	public java.lang.Integer getMemberId() {
		return memberId;
	}

	/**
	 * 设置会员编号，主键属性
	 *
	 * @param memberid
	 */
	public void setMemberId(java.lang.Integer memberId) {
		this.memberId = memberId;
	}

	/**
	 * 获取用户登录ID：用户登录系统的标识，一般是英文字符或者数字。属性
	 *
	 * @return account
	 */
	public java.lang.String getAccount() {
		return account;
	}

	/**
	 * 设置用户登录ID：用户登录系统的标识，一般是英文字符或者数字。属性
	 *
	 * @param account
	 */
	public void setAccount(java.lang.String account) {
		this.account = account;
	}

	/**
	 * 获取性别（0：男，1：女）属性
	 *
	 * @return sex
	 */
	public java.lang.String getSex() {
		return sex;
	}

	/**
	 * 设置性别（0：男，1：女）属性
	 *
	 * @param sex
	 */
	public void setSex(java.lang.String sex) {
		this.sex = sex;
	}

	/**
	 * 获取密码属性
	 *
	 * @return password
	 */
	public java.lang.String getPassword() {
		return password;
	}

	/**
	 * 设置密码属性
	 *
	 * @param password
	 */
	public void setPassword(java.lang.String password) {
		this.password = password;
	}

	/**
	 * 获取名字属性
	 *
	 * @return nickname
	 */
	public java.lang.String getNickName() {
		return nickName;
	}

	/**
	 * 设置名字属性
	 *
	 * @param nickname
	 */
	public void setNickName(java.lang.String nickName) {
		this.nickName = nickName;
	}

	/**
	 * 获取头像属性
	 *
	 * @return headportrait
	 */
	public java.lang.String getHeadPortrait() {
		return headPortrait;
	}

	/**
	 * 设置头像属性
	 *
	 * @param headportrait
	 */
	public void setHeadPortrait(java.lang.String headportrait) {
		this.headPortrait = headportrait;
	}

	/**
	 * 获取手机属性
	 *
	 * @return phone
	 */
	public java.lang.String getPhone() {
		return phone;
	}

	/**
	 * 设置手机属性
	 *
	 * @param phone
	 */
	public void setPhone(java.lang.String phone) {
		this.phone = phone;
	}

	/**
	 * 获取数据创建时间属性
	 *
	 * @return createtime
	 */
	public java.sql.Timestamp getCreateTime() {
		return createTime;
	}

	/**
	 * 设置数据创建时间属性
	 *
	 * @param createtime
	 */
	public void setCreatetime(java.sql.Timestamp createtime) {
		this.createTime = createtime;
	}

	/**
	 * 获取数据更新时间属性
	 *
	 * @return updatetime
	 */
	public java.sql.Timestamp getUpdateTime() {
		return updateTime;
	}

	/**
	 * 设置数据更新时间属性
	 *
	 * @param updatetime
	 */
	public void setUpdatetime(java.sql.Timestamp updateTime) {
		this.updateTime = updateTime;
	}

	/**
	 * 获取最后登录时间属性
	 *
	 * @return lastlogintime
	 */
	public java.sql.Timestamp getLastLoginTime() {
		return lastLoginTime;
	}

	/**
	 * 设置最后登录时间属性
	 *
	 * @param lastlogintime
	 */
	public void setLastLogintime(java.sql.Timestamp lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	/**
	 * 获取0：无效，1：有效属性
	 *
	 * @return isvalid
	 */
	public java.lang.Short getIsValid() {
		return isValid;
	}

	/**
	 * 设置0：无效，1：有效属性
	 *
	 * @param isvalid
	 */
	public void setIsValid(java.lang.Short isValid) {
		this.isValid = isValid;
	}

	public java.lang.Integer getPlanNum() {
		return planNum;
	}

	public void setPlanNum(java.lang.Integer planNum) {
		this.planNum = planNum;
	}

	public java.lang.Integer getFollowNum() {
		return followNum;
	}

	public void setFollowNum(java.lang.Integer followNum) {
		this.followNum = followNum;
	}

	public java.lang.Integer getBuildingCommentNum() {
		return buildingCommentNum;
	}

	public void setBuildingCommentNum(java.lang.Integer buildingCommentNum) {
		this.buildingCommentNum = buildingCommentNum;
	}

	public java.lang.Integer getVisitNum() {
		return visitNum;
	}

	public void setVisitNum(java.lang.Integer visitNum) {
		this.visitNum = visitNum;
	}

	public java.lang.Short getIsValidParam() {
		return isValidParam;
	}

	public void setIsValidParam(java.lang.Short isValidParam) {
		this.isValidParam = isValidParam;
	}

	public java.lang.Integer getCommentEnveloppe() {
		return commentEnveloppe;
	}

	public void setCommentEnveloppe(java.lang.Integer commentEnveloppe) {
		this.commentEnveloppe = commentEnveloppe;
	}

	public java.lang.Integer getLookEnveloppe() {
		return lookEnveloppe;
	}

	public void setLookEnveloppe(java.lang.Integer lookEnveloppe) {
		this.lookEnveloppe = lookEnveloppe;
	}

	public java.lang.Integer getRestEnveloppe() {
		return restEnveloppe;
	}

	public void setRestEnveloppe(java.lang.Integer restEnveloppe) {
		this.restEnveloppe = restEnveloppe;
	}

	public java.lang.String getBuildingName() {
		return buildingName;
	}

	public void setBuildingName(java.lang.String buildingName) {
		this.buildingName = buildingName;
	}

	public java.sql.Timestamp getPlanTime() {
		return planTime;
	}

	public void setPlanTime(java.sql.Timestamp planTime) {
		this.planTime = planTime;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public java.sql.Timestamp getVisitTime() {
		return visitTime;
	}

	public void setVisitTime(java.sql.Timestamp visitTime) {
		this.visitTime = visitTime;
	}

	public java.lang.String getUserName() {
		return userName;
	}

	public void setUserName(java.lang.String userName) {
		this.userName = userName;
	}

	public java.lang.Integer getPlanListNum() {
		return planListNum;
	}

	public void setPlanListNum(java.lang.Integer planListNum) {
		this.planListNum = planListNum;
	}

	public java.lang.Integer getVisitListNum() {
		return visitListNum;
	}

	public void setVisitListNum(java.lang.Integer visitListNum) {
		this.visitListNum = visitListNum;
	}

	public java.lang.Integer getFollowListNum() {
		return followListNum;
	}

	public void setFollowListNum(java.lang.Integer followListNum) {
		this.followListNum = followListNum;
	}

	public java.lang.Integer getBuildingCommentListNum() {
		return buildingCommentListNum;
	}

	public void setBuildingCommentListNum(java.lang.Integer buildingCommentListNum) {
		this.buildingCommentListNum = buildingCommentListNum;
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

	public java.lang.String getAreaName() {
		return areaName;
	}

	public void setAreaName(java.lang.String areaName) {
		this.areaName = areaName;
	}

	public java.lang.Integer getUpperPrive() {
		return upperPrive;
	}

	public void setUpperPrive(java.lang.Integer upperPrive) {
		this.upperPrive = upperPrive;
	}

	public java.lang.Integer getCityId() {
		return cityId;
	}

	public void setCityId(java.lang.Integer cityId) {
		this.cityId = cityId;
	}

	@Override
	public String toString() {
		return "Member [memberId=" + memberId + ", account=" + account + ", sex=" + sex + ", password=" + password + ", nickName="
				+ nickName + ", headPortrait=" + headPortrait + ", phone=" + phone + ", createTime=" + createTime + ", updateTime="
				+ updateTime + ", lastLoginTime=" + lastLoginTime + ", isValid=" + isValid + ", planNum=" + planNum + ", visitNum="
				+ visitNum + ", followNum=" + followNum + ", buildingCommentNum=" + buildingCommentNum + ", commentEnveloppe="
				+ commentEnveloppe + ", lookEnveloppe=" + lookEnveloppe + ", restEnveloppe=" + restEnveloppe + ", buildingName="
				+ buildingName + ", planTime=" + planTime + ", price=" + price + ", visitTime=" + visitTime + ", userName=" + userName
				+ ", isValidParam=" + isValidParam + ", planListNum=" + planListNum + ", visitListNum=" + visitListNum + ", followListNum="
				+ followListNum + ", buildingCommentListNum=" + buildingCommentListNum + ", areaName=" + areaName + ", upperPrive="
				+ upperPrive + ", companyAddr=" + companyAddr + ", companyLongitude=" + companyLongitude + ", companyLatitude="
				+ companyLatitude + ", homeAddr=" + homeAddr + ", homeLongitude=" + homeLongitude + ", homeLatitude=" + homeLatitude + "]";
	}

}