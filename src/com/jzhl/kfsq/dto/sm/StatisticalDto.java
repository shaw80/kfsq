package com.jzhl.kfsq.dto.sm;

public class StatisticalDto {
	private java.lang.String dateStart;
	private java.lang.String dateEnd;
	private java.lang.String year;
	private java.lang.Integer branchId; // 分站ID

	private java.lang.Integer userId; // 登录UserId

	public java.lang.String getDateStart() {
		return dateStart;
	}

	public void setDateStart(java.lang.String dateStart) {
		this.dateStart = dateStart;
	}

	public java.lang.String getDateEnd() {
		return dateEnd;
	}

	public void setDateEnd(java.lang.String dateEnd) {
		this.dateEnd = dateEnd;
	}

	public java.lang.String getYear() {
		return year;
	}

	public void setYear(java.lang.String year) {
		this.year = year;
	}

	public java.lang.Integer getBranchId() {
		return branchId;
	}

	public void setBranchId(java.lang.Integer branchId) {
		this.branchId = branchId;
	}

	public java.lang.Integer getUserId() {
		return userId;
	}

	public void setUserId(java.lang.Integer userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "StatisticalDto [dateStart=" + dateStart + ", dateEnd=" + dateEnd + ", year=" + year + ", branchId=" + branchId
				+ ", userId=" + userId + "]";
	}

}
