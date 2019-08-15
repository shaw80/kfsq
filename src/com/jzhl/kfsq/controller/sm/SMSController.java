package com.jzhl.kfsq.controller.sm;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jzhl.kfsq.common.base.ResponseBean;
import com.jzhl.kfsq.common.util.SMSConfig;
import com.jzhl.kfsq.common.util.SMSUtil;
import com.jzhl.kfsq.dto.sm.SMSInfoDto;
import com.jzhl.kfsq.entity.sm.SMSInfo;
import com.jzhl.kfsq.service.sm.ISMSService;

@Controller
public class SMSController {

	private static final Logger logger = Logger.getLogger(SMSController.class);

	@Autowired
	private ISMSService smsService;

	/**
	 * 发送短信
	 * 
	 * @param smsInfoDto
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "/serv/sendSMS", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean sendSMS(SMSInfoDto smsInfoDto) throws Exception {
		logger.debug("[发送短信]--");
		ResponseBean result = new ResponseBean();
		// 校验
		String mobilePhone = checkPhone(smsInfoDto.getMobilePhone());
		if (mobilePhone == null) {
			result.operateFail("非法手机号！");
			return result;
		}
		String templateId = SMSConfig.getTemplateIdBySmsType("" + smsInfoDto.getSmsType());
		if (templateId == null) {
			result.operateFail("非法短信类型！");
			return result;
		}

		SMSInfo smsInfo = new SMSInfo();
		BeanUtils.copyProperties(smsInfoDto, smsInfo);
		smsInfo.setMobilePhone(mobilePhone);
		smsInfo.setTemplateId(templateId);

		// 发送短信
		SMSInfo smsResult = SMSUtil.sendSM(smsInfo);

		// 保存数据库
		smsService.addSMS(smsResult);

		if (!SMSUtil.SUCCESS.equals(smsResult.getStatusCode())) {
			result.operateFail("短信发送失败！！！");
		}
		return result;
	}

	/**
	 * 获取发送成功的最近的短信信息
	 * 
	 * @param smsInfoDto
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/serv/getNewestSMS", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean<SMSInfo> getNewestSMS(SMSInfoDto smsInfoDto) throws Exception {
		SMSInfo result = smsService.getNewestSMS(smsInfoDto);
		return new ResponseBean<SMSInfo>(result);
	}

	/**
	 * 重发短信
	 * 
	 * @param codeId
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "/serv/resendSMS", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean updateSendTimes(SMSInfoDto smsInfoDto) throws Exception {
		logger.debug("[发送短信]--");
		ResponseBean result = new ResponseBean();
		// 校验
		String mobilePhone = checkPhone(smsInfoDto.getMobilePhone());
		if (mobilePhone == null) {
			result.operateFail("非法手机号！");
			return result;
		}
		String templateId = SMSConfig.getTemplateIdBySmsType("" + smsInfoDto.getSmsType());
		if (templateId == null) {
			result.operateFail("非法短信类型！");
			return result;
		}

		SMSInfo smsInfo = new SMSInfo();
		BeanUtils.copyProperties(smsInfoDto, smsInfo);
		smsInfo.setMobilePhone(mobilePhone);
		smsInfo.setTemplateId(templateId);

		// 发送短信
		SMSInfo smsResult = SMSUtil.sendSM(smsInfo);

		// 只在发送成功的短信上，做更新操作；发送失败则新建一条记录。每次查询只查成功的，失败的短信只做记录
		if (!SMSUtil.SUCCESS.equals(smsResult.getStatusCode())) {
			// 重发失败，则新建一条记录
			smsService.addSMS(smsResult);
			result.operateFail("短信发送失败！！！");
		} else {
			// 重发成功，则更新原纪录的发送次数
			smsService.updateSendTimes(smsInfoDto.getCodeId());
		}
		return result;
	}

	/**
	 * 检验手机号
	 * 
	 * @param phone
	 * @return
	 */
	private String checkPhone(String phone) {
		if (phone == null || phone.isEmpty()) {
			return null;
		}
		if (phone.length() == 11) {
			return phone;
		}
		if (phone.startsWith("+86") && phone.length() == 14) {
			return phone.substring(3, 14);
		}
		if (phone.startsWith("86") && phone.length() == 13) {
			return phone.substring(2, 13);
		}
		return null;
	}

	// /**
	// * 通过smsType获取templateId
	// * @param smsType
	// * @return
	// */
	// private String getTemplateId(Short smsType) {
	// if(smsType == 0 || smsType == 1 || smsType == 2) {
	// return "52215";
	// }
	// return null;
	// }

}
