package com.jzhl.kfsq.common.dataset;

import java.io.Serializable;

import com.jzhl.kfsq.common.util.SystemConfig;

public class FtpBean implements Serializable {
	
	private static final long serialVersionUID = 94709073862039162L;
	
	private java.lang.String path;

	public void setPath(java.lang.String path) {
		this.path = path;
	}

	public java.lang.String getPath() {
		return path == null ? "" : path;
	}

	public java.lang.String getHttpPath() {
		if (path == null || path.isEmpty()) {
			return "";
		}
		return SystemConfig.getHttpBasePath() + path;
	}

}
