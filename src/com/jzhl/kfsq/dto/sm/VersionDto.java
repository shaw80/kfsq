package com.jzhl.kfsq.dto.sm;

import java.io.Serializable;

public class VersionDto implements Serializable {

	private static final long serialVersionUID = -3657082716142353830L;// 序列化
	
	private String versionCode;// 版本编码
	
	private String type;// 类型（1：iOS C端，2：iOS B端，3：android C端，4：android B端）

	public String getVersionCode() {
		return versionCode;
	}

	public void setVersionCode(String versionCode) {
		this.versionCode = versionCode;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "VersionDto [versionCode=" + versionCode + ", type=" + type
				+ "]";
	}

}
