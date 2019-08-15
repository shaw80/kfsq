package com.jzhl.kfsq.dataset.bm;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.jzhl.kfsq.dto.bm.BuildingEnvelopeDto;

/**
 * 推荐楼盘结果集
 * 
 * @author Shaw
 *
 */
public class RecommendBuildingsDataSet implements Serializable {

	private static final long serialVersionUID = 2559994923385999081L;// 序列化

//	private List<BuildingEnvelopeDto> synthesize = new ArrayList<BuildingEnvelopeDto>();// 综合

	private List<BuildingEnvelopeDto> area = new ArrayList<BuildingEnvelopeDto>();// 同地段

	private List<BuildingEnvelopeDto> price = new ArrayList<BuildingEnvelopeDto>();// 同价位

	private List<BuildingEnvelopeDto> feature = new ArrayList<BuildingEnvelopeDto>();// 同特色

//	public List<BuildingEnvelopeDto> getSynthesize() {
//		return synthesize;
//	}
//
//	public void setSynthesize(List<BuildingEnvelopeDto> synthesize) {
//		this.synthesize = synthesize;
//	}

	public List<BuildingEnvelopeDto> getArea() {
		return area;
	}

	public void setArea(List<BuildingEnvelopeDto> area) {
		this.area = area;
	}

	public List<BuildingEnvelopeDto> getPrice() {
		return price;
	}

	public void setPrice(List<BuildingEnvelopeDto> price) {
		this.price = price;
	}

	public List<BuildingEnvelopeDto> getFeature() {
		return feature;
	}

	public void setFeature(List<BuildingEnvelopeDto> feature) {
		this.feature = feature;
	}

	@Override
	public String toString() {
		return "RecommendBuildingsDataSet [area=" + area + ", price=" + price
				+ ", feature=" + feature + "]";
	}

}
