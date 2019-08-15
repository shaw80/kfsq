package com.jzhl.kfsq.entity.sm;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 户型标签中间关系实体类
 * 
 * @author Shaw
 *
 */
public class UnitMapFeature implements Serializable {

	private static final long serialVersionUID = 4360172379385260851L;// 序列化
	
	private Integer unitMapFeatureId;// 主键
	
	private Integer unitMapId;// 外键，户型图编号
	
	private Integer tagId;// 外键，标签编号
	
	private Timestamp createTime;// 创建时间
	
	private Timestamp updateTime;// 更新时间
	
	private Integer createUserId;// 创建者
	
	private Integer updateUserId;// 更新者
	
	private Integer isValid;// 有效无效（0：无效，1：有效）

	public Integer getUnitMapFeatureId() {
		return unitMapFeatureId;
	}

	public void setUnitMapFeatureId(Integer unitMapFeatureId) {
		this.unitMapFeatureId = unitMapFeatureId;
	}

	public Integer getUnitMapId() {
		return unitMapId;
	}

	public void setUnitMapId(Integer unitMapId) {
		this.unitMapId = unitMapId;
	}

	public Integer getTagId() {
		return tagId;
	}

	public void setTagId(Integer tagId) {
		this.tagId = tagId;
	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public Timestamp getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}

	public Integer getCreateUserId() {
		return createUserId;
	}

	public void setCreateUserId(Integer createUserId) {
		this.createUserId = createUserId;
	}

	public Integer getUpdateUserId() {
		return updateUserId;
	}

	public void setUpdateUserId(Integer updateUserId) {
		this.updateUserId = updateUserId;
	}

	public Integer getIsValid() {
		return isValid;
	}

	public void setIsValid(Integer isValid) {
		this.isValid = isValid;
	}

	@Override
	public String toString() {
		return "UnitMapFeature [unitMapFeatureId=" + unitMapFeatureId
				+ ", unitMapId=" + unitMapId + ", tagId=" + tagId
				+ ", createTime=" + createTime + ", updateTime=" + updateTime
				+ ", createUserId=" + createUserId + ", updateUserId="
				+ updateUserId + ", isValid=" + isValid + "]";
	}

}
