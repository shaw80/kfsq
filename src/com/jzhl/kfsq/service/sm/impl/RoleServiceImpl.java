package com.jzhl.kfsq.service.sm.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jzhl.kfsq.dao.sm.IRightMapper;
import com.jzhl.kfsq.dao.sm.IRoleMapper;
import com.jzhl.kfsq.dataset.sm.Menu;
import com.jzhl.kfsq.dataset.sm.Menus;
import com.jzhl.kfsq.dataset.sm.RoleDetailDataSet;
import com.jzhl.kfsq.dto.login.RightNamesDto;
import com.jzhl.kfsq.dto.sm.RightQueryDto;
import com.jzhl.kfsq.dto.sm.RoleDto;
import com.jzhl.kfsq.dto.sm.RoleNameDto;
import com.jzhl.kfsq.entity.sm.Right;
import com.jzhl.kfsq.entity.sm.Role;
import com.jzhl.kfsq.service.sm.IRoleService;

/**
 * 角色业务层实现类
 * 
 * @author Shaw
 *
 */
@Service
public class RoleServiceImpl implements IRoleService {

	@Autowired
	private IRoleMapper roleDao;
	
	@Autowired
	private IRightMapper rightDao;

	/**
	 * 添加角色
	 * 
	 * @param role
	 */
	@Override
	public void insertRole(Role role) {
		role.setRoleType("1");
		roleDao.insertRole(role);
	}

	/**
	 * 删除角色
	 * 
	 * @param roleId
	 */
	@Override
	public void deleteRole(int roleId) {
		roleDao.deleteRole(roleId);
	}

	/**
	 * 更新角色
	 * 
	 * @param role
	 */
	@Override
	public void updateRole(Role role) {
		roleDao.updateRole(role);
	}

	/**
	 * 根据角色编号查询角色
	 * 
	 * @param roleId
	 * @return 角色
	 */
	@Override
	public Role getRole(int roleId) {
		Role role = roleDao.getRole(roleId);
		return role;
	}

	/**
	 * 查询全部角色
	 * 
	 * @return 角色集合
	 */
	@Override
	public List<Role> findAllByPage(Map<String, Object> map) {
		List<Role> result = roleDao.findAllByPage(map);
		return result;
	}

	/**
	 * 根据角色名称查询角色
	 * 
	 * @param roleName
	 * @return 角色
	 */
	@Override
	public Role getRoleByName(String roleName) {
		Role role = roleDao.getRoleByName(roleName);
		return role;
	}

	/**
	 * 角色信息列表
	 */
	@Override
	public List<Role> findAdminRoleInfoList(Role role) {
		List<Role> result = roleDao.findAdminRoleInfoList(role);
		return result;
	}

	/**
	 * 角色列表总数
	 */
	@Override
	public int getRoleDataCount() {
		int datoCount = roleDao.getRoleDataCount();
		return datoCount;
	}

	/**
	 * 遍历所有角色
	 */
	@Override
	public List<Role> getRoleList() {
		List<Role> result = roleDao.getRoleList();
		return result;
	}

	/**
	 * 新建管理员-获取角色列表-过滤角色条件
	 */
	@Override
	public List<Role> findUserRoleInfoList(Role role) {
		List<Role> result = roleDao.findUserRoleInfoList(role);
		return result;
	}

	/**
	 * 根据用户编号获取角色名称
	 * 
	 * @param userId
	 * @return
	 */
	@Override
	public String getRoleNameByUserId(int userId) {
		String roleName = roleDao.getRoleNameByUserId(userId);
		return roleName;
	}

	/**
	 * 根据角色编号查询对应权限名称
	 * 
	 * @param roleId
	 * @return
	 */
	@Override
	public List<String> findRightsByRoleId(int roleId) {
		List<String> result = roleDao.findRightsByRoleId(roleId);
		return result;
	}

	/**
	 * 根据角色名称和管理端类型判断角色是否存在
	 * @param dto
	 * @return
	 */
	@Override
	public String RoleNameIsExist(RightQueryDto dto) {
		RoleNameDto param = new RoleNameDto();
		param.setRoleName(dto.getRoleName());
		if(dto.getRoleCode() != null){
			if(dto.getRoleCode().equals("admin")){
				param.setManagerType("0");
			}else if(dto.getRoleCode().equals("agent")){
				param.setManagerType("2");
			}else{
				param.setManagerType("1");
			}
		}
		if(dto.getRoleId() != null){
			param.setRoleId(dto.getRoleId());
		}
		Role role = roleDao.getRoleByRoleNameAndManagerType(param);
		String result = null;
		if(role != null){// 如果角色存在
			result = "1";
		}else{
			result = "0";// 如果角色不存在
		}
		return result;
	}

	/**
	 * 根据角色编号查询角色详情
	 * @param dto
	 * @return
	 */
	@Override
	public RoleDetailDataSet getRoleDetail(RoleDto dto) {
		RoleDetailDataSet role = roleDao.getRoleDetailByRoleId(dto.getRoleId());
		return role;
	}

	/**
	 * 新建管理员-获取角色列表-查询代理商及其下属的角色信息
	 * @return
	 */
	@Override
	public List<Role> findRoleByManagerType() {
		List<Role> result = roleDao.findRoleByManagerType();
		return result;
	}

	/**
	 * 根据角色编号查询菜单
	 * @param roleId
	 * @return
	 */
	@Override
	public List<Menus> findMenusByRoleId(RightNamesDto dto) {
		List<Menus> result = new ArrayList<Menus>();
		List<Menu> list = roleDao.findMenusByRoleId(dto);
		for (Menu menu : list) {
			Right right = rightDao.getRight(menu.getParentId());// 根据父ID查询权限
			if(right != null){
				if(right.getParentId().equals(0)){// 如果权限的父ID为零
					Menus menus = new Menus();
					menus.setFirst(menu);
					result.add(menus);
					menu.setLevel(1);
				}else{// 如果权限的父ID不为零
					menu.setLevel(2);
				}
			}
		}
		for (Menus menus : result) {
			List<Menu> second = new ArrayList<Menu>();
			for (Menu menu2 : list) {
				if(menu2.getLevel().equals(2)){
					if(menus.getFirst().getRightId().equals(menu2.getParentId())){
						second.add(menu2);
						menus.setSecond(second);
					}
				}
			}
		}
		return result;
	}

}
