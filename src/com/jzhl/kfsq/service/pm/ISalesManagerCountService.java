package com.jzhl.kfsq.service.pm;

import com.jzhl.kfsq.common.base.ListResult;
import com.jzhl.kfsq.dataset.pm.SalesManagerCountDataSet;
import com.jzhl.kfsq.dataset.pm.TeamCustomerDataSet;
import com.jzhl.kfsq.dataset.pm.UserCustomerDataSet;
import com.jzhl.kfsq.dataset.pm.VisitCommonDataSet;
import com.jzhl.kfsq.dataset.pm.VisitCommonTeamDataSet;
import com.jzhl.kfsq.dataset.sm.ManagerDataSet;

/**
 * 销售经理统计页面业务层接口
 * 
 * @author Shaw
 *
 */
public interface ISalesManagerCountService {
	
	/**
	 * 统计销售经理页面数据
	 * @param userId
	 * @return
	 */
	public SalesManagerCountDataSet getCount(int userId);
	
	/**
	 * 根据销售经理编号查询所有下属的今日到访业绩及今日总到访量
	 * @param userId
	 * @param begin
	 * @param length
	 * @return
	 */
	public VisitCommonDataSet getVisitTodayPerson(int userId, int begin, int length);
	
	/**
	 * 根据销售经理编号查询所有下属的本月到访业绩及本月总到访量
	 * @param userId
	 * @param begin
	 * @param length
	 * @return
	 */
	public VisitCommonDataSet getVisitMonthPerson(int userId, int begin, int length);
	
	/**
	 * 根据销售经理编号查询所有下属的总到访业绩及总到访量
	 * @param userId
	 * @param begin
	 * @param length
	 * @return
	 */
	public VisitCommonDataSet getVisitTotalPerson(int userId, int begin, int length);
	
	/**
	 * 根据销售经理编号分页查询今天本楼盘所有团队到访业绩
	 * @param userId
	 * @param begin
	 * @param length
	 * @return
	 */
	public VisitCommonTeamDataSet getVisitTodayTeam(int userId, int begin, int length); 
	
	/**
	 * 根据销售经理编号分页查询本月本楼盘所有团队到访业绩
	 * @param userId
	 * @param begin
	 * @param length
	 * @return
	 */
	public VisitCommonTeamDataSet getVisitMonthTeam(int userId, int begin, int length); 
	
	/**
	 * 根据销售经理编号分页查询本楼盘所有团队总到访业绩
	 * @param userId
	 * @param begin
	 * @param length
	 * @return
	 */
	public VisitCommonTeamDataSet getVisitTotalTeam(int userId, int begin, int length); 
	
	/**
	 * 根据置业顾问编号分页查询客户信息
	 * @param userId
	 * @param memberName
	 * @param begin
	 * @param length
	 * @return
	 */
	public UserCustomerDataSet getUserCustomerDataSet(int userId, int begin, int length);
	
	/**
	 * 分页查询团队客户信息
	 * @param memberName
	 * @param begin
	 * @param length
	 * @return
	 */
	public TeamCustomerDataSet findCustomerDataSet(String memberName, int leaderId, int begin, int length);
	
	/**
	 * 根据销售经理编号查询销售经理信息
	 * @param userId
	 * @return
	 */
	public ManagerDataSet getManagerDataSet(int userId);
	
	/**
	 * 根据销售经理编号分页查询下属置业顾问信息
	 * @param userId
	 * @param begin
	 * @param length
	 * @return
	 */
	public ListResult findSalerDataSet(int userId, int begin, int length);
}
