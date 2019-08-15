package com.jzhl.kfsq.controller.sm;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jzhl.kfsq.common.base.ResponseBean;
import com.jzhl.kfsq.entity.sm.User;
import com.jzhl.kfsq.service.sm.IUserCacheService;

/**
 * B端用户信息缓存处理控制类。<br/>
 * <br/>
 * 
 * 【功能详细】<br/>
 * <ol>
 * <li>B端用户信息缓存处理控制类。</li>
 * <p>
 * 1.设定B端用户信息到缓存中。 
 * 2.设定令牌信息到缓存中。
 * 3.根据B端用户信息key取得B端用户信息。
 * 4.根据B端用户账号取得B端用户信息。
 * 5.根据令牌取得B端用户账号。
 * 6.装载所有B端用户信息到缓存中。
 * 7.在缓存中清除token。
 * </p>
 * </ol>
 * 
 * @author jzhl haojr
 * @version V1.0 2015/11/26 haojr<br/>
 */
@Controller
public class UserCacheController {
	
	/**
	 * 日志输出
	 */	
	private static final Logger logger = Logger
			.getLogger(UserCacheController.class);
	
	/**
	 * B端用户缓存信息操作接口
	 */	
	@Autowired
	private IUserCacheService userCacheService;
	
	/**
	 * 设定令牌信息到缓存中
	 * 
	 * @param token
	 *            令牌
	 * @param account
	 *            账号
	 */
	@RequestMapping(value = "/serv/userCache/token/a", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean<Object> addToken(String token, String account)
			throws Exception {

		ResponseBean<Object> result = new ResponseBean<Object>();
		this.userCacheService.addToken(token, account);
		logger.debug("令牌[" + token + "]更新成功");
		return result;

	}
	
	/**
	 * 根据B端用户账号取得用户信息
	 * 
	 * @param B端用户账号
	 * @return B端用户信息
	 */	
	@RequestMapping(value = "/serv/userCache/qma", method = RequestMethod.POST)
	@ResponseBody	
	public ResponseBean<User> queryUserByAccount(String account)
			throws Exception {

		User user = this.userCacheService.getUserByAccount(account);
		logger.debug("B端用户[" + account + "]缓存信息取得成功");

		ResponseBean<User> result = new ResponseBean<User>(user);

		return result;

	}
	
	/**
	 * 根据令牌取得B端用户账号
	 * 
	 * @param token 令牌
	 * @return B端用户账号
	 */	
	@RequestMapping(value = "/serv/userCache/qat", method = RequestMethod.POST)
	@ResponseBody		
	public ResponseBean<Map<String, String>> queryAccountByToken(String token)
			throws Exception {

		String value = this.userCacheService.getAccountByToken(token);

		Map<String, String> account = new HashMap<String, String>();
		account.put("account", value);
		ResponseBean<Map<String, String>> result = new ResponseBean<Map<String, String>>(
				account);

		return result;

	}
	
	/**
	 * 装载所有B端用户信息到缓存中
	 */
	@RequestMapping(value = "/serv/userCache/load", method = RequestMethod.POST)
	@ResponseBody	
	public ResponseBean<Object> loadUserCache() throws Exception {

		this.userCacheService.loadUserCache();

		ResponseBean<Object> result = new ResponseBean<Object>();
		return result;

	}
	
	/**
	 * 在缓存中清楚token
	 * 
	 * @param token 令牌
	 * @param account 账号
	 */	
	@RequestMapping(value = "/serv/userCache/token/d", method = RequestMethod.POST)
	@ResponseBody	
	public ResponseBean<Object> clearToken(String token, String account) throws Exception {

		this.userCacheService.clearToken(token, account);

		ResponseBean<Object> result = new ResponseBean<Object>();
		return result;

	}		

}
