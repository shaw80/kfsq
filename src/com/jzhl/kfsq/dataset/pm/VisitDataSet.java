package com.jzhl.kfsq.dataset.pm;

import java.io.Serializable;

public class VisitDataSet implements Serializable {
	
	private static final long serialVersionUID = 4825383293284790670L;
	private java.lang.String visitDate;
	private java.lang.Integer visits;
	private java.lang.Integer week;
	
	public java.lang.String getVisitDate() {
		return visitDate;
	}
	public void setVisitDate(java.lang.String visitDate) {
		this.visitDate = visitDate;
	}
	public java.lang.Integer getVisits() {
		return visits;
	}
	public void setVisits(java.lang.Integer visits) {
		this.visits = visits;
	}
	public java.lang.Integer getWeek() {
		return week;
	}
	public void setWeek(java.lang.Integer week) {
		this.week = week;
	}
	
	@Override
	public String toString() {
		return "VisitDataSet [visitDate=" + visitDate + ", visits=" + visits
				+ ", week=" + week + "]";
	}
}
