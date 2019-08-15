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
import com.jzhl.kfsq.entity.mm.Follow;
import com.jzhl.kfsq.service.mm.IFollowService;

@Controller
public class FollowController {

	private static final Logger logger = Logger.getLogger(FollowController.class);

	@Autowired
	private IFollowService followService;

	/**
	 * 添加关注
	 * 
	 * @param follow
	 * @return
	 */
	@RequestMapping(value = "/serv/addFollow", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean<Follow> addFollow(Follow follow) {
		logger.debug("[添加关注]--添加...");
		Follow result = followService.insertFollow(follow);
		logger.debug("[添加关注]--添加成功.");
		return new ResponseBean<Follow>(result);
	}

	/**
	 * 修改关注
	 * 
	 * @param follow
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "/serv/modifyFollow", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean modifyFollow(Follow follow) {
		logger.debug("[修改关注]--添加...");
		followService.updateFollow(follow);
		logger.debug("[修改关注]--添加成功.");
		ResponseBean result = new ResponseBean();
		result.operateSuccess();
		return result;
	}

	/**
	 * 查询关注
	 * 
	 * @param follow
	 * @return
	 */
	@RequestMapping(value = "/serv/findFollow", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean<Map<String, Object>> findFollow(Follow follow) {
		Map<String, Object> queryResult = new HashMap<String, Object>();
		ResponseBean<Map<String, Object>> result = new ResponseBean<Map<String, Object>>(queryResult);
		List<Follow> list = followService.findFollow(follow);
		queryResult.put("dataList", list);
		queryResult.put("dataCount", list.size());
		return result;
	}

}
