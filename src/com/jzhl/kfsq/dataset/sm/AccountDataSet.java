package com.jzhl.kfsq.dataset.sm;

/**
 * 账户结果集
 * 
 * @author Shaw
 *
 */
public class AccountDataSet {
	
	private int accountId;// 账户编号
	
	private String accountNum;// 账户

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public String getAccountNum() {
		return accountNum;
	}

	public void setAccountNum(String accountNum) {
		this.accountNum = accountNum;
	}

	@Override
	public String toString() {
		return "AccountDataSet [accountId=" + accountId + ", accountNum="
				+ accountNum + "]";
	}

}
