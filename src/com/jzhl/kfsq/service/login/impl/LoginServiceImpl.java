package com.jzhl.kfsq.service.login.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.jzhl.kfsq.dao.sm.IRightMapper;
import com.jzhl.kfsq.dao.sm.IRoleMapper;
import com.jzhl.kfsq.dao.sm.IRoleRightMapper;
import com.jzhl.kfsq.dao.sm.IUserMapper;
import com.jzhl.kfsq.entity.sm.Right;
import com.jzhl.kfsq.entity.sm.Role;
import com.jzhl.kfsq.entity.sm.RoleRight;
import com.jzhl.kfsq.entity.sm.User;
import com.jzhl.kfsq.service.login.ILoginService;

/**
 * 为web端shiro底层提供登录认证授权查询服务的业务层实现类
 * 
 * @author Shaw
 *
 */
@Service
public class LoginServiceImpl implements ILoginService {
	
	@Autowired
	@Qualifier("IUserMapper")
	private IUserMapper userDao;

	@Autowired
	@Qualifier("IRoleMapper")
	private IRoleMapper roleDao;
	
	@Autowired
	@Qualifier("IRightMapper")
	private IRightMapper rightDao;

	@Autowired
	@Qualifier("IRoleRightMapper")
	private IRoleRightMapper roleRightDao;

	/**
	 * 根据登陆名称查询用户
	 * 
	 * @param account
	 * @return
	 */
	@Override
	public User getUserByAccount(String account) {
		User user = userDao.getUserByAccount(account);// 根据登陆名称查询用户
		return user;
	}

	/**
	 * 根据角色编号查询中间表集合
	 * 
	 * @param roleId
	 * @return
	 */
	@Override
	public List<RoleRight> findRoleRightByRoleId(int roleId) {
		List<RoleRight> result = roleRightDao.findRoleRightByRoleId(roleId);// 根据角色编号查询中间表集合
		return result;
	}

	/**
	 * 根据角色编号查询角色信息
	 * 
	 * @param RoleId
	 * @return
	 */
	@Override
	public Role getRole(int RoleId) {
		Role role = roleDao.getRole(RoleId);// 根据角色编号查询角色信息
		return role;
	}

	/**
	 * 根据权限编号查询权限信息
	 * @param rightId
	 * @return
	 */
	@Override
	public Right getRight(int rightId) {
		Right right = rightDao.getRight(rightId);// 根据权限编号查询权限信息
		return right;
	}
	
	/**
	 * 根据用户编号查询用户信息
	 * @param userId
	 * @return
	 */
	public User getUserByUserId(User param){
		User user = userDao.getUser(param);
		return user;
	}

}
