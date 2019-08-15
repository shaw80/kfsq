package com.jzhl.kfsq.controller.sm;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jzhl.kfsq.common.base.ResponseBean;
import com.jzhl.kfsq.dataset.sm.RoleDetailDataSet;
import com.jzhl.kfsq.dto.sm.RightQueryDto;
import com.jzhl.kfsq.dto.sm.RoleDto;
import com.jzhl.kfsq.entity.sm.Role;
import com.jzhl.kfsq.service.sm.IRoleService;

/**
 * 角色管理类
 * 
 * @author Shaw
 *
 */
@Controller
public class RoleController {
	
	@Autowired
	private IRoleService roleService;
	
	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "/serv/role/m", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean updateRole(RoleDto dto){
		Role role = new Role();
		role.setRoleId(dto.getRoleId());
		role.setRoleName(dto.getRoleName());
		role.setUpdateUserId(dto.getUpdateUserId());
		roleService.updateRole(role);
		ResponseBean result = new ResponseBean();
		result.operateSuccess("更新成功");
		return result;
	}
	
	/**
	 * 根据角色编号查询角色信息
	 * @param roleId
	 * @return
	 */
	@RequestMapping(value = "/serv/role/getRole", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean<Role> getRole(RoleDto dto){
		Role role = roleService.getRole(dto.getRoleId());
		ResponseBean<Role> result = new ResponseBean<Role>(role);
		result.operateSuccess("查询成功");
		return result;
	}
	
	/**
	 * 根据角色名称和管理端类型判断角色是否存在
	 * @param dto
	 * @return isExist 0:不存在，1：存在
	 */
	@RequestMapping(value = "/serv/role/isExist", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean<Map<String, Object>> RoleNameIsExist(RightQueryDto dto){
		String isExist = roleService.RoleNameIsExist(dto);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("isExist", isExist);
		ResponseBean<Map<String, Object>> result = new ResponseBean<Map<String, Object>>(map);
		result.operateSuccess("查询成功");
		return result;
	}
	
	/**
	 * 根据角色编号查询角色详情
	 * @param dto
	 * @return
	 */
	@RequestMapping(value = "/serv/role/detail", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean<RoleDetailDataSet> getRoleDetail(RoleDto dto){
		RoleDetailDataSet role = roleService.getRoleDetail(dto);
		ResponseBean<RoleDetailDataSet> result = new ResponseBean<RoleDetailDataSet>(role);
		result.operateSuccess("查询成功");
		return result;
	}

}
