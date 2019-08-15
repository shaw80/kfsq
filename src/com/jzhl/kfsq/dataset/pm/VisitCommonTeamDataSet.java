package com.jzhl.kfsq.dataset.pm;

import com.jzhl.kfsq.common.base.ListResult;

/**
 * 团队统计结果集
 * 
 * @author Shaw
 *
 */
public class VisitCommonTeamDataSet {
	
	private Integer rank;// 名次
	
	private ListResult performances;// 到访业绩数据

	public Integer getRank() {
		return rank;
	}

	public void setRank(Integer rank) {
		this.rank = rank;
	}

	public ListResult getPerformances() {
		return performances;
	}

	public void setPerformances(ListResult performances) {
		this.performances = performances;
	}

	@Override
	public String toString() {
		return "VisitCommonTeamDataSet [rank=" + rank + ", performances="
				+ performances + "]";
	}

}
