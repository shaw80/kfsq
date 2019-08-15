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
import com.jzhl.kfsq.common.util.StringEncrypt;
import com.jzhl.kfsq.dataset.sm.UserDataSet;
import com.jzhl.kfsq.dto.sm.StatisticalDto;
import com.jzhl.kfsq.dto.sm.UserDto;
import com.jzhl.kfsq.entity.sm.Role;
import com.jzhl.kfsq.entity.sm.User;
import com.jzhl.kfsq.service.bm.IBuildingService;
import com.jzhl.kfsq.service.sm.IBranchService;
import com.jzhl.kfsq.service.sm.IRoleService;
import com.jzhl.kfsq.service.sm.IUserCacheService;
import com.jzhl.kfsq.service.sm.IUserService;

/**
 * 权限管理对外接口类
 * 
 * @author zhouzy
 *
 */
@Controller
public class AuthorityManagementController {

	@Autowired
	private IUserService userService;

	@Autowired
	private IRoleService roleService;

	@Autowired
	private IBranchService branchService;

	@Autowired
	private IUserCacheService userCacheService;

	@Autowired
	private IBuildingService buildingService;

	/**
	 * 权限管理-管理员人数；楼盘数；
	 * 
	 * @param userId
	 * @return ResponseBean
	 */
	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "/serv/user/getauthoritystatisticalinfo", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean getAuthorityStatisticalInfo(UserDto userDto) throws Exception {
		User user = new User();
		BeanUtils.copyProperties(userDto, user);

		// 根据userId 查询该代理商下所有楼盘数量
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("userId", user.getLoginUserId());
		int buildingNum = buildingService.getBuildingDataCount(map);

		// 根据userId 查询代理商下所有管理员人数
		int userNum = userService.getUserDataCount(map);

		// 直接用UserDataSet返回
		UserDataSet authorityStatisticalInfo = new UserDataSet();
		authorityStatisticalInfo.setBuildingNum(buildingNum);
		authorityStatisticalInfo.setUserNum(userNum);

		ResponseBean<UserDataSet> result = new ResponseBean<UserDataSet>(authorityStatisticalInfo);
		result.operateSuccess();
		return result;
	}

