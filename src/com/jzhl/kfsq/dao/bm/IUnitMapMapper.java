package com.jzhl.kfsq.dao.bm;

import java.util.List;
import java.util.Map;

import com.jzhl.kfsq.dataset.bm.UnitMapDataSet;
import com.jzhl.kfsq.dto.bm.UnitMapDto;
import com.jzhl.kfsq.dto.bm.UnitMapScoreDetailDto;
import com.jzhl.kfsq.entity.bm.UnitMap;

public interface IUnitMapMapper {

	public List<UnitMap> findUnitMap(UnitMap unitMap);

	public int insert(UnitMap unitMap);

	public List<UnitMapDataSet> findUnitMapList(Map<String, Object> map);

	public int unitMapListCount(Map<String, Object> map);

	// 根据id查询户型
	public UnitMapDataSet getUnitMap(UnitMap unitMap);

	public void updateMap(UnitMap unitMap);

	/**
	 * 更新户型图(除isValid外全字段更新)
	 * 
	 * @param unitMap
	 */
	public void update(UnitMap unitMap);

	/**
	 * 禁用楼盘户型图
	 * 
	 * @param unitMap
	 */
	public void inValid(UnitMap unitMap);

	/**
	 * 根据楼盘编号分页查询户型图
	 * 
	 * @param dto
	 * @return
	 */
	public List<UnitMap> findUnitMapByBuildingIdAndPage(UnitMapScoreDetailDto dto);

	/**
	 * 根据楼盘编号统计户型图个数
	 * 
	 * @param dto
	 * @return
	 */
	public int countUnitMapByBuildingIdAndPage(UnitMapScoreDetailDto dto);

	/**
	 * 根据楼盘编号查询户型描述
	 * 
	 * @param buildingId
	 * @return
	 */
	public List<String> findUnitMapDes(int buildingId);

	/**
	 * 根据户型ID删除对应数据列表
	 * 
	 * @author zhouzy
	 * 
	 */
	public void deleteUnitMapFeature(UnitMapDto dto);
}
