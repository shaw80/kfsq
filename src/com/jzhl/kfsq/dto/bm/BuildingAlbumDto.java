package com.jzhl.kfsq.dto.bm;

import java.io.Serializable;

import com.jzhl.kfsq.common.base.PageListCondition;

/**
 * 
 * BM_BuildingAlbum表
 * 
 * @author zhouzy
 *
 */
public class BuildingAlbumDto extends PageListCondition implements Serializable {

	private static final long serialVersionUID = 5253066115060608589L;
	private java.lang.Integer albumId; // 相册ID
	private java.lang.Integer buildingId; // 楼盘ID
	private java.lang.Integer type; // 相册类型，1：效果图 2：规划图 3：实景图 4：配套图
	private java.lang.String imgName; // 图片标题
	private java.lang.String path; // 图片路径
	private java.lang.Integer ranking; // 排序
	private java.lang.Integer isValid; // 0：无效，1：有效
	private java.util.Date createTime; // 创建时间
	private java.lang.Integer createUserId; // 创建者编号

	public java.lang.Integer getAlbumId() {
		return albumId;
	}

	public void setAlbumId(java.lang.Integer albumId) {
		this.albumId = albumId;
	}

	public java.lang.Integer getBuildingId() {
		return buildingId;
	}

	public void setBuildingId(java.lang.Integer buildingId) {
		this.buildingId = buildingId;
	}

	public java.lang.Integer getType() {
		return type;
	}

	public void setType(java.lang.Integer type) {
		this.type = type;
	}

	public java.lang.String getImgName() {
		return imgName;
	}

	public void setImgName(java.lang.String imgName) {
		this.imgName = imgName;
	}

	public java.lang.String getPath() {
		return path;
	}

	public void setPath(java.lang.String path) {
		this.path = path;
	}

	public java.lang.Integer getRanking() {
		return ranking;
	}

	public void setRanking(java.lang.Integer ranking) {
		this.ranking = ranking;
	}

	public java.lang.Integer getIsValid() {
		return isValid;
	}

	public void setIsValid(java.lang.Integer isValid) {
		this.isValid = isValid;
	}

	public java.util.Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(java.util.Date createTime) {
		this.createTime = createTime;
	}

	public java.lang.Integer getCreateUserId() {
		return createUserId;
	}

	public void setCreateUserId(java.lang.Integer createUserId) {
		this.createUserId = createUserId;
	}

}