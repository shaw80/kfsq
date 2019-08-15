package com.jzhl.kfsq.dto.sm;

import java.io.Serializable;

/**
 * 添加置业顾问dto
 * 
 * @author Shaw
 *
 */
public class SalerInsertDto implements Serializable {

	private static final long serialVersionUID = 7612206598887908934L;// 序列化
	
	private Integer leaderUserId;// 领导编号
	
	private String account;// 账户
	
	private String password;// 密码
	
	private String name;// 名字
	
	private Integer branchId;

	public Integer getLeaderUserId() {
		return leaderUserId;
	}

	public void setLeaderUserId(Integer leaderUserId) {
		this.leaderUserId = leaderUserId;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getBranchId() {
		return branchId;
	}

	public void setBranchId(Integer branchId) {
		this.branchId = branchId;
	}

	@Override
	public String toString() {
		return "SalerInsertDto [leaderUserId=" + leaderUserId + ", account="
				+ account + ", password=" + password + ", name=" + name + "]";
	}
	
}
