package com.jzhl.kfsq.common.base;

public class SMResponseBean {
	private String statusCode;
	private String smsMessageSid;
	private String dateCreated;
	public String getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}
	public String getSmsMessageSid() {
		return smsMessageSid;
	}
	public void setSmsMessageSid(String smsMessageSid) {
		this.smsMessageSid = smsMessageSid;
	}
	public String getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(String dateCreated) {
		this.dateCreated = dateCreated;
	}
}
