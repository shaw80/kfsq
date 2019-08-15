package com.jzhl.kfsq.dao.sm;

import java.util.List;
import java.util.Map;

import com.jzhl.kfsq.entity.sm.Feedback;

/**
 * 意见反馈接口
 * 
 * @author zhouzy
 *
 */
public interface IFeedbackMapper {

	/**
	 * 添加反馈
	 * 
	 * @param feedback
	 */
	public void insertFeedback(Feedback feedback);

	/**
	 * 获取意见反馈详情
	 * 
	 * @param id
	 * @return
	 */
	public Feedback getFeedback(Feedback feedback);

	/**
	 * 获取意见返回列表
	 * 
	 * @return 意见返回集合
	 */
	public List<Feedback> findFeedbackList(Map<String, Object> map);

	/**
	 * 获取意见返回列表总数
	 */
	public int findFeedbackDataCount();

}
