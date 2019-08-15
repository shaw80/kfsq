package com.jzhl.kfsq.controller.fm;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jzhl.kfsq.common.base.ResponseBean;
import com.jzhl.kfsq.dto.fm.CityDto;
import com.jzhl.kfsq.dto.fm.EnvelopeSwitchDto;
import com.jzhl.kfsq.dto.fm.MasterSwitchDto;
import com.jzhl.kfsq.entity.fm.EnvelopeSwitch;
import com.jzhl.kfsq.service.fm.IEnvelopeSwitchService;

/**
 * 红包开关设置
 * 
 * @author zhouzy
 *
 */
@Controller
public class EnvelopeSwitchController {

	@Autowired
	private IEnvelopeSwitchService envelopeSwitchService;

	/**
	 * 红包开关设置
	 * 
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "/serv/envelopeSwitch/updateenvelopeswitch", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean updateEnvelopeSwitch(EnvelopeSwitchDto envelopeSwitchDto) throws Exception {

		EnvelopeSwitch envelopeSwitch = new EnvelopeSwitch();
		BeanUtils.copyProperties(envelopeSwitchDto, envelopeSwitch);

		envelopeSwitchService.updateEnvelopeSwitch(envelopeSwitch);

		ResponseBean result = new ResponseBean();
		result.operateSuccess();
		return result;
	}

	/**
	 * 根据分站编号和开关类型查询总开关信息
	 * 
	 * @param dto
	 * @return
	 */
	@RequestMapping(value = "/serv/envelopeSwitch/envelopeswitchinfo", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean<EnvelopeSwitch> getEnvelopeSwitchInfo(EnvelopeSwitchDto envelopeSwitchDto) {

		EnvelopeSwitch envelopeSwitch = new EnvelopeSwitch();
		BeanUtils.copyProperties(envelopeSwitchDto, envelopeSwitch);
		EnvelopeSwitch resultEnv = envelopeSwitchService.getEnvelopeSwitchInfo(envelopeSwitch);
		ResponseBean<EnvelopeSwitch> result = new ResponseBean<EnvelopeSwitch>(resultEnv);
		result.operateSuccess();
		return result;
	}

	/**
	 * 根据楼盘编号和开关类型查询总开关
	 * 
	 * @param dto
	 * @return
	 */
	@RequestMapping(value = "/serv/envelopeSwitch/masterSwitch", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean<EnvelopeSwitch> getMasterSwitch(MasterSwitchDto dto) {
		EnvelopeSwitch es = envelopeSwitchService.getSwitchByBuildingIdAndSwitchType(dto.getBuildingId(), dto.getSwitchType());
		ResponseBean<EnvelopeSwitch> result = new ResponseBean<EnvelopeSwitch>(es);
		result.operateSuccess("查询成功");
		return result;
	}
	
	/**
	 * 根据城市编号查询看房红包信息
	 * @param dto
	 * @return
	 */
	@RequestMapping(value = "/serv/v2/envelopeSwitch/cityId", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean<Map<String, Object>> getLookhouseSwitchByCityId(CityDto dto){
		String isEnable = envelopeSwitchService.getSwitchByCityId(dto);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("isEnable", isEnable);
		ResponseBean<Map<String, Object>> result = new ResponseBean<Map<String, Object>>(map);
		result.operateSuccess("查询成功");
		return result;
	}
}
