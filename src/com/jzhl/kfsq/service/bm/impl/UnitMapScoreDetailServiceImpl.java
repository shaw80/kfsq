package com.jzhl.kfsq.service.bm.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jzhl.kfsq.common.base.ListResult;
import com.jzhl.kfsq.dao.bm.IBuildingMapper;
import com.jzhl.kfsq.dao.bm.IUnitMapMapper;
import com.jzhl.kfsq.dao.bm.IUnitMapScoreDetailMapper;
import com.jzhl.kfsq.dao.sm.ITagMapper;
import com.jzhl.kfsq.dataset.bm.UnitMapScoreDetail;
import com.jzhl.kfsq.dataset.bm.UnitMapV2DataSet;
import com.jzhl.kfsq.dataset.sm.FeatureTagDataSet;
import com.jzhl.kfsq.dto.bm.UnitMapScoreDetailDto;
import com.jzhl.kfsq.entity.bm.Building;
import com.jzhl.kfsq.entity.bm.UnitMap;
import com.jzhl.kfsq.service.bm.IUnitMapScoreDetailService;

/**
 * 户型分数详情业务实现类
 * 
 * @author Shaw
 *
 */
@Service
public class UnitMapScoreDetailServiceImpl implements
		IUnitMapScoreDetailService {
	
	@Autowired IUnitMapScoreDetailMapper unitMapScoreDetailDao;
	@Autowired IUnitMapMapper unitMapDao;
	@Autowired IBuildingMapper buildingDao;
	@Autowired ITagMapper tagDao;

	/**
	 * 根据楼盘编号查询户型分数详情
	 * 
	 * @param buildingId
	 * @return
	 */
	@Override
	public UnitMapScoreDetail getUnitMapScoreDetail(UnitMapScoreDetailDto dto) {
		UnitMapScoreDetail result = unitMapScoreDetailDao.getUnitMapScoreDetail(dto.getBuildingId());// 根据楼盘编号查询户型分数详情
		if (result == null) {
			result = new UnitMapScoreDetail();
		}
		dto.setOffset(20);
		List<UnitMap> dataList = unitMapDao.findUnitMapByBuildingIdAndPage(dto);// 根据楼盘编号查询户型图集合
		int dataCount = unitMapDao.countUnitMapByBuildingIdAndPage(dto);
		Building building = buildingDao.getBuildingByBuildingId(dto.getBuildingId());
		String decorationSituation = "";
		if(building.getDecorationSituation() != null){
			if(building.getDecorationSituation().equals(0)){
				decorationSituation = "毛坯";
			}else{
				decorationSituation = "精装";
			}
		}
		ListResult listResult = new ListResult();
		List<UnitMapV2DataSet> maps = new ArrayList<UnitMapV2DataSet>();
		for (UnitMap unitMap : dataList) {
			UnitMapV2DataSet data = new UnitMapV2DataSet();
			data.setUnitMapId(unitMap.getUnitMapId());
			data.setDecorationSituation(decorationSituation);
			if(unitMap.getAcreage() != null){
				data.setAcreage(String.valueOf(unitMap.getAcreage()));
			}
			data.setImgDes(unitMap.getImgDes());
			data.setImgName(unitMap.getImgName());
			data.setPath(unitMap.getPath());
			if(unitMap.getRoomRate() != null){
				data.setRoomRate(unitMap.getRoomRate() + "%");
			}
			if(unitMap.getTotalPrice() != null){
				data.setTotalPrice(String.valueOf(unitMap.getTotalPrice()));
			}
			if(unitMap.getTurned() != null){
				data.setTurned(unitMap.getTurned());
			}
			List<FeatureTagDataSet> tags = tagDao.findTagByUnitMapId(unitMap.getUnitMapId());
			data.setTags(tags);
			maps.add(data);
		}
		listResult.setDataCount(dataCount);
		listResult.setDataList(maps);
		result.setListResult(listResult);
		return result;
	}

}
