package com.jzhl.kfsq.controller.fm;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jzhl.kfsq.common.base.ResponseBean;
import com.jzhl.kfsq.dto.fm.EnvelopeCashDto;
import com.jzhl.kfsq.entity.fm.EnvelopeCash;
import com.jzhl.kfsq.service.fm.IEnvelopeCashService;

/**
 * 红包、提现中间表管理类
 * 
 * @author Shaw
 *
 */
@Controller
public class EnvelopeCashController {

	@Autowired
	private IEnvelopeCashService envelopeCashService;

	/**
	 * 删除中间表
	 * 
	 * @param dto
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "/serv/envelopeCash/d", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean deleteEnvelopeCash(EnvelopeCashDto dto) {
		envelopeCashService.deleteEnvelopeCash(dto.getEnvelopeCashId());
		ResponseBean result = new ResponseBean();
		result.operateSuccess("删除成功");
		return result;
	}

	/**
	 * 根据申请编号查询中间表集合
	 * 
	 * @param dto
	 * @return
	 */
	@RequestMapping(value = "/serv/envelopeCashs/appliId", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean<Map<String, Object>> findEnvelopeCashByApplicationId(
			EnvelopeCashDto dto) {
		List<EnvelopeCash> envelopeCashs = envelopeCashService
				.findEnvelopeCashByApplicationId(dto.getApplicationId());
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("envelopeCashs", envelopeCashs);
		ResponseBean<Map<String, Object>> result = new ResponseBean<Map<String, Object>>(
				map);
		result.operateSuccess("查询成功");
		return result;
	}

}
