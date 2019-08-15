package com.jzhl.kfsq.dao.sm;

import java.util.List;
import java.util.Map;

import com.jzhl.kfsq.dataset.sm.BranchStatisticalDataSet;
import com.jzhl.kfsq.entity.sm.Branch;

/**
 * 用户数据访问层接口
 * 
 * @author zhouzy
 *
 */
public interface IBranchMapper {

	/**
	 * 添加会员
	 * 
	 * @param BranchDto
	 */
	public void insertBranch(Branch branch);

	/**
	 * 编辑会员
	 * 
	 * @param BranchDto
	 */
	public void updateBranchCity(Branch branch);

	/**
	 * @param id
	 * @return
	 */
	public Branch getBranch(Branch branch);

	/**
	 * 获取代理商权限列表
	 * 
	 * @return 代理商集合
	 */
	public List<Branch> getBranchList(Map<String, Object> map);

	/**
	 * 代理商統計
	 * 
	 * @return 代理商統計
	 */
	public BranchStatisticalDataSet getBranchStatistical(Map<String, Object> map);

	/**
	 * 代理商旗下楼盘总数
	 */
	public int getBuildingCount(Map<String, Object> map);

	/**
	 * 代理商权限列表总数
	 */
	public int getBranchDataCount();

	/**
	 * 编辑代理商
	 */
	public void updateBranch(Branch branch);

	/**
	 * 分页获取代理商权限列表
	 */
	public List<Branch> getBranchListPage(Map<String, Object> map);

	/**
	 * 通过 城市ID获取代理商ID
	 * @param cityId
	 * @return
	 */
	public Integer getAgentIdByCityId(Integer cityId);

	/**
	 * 获取昨日新增楼盘总数
	 * @author zhouzy
	 */
	public int getBuildingCountYesterday(Map<String, Object> map);
	
	/**
	 * 查询全部分站
	 * @return
	 */
	public List<Branch> findAll();

}
