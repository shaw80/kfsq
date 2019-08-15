package com.jzhl.kfsq.dataset.bm;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 周边分数详情结果集
 * 
 * @author mac
 *
 */
public class AroundScoreDetail implements Serializable {

	private static final long serialVersionUID = -4168081015060006255L;

	private Integer buildingId;// 楼盘编号
	
	private String buildingName;// 楼盘名称
	
	private String longitude; // 经度
	
	private String latitude; // 纬度
	
	private String aroundImg;// 周边定位点静态图
	
	private String peripheryScore;// 周边分数
	
	private String countMember;// 参数评分人数
	
	private List<AroundInfo> aroundInfos = new ArrayList<AroundInfo>();// 周边信息集合

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

	public String getAroundImg() {
		return aroundImg;
	}

	public void setAroundImg(String aroundImg) {
		this.aroundImg = aroundImg;
	}

	public String getPeripheryScore() {
		return peripheryScore;
	}

	public void setPeripheryScore(String peripheryScore) {
		this.peripheryScore = peripheryScore;
	}

	public String getCountMember() {
		return countMember;
	}

	public void setCountMember(String countMember) {
		this.countMember = countMember;
	}

	public List<AroundInfo> getAroundInfos() {
		return aroundInfos;
	}

	public void setAroundInfos(List<AroundInfo> aroundInfos) {
		this.aroundInfos = aroundInfos;
	}

	public String getBuildingName() {
		return buildingName;
	}

	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}

}
