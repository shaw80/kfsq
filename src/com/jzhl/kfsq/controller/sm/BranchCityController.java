package com.jzhl.kfsq.controller.sm;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jzhl.kfsq.common.base.ResponseBean;
import com.jzhl.kfsq.dataset.sm.BranchCityDataSet;
import com.jzhl.kfsq.dto.login.IsOpenDto;
import com.jzhl.kfsq.service.sm.IBranchCityService;

/**
 * 分站城市管理类
 * 
 * @author Shaw
 *
 */
@Controller
public class BranchCityController {

	@Autowired
	private IBranchCityService branchCityService;

	/**
	 * 判断分站城市是否开通
	 * 
	 * @param branchId
	 * @return
	 */
	@RequestMapping(value = "/serv/branchCity/isOpen", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean<Map<String, Object>> isOpen(IsOpenDto dto) {
		Boolean isOpen = branchCityService.isOpen(dto.getBranchId());
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("isOpen", isOpen);
		ResponseBean<Map<String, Object>> result = new ResponseBean<Map<String, Object>>(param);
		result.operateSuccess("查询成功");
		return result;
	}

	/**
	 * 获取所有开通代理商的城市
	 * 
	 * @author zhouzy
	 * @return
	 */
	@RequestMapping(value = "/serv/branchCity/branchCityList", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean<Map<String, Object>> getBranchCityList() {

		// 查询列表
		List<BranchCityDataSet> branchCityList = branchCityService.getBranchCityList();
		// 返回参数
		Map<String, Object> queryResult = new HashMap<String, Object>();
		queryResult.put("dataList", branchCityList);
		ResponseBean<Map<String, Object>> result = new ResponseBean<Map<String, Object>>(queryResult);
		result.operateSuccess();
		return result;
	}

}
