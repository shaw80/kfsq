package com.jzhl.kfsq.dataset.bm;

import java.io.Serializable;

/**
 * 教育详情结果集
 * 
 * @author mac
 *
 */
public class EducationScoreDataSet implements Serializable {

	private static final long serialVersionUID = 3747265829972281947L;

	private Integer educationId;// 教育编号

	private String schoolName;// 学校名称

	private String distance;// 距离，单位米
	
	private String longitude;// 经度
	
	private String latitude;// 纬度

	public Integer getEducationId() {
		return educationId;
	}

	public void setEducationId(Integer educationId) {
		this.educationId = educationId;
	}

	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	public String getDistance() {
		return distance;
	}

	public void setDistance(String distance) {
		this.distance = distance;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

}
