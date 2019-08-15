package com.jzhl.kfsq.common.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;

/**
 * 短信接口信息配置类
 * 
 * @author henan
 */
@Controller
public class SMSConfig {
	private static final Logger logger = Logger.getLogger(SMSConfig.class);
	private static String serverIp;
	private static int port;
	private static String acountSid;
	private static String authToken;
	private static String appId;
	private static Map<String, String> templateMap = new HashMap<String, String>(); // key:smsType,
																					// value:templateId

	static {
		logger.debug("初始化SMSConfig...");
		try {
			Properties prop = new Properties();
			InputStream in = SMSConfig.class.getResourceAsStream("/sms.properties");
			BufferedReader bf = new BufferedReader(new InputStreamReader(in));
			prop.load(bf);

			serverIp = prop.getProperty("serverIp");
			port = Integer.parseInt(prop.getProperty("port"));
			acountSid = prop.getProperty("acountSid");
			authToken = prop.getProperty("authToken");
			appId = prop.getProperty("appId");
			setTemplateMap(prop);

			logger.debug("初始化SMSConfig成功.");
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("读取sms.properties文件异常：" + e.getMessage());
		}
	}

	/**
	 * 初始化短信类型map key:smsType, value:templateId
	 * 
	 * @param prop
	 */
	private static void setTemplateMap(Properties prop) {
		for (int i = 0;; i++) {
			String templateId = prop.getProperty("templateId" + (i + 1));
			if (templateId == null || templateId.isEmpty()) {
				break;
			}
			String smsType = prop.getProperty("smsType" + (i + 1));
			if (smsType == null || smsType.isEmpty()) {
				continue;
			}
			for (String str : smsType.split(",")) {
				templateMap.put(str, templateId);
			}
		}
	}

	/**
	 * 通过smsType获取templateId
	 * 
	 * @param smsType
	 * @return
	 */
	public static String getTemplateIdBySmsType(String smsType) {
		return templateMap.get(smsType);
	}

	public static String getServerIp() {
		return serverIp;
	}

	public static int getPort() {
		return port;
	}

	public static String getAcountSid() {
		return acountSid;
	}

	public static String getAuthToken() {
		return authToken;
	}

	public static String getAppId() {
		return appId;
	}

}
