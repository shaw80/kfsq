package com.jzhl.kfsq.service.sm;

import java.util.List;

import com.jzhl.kfsq.dataset.sm.BranchCityDataSet;

/**
 * 分站城市业务层接口
 * 
 * @author Shaw
 *
 */
public interface IBranchCityService {

	/**
	 * 根据分站编号查询分站城市是否开通
	 * 
	 * @param branchId
	 * @return
	 */
	public Boolean isOpen(int branchId);

	/**
	 * 获取所有开通代理商的城市
	 * 
	 * @author zhouzy
	 * @return
	 */
	public List<BranchCityDataSet> getBranchCityList();

}
