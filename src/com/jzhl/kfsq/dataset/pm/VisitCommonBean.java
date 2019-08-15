package com.jzhl.kfsq.dataset.pm;

import java.io.Serializable;
import java.sql.Timestamp;

import com.jzhl.kfsq.common.util.SystemConfig;

/**
 * 到访业绩实体
 * 
 * @author Shaw
 *
 */
public class VisitCommonBean implements Serializable {

	private static final long serialVersionUID = 2558361996061188280L;// 序列化
	
	private Integer userId;// 用户编号
	
	private Integer rank;// 名次
	
	private String headPortrait;// 个人头像
	
	private String userName;// 用户姓名
	
	private Integer count;// 到访量
	
	private Timestamp maxVisitTime;// 最后到访时间，用于团队查询
	
	private String isSelf;// 是否本人（0：不是，1：是）-- 是否自己的团队，用户团队查询

	public Timestamp getMaxVisitTime() {
		return maxVisitTime;
	}

	public void setMaxVisitTime(Timestamp maxVisitTime) {
		this.maxVisitTime = maxVisitTime;
	}

	public String getIsSelf() {
		return isSelf;
	}

	public void setIsSelf(String isSelf) {
		this.isSelf = isSelf;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getRank() {
		return rank;
	}

	public void setRank(Integer rank) {
		this.rank = rank;
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

	@Override
	public String toString() {
		return "VisitCommonBean [userId=" + userId + ", rank=" + rank
				+ ", headPortrait=" + headPortrait + ", userName=" + userName
				+ ", count=" + count + ", maxVisitTime=" + maxVisitTime
				+ ", isSelf=" + isSelf + "]";
	}

}
