package com.jzhl.kfsq.dto.fm;

import java.io.Serializable;

import com.jzhl.kfsq.common.base.PageListCondition;

/**
 * 代理商页面提现查询dto
 * 
 * @author Shaw
 *
 */
public class CashAgentDto extends PageListCondition implements Serializable {

	private static final long serialVersionUID = 4995612425789843349L;// 序列化

	private Integer userId;// 用户编号

	private Integer status;// 提现状态

	private String beginTime;// 开始时间

	private String endTime;// 结束时间

	private java.lang.String isDownFlag; // 是否为Excel导出

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
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
		return "CashAgentDto [userId=" + userId + ", status=" + status + ", beginTime=" + beginTime + ", endTime=" + endTime
				+ ", isDownFlag=" + isDownFlag + "]";
	}

}
