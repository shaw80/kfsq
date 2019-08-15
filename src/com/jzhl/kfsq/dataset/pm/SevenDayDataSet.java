package com.jzhl.kfsq.dataset.pm;

import java.io.Serializable;

/**
 * 统计七天折线图结果集
 * 
 * @author Shaw
 *
 */
public class SevenDayDataSet implements Serializable {

	private static final long serialVersionUID = 3487043107224270013L;
	
	private Integer count;// 到访人数
	
	private String day;// 周几 
	
	private String date;// 日期

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	@Override
	public String toString() {
		return "SevenDayDataSet [count=" + count + ", day=" + day + ", date="
				+ date + "]";
	}

}
