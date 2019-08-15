package com.jzhl.kfsq.service.pm.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jzhl.kfsq.dao.pm.ISalerCustomerMapper;
import com.jzhl.kfsq.entity.pm.SalerCustomer;
import com.jzhl.kfsq.service.pm.ISalerCustomerService;

/**
 * 客户到访表业务层实现类
 * 
 * @author Shaw
 *
 */
@Service
public class SalerCustomerServiceImpl implements ISalerCustomerService {
	
	@Autowired
	private ISalerCustomerMapper salerCustomerDao;

	/**
	 * 根据会员编号和楼盘编号查询到访记录
	 * @param memberId
	 * @param buildingId
	 * @return
	 */
	@Override
	public Boolean isVisit(int memberId, int buildingId) {
		Boolean isVisit = false;
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("memberId", memberId);
		param.put("buildingId", buildingId);
		List<SalerCustomer> list = salerCustomerDao.findSalerCustomerByMemberIdAndBuildingId(param);
		if(list.size() > 0){
			isVisit = true;
		}
		return isVisit;
	}

	/**
	 * 添加到访记录，带有返回值
	 * @param salerCustomer
	 * @return SalerCustomer
	 */
	@Override
	public SalerCustomer addSalerCustomer(SalerCustomer salerCustomer) {
		salerCustomerDao.insertSalerCustomer(salerCustomer);
		return salerCustomer;
	}

}
