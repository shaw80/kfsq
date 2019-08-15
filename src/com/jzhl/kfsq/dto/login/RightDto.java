package com.jzhl.kfsq.dto.login;

import java.io.Serializable;

/**
 * shiro底层权限查询服务dto
 * 
 * @author Shaw
 *
 */
public class RightDto implements Serializable {

	private static final long serialVersionUID = -3411873924848521123L;// 序列化

	private Integer rightId;// 权限编号

	public Integer getRightId() {
		return rightId;
	}

	public void setRightId(Integer rightId) {
		this.rightId = rightId;
	}

	@Override
	public String toString() {
		return "RightDto [rightId=" + rightId + "]";
	}

}
