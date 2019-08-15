package com.jzhl.kfsq.dto.pm;

import java.io.Serializable;

/**
 * 销售经理统计dto
 * 
 * @author Shaw
 *
 */
public class SalesManagerCountDto implements Serializable {
	
	private static final long serialVersionUID = 7707061304756754045L;// 序列化
	
	private Integer userId;// 用户编号

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "SalesManagerCountDto [userId=" + userId + "]";
	}

}
