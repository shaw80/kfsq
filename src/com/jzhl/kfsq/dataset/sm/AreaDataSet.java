package com.jzhl.kfsq.dataset.sm;

import java.io.Serializable;

/**
 * App首页查询列表的区域查询条件结果集
 * 
 * @author Shaw
 *
 */
public class AreaDataSet implements Serializable {

	private static final long serialVersionUID = -1887569836418682606L;// 序列化

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
		return "AreaDataSet [areaId=" + areaId + ", areaName=" + areaName + "]";
	}

}
