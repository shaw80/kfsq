package com.jzhl.kfsq.dao.sm;

import com.jzhl.kfsq.dto.sm.SMSInfoDto;
import com.jzhl.kfsq.entity.sm.SMSInfo;

public interface ISMSMapper {

	/**
	 * 保存短信数据
	 * @param smsInfo
	 */
	public void insertSMS(SMSInfo SMSInfo);


	/**
	 * 获取最新短信
	 * @param smsInfoDto
	 * @return
	 */
	public SMSInfo getNewestSMS(SMSInfoDto smsInfoDto);
	
	/**
	 * 更新发送次数
	 * @param codeId
	 */
	public void updateSendTimes(java.lang.Integer codeId);

}
