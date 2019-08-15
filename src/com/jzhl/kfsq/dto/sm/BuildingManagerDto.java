package com.jzhl.kfsq.dto.sm;

import java.io.Serializable;

public class BuildingManagerDto implements Serializable {

	private static final long serialVersionUID = -561517859593194406L;// 序列化
	
	private Integer userId;// 用户编号

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "BuildingManagerDto [userId=" + userId + "]";
	}

}
