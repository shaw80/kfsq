package com.jzhl.kfsq.controller.sm;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jzhl.kfsq.common.base.ResponseBean;
import com.jzhl.kfsq.dto.sm.EnvelopeRuleDto;
import com.jzhl.kfsq.entity.sm.EnvelopeRule;
import com.jzhl.kfsq.service.sm.IEnvelopeRuleService;

/**
 * 红包管理-红包规则接口类
 * 
 * @author zhouzy
 *
 */
@Controller
public class EnvelopeRuleController {

	@Autowired
	private IEnvelopeRuleService envelopeRuleService;

	/**
	 * 新增红包规则
	 */
	@SuppressWarnings({ "rawtypes" })
	@RequestMapping(value = "/serv/enveloperule/insertenveloperule", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean insertEnvelopeRule(EnvelopeRuleDto envelopeRuleDto) throws Exception {

		// 插入红包规则
		EnvelopeRule envelopeRule = new EnvelopeRule();
		BeanUtils.copyProperties(envelopeRuleDto, envelopeRule);

		envelopeRuleService.insertEnvelopeRule(envelopeRule);

		ResponseBean result = new ResponseBean();
		result.operateSuccess();
		return result;
	}
	
	/**
	 * 根据楼盘编号查询看房红包规则
	 * @return
	 */
	@RequestMapping(value = "/serv/enveloperule/allStatus", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean<EnvelopeRule> getRuleAllStatus(EnvelopeRuleDto dto){
		EnvelopeRule rule = envelopeRuleService.getRuleByBuildingIdAllStatus(dto.getBuildingId());
		ResponseBean<EnvelopeRule> result = new ResponseBean<EnvelopeRule>(rule);
		if(rule != null){
			result.operateSuccess("查询成功");
		}else{
			result.operateSuccess("尚未添加规则");
		}
		return result;
	}

}
