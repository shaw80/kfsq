package com.jzhl.kfsq.dto.sm;

import java.io.Serializable;

/**
 * 根据分站编号查询分站城市信息DTO
 * 
 * @author Shaw
 *
 */
public class BranchCityDto implements Serializable {

	private static final long serialVersionUID = 6634854435836491599L;// 序列化
	
	private Integer branchId;// 分站编号

	public Integer getBranchId() {
		return branchId;
	}

	public void setBranchId(Integer branchId) {
		this.branchId = branchId;
	}

	@Override
	public String toString() {
		return "BranchCityDto [branchId=" + branchId + "]";
	}

}
