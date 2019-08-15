package com.jzhl.kfsq.service.bm;

import java.util.List;
import java.util.Map;

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

public interface IBuildingMsgService {
	//查询区域
	public List<Area> findArea(int branchId);
	//查询特色
	public List<Feature> findFeature();
	//保存楼盘
	public int saveBuilding(Building building);
	//查询楼盘详情
	public BuildingMsgDataSet getBuildingMsg(Building building);
	//查询特色详情
	public List<BuildingFeatureDataSet> getBuildingFeature(BuildingFeature buildingfeature);
	//修改楼盘详情
	public void updateBuildingMsg(Building building);
	//保存特色
	public void saveBuildingFeature(BuildingFeature buildingfeature);
	//保存楼盘户型图
	public int  saveUnitMap(UnitMap unitmap);
	//修改户型图
	public void updateMap(UnitMap unitmap);
	//代理商添加评论
	public int saveAgentComment(BuildingComment buildingcomment);
	//修改代理商评论
	public void updateAgentComment(BuildingComment buildingcomment);
	//代理商保存评论图片
	public void saveAgentCommentImg(CommentImg commentimg);
	//代理商保存评论图片查询楼盘信息
	public List<BuildingMsgDataSet> findMsgBuildingList(Map<String, Object> map);
	
	 // 查询楼盘信息总数分页用

    public int findMsgBuildingListCount(Map<String, Object> map);
    
    //查询价格区间
    public List<PriceInfo> findPriceList();
    //获取户型图根据id
    public UnitMapDataSet getUnitMap(UnitMap unitMap);
    //查询楼盘户型
    public List<UnitMapDataSet> findUnitMapList(Map<String, Object> map);
    //查询楼盘户型总条数
    public int unitMapListCount(Map<String, Object> map);
    //查询评论
    public List<AgentCommentDataSet> findAgentCommentList(Map<String, Object> map);
    //查询评论列表总条数
    public int findAgentCommentCount(Map<String, Object> map);
    //修改评论
    public AgentCommentDataSet getAgentComment(BuildingComment buildingcomment);
    //删除楼盘特色
    public void deleteBuildingFeature(BuildingFeature buildingfeature);
    //更新看房红包规则
    public void updateEnvelopeRule(EnvelopeRule envelopeRule);
    
    // 删除原有关联评论图片路径 addby zhouzy 20160222
	public void deleteImg(Integer integer);
}
