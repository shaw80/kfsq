package com.jzhl.kfsq.service.bm.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jzhl.kfsq.dao.bm.IBuildingFeatureMapper;
import com.jzhl.kfsq.dao.bm.IBuildingMapper;
import com.jzhl.kfsq.dao.bm.IUnitMapMapper;
import com.jzhl.kfsq.dao.cm.IBuildingCommentMapper;
import com.jzhl.kfsq.dao.cm.ICommentImgMapper;
import com.jzhl.kfsq.dao.sm.IAreaMapper;
import com.jzhl.kfsq.dao.sm.IEnvelopeRuleMapper;
import com.jzhl.kfsq.dao.sm.IFeatureMapper;
import com.jzhl.kfsq.dao.sm.IPriceInfoMapper;
import com.jzhl.kfsq.dataset.bm.BuildingFeatureDataSet;
import com.jzhl.kfsq.dataset.bm.BuildingMsgDataSet;
import com.jzhl.kfsq.dataset.bm.UnitMapDataSet;
import com.jzhl.kfsq.dataset.cm.AgentCommentDataSet;
import com.jzhl.kfsq.entity.bm.Building;
import com.jzhl.kfsq.entity.bm.BuildingFeature;
import com.jzhl.kfsq.entity.bm.UnitMap;
import com.jzhl.kfsq.entity.cm.BuildingComment;
import com.jzhl.kfsq.entity.cm.CommentImg;
import com.jzhl.kfsq.entity.sm.Area;
import com.jzhl.kfsq.entity.sm.EnvelopeRule;
import com.jzhl.kfsq.entity.sm.Feature;
import com.jzhl.kfsq.entity.sm.PriceInfo;
import com.jzhl.kfsq.service.bm.IBuildingMsgService;

@Service
public class BuildingMsgServiceImpl implements IBuildingMsgService {
	@Autowired
	private IAreaMapper IAreaDao;
	@Autowired
	private IFeatureMapper IFeatureDao;
	@Autowired
	private IBuildingMapper IBuildingDao;
	@Autowired
	private IBuildingFeatureMapper IBuildingFeatureDao;
	@Autowired
	private IUnitMapMapper IUnitMapDao;
	@Autowired
	private IBuildingCommentMapper IBuildingCommentDao;
	@Autowired
	private ICommentImgMapper ICommentImgDao;
	@Autowired
	private IPriceInfoMapper IPriceInfoDao;
	@Autowired
	private IEnvelopeRuleMapper IEnvelopeRuleDao;

	@Override
	public List<Area> findArea(int branchId) {
		List<Area> list = IAreaDao.findAreaBybranchId(branchId);
		return list;
	}

	@Override
	public List<Feature> findFeature() {
		List<Feature> list = IFeatureDao.findFeature();
		return list;
	}

	@Override
	public int saveBuilding(Building building) {
		int buildingid = IBuildingDao.insert(building);
		return buildingid;
	}

	@Override
	public void saveBuildingFeature(BuildingFeature buildingfeature) {
		IBuildingFeatureDao.insert(buildingfeature);
	}

	@Override
	public int saveUnitMap(UnitMap unitmap) {
		int unitmapid = IUnitMapDao.insert(unitmap);
		return unitmapid;
	}

	@Override
	public int saveAgentComment(BuildingComment buildingcomment) {
		int buildingcommentid = IBuildingCommentDao.saveAgentComment(buildingcomment);
		return buildingcommentid;
	}

	@Override
	public void updateAgentComment(BuildingComment buildingcomment) {
		IBuildingCommentDao.updateAgentComment(buildingcomment);
	}

	@Override
	public void saveAgentCommentImg(CommentImg commentimg) {
		ICommentImgDao.insertAgentCommentImg(commentimg);
	}

	@Override
	public List<BuildingMsgDataSet> findMsgBuildingList(Map<String, Object> map) {
		List<BuildingMsgDataSet> list = IBuildingDao.findMsgBuildingList(map);
		return list;
	}

	@Override
	public int findMsgBuildingListCount(Map<String, Object> map) {
		int con = IBuildingDao.findMsgBuildingListCount(map);
		return con;
	}

	@Override
	public List<PriceInfo> findPriceList() {
		List<PriceInfo> list = IPriceInfoDao.findPriceInfo();
		return list;
	}

	@Override
	public List<UnitMapDataSet> findUnitMapList(Map<String, Object> map) {
		List<UnitMapDataSet> list = IUnitMapDao.findUnitMapList(map);
		return list;
	}

	@Override
	public int unitMapListCount(Map<String, Object> map) {
		int num = IUnitMapDao.unitMapListCount(map);
		return num;
	}

	@Override
	public List<AgentCommentDataSet> findAgentCommentList(Map<String, Object> map) {
		List<AgentCommentDataSet> list = IBuildingCommentDao.findAgentCommentList(map);
		return list;
	}

	@Override
	public int findAgentCommentCount(Map<String, Object> map) {
		int count = IBuildingCommentDao.findAgentCommentCount(map);
		return count;
	}

	@Override
	public AgentCommentDataSet getAgentComment(BuildingComment buildingcomment) {
		AgentCommentDataSet data = IBuildingCommentDao.getAgentComment(buildingcomment);
		return data;
	}

	@Override
	public UnitMapDataSet getUnitMap(UnitMap unitMap) {
		return IUnitMapDao.getUnitMap(unitMap);
	}

	@Override
	public void updateMap(UnitMap unitmap) {
		IUnitMapDao.updateMap(unitmap);
	}

	@Override
	public BuildingMsgDataSet getBuildingMsg(Building building) {
		return IBuildingDao.getBuildingMsg(building);
	}

	@Override
	public void updateBuildingMsg(Building building) {
		IBuildingDao.updateBuildingMsg(building);
	}

	@Override
	public List<BuildingFeatureDataSet> getBuildingFeature(BuildingFeature buildingfeature) {
		return IBuildingFeatureDao.getBuildingFeature(buildingfeature);
	}

	@Override
	public void deleteBuildingFeature(BuildingFeature buildingfeature) {
		IBuildingFeatureDao.delete(buildingfeature);
	}

	@Override
	public void updateEnvelopeRule(EnvelopeRule envelopeRule) {
		if (envelopeRule.getRuleId() == null) {// 添加
			IEnvelopeRuleDao.insertEnvelopeRule(envelopeRule);
		} else {// 修改
			IEnvelopeRuleDao.updateEnvelopeRule(envelopeRule);
		}
	}

	// 根据评论ID删除评论图片路径
	@Override
	public void deleteImg(Integer commentId) {
		ICommentImgDao.deleteImg(commentId);
	}

}
