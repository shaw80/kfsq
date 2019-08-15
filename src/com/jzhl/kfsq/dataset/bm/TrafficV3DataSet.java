package com.jzhl.kfsq.dataset.bm;

import java.io.Serializable;

/**
 * 楼盘详情交通结果集
 * 
 * @author Shaw
 *
 */
public class TrafficV3DataSet implements Serializable {

	private static final long serialVersionUID = -1661291912577371460L;// 序列化
	
	private String dimensionName;// 维度名称
	
	private String score;// 分数
	
	private String traffic;// 交通结果集

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

	public String getTraffic() {
		return traffic;
	}

	public void setTraffic(String traffic) {
		this.traffic = traffic;
	}

	@Override
	public String toString() {
		return "TrafficV3DataSet [dimensionName=" + dimensionName + ", score="
				+ score + ", traffic=" + traffic + "]";
	}

}
