package com.jzhl.kfsq.dataset.sm;

import java.io.Serializable;

import com.jzhl.kfsq.common.util.SystemConfig;

/**
 * 置业顾问结果集
 * 
 * @author Shaw
 *
 */
public class SalerDataSet implements Serializable {

	private static final long serialVersionUID = -2811021583095470759L;// 序列化
	
	private Integer userId;// 用户编号
	
	private String name;// 姓名
	
	private String headPortrait;// 头像
	
	private String account;// 登录账户
	
	private Integer isValid;// 是否有效（0：无效，1：有效）

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHeadPortrait() {
		if(headPortrait == null || headPortrait.isEmpty()) {
			return "";
		}
		return SystemConfig.getHttpBasePath() + headPortrait;
	}

	public void setHeadPortrait(String headPortrait) {
		this.headPortrait = headPortrait;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public Integer getIsValid() {
		return isValid;
	}

	public void setIsValid(Integer isValid) {
		this.isValid = isValid;
	}

	@Override
	public String toString() {
		return "SalerDataSet [userId=" + userId + ", name=" + name
				+ ", headPortrait=" + headPortrait + ", account=" + account
				+ ", isValid=" + isValid + "]";
	}

}
