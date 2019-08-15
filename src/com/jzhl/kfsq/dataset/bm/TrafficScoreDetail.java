package com.jzhl.kfsq.dataset.bm;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 交通分数详情结果集
 * 
 * @author Shaw
 *
 */
public class TrafficScoreDetail implements Serializable {

	private static final long serialVersionUID = 1628072613931014430L;// 序列化
	
	private Integer buildingId;// 楼盘编号
	
	private String buildingName;// 楼盘名称
	
	private String longitude; // 经度
	
	private String latitude; // 纬度
	
	private String trafficImg;// 交通定位点静态图
	
	private String trafficScore;// 交通分数
	
	private String countMember;// 参数评分人数
	
	private List<TrafficInfo> trafficInfos = new ArrayList<TrafficInfo>();// 交通信息集合
	
	private List<Station> stations = new ArrayList<Station>();// 站点信息集合

	public Integer getBuildingId() {
		return buildingId;
	}

	public void setBuildingId(Integer buildingId) {
		this.buildingId = buildingId;
	}

	public String getBuildingName() {
		return buildingName;
	}

	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
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

	public String getTrafficImg() {
		return trafficImg;
	}

	public void setTrafficImg(String trafficImg) {
		this.trafficImg = trafficImg;
	}

	public String getTrafficScore() {
		return trafficScore;
	}

	public void setTrafficScore(String trafficScore) {
		this.trafficScore = trafficScore;
	}

	public String getCountMember() {
		return countMember;
	}

	public void setCountMember(String countMember) {
		this.countMember = countMember;
	}

	public List<TrafficInfo> getTrafficInfos() {
		return trafficInfos;
	}

	public void setTrafficInfos(List<TrafficInfo> trafficInfos) {
		this.trafficInfos = trafficInfos;
	}

	public List<Station> getStations() {
		return stations;
	}

	public void setStations(List<Station> stations) {
		this.stations = stations;
	}

	@Override
	public String toString() {
		return "TrafficScoreDetail [buildingId=" + buildingId
				+ ", buildingName=" + buildingName + ", longitude=" + longitude
				+ ", latitude=" + latitude + ", trafficImg=" + trafficImg
				+ ", trafficScore=" + trafficScore + ", countMember="
				+ countMember + ", trafficInfos=" + trafficInfos
				+ ", stations=" + stations + "]";
	}

}
