package com.jzhl.kfsq.dao.sm;

import com.jzhl.kfsq.entity.sm.EnvelopeRule;

/**
 * 红包管理-看房红包
 * 
 * @author zhouzy
 *
 */
public interface IEnvelopeRuleMapper {

	/**
	 * 看房红包添加
	 */
	public void insertEnvelopeRule(EnvelopeRule envelopeRule);

	/**
	 * 看房红包编辑
	 */
	public void updateEnvelopeRule(EnvelopeRule envelopeRule);
	
	/**
	 * 根据楼盘编号查询看房红包规则
	 * @param buildingId
	 * @return
	 */
	public EnvelopeRule getRuleByBuildingId(int buildingId);
	
	/**
	 * 根据楼盘编号查询看房红包规则（包括有效和无效的）
	 * @param buildingId
	 * @return
	 */
	public EnvelopeRule getRuleByBuildingIdAllStatus(int buildingId);

}
