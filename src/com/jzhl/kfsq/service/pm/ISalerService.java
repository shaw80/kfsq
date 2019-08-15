package com.jzhl.kfsq.service.pm;

import java.util.List;

import com.jzhl.kfsq.common.base.ListResult;
import com.jzhl.kfsq.dataset.pm.VisitCommonDataSet;
import com.jzhl.kfsq.dataset.pm.VisitDataSet;
import com.jzhl.kfsq.dataset.pm.VisitMonthDataSet;
import com.jzhl.kfsq.dto.pm.FavoriteDBDto;
import com.jzhl.kfsq.dto.pm.SalerCustomerDto;
import com.jzhl.kfsq.dto.pm.VisitQueryDto;
import com.jzhl.kfsq.entity.pm.SalerCustomer;

public interface ISalerService {

	/**
	 * 查询一段时间内的访问量
	 * @param visitQueryDto
	 * @return
	 */
	public Integer getVisitCount(VisitQueryDto visitQueryDto);

	/**
	 * 查询一段时间内每天的访问量
	 * @param visitQueryDto
	 * @return
	 */
	public List<VisitDataSet> getDayVisitCountList(VisitQueryDto visitQueryDto);
	
	/**
	 * 查询我的客户
	 * @param userId
	 * @return
	 */
	public ListResult findSalerCustomerDataSet(SalerCustomerDto salerCustomerDto);

	/**
	 * 收藏或取消
	 * @param salerCustomerDto
	 */
	public void updateFavorite(FavoriteDBDto dto);

	/**
	 * 查询一段时间内每月的访问量
	 * @param visitQueryDto
	 * @return
	 */
	public List<VisitMonthDataSet> getMonthVisitCountList(VisitQueryDto visitQueryDto);

	/**
	 * 根据置业顾问编号查询所有下属的今日到访业绩及今日总到访量
	 * @param userId
	 * @param begin
	 * @param length
	 * @return
	 */
	public VisitCommonDataSet getVisitTodayPerson(int userId, int begin, int length);
	
	/**
	 * 根据置业顾问编号查询所有下属的本月到访业绩及本月总到访量
	 * @param userId
	 * @param begin
	 * @param length
	 * @return
	 */
	public VisitCommonDataSet getVisitMonthPerson(int userId, int begin, int length);
	
	/**
	 * 根据置业顾问编号查询所有下属的总到访业绩及总到访量
	 * @param userId
	 * @param begin
	 * @param length
	 * @return
	 */
	public VisitCommonDataSet getVisitTotalPerson(int userId, int begin, int length);

	/**
	 * 添加售楼员客户到访记录
	 * @param salerCustomer
	 */
	public SalerCustomer addSalerCustomer(SalerCustomer salerCustomer);

	/**
	 * 获取用户最后到访信息
	 * @param salerCustomer
	 * @return
	 */
	public SalerCustomer getCustomerLastTime(SalerCustomer salerCustomer);

	
	/**
	 * 修改到访记录
	 * @param salerCustomer
	 */
	public void modifySalerCustomer(SalerCustomer salerCustomer);
	
	/**
	 * 根据主键查询客户信息
	 * @param salerCustomerId
	 * @return
	 */
	public SalerCustomer getSalerCustomer(int salerCustomerId);
	
}
