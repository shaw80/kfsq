package com.jzhl.kfsq.dao.sm;

import java.util.List;
import java.util.Map;

import com.jzhl.kfsq.dataset.sm.Menu;
import com.jzhl.kfsq.dataset.sm.RoleDetailDataSet;
import com.jzhl.kfsq.dto.login.RightNamesDto;
import com.jzhl.kfsq.dto.sm.RoleNameDto;
import com.jzhl.kfsq.entity.sm.Role;

/**
 * 角色数据访问层接口
 * 
 * @author Shaw
 *
 */
public interface IRoleMapper {

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
	 * 根据角色ID查询角色其所有权限
	 */
	public List<Role> findAdminRoleInfoList(Role role);

	/**
	 * 角色总数
	 */
	public int getRoleDataCount();

	/**
	 * 遍历所有角色
	 */
	public List<Role> getRoleList();

	/**
	 * 新建管理员-获取角色列表-过滤角色条件（已作废，弃用）
	 */
	public List<Role> findUserRoleInfoList(Role role);
	
	/**
	 * 新建管理员-获取角色列表-查询代理商及其下属的角色信息
	 * @return
	 */
	public List<Role> findRoleByManagerType();

	/**
	 * 根据用户编号获取角色名称
	 * 
	 * @param userId
	 * @return
	 */
	public String getRoleNameByUserId(int userId);

	/**
	 * 根据角色编号查询对应的权限名称
	 * 
	 * @param roleId
	 * @return
	 */
	public List<String> findRightsByRoleId(int roleId);

	/**
	 * 根据角色编号查询角色信息
	 * 
	 * @param roleCode
	 * @return
	 */
	public Role getRoleByRoleCode(String roleCode);
	
	/**
	 * 根据管理端类型查询系统自带的角色信息
	 * @param managerType
	 * @return
	 */
	public Role getRoleByManagerType(String managerType);
	
	/**
	 * 根据角色名称和管理端类型查询角色信息
	 * @param dto
	 * @return
	 */
	public Role getRoleByRoleNameAndManagerType(RoleNameDto dto);
	
	/**
	 * 根据角色编号查询角色详情
	 * @param roleId
	 * @return
	 */
	public RoleDetailDataSet getRoleDetailByRoleId(Integer roleId);
	
	/**
	 * 根据角色编号查询菜单
	 * @param roleId
	 * @return
	 */
	public List<Menu> findMenusByRoleId(RightNamesDto dto);

}
