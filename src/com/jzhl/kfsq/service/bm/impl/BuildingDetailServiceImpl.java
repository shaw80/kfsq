package com.jzhl.kfsq.service.bm.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jzhl.kfsq.common.util.Constant;
import com.jzhl.kfsq.dao.ba.IBuildingScoreMapper;
import com.jzhl.kfsq.dao.bm.IAroundMapper;
import com.jzhl.kfsq.dao.bm.IBuildingDetailMapper;
import com.jzhl.kfsq.dao.bm.IBuildingMapper;
import com.jzhl.kfsq.dao.bm.IBuildingTagMapper;
import com.jzhl.kfsq.dao.bm.IEducationMapper;
import com.jzhl.kfsq.dao.bm.ITrafficScoreDetailMapper;
import com.jzhl.kfsq.dao.bm.IUnitMapMapper;
import com.jzhl.kfsq.dao.cm.IBuildingCommentMapper;
import com.jzhl.kfsq.dao.cm.ICommentImgMapper;
import com.jzhl.kfsq.dao.fm.IEnvelopeRechargeMapper;
import com.jzhl.kfsq.dao.fm.IEnvelopeSwitchMapper;
import com.jzhl.kfsq.dao.pm.IPlanMapper;
import com.jzhl.kfsq.dao.sm.IEnvelopeRuleMapper;
import com.jzhl.kfsq.dataset.bm.AroundDataSet;
import com.jzhl.kfsq.dataset.bm.AroundV2DataSet;
import com.jzhl.kfsq.dataset.bm.BuildingDetail;
import com.jzhl.kfsq.dataset.bm.BuildingInfoDataSet;
import com.jzhl.kfsq.dataset.bm.BuildingTagDataSet;
import com.jzhl.kfsq.dataset.bm.CommunityQualityV3DataSet;
import com.jzhl.kfsq.dataset.bm.EducationDataSet;
import com.jzhl.kfsq.dataset.bm.RecommendBuildingsV3DataSet;
import com.jzhl.kfsq.dataset.bm.TrafficV3DataSet;
import com.jzhl.kfsq.dataset.bm.UnitMapV3DataSet;
import com.jzhl.kfsq.dataset.cm.BuildingCommentV3DataSet;
import com.jzhl.kfsq.dataset.cm.MyCommentImg;
import com.jzhl.kfsq.dto.pm.IsVisitDto;
import com.jzhl.kfsq.dto.pm.PlanDto;
import com.jzhl.kfsq.entity.ba.BuildingScore;
import com.jzhl.kfsq.entity.bm.Building;
import com.jzhl.kfsq.entity.fm.EnvelopeSwitch;
import com.jzhl.kfsq.entity.pm.Plan;
import com.jzhl.kfsq.entity.sm.EnvelopeRule;
import com.jzhl.kfsq.service.bm.IBuildingDetailService;

/**
 * 楼盘详情业务层实现类
 * 
 * @author Shaw
 *
 */
@Service
public class BuildingDetailServiceImpl implements IBuildingDetailService {
	
	Logger log = Logger.getLogger(BuildingDetailServiceImpl.class);

	@Autowired
	IBuildingDetailMapper buildingDetailDao;
	@Autowired
	IBuildingTagMapper buildingTagDao;
	@Autowired
	IBuildingScoreMapper buildingScoreDao;
	@Autowired
	IUnitMapMapper unitMapMapperDao;
	@Autowired
	IBuildingMapper buildingDao;
	@Autowired
	ITrafficScoreDetailMapper trafficScoreDetailDao;
	@Autowired
	IEducationMapper educationDao;
	@Autowired
	IAroundMapper aroundDao;
	@Autowired
	IBuildingCommentMapper buildingCommentDao;
	@Autowired
	ICommentImgMapper commentImgDao;
	@Autowired
	IEnvelopeSwitchMapper envelopeSwitchDao;
	@Autowired
	IEnvelopeRuleMapper envelopeRuleDao;
	@Autowired
	IEnvelopeRechargeMapper envelopeRechargeDao;
	@Autowired
	IPlanMapper planDao;

