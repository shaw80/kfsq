package com.jzhl.kfsq.common.service;

/**
 * 系统初始化处理接口。<br/>
 * <br/>
 * 
 * 【功能详细】<br/>
 * <ol>
 * <li>系统初始化处理接口。</li>
 * <p>
 * 1.装载最新的手机端程序版本信息到缓存。
 * </p>
 * </ol>
 * 
 * @author jzhl haojr
 * @version V1.0 2016/05/15 haojr<br/>
 */
public interface ISystemInitService {
	
	/**
	 * 装载最新的手机端程序版本信息到缓存
	 */
	void loadVersionCache() throws Exception;

}
