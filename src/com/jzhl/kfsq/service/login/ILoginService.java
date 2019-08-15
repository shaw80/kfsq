package com.jzhl.kfsq.service.login;

import java.util.List;

import com.jzhl.kfsq.entity.sm.Right;
import com.jzhl.kfsq.entity.sm.Role;
import com.jzhl.kfsq.entity.sm.RoleRight;
import com.jzhl.kfsq.entity.sm.User;

/**
 * 为web端shiro底层提供登录认证授权查询服务的业务层接口
 * 
 * @author Shaw
 *
 */
public interface ILoginService {

	/**
	 * 根据登陆名称查询用户
	 * 
	 * @param account
	 * @return
	 */
	public User getUserByAccount(String account);

	/**
	 * 根据角色编号查询中间表集合
	 * 
	 * @param roleId
	 * @return
	 */
	public List<RoleRight> findRoleRightByRoleId(int roleId);

	/**
	 * 根据角色编号查询角色信息
	 * 
	 * @param RoleId
	 * @return
	 */
	public Role getRole(int RoleId);
	
	/**
	 * 根据权限编号查询权限信息
	 * @param rightId
	 * @return
	 */
	public Right getRight(int rightId);
	
	/**
	 * 根据用户编号查询用户信息
	 * @param userId
	 * @return
	 */
	public User getUserByUserId(User user);

}
