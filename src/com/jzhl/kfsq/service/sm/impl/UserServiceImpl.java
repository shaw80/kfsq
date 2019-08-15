package com.jzhl.kfsq.service.sm.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.jzhl.kfsq.common.util.StringEncrypt;
import com.jzhl.kfsq.dao.sm.IRoleMapper;
import com.jzhl.kfsq.dao.sm.IUserBuildingMapper;
import com.jzhl.kfsq.dao.sm.IUserMapper;
import com.jzhl.kfsq.dataset.sm.UserDataSet;
import com.jzhl.kfsq.dto.sm.PasswordDto;
import com.jzhl.kfsq.dto.sm.SalerInsertDto;
import com.jzhl.kfsq.dto.sm.StatisticalDto;
import com.jzhl.kfsq.dto.sm.ValiAccountDto;
import com.jzhl.kfsq.entity.sm.Role;
import com.jzhl.kfsq.entity.sm.User;
import com.jzhl.kfsq.entity.sm.UserBuilding;
import com.jzhl.kfsq.service.sm.IUserCacheService;
import com.jzhl.kfsq.service.sm.IUserService;

/**
 * 用户业务层实现类
 * 
 * @author Shaw
 *
 */
@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private IUserMapper userDao;

	@Autowired
	private IUserBuildingMapper userBuildingDao;

	@Autowired
	private IUserCacheService userCacheService = null;

	@Autowired
	@Qualifier("IRoleMapper")
	private IRoleMapper roleDao;

	/**
	 * 添加用户
	 * 
	 * @param user
	 *            用户实体类
	 */
	public void insertUser(User user) {

		// 口令MD5加密
		String password = user.getPassword();
		user.setPassword(StringEncrypt.MD5(password));

		// 根据roleCode 查询售楼总监的roleId
		if (user.getRoleCode() != null) {
			Role role = roleDao.getRoleByRoleCode(user.getRoleCode());
			user.setRoleId(role.getRoleId());
		}

		userDao.insertUser(user);

		if (user.getAppUserType() != null) {
			// SM_UserBuilding 中间表中插入数据
			UserBuilding userBuilding = new UserBuilding();
			userBuilding.setUserid(user.getUserId());
			if (user.getAppUserType() == 1) {
				// 根据登录userID 查询 buildingId
				userBuilding.setBuildingid(getUserBuilding(user.getLeaderUserId()));
				userBuilding.setCreatoruserid(user.getLeaderUserId()); // 登录者ID，在上级定义为父类ID了；
			} else {
				// 根据登录userID 查询 buildingId
				userBuilding.setBuildingid(getUserBuilding(user.getLoginUserId()));
				userBuilding.setCreatoruserid(user.getLoginUserId()); // 登录者ID;
			}
			userBuilding.setIsvalid((short) 1);
			userBuilding.setStatus((short) 1);
			insertBuildingUser(userBuilding);
		}

	}

	/**
	 * 新增销售总监
	 * 
	 * @author zhouzy
	 */
	@Override
	public void insertBuildingUser(User user) {

		// 口令MD5加密
		String password = user.getPassword();
		user.setPassword(StringEncrypt.MD5(password));

		// 根据roleCode 查询售楼总监的roleId
		Role role = roleDao.getRoleByRoleCode("director");
		user.setRoleId(role.getRoleId());

		userDao.insertUser(user);

		// SM_UserBuilding 中间表中插入数据
		UserBuilding userBuilding = new UserBuilding();
		userBuilding.setUserid(user.getUserId());
		userBuilding.setBuildingid(user.getBuildingId());
		userBuilding.setCreatoruserid(user.getLeaderUserId()); // 登录者ID，在上级定义为父类ID了；
		userBuilding.setIsvalid((short) 1);
		userBuilding.setStatus((short) 1);
		insertBuildingUser(userBuilding);
	}

	/**
	 * 删除用户
	 * 
	 * @param userId
	 *            用户编号
	 */
	public void deleteUser(int userId) {
		userDao.deleteUser(userId);
	}

	/**
	 * 修改用户
	 * 
	 * @param user
	 *            用户实体类
	 */
	public void updateUser(User user) throws Exception {

		// 口令MD5加密
		String password = user.getPassword();
		user.setPassword(StringEncrypt.MD5(password));

		userDao.updateUser(user);

		// B端用户冻结开启处理
		if (user.getIsValid() != null) {

			int isValid = user.getIsValid();
			user.setIsValid(null);

			User queryResult = userDao.getUser(user);
			if (queryResult != null) {
				if (queryResult.getAppUserType() != null) {
					String account = queryResult.getAccount();
					if (isValid == 0) {
						userCacheService.clearAccount(account);
					} else if (isValid == 1) {
						userCacheService.addOrUpdate(queryResult);
					}
				}

			}

		}

	}

	/**
	 * 根据用户条件查询用户信息
	 * 
	 * @param 用户查询条件
	 * @return 用户实体类
	 */
	public User getUser(User userCondition) {
		User user = userDao.getUser(userCondition);
		return user;
	}

	/**
	 * 查询登录用户信息
	 * 
	 * @param 用户信息
	 * @return 用户实体类
	 */
	public User getLoginUser(User userCondition) {

		// 口令MD5加密
		String password = userCondition.getPassword();
		userCondition.setPassword(StringEncrypt.MD5(password));

		User user = userDao.getLoginUser(userCondition);
		return user;
	}

	/**
	 * 查询全部用户
	 * 
	 * @return 用户集合
	 */
	public List<User> findAllByPage(int begin, int length) {
		List<User> result = userDao.findAllByPage(begin, length);
		return result;
	}

	/**
	 * 查询代理商公司名称与UserID
	 * 
	 * @author zhouzy
	 */
	@Override
	public List<UserDataSet> findBranchList() {
		List<UserDataSet> result = userDao.findBranchList();
		return result;
	}

	/**
	 * 根据代理商userid查询其下管理人员总数与列表
	 * 
	 * @author zhouzy
	 */
	@Override
	public List<User> findUserList(Map<String, Object> map) {

		// 根据roleCode 查询销售经理的roleId
		if (map.containsKey("roleCode")) {
			Role role = roleDao.getRoleByRoleCode(map.get("roleCode").toString());
			map.put("roleId", role.getRoleId());
		}
		List<User> result = userDao.findUserList(map);
		return result;
	}

	/**
	 * 根据代理商userid查询其下管理人员总数与列表
	 * 
	 * @author zhouzy
	 */
	@Override
	public int getUserDataCount(Map<String, Object> map) {
		int dataCount = userDao.getUserDataCount(map);
		return dataCount;
	}

	/**
	 * 权限管理-新增楼盘-销售总监
	 * 
	 * @author zhouzy
	 */
	@Override
	public void insertBuildingUser(UserBuilding userBuilding) {
		userDao.insertBuildingUser(userBuilding);
	}

	/**
	 * 查询登录销售总监旗下的所有销售经理列表-每个销售团队
	 * 
	 * @author zhouzy
	 */
	@Override
	public List<UserDataSet> findSaleLeaderList(StatisticalDto statisticalDto) {
		List<UserDataSet> result = userDao.findSaleLeaderList(statisticalDto);
		return result;
	}

	/**
	 * 根据userId 查旗下所有售楼员接待用户总量
	 * 
	 * @author zhouzy
	 */
	@Override
	public int getMemberCount(Map<String, Object> map) {
		int dataCount = userDao.getMemberCount(map);
		return dataCount;
	}

	/**
	 * 用户查询
	 * 
	 * @author zhouzy
	 */
	@Override
	public User getUserInfo(User user) {
		User userResult = userDao.getUserInfo(user);
		return userResult;
	}

	/**
	 * 验证旧用户密码
	 * 
	 * @param dto
	 */
	@Override
	public User verifyOldPassword(PasswordDto dto) {
		User user = new User();
		user.setUserId(dto.getUserId());
		User result = userDao.getUser(user);
		return result;
	}

	/**
	 * 修改新用户密码
	 * 
	 * @param dto
	 */
	@Override
	public void updatePassword(PasswordDto dto) {
		try {
			User user = new User();
			user.setUserId(dto.getUserId());
			user.setPassword(dto.getNewPassword());

			// 口令MD5加密
			String password = user.getPassword();
			user.setPassword(StringEncrypt.MD5(password));

			userDao.updateUser(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 根据登录ID售楼总监检索其下所有置业顾问列表
	 * 
	 * @author zhouzy
	 */
	@Override
	public List<User> findSaleUserList(Map<String, Object> map) {
		List<User> result = userDao.findSaleUserList(map);
		return result;
	}

	/**
	 * 根据登录ID售楼总监检索其下所有置业顾问列表总数
	 * 
	 * @author zhouzy
	 */
	@Override
	public int getSaleUserDataCount(Map<String, Object> map) {
		int dataCount = userDao.getSaleUserDataCount(map);
		return dataCount;
	}

	/**
	 * 销售经理添加置业顾问
	 * 
	 * @param dto
	 */
	@Override
	public void insertSaler(SalerInsertDto dto) throws Exception {

		User user = new User();
		user.setAccount(dto.getAccount());
		user.setName(dto.getName());
		user.setPassword(dto.getPassword());
		user.setLeaderUserId(dto.getLeaderUserId());
		user.setAppUserType(2);
		user.setUserType(1);
		user.setCreatorUserId(dto.getLeaderUserId());
		// 根据roleCode 查询置业顾问的roleId
		Role role = roleDao.getRoleByRoleCode("saler");
		user.setRoleId(role.getRoleId());
		user.setBranchId(dto.getBranchId());
		// 口令MD5加密
		String password = user.getPassword();
		user.setPassword(StringEncrypt.MD5(password));
		userDao.insertUser(user);

		// 加缓存
		if (user.getUserType() == 1) {
			userCacheService.addOrUpdate(user);
		}

		Integer buildingId = userBuildingDao.getUserBuildingByUserId(dto.getLeaderUserId()).getBuildingid();

		UserBuilding ub = new UserBuilding();
		ub.setUserid(user.getUserId());
		ub.setBuildingid(buildingId);
		ub.setCreatoruserid(dto.getLeaderUserId());
		userBuildingDao.insertUserBuilding(ub);
	}

	/**
	 * 根据销售总监登录ID查询其负责哪个楼盘
	 * 
	 * @author zhouzy
	 */
	@Override
	public Integer getUserBuilding(Integer userId) {
		Integer result = userDao.getUserBuilding(userId);
		return result;
	}

	/**
	 * 通过web端用户id查询所属城市ID
	 * 
	 * @param userId
	 * @return
	 */
	@Override
	public Integer getUserCityId(Integer userId) {
		return userDao.getUserCityId(userId);
	}

	/**
	 * 验证用户是否存在
	 * 
	 * @param dto
	 * @return
	 */
	@Override
	public Boolean accountIsExist(ValiAccountDto dto) {
		Boolean isExist = false;
		User param = new User();
		param.setAccount(dto.getAccount());
		User user = userDao.getUser(param);
		if (user != null) {
			isExist = true;// 存在
		}
		return isExist;
	}

	/**
	 * 根据楼盘Id获取营销总监userId
	 * 
	 * @author zhouzy
	 */
	@Override
	public Integer getUserIdByBuildingId(int buildingId) {
		Integer result = userDao.getUserIdByBuildingId(buildingId);
		return result;
	}

}
