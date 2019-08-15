package com.jzhl.kfsq.dao.fm;

import java.util.List;

import com.jzhl.kfsq.entity.fm.EnvelopeCash;

/**
 * 红包、提现中间表数据访问层接口
 * 
 * @author Shaw
 *
 */
public interface IEnvelopeCashMapper {

	/**
	 * 添加中间表
	 * 
	 * @param ec
	 */
	public void insertEnvelopeCash(EnvelopeCash ec);

	/**
	 * 删除中间表
	 * 
	 * @param envelopeCashId
	 */
	public void deleteEnvelopeCash(int envelopeCashId);

	/**
	 * 根据领取编号查询中间表集合
	 * 
	 * @param receiveId
	 * @return
	 */
	public List<EnvelopeCash> findEnvelopeCashByReceiveId(int receiveId);

	/**
	 * 根据提现编号查询中间表集合
	 * 
	 * @param applicationId
	 * @return
	 */
	public List<EnvelopeCash> findEnvelopeCashByApplicationId(
			String applicationId);

}