	/**
	 * 根据楼盘编号查询楼盘详情
	 * 
	 * @param buildingId
	 * @return
	 */
	@Override
	public BuildingDetail getBuildingDetail(IsVisitDto dto) {
		
		BuildingDetail result = buildingDetailDao.getBuildingDetail(dto
				.getBuildingId());// 根据楼盘编号查询一系列单行的数据
		
		Map<String, Object> highOpinions_param = new HashMap<String, Object>();// 定义好评集合查询参数
		highOpinions_param.put("buildingId", dto.getBuildingId());
		highOpinions_param.put("isShow", Constant.ONE);
		List<BuildingTagDataSet> highOpinions = buildingTagDao
				.findBuildingTagDataSet(highOpinions_param);// 查询好评集合
		
		if (highOpinions != null && highOpinions.size() > 0 && result != null) {
			result.setHighOpinions(highOpinions);
		}
		Map<String, Object> negativeComments_param = new HashMap<String, Object>();// 定义差评集合查询参数
		negativeComments_param.put("buildingId", dto.getBuildingId());
		negativeComments_param.put("isShow", Constant.TWO);
		List<BuildingTagDataSet> negativeComments = buildingTagDao
				.findBuildingTagDataSet(negativeComments_param);// 查询差评集合
		if (negativeComments != null && negativeComments.size() > 0
				&& result != null) {
			result.setNegativeComments(negativeComments);
		}
		
		BuildingScore buildingScore = buildingScoreDao
				.getBuildingScoreByBuildingId(dto.getBuildingId());// 根据楼盘编号查询楼盘评分

		List<String> unitMapNames = unitMapMapperDao.findUnitMapDes(dto
				.getBuildingId());// 根据楼盘编号查询户型名称集合
		
		UnitMapV3DataSet unitMap = new UnitMapV3DataSet();// 户型结果集
		unitMap.setDimensionName("户型");
		if (buildingScore != null) {
			unitMap.setScore(buildingScore.getUnitMapScore());
		} else {
			unitMap.setScore("0.0");
		}
		String unitMapNames_str = "";
		for (String string : unitMapNames) {
			unitMapNames_str += string + " ";
		}
		if(unitMapNames_str != null && unitMapNames_str != ""){
			unitMap.setUnitMapName(unitMapNames_str.substring(0,
					unitMapNames_str.length() - 1));
		}
		if (result != null) {
			result.setUnitMap(unitMap);
		}
		Building building = buildingDao.getBuildingByBuildingId(dto
				.getBuildingId());// 根据楼盘编号查询楼盘
		CommunityQualityV3DataSet communityQuality = new CommunityQualityV3DataSet();// 实例化社区品质结果集
		communityQuality.setDimensionName("社区品质");
		if (buildingScore != null) {
			communityQuality.setScore(buildingScore.getCommunityScore());
		} else {
			communityQuality.setScore("0.0");
		}
		communityQuality.setCommunityQuality("开发商：" + building.getDeveloper()
				+ " " + "物业：" + building.getProperty());
		if (result != null) {
			result.setCommunityQuality(communityQuality);
		}
		TrafficV3DataSet traffic = new TrafficV3DataSet();// 实例化交通结果集
		traffic.setDimensionName("交通");
		if (buildingScore != null) {
			traffic.setScore(buildingScore.getTrafficScore());
		} else {
			traffic.setScore("0.0");
		}
		Map<String, Object> bus_param = new HashMap<String, Object>();// 定义查询统计公交数量参数
		bus_param.put("buildingId", dto.getBuildingId());
		bus_param.put("type", Constant.ZERO);
		int countBus = trafficScoreDetailDao
				.countTrafficByBuildingIdAndType(bus_param);// 根据楼盘编号和类型统计公交数量
		Map<String, Object> metro_param = new HashMap<String, Object>();// 定义查询统计地铁数量参数
		metro_param.put("buildingId", dto.getBuildingId());
		metro_param.put("type", Constant.ONE);
		int countMetro = trafficScoreDetailDao
				.countTrafficByBuildingIdAndType(metro_param);// 根据楼盘编号和类型统计地铁数量
		Map<String, Object> trolley_param = new HashMap<String, Object>();// 定义查询统计有轨电车数量参数
		trolley_param.put("buildingId", dto.getBuildingId());
		trolley_param.put("type", Constant.TWO);
		int countTrolley = trafficScoreDetailDao
				.countTrafficByBuildingIdAndType(trolley_param);// 根据楼盘编号和类型统计有轨电车数量
		if (countBus == 0 && countMetro == 0 && countTrolley == 0) {
			traffic.setTraffic("");
		} else {
			traffic.setTraffic("公交（" + countBus + "）" + " " + "地铁（"
					+ countMetro + "）" + " " + "有轨电车（" + countTrolley + "）");
		}
		if (result != null) {
			result.setTraffic(traffic);
		}
		
		int countGreatPrimarySchool = educationDao.countGreatPrimarySchool(dto
				.getBuildingId());// 统计优质小学数量
		int countOrdinaryPrimarySchool = educationDao
				.countOrdinaryPrimarySchool(dto.getBuildingId());// 统计普通小学数量
		
		Map<String, Object> kindergarten_param = new HashMap<String, Object>();
		kindergarten_param.put("buildingId", dto.getBuildingId());
		kindergarten_param.put("type", Constant.ZERO);
		int countKindergarten = educationDao.countSchool(kindergarten_param);// 统计幼儿园数量
		Map<String, Object> middleSchool_param = new HashMap<String, Object>();
		middleSchool_param.put("buildingId", dto.getBuildingId());
		middleSchool_param.put("type", Constant.TWO);
		int countMiddleSchool = educationDao.countSchool(middleSchool_param);// 统计中学数量
		Map<String, Object> university_param = new HashMap<String, Object>();
		university_param.put("buildingId", dto.getBuildingId());
		university_param.put("type", Constant.THREE);
		int countUniversity = educationDao.countSchool(university_param);// 统计大学数量
		EducationDataSet education = new EducationDataSet();// 实例化教育结果集
		
		education.setDimensionName("教育");
		if (buildingScore != null) {
			education.setScore(buildingScore.getEducationScore());
		} else {
			education.setScore("0.0");
		}
		if (countGreatPrimarySchool == 0 && countKindergarten == 0
				&& countOrdinaryPrimarySchool == 0 && countMiddleSchool == 0
				&& countUniversity == 0) {
			education.setEducation("");
		} else {
			education.setEducation("优质小学（" + countGreatPrimarySchool + "）"
					+ " " + "幼儿园（" + countKindergarten + "）" + " " + "普通小学（"
					+ countOrdinaryPrimarySchool + "）" + " " + "中学（"
					+ countMiddleSchool + "）" + " " + "大学（" + countUniversity
					+ "）");
		}
		if (result != null) {
			result.setEducation(education);
		}
		AroundDataSet around_str = aroundDao.getAroundDataSet(dto
				.getBuildingId());// 根据楼盘编号查询周边设施
		AroundV2DataSet around = new AroundV2DataSet();
		around.setDimensionName("周边设施");
		if (buildingScore != null) {
			around.setScore(buildingScore.getPeripheryScore());
		} else {
			around.setScore("0.0");
		}
		if (around_str.getCountHealthCare().equals("0")
				&& around_str.getCountBank().equals("0")
				&& around_str.getCountEntertainment().equals("0")
				&& around_str.getCountBusiness().equals("0")
				&& around_str.getCountSurroundingEnvironment().equals("0")
				&& around_str.getCountUnfavorableFactors().equals("0")) {
			around.setAround("");
		}else{
			around.setAround("医疗（" + around_str.getCountHealthCare() + "）" + " "
					+ "银行（" + around_str.getCountBank() + "）" + " " + "娱乐（"
					+ around_str.getCountEntertainment() + "）" + " " + "商业（"
					+ around_str.getCountBusiness() + "）" + " " + "周边环境（"
					+ around_str.getCountSurroundingEnvironment() + "）" + " "
					+ "不利因素（" + around_str.getCountUnfavorableFactors() + "）");
		}
		if (result != null) {
			result.setAround(around);
		}
		
		BuildingCommentV3DataSet comment = buildingCommentDao
				.getBuildingCommentV3DataSet(dto.getBuildingId());// 根据楼盘编号查询最近一条评论
		if (comment != null) {
			Integer score = buildingCommentDao.getCommentScore(comment
					.getCommentId());// 根据评论编号计算评论分数
			comment.setScore(String.valueOf(score));
			List<MyCommentImg> imgs = commentImgDao
					.findMyCommentImgByCommentId(comment.getCommentId());// 根据评论编号查询评论图片
			comment.setImgs(imgs);
			result.setComment(comment);
		}
		
		
		List<RecommendBuildingsV3DataSet> areas = buildingDao
				.findRecommendBuildingsV3DataSetByArea(dto.getBuildingId());// 根据楼盘编号查询同地段的4个楼盘
		if (areas != null && areas.size() > 0) {
			for (RecommendBuildingsV3DataSet data : areas) {
				boolean hasEnvelope_area = hasEnvelope(data.getBuildingId());
				data.setHasEnvelope(hasEnvelope_area);
			}
		}
		if (result != null) {
			result.setAreas(areas);
		}
		
		List<RecommendBuildingsV3DataSet> prices = buildingDao
				.findRecommendBuildingsV3DataSetByPrice(dto.getBuildingId());// 根据楼盘编号查询同价位的4个楼盘
		if (prices != null && prices.size() > 0) {
			for (RecommendBuildingsV3DataSet data : prices) {
				boolean hasEnvelope_price = hasEnvelope(data.getBuildingId());
				data.setHasEnvelope(hasEnvelope_price);
			}
		}
		if (result != null) {
			result.setPrices(prices);
		}
		List<RecommendBuildingsV3DataSet> tags = buildingDao
				.findRecommendBuildingsV3DataSetByTag(dto.getBuildingId());// 根据楼盘编号查询同特色的4个楼盘
		if (tags != null && tags.size() > 0) {
			for (RecommendBuildingsV3DataSet data : tags) {
				boolean hasEnvelope_tag = hasEnvelope(data.getBuildingId());
				data.setHasEnvelope(hasEnvelope_tag);
			}
		}
		if (result != null) {
			result.setTags(tags);
		}
		if (dto.getMemberId() != null) {
			boolean hasJoinPlan = hasJoinPlan(dto);// 判断是否加入计划
			boolean hasLook = hasLook(dto);// 判断是否已看房
			if (result != null) {
				result.setHasJoinPlan(hasJoinPlan);
				result.setHasLook(hasLook);
			}
		}
		if (result != null) {
			boolean hasEnvelope = hasEnvelope(dto.getBuildingId());
			result.setHasEnvelope(hasEnvelope);
		}
		
		return result;
	}

