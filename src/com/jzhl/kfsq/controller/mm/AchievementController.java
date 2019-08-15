package com.jzhl.kfsq.controller.mm;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jzhl.kfsq.common.base.ResponseBean;
import com.jzhl.kfsq.dataset.mm.AchievementDataSet;
import com.jzhl.kfsq.service.mm.IAchievementService;

@Controller
public class AchievementController {

	private static final Logger logger = Logger.getLogger(AchievementController.class);

	@Autowired
	private IAchievementService achievementService;

	@RequestMapping(value = "/serv/achievement", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean<Map<String, Object>> findAchievement(int memberId) throws Exception {

		Map<String, Object> queryResult = new HashMap<String, Object>();
		ResponseBean<Map<String, Object>> result = new ResponseBean<Map<String, Object>>(queryResult);

		logger.debug("[获取个人成就]--获取");
		List<AchievementDataSet> list = achievementService.findAchievement(memberId);
		queryResult.put("dataList", list);
		queryResult.put("dataCount", list.size());
		return result;

	}

}
