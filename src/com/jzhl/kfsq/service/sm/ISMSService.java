package com.jzhl.kfsq.service.sm;

import com.jzhl.kfsq.dto.sm.SMSInfoDto;
import com.jzhl.kfsq.entity.sm.SMSInfo;

public interface ISMSService {
	
	/**
	 * 将短信息保存至数据库
	 * @param smsInfo
	 */
	public void addSMS(SMSInfo smsInfo);

	/**
	 * 查询手机号
	 * @param smsInfoDto
	 * @return
	 */
	public SMSInfo getNewestSMS(SMSInfoDto smsInfoDto);

	/**
	 * 更新发送次数
	 * @param codeId
	 */
	public void updateSendTimes(Integer codeId);

}
