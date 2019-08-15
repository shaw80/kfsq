package com.jzhl.kfsq.dto.pm;

import java.io.Serializable;

/**
 * 客户到访查询Dto
 * 
 * @author Shaw
 *
 */
public class IsVisitDto implements Serializable {

	private static final long serialVersionUID = -5133400653536816901L;// 序列化
	
	private Integer memberId;// 会员编号
	
	private Integer buildingId;// 楼盘编号

	public Integer getMemberId() {
		return memberId;
	}

	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}

	public Integer getBuildingId() {
		return buildingId;
	}

	public void setBuildingId(Integer buildingId) {
		this.buildingId = buildingId;
	}

	@Override
	public String toString() {
		return "IsVisitDto [memberId=" + memberId + ", buildingId="
				+ buildingId + "]";
	}

}
