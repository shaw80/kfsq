package com.jzhl.kfsq.dataset.pm;

import java.io.Serializable;

/**
 * 前端是否收藏结果集
 * 
 * @author Shaw
 *
 */
public class FavoriteDataSet implements Serializable {

	private static final long serialVersionUID = -7591247477396116392L;// 序列化

	private String favoriteStatus;// 收藏状态（0：未收藏，1：已收藏）

	private String salerCustomerId;// 客户编号

	public String getFavoriteStatus() {
		return favoriteStatus;
	}

	public void setFavoriteStatus(String favoriteStatus) {
		this.favoriteStatus = favoriteStatus;
	}

	public String getSalerCustomerId() {
		return salerCustomerId;
	}

	public void setSalerCustomerId(String salerCustomerId) {
		this.salerCustomerId = salerCustomerId;
	}

	@Override
	public String toString() {
		return "FavoriteDataSet [favoriteStatus=" + favoriteStatus
				+ ", salerCustomerId=" + salerCustomerId + "]";
	}

}
