package com.jzhl.kfsq.dataset.sm;

import java.io.Serializable;

/**
 * 特色结果集
 * 
 * @author Shaw
 *
 */
public class FeatureDataSet implements Serializable {

	private static final long serialVersionUID = -6509749935127225397L;// 序列化

	private Integer featureId;// 特色编号

	private String featureName;// 特色名称

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

	@Override
	public String toString() {
		return "FeatureDataSet [featureId=" + featureId + ", featureName="
				+ featureName + "]";
	}

}
