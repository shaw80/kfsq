package com.jzhl.kfsq.dto.sm;



/**
 * Created by Administrator on 2015/12/17.
 */
public class LogDto{
    //操作人
   private java.lang.Integer logUserId;
   //操作内容
   private java.lang.String logText;
   //操作id
   private java.lang.String logIp;
    private java.sql.Timestamp createTime; // 创建时间


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

	public java.sql.Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(java.sql.Timestamp createTime) {
		this.createTime = createTime;
	}
    
}
