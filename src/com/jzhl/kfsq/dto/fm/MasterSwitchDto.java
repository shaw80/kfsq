package com.jzhl.kfsq.dto.fm;

import java.io.Serializable;

/**
 * 总开关dto
 * @author Shaw
 *
 */
public class MasterSwitchDto implements Serializable {

	private static final long serialVersionUID = 2177978647552883540L;// 序列化
	
	private Integer buildingId;// 楼盘编号
	
	private Integer switchType;// 开关类型（0：评论红包，1：看房红包）

	public Integer getBuildingId() {
		return buildingId;
	}

	public void setBuildingId(Integer buildingId) {
		this.buildingId = buildingId;
	}

	public Integer getSwitchType() {
		return switchType;
	}

	public void setSwitchType(Integer switchType) {
		this.switchType = switchType;
	}

	@Override
	public String toString() {
		return "MasterSwitchDto [buildingId=" + buildingId + ", switchType="
				+ switchType + "]";
	}

}
