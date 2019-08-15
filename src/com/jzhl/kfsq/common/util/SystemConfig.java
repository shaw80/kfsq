package com.jzhl.kfsq.common.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Hashtable;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;

@Controller
public class SystemConfig {
	private static final Logger logger = Logger.getLogger(SystemConfig.class);
	private static Hashtable<Object, Object> systemTable = new Hashtable<Object, Object>();
	private static String ftpIp;
	private static int ftpPort;
	private static String usernName;
	private static String password;

	private static String httpBasePath;

	static {
		logger.debug("初始化SystemConfig...");
		try {
			Properties prop = new Properties();
			systemTable = prop;
			InputStream in = SystemConfig.class.getResourceAsStream("/system.properties");
			BufferedReader bf = new BufferedReader(new InputStreamReader(in));
			prop.load(bf);
			ftpIp = prop.getProperty("ftp.ip");
			ftpPort = Integer.parseInt(prop.getProperty("ftp.port"));
			usernName = prop.getProperty("ftp.userName");
			password = prop.getProperty("ftp.password");
			httpBasePath = prop.getProperty("http.httpBasePath");
			logger.debug("初始化SystemConfig成功.");
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("读取system.properties文件异常：" + e.getMessage());
		}
	}

	public static String getFtpIp() {
		return ftpIp;
	}

	public static int getFtpPort() {
		return ftpPort;
	}

	public static String getUsernName() {
		return usernName;
	}

	public static String getPassword() {
		return password;
	}

	/**
	 * http图片根目录
	 * 
	 * @return
	 */
	public static String getHttpBasePath() {
		return httpBasePath;
	}

	/**
	 * 通过图片类型获取图片路径，规则：图片类型type，图片路径配置名ftp.type
	 * 
	 * @param type
	 * @return
	 */
	public static String getFtpPathByType(String type) {
		String ftpPath = null;
		try {
			ftpPath = (String) systemTable.get("ftp." + type);
			if (ftpPath == null || ftpPath.isEmpty()) {
				logger.debug("system.properties文件中，未匹配到" + type);
				return null;
			}
		} catch (Exception e) {
			logger.error("读取system.properties文件，属性" + type + "异常：" + e.getMessage());
		}
		return ftpPath;
	}

}
