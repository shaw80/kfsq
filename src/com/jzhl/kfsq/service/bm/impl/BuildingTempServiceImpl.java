package com.jzhl.kfsq.service.bm.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jzhl.kfsq.dao.bm.IBuildingFeatureTempMapper;
import com.jzhl.kfsq.dao.bm.IBuildingTempMapper;
import com.jzhl.kfsq.dao.bm.IUnitMapTempMapper;
import com.jzhl.kfsq.dataset.bm.BuildingTempInfoDataSet;
import com.jzhl.kfsq.entity.bm.BuildingFeatureTemp;
import com.jzhl.kfsq.entity.bm.BuildingTemp;
import com.jzhl.kfsq.entity.bm.UnitMapTemp;
import com.jzhl.kfsq.service.bm.IBuildingTempService;

@Service
public class BuildingTempServiceImpl implements IBuildingTempService {
	
	@Autowired
	private IBuildingTempMapper buildingTempDao;
	@Autowired
	private IUnitMapTempMapper unitMapTempDao;
	@Autowired
	private IBuildingFeatureTempMapper buildingFeatureTempDao;

	@Override
	public BuildingTemp insertBuildingTemp(BuildingTemp buildingTemp) {
		buildingTempDao.insertBuildingTemp(buildingTemp);
		return buildingTemp;
	}

	@Override
	public void updateBuildingTemp(BuildingTemp buildingTemp) {
		buildingTempDao.updateBuildingTemp(buildingTemp);
	}
	
	@Override
	public void updateBuildingTempInValid(String[] buildingIds) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("buildingIds", buildingIds);
		buildingTempDao.updateBuildingTempInValid(map);
	}
	
	@Override
	public void insertBuildingFeatureTemp(BuildingFeatureTemp buildingTempDto) {
		buildingFeatureTempDao.insertBuildingFeatureTemp(buildingTempDto);
	}

	@Override
	public void updateBuildingFeatureTemp(BuildingFeatureTemp buildingTempDto) {
		buildingFeatureTempDao.updateBuildingFeatureTemp(buildingTempDto);
	}
	
	@Override
	public void updateBuildingFeatureTempInValid(String[] featureIds) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("featureIds", featureIds);
		buildingFeatureTempDao.updateBuildingFeatureTempInValid(map);
	}

	@Override
	public void insertUnitMapTemp(UnitMapTemp unitMapTemp) {
		unitMapTempDao.insertUnitMapTemp(unitMapTemp);
	}

	@Override
	public void updateUnitMapTemp(UnitMapTemp unitMapTemp) {
		unitMapTempDao.updateUnitMapTemp(unitMapTemp);
	}
	
	@Override
	public void updateUnitMapTempInValid(String[] unitMapIds) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("unitMapIds", unitMapIds);
		unitMapTempDao.updateUnitMapTempInValid(map);
	}

	@Override
	public List<BuildingTempInfoDataSet> findBuildingTempInfo(BuildingTemp buildingTemp) {
		List<BuildingTempInfoDataSet> result = new ArrayList<BuildingTempInfoDataSet>();
		List<BuildingTemp> buildingTempList = buildingTempDao.findBuildingTemp(buildingTemp);
		for(BuildingTemp bt : buildingTempList) {
			BuildingTempInfoDataSet buildingTempInfoDataSet = new BuildingTempInfoDataSet();
			BeanUtils.copyProperties(bt, buildingTempInfoDataSet);
			
			BuildingFeatureTemp buildingFeatureTemp = new BuildingFeatureTemp();
			buildingFeatureTemp.setBuildingId(bt.getBuildingId());
			buildingFeatureTemp.setIsSynchronous(bt.getIsSynchronous());
			List<BuildingFeatureTemp> bftList = buildingFeatureTempDao.findBuildingFeatureTemp(buildingFeatureTemp);
			buildingTempInfoDataSet.setBuildingFeatureTempList(bftList);
			
			UnitMapTemp unitMapTemp = new UnitMapTemp();
			unitMapTemp.setBuildingId(bt.getBuildingId());
			unitMapTemp.setIsSynchronous(bt.getIsSynchronous());
			List<UnitMapTemp> umtList = unitMapTempDao.findUnitMapTempList(unitMapTemp);
			buildingTempInfoDataSet.setUnitMapTempList(umtList);
			
			result.add(buildingTempInfoDataSet);
		}
		
		return result;
	}
	
	@Override
	public void updateBuildingInfoSynchronized(Integer buildingId) {
		buildingTempDao.updateBuildingTempSynchronized(buildingId);
		unitMapTempDao.updateUnitMapTempSynchronized(buildingId);
		buildingFeatureTempDao.updateBuildingFeatureTempSynchronized(buildingId);
	}

	@Override
	public int getBuildingTempCount(BuildingTemp buildingTemp) {
		return buildingTempDao.getBuildingTempCount(buildingTemp);
	}

}
