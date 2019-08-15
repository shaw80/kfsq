package com.jzhl.kfsq.service.mm;

import com.jzhl.kfsq.entity.mm.Member;

/**
 * 会员信息缓存处理服务接口。<br/>
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
public interface IMemberCacheService {
	
	/**
	 * 设定会员信息到缓存中
	 * 
	 * @param member 会员信息
	 */
	void addOrUpdate(Member member) throws Exception;
	
	/**
	 * 设定令牌信息到缓存中
	 * 
	 * @param token 令牌
	 * @param account 账号
	 */
	void addToken(String token, String account) throws Exception;	
	
	/**
	 * 根据登录账号获取登录token
	 * 
	 * @param account 账号
	 * @return 登录token
	 */
	String getTokenByAccount(String account) throws Exception;
	
	/**
	 * 根据会员信息key取得会员信息
	 * 
	 * @param 会员信息key
	 * @return 会员信息
	 */
	Member getMember(Member member) throws Exception;	
	
	/**
	 * 根据会员账号取得会员信息
	 * 
	 * @param 会员账号
	 * @return 会员信息
	 */	
	Member getMemberByAccount(String account) throws Exception;
	
	/**
	 * 根据令牌取得会员账号
	 * 
	 * @param token 令牌
	 * @return 会员账号
	 */	
	String getAccountByToken(String token) throws Exception;
	
	/**
	 * 装载所有会员信息到缓存中
	 */	
	void loadMemberCache() throws Exception;
	
	/**
	 * 在缓存中清除token
	 * 
	 * @param token 令牌
	 * @param account 账号
	 */	
	void clearToken(String token, String account) throws Exception;
	
	/**
	 * 在缓存中清除账户
	 * 
	 * @param account 账户
	 */	
	void clearAccount(String account) throws Exception;	

}
