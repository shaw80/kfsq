package com.jzhl.kfsq.dto.pm;

import java.io.Serializable;

/**
 * 收藏写入数据库DTO
 * 
 * @author Shaw
 *
 */
public class FavoriteDBDto implements Serializable {

	private static final long serialVersionUID = 451313338055373089L;// 序列化
	private Integer isFavorite;
	private Integer userId;
	private Integer salerCustomerId;

	public Integer getIsFavorite() {
		return isFavorite;
	}

	public void setIsFavorite(Integer isFavorite) {
		this.isFavorite = isFavorite;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getSalerCustomerId() {
		return salerCustomerId;
	}

	public void setSalerCustomerId(Integer salerCustomerId) {
		this.salerCustomerId = salerCustomerId;
	}

	@Override
	public String toString() {
		return "FavoriteDBDto [isFavorite=" + isFavorite + ", userId=" + userId
				+ ", salerCustomerId=" + salerCustomerId + "]";
	}

}
