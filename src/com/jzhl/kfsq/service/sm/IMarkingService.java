package com.jzhl.kfsq.service.sm;


/**
 * 评分业务层接口
 * 
 * @author Shaw
 *
 */
public interface IMarkingService {

	/**
	 * 计算系统户型评分
	 * 
	 * @param tagName
	 * @return
	 * @throws Exception 
	 */
	public void sumScore() throws Exception;

}
