package com.jzhl.kfsq.service.sm.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jzhl.kfsq.dao.sm.IFeedbackMapper;
import com.jzhl.kfsq.entity.sm.Feedback;
import com.jzhl.kfsq.service.sm.IFeedbackService;

/**
 * 意见反馈实现类
 * 
 * @author zhouzy
 *
 */
@Service
public class FeedbackServiceImpl implements IFeedbackService {

	@Autowired
	private IFeedbackMapper feedbackDao;

	/**
	 * 添加反馈
	 */
	@Override
	public void insertFeedback(Feedback feedback) {
		feedbackDao.insertFeedback(feedback);
	}

	/**
	 * 查看意见反馈详情
	 */
	@Override
	public Feedback getFeedback(Feedback param) {
		Feedback feedback = feedbackDao.getFeedback(param);
		return feedback;
	}

	/**
	 * 查看意见反馈列表
	 */
	@Override
	public List<Feedback> findFeedbackList(Map<String, Object> map) {
		List<Feedback> result = feedbackDao.findFeedbackList(map);
		return result;
	}

	/**
	 * 查看意见反馈列表总数
	 */
	@Override
	public int findFeedbackDataCount() {
		int dataCount = feedbackDao.findFeedbackDataCount();
		return dataCount;
	}

}
