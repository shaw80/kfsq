package com.jzhl.kfsq.dto.bm;

import com.jzhl.kfsq.common.base.PageListCondition;

public class BuildingDto extends PageListCondition {
	private java.lang.String areaId; // 区域编号
	private java.lang.String priceId; // 价格编号
	private java.lang.String featureId; // 特色编号
	private java.lang.String position; // 地段
	private java.lang.String developer; // 开发商
	private java.lang.String buildingName; // 楼盘名称
	private java.lang.String longitude; // 经度
	private java.lang.String latitude; // 纬度
	private java.lang.String longitudeSpan; // 经度跨度
	private java.lang.String latitudeSpan; // 纬度跨度
	private java.lang.String isPage = "0"; // 1分页;0不分页
	private java.lang.String isComprehensive = "0"; // 0或null不是综合;1综合
	private java.lang.String year; // 按月份查询时，分组的年份
	private java.lang.Integer agentId;
	private java.lang.String buildingId;
	private java.lang.String month; // 按月份查询新增充值楼盘数量
	private java.lang.Integer memberId;// 会员编号
	private java.lang.String cityId;

	private java.lang.String uuId; // 手机uuid
	private java.lang.Integer secondAreaId; // 二级区域编号
	private java.lang.Integer decorationSituation; // 装修情况（0：毛坯，1：精装）
	private java.lang.Integer sortFlag; // 筛选-更多-排序标志:
										// 0:价格由低到高；1：价格由高到低；2：评分由高到低；3：评分由低到高
	private java.lang.Integer tagId; // 特色标签编号
	private java.lang.Integer totalScore; // 总评分
	private java.lang.Integer switchStatus; // 红包状态

	public BuildingDto() {

	}

	public java.lang.Integer getMemberId() {
		return memberId;
	}

	public void setMemberId(java.lang.Integer memberId) {
		this.memberId = memberId;
	}

	public java.lang.String getAreaId() {
		return areaId;
	}

	public void setAreaId(java.lang.String areaId) {
		this.areaId = areaId;
	}

	public java.lang.String getPriceId() {
		return priceId;
	}

	public void setPriceId(java.lang.String priceId) {
		this.priceId = priceId;
	}

	public java.lang.String[] getFeatureIdDisplay() {
		if (featureId == null || featureId.isEmpty() || "0".equals(featureId)) {
			return null;
		}
		return featureId.split(",");
	}

	public java.lang.String getFeatureId() {
		return featureId;
	}

	public void setFeatureId(java.lang.String featureId) {
		this.featureId = featureId;
	}

	public java.lang.String getPosition() {
		return position;
	}

	public void setPosition(java.lang.String position) {
		this.position = position;
	}

	public java.lang.String getDeveloper() {
		return developer;
	}

	public void setDeveloper(java.lang.String developer) {
		this.developer = developer;
	}

	public java.lang.String getBuildingName() {
		return buildingName;
	}

	public void setBuildingName(java.lang.String buildingName) {
		this.buildingName = buildingName;
	}

	public java.lang.String getLongitude() {
		return longitude;
	}

	public void setLongitude(java.lang.String longitude) {
		this.longitude = longitude;
	}

	public Double getMaxLongitude() {
		try {
			if (longitude == null || longitudeSpan == null) {
				return null;
			}
			double maxLongitude = Double.parseDouble(longitude) + Double.parseDouble(longitudeSpan);
			while (maxLongitude > 180) {
				maxLongitude -= 360;
			}
			return maxLongitude;
		} catch (Exception e) {
			return null;
		}
	}

	public Double getMinLongitude() {
		try {
			if (longitude == null || longitudeSpan == null) {
				return null;
			}
			double mixLongitude = Double.parseDouble(longitude) - Double.parseDouble(longitudeSpan);
			while (mixLongitude < -180) {
				mixLongitude += 360;
			}
			return mixLongitude;
		} catch (Exception e) {
			return null;
		}
	}

	public java.lang.String getLatitude() {
		return latitude;
	}

	public void setLatitude(java.lang.String latitude) {
		this.latitude = latitude;
	}

	public Double getMaxLatitude() {
		try {
			if (latitude != null && latitudeSpan != null) {
				return Double.parseDouble(latitude) + Double.parseDouble(latitudeSpan);
			}
		} catch (Exception e) {

		}
		return null;
	}

	public Double getMinLatitude() {
		try {
			if (latitude != null && latitudeSpan != null) {
				return Double.parseDouble(latitude) - Double.parseDouble(latitudeSpan);
			}
		} catch (Exception e) {

		}
		return null;
	}

	public java.lang.String getLongitudeSpan() {
		return longitudeSpan;
	}

	public void setLongitudeSpan(java.lang.String longitudeSpan) {
		this.longitudeSpan = longitudeSpan;
	}

	public java.lang.String getLatitudeSpan() {
		return latitudeSpan;
	}

	public void setLatitudeSpan(java.lang.String latitudeSpan) {
		this.latitudeSpan = latitudeSpan;
	}

	public java.lang.String getIsPage() {
		return isPage;
	}

	public void setIsPage(java.lang.String isPage) {
		this.isPage = isPage;
	}

	public java.lang.String getIsComprehensive() {
		return isComprehensive;
	}

	public void setIsComprehensive(java.lang.String isComprehensive) {
		this.isComprehensive = isComprehensive;
	}

	public java.lang.String getYear() {
		return year;
	}

	public void setYear(java.lang.String year) {
		this.year = year;
	}

	public java.lang.Integer getAgentId() {
		return agentId;
	}

	public void setAgentId(java.lang.Integer agentId) {
		this.agentId = agentId;
	}

	public java.lang.String getBuildingId() {
		return buildingId;
	}

	public void setBuildingId(java.lang.String buildingId) {
		this.buildingId = buildingId;
	}

	public java.lang.String getMonth() {
		return month;
	}

	public void setMonth(java.lang.String month) {
		this.month = month;
	}

	public java.lang.String getCityId() {
		return cityId;
	}

	public void setCityId(java.lang.String cityId) {
		this.cityId = cityId;
	}

	public java.lang.String getUuId() {
		return uuId;
	}

	public void setUuId(java.lang.String uuId) {
		this.uuId = uuId;
	}

	public java.lang.Integer getSecondAreaId() {
		return secondAreaId;
	}

	public void setSecondAreaId(java.lang.Integer secondAreaId) {
		this.secondAreaId = secondAreaId;
	}

	public java.lang.Integer getDecorationSituation() {
		return decorationSituation;
	}

	public void setDecorationSituation(java.lang.Integer decorationSituation) {
		this.decorationSituation = decorationSituation;
	}

	public java.lang.Integer getSortFlag() {
		return sortFlag;
	}

	public void setSortFlag(java.lang.Integer sortFlag) {
		this.sortFlag = sortFlag;
	}

	public java.lang.Integer getTagId() {
		return tagId;
	}

	public void setTagId(java.lang.Integer tagId) {
		this.tagId = tagId;
	}

	public java.lang.Integer getTotalScore() {
		return totalScore;
	}

	public void setTotalScore(java.lang.Integer totalScore) {
		this.totalScore = totalScore;
	}

	public java.lang.Integer getSwitchStatus() {
		return switchStatus;
	}

	public void setSwitchStatus(java.lang.Integer switchStatus) {
		this.switchStatus = switchStatus;
	}

}
