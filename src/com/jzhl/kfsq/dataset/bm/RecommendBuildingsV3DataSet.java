package com.jzhl.kfsq.dataset.bm;

import java.io.Serializable;

/**
 * 推荐楼盘结果集
 * 
 * @author Shaw
 *
 */
public class RecommendBuildingsV3DataSet implements Serializable {

	private static final long serialVersionUID = -1288589472801958095L;// 序列化
	
	private Integer buildingId;// 楼盘编号
	
	private String banner;// 楼盘大图
	
	private String buildingName;// 楼盘名称
	
	private String address;// 地址
	
	private String totalScore;// 楼盘总评分
	
	private String averagePrice;// 均价
	
	private boolean hasEnvelope = false;// 是否有红包，默认值false

	public Integer getBuildingId() {
		return buildingId;
	}

	public void setBuildingId(Integer buildingId) {
		this.buildingId = buildingId;
	}

	public String getBanner() {
		if(banner == null || "".equals(banner)) {
			return "";
		}
		return banner;
	}
	
	public String getSmallBanner() {
		if(banner == null || "".equals(banner)) {
			return "";
		}
		String imageName = banner.substring(0, banner.lastIndexOf("."));
		String extName = banner.substring(banner.lastIndexOf(".") + 1);
		return imageName + "_small." + extName;
	}

	public void setBanner(String banner) {
		this.banner = banner;
	}

	public String getBuildingName() {
		return buildingName;
	}

	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTotalScore() {
		return totalScore;
	}

	public void setTotalScore(String totalScore) {
		this.totalScore = totalScore;
	}

	public String getAveragePrice() {
		return averagePrice;
	}

	public void setAveragePrice(String averagePrice) {
		this.averagePrice = averagePrice;
	}

	public boolean isHasEnvelope() {
		return hasEnvelope;
	}

	public void setHasEnvelope(boolean hasEnvelope) {
		this.hasEnvelope = hasEnvelope;
	}

	@Override
	public String toString() {
		return "RecommendBuildingsV3DataSet [buildingId=" + buildingId
				+ ", banner=" + banner + ", buildingName=" + buildingName
				+ ", address=" + address + ", totalScore=" + totalScore
				+ ", averagePrice=" + averagePrice + ", hasEnvelope="
				+ hasEnvelope + "]";
	}

}
