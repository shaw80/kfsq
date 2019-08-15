package com.jzhl.kfsq.dto.sm;

import java.io.Serializable;

/**
 * 手机端查询版本更新DTO
 * 
 * @author Shaw
 *
 */
public class VersionAppDto implements Serializable {

	private static final long serialVersionUID = -7645513735986765815L;// 序列化

	private Integer versionCode;// 版本编码

	private Integer type;// 类型（1：iOS C端，2：iOS B端，3：android C端，4：android B端）

	public Integer getVersionCode() {
		return versionCode;
	}

	public void setVersionCode(Integer versionCode) {
		this.versionCode = versionCode;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "VersionAppDto [versionCode=" + versionCode + ", type=" + type
				+ "]";
	}

}
