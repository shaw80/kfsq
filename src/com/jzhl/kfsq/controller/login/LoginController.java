package com.jzhl.kfsq.controller.login;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jzhl.kfsq.common.base.ResponseBean;
import com.jzhl.kfsq.dataset.sm.Menus;
import com.jzhl.kfsq.dto.login.RightDto;
import com.jzhl.kfsq.dto.login.RightNamesDto;
import com.jzhl.kfsq.dto.login.RoleChangeDto;
import com.jzhl.kfsq.dto.login.RoleDto;
import com.jzhl.kfsq.dto.login.RoleNameDto;
import com.jzhl.kfsq.dto.login.UserDto;
import com.jzhl.kfsq.entity.sm.Right;
import com.jzhl.kfsq.entity.sm.Role;
import com.jzhl.kfsq.entity.sm.RoleRight;
import com.jzhl.kfsq.entity.sm.User;
import com.jzhl.kfsq.service.login.ILoginService;
import com.jzhl.kfsq.service.sm.IRoleService;

/**
 * 登录管理类
 * 
 * @author Shaw
 *
 */
@Controller
public class LoginController {


	@Autowired
	private ILoginService loginService;

	@Autowired
	private IRoleService roleService;

	private static final Logger logger = Logger.getLogger(LoginController.class);

	/**
	 * 根据登陆名称查询用户
	 * 
	 * @param dto
	 * @return
	 */
	@RequestMapping(value = "/serv/shiro/user", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean<User> getUserByAccount(UserDto dto) {
		logger.debug("[用户登录]--根据登陆名称查询用户");
		User user = loginService.getUserByAccount(dto.getAccount());
		ResponseBean<User> result = new ResponseBean<User>(user);
		if (user != null) {
			result.operateSuccess("查询成功");
		} else {
			result.operateFail("用户不存在");
		}

		return result;
	}

	/**
	 * 根据角色编号查询中间表集合
	 * 
	 * @param roleId
	 * @return
	 */
	@RequestMapping(value = "/serv/shiro/roleRight", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean<Map<String, Object>> findRoleRightByRoleId(RoleDto dto) {
		logger.debug("[用户登录]--根据角色编号查询中间表集合");
		List<RoleRight> list = loginService.findRoleRightByRoleId(dto
				.getRoleId());
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("data", list);
		ResponseBean<Map<String, Object>> result = new ResponseBean<Map<String, Object>>(
				map);
		if (list != null) {
			result.operateSuccess("查询成功");
		}
		return result;
	}

	/**
	 * 根据角色编号查询角色信息
	 * 
	 * @param RoleId
	 * @return
	 */
	@RequestMapping(value = "/serv/shiro/role", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean<Role> getRole(RoleDto dto) {
		logger.debug("[用户登录]--根据角色编号查询角色信息");
		Role role = loginService.getRole(dto.getRoleId());
		ResponseBean<Role> result = new ResponseBean<Role>(role);
		if (role != null) {
			result.operateSuccess("查询成功");
		} else {
			result.operateFail("无角色信息");
		}
		return result;
	}

	/**
	 * 根据权限编号查询权限信息
	 * 
	 * @param rightId
	 * @return
	 */
	@RequestMapping(value = "/serv/shiro/right", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean<Right> getRight(RightDto dto) {
		logger.debug("[用户登录]--根据权限编号查询权限信息");
		Right right = loginService.getRight(dto.getRightId());
		ResponseBean<Right> result = new ResponseBean<Right>(right);
		if (right != null) {
			result.operateSuccess("查询成功");
		} else {
			result.operateFail("无权限信息");
		}
		return result;
	}

	/**
	 * 根据用户编号查询角色名称
	 * 
	 * @param dto
	 * @return
	 */
	@RequestMapping(value = "/serv/login/roleName", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean<Map<String, Object>> getRoleName(RoleNameDto dto) {
		logger.debug("[用户登录]--根据用户编号查询角色名称");
		String roleName = roleService.getRoleNameByUserId(dto.getUserId());
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("roleName", roleName);
		ResponseBean<Map<String, Object>> result = new ResponseBean<Map<String, Object>>(param);
		if (roleName != null) {
			result.operateSuccess("查询成功");
		} else {
			result.operateFail("无角色信息");
		}
		return result;
	}

	/**
	 * 根据角色编号查询对应权限名称
	 * 
	 * @param dto
	 * @return
	 */
	@RequestMapping(value = "/serv/login/rightNames", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean<Map<String, Object>> findRightsByRoleId(RightNamesDto dto) {
		logger.debug("[用户登录]--根据角色编号查询对应权限名称");
		List<Menus> menus = roleService.findMenusByRoleId(dto);
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("menus", menus);
		ResponseBean<Map<String, Object>> result = new ResponseBean<Map<String, Object>>(param);
		if(menus != null){
			result.operateSuccess("查询成功");
		}else{
			result.operateFail("无权限信息");
		}
		return result;
	}
	
	/**
	 * 根据用户编号查询用户信息
	 * @param dto
	 * @return
	 */
	@RequestMapping(value = "/serv/login/roleChange", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean<User> getUserByUserId(RoleChangeDto dto){
		logger.debug("[用户登录]--根据用户编号查询用户信息");
		User param = new User();
		param.setUserId(dto.getUserId());
		User user = loginService.getUserByUserId(param);
		ResponseBean<User> result = new ResponseBean<User>(user);
		result.operateSuccess("查询成功");
		return result;
	}

}