	/**
	 * 根据代理商userid查询其下管理人员总数与列表
	 */
	@SuppressWarnings({ "rawtypes" })
	@RequestMapping(value = "/serv/user/finduserlist", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean findUserList(UserDto userDto) throws Exception {

		// 分页查询参数
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("rowstart", userDto.getRowStart());
		map.put("offset", userDto.getOffset());

		// 查询参数
		map.put("userId", userDto.getUserId());
		map.put("keyword", userDto.getKeyword());
		map.put("isValid", userDto.getIsValid());

		map.put("roleId", userDto.getRoleId());
		if (userDto.getRoleCode() != null) {
			map.put("roleCode", userDto.getRoleCode()); // roleId
		}
		map.put("appUserType", userDto.getAppUserType());

		List<User> userList = userService.findUserList(map);

		// 分页返回
		ListResult listResult = new ListResult();
		listResult.setDataList(userList);

		// 总页数
		int dataCount = userService.getUserDataCount(map);
		listResult.setDataCount(dataCount);

		ResponseBean<ListResult> result = new ResponseBean<ListResult>(listResult);
		result.operateSuccess();
		return result;
	}

	/**
	 * 查询管理员详情
	 * 
	 * @param userId
	 * @return ResponseBean
	 */
	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "/serv/user/getuserinfo", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean getUserInfo(UserDto userDto) throws Exception {
		User user = new User();
		BeanUtils.copyProperties(userDto, user);
		User queryResult = userService.getUser(user);
		ResponseBean<User> result = new ResponseBean<User>(queryResult);
		result.operateSuccess();
		return result;
	}

	/**
	 * 重置密码
	 * 
	 * @param userId
	 * @return ResponseBean
	 */
	@SuppressWarnings({ "rawtypes" })
	@RequestMapping(value = "/serv/user/updateuserinfo", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean updateUserInfo(UserDto userDto) throws Exception {
		User user = new User();
		BeanUtils.copyProperties(userDto, user);

		// 如果是重置密码，密码重置为123456
		if (userDto.getIsValid() == null && userDto.getPassword() == null) {
			String md51 = StringEncrypt.encrypt("123456", "MD5");
			user.setPassword(md51);
		}

		userService.updateUser(user);

		// 如果是关闭售楼总监
		if (userDto.getIsValid() != null && userDto.getIsValid() == 0) {
			// 删除缓存
			userCacheService.clearAccount(user.getAccount());
		} else if (userDto.getIsValid() != null && userDto.getIsValid() == 1) {
			// 加缓存
			userCacheService.addOrUpdate(user);
		}

		ResponseBean result = new ResponseBean();
		result.operateSuccess();
		return result;
	}

	/**
	 * 获取权限列表
	 * 
	 * @return ResponseBean
	 */
	@SuppressWarnings({ "rawtypes" })
	@RequestMapping(value = "/serv/user/finduserroleinfolist", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean findUserRoleInfoList() throws Exception {
		// 查询代理商本身角色信息，以及代理商下属的角色信息
		List<Role> roleInfoList = roleService.findRoleByManagerType();
		Map<String, Object> queryResult = new HashMap<String, Object>();
		queryResult.put("dataList", roleInfoList);
		ResponseBean<Map<String, Object>> result = new ResponseBean<Map<String, Object>>(queryResult);
		result.operateSuccess();
		return result;
	}

	/**
	 * 新建管理员
	 * 
	 * @return ResponseBean
	 */
	@SuppressWarnings({ "rawtypes" })
	@RequestMapping(value = "/serv/user/insertuser", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean insertUser(UserDto userDto) throws Exception {
		User user = new User();
		BeanUtils.copyProperties(userDto, user);
		// 默认userType：0.运营平台用户 1.B端用户
		// user.setUserType(0);
		if (userDto.getAppUserType() != null && userDto.getAppUserType() == 2) {
			user.setLeaderUserId(userDto.getLeaderUserId()); // 父类ID
		} else {
			user.setLeaderUserId(userDto.getUserId()); // 父类ID
		}

		// B端用户类型区分
		if (userDto.getAppUserType() != null) {
			// 0.营销总监 1.销售经理2.置业顾问
			user.setAppUserType(userDto.getAppUserType());
		}

		// 添加用户
		userService.insertUser(user);

		// 加缓存
		if (user.getUserType() == 1 || user.getUserType() == 2) {
			userCacheService.addOrUpdate(user);
		}

		ResponseBean result = new ResponseBean();
		result.operateSuccess();
		return result;
	}

	/**
	 * 权限管理-新增楼盘-销售总监
	 * 
	 * @return ResponseBean
	 */
	@SuppressWarnings({ "rawtypes" })
	@RequestMapping(value = "/serv/user/insertbuildinguser", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean insertBuildingUser(UserDto userDto) throws Exception {
		User user = new User();
		BeanUtils.copyProperties(userDto, user);

		user.setUserType(1); // 默认userType：0.运营平台用户 ; 1.B端用户
		// user.setRoleId(4); // 4 销售总监 在实现类里insertBuildingUser查询获得；
		user.setLeaderUserId(userDto.getUserId()); // 父类ID
		user.setAppUserType(0); // 0.营销总监 1.销售经理 2.置业顾问

		// sm_user 表中插入数据
		userService.insertBuildingUser(user);

		// 加缓存
		userCacheService.addOrUpdate(user);

		ResponseBean result = new ResponseBean();
		result.operateSuccess();
		return result;
	}

	/**
	 * 楼盘管理后台-首页-销售团队列表
	 * 
	 * @param
	 * @return ResponseBean
	 */
	@SuppressWarnings({ "rawtypes" })
	@RequestMapping(value = "/serv/user/saleleaderlist", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean findSaleLeaderList(StatisticalDto statisticalDto) {

		// 查询登录销售总监旗下的所有销售经理列表-每个销售团队
		List<UserDataSet> saleLeaderList = userService.findSaleLeaderList(statisticalDto);
		// 返回数据添加
		Map<String, Object> queryResult = new HashMap<String, Object>();
		queryResult.put("dataList", saleLeaderList);
		ResponseBean<Map<String, Object>> result = new ResponseBean<Map<String, Object>>(queryResult);
		result.operateSuccess();
		return result;
	}

	/**
	 * 根据登录ID售楼总监检索其下所有置业顾问列表
	 */
	@SuppressWarnings({ "rawtypes" })
	@RequestMapping(value = "/serv/user/findsaleuserlist", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean findSaleUserList(UserDto userDto) throws Exception {

		// 分页查询参数
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("rowstart", userDto.getRowStart());
		map.put("offset", userDto.getOffset());

		// 查询参数
		map.put("userId", userDto.getUserId());

		// 根据登录ID售楼总监检索其下所有置业顾问列表；
		List<User> userList = userService.findSaleUserList(map);

		// 分页返回
		ListResult listResult = new ListResult();
		listResult.setDataList(userList);

		// 总页数
		int dataCount = userService.getSaleUserDataCount(map);
		listResult.setDataCount(dataCount);

		ResponseBean<ListResult> result = new ResponseBean<ListResult>(listResult);
		result.operateSuccess();
		return result;
	}
}
