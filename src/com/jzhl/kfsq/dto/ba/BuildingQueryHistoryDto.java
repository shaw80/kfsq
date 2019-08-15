package com.jzhl.kfsq.dto.ba;

import java.io.Serializable;

/**
 * 
 * BA_BuildingQueryHistory表
 * 
 * @author mew
 *
 */
public class BuildingQueryHistoryDto implements Serializable {
	private static final long serialVersionUID = 3813867168706999296L;
	private java.lang.Integer queryid; // 询查历史Id
	private java.lang.String uuid; // 手机uuid
	private java.lang.Integer memberid; // 询查用户ID
	private java.lang.String querystring; // 询查关键字
	private java.util.Date createtime; // 操作时间

	public java.lang.Integer getQueryid() {
		return queryid;
	}

	public void setQueryid(java.lang.Integer queryid) {
		this.queryid = queryid;
	}

	public java.lang.String getUuid() {
		return uuid;
	}

	public void setUuid(java.lang.String uuid) {
		this.uuid = uuid;
	}

	public java.lang.Integer getMemberid() {
		return memberid;
	}

	public void setMemberid(java.lang.Integer memberid) {
		this.memberid = memberid;
	}

	public java.lang.String getQuerystring() {
		return querystring;
	}

	public void setQuerystring(java.lang.String querystring) {
		this.querystring = querystring;
	}

	public java.util.Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(java.util.Date createtime) {
		this.createtime = createtime;
	}

	@Override
	public String toString() {
		return "BuildingQueryHistoryDto [queryid=" + queryid + ", uuid=" + uuid + ", memberid=" + memberid + ", querystring=" + querystring
				+ ", createtime=" + createtime + "]";
	}

}