package com.jzhl.kfsq.service.pm;

import com.jzhl.kfsq.entity.pm.SalerCustomer;

/**
 * 客户到访表业务层接口
 * 
 * @author Shaw
 *
 */
public interface ISalerCustomerService {
	
	/**
	 * 根据会员编号和楼盘编号查询到访记录
	 * @param memberId
	 * @param buildingId
	 * @return
	 */
	public Boolean isVisit(int memberId, int buildingId);
	
	/**
	 * 添加到访记录，带有返回值
	 * @param salerCustomer
	 * @return SalerCustomer
	 */
	public SalerCustomer addSalerCustomer(SalerCustomer salerCustomer);

}
