package com.jzhl.kfsq.dto.sm;

import java.io.Serializable;

/**
 * 推送信息查询dto
 * 
 * @author Shaw
 *
 */
public class PushInfoGetDto implements Serializable {

	private static final long serialVersionUID = -4287578408658799094L;

	private String pushId;// 推送编号

	public String getPushId() {
		return pushId;
	}

	public void setPushId(String pushId) {
		this.pushId = pushId;
	}

	@Override
	public String toString() {
		return "PushInfoGetDto [pushId=" + pushId + "]";
	}

}
