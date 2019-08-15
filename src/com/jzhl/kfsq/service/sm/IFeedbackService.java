package com.jzhl.kfsq.service.sm;

import java.util.List;
import java.util.Map;

import com.jzhl.kfsq.entity.sm.Feedback;

/**
 * 意见反馈接口
 * 
 * @author zhouzy
 *
 */
public interface IFeedbackService {

	/**
	 * 添加反馈
	 * 
	 * @param feedback
	 */
	public void insertFeedback(Feedback feedback);

	/**
	 * 查看意见反馈详情
	 * 
	 */
	public Feedback getFeedback(Feedback feedback);

	/**
	 * 查询意见反馈列表
	 * 
	 */
	public List<Feedback> findFeedbackList(Map<String, Object> map);

	/**
	 * 查询意见反馈列表总数
	 * 
	 */
	public int findFeedbackDataCount();

}
