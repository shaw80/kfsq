package com.jzhl.kfsq.dataset.pm;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * 销售经理页面统计结果集
 * 
 * @author Shaw
 *
 */
public class SalesManagerCountDataSet implements Serializable {

	private static final long serialVersionUID = 991912993604803583L;// 序列化
	
	private String roleName;// 角色名称
	
	private String headPortrait;// 用户头像
	
	private Integer todayCount;// 当日到访统计
	
	private Integer monthCount;// 当月到访统计
	
	private Integer totalCount;// 总到访统计
	
	private BigDecimal extendPrice;// 已发放红包到访统计
	
	private List<SevenDayDataSet> days = new ArrayList<SevenDayDataSet>();// 七天折线数据

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getHeadPortrait() {
		return headPortrait;
	}

	public void setHeadPortrait(String headPortrait) {
		this.headPortrait = headPortrait;
	}

	public Integer getTodayCount() {
		return todayCount;
	}

	public void setTodayCount(Integer todayCount) {
		this.todayCount = todayCount;
	}

	public Integer getMonthCount() {
		return monthCount;
	}

	public void setMonthCount(Integer monthCount) {
		this.monthCount = monthCount;
	}

	public Integer getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}

	public BigDecimal getExtendPrice() {
		return extendPrice;
	}

	public void setExtendPrice(BigDecimal extendPrice) {
		this.extendPrice = extendPrice;
	}

	public List<SevenDayDataSet> getDays() {
		return days;
	}

	public void setDays(List<SevenDayDataSet> days) {
		this.days = days;
	}

	@Override
	public String toString() {
		return "SalesManagerCountDataSet [roleName=" + roleName
				+ ", headPortrait=" + headPortrait + ", todayCount="
				+ todayCount + ", monthCount=" + monthCount + ", totalCount="
				+ totalCount + ", extendPrice=" + extendPrice + ", days="
				+ days + "]";
	}

}
