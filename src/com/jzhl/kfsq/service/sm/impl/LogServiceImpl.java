package com.jzhl.kfsq.service.sm.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jzhl.kfsq.common.base.PageListCondition;
import com.jzhl.kfsq.dao.sm.ILogMapper;
import com.jzhl.kfsq.dto.sm.LogDto;
import com.jzhl.kfsq.service.sm.ILogService;
@Service
public class LogServiceImpl implements ILogService{
	@Autowired
	private ILogMapper logDao;
	@Override
	public void insert(LogDto dto) {
		// TODO Auto-generated method stub
		logDao.insert(dto);
	}

	@Override
	public List<LogDto> findLogList(PageListCondition page) {
		// TODO Auto-generated method stub
		return logDao.findLogList(page);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return logDao.getNumber();
	}

}
