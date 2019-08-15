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
import com.jzhl.kfsq.common.base.PageListCondition;
import com.jzhl.kfsq.common.base.ResponseBean;
import com.jzhl.kfsq.dto.sm.LogDto;
import com.jzhl.kfsq.service.sm.ILogService;

@Controller
public class LogController {
	@Autowired
	private ILogService logService;
	
	/**
	 * 保存操作日志
	 * @param dto
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings({ "rawtypes" })
	@RequestMapping(value = "/serv/savelog", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean insertFeedback(LogDto dto) throws Exception {
		
		logService.insert(dto);
		
		ResponseBean result = new ResponseBean();
		
		result.operateSuccess("添加成功");
		
		return result;
	}
	/**
	 * 分页查询操作日志
	 * 
	 * @author chih
	 * @param
	 * @return ResponseBean
	 */
	@SuppressWarnings({ "rawtypes" })
	@RequestMapping(value = "/serv/logList", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean findBuildingList(PageListCondition page){
		// 分页查询参数
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("rowstart", page.getRowStart());
		map.put("offset", page.getOffset());
		
		List<LogDto> list = logService.findLogList(page);
		// 分页返回
		ListResult listResult = new ListResult();
		listResult.setDataList(list);
		// 总页数
		int dataCount =logService.getCount();
		listResult.setDataCount(dataCount);
		ResponseBean<ListResult> result = new ResponseBean<ListResult>(listResult);
		result.operateSuccess();
		return result;
	}
}