	/**
	 * 根据楼盘编号查询楼盘信息
	 * 
	 * @param buildingId
	 * @return
	 */
	@Override
	public BuildingInfoDataSet getBuildingInfoDataSet(int buildingId) {
		BuildingInfoDataSet result = buildingDetailDao
				.getBuildingInfoDataSet(buildingId);
		if (result != null) {
			if (result.getPeriodOfPropertyRights() != null && !result.getPeriodOfPropertyRights().equals("")) {
				result.setPeriodOfPropertyRights(result
						.getPeriodOfPropertyRights() + "年");
			}else{
				result.setPeriodOfPropertyRights(null);
			}
			if (result.getVolumeRatio() != null && !result.getVolumeRatio().equals("0")) {
				result.setVolumeRatio(result.getVolumeRatio() + "%");
			}else{
				result.setVolumeRatio(null);
			}
			if (result.getGreenRates() != null && !result.getGreenRates().equals("0")) {
				result.setGreenRates(result.getGreenRates() + "%");
			}else{
				result.setGreenRates(null);
			}
			if(result.getPropertyFee().equals("0.00")){
				result.setPropertyFee(null);
			}
		}
		return result;
	}

	/**
	 * 判断楼盘是否有看房红包
	 * 
	 * @param buildingId
	 * @return
	 */
	private boolean hasEnvelope(int buildingId) {
		boolean result = false;
		Map<String, Object> param_es = new HashMap<String, Object>();
		param_es.put("buildingId", buildingId);
		param_es.put("switchType", Constant.ONE);
		EnvelopeSwitch es = envelopeSwitchDao
				.getSwitchByBuildingIdAndSwitchType(param_es);// 根据楼盘编号和红包类型查询总开关
		EnvelopeRule er = envelopeRuleDao.getRuleByBuildingId(buildingId);// 根据楼盘编号查询楼盘红包开关--有无红包规则
		Integer balance = envelopeRechargeDao.getBalance(buildingId);
		if (es.getSwitchStatus().equals(1)) {
			if (er != null) {
				if (balance != null) {
					if (balance > 0) {
						result = true;
					}
				}
			}
		}
		return result;
	}

	/**
	 * 判断是否已加入计划
	 * 
	 * @param dto
	 * @return
	 */
	private boolean hasJoinPlan(IsVisitDto dto) {
		boolean hasJoinPlan = false;
		PlanDto param = new PlanDto();
		param.setBuildingId(dto.getBuildingId());
		param.setCreatorUserId(dto.getMemberId());
		Plan plan = planDao.getPlanIsLook(param);
		if (plan != null) {
			hasJoinPlan = true;
		}
		return hasJoinPlan;
	}

	/**
	 * 判断是否已看房
	 * 
	 * @param dto
	 * @return
	 */
	private boolean hasLook(IsVisitDto dto) {
		boolean hasLook = false;
		PlanDto param = new PlanDto();
		param.setBuildingId(dto.getBuildingId());
		param.setCreatorUserId(dto.getMemberId());
		Plan plan = planDao.getPlanIsLook(param);
		if (plan != null) {
			if (plan.getStatus().equals(1) || plan.getStatus().equals(2)) {
				hasLook = true;
			}
		}
		return hasLook;
	}

}
