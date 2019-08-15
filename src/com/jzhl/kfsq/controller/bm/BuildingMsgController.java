package com.jzhl.kfsq.controller.bm;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jzhl.kfsq.common.base.ListResult;
import com.jzhl.kfsq.common.base.ResponseBean;
import com.jzhl.kfsq.dataset.bm.BuildingFeatureDataSet;
import com.jzhl.kfsq.dataset.bm.BuildingMsgDataSet;
import com.jzhl.kfsq.dataset.bm.UnitMapDataSet;
import com.jzhl.kfsq.dataset.cm.AgentCommentDataSet;
import com.jzhl.kfsq.dto.bm.BuildingMsgDto;
import com.jzhl.kfsq.dto.bm.UnitMapDto;
import com.jzhl.kfsq.dto.cm.AgentCommentDto;
import com.jzhl.kfsq.dto.sm.EnvelopeRuleDto;
import com.jzhl.kfsq.entity.bm.Building;
import com.jzhl.kfsq.entity.bm.BuildingExtendContent;
import com.jzhl.kfsq.entity.bm.BuildingFeature;
import com.jzhl.kfsq.entity.bm.BuildingTag;
import com.jzhl.kfsq.entity.bm.CommunityQuality;
import com.jzhl.kfsq.entity.bm.UnitMap;
import com.jzhl.kfsq.entity.cm.BuildingComment;
import com.jzhl.kfsq.entity.cm.CommentImg;
import com.jzhl.kfsq.entity.sm.Area;
import com.jzhl.kfsq.entity.sm.EnvelopeRule;
import com.jzhl.kfsq.entity.sm.Feature;
import com.jzhl.kfsq.entity.sm.PriceInfo;
import com.jzhl.kfsq.entity.sm.UnitMapFeature;
import com.jzhl.kfsq.service.bm.IBuildingExtendContentService;
import com.jzhl.kfsq.service.bm.IBuildingMsgService;
import com.jzhl.kfsq.service.bm.IBuildingTagService;
import com.jzhl.kfsq.service.bm.ICommunityQualityService;
import com.jzhl.kfsq.service.bm.IUnitMapFeatureService;
import com.jzhl.kfsq.service.fm.IEnvelopeRechargeService;

@Controller
public class BuildingMsgController {
	protected static final Logger logger = Logger.getLogger(BuildingController.class);
	@Autowired
	private IBuildingMsgService buildingMsgService;
	@Autowired
	private IEnvelopeRechargeService envelopeRechargeService;
	@Autowired
	private IBuildingTagService buildingTagService;
	@Autowired
	private IUnitMapFeatureService unitMapFeatureService;
	@Autowired
	private ICommunityQualityService communityQualityService;
	@Autowired
	private IBuildingExtendContentService buildingExtendContentService;

