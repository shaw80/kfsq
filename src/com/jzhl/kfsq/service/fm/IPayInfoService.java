package com.jzhl.kfsq.service.fm;

import com.jzhl.kfsq.common.base.ListResult;
import com.jzhl.kfsq.dataset.fm.BillingDetailDataSet;
import com.jzhl.kfsq.dto.fm.BillingDto;
import com.jzhl.kfsq.dto.fm.PayInfoDto;

/**
 * 支付信息业务层接口
 * 
 * @author Shaw
 *
 */
public interface IPayInfoService {

	/**
	 * 根据用户编号分页查询支付信息
	 * 
	 * @param dto
	 * @return
	 */
	public ListResult findPayInfoByUserId(PayInfoDto dto);

	/**
	 * 根据流水号查询账单明细
	 * 
	 * @param dto
	 * @return
	 */
	public BillingDetailDataSet getBillingDetalilDataSet(BillingDto dto);

}
