package com.jzhl.kfsq.service.sm;

import java.util.List;

import com.jzhl.kfsq.entity.sm.RoleRight;

/**
 * 角色权限中间表业务层接口
 * 
 * @author Shaw
 *
 */
public interface IRoleRightService {
	
	/**
	 * 添加中间关系
	 * 
	 * @param roleRight
	 */
	public void insertRoleRight(List<RoleRight> roleRights);

	/**
	 * 删除中间关系
	 * 
	 * @param roleRightId
	 */
	public void deleteRoleRight(int roleRightId);

	/**
	 * 更新中间关系
	 * 
	 * @param roleRight
	 */
	public void updateRoleRight(List<RoleRight> roleRights);

	/**
	 * 根据主键查询中间关系
	 * 
	 * @param roleRightId
	 * @return
	 */
	public RoleRight getRoleRight(int roleRightId);

	/**
	 * 根据角色编号查询中间关系
	 * 
	 * @param roleId
	 * @return 中间关系集合
	 */
	public List<RoleRight> findRoleRightByRoleId(int roleId);

}
