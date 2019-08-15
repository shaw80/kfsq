package com.jzhl.kfsq.common.base;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.jzhl.kfsq.common.constant.RedisConstant;
import com.jzhl.kfsq.common.util.ValidateUtil;

/**
 * 前端响应结果集
 * 
 * @author Shaw
 * @param <T>
 *
 */
public class ResponseBean<T> implements Serializable {

	private static final long serialVersionUID = -6471751281368806190L;

	private static String FAIL = "0";

	private static String SUCCESS = "1";

	@JsonProperty(value = "status")
	private String status = SUCCESS; // 状态0失败,1成功

	@JsonProperty(value = "msg")
	private String msg = ""; // 当状态是1的时候，“操作成功”，若是0的时候，里面是其它的各种错误信息
	
	@JsonProperty(value = "ciosLastVersion")
	private Integer ciosLastVersion; 	
	
	@JsonProperty(value = "biosLastVersion")
	private Integer biosLastVersion; 	
	
	@JsonProperty(value = "candroidLastVersion")
	private Integer candroidLastVersion; 	
	
	@JsonProperty(value = "bandroidLastVersion")
	private Integer bandroidLastVersion;	

	@JsonProperty(value = "jsonData")
	private T jsonData;

	public ResponseBean() {
		super();
		this.initVersionInfo();
	}

	public ResponseBean(T jsonData) {
		super();
		this.initVersionInfo();		
		this.jsonData = jsonData;
	}

	public void operateSuccess() {
		this.status = SUCCESS;
	}
	
	public void operateSuccess(String msg) {
		this.status = SUCCESS;
		this.msg = msg;
	}

	public void operateFail(String msg) {
		this.status = FAIL;
		this.msg = msg;
	}

	public String getStatus() {
		return status;
	}

	public String getMsg() {
		return msg;
	}

	public Integer getCiosLastVersion() {
		return ciosLastVersion;
	}

	public Integer getBiosLastVersion() {
		return biosLastVersion;
	}

	public Integer getCandroidLastVersion() {
		return candroidLastVersion;
	}

	public Integer getBandroidLastVersion() {
		return bandroidLastVersion;
	}

	public T getJsonData() {
		return jsonData;
	}

	public void setJsonData(T jsonData) {
		this.jsonData = jsonData;
	}

	@Override
	public String toString() {
		return "ResponseBean [status=" + status + ", msg=" + msg
				+ ", jsonData=" + jsonData + "]";
	}	
	
	private void initVersionInfo() {

		String CIOSLastVersion = RedisOperator
				.loadValue(RedisConstant.KEY_IOS_C_LAST_VERSION);
		this.ciosLastVersion = ValidateUtil.isEmpty(CIOSLastVersion)
				|| "null".equals(CIOSLastVersion) ? 0 : Integer
				.parseInt(CIOSLastVersion);

		String BIOSLastVersion = RedisOperator
				.loadValue(RedisConstant.KEY_IOS_B_LAST_VERSION);
		this.biosLastVersion = ValidateUtil.isEmpty(BIOSLastVersion)
				|| "null".equals(BIOSLastVersion) ? 0 : Integer
				.parseInt(BIOSLastVersion);

		String CAndroidLastVersion = RedisOperator
				.loadValue(RedisConstant.KEY_ANDROID_C_LAST_VERSION);
		this.candroidLastVersion = ValidateUtil.isEmpty(CAndroidLastVersion)
				|| "null".equals(CAndroidLastVersion) ? 0 : Integer
				.parseInt(CAndroidLastVersion);

		String BAndroidLastVersion = RedisOperator
				.loadValue(RedisConstant.KEY_ANDROID_B_LAST_VERSION);
		this.bandroidLastVersion = ValidateUtil.isEmpty(BAndroidLastVersion)
				|| "null".equals(BAndroidLastVersion) ? 0 : Integer
				.parseInt(BAndroidLastVersion);

	}

}