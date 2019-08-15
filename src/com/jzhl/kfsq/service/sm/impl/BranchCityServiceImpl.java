package com.jzhl.kfsq.service.sm.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jzhl.kfsq.dao.sm.IBranchCityMapper;
import com.jzhl.kfsq.dataset.sm.BranchCityDataSet;
import com.jzhl.kfsq.entity.sm.BranchCity;
import com.jzhl.kfsq.service.sm.IBranchCityService;

/**
 * 分站城市业务层实现类
 * 
 * @author Shaw
 *
 */
@Service
public class BranchCityServiceImpl implements IBranchCityService {
	
	@Autowired
	private IBranchCityMapper branchCityDao;

	/**
	 * 根据分站编号查询分站城市是否开通
	 * 
	 * @param branchId
	 * @return
	 */
	@Override
	public Boolean isOpen(int branchId) {
		Boolean isOpen = false;
		BranchCity bc = branchCityDao.getBranchCityByBranchId(branchId);
		if(bc.getStatus() == 1){
			isOpen = true;
		}
		return isOpen;
	}

	/**
	 * 获取所有开通代理商的城市
	 * 
	 * @author zhouzy
	 * @return
	 */
	@Override
	public List<BranchCityDataSet> getBranchCityList() {
		List<BranchCityDataSet> result = branchCityDao.getBranchCityList();
		return result;
	}

}
