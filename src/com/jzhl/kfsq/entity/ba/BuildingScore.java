package com.jzhl.kfsq.entity.ba;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 楼盘分数实体类
 * 
 * @author Shaw
 *
 */
public class BuildingScore implements Serializable {

	private static final long serialVersionUID = 9065537622766055287L;// 序列化

	private Integer scoreId;// 评分编号
	
	private Integer batchId;// 评分批次编号
	
	private Integer cityId;// 城市编号
	
	private Integer buildingId;// 楼盘编号
	
	private String buildingName;// 楼盘名称
	
	private String unitMapScore;// 户型分数
	
	private String communityScore;// 社区品质分数
	
	private String trafficScore;// 交通评分
	
	private String educationScore;// 教育评分
	
	private String peripheryScore;// 周边配套评分
	
	private String totalScore;// 总评分
	
	private Integer isValid;// 有效无效（0：无效，1：有效）
	
	private Integer creatorUserId;// 创建者编号
	
	private Timestamp createTime;// 创建时间
	
	private Timestamp updateTime;// 更新时间

	public Integer getScoreId() {
		return scoreId;
	}

	public void setScoreId(Integer scoreId) {
		this.scoreId = scoreId;
	}

	public Integer getBatchId() {
		return batchId;
	}

	public void setBatchId(Integer batchId) {
		this.batchId = batchId;
	}

	public Integer getCityId() {
		return cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

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

	public String getUnitMapScore() {
		return unitMapScore;
	}

	public void setUnitMapScore(String unitMapScore) {
		this.unitMapScore = unitMapScore;
	}

	public String getCommunityScore() {
		return communityScore;
	}

	public void setCommunityScore(String communityScore) {
		this.communityScore = communityScore;
	}

	public String getTrafficScore() {
		return trafficScore;
	}

	public void setTrafficScore(String trafficScore) {
		this.trafficScore = trafficScore;
	}

	public String getEducationScore() {
		return educationScore;
	}

	public void setEducationScore(String educationScore) {
		this.educationScore = educationScore;
	}

	public String getPeripheryScore() {
		return peripheryScore;
	}

	public void setPeripheryScore(String peripheryScore) {
		this.peripheryScore = peripheryScore;
	}

	public String getTotalScore() {
		return totalScore;
	}

	public void setTotalScore(String totalScore) {
		this.totalScore = totalScore;
	}

	public Integer getIsValid() {
		return isValid;
	}

	public void setIsValid(Integer isValid) {
		this.isValid = isValid;
	}

	public Integer getCreatorUserId() {
		return creatorUserId;
	}

	public void setCreatorUserId(Integer creatorUserId) {
		this.creatorUserId = creatorUserId;
	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public Timestamp getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}

	@Override
	public String toString() {
		return "BuildingScore [scoreId=" + scoreId + ", batchId=" + batchId
				+ ", cityId=" + cityId + ", buildingId=" + buildingId
				+ ", buildingName=" + buildingName + ", unitMapScore="
				+ unitMapScore + ", communityScore=" + communityScore
				+ ", trafficScore=" + trafficScore + ", educationScore="
				+ educationScore + ", peripheryScore=" + peripheryScore
				+ ", totalScore=" + totalScore + ", isValid=" + isValid
				+ ", creatorUserId=" + creatorUserId + ", createTime="
				+ createTime + ", updateTime=" + updateTime + "]";
	}
	
}
