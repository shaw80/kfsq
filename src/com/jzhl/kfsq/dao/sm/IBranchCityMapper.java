package com.jzhl.kfsq.dao.sm;

import java.util.List;

import com.jzhl.kfsq.dataset.sm.BranchCityDataSet;
import com.jzhl.kfsq.entity.sm.BranchCity;

/**
 * 分站城市中间表数据访问层接口
 * 
 * @author Shaw
 *
 */
public interface IBranchCityMapper {

	/**
	 * 根据分站编号查询分站城市中间表信息
	 * 
	 * @return
	 */
	public BranchCity getBranchCityByBranchId(int branchId);

	/**
	 * 新增代理商城市
	 */
	public void insertBranchCity(BranchCity branchCity);

	/**
	 * 获取所有开通代理商的城市列表
	 * 
	 * @author zhouzy
	 * @return
	 */
	public List<BranchCityDataSet> getBranchCityList();

}
