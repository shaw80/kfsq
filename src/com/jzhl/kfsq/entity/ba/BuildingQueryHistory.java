package com.jzhl.kfsq.entity.ba;

import java.io.Serializable;

/**
 * 
 * BA_BuildingQueryHistory表
 * 
 * @author mew
 *
 */
public class BuildingQueryHistory implements Serializable {
	private static final long serialVersionUID = 3813867168706999296L;
	private java.lang.Integer queryId; // 询查历史Id
	private java.lang.String uuId; // 手机uuid
	private java.lang.Integer memberId; // 询查用户ID
	private java.lang.String queryString; // 询查关键字
	private java.sql.Timestamp createTime; // 操作时间

	public java.lang.Integer getQueryId() {
		return queryId;
	}

	public void setQueryId(java.lang.Integer queryId) {
		this.queryId = queryId;
	}

	public java.lang.String getUuId() {
		return uuId;
	}

	public void setUuId(java.lang.String uuId) {
		this.uuId = uuId;
	}

	public java.lang.Integer getMemberId() {
		return memberId;
	}

	public void setMemberId(java.lang.Integer memberId) {
		this.memberId = memberId;
	}

	public java.lang.String getQueryString() {
		return queryString;
	}

	public void setQueryString(java.lang.String queryString) {
		this.queryString = queryString;
	}

	public java.sql.Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(java.sql.Timestamp createTime) {
		this.createTime = createTime;
	}

	@Override
	public String toString() {
		return "BuildingQueryHistory [queryId=" + queryId + ", uuId=" + uuId + ", memberId=" + memberId + ", queryString=" + queryString
				+ ", createTime=" + createTime + "]";
	}

}