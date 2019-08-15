package com.jzhl.kfsq.service.sm.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jzhl.kfsq.common.base.RedisOperator;
import com.jzhl.kfsq.common.util.ValidateUtil;
import com.jzhl.kfsq.dao.sm.IUserMapper;
import com.jzhl.kfsq.entity.sm.User;
import com.jzhl.kfsq.service.sm.IUserCacheService;

/**
 * B端用户信息缓存处理服务类。<br/>
 * <br/>
 * 
 * 【功能详细】<br/>
 * <ol>
 * <li>B端用户信息缓存处理服务。</li>
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
@Service
public class UserCacheServiceImpl implements IUserCacheService {
	
	@Autowired
	private IUserMapper userDao = null;
	
	/**
	 * 设定用户信息到缓存中
	 * 
	 * @param User B端用户信息
	 */
	public void addOrUpdate(User user) throws Exception {

		String key = new StringBuffer("Business").append(user.getAccount())
				.toString();
		String value = String.valueOf(user.getUserId());
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
		String key = new StringBuffer("Login#Business").append(account)
				.toString();
		RedisOperator.addOrUpdateValue(key, token);
		
	}
	
	/**
	 * 根据B端用户信息key取得B端用户信息
	 * 
	 * @param B端用户信息key
	 * @return B端用户信息
	 */
	public User getUser(User user) throws Exception {
		throw new RuntimeException("暂未实现");
	}
	
	/**
	 * 根据B端用户账号取得B端用户信息
	 * 
	 * @param B端用户账号
	 * @return B端用户信息
	 */	
	public User getUserByAccount(String account) throws Exception {

		User result = new User();

		String key = new StringBuffer("Business").append(account).toString();
		String value = RedisOperator.loadValue(key);
		value = ValidateUtil.isEmpty(value) ? null : value;
		result.setUserId(value == null ? null : Integer.parseInt(value));
		result.setAccount(account);

		return result;

	}
	
	/**
	 * 根据令牌取得B端用户账号
	 * 
	 * @param token 令牌
	 * @return B端用户账号
	 */	
	public String getAccountByToken(String token) throws Exception {
		return RedisOperator.loadValue(token);
	}
	
	/**
	 * 装载所有B端用户信息到缓存中
	 */	
	public void loadUserCache() throws Exception {
		
		// 取得有效会员信息
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("isValid", 1);
		params.put("userType", 1);
		List<User> userList = this.userDao.getUsers(params);
		if (ValidateUtil.isEmpty(userList)) {
			return;
		}

		// 装载到缓存中
		Map<String, Object> users = new HashMap<String, Object>();
		for (User user : userList) {
			users.put(new StringBuffer("Business").append(user.getAccount())
					.toString(), String.valueOf(user.getUserId()));
		}
		RedisOperator.addOrUpdateValue(users);
		
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
			String key = new StringBuffer("Login#Business").append(account)
					.toString();
			String account_token = RedisOperator.loadValue(key);
			RedisOperator.delete(key);
			if (ValidateUtil.isNotEmpty(account_token)) {
				RedisOperator.delete(account_token);
			}			
		}		

	}
	
	/**
	 * 在缓存中清除用户信息
	 * 
	 * @param account
	 *            账户
	 */
	public void clearAccount(String account) throws Exception {
		RedisOperator.delete(new StringBuffer("Business").append(account)
				.toString());
	}

}
