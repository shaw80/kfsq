package com.jzhl.kfsq.dataset.mm;

public class AchievementDataSet {
	private String actionTime;
	private String action;
	private String buildingName;
	private String banner;

	public AchievementDataSet() {
		
	}

	public String getActionTime() {
		return actionTime;
	}

	public void setActionTime(String actionTime) {
		this.actionTime = actionTime;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getBuildingName() {
		return buildingName==null ? "" : buildingName;
	}

	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}

	public String getBanner() {
		return banner==null ? "" : banner;
	}

	public void setBanner(String banner) {
		this.banner = banner;
	}
	

}
