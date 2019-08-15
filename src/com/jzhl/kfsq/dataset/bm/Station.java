package com.jzhl.kfsq.dataset.bm;

import java.io.Serializable;

/**
 * 站点结果集
 * 
 * @author Shaw
 *
 */
public class Station implements Serializable {

	private static final long serialVersionUID = -3282241889896818303L;// 序列化
	
	private String stationName;// 站点名称
	
	private String lineName;// 线路名称
	
	private String longitude;// 经度
	
	private String latitude;// 维度

	public String getStationName() {
		return stationName;
	}

	public void setStationName(String stationName) {
		this.stationName = stationName;
	}

	public String getLineName() {
		return lineName;
	}

	public void setLineName(String lineName) {
		this.lineName = lineName;
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

	@Override
	public String toString() {
		return "Station [stationName=" + stationName + ", lineName=" + lineName
				+ ", longitude=" + longitude + ", latitude=" + latitude + "]";
	}

}
