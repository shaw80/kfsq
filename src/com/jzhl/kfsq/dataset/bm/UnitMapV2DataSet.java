package com.jzhl.kfsq.dataset.bm;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.jzhl.kfsq.common.util.SystemConfig;
import com.jzhl.kfsq.dataset.sm.FeatureTagDataSet;

/**
 * 户型图结果集
 * 
 * @author Shaw
 *
 */
public class UnitMapV2DataSet implements Serializable {

	private static final long serialVersionUID = 3109515443903541675L;// 序列化

	private Integer unitMapId;// 户型编号

	private String imgName;// 图片名称（户型名称）

	private String imgDes;// 图片描述

	private String acreage;// 面积

	private String totalPrice;// 总价

	private String path;// 户型图
	
	private String turned;// 朝向（0：南北，1：东西）

	private String decorationSituation;// 装修情况（0：毛坯，1：精装）

	private String roomRate;// 得房率，百分比

	private List<FeatureTagDataSet> tags = new ArrayList<FeatureTagDataSet>();// 户型标签集合

	public Integer getUnitMapId() {
		return unitMapId;
	}

	public void setUnitMapId(Integer unitMapId) {
		this.unitMapId = unitMapId;
	}

	public String getImgName() {
		return imgName;
	}

	public void setImgName(String imgName) {
		this.imgName = imgName;
	}

	public String getImgDes() {
		return imgDes;
	}

	public void setImgDes(String imgDes) {
		this.imgDes = imgDes;
	}

	public String getAcreage() {
		return acreage;
	}

	public void setAcreage(String acreage) {
		this.acreage = acreage;
	}

	public String getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(String totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getPath() {
		if(path == null || "".equals(path)) {
			return "";
		}
		return SystemConfig.getHttpBasePath() + path;
	}
	
	public String getSmallPath() {
		if(path == null || "".equals(path)) {
			return "";
		}
		// String imageName = path.substring(0, path.lastIndexOf("."));
		// String extName = path.substring(path.lastIndexOf(".") + 1);
		// return SystemConfig.getHttpBasePath() + (imageName + "_small." +
		// extName);
		return SystemConfig.getHttpBasePath() + path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getTurned() {
		return turned;
	}

	public void setTurned(String turned) {
		this.turned = turned;
	}

	public String getDecorationSituation() {
		return decorationSituation;
	}

	public void setDecorationSituation(String decorationSituation) {
		this.decorationSituation = decorationSituation;
	}

	public String getRoomRate() {
		return roomRate;
	}

	public void setRoomRate(String roomRate) {
		this.roomRate = roomRate;
	}

	public List<FeatureTagDataSet> getTags() {
		return tags;
	}

	public void setTags(List<FeatureTagDataSet> tags) {
		this.tags = tags;
	}

	@Override
	public String toString() {
		return "UnitMapV2DataSet [unitMapId=" + unitMapId + ", imgName="
				+ imgName + ", imgDes=" + imgDes + ", acreage=" + acreage
				+ ", totalPrice=" + totalPrice + ", path=" + path + ", turned="
				+ turned + ", decorationSituation=" + decorationSituation
				+ ", roomRate=" + roomRate + ", tags=" + tags + "]";
	}

}
