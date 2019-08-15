package com.jzhl.kfsq.dataset.bm;

import java.io.Serializable;

public class BuildingFeatureMsgDataSet implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Integer featureId;
	private String featureName;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getFeatureId() {
		return featureId;
	}
	public void setFeatureId(Integer featureId) {
		this.featureId = featureId;
	}
	public String getFeatureName() {
		return featureName;
	}
	public void setFeatureName(String featureName) {
		this.featureName = featureName;
	}
}
