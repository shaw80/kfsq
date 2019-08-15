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
import com.jzhl.kfsq.dataset.sm.RightDataSet;
import com.jzhl.kfsq.dataset.sm.RightDetailDataSet;
import com.jzhl.kfsq.dto.sm.RightQueryDto;
import com.jzhl.kfsq.service.sm.IRightService;

/**
 * 权限管理类
 * 
 * @author Shaw
 *
 */
@Controller
public class RightController {
	
	@Autowired
	private IRightService rightService;
	
	/**
	 * WEB端根据角色编号和父编号查询权限列表
	 * @param dto
	 * @return
	 */
	@RequestMapping(value = "/serv/right/parentId", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean<Map<String, Object>> findRightByParentId(RightQueryDto dto){
		List<RightDataSet> list = rightService.findRightByParentId(dto);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("rights", list);
		ResponseBean<Map<String, Object>> result = new ResponseBean<Map<String, Object>>(map);
		result.operateSuccess("查询成功");
		return result;
	}
	
	/**
	 * WEB端查询角色权限详情
	 * @param dto
	 * @return
	 */
	@RequestMapping(value = "/serv/right/detail", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean<RightDetailDataSet> getRightDetailDataSet(RightQueryDto dto){
		RightDetailDataSet data = rightService.getRightDetailDataSet(dto);
		ResponseBean<RightDetailDataSet> result = new ResponseBean<RightDetailDataSet>(data);
		result.operateSuccess("查询成功");
		return result;
	}

}
