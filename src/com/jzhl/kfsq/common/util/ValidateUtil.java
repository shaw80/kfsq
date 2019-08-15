package com.jzhl.kfsq.common.util;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 校验用工具类
 * 
 * @author haojr
 */
public class ValidateUtil {

	/**
	 * 空白
	 */
	protected static final String BLANK_CHAR = "";

	/**
	 * 校验对象超出最大长度
	 * 
	 * @param obj
	 *            校验对象
	 * @param maxLength
	 *            最大长度
	 * @return 超过：true;没超过：false
	 */
	public static boolean isOverMaxLength(Object obj, int maxLength) {
		if (obj == null)
			return false;
		if (obj instanceof String) {
			if (String.valueOf(obj).length() > maxLength)
				return true;
		} else if (obj instanceof Integer) {
			if (String.valueOf(obj).length() > maxLength)
				return true;
		} else if (obj instanceof Float) {
			if (String.valueOf(Math.abs((Float) obj)).length() > maxLength)
				return true;
		} else if (obj instanceof List) {
			if (((List<?>) obj).size() > maxLength)
				return true;
		} else if (obj instanceof Object[]) {
			if (((Object[]) obj).length > maxLength)
				return true;
		}
		return false;
	}

	/**
	 * 校验对象不超出最大长度
	 * 
	 * @param obj
	 *            校验对象
	 * @param maxLength
	 *            最大长度
	 * @return 超过：true;没超过：false
	 */
	public static boolean isNotOverMaxLength(Object obj, int maxLength) {
		return !isOverMaxLength(obj, maxLength);
	}

	/**
	 * 校验数字（正整数）
	 * 
	 * @param obj
	 *            校验对象
	 * @return 是数字：true;不是数字：false
	 */
	public static boolean isNumber(String number) {
		if (number == null)
			return false;
		return number.matches("^\\d+$");
	}

	/**
	 * 校验数值
	 * 
	 * @param obj
	 *            校验对象
	 * @return 是数值：true;不是数值：false
	 */
	public static boolean isNumeric(String numeric) {
		if (numeric == null)
			return false;
		return numeric.matches("^(\\+|-)?\\d+$|^(\\+|-)?\\d+\\.\\d+$");
	}

	/**
	 * 校验日期(yyyyMMdd / yyyyMM)
	 * 
	 * @param obj
	 *            校验对象
	 * @return 是数值：true;不是数值：false
	 */
	public static boolean isDate(String date) {
		if (!isNumber(date))
			return false;
		if (date.length() == 6) {
			return (Integer.valueOf(date.substring(4)) <= 12 && Integer
					.valueOf(date.substring(4)) > 0);
		} else if (date.length() == 8) {
			SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
			formatter.setLenient(false);
			try {
				formatter.parse(date);
				return true;
			} catch (Exception e) {
				return false;
			}
		}
		return false;
	}

	/**
	 * 非空校验
	 * 
	 * @param obj
	 *            校验对象
	 * @return 非空：true;空：false
	 */
	public static boolean isNotEmpty(Object obj) {
		if (obj == null)
			return false;
		if (obj instanceof String) {
			if (BLANK_CHAR.equals(obj))
				return false;
		} else if (obj instanceof List) {
			if (((List<?>) obj).size() <= 0)
				return false;
		} else if (obj instanceof Object[]) {
			if (((Object[]) obj).length <= 0)
				return false;
		}
		return true;
	}

	/**
	 * 空校验
	 * 
	 * @param obj
	 *            校验对象
	 * @return 空：true;非空：false
	 */
	public static boolean isEmpty(Object obj) {
		return !isNotEmpty(obj);
	}
	
	public static boolean isMobile(String num) {
		
		if (null == num || 0 == num.length()) {
			return false;
		}
		Pattern p = Pattern.compile("1[3|5|7|8|][0-9]{9}");  
		Matcher m = p.matcher(num);  
		return m.find();
	}

}
