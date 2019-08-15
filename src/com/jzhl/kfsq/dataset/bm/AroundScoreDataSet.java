package com.jzhl.kfsq.dataset.bm;

import java.io.Serializable;

/**
 * 教育详情结果集
 * 
 * @author mac
 *
 */
public class AroundScoreDataSet implements Serializable {

	private static final long serialVersionUID = 3747265829972281947L;

	private Integer aroundId;// 周边编号

	private String unitName;// 单位名称

	private String distance;// 距离，单位米
	
	private String longitude;// 经度
	
	private String latitude;// 纬度

	public String getDistance() {
		return distance;
	}

	public Integer getAroundId() {
		return aroundId;
	}

	public void setAroundId(Integer aroundId) {
		this.aroundId = aroundId;
	}

	public String getUnitName() {
		return unitName;
	}

	public void setUnitName(String unitName) {
		this.unitName = unitName;
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

	public void setDistance(String distance) {
		this.distance = distance;
	}

	@Override
	public String toString() {
		return "EducationDataSet [aroundId=" + aroundId + ", unitName="
				+ unitName + ", distance=" + distance + ", longitude="
				+ longitude + ", latitude=" + latitude + "]";
	}

}
