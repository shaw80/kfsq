package com.jzhl.kfsq.dataset.bm;

import java.io.Serializable;

/**
 * 楼盘详情社区品质结果集
 * 
 * @author Shaw
 *
 */
public class CommunityQualityV3DataSet implements Serializable {

	private static final long serialVersionUID = 4558411963164625646L;// 序列化
	
	private String dimensionName;// 维度名称
	
	private String score;// 分数
	
	private String communityQuality;// 开发商
	
	public String getDimensionName() {
		return dimensionName;
	}

	public void setDimensionName(String dimensionName) {
		this.dimensionName = dimensionName;
	}

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}

	public String getCommunityQuality() {
		return communityQuality;
	}

	public void setCommunityQuality(String communityQuality) {
		this.communityQuality = communityQuality;
	}

	@Override
	public String toString() {
		return "CommunityQualityV3DataSet [dimensionName=" + dimensionName
				+ ", score=" + score + ", communityQuality=" + communityQuality
				+ "]";
	}

}
