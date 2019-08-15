package com.jzhl.kfsq.controller.pm;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jzhl.kfsq.common.base.ResponseBean;
import com.jzhl.kfsq.dto.pm.IsVisitDto;
import com.jzhl.kfsq.entity.pm.SalerCustomer;
import com.jzhl.kfsq.service.pm.ISalerCustomerService;

/**
 * 客户到访管理类
 * 
 * @author Shaw
 *
 */
@Controller
public class SalerCustomerController {
	
	@Autowired
	private ISalerCustomerService salerCustomerService;
	
	/**
	 * 根据会员编号和楼盘编号查询客户是否到访
	 * @return
	 */
	@RequestMapping(value="serv/getIsVisit", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean<Map<String, Object>> getIsVisit(IsVisitDto dto){
		Boolean isVisit = salerCustomerService.isVisit(dto.getMemberId(), dto.getBuildingId());
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("isVisit", isVisit);
		ResponseBean<Map<String, Object>> result = new ResponseBean<Map<String, Object>>(map);
		result.operateSuccess("查询成功");
		return result;
	}
	
	/**
	 * 添加到访记录
	 * @return
	 */
	@RequestMapping(value="serv/salercustomer", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean<SalerCustomer> addSalerCustomer(SalerCustomer salerCustomer){
		salerCustomer = salerCustomerService.addSalerCustomer(salerCustomer);
		ResponseBean<SalerCustomer> result = new ResponseBean<SalerCustomer>(salerCustomer);
		result.operateSuccess("到访记录添加成功");
		return result;
	}

}
