package com.jzhl.kfsq.common.util;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * 获取固定时间节点的date格式时间
 * 
 * @author Shaw
 *
 */
public class TimeUtil {

	private final static SimpleDateFormat shortSdf = new SimpleDateFormat("yyyy-MM-dd");

	private final static SimpleDateFormat longSdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	private final static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM"); // 设置时间格式

	private final static SimpleDateFormat sdf_day_this_month = new SimpleDateFormat("dd"); // 设置时间格式

	/**
	 * 获得本月的开始时间，即2012-01-01 00:00:00
	 * 
	 * @return
	 */
	public static Long getCurrentMonthStartTime() {
		Calendar c = Calendar.getInstance();
		Long now = null;
		try {
			c.set(Calendar.DATE, 1);
			now = c.getTimeInMillis();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return now;
	}

	/**
	 * 当前月的结束时间，即2012-01-31 23:59:59
	 * 
	 * @return
	 */
	public static Long getCurrentMonthEndTime() {
		Calendar c = Calendar.getInstance();
		Long now = null;
		try {
			c.set(Calendar.DATE, 1);
			c.add(Calendar.MONTH, 1);
			c.add(Calendar.DATE, -1);
			Date date = longSdf.parse(shortSdf.format(c.getTime()) + " 23:59:59");
			now = date.getTime();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return now;
	}

	/**
	 * 判断给定时间是否早于当前时间
	 * 
	 * @author zhouzy
	 * @param date
	 * @return
	 */
	public static boolean before(java.util.Date date) {
		if (date == null)
			return false;
		return new java.util.Date().after(date);
	}

	/**
	 * 统计时，查询12月内数据，把为null的月份添加默认值，
	 * 
	 * @author zhouzy
	 * @return 近12月列表
	 */
	@SuppressWarnings("static-access")
	public static List<String> dataResult() {
		List<String> listResult = new ArrayList<>();
		String dataResult = "";
		Date dNow = new Date(); // 当前时间
		for (int i = 11; i >= 0; i--) {
			Date dBefore = new Date();
			Calendar calendar = Calendar.getInstance(); // 得到日历
			calendar.setTime(dNow);// 把当前时间赋给日历
			calendar.add(calendar.MONTH, -i); // 设置为前11月
			dBefore = calendar.getTime(); // 得到前11月的时间
			dataResult = sdf.format(dBefore); // 格式化前11月的时间
			listResult.add(dataResult);
		}
		return listResult;
	}

	/**
	 * 统计时，查询6月内数据，把为null的月份添加默认值，
	 * 
	 * @author zhouzy
	 * @return 近6月列表
	 */
	@SuppressWarnings("static-access")
	public static List<String> monthResult() {
		List<String> listResult = new ArrayList<>();
		String dataResult = "";
		Date dNow = new Date(); // 当前时间
		for (int i = 5; i >= 0; i--) {
			Date dBefore = new Date();
			Calendar calendar = Calendar.getInstance(); // 得到日历
			calendar.setTime(dNow);// 把当前时间赋给日历
			calendar.add(calendar.MONTH, -i); // 设置为前11月
			dBefore = calendar.getTime(); // 得到前11月的时间
			dataResult = sdf.format(dBefore); // 格式化前11月的时间
			listResult.add(dataResult);
		}
		return listResult;
	}

	/**
	 * 统计时，查询近7天内数据，把为null的近7天添加默认值，
	 * 
	 * @author zhouzy
	 * @return 近7天列表
	 */
	@SuppressWarnings("static-access")
	public static List<String> dayResult() {
		List<String> listResult = new ArrayList<>();
		String dataResult = "";
		Date dNow = new Date(); // 当前时间
		for (int i = 6; i >= 0; i--) {
			Date dBefore = new Date();
			Calendar calendar = Calendar.getInstance(); // 得到日历
			calendar.setTime(dNow);// 把当前时间赋给日历
			calendar.add(calendar.DATE, -i); // 设置为前7天
			dBefore = calendar.getTime(); // 得到前7天的时间
			dataResult = shortSdf.format(dBefore); // 格式化前7天的时间
			listResult.add(dataResult);
		}
		return listResult;
	}

	/**
	 * 统计时，查询本月内数据，把为null的日期添加默认值，
	 * 
	 * @author zhouzy
	 * @return 本月日期列表
	 */
	@SuppressWarnings("static-access")
	public static List<String> dayForThisMonthResult() {
		List<String> listResult = new ArrayList<>();
		String dataResult = "";
		Date dNow = new Date(); // 当前时间
		Date dBefore = new Date();
		Calendar calendar = Calendar.getInstance(); // 得到日历
		calendar.setTime(dNow);// 把当前时间赋给日历
		calendar.add(calendar.DATE, 0);
		dBefore = calendar.getTime();
		dataResult = sdf_day_this_month.format(dBefore); // 格式化日期
		for (int i = 1; i <= Integer.parseInt(dataResult); i++) {
			String temp = "";
			if (Integer.toString(i).length() == 1) {
				temp = "0" + i;
			} else {
				temp = "" + i;
			}
			listResult.add(temp);
		}
		return listResult;
	}

	public static void main(String[] args) {
		TimeUtil.dayForThisMonthResult();

	}
}
