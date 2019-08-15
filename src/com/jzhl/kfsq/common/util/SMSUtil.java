package com.jzhl.kfsq.common.util;

import java.util.HashMap;

import org.apache.log4j.Logger;

import com.cloopen.rest.sdk.CCPRestSmsSDK;
import com.jzhl.kfsq.entity.sm.SMSInfo;

/**
 * 短信发送工具类
 * @author henan
 */
public class SMSUtil {
	
	public static final Logger logger = Logger.getLogger(SMSUtil.class);
	
	public static final String SUCCESS = "000000";
	private static final String SERVER_IP = SMSConfig.getServerIp();
	private static final String PORT = "" + SMSConfig.getPort();
	private static final String ACOUNT_SID = SMSConfig.getAcountSid();
	private static final String AUTH_TOKEN = SMSConfig.getAuthToken();
	private static final String APP_ID = SMSConfig.getAppId();
	
//	public static SMSInfo sendSM(SMSInfo smsInfo) {
//		smsInfo.setStatusCode(SUCCESS);
//		return smsInfo;
//	}
	
	@SuppressWarnings("unchecked")
	public static SMSInfo sendSM(SMSInfo smsInfo) {
		
		logger.debug("[短信发送]--手机号：" + smsInfo.getMobilePhone());
		
		HashMap<String, Object> result = null;

		//初始化SDK
		CCPRestSmsSDK restAPI = new CCPRestSmsSDK();
		// 初始化服务器地址和端口                                                       *
		restAPI.init(SERVER_IP, PORT);
		// 初始化主帐号和主帐号令牌,对应官网开发者主账号下的ACCOUNT SID和AUTH TOKEN     *
		restAPI.setAccount(ACOUNT_SID, AUTH_TOKEN);
		// 初始化应用ID    
		restAPI.setAppId(APP_ID);
		// 发送短信
		result = restAPI.sendTemplateSMS(smsInfo.getMobilePhone(), smsInfo.getTemplateId(), smsInfo.getTemplateParams());
		
		logger.debug("[短信发送]--返回结果：" + result);
		
		String statusCode = (String)result.get("statusCode");
		
		smsInfo.setStatusCode(statusCode);
		
		if(SUCCESS.equals(statusCode)){
			logger.debug("");
			try {
				HashMap<String,Object> data = (HashMap<String, Object>) result.get("data");
				HashMap<String,Object> templateSMS = (HashMap<String,Object>)data.get("templateSMS");
				try {
					String smsMessageSid = (String)templateSMS.get("smsMessageSid");
					smsInfo.setSmsMessageSid(smsMessageSid);
				} catch(Exception e) {
					logger.error("[短信发送]--解析smsMessageSid时发生异常：" +  e.getMessage());
				}
				try {
					String dateCreated = (String)templateSMS.get("dateCreated");
					smsInfo.setDateCreated(dateCreated);
				} catch (Exception e) {
					logger.error("[短信发送]--解析dateCreated时发生异常：" +  e.getMessage());
				}
			} catch (Exception e) {
				logger.error("[短信发送]--解析data时发生异常：" + e.getMessage());
			}
		}else{
			logger.error("[短信发送]--手机号：" + smsInfo.getMobilePhone()  + "，返回错误码:" + statusCode +",错误信息:"+result.get("statusMsg"));
		}
		return smsInfo;
	}
}
