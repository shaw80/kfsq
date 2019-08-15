package com.jzhl.kfsq.dto.fm;

import java.io.Serializable;

import com.jzhl.kfsq.common.base.PageListCondition;

/**
 * 提现申请实体类传入参数
 * 
 * @author zhouzy
 *
 */
public class CashApplicationDto extends PageListCondition implements Serializable {

	private static final long serialVersionUID = -9196830101323306260L;
	private java.lang.Integer userId; // 登录代理商ID
	private java.lang.String dateStart; // 自定义时间开始日期
	private java.lang.String dateEnd; // 自定义时间结束时间
	private java.lang.String keyword; // 关键字
	private java.lang.String isDownFlag; // 是否为excel导出

	public java.lang.Integer getUserId() {
		return userId;
	}

	public void setUserId(java.lang.Integer userId) {
		this.userId = userId;
	}

	public java.lang.String getDateStart() {
		return dateStart;
	}

	public void setDateStart(java.lang.String dateStart) {
		this.dateStart = dateStart;
	}

	public java.lang.String getDateEnd() {
		return dateEnd;
	}

	public void setDateEnd(java.lang.String dateEnd) {
		this.dateEnd = dateEnd;
	}

	public java.lang.String getKeyword() {
		return keyword;
	}

	public void setKeyword(java.lang.String keyword) {
		this.keyword = keyword;
	}

	public java.lang.String getIsDownFlag() {
		return isDownFlag;
	}

	public void setIsDownFlag(java.lang.String isDownFlag) {
		this.isDownFlag = isDownFlag;
	}

}
