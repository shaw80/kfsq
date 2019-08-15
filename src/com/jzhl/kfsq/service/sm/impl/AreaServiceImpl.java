package com.jzhl.kfsq.service.sm.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jzhl.kfsq.dao.sm.IAreaMapper;
import com.jzhl.kfsq.dataset.sm.AreaDataSet;
import com.jzhl.kfsq.dto.sm.AreaDto;
import com.jzhl.kfsq.entity.sm.Area;
import com.jzhl.kfsq.service.sm.IAreaService;

/**
 * 区域业务实现类
 * 
 * @author Shaw
 *
 */
@Service
public class AreaServiceImpl implements IAreaService {

	@Autowired
	private IAreaMapper IAreaDao;

	@Override
	public List<Area> findArea(Area area) {
		return IAreaDao.findAreaByCityId(area);
	}

	@Override
	public void insertArea(Area area) {
		IAreaDao.insertArea(area);
	}

	@Override
	public void updateArea(Area area) {
		IAreaDao.updateArea(area);
	}

	@Override
	public Area getArea(Integer areaId) {
		return IAreaDao.getArea(areaId);
	}

	@Override
	public List<Area> findAreaByCityName(AreaDto dto) {
		List<Area> result = IAreaDao.findAreaByCityName(dto);
		return result;
	}

	// 分页获取区域列表；addby zhouzy 20160401
	@Override
	public List<Area> findAreaList(Map<String, Object> map) {
		return IAreaDao.findAreaList(map);
	}

	// 获取区域列表总数；addby zhouzy 20160401
	@Override
	public int getAreaDataCount(Map<String, Object> map) {
		int dataCount = IAreaDao.getAreaDataCount(map);
		return dataCount;
	}

	/**
	 * 根据城市ID查询App首页列表的区域信息属性集合
	 * 
	 * @param cityId
	 * @return
	 */
	@Override
	public List<AreaDataSet> findAreaDateSet(int cityId) {
		List<AreaDataSet> result = IAreaDao.findAreaDateSet(cityId);
		return result;
	}

	/**
	 * 根据一级区域 areaId 获取二级区域列表
	 * 
	 * @param areaId
	 * @return
	 */
	@Override
	public List<Area> findScecondAreaList(Map<String, Object> map) {
		List<Area> result = IAreaDao.findScecondAreaList(map);
		return result;
	}

	/**
	 * 根据一级区域 areaId 获取二级区域列表 - 分页
	 * 
	 * @param areaId
	 * @return
	 */
	@Override
	public List<Area> findSecondAreaListByPage(Map<String, Object> param) {
		List<Area> result = IAreaDao.findSecondAreaListByPage(param);
		return result;
	}

	/**
	 * 根据一级区域 areaId 获取二级区域列表 - 分页 总数
	 * 
	 * @param areaId
	 * @return
	 */
	@Override
	public int findSecondAreaListByPageDataCount(Map<String, Object> param) {
		int dataCount = IAreaDao.findSecondAreaListByPageDataCount(param);
		return dataCount;
	}

}
