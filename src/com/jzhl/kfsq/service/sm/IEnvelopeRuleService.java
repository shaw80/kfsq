package com.jzhl.kfsq.service.sm;

import com.jzhl.kfsq.entity.sm.EnvelopeRule;

/**
 * 红包管理-评论红包
 * 
 * @author zhouzy
 *
 */
public interface IEnvelopeRuleService {

	/**
	 * 添加紅包规则
	 * 
	 */
	public void insertEnvelopeRule(EnvelopeRule envelopeRule);

	/**
	 * 编辑红包规则
	 * 
	 */
	public void updateEnvelopeRule(EnvelopeRule envelopeRule);
	
	/**
	 * 根据楼盘编号查询看房红包规则
	 * @param buildingId
	 * @return
	 */
	public EnvelopeRule getRuleByBuildingIdAllStatus(int buildingId);

}
