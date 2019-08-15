package com.jzhl.kfsq.dao.sm;

import java.util.List;
import java.util.Map;

import com.jzhl.kfsq.dataset.sm.UserDataSet;
import com.jzhl.kfsq.dto.sm.StatisticalDto;
import com.jzhl.kfsq.entity.sm.User;
import com.jzhl.kfsq.entity.sm.UserBuilding;

/**
 * 用户数据访问层接口
 * 
 * @author Shaw
 *
 */
public interface IUserMapper {

	/**
	 * 添加用户
	 * 
	 * @param user
	 *            用户实体类
	 */
	public void insertUser(User user);

	/**
	 * 删除用户
	 * 
	 * @param userId
	 *            用户编号
	 */
	public void deleteUser(int userId);

	/**
	 * 修改用户
	 * 
	 * @param user
	 *            用户实体类
	 */
	public void updateUser(User user);

	/**
	 * 根据用户信息条件查询用户信息
	 * 
	 * @param 用户信息
	 * @return 用户实体类
	 */
	public User getUser(User user);

	/**
	 * 查询登录用户信息
	 * 
	 * @param 用户信息
	 * @return 用户实体类
	 */
	public User getLoginUser(User user);

	/**
	 * 根据用户信息条件查询用户列表信息
	 * 
	 * @param 用户信息
	 * @return 查询条件
	 */
	public List<User> getUsers(Map<String, Object> params);

	/**
	 * 根据账户查询用户信息
	 * 
	 * @param account
	 * @return
	 */
	public User getUserByAccount(String account);

	/**
	 * 分页查询全部用户信息
	 * 
	 * @param begin
	 *            起始条目
	 * @param length
	 *            长度
	 * @return 用户集合
	 */
	public List<User> findAllByPage(int begin, int length);

	/**
	 * 查询代理商公司名称与UserID
	 * 
	 * @author zhouzy
	 */
	public List<UserDataSet> findBranchList();

	/**
	 * 根据代理商userid查询其下管理人员总数与列表
	 * 
	 * @author zhouzy
	 */
	public List<User> findUserList(Map<String, Object> map);

	/**
	 * 根据代理商userid查询其下管理人员总数与列表
	 * 
	 * @author zhouzy
	 */
	public int getUserDataCount(Map<String, Object> map);

	/**
	 * 权限管理-新增楼盘-销售总监
	 * 
	 * @author zhouzy
	 */
	public void insertBuildingUser(UserBuilding userBuilding);

	/**
	 * 查询登录销售总监旗下的所有销售经理列表-每个销售团队
	 * 
	 * @author zhouzy
	 */
	public List<UserDataSet> findSaleLeaderList(StatisticalDto statisticalDto);

	/**
	 * 根据userId 查旗下所有售楼员接待用户总量
	 * 
	 * @author zhouzy
	 */
	public int getMemberCount(Map<String, Object> map);

	/**
	 * 用户查询
	 * 
	 * @author zhouzy
	 */
	public User getUserInfo(User user);

	/**
	 * 根据登录ID售楼总监检索其下所有置业顾问列表
	 * 
	 * @author zhouzy
	 */
	public List<User> findSaleUserList(Map<String, Object> map);

	/**
	 * 根据登录ID售楼总监检索其下所有置业顾问列表总数
	 * 
	 * @author zhouzy
	 */
	public int getSaleUserDataCount(Map<String, Object> map);

	/**
	 * 根据销售总监登录ID查询其负责哪个楼盘
	 * 
	 * @author zhouzy
	 */
	public Integer getUserBuilding(Integer userId);

	/**
	 * 通过web端用户id查询所属城市ID
	 * 
	 * @param userId
	 * @return
	 */
	public Integer getUserCityId(Integer userId);

	/**
	 * 根据楼盘Id获取营销总监userId
	 * 
	 * @author zhouzy
	 */
	public Integer getUserIdByBuildingId(int buildingId);

}
