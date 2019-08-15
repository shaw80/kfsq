package com.jzhl.kfsq.dataset.bm;

import java.io.Serializable;

/**
 * 交通结果集
 * 
 * @author Shaw
 *
 */
public class TrafficDataSet implements Serializable {

	private static final long serialVersionUID = -1213937570799301227L;// 序列化

	private Integer lineId;// 线路编号

	private String lineName;// 线路名称

	private String distance;// 距离，单位米
	
	private String longitude;// 经度
	
	private String latitude;// 纬度

	public Integer getLineId() {
		return lineId;
	}

	public void setLineId(Integer lineId) {
		this.lineId = lineId;
	}

	public String getLineName() {
		return lineName;
	}

	public void setLineName(String lineName) {
		this.lineName = lineName;
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

	@Override
	public String toString() {
		return "TrafficDataSet [lineId=" + lineId + ", lineName="
				+ lineName + ", distance=" + distance + ", longitude="
				+ longitude + ", latitude=" + latitude + "]";
	}

}
