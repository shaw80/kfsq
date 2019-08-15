package com.jzhl.kfsq.dao.pm;

import java.util.List;
import java.util.Map;

import com.jzhl.kfsq.dataset.pm.CustomerDataSet;
import com.jzhl.kfsq.dataset.pm.SalesManagerCountDataSet;
import com.jzhl.kfsq.dataset.pm.SevenDayReceiveDataSet;
import com.jzhl.kfsq.dataset.pm.VisitCommonBean;
import com.jzhl.kfsq.dataset.sm.ManagerReceiveDataSet;
import com.jzhl.kfsq.dataset.sm.SalerDataSet;

/**
 * 销售经理页面统计相关功能数据访问层接口
 * 
 * @author Shaw
 *
 */
public interface ISalesManagerCountMapper {

	/**
	 * 统计销售经理页面相关数据
	 * 
	 * @return
	 */
	public SalesManagerCountDataSet getCount(Map<String, Object> params);
	
	/**
	 * 查询某一个时间节点的折线图数据
	 * @param userId
	 * @return
	 */
	public SevenDayReceiveDataSet getSevenDay(Map<String, Object> params);
	
	/**
	 * 根据销售经理编号查询所有下属的某段时间到访业绩
	 * @param userId
	 * @return
	 */
	public List<VisitCommonBean> findVisitPerson(Map<String, Object> params);
	
	/**
	 * 根据销售经理编号统计所有下属的某段时间到访业绩的数据量
	 * @param params
	 * @return
	 */
	public Integer countVisitPerson(Map<String, Object> params);
	
	/**
	 * 根据销售经理查询某段段时间的到访量
	 * @param userId
	 * @return
	 */
	public Integer getVisit(Map<String, Object> params);
	
	/**
	 * 根据销售经理编号分页查询某段时间本楼盘所有团队到访业绩
	 * @param params
	 * @return
	 */
	public List<VisitCommonBean> findVisitTeam(Map<String, Object> params);
	
	/**
	 * 根据销售经理编号统计本楼盘所有团队的某段时间到访业绩的数据量
	 * @param params
	 * @return
	 */
	public Integer countVisitTeam(Map<String, Object> params);
	
	/**
	 * 条件分页查询到访客户
	 * @param params
	 * @return
	 */
	public List<CustomerDataSet> findCustomerDataSet(Map<String, Object> params);
	
	/**
	 * 统计条件分页查询到访客户数据量
	 * @param params
	 * @return
	 */
	public Integer countCustomerDataSet(Map<String, Object> params);
	
	/**
	 * 根据销售经理编号查询销售经理信息
	 * @param userId
	 * @return
	 */
	public ManagerReceiveDataSet getManagerDataSet(int userId);
	
	/**
	 * 根据销售经理编号分页查询下属置业顾问信息
	 * @param userId
	 * @return
	 */
	public List<SalerDataSet> findSalerDataSet(Map<String, Object> params);
	
	/**
	 * 根据销售经理编号统计下属置业顾问信息的数据量
	 * @param userId
	 * @return
	 */
	public Integer countSalerDataSet(int userId);

}
