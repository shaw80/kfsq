package com.jzhl.kfsq.controller.sm;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jzhl.kfsq.common.base.ListResult;
import com.jzhl.kfsq.common.base.ResponseBean;
import com.jzhl.kfsq.dto.sm.FeddbackInsertDto;
import com.jzhl.kfsq.dto.sm.FeedbackDto;
import com.jzhl.kfsq.entity.sm.Feedback;
import com.jzhl.kfsq.service.sm.IFeedbackService;

/**
 * 意见反馈对外接口类
 * 
 * @author zhouzy
 *
 */
@Controller
public class FeedbackController {

	@Autowired
	private IFeedbackService feedbackService;

	/**
	 * 添加反馈
	 * 
	 * @param feedback
	 * @return
	 */
	@SuppressWarnings({ "rawtypes" })
	@RequestMapping(value = "/serv/feedback", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean insertFeedback(FeddbackInsertDto dto) throws Exception {

		Feedback feedback = new Feedback();

		feedback.setContentValue(dto.getContentValue());

		feedback.setMemberId(dto.getMemberId());

		feedback.setCreateTime(new Timestamp(System.currentTimeMillis()));

		feedbackService.insertFeedback(feedback);

		ResponseBean result = new ResponseBean();

		result.operateSuccess("添加成功");

		return result;
	}

	/**
	 * 获取意见反馈列表
	 * 
	 * @return ResponseBean
	 */
	@SuppressWarnings({ "rawtypes" })
	@RequestMapping(value = "/serv/feedback/findfeedbacklist", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean findFeedbackList(FeedbackDto feedbackDto) throws Exception {
		// 分页查询参数
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("rowstart", feedbackDto.getRowStart());
		map.put("offset", feedbackDto.getOffset());
		List<Feedback> feedbacklist = feedbackService.findFeedbackList(map);

		// 分页返回
		ListResult listResult = new ListResult();
		listResult.setDataList(feedbacklist);

		// 总页数
		int dataCount = feedbackService.findFeedbackDataCount();
		listResult.setDataCount(dataCount);

		ResponseBean<ListResult> result = new ResponseBean<ListResult>(listResult);
		result.operateSuccess();
		return result;
	}

	/**
	 * 查询意见反馈详情
	 *
	 * @return ResponseBean
	 */
	@SuppressWarnings({ "rawtypes" })
	@RequestMapping(value = "/serv/feedback/getfeedbackinfo", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean getFeedbackInfo(FeedbackDto feedbackDto) throws Exception {
		Feedback feedback = new Feedback();
		BeanUtils.copyProperties(feedbackDto, feedback);
		Feedback queryResult = feedbackService.getFeedback(feedback);
		ResponseBean<Feedback> result = new ResponseBean<Feedback>(queryResult);
		result.operateSuccess();
		return result;
	}
}
