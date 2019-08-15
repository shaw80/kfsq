package com.jzhl.kfsq.dto.sm;

import java.io.Serializable;
import java.sql.Date;

/**
 * 内容信息实体类
 * 
 * @author zhouzy
 *
 */
public class ContentInfoDto implements Serializable {

	private static final long serialVersionUID = -619921817049962585L;// 序列化

	private Integer contentId;// 内容编号

	private Integer contentType;// 内容类型（0：提现说明，1：关于我们）

	private String contentTypeName;// 内容类型名称

	private String contentKey;// 内容关键字

	private String contentValue;// 内容

	private Integer creatorUserId;// 创建人编号

	private Date createTime;// 创建时间

	private Integer updateUserId;// 更新人编号

	private Date updateTime;// 更新时间

	private Integer isValid; // '0：无效，1：有效'

	public Integer getContentId() {
		return contentId;
	}

	public void setContentId(Integer contentId) {
		this.contentId = contentId;
	}

	public Integer getContentType() {
		return contentType;
	}

	public void setContentType(Integer contentType) {
		this.contentType = contentType;
	}

	public String getContentTypeName() {
		return contentTypeName;
	}

	public void setContentTypeName(String contentTypeName) {
		this.contentTypeName = contentTypeName;
	}

	public String getContentKey() {
		return contentKey;
	}

	public void setContentKey(String contentKey) {
		this.contentKey = contentKey;
	}

	public String getContentValue() {
		return contentValue;
	}

	public void setContentValue(String contentValue) {
		this.contentValue = contentValue;
	}

	public Integer getCreatorUserId() {
		return creatorUserId;
	}

	public void setCreatorUserId(Integer creatorUserId) {
		this.creatorUserId = creatorUserId;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Integer getUpdateUserId() {
		return updateUserId;
	}

	public void setUpdateUserId(Integer updateUserId) {
		this.updateUserId = updateUserId;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Integer getIsValid() {
		return isValid;
	}

	public void setIsValid(Integer isValid) {
		this.isValid = isValid;
	}

	@Override
	public String toString() {
		return "ContentInfoDto [contentId=" + contentId + ", contentType=" + contentType + ", contentTypeName=" + contentTypeName
				+ ", contentKey=" + contentKey + ", contentValue=" + contentValue + ", creatorUserId=" + creatorUserId + ", createTime="
				+ createTime + ", updateUserId=" + updateUserId + ", updateTime=" + updateTime + ", isValid=" + isValid + "]";
	}

}
