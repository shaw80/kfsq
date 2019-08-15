package com.jzhl.kfsq.dto.sm;

import java.io.Serializable;

/**
 * 置业顾问dto
 * 
 * @author Shaw
 *
 */
public class SalerDto implements Serializable {

	private static final long serialVersionUID = 858214909866294039L;
	
	private Integer userId;// 用户编号
	
	private String isValid;// 是否有效（0：无效，1：有效）

	public String getIsValid() {
		return isValid;
	}

	public void setIsValid(String isValid) {
		this.isValid = isValid;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "SalerDto [userId=" + userId + ", isValid=" + isValid + "]";
	}

}
