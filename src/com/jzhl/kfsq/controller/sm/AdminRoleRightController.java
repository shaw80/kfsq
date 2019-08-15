package com.jzhl.kfsq.controller.sm;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jzhl.kfsq.common.base.ListResult;
import com.jzhl.kfsq.common.base.ResponseBean;
import com.jzhl.kfsq.dto.sm.RoleDto;
import com.jzhl.kfsq.entity.sm.Right;
import com.jzhl.kfsq.entity.sm.Role;
import com.jzhl.kfsq.entity.sm.RoleRight;
import com.jzhl.kfsq.service.sm.IRightService;
import com.jzhl.kfsq.service.sm.IRoleService;

/**
 * 管理员角色权限接口类
 * 
 * @author zhouzy
 *
 */
@Controller
public class AdminRoleRightController {

	@Autowired
	private IRightService rightService;

	@Autowired
	private IRoleService roleService;

	/**
	 * 查询所有权限列表
	 * 
	 * @return ResponseBean
	 */
	@SuppressWarnings({ "rawtypes" })
	@RequestMapping(value = "/serv/admin/findadminrightlist", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean findAdminRightList() throws Exception {

		List<Right> right = rightService.findAdminRightList();
		Map<String, Object> queryResult = new HashMap<String, Object>();
		queryResult.put("dataList", right);
		ResponseBean<Map<String, Object>> result = new ResponseBean<Map<String, Object>>(queryResult);
		result.operateSuccess();
		return result;
	}

	/**
	 * 根据角色名称查询是否已经存在
	 *
	 * @return ResponseBean
	 */
	@SuppressWarnings({ "rawtypes" })
	@RequestMapping(value = "/serv/admin/getRoleInfo", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean getRoleInfo(RoleDto roleDto) throws Exception {
		Role role = new Role();
		BeanUtils.copyProperties(roleDto, role);
		String roleName = role.getRoleName();
		Role roleResult = roleService.getRoleByName(roleName);
		ResponseBean<Role> result = new ResponseBean<Role>(roleResult);
		result.operateSuccess();
		return result;
	}

	/**
	 * 新增角色
	 * 
	 * @return ResponseBean
	 */
	@SuppressWarnings({ "rawtypes" })
	@RequestMapping(value = "/serv/admin/insertadminrole", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean insertAdminRole(RoleDto roleDto) throws Exception {
		Role role = new Role();
		role.setRoleName(roleDto.getRoleName());
		role.setRoleCode(roleDto.getRoleCode());
		role.setCreatorUserId(roleDto.getCreatorUserId());
		// 新增角色
		roleService.insertRole(role);

		int roleId = role.getRoleId();

		// 添加中间表中新增角色的权限
		String rightList = roleDto.getRightList().replaceAll("\\s*", "");
		if (rightList.contains(",")) {
			String[] stringArr = rightList.split(",");
			// 循环插入中间表
			for (int i = 0; i < stringArr.length; i++) {
				RoleRight roleRight = new RoleRight();
				roleRight.setRoleId(roleId);
				roleRight.setRightId(Integer.parseInt(stringArr[i]));
				roleRight.setCreatorUserId(roleDto.getCreatorUserId());
				rightService.insertRoleRight(roleRight);
			}
		}

		ResponseBean result = new ResponseBean<Role>();
		result.operateSuccess();
		return result;
	}

	/**
	 * 查询所有角色列表
	 * 
	 * @return ResponseBean
	 */
	@SuppressWarnings({ "rawtypes" })
	@RequestMapping(value = "/serv/admin/findadminrolelist", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean findAdminRoleList(RoleDto roleDto) throws Exception {
		// 分页查询参数
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("rowstart", roleDto.getRowStart());
		map.put("offset", roleDto.getOffset());
		List<Role> roleList = roleService.findAllByPage(map);

		// 分页返回
		ListResult listResult = new ListResult();
		listResult.setDataList(roleList);

		// 总页数
		int dataCount = roleService.getRoleDataCount();
		listResult.setDataCount(dataCount);

		ResponseBean<ListResult> result = new ResponseBean<ListResult>(listResult);
		result.operateSuccess();
		return result;
	}

	/**
	 * 查询角色权限详情
	 * 
	 * @return ResponseBean
	 */
	@SuppressWarnings({ "rawtypes" })
	@RequestMapping(value = "/serv/admin/findadminroleinfolist", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean findAdminRoleInfoList(RoleDto roleDto) throws Exception {

		Role role = new Role();
		BeanUtils.copyProperties(roleDto, role);
		List<Role> roleInfo = roleService.findAdminRoleInfoList(role);
		Map<String, Object> queryResult = new HashMap<String, Object>();
		queryResult.put("dataList", roleInfo);
		ResponseBean<Map<String, Object>> result = new ResponseBean<Map<String, Object>>(queryResult);
		result.operateSuccess();
		return result;
	}

	/**
	 * 编辑角色权限
	 * 
	 * @return ResponseBean
	 */
	@SuppressWarnings({ "rawtypes", })
	@RequestMapping(value = "/serv/admin/updateAdminRoleRight", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean updateAdminRoleRight(RoleDto roleDto) throws Exception {
		// 先把以前的roleId对应的权限删除
		rightService.deleteRightByRoleId(roleDto);

		// 重新添加中间表中的权限
		String rightList = roleDto.getRightList().replaceAll("\\s*", "");
		// 如果包含权限
		if (rightList.contains(",")) {
			String[] stringArr = rightList.split(",");
			// 循环插入中间表
			for (int i = 0; i < stringArr.length; i++) {
				RoleRight roleRight = new RoleRight();
				roleRight.setRoleId(roleDto.getRoleId());
				roleRight.setRightId(Integer.parseInt(stringArr[i]));
				// roleRight.setCreatorUserId(roleDto.getCreatorUserId());
				rightService.insertRoleRight(roleRight);
			}
		}

		ResponseBean result = new ResponseBean<Role>();
		result.operateSuccess();
		return result;
	}
}
