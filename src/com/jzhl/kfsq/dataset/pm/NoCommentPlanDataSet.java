package com.jzhl.kfsq.dataset.pm;



/**
 * 待发表看房圈评论的计划实体类
 * 
 * @author Shaw
 *
 */
public class NoCommentPlanDataSet {
	
	private Integer buildingId;// 楼盘编号
	
	private String buildingName;// 楼盘名称
	
	private String buildingImg;// 楼盘图片
	
	private String planTime;// 看房时间

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
		return buildingImg;
	}
	
	public String getSmallBuildingImg() {
		if(buildingImg == null || buildingImg.isEmpty() || !buildingImg.contains(".")) {
			return "";
		}
		String imageName = buildingImg.substring(0, buildingImg.lastIndexOf("."));
		String extName = buildingImg.substring(buildingImg.lastIndexOf(".") + 1);
		return imageName + "_small." + extName;
	}	

	public void setBuildingImg(String buildingImg) {
		this.buildingImg = buildingImg;
	}

	public String getPlanTime() {
		return planTime;
	}

	public void setPlanTime(String planTime) {
		this.planTime = planTime;
	}
	
}
