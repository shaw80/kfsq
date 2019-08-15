package com.jzhl.kfsq.dto.sm;

import java.io.Serializable;

public class SMSInfoDto implements Serializable{
	private static final long serialVersionUID = -5836250217795076460L;
	private java.lang.Integer codeId;
	private java.lang.String mobilePhone; // 手机号
	private java.lang.Short smsType; // 短信类型（0：注册，1：忘记密码，2：快捷登录）
	private java.lang.String templateParam1; // 短信模版参数1
	private java.lang.String templateParam2; // 短信模版参数2
	private java.lang.String templateParam3; // 短信模版参数3
	private java.lang.String templateParam4; // 短信模版参数4
	private java.lang.String templateParam5; // 短信模版参数5
	
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
	
}
