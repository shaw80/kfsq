package com.jzhl.kfsq.entity.fm;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * 提现申请实体类
 * 
 * @author Shaw
 *
 */
public class CashApplication implements Serializable {

	private static final long serialVersionUID = -2741664039151815435L;// 序列化

	private String applicationId;// 申请编号

	private Integer receiveAccountId;// 接收账户编号

	private Integer payAccountId;// 支付账户编号

	private BigDecimal price;// 提现金额

	private Integer status;// 申请状态（0：待处理，1：处理中，2：处理成功，3：处理失败）

	private String failReason;// 失败原因

	private String serialNum;// 交易流水号

	private String batchNum;// 批次号

	private Timestamp applicationTime;// 申请时间

	private Timestamp payTime;// 支付时间

	private Timestamp updateTime;// 更新时间

	private Integer applicationPersonId;// 申请人编号

	private String applicationPersonName;// 申请人姓名

	private java.lang.Integer auditingPersonId; // 审核人编号

	private Integer payPersonId;// 支付人编号

	private String payPersonName;// 支付人姓名

	private Integer isValid;// 0：无效，1：有效

	private java.lang.Integer buildingNum; // 已看楼盘数量
	private java.lang.Integer visitNum; // 到访用户量
	private java.lang.Integer visitSumNum; // 到访用户总量，一个人到访多次也算
	private java.lang.Integer sumPrice; // 红包派发总额
	private java.lang.Integer buildingNumYesterday; // 昨天已看楼盘数量
	private java.lang.Integer visitNumYesterday; // 昨天到访用户量
	private java.lang.Integer visitSumNumYesterday; // 昨天到访用户总量，一个人到访多次也算
	private java.lang.Integer sumPriceYesterday; // 昨天红包派发总额

	private java.lang.String areaName; // 省市
	private java.lang.String buildingName; // 楼盘名称
	private java.lang.String auditName; // 审核人名称
	private java.lang.Integer commentBuildingNum; // 已评论楼盘数
	private java.lang.Integer commentMemmberNum; // 评论用户量
	private java.lang.Integer commentNum; // 评论量
	private java.lang.Integer commentBuildingNumYesterday; // 昨日已评论楼盘数
	private java.lang.Integer commentMemmberNumYesterday; // 昨日评论用户量
	private java.lang.Integer commentNumYesterday; // 昨日评论量

	public String getBatchNum() {
		return batchNum;
	}

	public void setBatchNum(String batchNum) {
		this.batchNum = batchNum;
	}

	public String getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(String applicationId) {
		this.applicationId = applicationId;
	}

	public Integer getReceiveAccountId() {
		return receiveAccountId;
	}

	public void setReceiveAccountId(Integer receiveAccountId) {
		this.receiveAccountId = receiveAccountId;
	}

	public Integer getPayAccountId() {
		return payAccountId;
	}

	public void setPayAccountId(Integer payAccountId) {
		this.payAccountId = payAccountId;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getFailReason() {
		return failReason;
	}

	public void setFailReason(String failReason) {
		this.failReason = failReason;
	}

	public String getSerialNum() {
		return serialNum;
	}

	public void setSerialNum(String serialNum) {
		this.serialNum = serialNum;
	}

	public Timestamp getApplicationTime() {
		return applicationTime;
	}

	public void setApplicationTime(Timestamp applicationTime) {
		this.applicationTime = applicationTime;
	}

	public Timestamp getPayTime() {
		return payTime;
	}

	public void setPayTime(Timestamp payTime) {
		this.payTime = payTime;
	}

	public Timestamp getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}

	public Integer getApplicationPersonId() {
		return applicationPersonId;
	}

	public void setApplicationPersonId(Integer applicationPersonId) {
		this.applicationPersonId = applicationPersonId;
	}

	public String getApplicationPersonName() {
		return applicationPersonName;
	}

	public void setApplicationPersonName(String applicationPersonName) {
		this.applicationPersonName = applicationPersonName;
	}

	public Integer getPayPersonId() {
		return payPersonId;
	}

	public void setPayPersonId(Integer payPersonId) {
		this.payPersonId = payPersonId;
	}

	public String getPayPersonName() {
		return payPersonName;
	}

	public void setPayPersonName(String payPersonName) {
		this.payPersonName = payPersonName;
	}

	public Integer getIsValid() {
		return isValid;
	}

	public void setIsValid(Integer isValid) {
		this.isValid = isValid;
	}

	public java.lang.Integer getAuditingPersonId() {
		return auditingPersonId;
	}

	public void setAuditingPersonId(java.lang.Integer auditingPersonId) {
		this.auditingPersonId = auditingPersonId;
	}

	public java.lang.Integer getBuildingNum() {
		return buildingNum;
	}

	public void setBuildingNum(java.lang.Integer buildingNum) {
		this.buildingNum = buildingNum;
	}

	public java.lang.Integer getVisitNum() {
		return visitNum;
	}

	public void setVisitNum(java.lang.Integer visitNum) {
		this.visitNum = visitNum;
	}

