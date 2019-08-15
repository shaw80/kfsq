package com.jzhl.kfsq.dto.fm;

import java.io.Serializable;

import com.jzhl.kfsq.common.base.PageListCondition;

/**
 * 支付信息dto
 * 
 * @author Shaw
 *
 */
public class PayInfoDto extends PageListCondition implements Serializable {

	private static final long serialVersionUID = 4236872515073863932L;// 序列化

	private Integer userId;// 用户编号

	private String beginTime;// 开始时间

	private String endTime;// 结束时间

	private java.lang.String isDownFlag; // 是否为excel导出

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(String beginTime) {
		this.beginTime = beginTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public java.lang.String getIsDownFlag() {
		return isDownFlag;
	}

	public void setIsDownFlag(java.lang.String isDownFlag) {
		this.isDownFlag = isDownFlag;
	}

	@Override
	public String toString() {
		return "PayInfoDto [userId=" + userId + ", beginTime=" + beginTime + ", endTime=" + endTime + ", isDownFlag=" + isDownFlag + "]";
	}

}
