package com.jzhl.kfsq.dataset.pm;

import java.sql.Timestamp;

import com.jzhl.kfsq.common.util.SystemConfig;

/**
 * 待发表看房圈评论接收数据访问层结果实体结果集
 * 
 * @author Shaw
 *
 */
public class NoCommentPlanReveiceDataSet {
	
	private Integer buildingId;// 楼盘编号
	
	private String buildingName;// 楼盘名称
	
	private String buildingImg;// 楼盘图片
	
	private Timestamp planTime;// 看房时间

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

	public String getBuildingImg() {
		if(buildingImg == null || buildingImg.isEmpty()) {
			return "";
		}
		return SystemConfig.getHttpBasePath() + buildingImg;
	}
	
	public String getSmallBuildingImg() {
		if(buildingImg == null || buildingImg.isEmpty() || !buildingImg.contains(".")) {
			return "";
		}
		String imageName = buildingImg.substring(0, buildingImg.lastIndexOf("."));
		String extName = buildingImg.substring(buildingImg.lastIndexOf(".") + 1);
		return SystemConfig.getHttpBasePath() + (imageName + "_small." + extName);
	}

	public void setBuildingImg(String buildingImg) {
		this.buildingImg = buildingImg;
	}

	public Timestamp getPlanTime() {
		return planTime;
	}

	public void setPlanTime(Timestamp planTime) {
		this.planTime = planTime;
	}

}
