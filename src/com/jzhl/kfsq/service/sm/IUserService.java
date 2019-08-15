package com.jzhl.kfsq.service.sm;

import java.util.List;
import java.util.Map;

import com.jzhl.kfsq.dataset.sm.UserDataSet;
import com.jzhl.kfsq.dto.sm.PasswordDto;
import com.jzhl.kfsq.dto.sm.SalerInsertDto;
import com.jzhl.kfsq.dto.sm.StatisticalDto;
import com.jzhl.kfsq.dto.sm.ValiAccountDto;
import com.jzhl.kfsq.entity.sm.User;
import com.jzhl.kfsq.entity.sm.UserBuilding;

/**
 * 用户业务层接口
 * 
 * @author Shaw
 *
 */
public interface IUserService {

	/**
	 * 添加用户
	 * 
	 * @param user
	 *            用户实体类
	 */
	public void insertUser(User user);

	/**
	 * 销售经理添加置业顾问
	 * 
	 * @param dto
	 */
	public void insertSaler(SalerInsertDto dto) throws Exception;

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
	public void updateUser(User user) throws Exception;

	/**
	 * 根据用户条件查询用户信息
	 * 
	 * @param 用户查询条件
	 * @return 用户实体类
	 */
	public User getUser(User userCondition);

	/**
	 * 查询登录用户信息
	 * 
	 * @param 用户信息
	 * @return 用户实体类
	 */
	public User getLoginUser(User userCondition);

	/**
	 * 分页查询全部用户资料
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
	 * 新增销售总监
	 * 
	 * @author zhouzy
	 */
	public void insertBuildingUser(User user);

	/**
	 * 用户查询
	 * 
	 * @author zhouzy
	 */
	public User getUserInfo(User user);

	/**
	 * 验证旧用户密码
	 * 
	 * @param dto
	 */
	public User verifyOldPassword(PasswordDto dto);

	/**
	 * 修改新用户密码
	 * 
	 * @param dto
	 */
	public void updatePassword(PasswordDto dto);

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
	 * 验证用户是否存在
	 * 
	 * @param dto
	 * @return
	 */
	public Boolean accountIsExist(ValiAccountDto dto);

	/**
	 * 根据楼盘Id获取营销总监userId
	 * 
	 * @author zhouzy
	 */
	public Integer getUserIdByBuildingId(int buildingId);
}
