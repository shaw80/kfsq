package com.jzhl.kfsq.dao.fm;

import java.util.List;
import java.util.Map;

import com.jzhl.kfsq.dataset.mm.MemberBillingDataSet;
import com.jzhl.kfsq.dto.fm.PayParamDto;
import com.jzhl.kfsq.entity.fm.PayInfo;

/**
 * 支付信息数据访问层接口
 * 
 * @author Shaw
 *
 */
public interface IPayInfoMapper {

	/**
	 * 根据用户编号分页查询支付信息
	 * 
	 * @param dto
	 * @return
	 */
	public List<PayInfo> findPayInfoByUserId(PayParamDto dto);

	/**
	 * 根据用户编号统计支付信息数据量
	 * 
	 * @param dto
	 * @return
	 */
	public Integer countPayInfoByUserId(PayParamDto dto);

	/**
	 * 根据流水号获取支付信息
	 * 
	 * @param serialNum
	 * @return
	 */
	public PayInfo getPayInfoBySerNum(String serialNum);

	/**
	 * 根据流水号查询批量支付给哪些用户
	 * 
	 * @param serialNum
	 * @return
	 */
	public List<MemberBillingDataSet> findMemberBySerNum(Map<String, Object> params);
	
	/**
	 * 根据流水号统计批量支付给多少用户
	 * @param serialNum
	 * @return
	 */
	public Integer countMemberBySerNum(String serialNum);

}