	public java.lang.Integer getSumPrice() {
		return sumPrice;
	}

	public void setSumPrice(java.lang.Integer sumPrice) {
		this.sumPrice = sumPrice;
	}

	public java.lang.String getAreaName() {
		return areaName;
	}

	public void setAreaName(java.lang.String areaName) {
		this.areaName = areaName;
	}

	public java.lang.String getBuildingName() {
		return buildingName;
	}

	public void setBuildingName(java.lang.String buildingName) {
		this.buildingName = buildingName;
	}

	public java.lang.String getAuditName() {
		return auditName;
	}

	public void setAuditName(java.lang.String auditName) {
		this.auditName = auditName;
	}

	public java.lang.Integer getCommentBuildingNum() {
		return commentBuildingNum;
	}

	public void setCommentBuildingNum(java.lang.Integer commentBuildingNum) {
		this.commentBuildingNum = commentBuildingNum;
	}

	public java.lang.Integer getCommentMemmberNum() {
		return commentMemmberNum;
	}

	public void setCommentMemmberNum(java.lang.Integer commentMemmberNum) {
		this.commentMemmberNum = commentMemmberNum;
	}

	public java.lang.Integer getCommentNum() {
		return commentNum;
	}

	public void setCommentNum(java.lang.Integer commentNum) {
		this.commentNum = commentNum;
	}

	public java.lang.Integer getVisitSumNum() {
		return visitSumNum;
	}

	public void setVisitSumNum(java.lang.Integer visitSumNum) {
		this.visitSumNum = visitSumNum;
	}

	public java.lang.Integer getBuildingNumYesterday() {
		return buildingNumYesterday;
	}

	public void setBuildingNumYesterday(java.lang.Integer buildingNumYesterday) {
		this.buildingNumYesterday = buildingNumYesterday;
	}

	public java.lang.Integer getVisitNumYesterday() {
		return visitNumYesterday;
	}

	public void setVisitNumYesterday(java.lang.Integer visitNumYesterday) {
		this.visitNumYesterday = visitNumYesterday;
	}

	public java.lang.Integer getVisitSumNumYesterday() {
		return visitSumNumYesterday;
	}

	public void setVisitSumNumYesterday(java.lang.Integer visitSumNumYesterday) {
		this.visitSumNumYesterday = visitSumNumYesterday;
	}

	public java.lang.Integer getSumPriceYesterday() {
		return sumPriceYesterday;
	}

	public void setSumPriceYesterday(java.lang.Integer sumPriceYesterday) {
		this.sumPriceYesterday = sumPriceYesterday;
	}

	public java.lang.Integer getCommentBuildingNumYesterday() {
		return commentBuildingNumYesterday;
	}

	public void setCommentBuildingNumYesterday(java.lang.Integer commentBuildingNumYesterday) {
		this.commentBuildingNumYesterday = commentBuildingNumYesterday;
	}

	public java.lang.Integer getCommentMemmberNumYesterday() {
		return commentMemmberNumYesterday;
	}

	public void setCommentMemmberNumYesterday(java.lang.Integer commentMemmberNumYesterday) {
		this.commentMemmberNumYesterday = commentMemmberNumYesterday;
	}

	public java.lang.Integer getCommentNumYesterday() {
		return commentNumYesterday;
	}

	public void setCommentNumYesterday(java.lang.Integer commentNumYesterday) {
		this.commentNumYesterday = commentNumYesterday;
	}

	@Override
	public String toString() {
		return "CashApplication [applicationId=" + applicationId + ", receiveAccountId=" + receiveAccountId + ", payAccountId="
				+ payAccountId + ", price=" + price + ", status=" + status + ", failReason=" + failReason + ", serialNum=" + serialNum
				+ ", batchNum=" + batchNum + ", applicationTime=" + applicationTime + ", payTime=" + payTime + ", updateTime=" + updateTime
				+ ", applicationPersonId=" + applicationPersonId + ", applicationPersonName=" + applicationPersonName
				+ ", auditingPersonId=" + auditingPersonId + ", payPersonId=" + payPersonId + ", payPersonName=" + payPersonName
				+ ", isValid=" + isValid + ", buildingNum=" + buildingNum + ", visitNum=" + visitNum + ", visitSumNum=" + visitSumNum
				+ ", sumPrice=" + sumPrice + ", buildingNumYesterday=" + buildingNumYesterday + ", visitNumYesterday=" + visitNumYesterday
				+ ", visitSumNumYesterday=" + visitSumNumYesterday + ", sumPriceYesterday=" + sumPriceYesterday + ", areaName=" + areaName
				+ ", buildingName=" + buildingName + ", auditName=" + auditName + ", commentBuildingNum=" + commentBuildingNum
				+ ", commentMemmberNum=" + commentMemmberNum + ", commentNum=" + commentNum + ", commentBuildingNumYesterday="
				+ commentBuildingNumYesterday + ", commentMemmberNumYesterday=" + commentMemmberNumYesterday + ", commentNumYesterday="
				+ commentNumYesterday + "]";
	}

}
