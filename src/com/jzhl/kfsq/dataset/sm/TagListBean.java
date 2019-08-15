package com.jzhl.kfsq.dataset.sm;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * SM_Tag表
 * 
 * @author zhouzy
 * @tagType签标类型 @ 1 用户标签、2 房源标签、3 楼盘标签、4 户型标签、5 园区配套标签、6 娱乐设施标签、 7周边商业标签、
 *              8周边环境标签、 9周边不利因素标签'
 */
public class TagListBean implements Serializable {

	private static final long serialVersionUID = 1116277815755620151L;

	private List<TagDataSet> buildingTagList = new ArrayList<TagDataSet>(); // 楼盘标签
	private List<TagDataSet> houseTypeList = new ArrayList<TagDataSet>(); // 户型标签
	private List<TagDataSet> gardenSupportList = new ArrayList<TagDataSet>(); // 园区配套标签
	private List<TagDataSet> entertainmentSupportList = new ArrayList<TagDataSet>(); // 娱乐设施标签
	private List<TagDataSet> surroundSupportList = new ArrayList<TagDataSet>(); // 周边商业标签
	private List<TagDataSet> surroundEnvironmentList = new ArrayList<TagDataSet>(); // 周边环境标签
	private List<TagDataSet> surroundDisadvantageList = new ArrayList<TagDataSet>(); // 周边不利因素标签

	public List<TagDataSet> getBuildingTagList() {
		return buildingTagList;
	}

	public void setBuildingTagList(List<TagDataSet> buildingTagList) {
		this.buildingTagList = buildingTagList;
	}

	public List<TagDataSet> getHouseTypeList() {
		return houseTypeList;
	}

	public void setHouseTypeList(List<TagDataSet> houseTypeList) {
		this.houseTypeList = houseTypeList;
	}

	public List<TagDataSet> getGardenSupportList() {
		return gardenSupportList;
	}

	public void setGardenSupportList(List<TagDataSet> gardenSupportList) {
		this.gardenSupportList = gardenSupportList;
	}

	public List<TagDataSet> getEntertainmentSupportList() {
		return entertainmentSupportList;
	}

	public void setEntertainmentSupportList(List<TagDataSet> entertainmentSupportList) {
		this.entertainmentSupportList = entertainmentSupportList;
	}

	public List<TagDataSet> getSurroundSupportList() {
		return surroundSupportList;
	}

	public void setSurroundSupportList(List<TagDataSet> surroundSupportList) {
		this.surroundSupportList = surroundSupportList;
	}

	public List<TagDataSet> getSurroundEnvironmentList() {
		return surroundEnvironmentList;
	}

	public void setSurroundEnvironmentList(List<TagDataSet> surroundEnvironmentList) {
		this.surroundEnvironmentList = surroundEnvironmentList;
	}

	public List<TagDataSet> getSurroundDisadvantageList() {
		return surroundDisadvantageList;
	}

	public void setSurroundDisadvantageList(List<TagDataSet> surroundDisadvantageList) {
		this.surroundDisadvantageList = surroundDisadvantageList;
	}

}