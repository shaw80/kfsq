package com.jzhl.kfsq.dto.ba;

import com.jzhl.kfsq.common.base.PageListCondition;

/**
 * 分页查询用户评价参数DTO
 * 
 * @author Shaw
 *
 */
public class MemberEvaluatePageDto extends PageListCondition {
	
	private String dimensionCode;// 维度编码
	
	private Integer buildingId;// 楼盘编号

	public String getDimensionCode() {
		return dimensionCode;
	}

	public void setDimensionCode(String dimensionCode) {
		this.dimensionCode = dimensionCode;
	}

	public Integer getBuildingId() {
		return buildingId;
	}

	public void setBuildingId(Integer buildingId) {
		this.buildingId = buildingId;
	}

}
