package com.jzhl.kfsq.dataset.bm;

import java.io.Serializable;

/**
 * 楼盘详情户型结果集
 * 
 * @author Shaw
 *
 */
public class UnitMapV3DataSet implements Serializable {

	private static final long serialVersionUID = -1050277151330796167L;// 序列化
	
	private String dimensionName;// 维度名称
	
	private String score;// 分数
	
	private String unitMapName;// 户型名称集合

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

	public String getUnitMapName() {
		return unitMapName;
	}

	public void setUnitMapName(String unitMapName) {
		this.unitMapName = unitMapName;
	}

	@Override
	public String toString() {
		return "UnitMapV3DataSet [dimensionName=" + dimensionName + ", score="
				+ score + ", unitMapName=" + unitMapName + "]";
	}

}
