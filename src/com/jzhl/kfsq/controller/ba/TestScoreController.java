package com.jzhl.kfsq.controller.ba;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jzhl.kfsq.common.base.ResponseBean;
import com.jzhl.kfsq.service.sm.IMarkingService;

/**
 * 测试评分系统管理类
 * 
 * @author Shaw
 *
 */
@Controller
public class TestScoreController {
	
	@Autowired
	private IMarkingService markingService;
	
	@RequestMapping(value = "/serv/getScore", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean getScore() throws Exception{
		markingService.sumScore();
		ResponseBean result = new ResponseBean<>();
		result.operateSuccess("计算评分成功");
		return result;
	}

}
