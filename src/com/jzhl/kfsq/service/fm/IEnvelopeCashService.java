package com.jzhl.kfsq.service.fm;

import java.util.List;

import com.jzhl.kfsq.entity.fm.EnvelopeCash;

/**
 * 红包、提现中间表业务层接口
 * 
 * @author Shaw
 *
 */
public interface IEnvelopeCashService {

	/**
	 * 删除红包、提现中间表
	 * 
	 * @param envelopeCashId
	 */
	public void deleteEnvelopeCash(int envelopeCashId);

	/**
	 * 根据提现编号查询中间表
	 * 
	 * @param applicationId
	 * @return
	 */
	public List<EnvelopeCash> findEnvelopeCashByApplicationId(
			String applicationId);
}
