package com.jzhl.kfsq.service.sm;

import java.util.List;
import java.util.Map;

import com.jzhl.kfsq.dataset.sm.Menus;
import com.jzhl.kfsq.dataset.sm.RoleDetailDataSet;
import com.jzhl.kfsq.dto.login.RightNamesDto;
import com.jzhl.kfsq.dto.sm.RightQueryDto;
import com.jzhl.kfsq.dto.sm.RoleDto;
import com.jzhl.kfsq.entity.sm.Role;

/**
 * 用户业务层接口
 * 
 * @author Shaw
 *
 */
public interface IRoleService {

	/**
	 * 添加角色
	 * 
	 * @param role
	 */
	public void insertRole(Role role);

	/**
	 * 删除角色
	 * 
	 * @param roleId
	 */
	public void deleteRole(int roleId);

	/**
	 * 更新角色
	 * 
	 * @param role
	 */
	public void updateRole(Role role);

	/**
	 * 根据角色编号查询角色
	 * 
	 * @param roleId
	 * @return 角色
	 */
	public Role getRole(int roleId);

	/**
	 * 查询全部角色
	 * 
	 * @param map
	 * 
	 * @return 角色集合
	 */
	public List<Role> findAllByPage(Map<String, Object> map);

	/**
	 * 根据角色名称查询角色
	 * 
	 * @param roleName
	 * @return 角色
	 */
	public Role getRoleByName(String roleName);

	/**
	 * 根据角色ID查询其对应权限
	 */
	public List<Role> findAdminRoleInfoList(Role role);

	/**
	 * 角色总数量
	 */
	public int getRoleDataCount();

	/**
	 * 遍历所有角色
	 */
	public List<Role> getRoleList();

	/**
	 * 新建管理员-获取角色列表-过滤角色条件(已作废，弃用)
	 */
	public List<Role> findUserRoleInfoList(Role role);
	
	/**
	 * 查询代理商及下属的角色信息
	 * managerType = 2 代理商平台
	 * @return
	 */
	public List<Role> findRoleByManagerType();

	/**
	 * 根据用户编号查询角色名称
	 * 
	 * @param userId
	 * @return
	 */
	public String getRoleNameByUserId(int userId);

	/**
	 * 根据角色编号查询对应权限名称
	 * 
	 * @param roleId
	 * @return
	 */
	public List<String> findRightsByRoleId(int roleId);
	
	/**
	 * 根据角色名称和管理端类型判断角色是否存在
	 * @param dto
	 * @return
	 */
	public String RoleNameIsExist(RightQueryDto dto);
	
	/**
	 * 根据角色编号查询角色详情
	 * @param dto
	 * @return
	 */
	public RoleDetailDataSet getRoleDetail(RoleDto dto);
	
	/**
	 * 根据角色编号查询菜单
	 * @param roleId
	 * @return
	 */
	public List<Menus> findMenusByRoleId(RightNamesDto dto);
}
