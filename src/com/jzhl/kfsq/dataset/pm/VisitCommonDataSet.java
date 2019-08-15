package com.jzhl.kfsq.dataset.pm;

import java.io.Serializable;

import com.jzhl.kfsq.common.base.ListResult;

/**
 * 个人今日到访业绩结果集
 * 
 * @author Shaw
 *
 */
public class VisitCommonDataSet implements Serializable {

	private static final long serialVersionUID = 2558361996061188280L;// 序列化
	
	private Integer totalVisit;// 到访量
	
	private ListResult performances;// 到访业绩数据

	public Integer getTotalVisit() {
		return totalVisit;
	}

	public void setTotalVisit(Integer totalVisit) {
		this.totalVisit = totalVisit;
	}

	public ListResult getPerformances() {
		return performances;
	}

	public void setPerformances(ListResult performances) {
		this.performances = performances;
	}

	@Override
	public String toString() {
		return "VisitTodayPersonDataSet [totalVisit=" + totalVisit
				+ ", performances=" + performances + "]";
	}

}
