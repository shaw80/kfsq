package com.jzhl.kfsq.service.mm.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jzhl.kfsq.common.base.RedisOperator;
import com.jzhl.kfsq.common.util.ValidateUtil;
import com.jzhl.kfsq.dao.mm.IMemberMapper;
import com.jzhl.kfsq.entity.mm.Member;
import com.jzhl.kfsq.service.mm.IMemberCacheService;

/**
 * 会员信息缓存处理服务实现类。<br/>
 * <br/>
 * 
 * 【功能详细】<br/>
 * <ol>
 * <li>会员信息缓存处理服务。</li>
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
@Service
public class MemberCacheServiceImpl implements IMemberCacheService {
	
	@Autowired
	private IMemberMapper memberDao = null;
	
	/**
	 * 设定会员信息到缓存中
	 * 
	 * @param member
	 *            会员信息
	 */
	public void addOrUpdate(Member member) throws Exception {

		String key = new StringBuffer("Client").append(member.getAccount())
				.toString();
		String value = String.valueOf(member.getMemberId());
		RedisOperator.addOrUpdateValue(key, value);

	}
	
	/**
	 * 设定令牌信息到缓存中
	 * 
	 * @param token 令牌
	 * @param account 账号
	 */
	public void addToken(String token, String account) throws Exception {
		
		// 以token为key保管登录信息
		RedisOperator.addOrUpdateValue(token, account);
		// 以account为key保管token信息
		String key = new StringBuffer("Login#Client").append(account)
				.toString();
		RedisOperator.addOrUpdateValue(key, token);
		
	}
	
	/**
	 * 根据登录账号获取登录token
	 * 
	 * @param account 账号
	 * @return 登录token
	 */
	public String getTokenByAccount(String account) throws Exception {

		String result = null;

		String key = new StringBuffer("Login#Client").append(account)
				.toString();
		result = RedisOperator.loadValue(key);

		return (ValidateUtil.isEmpty(result) || "null".equals(result)) ? ""
				: result;

	}
	
	/**
	 * 根据会员信息key取得会员信息
	 * 
	 * @param 会员信息key
	 * @return 会员信息
	 */
	public Member getMember(Member member) throws Exception {
		throw new RuntimeException("暂未实现");
	}
	
	/**
	 * 根据会员账号取得会员信息
	 * 
	 * @param 会员账号
	 * @return 会员信息
	 */	
	public Member getMemberByAccount(String account) throws Exception {

		Member result = new Member();

		String key = new StringBuffer("Client").append(account).toString();
		String value = RedisOperator.loadValue(key);
		value = ValidateUtil.isEmpty(value) ? null : value;
		result.setMemberId(value == null ? null : Integer.parseInt(value));
		result.setAccount(account);

		return result;

	}
	
	/**
	 * 根据令牌取得会员账号
	 * 
	 * @param token 令牌
	 * @return 会员账号
	 */	
	public String getAccountByToken(String token) throws Exception {
		return RedisOperator.loadValue(token);
	}
	
	/**
	 * 装载所有会员信息到缓存中
	 */
	public void loadMemberCache() throws Exception {

		// 取得有效会员信息
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("isValid", 1);
		List<Member> memberList = this.memberDao.getMembers(params);
		if (ValidateUtil.isEmpty(memberList)) {
			return;
		}

		// 装载到缓存中
		Map<String, Object> members = new HashMap<String, Object>();
		for (Member member : memberList) {
			members.put(new StringBuffer("Client").append(member.getAccount())
					.toString(), String.valueOf(member.getMemberId()));
		}
		RedisOperator.addOrUpdateValue(members);

	}
	
	/**
	 * 在缓存中清除token
	 * 
	 * @param token 令牌
	 * @param account 账号
	 */	
	public void clearToken(String token, String account) throws Exception {

		// 清除缓存中的token
		if (ValidateUtil.isNotEmpty(token)) {
			RedisOperator.delete(token);
		}

		// 清除登入用户的账户信息及对应的token
		if (ValidateUtil.isNotEmpty(account)) {
			String key = new StringBuffer("Login#Client").append(account)
					.toString();
			String account_token = RedisOperator.loadValue(key);
			RedisOperator.delete(key);
			if (ValidateUtil.isNotEmpty(account_token)) {
				RedisOperator.delete(account_token);
			}
		}

	}
	
	/**
	 * 在缓存中清除账户
	 * 
	 * @param account
	 *            账户
	 */
	public void clearAccount(String account) throws Exception {
		RedisOperator.delete(new StringBuffer("Client").append(account)
				.toString());
	}

}
