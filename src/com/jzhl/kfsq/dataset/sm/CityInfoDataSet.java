package com.jzhl.kfsq.dataset.sm;

import java.io.Serializable;

/**
 * 根据分站编号查询分站城市信息结果集
 * 
 * @author Shaw
 *
 */
public class CityInfoDataSet implements Serializable {

	private static final long serialVersionUID = -291123977494955300L;// 序列化
	
	private Integer areaId;// 区域编号
	
	private String areaName;// 区域名称

	public Integer getAreaId() {
		return areaId;
	}

	public void setAreaId(Integer areaId) {
		this.areaId = areaId;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	@Override
	public String toString() {
		return "CityInfoDataSet [areaId=" + areaId + ", areaName=" + areaName
				+ "]";
	}

}
