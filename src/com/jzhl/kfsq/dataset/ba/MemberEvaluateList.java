package com.jzhl.kfsq.dataset.ba;

import java.io.Serializable;

import com.jzhl.kfsq.common.util.SystemConfig;

/**
 * 用户评价结果集
 * 
 * @author Shaw
 *
 */
public class MemberEvaluateList implements Serializable {

	private static final long serialVersionUID = 17304187630848106L;// 序列化
	
	private String headPortrait;// 头像
	
	private String nickName;// 昵称
	
	private Integer dimensionValue;// 分数

	public String getHeadPortrait() {
		if(headPortrait == null || "".equals(headPortrait)) {
			return "";
		}
		return SystemConfig.getHttpBasePath() + headPortrait;
	}

	public void setHeadPortrait(String headPortrait) {
		this.headPortrait = headPortrait;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public Integer getDimensionValue() {
		return dimensionValue;
	}

	public void setDimensionValue(Integer dimensionValue) {
		this.dimensionValue = dimensionValue;
	}

}
