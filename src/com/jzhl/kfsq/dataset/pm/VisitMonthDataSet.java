package com.jzhl.kfsq.dataset.pm;

import java.io.Serializable;

public class VisitMonthDataSet implements Serializable {
	
	private static final long serialVersionUID = -4714512251139663871L;
	private java.lang.String visitMonth;
	private java.lang.Integer visits;
	
	public java.lang.String getVisitMonth() {
		return visitMonth;
	}
	public void setVisitMonth(java.lang.String visitMonth) {
		this.visitMonth = visitMonth;
	}
	public java.lang.Integer getVisits() {
		return visits;
	}
	public void setVisits(java.lang.Integer visits) {
		this.visits = visits;
	}
	
}
