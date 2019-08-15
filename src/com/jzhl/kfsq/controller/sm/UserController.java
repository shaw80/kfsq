package com.jzhl.kfsq.controller.sm;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jzhl.kfsq.common.base.ResponseBean;
import com.jzhl.kfsq.dataset.sm.UserDataSet;
import com.jzhl.kfsq.dto.sm.PasswordDto;
import com.jzhl.kfsq.dto.sm.SalerDto;
import com.jzhl.kfsq.dto.sm.SalerInsertDto;
import com.jzhl.kfsq.dto.sm.UserDto;
import com.jzhl.kfsq.dto.sm.ValiAccountDto;
import com.jzhl.kfsq.entity.sm.User;
import com.jzhl.kfsq.service.sm.IUserService;

/**
 * 用户对外接口类
 * 
 * @author Shaw
 *
 */
@Controller
public class UserController {

	@Autowired
	private IUserService userService;

	private static final Logger logger = Logger.getLogger(UserController.class);

	/**
	 * 添加用户
	 * 
	 * @param user
	 * @return ResponseBean
	 */
	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "/user/addUser", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean addTeam(User user) throws Exception {
		System.out.println("成功");
		return null;
	}

	/**
	 * 销售经理添加置业顾问
	 * 
	 * @param dto
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/serv/user/saler", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean<Map<String, Object>> addSaler(SalerInsertDto dto) throws Exception {
		
		// 取得所属分站ID
		User param = new User();
		param.setUserId(dto.getLeaderUserId());
		User leaderUser = userService.getUser(param);
		if (leaderUser != null) {
			Integer branchId = leaderUser.getBranchId();
			dto.setBranchId(branchId);
		}
		
		userService.insertSaler(dto);
		param = new User();
		param.setAccount(dto.getAccount());
		User user = userService.getUser(param);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("userId", user.getUserId());
		ResponseBean<Map<String, Object>> result = new ResponseBean<Map<String, Object>>(map);
		result.operateSuccess("添加成功");
		return result;
	}

	/**
	 * 根据用户编号查询用户信息
	 * 
	 * @param userId
	 *            用户编号
	 * @return ResponseBean
	 */
	@RequestMapping(value = "/serv/user/detail", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean<User> getUser(UserDto dto) throws Exception {

		logger.debug("[用户信息]--根据用户编号查询用户信息，用户编号为：" + dto.getUserId());

		User queryCondition = new User();
		BeanUtils.copyProperties(dto, queryCondition);

		User user = userService.getUser(queryCondition);

		ResponseBean<User> result = new ResponseBean<User>(user);

		result.operateSuccess();

		return result;

	}
	
	/**
	 * 查询登录用户信息
	 * 
	 * @param userId
	 *            用户编号
	 * @return ResponseBean
	 */
	@RequestMapping(value = "/serv/user/login", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean<User> getLoginUser(UserDto dto) throws Exception {

		logger.debug("[用户信息]--查询登录用户信息，用户编号为：" + dto.getUserId());

		User queryCondition = new User();
		BeanUtils.copyProperties(dto, queryCondition);

		User user = userService.getLoginUser(queryCondition);

		ResponseBean<User> result = new ResponseBean<User>(user);

		result.operateSuccess();

		return result;

	}	

	/**
	 * 用户更新时，查询除了自己之外的用户，是否有注册过account和phone的
	 * 
	 * @param userId
	 *            用户编号
	 * @return ResponseBean
	 */
	@RequestMapping(value = "/serv/user/userinfo", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean<User> getUserInfo(UserDto dto) throws Exception {

		logger.debug("[用户信息]--根据用户编号查询用户信息，用户编号为：" + dto.getUserId());

		User user = new User();
		BeanUtils.copyProperties(dto, user);

		User resultUser = userService.getUserInfo(user);

		ResponseBean<User> result = new ResponseBean<User>(resultUser);

		result.operateSuccess();

		return result;

	}

	/**
	 * 查询代理商userid和代理商公司名称
	 */
	@SuppressWarnings({ "rawtypes" })
	@RequestMapping(value = "/serv/user/findBranchList", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean findBranchList() throws Exception {

		// 按照月份分组查询用户数量
		List<UserDataSet> branchlist = userService.findBranchList();

		Map<String, Object> queryResult = new HashMap<String, Object>();
		// 返回数据添加
		queryResult.put("dataList", branchlist);
		ResponseBean<Map<String, Object>> result = new ResponseBean<Map<String, Object>>(queryResult);
		result.operateSuccess();
		return result;
	}

	/**
	 * 开启/关闭用户
	 * 
	 * @param dto
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "/serv/user/m", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean updateUser(SalerDto dto) throws Exception {
		User user = new User();
		user.setUserId(dto.getUserId());
		user.setIsValid(Integer.parseInt(dto.getIsValid()));
		userService.updateUser(user);
		ResponseBean result = new ResponseBean();
		result.operateSuccess("修改成功");
		return result;
	}

	/**
	 * 验证旧用户密码
	 * 
	 * @param dto
	 * @return
	 */
	@RequestMapping(value = "/serv/user/oldPassword", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean<User> verifyOldPassword(PasswordDto dto) {
		User user = userService.verifyOldPassword(dto);
		ResponseBean<User> result = new ResponseBean<User>(user);
		result.operateSuccess("查询成功");
		return result;
	}

	/**
	 * 更新用户密码
	 * 
	 * @param dto
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	@ResponseBody
	@RequestMapping(value = "/serv/user/newPassword", method = RequestMethod.POST)
	public ResponseBean updatePassword(PasswordDto dto) {
		userService.updatePassword(dto);
		ResponseBean result = new ResponseBean();
		result.operateSuccess("更新成功");
		return result;
	}

	/**
	 * 修改用户信息
	 * 
	 * @param user
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "/serv/user/modifyUser", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean modifyUser(User user) throws Exception {
		logger.debug("[用户信息]--修改");
		ResponseBean result = new ResponseBean();
		userService.updateUser(user);
		result.operateSuccess();
		return result;
	}
	
	
	/**
	 * 获取用户所属楼盘
	 * @param userId
	 * @return
	 */
	@RequestMapping(value = "/serv/user/getBuildingId", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean<Map<String, Object>> getUserBuilding(Integer userId) {
		Integer buildingId = userService.getUserBuilding(userId);
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("buildingId", buildingId);
		return new ResponseBean<Map<String, Object>>(param);
	}
	
	
	/**
	 * 通过web'端用户ID获取城市ID
	 * @param userId
	 * @return
	 */
	@RequestMapping(value = "/serv/user/getUserCityId", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean<Map<String, Object>> getUserCityId(Integer userId) {
		Integer cityId = userService.getUserCityId(userId);
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("cityId", cityId);
		return new ResponseBean<Map<String, Object>>(param);
	}
	
	/**
	 * 验证账户是否存在
	 * @param dto
	 * @return
	 */
	@RequestMapping(value = "/serv/user/accountIsExist", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean<Map<String, Object>> accountIsExist(ValiAccountDto dto){
		Boolean isExist = userService.accountIsExist(dto);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("isExist", isExist);
		ResponseBean<Map<String, Object>> result = new ResponseBean<Map<String, Object>>(map);
		return result;
	}

}
