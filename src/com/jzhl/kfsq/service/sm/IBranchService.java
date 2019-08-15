package com.jzhl.kfsq.service.sm;

import java.util.List;
import java.util.Map;

import com.jzhl.kfsq.dto.sm.BranchDto;
import com.jzhl.kfsq.entity.sm.Branch;

/**
 * 用户业务层接口
 * 
 * @author zhouzy
 *
 */
public interface IBranchService {

	/**
	 * 开通、关闭所代理的城市
	 * 
	 * 用户实体类
	 */
	public void updateBranchCity(Branch branch);

	/**
	 * 根据用户编号查询用户信息
	 * 
	 * @return 用户实体类
	 */
	public Branch getBranch(Branch branch);

	/**
	 * 查询
	 * 
	 * @return 代理商列表
	 */
	public List<Branch> getBranchList(Map<String, Object> map);

	/**
	 * 获取代理商下楼盘总数
	 */
	public int getBuildingCount(Map<String, Object> mapb);

	/**
	 * 开通代理商
	 */
	public void insertBranch(Branch branch, BranchDto branchDto);

	/**
	 * 代理商权限列表总数
	 */
	public int getBranchDataCount();

	/**
	 * 编辑代理商
	 */
	public void updateBranch(Branch branch) throws Exception;

	/**
	 * 分页查询
	 * 
	 * @return 代理商列表
	 */
	public List<Branch> getBranchListPage(Map<String, Object> map);

	/**
	 * 代理商余额提醒
	 */
	public long remindInfoInsert();

	/**
	 * 通过 城市ID获取代理商ID
	 * 
	 * @param cityId
	 * @return
	 */
	public Integer getAgentIdByCityId(Integer cityId);

	/**
	 * 获取昨日新增楼盘总数
	 * 
	 * @author zhouzy
	 */
	public int getBuildingCountYesterday(Map<String, Object> map);

	/**
	 * 楼盘余额提醒
	 * 
	 * @author zhouzy
	 */
	public long buildingRemindInfoInsert();

}
