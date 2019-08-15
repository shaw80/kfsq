package com.jzhl.kfsq.dao.pm;

import java.util.List;
import java.util.Map;

import com.jzhl.kfsq.dto.pm.FavoriteDBDto;
import com.jzhl.kfsq.entity.pm.SalerCustomer;

public interface ISalerCustomerMapper {
	
	public Integer insertSalerCustomer(SalerCustomer salerCustomer);
	
	public SalerCustomer getCustomerLastTime(SalerCustomer salerCustomer);

	public void updateSalerCustomer(SalerCustomer salerCustomer);
	
	public SalerCustomer getSalerCustomer(int salerCustomerId);
	
	/**
	 * 根据用户编号查询客户信息
	 * @param params
	 * @return
	 */
	public List<SalerCustomer> findSalerCustomerByUserId(Map<String, Object> params);
	
	/**
	 * 统计用户编号查询客户信息的数据量
	 * @param userId
	 * @return
	 */
	public Integer countSalerCustomerByUserId(Map<String, Object> params);
	
	/**
	 * 收藏或取消
	 * @param salerCustomerDto
	 */
	public void updateFavorite(FavoriteDBDto dto);
	
	/**
	 * 根据会员编号和楼盘编号查询到访记录
	 * @param params
	 * @return
	 */
	public List<SalerCustomer> findSalerCustomerByMemberIdAndBuildingId(Map<String, Object> params);
	
}
