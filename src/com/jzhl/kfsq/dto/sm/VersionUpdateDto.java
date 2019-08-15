package com.jzhl.kfsq.dto.sm;

import java.io.Serializable;

/**
 * 
 * SM_VersionUpdate表
 * 
 * @author zhouzy
 *
 */
public class VersionUpdateDto implements Serializable {
	private static final long serialVersionUID = 2477238526634895928L;
	private java.lang.Integer versionId; // 主键
	private java.lang.String versionNum; // 版本号
	private java.lang.Integer updateCode; // 升级编码
	private java.lang.String filePath; // 升级文件路径
	private java.lang.String fileSize; // 上传apk文件大小
	private java.lang.Short isPush; // 是否推送（0：默认推送，1：不推送）
	private java.lang.Short isUpdate; // 是否强制更新0不是1是
	private java.lang.Integer type; // 类型（1：iOS C端，2：iOS B端，3：android // C端，4：android B端）
	private java.lang.String versionTitle; // 版本标题
	private java.lang.String versionInfo; // 版本信息
	private java.lang.Integer creatorUserId; // 创建人编号
	private java.util.Date createTime; // 创建时间
	private java.lang.Short isValid; // 是否有效（0：无效，1：有效）

	public java.lang.Integer getVersionId() {
		return versionId;
	}

	public void setVersionId(java.lang.Integer versionId) {
		this.versionId = versionId;
	}

	public java.lang.String getVersionNum() {
		return versionNum;
	}

	public void setVersionNum(java.lang.String versionNum) {
		this.versionNum = versionNum;
	}

	public java.lang.Integer getUpdateCode() {
		return updateCode;
	}

	public void setUpdateCode(java.lang.Integer updateCode) {
		this.updateCode = updateCode;
	}

	public java.lang.String getFilePath() {
		return filePath;
	}

	public void setFilePath(java.lang.String filePath) {
		this.filePath = filePath;
	}
	
	public java.lang.String getFileSize() {
		return fileSize;
	}

	public void setFileSize(java.lang.String fileSize) {
		this.fileSize = fileSize;
	}

	public java.lang.Short getIsPush() {
		return isPush;
	}

	public void setIsPush(java.lang.Short isPush) {
		this.isPush = isPush;
	}

	public java.lang.Short getIsUpdate() {
		return isUpdate;
	}

	public void setIsUpdate(java.lang.Short isUpdate) {
		this.isUpdate = isUpdate;
	}

	public java.lang.Integer getType() {
		return type;
	}

	public void setType(java.lang.Integer type) {
		this.type = type;
	}

	public java.lang.String getVersionTitle() {
		return versionTitle;
	}

	public void setVersionTitle(java.lang.String versionTitle) {
		this.versionTitle = versionTitle;
	}

	public java.lang.String getVersionInfo() {
		return versionInfo;
	}

	public void setVersionInfo(java.lang.String versionInfo) {
		this.versionInfo = versionInfo;
	}

	public java.lang.Integer getCreatorUserId() {
		return creatorUserId;
	}

	public void setCreatorUserId(java.lang.Integer creatorUserId) {
		this.creatorUserId = creatorUserId;
	}

	public java.util.Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(java.util.Date createTime) {
		this.createTime = createTime;
	}

	public java.lang.Short getIsValid() {
		return isValid;
	}

	public void setIsValid(java.lang.Short isValid) {
		this.isValid = isValid;
	}

	@Override
	public String toString() {
		return "VersionUpdateDto [versionId=" + versionId + ", versionNum=" + versionNum + ", updateCode=" + updateCode + ", filePath="
				+ filePath + ", fileSize=" + fileSize + ", isPush=" + isPush + ", isUpdate=" + isUpdate + ", type=" + type
				+ ", versionTitle=" + versionTitle + ", versionInfo=" + versionInfo + ", creatorUserId=" + creatorUserId + ", createTime="
				+ createTime + ", isValid=" + isValid + "]";
	}

}