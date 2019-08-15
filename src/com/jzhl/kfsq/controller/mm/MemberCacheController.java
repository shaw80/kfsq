package com.jzhl.kfsq.controller.mm;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jzhl.kfsq.common.base.ResponseBean;
import com.jzhl.kfsq.entity.mm.Member;
import com.jzhl.kfsq.service.mm.IMemberCacheService;

/**
 * 会员缓存操作控制类。<br/>
 * <br/>
 * 
 * 【功能详细】<br/>
 * <ol>
 * <li>会员缓存控制类。</li>
 * <p>
 * 1.设定会员信息到缓存中。 
 * 2.设定令牌信息到缓存中。
 * 3.根据会员信息key取得会员信息。
 * 4.根据会员账号取得会员信息。
 * 5.根据令牌取得会员账号。
 * 6.装载所有会员信息到缓存中。
 * 7.在缓存中清楚token。
 * </p>
 * </ol>
 * 
 * @author jzhl haojr
 * @version V1.0 2015/11/25 haojr<br/>
 */
@Controller
public class MemberCacheController {
	
	/**
	 * 日志输出
	 */	
	private static final Logger logger = Logger
			.getLogger(MemberCacheController.class);
	
	/**
	 * 会员缓存信息操作接口
	 */	
	@Autowired
	private IMemberCacheService memberCacheService;
	
	/**
	 * 设定令牌信息到缓存中
	 * 
	 * @param token
	 *            令牌
	 * @param account
	 *            账号
	 */
	@RequestMapping(value = "/serv/memberCache/token/a", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean<Object> addToken(String token, String account)
			throws Exception {

		ResponseBean<Object> result = new ResponseBean<Object>();
		this.memberCacheService.addToken(token, account);
		logger.debug("令牌[" + token + "]更新成功");
		return result;

	}
	
	/**
	 * 根据用户账户取得登录token
	 * 
	 * @param account
	 *            账号
	 * @return token
	 *            令牌
	 */
	@RequestMapping(value = "/serv/memberCache/qta", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean<Map<String, String>> getTokenByAccount(String account)
			throws Exception {

		String value = this.memberCacheService.getTokenByAccount(account);

		Map<String, String> token = new HashMap<String, String>();
		token.put("token", value);
		ResponseBean<Map<String, String>> result = new ResponseBean<Map<String, String>>(
				token);

		return result;

	}
	
	/**
	 * 根据会员账号取得会员信息
	 * 
	 * @param 会员账号
	 * @return 会员信息
	 */	
	@RequestMapping(value = "/serv/memberCache/qma", method = RequestMethod.POST)
	@ResponseBody	
	public ResponseBean<Member> queryMemberByAccount(String account)
			throws Exception {

		Member member = this.memberCacheService.getMemberByAccount(account);
		logger.debug("会员[" + account + "]缓存信息取得成功");

		ResponseBean<Member> result = new ResponseBean<Member>(member);

		return result;

	}
	
	/**
	 * 根据令牌取得会员账号
	 * 
	 * @param token 令牌
	 * @return 会员账号
	 */	
	@RequestMapping(value = "/serv/memberCache/qat", method = RequestMethod.POST)
	@ResponseBody		
	public ResponseBean<Map<String, String>> queryAccountByToken(String token)
			throws Exception {

		String value = this.memberCacheService.getAccountByToken(token);

		Map<String, String> account = new HashMap<String, String>();
		account.put("account", value);
		ResponseBean<Map<String, String>> result = new ResponseBean<Map<String, String>>(
				account);

		return result;

	}
	
	/**
	 * 装载所有会员信息到缓存中
	 */
	@RequestMapping(value = "/serv/memberCache/load", method = RequestMethod.POST)
	@ResponseBody	
	public ResponseBean<Object> loadMemberCache() throws Exception {

		this.memberCacheService.loadMemberCache();

		ResponseBean<Object> result = new ResponseBean<Object>();
		return result;

	}
	
	/**
	 * 在缓存中清楚token
	 * 
	 * @param token 令牌
	 */	
	@RequestMapping(value = "/serv/memberCache/token/d", method = RequestMethod.POST)
	@ResponseBody	
	public ResponseBean<Object> clearToken(String token, String account)
			throws Exception {

		this.memberCacheService.clearToken(token, account);

		ResponseBean<Object> result = new ResponseBean<Object>();
		return result;

	}	

}
