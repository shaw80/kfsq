package com.jzhl.kfsq.dataset.pm;

import java.io.Serializable;
import java.sql.Timestamp;

public class SalesDirectoVisitDataSet implements Serializable {
	private static final long serialVersionUID = 8600435958259819298L;
	private Integer rank; // 排名
	private Integer userId;// 用户编号
	private String headPortrait;// 个人头像
	private String userName;// 用户姓名
	private Integer count;// 到访量
	private Timestamp maxVisitTime;// 最后到访时间，用于团队查询
	public Integer getRank() {
		return rank;
	}

	public void setRank(Integer rank) {
		this.rank = rank;
	}
	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getHeadPortrait() {
		return headPortrait;
	}

	public void setHeadPortrait(String headPortrait) {
		this.headPortrait = headPortrait;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Timestamp getMaxVisitTime() {
		return maxVisitTime;
	}

	public void setMaxVisitTime(Timestamp maxVisitTime) {
		this.maxVisitTime = maxVisitTime;
	}
	
}
