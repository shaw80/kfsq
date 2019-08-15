package com.jzhl.kfsq.service.sm.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jzhl.kfsq.dao.sm.IRoleRightMapper;
import com.jzhl.kfsq.entity.sm.RoleRight;
import com.jzhl.kfsq.service.sm.IRoleRightService;

/**
 * 角色权限中间表业务层实现类
 * 
 * @author Shaw
 *
 */
@Service
public class RoleRightServiceImpl implements IRoleRightService {
	
	@Autowired
	private IRoleRightMapper roleRightDao;

	/**
	 * 添加中间关系
	 * 
	 * @param roleRight
	 */
	@Override
	public void insertRoleRight(List<RoleRight> roleRights) {
		for (RoleRight roleRight : roleRights) {
			roleRightDao.insertRoleRight(roleRight);
		}
	}

	/**
	 * 删除中间关系
	 * 
	 * @param roleRightId
	 */
	@Override
	public void deleteRoleRight(int roleRightId) {
		roleRightDao.deleteRoleRight(roleRightId);
	}

	/**
	 * 更新中间关系
	 * 
	 * @param roleRight
	 */
	@Override
	public void updateRoleRight(List<RoleRight> roleRights) {
		RoleRight roleRight = roleRights.get(0);
		roleRightDao.deleteRoleRight(roleRight.getRoleId());
		for (RoleRight roleRight_param : roleRights) {
			roleRightDao.insertRoleRight(roleRight_param);
		}
	}

	/**
	 * 根据主键查询中间关系
	 * 
	 * @param roleRightId
	 * @return
	 */
	@Override
	public RoleRight getRoleRight(int roleRightId) {
		RoleRight roleRight = roleRightDao.getRoleRight(roleRightId);
		return roleRight;
	}

	/**
	 * 根据角色编号查询中间关系
	 * 
	 * @param roleId
	 * @return 中间关系集合
	 */
	@Override
	public List<RoleRight> findRoleRightByRoleId(int roleId) {
		List<RoleRight> result = roleRightDao.findRoleRightByRoleId(roleId);
		return result;
	}

}
