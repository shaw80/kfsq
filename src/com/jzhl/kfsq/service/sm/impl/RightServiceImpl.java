package com.jzhl.kfsq.service.sm.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.jzhl.kfsq.dao.sm.IRightMapper;
import com.jzhl.kfsq.dao.sm.IRoleMapper;
import com.jzhl.kfsq.dao.sm.IRoleRightMapper;
import com.jzhl.kfsq.dataset.sm.RightDataSet;
import com.jzhl.kfsq.dataset.sm.RightDetailDataSet;
import com.jzhl.kfsq.dto.sm.RightQueryDto;
import com.jzhl.kfsq.dto.sm.RoleDto;
import com.jzhl.kfsq.entity.sm.Right;
import com.jzhl.kfsq.entity.sm.Role;
import com.jzhl.kfsq.entity.sm.RoleRight;
import com.jzhl.kfsq.service.sm.IRightService;

/**
 * 权限业务层实现类
 * 
 * @author Shaw
 *
 */
@Service
public class RightServiceImpl implements IRightService {
	
	@Autowired
	@Qualifier("IRightMapper")
	private IRightMapper rightDao;
	
	@Autowired
	@Qualifier("IRoleRightMapper")
	private IRoleRightMapper roleRightDao;
	
	@Autowired
	@Qualifier("IRoleMapper")
	private IRoleMapper roleDao;

	/**
	 * 添加权限
	 * 
	 * @param right
	 */
	@Override
	public void insertRight(Right right) {
		rightDao.insertRight(right);
	}

	/**
	 * 删除权限
	 * 
	 * @param rightId
	 */
	@Override
	public void deleteRight(int rightId) {
		rightDao.deleteRight(rightId);
	}

	/**
	 * 更新权限
	 * 
	 * @param right
	 */
	@Override
	public void updateRight(Right right) {
		rightDao.updateRight(right);
	}

	/**
	 * 根据权限编号查询权限
	 * 
	 * @param rightId
	 * @return 权限
	 */
	@Override
	public Right getRight(int rightId) {
		Right right = rightDao.getRight(rightId);
		return right;
	}

	/**
	 * 查询全部权限
	 * 
	 * @return 权限集合
	 */
	@Override
	public List<Right> findAll() {
		List<Right> result = rightDao.findAll();
		return result;
	}

	/**
	 * 查询全部权限
	 * 
	 * @return 权限集合
	 * @author zhouzy
	 */
	@Override
	public List<Right> findAdminRightList() {
		List<Right> result = rightDao.findAdminRightList();
		return result;
	}

	/**
	 * 在中间表中插入角色权限
	 * @author zhouzy
	 */
	@Override
	public void insertRoleRight(RoleRight roleRight) {
		rightDao.insertRoleRight(roleRight);
	}

	/**
	 * 删除原有角色权限
	 * @author zhouzy
	 */
	@Override
	public void deleteRightByRoleId(RoleDto roleDto) {
		rightDao.deleteRightByRoleId(roleDto);
	}

	/**
	 * WEB端根据角色编号和父编号查询权限列表
	 * 
	 * @param dto
	 * @return
	 */
	@Override
	public List<RightDataSet> findRightByParentId(RightQueryDto dto) {
		List<RightDataSet> rights = rightDao.findRightByParentId(dto);
		Integer roleId = null;
		if(dto.getRoleId() != null){
			roleId = dto.getRoleId();
		}
		if(dto.getRoleCode() != null){
			Role role = roleDao.getRoleByRoleCode(dto.getRoleCode());
			roleId = role.getRoleId();
		}
		List<RoleRight> roleRights = roleRightDao.findRoleRightByRoleId(roleId);
		for (RoleRight roleRight : roleRights) {
			for (RightDataSet right : rights) {
				if(right.getRightId() == roleRight.getRightId()){
					right.setPermission(true);
				}
			}
		}
		return rights;
	}

	/**
	 * 查看角色详情结果集
	 * @param dto
	 * @return
	 */
	@Override
	public RightDetailDataSet getRightDetailDataSet(RightQueryDto dto) {
		RightDetailDataSet result = new RightDetailDataSet();
		Role role_dataset = new Role();
		List<RoleRight> list_roleright = new ArrayList<RoleRight>();
		if(dto.getRoleId() != null){
			role_dataset = roleDao.getRole(dto.getRoleId());
			list_roleright = roleRightDao.findRoleRightByRoleId(dto.getRoleId());
		}
		if(dto.getRoleCode() != null){
			role_dataset = roleDao.getRoleByRoleCode(dto.getRoleCode());
			list_roleright = roleRightDao.findRoleRightByRoleId(role_dataset.getRoleId());
		}
		Role role_sys = roleDao.getRoleByManagerType(role_dataset.getManagerType());
		List<RightDataSet> first = rightDao.findFirstRights(role_dataset.getManagerType());
		List<RightDataSet> second = rightDao.findAllSecondRights(role_dataset.getManagerType());
		for (RoleRight roleRight : list_roleright) {
			for (RightDataSet right_first : first) {
				if(roleRight.getRightId().equals(right_first.getRightId())){
					right_first.setPermission(true);
				}
			}
			for (RightDataSet right_second : second) {
				if(roleRight.getRightId().equals(right_second.getRightId())){
					right_second.setPermission(true);
				}
			}
		}
		
		result.setRoleId(dto.getRoleId());
		result.setRoleName(role_dataset.getRoleName());
		result.setRoleType(role_dataset.getRoleType());
		result.setRoleCode(role_sys.getRoleCode());
		result.setFirst(first);
		result.setSecond(second);
		return result;
	}

}
