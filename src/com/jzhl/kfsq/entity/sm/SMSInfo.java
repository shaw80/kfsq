package com.jzhl.kfsq.entity.sm;

import java.io.Serializable;

/**
 * 对应SM_SMSInfo表（短信表）
 */
public class SMSInfo implements Serializable{
	private static final long serialVersionUID = 7996315000128486363L;
	private java.lang.Integer codeId; // 数据ID
	private java.lang.String mobilePhone; // 手机号
	private java.lang.Short smsType; // 短信类型（0：注册，1：忘记密码，2：快捷登录）
	private java.lang.String smsMessageSid; // 短信网关返回的唯一标识
	private java.lang.String dateCreated; // 短信网关返回的短信创建时间
	private java.lang.String statusCode; // 短信网关返回状态码
	private java.lang.String templateId; // 短信模版ID
	private java.lang.String templateParam1; // 短信模版参数1
	private java.lang.String templateParam2; // 短信模版参数2
	private java.lang.String templateParam3; // 短信模版参数3
	private java.lang.String templateParam4; // 短信模版参数4
	private java.lang.String templateParam5; // 短信模版参数5
	private java.sql.Timestamp createTime; // 创建时间
	public java.lang.Integer getCodeId() {
		return codeId;
	}
	public void setCodeId(java.lang.Integer codeId) {
		this.codeId = codeId;
	}
	public java.lang.String getMobilePhone() {
		return mobilePhone;
	}
	public void setMobilePhone(java.lang.String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}
	public java.lang.Short getSmsType() {
		return smsType;
	}
	public void setSmsType(java.lang.Short smsType) {
		this.smsType = smsType;
	}
	public java.lang.String getSmsMessageSid() {
		return smsMessageSid;
	}
	public void setSmsMessageSid(java.lang.String smsMessageSid) {
		this.smsMessageSid = smsMessageSid;
	}
	public java.lang.String getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(java.lang.String dateCreated) {
		this.dateCreated = dateCreated;
	}
	public java.lang.String getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(java.lang.String statusCode) {
		this.statusCode = statusCode;
	}
	public java.lang.String getTemplateId() {
		return templateId;
	}
	public void setTemplateId(java.lang.String templateId) {
		this.templateId = templateId;
	}
	public java.lang.String getTemplateParam1() {
		return templateParam1;
	}
	public void setTemplateParam1(java.lang.String templateParam1) {
		this.templateParam1 = templateParam1;
	}
	public java.lang.String getTemplateParam2() {
		return templateParam2;
	}
	public void setTemplateParam2(java.lang.String templateParam2) {
		this.templateParam2 = templateParam2;
	}
	public java.lang.String getTemplateParam3() {
		return templateParam3;
	}
	public void setTemplateParam3(java.lang.String templateParam3) {
		this.templateParam3 = templateParam3;
	}
	public java.lang.String getTemplateParam4() {
		return templateParam4;
	}
	public void setTemplateParam4(java.lang.String templateParam4) {
		this.templateParam4 = templateParam4;
	}
	public java.lang.String getTemplateParam5() {
		return templateParam5;
	}
	public void setTemplateParam5(java.lang.String templateParam5) {
		this.templateParam5 = templateParam5;
	}
	public java.sql.Timestamp getCreateTime() {
		return createTime;
	}
	public void setCreateTime(java.sql.Timestamp createTime) {
		this.createTime = createTime;
	}
	public String[] getTemplateParams() {
		String templateParamList = "";
		if(templateParam1 != null && !templateParam1.isEmpty()) {
			templateParamList = templateParam1;
			if(templateParam2 != null && !templateParam2.isEmpty()) {
				templateParamList += "," + templateParam2;
				if(templateParam3 != null && !templateParam3.isEmpty()) {
					templateParamList += "," + templateParam3;
					if(templateParam4 != null && !templateParam4.isEmpty()) {
						templateParamList += "," + templateParam4;
						if(templateParam5 != null && !templateParam5.isEmpty()) {
							templateParamList += "," + templateParam5;
						}
					}
				}
			}
		}
		return templateParamList.split(",");
	}
}
