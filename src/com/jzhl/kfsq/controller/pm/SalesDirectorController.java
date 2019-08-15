package com.jzhl.kfsq.controller.pm;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jzhl.kfsq.common.base.ListResult;
import com.jzhl.kfsq.common.base.ResponseBean;
import com.jzhl.kfsq.dto.pm.SalesDirectorCountDto;
import com.jzhl.kfsq.service.pm.ISalesDirectorService;


@Controller
public class SalesDirectorController {
	
	@Autowired
	private ISalesDirectorService salesDirectorService;
	
	private static final Logger logger = Logger.getLogger(SalesDirectorController.class);
	
	@RequestMapping(value = "/serv/director/findVisitTeam", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean<ListResult> findVisitTeam(SalesDirectorCountDto salesDirectorCountDto) {
		logger.debug("[营销总监]--查询团队排名");
		ListResult result = salesDirectorService.findVisitTeamPage(salesDirectorCountDto);
		return new ResponseBean<ListResult>(result);
	}

}
