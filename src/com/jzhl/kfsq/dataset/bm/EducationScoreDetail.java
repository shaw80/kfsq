package com.jzhl.kfsq.dataset.bm;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 教育分数详情结果集
 * 
 * @author mac
 *
 */
public class EducationScoreDetail implements Serializable {

	private static final long serialVersionUID = -4034812899322163138L;

	private Integer buildingId;// 楼盘编号
	
	private String buildingName;// 楼盘名称
	
	private String longitude; // 经度
	
	private String latitude; // 纬度
	
	private String educationImg;// 教育定位点静态图
	
	private String educationScore;// 交通分数
	
	private String countMember;// 参数评分人数
	
	private List<EducationInfo> educationInfos = new ArrayList<EducationInfo>();// 教育信息集合

	public Integer getBuildingId() {
		return buildingId;
	}

	public void setBuildingId(Integer buildingId) {
		this.buildingId = buildingId;
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

	public String getEducationImg() {
		return educationImg;
	}

	public void setEducationImg(String educationImg) {
		this.educationImg = educationImg;
	}

	public String getEducationScore() {
		return educationScore;
	}

	public void setEducationScore(String educationScore) {
		this.educationScore = educationScore;
	}

	public String getCountMember() {
		return countMember;
	}

	public void setCountMember(String countMember) {
		this.countMember = countMember;
	}

	public List<EducationInfo> getEducationInfos() {
		return educationInfos;
	}

	public void setEducationInfos(List<EducationInfo> educationInfos) {
		this.educationInfos = educationInfos;
	}

	public String getBuildingName() {
		return buildingName;
	}

	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}
	
}
