package com.jzhl.kfsq.dao.sm;

import com.jzhl.kfsq.entity.sm.UserBuilding;

/**
 * 用户楼盘中间表数据访问层
 * 
 * @author Shaw
 *
 */
public interface IUserBuildingMapper {

	/**
	 * 添加中间关系
	 * 
	 * @param ub
	 */
	public void insertUserBuilding(UserBuilding ub);

	/**
	 * 根据用户编号查询中间表
	 * 
	 * @param userId
	 * @return
	 */
	public UserBuilding getUserBuildingByUserId(int userId);

}
