package com.jzhl.kfsq.controller.sm;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jzhl.kfsq.common.base.ResponseBean;
import com.jzhl.kfsq.dto.sm.RoleRightDto;
import com.jzhl.kfsq.entity.sm.Role;
import com.jzhl.kfsq.entity.sm.RoleRight;
import com.jzhl.kfsq.service.sm.IRoleRightService;
import com.jzhl.kfsq.service.sm.IRoleService;

/**
 * 角色权限中间表管理类
 * 
 * @author Shaw
 *
 */
@Controller
public class RoleRightController {
	
	@Autowired
	private IRoleRightService roleRightService;
	
	@Autowired
	private IRoleService roleService;
	
	/**
	 * 新增中间关系
	 * @param roleRights
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "/serv/roleRight/roleRight", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean insertRoleRight(RoleRightDto dto){
		Role role = new Role();
		role.setRoleName(dto.getRoleName());
		role.setRoleCode(dto.getRoleCode());
		role.setRoleType("1");
		role.setCreatorUserId(dto.getCreatorUserId());
		if(dto.getRoleCode().equals("admin")){
			role.setManagerType("0");
		}else if(dto.getRoleCode().equals("agent")){
			role.setManagerType("2");
		}else{
			role.setManagerType("1");
		}
		roleService.insertRole(role);
		
		List<RoleRight> list = new ArrayList<RoleRight>();
		String str[] = dto.getRightId().split(",");
		for (String string : str) {
			RoleRight roleRight = new RoleRight();
			roleRight.setRoleId(role.getRoleId());
			roleRight.setRightId(Integer.parseInt(string));
			roleRight.setCreatorUserId(dto.getCreatorUserId());
			list.add(roleRight);
		}
		roleRightService.insertRoleRight(list);
		ResponseBean result = new ResponseBean();
		result.operateSuccess("添加成功");
		return result;
	}
	
	/**
	 * 更新中间关系
	 * @param dto
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "/serv/roleRight/m", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean updateRoleRight(RoleRightDto dto){
		Role role = new Role();
		role.setRoleId(Integer.parseInt(dto.getRoleId()));
		role.setRoleName(dto.getRoleName());
		role.setUpdateUserId(dto.getCreatorUserId());
		if(dto.getRoleCode() != null){
			if(dto.getRoleCode().equals("admin")){
				role.setManagerType("0");
			}else if(dto.getRoleCode().equals("agent")){
				role.setManagerType("2");
			}else{
				role.setManagerType("1");
			}
		}
		roleService.updateRole(role);
		
		List<RoleRight> list = new ArrayList<RoleRight>();
		String str[] = dto.getRightId().split(",");
		for (String string : str) {
			RoleRight roleRight = new RoleRight();
			roleRight.setRoleId(Integer.parseInt(dto.getRoleId()));
			roleRight.setRightId(Integer.parseInt(string));
			roleRight.setUpdateUserId(dto.getCreatorUserId());
			list.add(roleRight);
		}
		roleRightService.updateRoleRight(list);
		ResponseBean result = new ResponseBean();
		result.operateSuccess("更新成功");
		return result;
	}

}
