package com.jzhl.kfsq.dataset.pm;

import java.io.Serializable;

import com.jzhl.kfsq.common.util.SystemConfig;

public class SalerCustomerDataSet implements Serializable {
	private static final long serialVersionUID = 1657227118418547100L;
	private java.lang.String clientName;
	private java.lang.String clientHeadPortrait;
	private java.lang.String clientTime;
	private java.lang.String envelope;
	private java.lang.String clientPhone;
	private java.lang.String isFavorite;
	private java.lang.String salerCustomerId;
	
	public java.lang.String getSalerCustomerId() {
		return salerCustomerId;
	}
	public void setSalerCustomerId(java.lang.String salerCustomerId) {
		this.salerCustomerId = salerCustomerId;
	}
	public java.lang.String getClientName() {
		return clientName;
	}
	public void setClientName(java.lang.String clientName) {
		this.clientName = clientName;
	}
	public java.lang.String getClientTime() {
		return clientTime;
	}
	public void setClientTime(java.lang.String clientTime) {
		this.clientTime = clientTime;
	}
	public java.lang.String getEnvelope() {
		return envelope;
	}
	public void setEnvelope(java.lang.String envelope) {
		this.envelope = envelope;
	}
	public java.lang.String getClientPhone() {
		return clientPhone;
	}
	public void setClientPhone(java.lang.String clientPhone) {
		this.clientPhone = clientPhone;
	}
	public java.lang.String getIsFavorite() {
		return isFavorite;
	}
	public void setIsFavorite(java.lang.String isFavorite) {
		this.isFavorite = isFavorite;
	}
	public java.lang.String getClientHeadPortrait() {
		if(clientHeadPortrait == null || clientHeadPortrait.isEmpty()) {
			return "";
		}
		return SystemConfig.getHttpBasePath() + clientHeadPortrait;
	}
	public void setClientHeadPortrait(java.lang.String clientHeadPortrait) {
		this.clientHeadPortrait = clientHeadPortrait;
	}
	
}