	/**
	 * 分页查询楼盘列表
	 * 
	 * @author chih
	 * @param
	 * @return ResponseBean
	 */
	@SuppressWarnings({ "rawtypes" })
	@RequestMapping(value = "/serv/building/findbuildingmsglist", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean findBuildingList(BuildingMsgDto dto) {
		// 分页查询参数
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("rowStart", dto.getRowStart());
		map.put("offset", dto.getOffset());
		// 条件查询参数；
		map.put("agentId", dto.getAgentId());
		// 红包状态
		if (dto.getPriceisValid() != null) {
			map.put("priceisValid", dto.getPriceisValid());
		}
		// 区域
		if (dto.getCounty() != null) {
			map.put("county", dto.getCounty());
		}
		// 特色
		if (dto.getFeatureId() != null && !dto.getFeatureId().equals("")) {
			map.put("featureId", dto.getFeatureId());
		}
		// 楼盘状态
		if (dto.getIsValid() != null) {
			map.put("isValid", dto.getIsValid());
		}
		// 最大价格
		if (dto.getMaxPrice() != null) {
			map.put("maxPrice", dto.getMaxPrice());
		}
		// 最小价格
		if (dto.getMinPrice() != null) {
			map.put("minPrice", dto.getMinPrice());
		}
		// 名称模糊
		if (dto.getBuildingName() != null) {
			map.put("buildingName", dto.getBuildingName());
		}

		// rechargeFlag; // 充值状态标志位；null全部，0已充值，1未充值 addby zhouzy 20160322
		if (dto.getRechargeFlag() != null) {
			map.put("rechargeFlag", dto.getRechargeFlag());
		}

		// V1.1 addby zhouzy 20160616 ------begin
		// 二级区域
		if (dto.getSecondAreaId() != null) {
			map.put("secondAreaId", dto.getSecondAreaId());
		}

		// 装修情况（0：毛坯，1：精装）
		if (dto.getDecorationSituation() != null) {
			map.put("decorationSituation", dto.getDecorationSituation());
		}

		// 绿化率
		if (dto.getGreenRates() != null) {
			map.put("greenRates", dto.getGreenRates());
		}

		// 绿化率图
		if (dto.getGreenImg() != null) {
			map.put("greenImg", dto.getGreenImg());
		}

		// 车位比
		if (dto.getRatioOfSpaces() != null) {
			map.put("ratioOfSpaces", dto.getRatioOfSpaces());
		}

		// 车位图
		if (dto.getSpaceOfCarImg() != null) {
			map.put("spaceOfCarImg", dto.getSpaceOfCarImg());
		}

		// 园区配套图
		if (dto.getParkFacilitiesImg() != null) {
			map.put("parkFacilitiesImg", dto.getParkFacilitiesImg());
		}

		// 是否人车分流（0：不分流，1：分流）
		if (dto.getIsSeparation() != null) {
			map.put("IsSeparation", dto.getIsSeparation());
		}

		// 前端可见标签数量
		if (dto.getTagIsShowNum() != null) {
			map.put("tagIsShowNum", dto.getTagIsShowNum());
		}
		// V1.1 addby zhouzy 20160616 ------end

		List<BuildingMsgDataSet> list = buildingMsgService.findMsgBuildingList(map);
		// 分页返回
		ListResult listResult = new ListResult();
		listResult.setDataList(list);
		// 总页数
		int dataCount = buildingMsgService.findMsgBuildingListCount(map);
		listResult.setDataCount(dataCount);

		ResponseBean<ListResult> result = new ResponseBean<ListResult>(listResult);
		result.operateSuccess();
		return result;

	}

	/**
	 * 查询区域
	 * 
	 * @param 无
	 * @return
	 */
	@SuppressWarnings({ "rawtypes" })
	@RequestMapping(value = "/serv/buildingmsgarea/findarealist", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean findarealist(BuildingMsgDto dto) {

		List<Area> list = buildingMsgService.findArea(dto.getBranchId());
		// 返回
		// ListResult listResult = new ListResult();
		// listResult.setDataList(list);
		Map<String, Object> queryResult = new HashMap<String, Object>();
		// 返回数据添加
		queryResult.put("datalist", list);
		ResponseBean<Map<String, Object>> result = new ResponseBean<Map<String, Object>>(queryResult);
		result.operateSuccess();
		return result;
	}

	/**
	 * 查询价格区间
	 * 
	 * @param 无
	 * @return
	 */
	@SuppressWarnings({ "rawtypes" })
	@RequestMapping(value = "/serv/buildingmsgarea/findprice", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean findPriceList() {

		List<PriceInfo> list = buildingMsgService.findPriceList();
		// 返回
		// ListResult listResult = new ListResult();
		// listResult.setDataList(list);
		Map<String, Object> queryResult = new HashMap<String, Object>();
		// 返回数据添加
		queryResult.put("datalist", list);
		ResponseBean<Map<String, Object>> result = new ResponseBean<Map<String, Object>>(queryResult);
		result.operateSuccess();
		return result;
	}

	/**
	 * 查询特色
	 * 
	 * @param 无
	 * @return
	 */
	@SuppressWarnings({ "rawtypes" })
	@RequestMapping(value = "/serv/buildingmsgarea/findfeaturelist", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean findfeaturelist() {

		List<Feature> list = buildingMsgService.findFeature();
		// 返回
		// ListResult listResult = new ListResult();
		// listResult.setDataList(list);
		Map<String, Object> queryResult = new HashMap<String, Object>();
		// 返回数据添加
		queryResult.put("datalist", list);
		ResponseBean<Map<String, Object>> result = new ResponseBean<Map<String, Object>>(queryResult);
		result.operateSuccess();
		return result;
	}

	/**
	 * 代理添加楼盘
	 * 
	 * @param BuildingMsgDto
	 * @return buildingId，buildingName
	 */
	@SuppressWarnings({ "rawtypes" })
	@RequestMapping(value = "/serv/buildingmsgarea/savebuildingmsg", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean addBuildingMsg(BuildingMsgDto dto) {

		Building building = new Building();
		BeanUtils.copyProperties(dto, building);
		building.setIsValid((short) 1);
		if (dto.getBuildingId() != null) {// 修改
			// 保存楼盘信息
			buildingMsgService.updateBuildingMsg(building);

			// // 楼盘特色信息更新;
			// String[] FeatureId = dto.getFeatureId().split(",");
			// // 根据楼盘先删除楼盘特色
			// BuildingFeature buildingfeature1 = new BuildingFeature();
			// buildingfeature1.setBuildingId(building.getBuildingId());
			// buildingMsgService.deleteBuildingFeature(buildingfeature1);
			// // 保存楼盘特色
			// if (!dto.getFeatureId().equals("")) {
			// for (int i = 0; i < FeatureId.length; i++) {
			// BuildingFeature buildingfeature = new BuildingFeature();
			// buildingfeature.setBuildingId(building.getBuildingId());
			// buildingfeature.setFeatureId(Integer.parseInt(FeatureId[i]));
			// buildingfeature.setIsValid((short) 1);
			// buildingMsgService.saveBuildingFeature(buildingfeature);
			// }
			// }

			// addby zhouzy v1.1 保存标签信息 20160620
			// 删除原楼盘ID关联标签列表
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("buildingId", dto.getBuildingId());
			buildingTagService.deleteTag(param);

			// 插入新标签数据
			// tagList = "1,0;2,1;9,2"; //一个标签有两种属性
			// tagId=9,isShow=2;字符串，前面是tagId,后面isShow，中间用“，”分割； 每个标签用“；”分割
			if (dto.getTagList() != null && dto.getTagList().contains(";")) {
				String[] tagList = dto.getTagList().split(";");
				for (int i = 0; i < tagList.length; i++) {
					String[] tag = tagList[i].split(",");
					// 向数据库中存入数据
					BuildingTag buildingTag = new BuildingTag();
					buildingTag.setBuildingId(dto.getBuildingId());
					buildingTag.setTagId(Integer.parseInt(tag[0]));
					buildingTag.setIsShow(Integer.parseInt(tag[1]));
					buildingTag.setUpdateUserId(dto.getUpdateUserId());
					buildingTag.setCreatorUserId(dto.getCreatorUserId());
					buildingTag.setIsValid(1);
					buildingTagService.saveBuildingTag(buildingTag);
				}
			}

			// 社区品质表中则按buildingId更新相关信息；
			CommunityQuality communityQuality = new CommunityQuality();
			communityQuality.setBuildingId(dto.getBuildingId());
			communityQuality.setGreenRates(dto.getGreenRates());
			communityQuality.setGreenImg(dto.getGreenImg());
			communityQuality.setRatioOfSpaces(dto.getRatioOfSpaces());
			communityQuality.setSpaceOfCarImg(dto.getSpaceOfCarImg());
			communityQuality.setSpaceOfCarImg(dto.getSpaceOfCarImg());
			communityQuality.setParkFacilitiesImg(dto.getParkFacilitiesImg());
			communityQuality.setIsSeparation(dto.getIsSeparation());
			communityQuality.setUpdateUserId(dto.getUpdateUserId());
			communityQualityService.updateCommunityQuality(communityQuality);

			// 楼盘扩展信息表更新
			BuildingExtendContent buildingExtendContent = new BuildingExtendContent();
			buildingExtendContent.setBuildingId(dto.getBuildingId());
			buildingExtendContent.setTraffic(dto.getTraffic());
			buildingExtendContent.setEducation(dto.getEducation());
			buildingExtendContent.setArround(dto.getArround());
			buildingExtendContent.setDiscount(dto.getDiscount());
			buildingExtendContent.setUpdateUserId(dto.getUpdateUserId());
			buildingExtendContentService.updateBuildingExtendContent(buildingExtendContent);
		} else {
			// 添加楼盘信息
			buildingMsgService.saveBuilding(building);

			// // 楼盘特色信息保存
			// String[] FeatureId = dto.getFeatureId().split(",");
			// // 保存楼盘特色
			// if (!dto.getFeatureId().equals("")) {
			// for (int i = 0; i < FeatureId.length; i++) {
			// BuildingFeature buildingfeature = new BuildingFeature();
			// buildingfeature.setBuildingId(building.getBuildingId());
			// buildingfeature.setFeatureId(Integer.parseInt(FeatureId[i]));
			// buildingfeature.setIsValid((short) 1);
			// buildingMsgService.saveBuildingFeature(buildingfeature);
			// }
			// }

			// addby zhouzy v1.1 保存标签信息 20160620
			// 插入新标签数据
			if (dto.getTagList() != null && dto.getTagList().contains(";")) {
				String[] tagList = dto.getTagList().split(";");
				for (int i = 0; i < tagList.length; i++) {
					String[] tag = tagList[i].split(",");
					// 向数据库中存入数据
					BuildingTag buildingTag = new BuildingTag();
					buildingTag.setBuildingId(building.getBuildingId());
					buildingTag.setTagId(Integer.parseInt(tag[0]));
					buildingTag.setIsShow(Integer.parseInt(tag[1]));
					buildingTag.setUpdateUserId(dto.getUpdateUserId());
					buildingTag.setCreatorUserId(dto.getCreatorUserId());
					buildingTag.setIsValid(1);
					buildingTagService.saveBuildingTag(buildingTag);
				}
			}

			// 社区品质表中则按buildingId插入相关信息；
			CommunityQuality communityQuality = new CommunityQuality();
			communityQuality.setBuildingId(building.getBuildingId());
			communityQuality.setGreenRates(dto.getGreenRates());
			communityQuality.setGreenImg(dto.getGreenImg());
			communityQuality.setRatioOfSpaces(dto.getRatioOfSpaces());
			communityQuality.setSpaceOfCarImg(dto.getSpaceOfCarImg());
			communityQuality.setSpaceOfCarImg(dto.getSpaceOfCarImg());
			communityQuality.setParkFacilitiesImg(dto.getParkFacilitiesImg());
			communityQuality.setIsSeparation(dto.getIsSeparation());
			communityQuality.setCreateUserId(dto.getCreatorUserId());
			communityQuality.setIsValid(1);
			communityQualityService.insertCommunityQuality(communityQuality);

			// 楼盘扩展信息表插入
			BuildingExtendContent buildingExtendContent = new BuildingExtendContent();
			buildingExtendContent.setBuildingId(building.getBuildingId());
			buildingExtendContent.setTraffic(dto.getTraffic());
			buildingExtendContent.setEducation(dto.getEducation());
			buildingExtendContent.setArround(dto.getArround());
			buildingExtendContent.setDiscount(dto.getDiscount());
			buildingExtendContent.setCreatorUserId(dto.getCreatorUserId());
			buildingExtendContentService.insertBuildingExtendContent(buildingExtendContent);
		}

		// 返回
		Map<String, Object> queryResult = new HashMap<String, Object>();
		// 返回数据添加
		queryResult.put("buildingid", building.getBuildingId());
		ResponseBean<Map<String, Object>> result = new ResponseBean<Map<String, Object>>(queryResult);
		result.operateSuccess();
		return result;
	}

	/**
	 * 根据楼盘id获取楼盘详情
	 * 
	 * @param BuildingMsgDto
	 * @return buildingId，buildingName
	 * @throws IOException
	 */

	@RequestMapping(value = "/serv/building/getBuildingMsg", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean<BuildingMsgDataSet> getBuildingMsg(BuildingMsgDto dto) throws IOException {

		Building building = new Building();
		BeanUtils.copyProperties(dto, building);

		BuildingMsgDataSet commentdata = buildingMsgService.getBuildingMsg(building);
		ResponseBean<BuildingMsgDataSet> result = new ResponseBean<BuildingMsgDataSet>(commentdata);
		result.operateSuccess();
		return result;
	}

	/**
	 * 根据楼盘id获取楼盘特色
	 * 
	 * @param
	 * @return
	 */

	@SuppressWarnings({ "rawtypes" })
	@RequestMapping(value = "/serv/building/getBuildingFeature", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean getBuildingFeature(BuildingMsgDto dto) {

		BuildingFeature buildingFeature = new BuildingFeature();
		buildingFeature.setBuildingId(dto.getBuildingId());
		List<BuildingFeatureDataSet> list = buildingMsgService.getBuildingFeature(buildingFeature);
		// 返回
		// ListResult listResult = new ListResult();
		// listResult.setDataList(list);
		Map<String, Object> queryResult = new HashMap<String, Object>();
		// 返回数据添加
		queryResult.put("datalist", list);
		ResponseBean<Map<String, Object>> result = new ResponseBean<Map<String, Object>>(queryResult);
		result.operateSuccess();
		return result;
	}

	/**
	 * 查询户型图列表
	 * 
	 * @param 无
	 * @return
	 * @throws IOException
	 */
	@SuppressWarnings({ "rawtypes" })
	@RequestMapping(value = "/serv/building/findUnitMapList", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean findUnitMapList(UnitMapDto dto) throws IOException {
		// 分页查询参数
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("rowStart", dto.getRowStart());
		map.put("offset", dto.getOffset());
		map.put("buildingId", dto.getBuildingId());
		map.put("imgName", dto.getImgName());
		map.put("isValid", 1);
		List<UnitMapDataSet> list = buildingMsgService.findUnitMapList(map);

		// 返回
		// 分页返回
		ListResult listResult = new ListResult();
		listResult.setDataList(list);
		// 总页数
		int dataCount = buildingMsgService.unitMapListCount(map);
		listResult.setDataCount(dataCount);

		ResponseBean<ListResult> result = new ResponseBean<ListResult>(listResult);
		result.operateSuccess();
		return result;
	}

	/**
	 * 根据评论id获取评论信息
	 * 
	 * @param BuildingMsgDto
	 * @return buildingId，buildingName
	 */

	@RequestMapping(value = "/serv/building/getUnitMap", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean<UnitMapDataSet> getUnitMap(UnitMapDto dto) {

		UnitMap unitmap = new UnitMap();
		unitmap.setUnitMapId(dto.getUnitMapId());

		UnitMapDataSet data = buildingMsgService.getUnitMap(unitmap);

		ResponseBean<UnitMapDataSet> result = new ResponseBean<UnitMapDataSet>(data);
		result.operateSuccess();
		return result;
	}

	/**
	 * 代理添加楼盘户型图
	 * 
	 * @param BuildingMsgDto
	 * @return buildingId，buildingName
	 */
	@SuppressWarnings({ "rawtypes" })
	@RequestMapping(value = "/serv/buildingmsgarea/saveUnitMap", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean addUnitMap(UnitMapDto dto) {

		UnitMap unitmap = new UnitMap();

		// 修改户型
		if (dto.getUnitMapId() != null) {

			// 户型表基本信息更新
			unitmap.setUnitMapId(dto.getUnitMapId());
			unitmap.setImgName(dto.getImgName()); // 名字
			unitmap.setNumOfRoom(dto.getNumOfRoom()); // 居室
			unitmap.setAcreage(dto.getAcreage()); // 面积
			unitmap.setUnitPrice(dto.getUnitPrice()); // 单价
			unitmap.setRoomRate(dto.getRoomRate()); // 得房率
			unitmap.setTurned(dto.getTurned()); // 朝向
			unitmap.setImgDes(dto.getImgDes()); // 描述
			unitmap.setPath(dto.getPath()); // 图片路径
			buildingMsgService.updateMap(unitmap);

			// 户型标签中间表更新
			// 用户标签列表
			// 按照户型编码先把原来的对应关系从表中删除
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("unitMapId", dto.getUnitMapId());
			unitMapFeatureService.deleteUnitMapFeature(map);

			if (dto.getUnitTagList() != null) {
				String[] unitTagList = dto.getUnitTagList().split(",");
				for (String tagId : unitTagList) {
					UnitMapFeature unitMapFeature = new UnitMapFeature();
					unitMapFeature.setUnitMapId(dto.getUnitMapId());
					unitMapFeature.setTagId(Integer.parseInt(tagId));
					unitMapFeature.setIsValid(1);
					unitMapFeature.setCreateUserId(dto.getCreatorUserId());
					unitMapFeature.setUpdateUserId(dto.getCreatorUserId());
					unitMapFeatureService.saveUnitMapFeature(unitMapFeature);
				}
			}

		} else {
			// 添加户型
			unitmap.setImgDes(dto.getImgDes());
			unitmap.setImgName(dto.getImgName());
			unitmap.setBuildingId(dto.getBuildingId());
			unitmap.setPath(dto.getPath());
			unitmap.setCreatorUserId(dto.getCreatorUserId());
			unitmap.setImgType(dto.getImgType());
			unitmap.setIsValid(1);
			unitmap.setNumOfRoom(dto.getNumOfRoom()); // 居室
			unitmap.setAcreage(dto.getAcreage()); // 面积
			unitmap.setUnitPrice(dto.getUnitPrice()); // 单价
			unitmap.setRoomRate(dto.getRoomRate()); // 得房率
			unitmap.setTurned(dto.getTurned()); // 朝向
			// 保存楼盘户型图
			buildingMsgService.saveUnitMap(unitmap);

			// 插入标签数据
			if (dto.getUnitTagList() != null) {
				String[] unitTagList = dto.getUnitTagList().split(",");
				for (String tagId : unitTagList) {
					UnitMapFeature unitMapFeature = new UnitMapFeature();
					unitMapFeature.setUnitMapId(dto.getUnitMapId());
					unitMapFeature.setTagId(Integer.parseInt(tagId));
					unitMapFeature.setIsValid(1);
					unitMapFeature.setCreateUserId(dto.getCreatorUserId());
					unitMapFeature.setUpdateUserId(dto.getCreatorUserId());
					unitMapFeatureService.saveUnitMapFeature(unitMapFeature);
				}
			}
		}

		Map<String, Object> queryResult = new HashMap<String, Object>();
		// 返回数据添加
		queryResult.put("unitMapId", unitmap.getUnitMapId());
		queryResult.put("buildingId", unitmap.getBuildingId());
		ResponseBean<Map<String, Object>> result = new ResponseBean<Map<String, Object>>(queryResult);
		result.operateSuccess();
		return result;
	}

	/**
	 * 代理添加楼盘评论
	 * 
	 * @param BuildingMsgDto
	 * @return buildingId，buildingName
	 */
	@SuppressWarnings({ "rawtypes" })
	@RequestMapping(value = "/serv/buildingmsgarea/saveAgentComment", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean addAgentComment(AgentCommentDto dto) {

		BuildingComment buildingcomment = new BuildingComment();

		BeanUtils.copyProperties(dto, buildingcomment);
		if (dto.getCommentId() != null) {// 修改接口
			buildingMsgService.updateAgentComment(buildingcomment);

			// changeby zhouzy 20160222 添加评论图片---begin
			if (dto.getImgurl() != null) {
				// 先把原来的图片路径都删除掉；然后重新插入路径
				buildingMsgService.deleteImg(buildingcomment.getCommentId());

				String[] commentPathList = dto.getImgurl().split(",");
				for (String path : commentPathList) {
					// 保存图片表
					CommentImg commentImg = new CommentImg();
					commentImg.setCommentId(buildingcomment.getCommentId());
					commentImg.setCommentType(0);// 0：看房圈评论
					commentImg.setPath(path);
					commentImg.setIsUse("1");
					buildingMsgService.saveAgentCommentImg(commentImg);
				}
			}
			// changeby zhouzy 20160222 添加评论图片---end
		} else {
			// 保存楼盘评论
			/* int commentId = */buildingMsgService.saveAgentComment(buildingcomment);

			// changeby zhouzy 20160222 添加评论图片---begin
			if (dto.getImgurl() != null) {

				String[] commentPathList = dto.getImgurl().split(",");
				for (String path : commentPathList) {
					// 保存图片表
					CommentImg commentImg = new CommentImg();
					commentImg.setCommentId(buildingcomment.getCommentId());
					commentImg.setCommentType(0);// 0：看房圈评论
					commentImg.setPath(path);
					commentImg.setIsUse("1");
					buildingMsgService.saveAgentCommentImg(commentImg);
				}
			}
			// changeby zhouzy 20160222 添加评论图片---end

		}

		Map<String, Object> queryResult = new HashMap<String, Object>();
		// 返回数据添加
		queryResult.put("commentId", buildingcomment.getCommentId());
		ResponseBean<Map<String, Object>> result = new ResponseBean<Map<String, Object>>(queryResult);
		result.operateSuccess();
		return result;
	}

	/**
	 * 查询评论列表
	 * 
	 * @param 无
	 * @return
	 * @throws IOException
	 */
	@SuppressWarnings({ "rawtypes" })
	@RequestMapping(value = "/serv/building/findAgentCommentList", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean findAgentCommentList(AgentCommentDto dto) throws IOException {
		// 分页查询参数
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("rowStart", dto.getRowStart());
		map.put("offset", dto.getOffset());
		map.put("buildingId", dto.getBuildingId());
		map.put("isValid", 1);
		map.put("creatorUserId", dto.getCreatorUserId());
		List<AgentCommentDataSet> list = buildingMsgService.findAgentCommentList(map);

		// 返回
		// 分页返回
		ListResult listResult = new ListResult();
		listResult.setDataList(list);
		// 总页数
		int dataCount = buildingMsgService.findAgentCommentCount(map);
		listResult.setDataCount(dataCount);

		ResponseBean<ListResult> result = new ResponseBean<ListResult>(listResult);
		result.operateSuccess();
		return result;
	}

	/**
	 * 根据评论id获取评论信息
	 * 
	 * @param
	 * @return
	 */

	@RequestMapping(value = "/serv/building/getAgentComment", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean<AgentCommentDataSet> getAgentComment(AgentCommentDto dto) {

		BuildingComment buildingcomment = new BuildingComment();

		BeanUtils.copyProperties(dto, buildingcomment);

		AgentCommentDataSet commentdata = buildingMsgService.getAgentComment(buildingcomment);

		ResponseBean<AgentCommentDataSet> result = new ResponseBean<AgentCommentDataSet>(commentdata);
		result.operateSuccess();
		return result;
	}

	/**
	 * 代理添加看房红包规则
	 * 
	 * @param EnvelopeRuleDto
	 * @return
	 */
	@SuppressWarnings({ "rawtypes" })
	@RequestMapping(value = "/serv/building/enveloperule", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean enveloperule(EnvelopeRuleDto dto) {
		EnvelopeRule envelopeRule = new EnvelopeRule();
		BeanUtils.copyProperties(dto, envelopeRule);
		buildingMsgService.updateEnvelopeRule(envelopeRule);
		ResponseBean result = new ResponseBean<Area>();
		result.operateSuccess();
		return result;
	}

}
