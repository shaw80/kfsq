package com.jzhl.kfsq.dao.sm;

import java.util.List;

import com.jzhl.kfsq.dataset.sm.RightDataSet;
import com.jzhl.kfsq.dto.sm.RightQueryDto;
import com.jzhl.kfsq.dto.sm.RoleDto;
import com.jzhl.kfsq.entity.sm.Right;
import com.jzhl.kfsq.entity.sm.RoleRight;

/**
 * 权限数据访问层接口
 * 
 * @author Shaw
 *
 */
public interface IRightMapper {

	/**
	 * 添加权限
	 * 
	 * @param right
	 */
	public void insertRight(Right right);

	/**
	 * 删除权限
	 * 
	 * @param rightId
	 */
	public void deleteRight(int rightId);

	/**
	 * 更新权限
	 * 
	 * @param right
	 */
	public void updateRight(Right right);

	/**
	 * 根据权限编号查询权限
	 * 
	 * @param rightId
	 * @return 权限
	 */
	public Right getRight(int rightId);

	/**
	 * 查询全部权限
	 * 
	 * @return 权限集合
	 */
	public List<Right> findAll();

	/**
	 * 查询全部权限
	 * 
	 * @return 权限集合
	 * @author zhouzy
	 */
	public List<Right> findAdminRightList();

	/**
	 * @author zhouzy 在中间表中插入角色权限
	 */
	public void insertRoleRight(RoleRight roleRight);

	/**
	 * @author zhouzy 删除角色权限
	 */
	public void deleteRightByRoleId(RoleDto roleDto);

	/**
	 * WEB端根据角色编号和父编号查询权限列表
	 * 
	 * @param dto
	 * @return
	 */
	public List<RightDataSet> findRightByParentId(RightQueryDto dto);
	
	/**
	 * 查询全部一级菜单
	 * @param managerType
	 * @return
	 */
	public List<RightDataSet> findFirstRights(String managerType);
	
	/**
	 * 查询全部二级菜单
	 * @param managerType
	 * @return
	 */
	public List<RightDataSet> findAllSecondRights(String managerType);

}
