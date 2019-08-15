package com.jzhl.kfsq.dataset.sm;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonFormat;

public class LogDataSet implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2340727761411216644L;
	// id
	private java.lang.Integer id;
	// 操作人
	private java.lang.Integer logUserId;
	// 操作人
	private java.lang.String name;
	// 操作内容
	private java.lang.String logText;
	// 操作id
	private java.lang.String logIp;
	private java.sql.Timestamp createTime; // 创建时间

	public java.lang.Integer getId() {
		return id;
	}

	public void setId(java.lang.Integer id) {
		this.id = id;
	}

	public java.lang.Integer getLogUserId() {
		return logUserId;
	}

	public void setLogUserId(java.lang.Integer logUserId) {
		this.logUserId = logUserId;
	}

	public java.lang.String getLogText() {
		return logText;
	}

	public void setLogText(java.lang.String logText) {
		this.logText = logText;
	}

	public java.lang.String getLogIp() {
		return logIp;
	}

	public void setLogIp(java.lang.String logIp) {
		this.logIp = logIp;
	}

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
	public java.sql.Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(java.sql.Timestamp createTime) {
		this.createTime = createTime;
	}

	public java.lang.String getName() {
		return name;
	}

	public void setName(java.lang.String name) {
		this.name = name;
	}

}
