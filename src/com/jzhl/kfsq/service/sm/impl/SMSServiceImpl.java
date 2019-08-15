package com.jzhl.kfsq.service.sm.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jzhl.kfsq.dao.sm.ISMSMapper;
import com.jzhl.kfsq.dto.sm.SMSInfoDto;
import com.jzhl.kfsq.entity.sm.SMSInfo;
import com.jzhl.kfsq.service.sm.ISMSService;

@Service
public class SMSServiceImpl implements ISMSService {
	
	@Autowired
	private ISMSMapper smsDAO;

	@Override
	public void addSMS(SMSInfo smsInfo) {
		smsDAO.insertSMS(smsInfo);
	}

	@Override
	public SMSInfo getNewestSMS(SMSInfoDto smsInfoDto) {
		return smsDAO.getNewestSMS(smsInfoDto);
	}
	
	@Override
	public void updateSendTimes(java.lang.Integer codeId) {
		smsDAO.updateSendTimes(codeId);
	}
}
