package com.jzhl.kfsq.dataset.pm;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 统计七天折线图查询结果集
 * 
 * @author Shaw
 *
 */
public class SevenDayReceiveDataSet implements Serializable {

	private static final long serialVersionUID = -3527275585274232349L;
	
	private Integer count;// 到访人数
	
	private Timestamp day;// 周几 

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Timestamp getDay() {
		return day;
	}

	public void setDay(Timestamp day) {
		this.day = day;
	}

	@Override
	public String toString() {
		return "SevenDayReceiveDataSet [count=" + count + ", day=" + day + "]";
	}

}
