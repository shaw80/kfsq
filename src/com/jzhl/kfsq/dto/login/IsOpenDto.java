package com.jzhl.kfsq.dto.login;

import java.io.Serializable;

/**
 * 查询分站城市是否开通DTO
 * 
 * @author Shaw
 *
 */
public class IsOpenDto implements Serializable {

	private static final long serialVersionUID = 4314666133410784025L;// 序列化
	
	private Integer branchId;// 分站编号

	public Integer getBranchId() {
		return branchId;
	}

	public void setBranchId(Integer branchId) {
		this.branchId = branchId;
	}

	@Override
	public String toString() {
		return "IsOpenDto [branchId=" + branchId + "]";
	}

}
