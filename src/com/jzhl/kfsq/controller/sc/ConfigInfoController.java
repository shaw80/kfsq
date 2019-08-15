package com.jzhl.kfsq.controller.sc;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jzhl.kfsq.common.base.ResponseBean;
import com.jzhl.kfsq.dto.sc.ConfigInfoDto;
import com.jzhl.kfsq.entity.sc.ConfigInfo;
import com.jzhl.kfsq.service.sc.IConfigInfoService;

/**
 * 系统参数配置管理类
 * 
 * @author Shaw
 *
 */
@Controller
public class ConfigInfoController {

	@Autowired
	private IConfigInfoService configInfoService;

	@RequestMapping(value = "/serv/configInfos", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean<Map<String, Object>> findConfigInfoByConfigType(String configType) throws Exception {

		List<ConfigInfo> configs = configInfoService.findConfigInfoByConfigType(Integer.parseInt(configType));

		Map<String, Object> map = new HashMap<String, Object>();

		map.put("bean", configs);

		ResponseBean<Map<String, Object>> result = new ResponseBean<Map<String, Object>>(map);

		result.operateSuccess("查询成功");

		return result;
	}

	/**
	 * 设置余额提醒；设置看房红包状态；设置评论红包状态
	 * 
	 * @author zhouzy
	 */
	@SuppressWarnings({ "rawtypes" })
	@RequestMapping(value = "/serv/configinfo/updateconfiginfo", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean updateConfigInfo(ConfigInfoDto configInfoDto) throws Exception {
		ConfigInfo configInfo = new ConfigInfo();
		BeanUtils.copyProperties(configInfoDto, configInfo);
		configInfoService.updateConfigInfo(configInfo);
		ResponseBean result = new ResponseBean<ConfigInfo>();
		result.operateSuccess();
		return result;
	}

	/**
	 * 查看参数配置信息表信息
	 * 
	 * @author zhouzy
	 */
	@SuppressWarnings({ "rawtypes" })
	@RequestMapping(value = "/serv/configinfo/getconfiginfobyobj", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean getContentInfoByObj(ConfigInfoDto configInfoDto) throws Exception {
		ConfigInfo configInfo = new ConfigInfo();
		BeanUtils.copyProperties(configInfoDto, configInfo);
		ConfigInfo configInfoResult = configInfoService.getConfigInfoByObj(configInfo);
		ResponseBean<ConfigInfo> result = new ResponseBean<ConfigInfo>(configInfoResult);
		result.operateSuccess();
		return result;
	}

	/**
	 * 查看参数配置信息列表
	 * 
	 * @author zhouzy
	 */
	@RequestMapping(value = "/serv/configInfo/configInfos", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean<Map<String, Object>> findConfigInfoList(ConfigInfoDto configInfoDto) throws Exception {

		List<ConfigInfo> configInfoList = configInfoService.findConfigInfoList(configInfoDto);
		
		Map<String, Object> queryResult = new HashMap<String, Object>();
		queryResult.put("dataList", configInfoList);
		ResponseBean<Map<String, Object>> result = new ResponseBean<Map<String, Object>>(queryResult);
		result.operateSuccess("查询成功");
		return result;
	}

}
