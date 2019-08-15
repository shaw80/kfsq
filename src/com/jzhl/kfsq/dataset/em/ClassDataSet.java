package com.jzhl.kfsq.dataset.em;

public class ClassDataSet {
	private int classId;
	private String className;
	private String icon;
	private int serialNum;
	private java.lang.Integer isValid; // 0：无效，1：有效

	public ClassDataSet() {

	}

	public int getClassId() {
		return classId;
	}

	public void setClassId(int classId) {
		this.classId = classId;
	}

	public String getClassName() {
		return className == null ? "" : className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getIcon() {
		return icon == null ? "" : icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public java.lang.Integer getIsValid() {
		return isValid;
	}

	public void setIsValid(java.lang.Integer isValid) {
		this.isValid = isValid;
	}

	public int getSerialNum() {
		return serialNum;
	}

	public void setSerialNum(int serialNum) {
		this.serialNum = serialNum;
	}

}
