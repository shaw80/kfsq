package com.jzhl.kfsq.service.sm.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jzhl.kfsq.dao.sm.IEnvelopeRuleMapper;
import com.jzhl.kfsq.entity.sm.EnvelopeRule;
import com.jzhl.kfsq.service.sm.IEnvelopeRuleService;

/**
 * 红包管理-评论红包
 * 
 * @author zhouzy
 *
 */
@Service
public class EnvelopeRuleServiceImpl implements IEnvelopeRuleService {

	@Autowired
	private IEnvelopeRuleMapper envelopeRuleDao;

	/**
	 * 评论红包添加
	 */
	@Override
	public void insertEnvelopeRule(EnvelopeRule envelopeRule) {
		envelopeRuleDao.insertEnvelopeRule(envelopeRule);
	}

	/**
	 * 评论红包编辑
	 */
	@Override
	public void updateEnvelopeRule(EnvelopeRule envelopeRule) {
		envelopeRuleDao.updateEnvelopeRule(envelopeRule);
	}

	/**
	 * 根据楼盘编号查询看房红包规则
	 * @param buildingId
	 * @return
	 */
	@Override
	public EnvelopeRule getRuleByBuildingIdAllStatus(int buildingId) {
		EnvelopeRule rule = envelopeRuleDao.getRuleByBuildingIdAllStatus(buildingId);
		return rule;
	}
}
