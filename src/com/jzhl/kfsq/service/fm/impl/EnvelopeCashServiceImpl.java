package com.jzhl.kfsq.service.fm.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jzhl.kfsq.dao.fm.IEnvelopeCashMapper;
import com.jzhl.kfsq.entity.fm.EnvelopeCash;
import com.jzhl.kfsq.service.fm.IEnvelopeCashService;

/**
 * 红包、提现中间表业务层实现类
 * 
 * @author Shaw
 *
 */
@Service
public class EnvelopeCashServiceImpl implements IEnvelopeCashService {
	
	@Autowired
	private IEnvelopeCashMapper envelopeCashDao;

	/**
	 * 删除红包、提现中间表
	 * 
	 * @param envelopeCashId
	 */
	@Override
	public void deleteEnvelopeCash(int envelopeCashId) {
		envelopeCashDao.deleteEnvelopeCash(envelopeCashId);
	}

	/**
	 * 根据提现编号查询中间表
	 * 
	 * @param applicationId
	 * @return
	 */
	@Override
	public List<EnvelopeCash> findEnvelopeCashByApplicationId(
			String applicationId) {
		List<EnvelopeCash> envelopeCashs = envelopeCashDao.findEnvelopeCashByApplicationId(applicationId);
		return envelopeCashs;
	}

}
