package com.jzhl.kfsq.dao.pm;

import java.util.List;
import java.util.Map;

import com.jzhl.kfsq.dataset.pm.SalerCustomerDataSet;
import com.jzhl.kfsq.dataset.pm.VisitCommonBean;
import com.jzhl.kfsq.dataset.pm.VisitDataSet;
import com.jzhl.kfsq.dataset.pm.VisitMonthDataSet;
import com.jzhl.kfsq.dto.pm.SalerCustomerDto;
import com.jzhl.kfsq.dto.pm.VisitQueryDto;

public interface ISalerMapper {
	
	/**
	 * 查询一段时间内的访问量
	 * @param visitQueryDto
	 * @return
	 */
	public java.lang.Integer getVisitCount(VisitQueryDto visitQueryDto);
	
	/**
	 * 查询一段时间内每天的访问量
	 * @param visitQueryDto
	 * @return
	 */
	public List<VisitDataSet> getDayVisitCountList(VisitQueryDto visitQueryDto);
	
	/**
	 * 分页查询我的客户List
	 * @param userId
	 * @return
	 */
	public List<SalerCustomerDataSet> findSalerCustomerDataSetPage(SalerCustomerDto salerCustomerDto);
	
	/**
	 * 分页查询我的客户count
	 * @param userId
	 * @return
	 */
	public int findSalerCustomerDataSetCount(SalerCustomerDto salerCustomerDto);
	
	/**
	 * 查询一段时间内每月的访问量
	 * @param visitQueryDto
	 * @return
	 */
	public List<VisitMonthDataSet> getMonthVisitCountList(VisitQueryDto visitQueryDto);
	
	/**
	 * 根据置业顾问编号查询所有下属的某段时间到访业绩
	 * @param userId
	 * @return
	 */
	public List<VisitCommonBean> findVisitPerson(Map<String, Object> params);
	
	/**
	 * 根据置业顾问编号统计所有下属的某段时间到访业绩的数据量
	 * @param params
	 * @return
	 */
	public Integer countVisitPerson(Map<String, Object> params);
	
	/**
	 * 根据置业顾问编号查询某段段时间的到访量
	 * @param userId
	 * @return
	 */
	public Integer getVisit(Map<String, Object> params);
	
}
