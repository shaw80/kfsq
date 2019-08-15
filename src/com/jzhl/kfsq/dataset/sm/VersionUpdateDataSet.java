package com.jzhl.kfsq.dataset.sm;

import java.io.Serializable;

/**
 * 手机端查询版本更新结果集
 * 
 * @author Shaw
 *
 */
public class VersionUpdateDataSet implements Serializable {

	private static final long serialVersionUID = -5975887170578452443L;// 序列化

	private String versionNum;// 版本号

	private Integer updateCode;// 版本编号

	private String versionTitle;// 版本标题

	private String versionInfo;// 版本信息

	private String filePath;// 升级文件路径
	
	private String fileSize;//文件大小

	private Integer isUpdate;// 是否强制更新（0为选择，1为强制更新）

	public String getVersionNum() {
		return versionNum;
	}

	public void setVersionNum(String versionNum) {
		this.versionNum = versionNum;
	}

	public Integer getUpdateCode() {
		return updateCode;
	}

	public void setUpdateCode(Integer updateCode) {
		this.updateCode = updateCode;
	}

	public String getVersionTitle() {
		return versionTitle;
	}

	public void setVersionTitle(String versionTitle) {
		this.versionTitle = versionTitle;
	}

	public String getVersionInfo() {
		return versionInfo;
	}

	public void setVersionInfo(String versionInfo) {
		this.versionInfo = versionInfo;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getFileSize() {
		return fileSize;
	}

	public void setFileSize(String fileSize) {
		this.fileSize = fileSize;
	}

	public Integer getIsUpdate() {
		return isUpdate;
	}

	public void setIsUpdate(Integer isUpdate) {
		this.isUpdate = isUpdate;
	}

	@Override
	public String toString() {
		return "VersionUpdateDataSet [versionNum=" + versionNum
				+ ", updateCode=" + updateCode + ", versionTitle="
				+ versionTitle + ", versionInfo=" + versionInfo + ", filePath="
				+ filePath + ", isUpdate=" + isUpdate + "]";
	}

}
