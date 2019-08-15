package com.jzhl.kfsq.dto.bm;

import com.jzhl.kfsq.common.base.PageListCondition;

public class UnitMapScoreDetailDto extends PageListCondition {
	
	private int buildingId;// 楼盘编号

	public int getBuildingId() {
		return buildingId;
	}

	public void setBuildingId(int buildingId) {
		this.buildingId = buildingId;
	}

}
