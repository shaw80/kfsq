package com.jzhl.kfsq.controller.sm;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jzhl.kfsq.common.base.ListResult;
import com.jzhl.kfsq.common.base.ResponseBean;
import com.jzhl.kfsq.dto.sm.RemindInfoDto;
import com.jzhl.kfsq.entity.sm.RemindInfo;
import com.jzhl.kfsq.service.sm.IRemindInfoService;

/**
 * 提醒列表接口类
 * 
 * @author zhouzy
 *
 */
@Controller
public class RemindInfoController {

	@Autowired
	private IRemindInfoService remindInfoService;

	/**
	 * 获取提醒列表
	 * 
	 * @param
	 * @return ResponseBean
	 */
	@SuppressWarnings({ "rawtypes" })
	@RequestMapping(value = "/serv/remindInfo/findremindinfolist", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean findRemindInfoList(RemindInfoDto remindInfoDto) throws Exception {
		// 分页查询参数
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("rowstart", remindInfoDto.getRowStart());
		map.put("offset", remindInfoDto.getOffset());

		// 查询提醒列表
		List<RemindInfo> remindInfoList = remindInfoService.findRemindInfoList(map);

		// 分页返回
		ListResult listResult = new ListResult();
		listResult.setDataList(remindInfoList);

		// 总页数
		int dataCount = remindInfoService.getRemindInfoDataCount(map);
		listResult.setDataCount(dataCount);

		ResponseBean<ListResult> result = new ResponseBean<ListResult>(listResult);
		result.operateSuccess();
		return result;
	}

}
