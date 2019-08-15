package com.jzhl.kfsq.dao.sm;

import java.util.List;
import java.util.Map;

import com.jzhl.kfsq.dataset.sm.AreaDataSet;
import com.jzhl.kfsq.dto.sm.AreaDto;
import com.jzhl.kfsq.entity.sm.Area;

public interface IAreaMapper {

	public List<Area> findArea(Area area);

	// 通过登录的代理商的站 id获得地域
	public List<Area> findAreaBybranchId(int branchId);

	public void insertArea(Area area);

	public void updateArea(Area area);

	public Area getArea(Integer areaId);

	/**
	 * 根据城市ID查询区域信息
	 * 
	 * @param area
	 * @return
	 */
	public List<Area> findAreaByCityId(Area area);

	/**
	 * 根据城市ID查询App首页列表的区域信息属性集合
	 * 
	 * @param cityId
	 * @return
	 */
	public List<AreaDataSet> findAreaDateSet(int cityId);

	/**
	 * 根据城市名称查询区域信息
	 * 
	 * @param area
	 * @return
	 */
	public List<Area> findAreaByCityName(AreaDto dto);

	/**
	 * 分页获取区域列表；addby zhouzy 20160401
	 * 
	 * @param area
	 * @return
	 */
	public List<Area> findAreaList(Map<String, Object> map);

	/**
	 * 获取区域列表总数；addby zhouzy 20160401
	 * 
	 * @param area
	 * @return
	 */
	public int getAreaDataCount(Map<String, Object> map);

	/**
	 * 根据一级区域 areaId 获取二级区域列表
	 * 
	 * @param areaId
	 * @return
	 */
	public List<Area> findScecondAreaList(Map<String, Object> map);

	/**
	 * 根据一级区域 areaId 获取二级区域列表 - 分页
	 * 
	 * @param areaId
	 * @return
	 */
	public List<Area> findSecondAreaListByPage(Map<String, Object> param);

	/**
	 * 根据一级区域 areaId 获取二级区域列表 - 分页 总数
	 * 
	 * @param areaId
	 * @return
	 */
	public int findSecondAreaListByPageDataCount(Map<String, Object> param);
}
