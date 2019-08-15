package com.jzhl.kfsq.dto.fm;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 提现参数dto
 * 
 * @author Shaw
 *
 */
public class CashParamDto implements Serializable {

	private static final long serialVersionUID = -8735815306966498416L;// 序列化

	private Integer userId;// 用户编号

	private Integer status;// 提现状态

	private Timestamp beginTime;// 开始时间

	private Timestamp endTime;// 结束时间

	private Integer rowStart;// 起始条目

	private Integer offset;// 增量

	private java.lang.String isDownFlag; // 是否为excel导出

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

	public Timestamp getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(Timestamp beginTime) {
		this.beginTime = beginTime;
	}

	public Timestamp getEndTime() {
		return endTime;
	}

	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;
	}

	public Integer getRowStart() {
		return rowStart;
	}

	public void setRowStart(Integer rowStart) {
		this.rowStart = rowStart;
	}

	public Integer getOffset() {
		return offset;
	}

	public void setOffset(Integer offset) {
		this.offset = offset;
	}

	public java.lang.String getIsDownFlag() {
		return isDownFlag;
	}

	public void setIsDownFlag(java.lang.String isDownFlag) {
		this.isDownFlag = isDownFlag;
	}

	@Override
	public String toString() {
		return "CashParamDto [userId=" + userId + ", status=" + status + ", beginTime=" + beginTime + ", endTime=" + endTime
				+ ", rowStart=" + rowStart + ", offset=" + offset + ", isDownFlag=" + isDownFlag + "]";
	}

}
