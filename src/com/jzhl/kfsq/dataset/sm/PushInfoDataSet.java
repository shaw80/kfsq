package com.jzhl.kfsq.dataset.sm;

import java.io.Serializable;

/**
 * 通知（推送信息）结果集
 * 
 * @author Shaw
 *
 */
public class PushInfoDataSet implements Serializable {

	private static final long serialVersionUID = -2047160419992442837L;// 序列化
	
	private int pushId;// 推送编号
	
	private String title;// 标题
	
	private String content;// 内容
	
	private String pushTime;// 推送时间

	public int getPushId() {
		return pushId;
	}

	public void setPushId(int pushId) {
		this.pushId = pushId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getPushTime() {
		return pushTime;
	}

	public void setPushTime(String pushTime) {
		this.pushTime = pushTime;
	}

	@Override
	public String toString() {
		return "PushInfoDataSet [pushId=" + pushId + ", title=" + title
				+ ", content=" + content + ", pushTime=" + pushTime + "]";
	}

}
