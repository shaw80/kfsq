package com.jzhl.kfsq.service.sm;

import com.jzhl.kfsq.entity.sm.User;

/**
 * B端用户信息缓存处理服务接口。<br/>
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
public interface IUserCacheService {
	
	/**
	 * 设定用户信息到缓存中
	 * 
	 * @param User B端用户信息
	 */
	void addOrUpdate(User user) throws Exception;
	
	/**
	 * 设定令牌信息到缓存中
	 * 
	 * @param token 令牌
	 * @param account 账号
	 */
	void addToken(String token, String account) throws Exception;	
	
	/**
	 * 根据B端用户信息key取得B端用户信息
	 * 
	 * @param B端用户信息key
	 * @return B端用户信息
	 */
	User getUser(User user) throws Exception;	
	
	/**
	 * 根据B端用户账号取得B端用户信息
	 * 
	 * @param B端用户账号
	 * @return B端用户信息
	 */	
	User getUserByAccount(String account) throws Exception;
	
	/**
	 * 根据令牌取得B端用户账号
	 * 
	 * @param token 令牌
	 * @return B端用户账号
	 */	
	String getAccountByToken(String token) throws Exception;
	
	/**
	 * 装载所有B端用户信息到缓存中
	 */	
	void loadUserCache() throws Exception;
	
	/**
	 * 在缓存中清除token
	 * 
	 * @param token 令牌
	 * @param account 账号
	 */	
	void clearToken(String token, String account) throws Exception;
	
	/**
	 * 在缓存中清除用户信息
	 * 
	 * @param account
	 *            账户
	 */
	void clearAccount(String account) throws Exception;

}
