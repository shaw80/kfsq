package com.jzhl.kfsq.service.sm.impl;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jzhl.kfsq.dao.ba.IBuildingScoreMapper;
import com.jzhl.kfsq.dao.ba.IDimensionMapper;
import com.jzhl.kfsq.dao.ba.IMemberEvaluateMapper;
import com.jzhl.kfsq.dao.bm.IAroundMapper;
import com.jzhl.kfsq.dao.bm.IBuildingMapper;
import com.jzhl.kfsq.dao.bm.IBuildingTagMapper;
import com.jzhl.kfsq.dao.bm.ICommunityQualityMapper;
import com.jzhl.kfsq.dao.bm.IEducationMapper;
import com.jzhl.kfsq.dao.bm.ILineInfoMapper;
import com.jzhl.kfsq.dao.sm.IBranchMapper;
import com.jzhl.kfsq.dataset.ba.DimensionDataSet;
import com.jzhl.kfsq.dataset.ba.MemberScoreDataSet;
import com.jzhl.kfsq.dto.sm.ScoreParams;
import com.jzhl.kfsq.entity.ba.BuildingScore;
import com.jzhl.kfsq.entity.ba.Dimension;
import com.jzhl.kfsq.entity.ba.MemberEvaluate;
import com.jzhl.kfsq.entity.bm.Building;
import com.jzhl.kfsq.entity.sm.Branch;
import com.jzhl.kfsq.service.sm.IMarkingService;

/**
 * 评分业务层实现类
 * 
 * @author Shaw
 *
 */
@Service
public class MarkingServiceImpl implements IMarkingService {

	@Autowired
	private IBuildingMapper buildingDao;
	@Autowired
	private IBuildingTagMapper buildingTagDao;
	@Autowired
	private IDimensionMapper dimensionDao;
	@Autowired
	private IMemberEvaluateMapper memberEvaluateDao;
	@Autowired
	private IBranchMapper branchDao;
	@Autowired
	private IBuildingScoreMapper buildingScoreDao;
	@Autowired
	private ICommunityQualityMapper communityQualityDao;
	@Autowired
	private IAroundMapper aroundDao;
	@Autowired
	private ILineInfoMapper lineInfoDao;
	@Autowired
	private IEducationMapper educationDao;

	/**
	 * 计算评分
	 * 
	 * @param tagName
	 * @return
	 */
	public void sumScore() throws Exception {
		List<Branch> branchs = branchDao.findAll();// 查询全部分站
		for (Branch branch : branchs) {// 遍历分站
			int cityId = branch.getBranchCityId();
			int size = 0;
			List<Building> buildings = buildingDao
					.findBuildingByBranchId(branch.getBranchId());// 根据分站编号查询对应的楼盘
			if (buildings != null && buildings.size() > 0) {
				for (Building building : buildings) {
					ScoreParams param_unitMap = new ScoreParams();
					// 查询户型的权重，并赋值
					Map<String, Object> param_weight_unitMap = new HashMap<String, Object>();
					param_weight_unitMap.put("dimensionCode", "unitMap");
					param_weight_unitMap.put("cityId", cityId);
					Dimension dimen_unitMap = dimensionDao
							.getDimensionByDimensionCodeAndCityId(param_weight_unitMap);
					if (dimen_unitMap != null) {
						double firstWeight_unitMap = dimen_unitMap.getWeight();
						param_unitMap.setFirstWeight(firstWeight_unitMap);
						param_unitMap.setFirstScore(dimen_unitMap.getScore());
					}

					ScoreParams param_quality = new ScoreParams();
					// 查询社区品质的权重，并赋值
					Map<String, Object> param_weight_quality = new HashMap<String, Object>();
					param_weight_quality.put("dimensionCode",
							"communityQuality");
					param_weight_quality.put("cityId", cityId);
					Dimension dimen_quality = dimensionDao
							.getDimensionByDimensionCodeAndCityId(param_weight_quality);
					if (dimen_quality != null) {
						double firstWeight_quality = dimen_quality.getWeight();
						param_quality.setFirstWeight(firstWeight_quality);
						param_quality.setFirstScore(dimen_quality.getScore());
					}

					ScoreParams param_busDistance = new ScoreParams();
					ScoreParams param_busNum = new ScoreParams();
					ScoreParams param_trackDistance = new ScoreParams();
					ScoreParams param_trackNum = new ScoreParams();
					// 查询交通的权重，并赋值
					Map<String, Object> param_weight_traffic = new HashMap<String, Object>();
					param_weight_traffic.put("dimensionCode", "traffic");
					param_weight_traffic.put("cityId", cityId);
					Dimension dimen_traffic = dimensionDao
							.getDimensionByDimensionCodeAndCityId(param_weight_traffic);
					if (dimen_traffic != null) {
						double firstWeight_traffic = dimen_traffic.getWeight();
						param_busDistance.setFirstWeight(firstWeight_traffic);
						param_busDistance.setFirstScore(dimen_traffic
								.getScore());
						param_busNum.setFirstWeight(firstWeight_traffic);
						param_busNum.setFirstScore(dimen_traffic.getScore());
					}

					// 定义教育类参数
					ScoreParams param_nurseryDistance = new ScoreParams();
					ScoreParams param_nurseryNum = new ScoreParams();
					ScoreParams param_commonDistance = new ScoreParams();
					ScoreParams param_commonNum = new ScoreParams();
					ScoreParams param_greatDistance = new ScoreParams();
					ScoreParams param_greatNum = new ScoreParams();
					ScoreParams param_middleDistance = new ScoreParams();
					ScoreParams param_middleNum = new ScoreParams();
					ScoreParams param_collegeDistance = new ScoreParams();
					ScoreParams param_collegeNum = new ScoreParams();

					// 查询教育的权重，并赋值
					Map<String, Object> param_weight_education = new HashMap<String, Object>();
					param_weight_education.put("dimensionCode", "education");
					param_weight_education.put("cityId", cityId);
					Dimension dimen_education = dimensionDao
							.getDimensionByDimensionCodeAndCityId(param_weight_education);
					if (dimen_education != null) {
						double firstWeight_education = dimen_education
								.getWeight();
						param_nurseryDistance
								.setFirstWeight(firstWeight_education);
						param_nurseryDistance.setFirstScore(dimen_education
								.getScore());
						param_nurseryNum.setFirstWeight(firstWeight_education);
						param_nurseryNum.setFirstScore(dimen_education
								.getScore());
						param_commonDistance
								.setFirstWeight(firstWeight_education);
						param_commonDistance.setFirstScore(dimen_education
								.getScore());
						param_commonNum.setFirstWeight(firstWeight_education);
						param_commonNum.setFirstScore(dimen_education
								.getScore());
						param_greatDistance
								.setFirstWeight(firstWeight_education);
						param_greatDistance.setFirstScore(dimen_education
								.getScore());
						param_greatNum.setFirstWeight(firstWeight_education);
						param_greatNum
								.setFirstScore(dimen_education.getScore());
						param_middleDistance
								.setFirstWeight(firstWeight_education);
						param_middleDistance.setFirstScore(dimen_education
								.getScore());
						param_middleNum.setFirstWeight(firstWeight_education);
						param_middleNum.setFirstScore(dimen_education
								.getScore());
						param_collegeDistance
								.setFirstWeight(firstWeight_education);
						param_collegeDistance.setFirstScore(dimen_education
								.getScore());
						param_collegeNum.setFirstWeight(firstWeight_education);
						param_collegeNum.setFirstScore(dimen_education
								.getScore());
					}

					// 定义周边类参数
					ScoreParams param_hospitalDistance = new ScoreParams();// 医院
					ScoreParams param_hospitalNum = new ScoreParams();
					ScoreParams param_clinicDistance = new ScoreParams();// 诊所
					ScoreParams param_clinicNum = new ScoreParams();
					ScoreParams param_pharmacyDistance = new ScoreParams();// 药房
					ScoreParams param_pharmacyNum = new ScoreParams();
					ScoreParams param_bankDistance = new ScoreParams();// 银行
					ScoreParams param_bankNum = new ScoreParams();
					ScoreParams param_entertainmentDistance = new ScoreParams();// 娱乐
					ScoreParams param_entertainmentNum = new ScoreParams();
					ScoreParams param_businessDistance = new ScoreParams();// 商业
					ScoreParams param_businessNum = new ScoreParams();
					ScoreParams param_surroundingDistance = new ScoreParams();// 周边环境
					ScoreParams param_surroundingNum = new ScoreParams();
					ScoreParams param_disadvantageDistance = new ScoreParams();// 不利因素
					ScoreParams param_disadvantageNum = new ScoreParams();
					// 查询周边的权重，并赋值
					Map<String, Object> param_weight_around = new HashMap<String, Object>();
					param_weight_around.put("dimensionCode", "around");
					param_weight_around.put("cityId", cityId);
					Dimension dimen_around = dimensionDao
							.getDimensionByDimensionCodeAndCityId(param_weight_around);
					if (dimen_around != null) {
						double firstWeight_around = dimen_around.getWeight();
						param_hospitalDistance
								.setFirstWeight(firstWeight_around);
						param_hospitalDistance.setFirstScore(dimen_around
								.getScore());
						param_hospitalNum.setFirstWeight(firstWeight_around);
						param_hospitalNum
								.setFirstScore(dimen_around.getScore());
						param_clinicDistance.setFirstWeight(firstWeight_around);
						param_clinicDistance.setFirstScore(dimen_around
								.getScore());
						param_clinicNum.setFirstWeight(firstWeight_around);
						param_clinicNum.setFirstScore(dimen_around.getScore());
						param_pharmacyDistance
								.setFirstWeight(firstWeight_around);
						param_pharmacyDistance.setFirstScore(dimen_around
								.getScore());
						param_pharmacyNum.setFirstWeight(firstWeight_around);
						param_pharmacyNum
								.setFirstScore(dimen_around.getScore());
						param_bankDistance.setFirstWeight(firstWeight_around);
						param_bankDistance.setFirstScore(dimen_around
								.getScore());
						param_bankNum.setFirstWeight(firstWeight_around);
						param_bankNum.setFirstScore(dimen_around.getScore());
						param_entertainmentDistance
								.setFirstWeight(firstWeight_around);
						param_entertainmentDistance.setFirstScore(dimen_around
								.getScore());
						param_entertainmentNum
								.setFirstWeight(firstWeight_around);
						param_entertainmentNum.setFirstScore(dimen_around
								.getScore());
						param_businessDistance
								.setFirstWeight(firstWeight_around);
						param_businessDistance.setFirstScore(dimen_around
								.getScore());
						param_businessNum.setFirstWeight(firstWeight_around);
						param_businessNum
								.setFirstScore(dimen_around.getScore());
						param_surroundingDistance
								.setFirstWeight(firstWeight_around);
						param_surroundingDistance.setFirstScore(dimen_around
								.getScore());
						param_surroundingNum.setFirstWeight(firstWeight_around);
						param_surroundingNum.setFirstScore(dimen_around
								.getScore());
						param_disadvantageDistance
								.setFirstWeight(firstWeight_around);
						param_disadvantageDistance.setFirstScore(dimen_around
								.getScore());
						param_disadvantageNum
								.setFirstWeight(firstWeight_around);
						param_disadvantageNum.setFirstScore(dimen_around
								.getScore());
					}
					double unitMapScore = 0.0;
					double qualityScore = 0.0;
					double trafficScore = 0.0;
					double educationScore = 0.0;
					double aroundScore = 0.0;
					// 根据buildingId查询户型标签集合
					List<String> tagNames = buildingTagDao
							.findTagByBuildingId(building.getBuildingId());
					size = tagNames.size();
					Map<String, Object> param_tagCount = new HashMap<String, Object>();
					param_tagCount.put("tagCount", size);
					param_tagCount.put("cityId", cityId);
					unitMapScore = dimensionDao.getScoreByCityIdAndCode(param_tagCount);// 根据标签数量查询分数
					Map<String, Object> param_tag1 = new HashMap<String, Object>();
					param_tag1.put("dimensionCode", "northSouth");
					param_tag1.put("cityId", cityId);
					Dimension tag1 = dimensionDao
							.getDimensionByDimensionCodeAndCityId(param_tag1);// 查询南北通透的维度
					Map<String, Object> param_tag2 = new HashMap<String, Object>();
					param_tag2.put("dimensionCode", "founder");
					param_tag2.put("cityId", cityId);
					Dimension tag2 = dimensionDao
							.getDimensionByDimensionCodeAndCityId(param_tag2);// 查询户型方正的维度
					double score_northSouth = tag1.getScore();
					double score_founder = tag2.getScore();
					for (String name : tagNames) {
						if (name.equals("南北通透")){
							unitMapScore = unitMapScore + score_northSouth;
						}
						if (name.equals("户型方正")){
							unitMapScore = unitMapScore + score_founder;
						}
					}
					unitMapScore = unitMapScore * dimen_unitMap.getWeight() * 0.01;

					// 根据开发商排名查询维度表对象，二级维度
					Dimension developer = null;
					if (building.getDeveloper() != null
							&& building.getDeveloper() != "") {
						developer = dimensionDao
								.getDimensionByDevelopers(building
										.getDeveloper());
						if (developer != null) {
							param_quality.setSecondWeight((double) developer
									.getWeight());
							param_quality.setSecondScore(developer.getScore());
						}
					} else {
						developer = dimensionDao.getDimensionByDevelopers("");
					}

					qualityScore = getScore(param_quality);
					param_quality.setScore(qualityScore);
					// 根据物业排名查询维度表对象
					Dimension property = null;
					if (building.getProperty() != null
							&& building.getProperty() != "") {
						property = dimensionDao.getDimensionByProperty(building
								.getProperty());
						if (property != null) {
							param_quality.setSecondWeight((double) property
									.getWeight());
							param_quality.setSecondScore(property.getScore());
						}else{
							param_quality.setSecondWeight(0.0);
							param_quality.setSecondScore(0);
						}
					}

					qualityScore = getScore(param_quality);
					param_quality.setScore(qualityScore);
					// 根据地段排名查询维度表对象
					Dimension area = null;
					if (building.getSecondAreaId() != null) {
						area = dimensionDao.getDimensionByArea(building
								.getSecondAreaId());
						if (area != null) {
							param_quality.setSecondWeight((double) area
									.getWeight());
							param_quality.setSecondScore(area.getScore());
						}else{
							param_quality.setSecondWeight(0.0);
							param_quality.setSecondScore(0);
						}
					}

					qualityScore = getScore(param_quality);
					param_quality.setScore(qualityScore);
					// 根据绿化率查询数据哪个区间维度表对象
					DimensionDataSet greenRates = dimensionDao
							.getDimensionDataSetByGreenRates(building
									.getBuildingId());
					if (greenRates != null) {
						param_quality.setSecondWeight((double) greenRates
								.getWeight());
						param_quality.setSecondScore(greenRates.getScore());
					}
					qualityScore = getScore(param_quality);
					param_quality.setScore(qualityScore);
					// 根据车位比查询数据哪个区间维度表对象
					String str = communityQualityDao
							.getCommunityQualityByBuildingId(
									building.getBuildingId())
							.getRatioOfSpaces();
					if (str != null && str != "") {
						boolean boo = str.contains(":");
						if (boo) {
							String[] arr = str.split(":");
							double prefix = Double.parseDouble(String
									.valueOf(arr[0]));
							double suffix = Double.parseDouble(String
									.valueOf(arr[1]));
							if (prefix == 1) {
								Map<String, Object> param_ratioOfSpaces = new HashMap<String, Object>();
								param_ratioOfSpaces.put("buildingId",
										building.getBuildingId());
								param_ratioOfSpaces
										.put("ratioOfSpaces", suffix);
								DimensionDataSet ratioOfSpaces = dimensionDao
										.getDimensionDataSetByRatioOfSpaces(param_ratioOfSpaces);
								if (ratioOfSpaces != null) {
									param_quality
											.setSecondWeight((double) ratioOfSpaces
													.getWeight());
									param_quality.setSecondScore(ratioOfSpaces
											.getScore());
								}
							} else {
								suffix = (1 / prefix);
								BigDecimal big = new BigDecimal(suffix);
								double newsuffix = big.setScale(2,
										BigDecimal.ROUND_HALF_UP).floatValue();
								Map<String, Object> param_ratioOfSpaces = new HashMap<String, Object>();
								param_ratioOfSpaces.put("buildingId",
										building.getBuildingId());
								param_ratioOfSpaces.put("ratioOfSpaces",
										newsuffix);
								DimensionDataSet ratioOfSpaces = dimensionDao
										.getDimensionDataSetByRatioOfSpaces(param_ratioOfSpaces);
								if (ratioOfSpaces != null) {
									param_quality
											.setSecondWeight((double) ratioOfSpaces
													.getWeight());
									param_quality.setSecondScore(ratioOfSpaces
											.getScore());
								}
							}
						}

						qualityScore = getScore(param_quality);
						param_quality.setScore(qualityScore);
					}

					// 根据园区配套查询数据哪个区间维度表对象
					int countParkFacilities = aroundDao
							.countParkFacilitiesByBuildingId(building
									.getBuildingId());
					DimensionDataSet parkFacilities = dimensionDao
							.getDimensionDataSetByParkFacilities(countParkFacilities);
					if (parkFacilities != null) {
						param_quality.setSecondWeight((double) parkFacilities
								.getWeight());
						param_quality.setSecondScore(parkFacilities.getScore());
					}
					qualityScore = getScore(param_quality);
					param_quality.setScore(qualityScore);
					// 根据是否人车分流查询数据哪个区间维度表对象
					DimensionDataSet isSeparation = dimensionDao
							.getDimensionDataSetByIsSeparation(building
									.getBuildingId());
					if (isSeparation != null) {
						param_quality.setSecondWeight((double) isSeparation
								.getWeight());
						param_quality.setSecondScore(isSeparation.getScore());
					}
					qualityScore = getScore(param_quality)
							* param_quality.getFirstWeight() * 0.01;
					// 查询交通的二级维度对象:"公交"，获取维度权重
					DimensionDataSet bus_traffic = dimensionDao
							.getDimensionDataSetByBus(building
									.getBuildingId());

					if(bus_traffic != null){
						Integer mindis_bus = null;
						mindis_bus = lineInfoDao.getBusMinDistance(building
								.getBuildingId());// 根据楼盘编号查询公交最短距离
						if(mindis_bus != null){
							// 根据公交距离查询维度表对象，获取三级维度权重及分值
							DimensionDataSet bus_distance = dimensionDao
									.getDimensionDataSetByBusDistance(building
											.getBuildingId());
							if (bus_distance != null) {
								param_busDistance.setThirdWeight((double) bus_distance
										.getWeight());
								param_busDistance
										.setThirdScore(bus_distance.getScore());
								trafficScore = getScore(param_busDistance);
								param_busNum.setScore(trafficScore);
								// 根据公交数量查询维度对象，获取三级维度权重及分值
								Map<String, Object> param_bus_num = new HashMap<String, Object>();
								param_bus_num.put("buildingId",
										building.getBuildingId());
								param_bus_num.put("begin",
										bus_distance.getBeginValue());
								param_bus_num.put("end",
										bus_distance.getEndValue());
								int countBus = lineInfoDao
										.countBusByBuildIdAndBeginAndEnd(param_bus_num);
								DimensionDataSet bus_num = dimensionDao
										.getDimensionDataSetByBusNum(countBus);
								if (bus_num != null) {
									param_busNum.setThirdWeight((double) bus_num
											.getWeight());
									param_busNum.setThirdScore(bus_num.getScore());
								}
								trafficScore = getScore(param_busNum);
								param_trackDistance.setScore(trafficScore);
							}
						}
					}
					
					// 查询交通的二级维度对象:"轨道"，获取维度权重
					DimensionDataSet track_traffic = dimensionDao
							.getDimensionDataSetByTrack(building
									.getBuildingId());
					if (track_traffic != null) {
						Integer mindis_track = null;
						mindis_track = lineInfoDao.getTrackMinDistance(building
								.getBuildingId());// 根据楼盘编号查询轨道交通工具最短距离
						if (mindis_track != null) {
							DimensionDataSet track_distance = dimensionDao
									.getDimensionDataSetByTrackDistance(mindis_track);// 根据轨道最短距离查询维度
							if (track_distance != null) {
								param_trackDistance
										.setThirdWeight((double) track_distance
												.getWeight());
								param_trackDistance
										.setThirdScore(track_distance
												.getScore());
								trafficScore = getScore(param_trackDistance);
								param_trackNum.setScore(trafficScore);

								// 根据轨道交通工具数量查询维度对象，获取三级维度权重及分值
								Map<String, Object> param_track_num = new HashMap<String, Object>();
								param_track_num.put("buildingId",
										building.getBuildingId());
								param_track_num.put("begin",
										track_distance.getBeginValue());
								param_track_num.put("end",
										track_distance.getEndValue());
								int countTrack = lineInfoDao
										.countLineByBuildIdAndBeginAndEnd(param_track_num);
								DimensionDataSet track_num = dimensionDao
										.getDimensionDataSetByTrackNum(countTrack);
								if (track_num != null) {
									param_trackNum
											.setThirdWeight((double) track_num
													.getWeight());
									param_trackNum.setThirdScore(track_num
											.getScore());
									trafficScore = getScore(param_trackNum)
											* track_traffic.getWeight() * 0.01
											* param_busNum.getFirstWeight() * 0.01;
								}
							}
						}else{
							if(trafficScore != 0){
								trafficScore = getScore(param_trackDistance)
										* bus_traffic.getWeight() * 0.01
										* param_busNum.getFirstWeight() * 0.01;
							}
						}
					}else{
						if(trafficScore != 0){
							trafficScore = getScore(param_trackDistance)
									* bus_traffic.getWeight() * 0.01
									* param_busNum.getFirstWeight() * 0.01;
						}
					}

					// 查询幼儿园的维度权重，二级权重
					Map<String, Object> param_nursery1 = new HashMap<String, Object>();
					param_nursery1.put("dimensionCode", "kindergarten");
					param_nursery1.put("cityId", cityId);
					Dimension nursery = dimensionDao
							.getDimensionByDimensionCodeAndCityId(param_nursery1);

					// 根据幼儿园最短距离，查询三级维度及分数
					Map<String, Object> param_nursery2 = new HashMap<String, Object>();
					param_nursery2.put("dimensionCode1", "kindergartenCount");
					param_nursery2.put("dimensionCode", "kindergartenDistance");
					param_nursery2.put("buildingId", building.getBuildingId());
					param_nursery2.put("cityId", cityId);
					DimensionDataSet nursery_distance = dimensionDao
							.getDimensionDataSetByBuildingIdAndCodeAndCityIdForSchoolDistance(param_nursery2);
					if (nursery_distance != null) {
						param_nurseryDistance
								.setThirdWeight((double) nursery_distance
										.getWeight());
						param_nurseryDistance.setThirdScore(nursery_distance
								.getScore());
					}
					double educationScore_nursery = getScore(param_nurseryDistance);
					param_nurseryNum.setScore(educationScore_nursery);

					// 根据幼儿园数量查询维度对象，获取三级维度权重及分值
					DimensionDataSet nursery_num = dimensionDao
							.getDimensionDataSetByBuildingIdAndCodeAndCityIdForSchoolCount(param_nursery2);
					if (nursery_num != null) {
						param_nurseryNum.setThirdWeight((double) nursery_num
								.getWeight());
						param_nurseryNum.setThirdScore(nursery_num.getScore());
					}

					educationScore_nursery = getScore(param_nurseryNum)
							* nursery.getWeight() * 0.01;

					// 查询普通小学的维度权重，二级权重
					Map<String, Object> param_commonSchool1 = new HashMap<String, Object>();
					param_commonSchool1.put("dimensionCode", "gradeSchool");
					param_commonSchool1.put("cityId", cityId);
					Dimension commonSchool = dimensionDao
							.getDimensionByDimensionCodeAndCityId(param_commonSchool1);

					// 根据普通小学最短距离，查询三级维度及分数
					Map<String, Object> param_commonSchool2 = new HashMap<String, Object>();
					param_commonSchool2.put("buildingId",
							building.getBuildingId());
					param_commonSchool2.put("cityId", cityId);
					DimensionDataSet common_distance = dimensionDao
							.getDimensionDataSetByBuildingIdAndCityIdForGradeSchoolDistance(param_commonSchool2);
					if (common_distance != null) {
						param_commonDistance
								.setThirdWeight((double) common_distance
										.getWeight());
						param_commonDistance.setThirdScore(common_distance
								.getScore());
					}
					double educationScore_common = getScore(param_commonDistance);
					param_commonNum.setScore(educationScore_common);

					int countCommon = educationDao
							.countOrdinaryPrimarySchool(building
									.getBuildingId());
					// 根据普通小学数量查询维度对象，获取三级维度权重及分值
					DimensionDataSet common_num = dimensionDao
							.getDimensionDataSetByBuildingIdAndCityIdForGradeSchoolCount(countCommon);
					if (common_num != null) {
						param_commonNum.setThirdWeight((double) common_num
								.getWeight());
						param_commonNum.setThirdScore(common_num.getScore());
					}
					educationScore_common = getScore(param_commonNum)
							* commonSchool.getWeight() * 0.01;

					// 查询优质小学的维度权重，二级权重
					Map<String, Object> goodGradeSchool1 = new HashMap<String, Object>();
					goodGradeSchool1.put("dimensionCode", "goodGradeSchool");
					goodGradeSchool1.put("cityId", cityId);
					Dimension goodGradeSchool = dimensionDao
							.getDimensionByDimensionCodeAndCityId(goodGradeSchool1);

					// 根据优质小学最短距离，查询三级维度及分数
					Map<String, Object> goodGradeSchool2 = new HashMap<String, Object>();
					goodGradeSchool2
							.put("buildingId", building.getBuildingId());
					goodGradeSchool2.put("cityId", cityId);
					DimensionDataSet great_distance = dimensionDao
							.getDimensionDataSetByBuildingIdAndCityIdForGoodGradeSchoolDistance(goodGradeSchool2);
					if (great_distance != null) {
						param_greatDistance
								.setThirdWeight((double) great_distance
										.getWeight());
						param_greatDistance.setThirdScore(great_distance
								.getScore());
					}
					double educationScore_good = getScore(param_greatDistance);
					param_greatNum.setScore(educationScore_good);

					// 根据优质小学数量查询维度对象，获取三级维度权重及分值
					DimensionDataSet great_num = dimensionDao
							.getDimensionDataSetByBuildingIdAndCityIdForGoodGradeSchoolCount(goodGradeSchool2);
					if (great_num != null) {
						param_greatNum.setThirdWeight((double) great_num
								.getWeight());
						param_greatNum.setThirdScore(great_num.getScore());
					}
					educationScore_good = getScore(param_greatNum)
							* goodGradeSchool.getWeight() * 0.01;

					// 查询中学的维度权重，二级权重
					Map<String, Object> param_middle1 = new HashMap<String, Object>();
					param_middle1.put("dimensionCode", "middleSchool");
					param_middle1.put("cityId", cityId);
					Dimension middleSchool = dimensionDao
							.getDimensionByDimensionCodeAndCityId(param_middle1);

					// 根据中学最短距离，查询三级维度及分数
					Map<String, Object> param_middle2 = new HashMap<String, Object>();
					param_middle2.put("dimensionCode1", "middleSchoolCount");
					param_middle2.put("dimensionCode", "middleSchoolDistance");
					param_middle2.put("buildingId", building.getBuildingId());
					param_middle2.put("cityId", cityId);
					DimensionDataSet middle_distance = dimensionDao
							.getDimensionDataSetByBuildingIdAndCodeAndCityIdForSchoolDistance(param_middle2);
					if (middle_distance != null) {
						param_middleDistance
								.setThirdWeight((double) middle_distance
										.getWeight());
						param_middleDistance.setThirdScore(middle_distance
								.getScore());
					}
					double educationScore_middle = getScore(param_middleDistance);
					param_middleNum.setScore(educationScore_middle);

					// 根据中学数量查询维度对象，获取三级维度权重及分值
					DimensionDataSet middle_num = dimensionDao
							.getDimensionDataSetByBuildingIdAndCodeAndCityIdForSchoolCount(param_middle2);
					if (middle_num != null) {
						param_middleNum.setThirdWeight((double) middle_num
								.getWeight());
						param_middleNum.setThirdScore(middle_num.getScore());
					}
					educationScore_middle = getScore(param_middleNum)
							* middleSchool.getWeight() * 0.01;

					// 查询大学的维度权重，二级权重
					Map<String, Object> param_college1 = new HashMap<String, Object>();
					param_college1.put("dimensionCode", "college");
					param_college1.put("cityId", cityId);
					Dimension college = dimensionDao
							.getDimensionByDimensionCodeAndCityId(param_college1);

					// 根据大学最短距离，查询三级维度及分数
					Map<String, Object> param_college2 = new HashMap<String, Object>();
					param_college2.put("dimensionCode", "collegeCount");
					param_college2.put("dimensionCode", "collegeDistance");
					param_college2.put("buildingId", building.getBuildingId());
					param_college2.put("cityId", cityId);
					DimensionDataSet college_distance = dimensionDao
							.getDimensionDataSetByBuildingIdAndCodeAndCityIdForSchoolDistance(param_college2);
					if (college_distance != null) {
						param_collegeDistance
								.setThirdWeight((double) college_distance
										.getWeight());
						param_collegeDistance.setThirdScore(college_distance
								.getScore());
					}
					double educationScore_college = getScore(param_collegeDistance);
					param_collegeNum.setScore(educationScore_college);

					Map<String, Object> param_countCollege = new HashMap<String, Object>();
					param_countCollege.put("buildingId",
							building.getBuildingId());
					param_countCollege.put("type", 3);
					int countCollege = educationDao
							.countSchool(param_countCollege);
					// 根据大学数量查询维度对象，获取三级维度权重及分值
					DimensionDataSet college_num = dimensionDao
							.getDimensionDataSetByCollege(countCollege);
					if (college_num != null) {
						param_collegeNum.setThirdWeight((double) college_num
								.getWeight());
						param_collegeNum.setThirdScore(college_num.getScore());
					}
					educationScore_college = getScore(param_collegeNum)
							* college.getWeight() * 0.01;

					educationScore = (educationScore_nursery
							+ educationScore_common + educationScore_good
							+ educationScore_middle + educationScore_college)

							* param_middleNum.getFirstWeight() * 0.01;

					double aroundScore_healtCare = 0.0;

					// 查询"医疗"的维度，作为二级权重
					Map<String, Object> param_healtCare1 = new HashMap<String, Object>();
					param_healtCare1.put("dimensionCode", "medical");
					param_healtCare1.put("cityId", cityId);
					Dimension healtCare = dimensionDao
							.getDimensionByDimensionCodeAndCityId(param_healtCare1);

					// 查询"医院"的维度，作为三级权重
					Map<String, Object> param_hospital = new HashMap<String, Object>();
					param_hospital.put("dimensionCode", "hospital");
					param_hospital.put("cityId", cityId);
					Dimension hospital = dimensionDao
							.getDimensionByDimensionCodeAndCityId(param_hospital);

					// 根据最短距离医院，获取四级维度和权重
					Map<String, Object> param_distance_hospital = new HashMap<String, Object>();
					param_distance_hospital.put("buildingId",
							building.getBuildingId());
					param_distance_hospital.put("cityId", cityId);
					DimensionDataSet distance_hospital = dimensionDao
							.getDimensionDataSetByBuildingIdAndCityIdForHospitalDistance(param_distance_hospital);
					if (distance_hospital != null) {
						param_hospitalDistance
								.setFouthWeight((double) distance_hospital
										.getWeight());
						param_hospitalDistance.setFouthScore(distance_hospital
								.getScore());
					}
					double aroundScore_hospital = getScore(param_hospitalDistance);
					param_hospitalNum.setScore(aroundScore_hospital);

					Map<String, Object> param_count_hospital = new HashMap<String, Object>();
					param_count_hospital.put("buildingId",
							building.getBuildingId());
					param_count_hospital.put("type", 1);
					int countHospital = aroundDao
							.countAround(param_count_hospital);
					// 根据医院数量，查询维度对象，作为四级维度
					DimensionDataSet num_hospital = dimensionDao
							.getDimensionDataSetByBuildingIdAndCityIdForHospitalCount(countHospital);
					if (num_hospital != null) {
						param_hospitalNum.setFouthWeight((double) num_hospital
								.getWeight());
						param_hospitalNum
								.setFouthScore(num_hospital.getScore());
					}
					aroundScore_hospital = getScore(param_hospitalNum)
							* hospital.getWeight() * 0.01;

					// 查询诊所的三级维度
					Map<String, Object> param_clinic = new HashMap<String, Object>();
					param_clinic.put("dimensionCode", "clinic");
					param_clinic.put("cityId", cityId);
					Dimension clinic = dimensionDao
							.getDimensionByDimensionCodeAndCityId(param_clinic);

					// 根据最短距离，获取四级维度和权重
					Map<String, Object> param_clinic_distance = new HashMap<String, Object>();
					param_clinic_distance.put("buildingId",
							building.getBuildingId());
					param_clinic_distance.put("cityId", cityId);
					DimensionDataSet distance_clinic = dimensionDao
							.getDimensionDataSetByBuildingIdAndCityIdForClinicDistance(param_clinic_distance);
					if (distance_clinic != null) {
						param_clinicDistance
								.setFouthWeight((double) distance_clinic
										.getWeight());
						param_clinicDistance.setFouthScore(distance_clinic
								.getScore());
					}
					double aroundScore_clinic = getScore(param_clinicDistance);
					param_clinicNum.setScore(aroundScore_clinic);

					Map<String, Object> param_count_clinic = new HashMap<String, Object>();
					param_count_clinic.put("buildingId",
							building.getBuildingId());
					param_count_clinic.put("type", 2);
					int countClinic = aroundDao.countAround(param_count_clinic);
					// 根据诊所数量，查询维度对象，作为四级维度
					DimensionDataSet num_clinic = dimensionDao
							.getDimensionDataSetByBuildingIdAndCityIdForClinicCount(countClinic);
					if (num_clinic != null) {
						param_clinicNum.setFouthWeight((double) num_clinic
								.getWeight());
						param_clinicNum.setFouthScore(num_clinic.getScore());
					}
					aroundScore_clinic = getScore(param_clinicNum)
							* clinic.getWeight() * 0.01;

					// 查询药店的三级维度
					Map<String, Object> param_pharmacy = new HashMap<String, Object>();
					param_pharmacy.put("dimensionCode", "pharmacy");
					param_pharmacy.put("cityId", cityId);
					Dimension pharmacy = dimensionDao
							.getDimensionByDimensionCodeAndCityId(param_pharmacy);

					// 根据药店最短距离，获取四级维度和权重
					Map<String, Object> param_pharmacy_distance = new HashMap<String, Object>();
					param_pharmacy_distance.put("buildingId",
							building.getBuildingId());
					param_pharmacy_distance.put("cityId", cityId);
					DimensionDataSet distance_pharmacy = dimensionDao
							.getDimensionDataSetByBuildingIdAndCityIdForPharmacyDistance(param_pharmacy_distance);
					if (distance_pharmacy != null) {
						param_pharmacyDistance
								.setFouthWeight((double) distance_pharmacy
										.getWeight());
						param_pharmacyDistance.setFouthScore(distance_pharmacy
								.getScore());
					}
					double aroundScore_pharmacy = getScore(param_pharmacyDistance);
					param_pharmacyNum.setScore(aroundScore_pharmacy);

					Map<String, Object> param_count_pharmacy = new HashMap<String, Object>();
					param_count_pharmacy.put("buildingId",
							building.getBuildingId());
					param_count_pharmacy.put("type", 3);
					int countPharmacy = aroundDao
							.countAround(param_count_pharmacy);
					// 根据药店数量，查询维度对象，作为四级维度
					DimensionDataSet num_pharmacy = dimensionDao
							.getDimensionDataSetByBuildingIdAndCityIdForPharmacyCount(countPharmacy);
					if (num_pharmacy != null) {
						param_pharmacyNum.setFouthWeight((double) num_pharmacy
								.getWeight());
						param_pharmacyNum
								.setFouthScore(num_pharmacy.getScore());
					}
					aroundScore_pharmacy = getScore(param_pharmacyNum)
							* pharmacy.getWeight() * 0.01;
					aroundScore_healtCare = (aroundScore_hospital
							+ aroundScore_clinic + aroundScore_pharmacy)
							* healtCare.getWeight() * 0.01;

					// 查询银行的维度,作为二级维度
					Map<String, Object> param_bank = new HashMap<String, Object>();
					param_bank.put("dimensionCode", "bank");
					param_bank.put("cityId", cityId);
					Dimension bank = dimensionDao
							.getDimensionByDimensionCodeAndCityId(param_bank);

					// 根据银行最短距离，获取三级维度和权重
					Map<String, Object> param_bank_distance = new HashMap<String, Object>();
					param_bank_distance.put("buildingId",
							building.getBuildingId());
					param_bank_distance.put("cityId", cityId);
					DimensionDataSet distance_bank = dimensionDao
							.getDimensionDataSetByBuildingIdAndCityIdForBankDistance(param_bank_distance);
					if (distance_bank != null) {
						param_bankDistance
								.setThirdWeight((double) distance_bank
										.getWeight());
						param_bankDistance.setThirdScore(distance_bank
								.getScore());
					}
					double aroundScore_bank = getScore(param_bankDistance);
					param_bankNum.setScore(aroundScore_bank);

					Map<String, Object> param_count_bank = new HashMap<String, Object>();
					param_count_bank
							.put("buildingId", building.getBuildingId());
					param_count_bank.put("type", 4);
					int countBank = aroundDao.countAround(param_count_bank);
					// 根据银行数量，查询维度对象，作为三级级维度
					DimensionDataSet num_bank = dimensionDao
							.getDimensionDataSetByBuildingIdAndCityIdForBankCount(countBank);
					if (num_bank != null) {
						param_bankNum.setThirdWeight((double) num_bank
								.getWeight());
						param_bankNum.setThirdScore(num_bank.getScore());
						aroundScore_bank = getScore(param_bankNum)
								* bank.getWeight() * 0.01;
					}

					// 查询娱乐设施的维度,作为二级维度
					Map<String, Object> param_entertainment = new HashMap<String, Object>();
					param_entertainment.put("dimensionCode", "entertainment");
					param_entertainment.put("cityId", cityId);
					Dimension entertainment = dimensionDao
							.getDimensionByDimensionCodeAndCityId(param_entertainment);

					// 根据最短距离，获取三级维度和权重
					Map<String, Object> param_entertainment_distance = new HashMap<String, Object>();
					param_entertainment_distance.put("buildingId",
							building.getBuildingId());
					param_entertainment_distance.put("cityId", cityId);
					DimensionDataSet distance_entertainment = dimensionDao
							.getDimensionDataSetByBuildingIdAndCityIdForEntertainmentDistance(param_entertainment_distance);
					if (distance_entertainment != null) {
						param_entertainmentDistance
								.setThirdWeight((double) distance_entertainment
										.getWeight());
						param_entertainmentDistance
								.setThirdScore(distance_entertainment
										.getScore());
					}
					double aroundScore_entertainment = getScore(param_entertainmentDistance);
					param_entertainmentNum.setScore(aroundScore_entertainment);

					Map<String, Object> param_count_entertainment = new HashMap<String, Object>();
					param_count_entertainment.put("buildingId",
							building.getBuildingId());
					param_count_entertainment.put("type", 5);
					int countEntertainment = aroundDao
							.countAround(param_count_entertainment);
					// 根据娱乐设施数量，查询维度对象，作为三级级维度
					DimensionDataSet num_entertainment = dimensionDao
							.getDimensionDataSetByBuildingIdAndCityIdForEntertainmentCount(countEntertainment);
					if (num_entertainment != null) {
						param_entertainmentNum
								.setThirdWeight((double) num_entertainment
										.getWeight());
						param_entertainmentNum.setThirdScore(num_entertainment
								.getScore());
						aroundScore_entertainment = getScore(param_entertainmentNum)
								* entertainment.getWeight() * 0.01;
					}

					// 查询商业设施的维度,作为二级维度
					Map<String, Object> param_business = new HashMap<String, Object>();
					param_business.put("dimensionCode", "business");
					param_business.put("cityId", cityId);
					Dimension business = dimensionDao
							.getDimensionByDimensionCodeAndCityId(param_business);

					// 根据商业设施最短距离，获取三级维度和权重
					Map<String, Object> param_business_distance = new HashMap<String, Object>();
					param_business_distance.put("buildingId",
							building.getBuildingId());
					param_business_distance.put("cityId", cityId);
					DimensionDataSet distance_business = dimensionDao
							.getDimensionDataSetByBuildingIdAndCityIdForBusinessDistance(param_business_distance);
					if (distance_business != null) {
						param_businessDistance
								.setThirdWeight((double) distance_business
										.getWeight());
						param_businessDistance.setThirdScore(distance_business
								.getScore());
					}
					double aroundScore_business = getScore(param_businessDistance);
					param_businessNum.setScore(aroundScore_business);

					Map<String, Object> param_count_business = new HashMap<String, Object>();
					param_count_business.put("buildingId",
							building.getBuildingId());
					param_count_business.put("type", 6);
					int countBusiness = aroundDao
							.countAround(param_count_business);
					// 根据商业设施数量，查询维度对象，作为三级级维度
					DimensionDataSet num_business = dimensionDao
							.getDimensionDataSetByBuildingIdAndCityIdForBusinessCount(countBusiness);
					if (num_business != null) {
						param_businessNum.setThirdWeight((double) num_business
								.getWeight());
						param_businessNum
								.setThirdScore(num_business.getScore());
						aroundScore_business = getScore(param_businessNum)
								* business.getWeight() * 0.01;
					}

					// 查询周边环境的维度,作为二级维度
					Map<String, Object> param_environment = new HashMap<String, Object>();
					param_environment.put("dimensionCode", "environment");
					param_environment.put("cityId", cityId);
					Dimension surrounding = dimensionDao
							.getDimensionByDimensionCodeAndCityId(param_environment);

					// 根据周边环境最短距离，获取三级维度和权重
					Map<String, Object> param_environment_distance = new HashMap<String, Object>();
					param_environment_distance.put("buildingId",
							building.getBuildingId());
					param_environment_distance.put("cityId", cityId);
					DimensionDataSet distance_surrounding = dimensionDao
							.getDimensionDataSetByBuildingIdAndCityIdForEnvironmentDistance(param_environment_distance);
					if (distance_surrounding != null) {
						param_surroundingDistance
								.setThirdWeight((double) distance_surrounding
										.getWeight());
						param_surroundingDistance
								.setThirdScore(distance_surrounding.getScore());
					}
					double aroundScore_surrounding = getScore(param_surroundingDistance);
					param_surroundingNum.setScore(aroundScore_surrounding);

					Map<String, Object> param_count_surrounding = new HashMap<String, Object>();
					param_count_surrounding.put("buildingId",
							building.getBuildingId());
					param_count_surrounding.put("type", 7);
					int countSurrounding = aroundDao
							.countAround(param_count_surrounding);
					// 根据周边环境数量，查询维度对象，作为三级级维度
					DimensionDataSet num_surrounding = dimensionDao
							.getDimensionDataSetByBuildingIdAndCityIdForEnvironmentCount(countSurrounding);
					if (num_surrounding != null) {
						param_surroundingNum
								.setThirdWeight((double) num_surrounding
										.getWeight());
						param_surroundingNum.setThirdScore(num_surrounding
								.getScore());
						aroundScore_surrounding = getScore(param_surroundingNum) * surrounding.getWeight() * 0.01;
					}

					// 查询不利因素的维度,作为二级维度
					Map<String, Object> param_badFactor = new HashMap<String, Object>();
					param_badFactor.put("dimensionCode", "badFactor");
					param_badFactor.put("cityId", cityId);
					Dimension disadvantage = dimensionDao
							.getDimensionByDimensionCodeAndCityId(param_badFactor);

					// 根据最短距离，获取三级维度和权重
					Map<String, Object> param_badFactor_distance = new HashMap<String, Object>();
					param_badFactor_distance.put("buildingId",
							building.getBuildingId());
					param_badFactor_distance.put("cityId", cityId);
					DimensionDataSet distance_disadvantage = dimensionDao
							.getDimensionDataSetByBuildingIdAndCityIdForBadFactorDistance(param_badFactor_distance);
					if (distance_disadvantage != null) {
						param_disadvantageDistance
								.setThirdWeight((double) distance_disadvantage
										.getWeight());
						param_disadvantageDistance
								.setThirdScore(distance_disadvantage.getScore());
					}
					double aroundScore_disadvantage = getScore(param_disadvantageDistance);
					param_disadvantageNum.setScore(aroundScore_disadvantage);

					Map<String, Object> param_count_disadvantage = new HashMap<String, Object>();
					param_count_disadvantage.put("buildingId",
							building.getBuildingId());
					param_count_disadvantage.put("type", 8);
					int countDisadvantage = aroundDao
							.countAround(param_count_disadvantage);
					// 根据不利因素数量，查询维度对象，作为三级级维度
					DimensionDataSet num_disadvantage = dimensionDao
							.getDimensionDataSetByBuildingIdAndCityIdForBadFactorCount(countDisadvantage);
					if (num_disadvantage != null) {
						param_disadvantageNum
								.setThirdWeight((double) num_disadvantage
										.getWeight());
						param_disadvantageNum.setThirdScore(num_disadvantage
								.getScore());
					}

					aroundScore_disadvantage = getScore(param_disadvantageNum)
							* disadvantage.getWeight() * 0.01;

					aroundScore = (aroundScore_healtCare + aroundScore_bank
							+ aroundScore_entertainment + aroundScore_business
							+ aroundScore_surrounding + aroundScore_disadvantage)
							* param_disadvantageNum.getFirstWeight() * 0.01;

					// 所有评论的总平均分
					double averageSum = 0;
					// 户型分数平均分
					double unitMapScoreAverage = 0;
					// 社区品质评分平均分数
					double communityQualityScoreAverage = 0;
					// 交通评分平均分数
					double trafficScoreAverage = 0;
					// 教育评分平均分数
					double educationScoreAverage = 0;
					// 周边配套评分平均分数
					double aroundScoreAverage = 0;
					// 根据楼盘ID 查询评论列表
					List<MemberEvaluate> memberEvaluateList = memberEvaluateDao
							.findMemberEvaluateList(building.getBuildingId());
					// 该楼盘有评论
					if (memberEvaluateList.size() > 0) {

						// 根据评论ID查询评分
						for (MemberEvaluate memberEvaluate : memberEvaluateList) {
							// 每条评论对于该楼盘的总评分
							double dimenWeightSumValue = memberEvaluateDao
									.getDimensionWeightSumValueByCommentId(memberEvaluate
											.getCommentId());
							// 累计总评分
							averageSum += dimenWeightSumValue;
							// 五个维度用户评分
							List<MemberScoreDataSet> memberScoreDataSetList = memberEvaluateDao
									.findBuildingScore(memberEvaluate
											.getCommentId());
							// 五个维度各自的评分总和
							for (MemberScoreDataSet memberScoreDataSet : memberScoreDataSetList) {
								if (memberScoreDataSet.getDimensionCode()
										.equals("unitMap")) {
									unitMapScoreAverage += memberScoreDataSet
											.getWeightSumValue();
								} else if (memberScoreDataSet
										.getDimensionCode().equals(
												"communityQuality")) {
									communityQualityScoreAverage += memberScoreDataSet
											.getWeightSumValue();
								} else if (memberScoreDataSet
										.getDimensionCode().equals("traffic")) {
									trafficScoreAverage += memberScoreDataSet
											.getWeightSumValue();
								} else if (memberScoreDataSet
										.getDimensionCode().equals("education")) {
									educationScoreAverage += memberScoreDataSet
											.getWeightSumValue();
								} else if (memberScoreDataSet
										.getDimensionCode().equals("around")) {
									aroundScoreAverage += memberScoreDataSet
											.getWeightSumValue();
								}
							}
						}

						// 算总平均分
						averageSum = averageSum / memberEvaluateList.size();
						// 户型分数平均分
						unitMapScoreAverage = unitMapScoreAverage
								/ memberEvaluateList.size();
						// 社区品质评分平均分数
						communityQualityScoreAverage = communityQualityScoreAverage
								/ memberEvaluateList.size();
						// 交通评分平均分数
						trafficScoreAverage = trafficScoreAverage
								/ memberEvaluateList.size();
						// 教育评分平均分数
						educationScoreAverage = educationScoreAverage
								/ memberEvaluateList.size();
						// 周边配套评分平均分数
						aroundScoreAverage = aroundScoreAverage
								/ memberEvaluateList.size();

						BuildingScore buildingScore = new BuildingScore();
						buildingScore.setBuildingId(building.getBuildingId());
						buildingScore.setBuildingName(building
								.getBuildingName());
						buildingScore.setTotalScore(String.format("%.1f",
								averageSum));
						buildingScore.setUnitMapScore(String.format("%.1f",
								unitMapScoreAverage));
						buildingScore.setCommunityScore(String.format("%.1f",
								communityQualityScoreAverage));
						buildingScore.setTrafficScore(String.format("%.1f",
								trafficScoreAverage));
						buildingScore.setEducationScore(String.format("%.1f",
								educationScoreAverage));
						buildingScore.setPeripheryScore(String.format("%.1f",
								aroundScoreAverage));

					}

					// 查询系统维度
					Map<String, Object> param_sys_score = new HashMap<String, Object>();
					param_sys_score.put("dimensionCode", "systemScore");
					param_sys_score.put("cityId", cityId);
					Dimension systemScore = dimensionDao
							.getDimensionByDimensionCodeAndCityId(param_sys_score);
					Integer sys_dim = 0;
					if (systemScore != null) {
						sys_dim = systemScore.getWeight();
					}

					// 查询用户维度
					Map<String, Object> param_user_score = new HashMap<String, Object>();
					param_user_score.put("dimensionCode", "userScore");
					param_user_score.put("cityId", cityId);
					Dimension userScore = dimensionDao
							.getDimensionByDimensionCodeAndCityId(param_user_score);
					Integer user_dim = 0;
					if (userScore != null) {
						user_dim = userScore.getWeight();
					}

					Float sumUnitMapScore = (float) (unitMapScore * sys_dim
							* 0.01 + unitMapScoreAverage * user_dim * 0.01);// 计算户型评分
					BigDecimal um = new BigDecimal(sumUnitMapScore);
					float sumum = um.setScale(1, BigDecimal.ROUND_HALF_UP)
							.floatValue();
					Float sumQualityScore = (float) (qualityScore * sys_dim
							* 0.01 + communityQualityScoreAverage * user_dim
							* 0.01);// 计算社区品质评分
					BigDecimal q = new BigDecimal(sumQualityScore);
					float sumq = q.setScale(1, BigDecimal.ROUND_HALF_UP)
							.floatValue();
					Float sumTrafficScore = (float) (trafficScore * sys_dim
							* 0.01 + trafficScoreAverage * user_dim * 0.01);// 计算交通评分
					BigDecimal t = new BigDecimal(sumTrafficScore);
					float sumt = t.setScale(1, BigDecimal.ROUND_HALF_UP)
							.floatValue();
					Float sumEducationScore = (float) (educationScore * sys_dim
							* 0.01 + educationScoreAverage * user_dim * 0.01);// 计算教育评分
					BigDecimal e = new BigDecimal(sumEducationScore);
					float sume = e.setScale(1, BigDecimal.ROUND_HALF_UP)
							.floatValue();
					Float sumAroundScore = (float) (aroundScore * sys_dim
							* 0.01 + aroundScoreAverage * user_dim * 0.01);// 计算周边评分
					BigDecimal a = new BigDecimal(sumAroundScore);
					float suma = a.setScale(1, BigDecimal.ROUND_HALF_UP)
							.floatValue();
					Float sumbuildingScore = sumum + sumq + sumt + sume + suma;// 计算综合评分

					BuildingScore bs = new BuildingScore();// 实例化楼盘评分结果集
					bs.setBatchId(branch.getBranchId());
					bs.setBuildingId(building.getBuildingId());
					bs.setCityId(cityId);
					bs.setBuildingName(building.getBuildingName());
					bs.setUnitMapScore(String.valueOf(sumum));
					bs.setCommunityScore(String.valueOf(sumq));
					bs.setTrafficScore(String.valueOf(sumt));
					bs.setEducationScore(String.valueOf(sume));
					bs.setPeripheryScore(String.valueOf(suma));
					bs.setTotalScore(String.valueOf(sumbuildingScore));
					BuildingScore dbbs = buildingScoreDao
							.getBuildingScoreByBuildingId(building
									.getBuildingId());// 根据楼盘编号查询楼盘评分
					if (dbbs != null) {
						buildingScoreDao.updateBuildingScore(bs);// 如果数据存在，则更新
					} else {
						buildingScoreDao.insertBuildingScore(bs);// 如果数据不存在，则保存
					}

				}
			}
		}

	}

	/**
	 * 计算评分
	 * 
	 * @param param
	 * @return
	 */
	private Double getScore(ScoreParams param) {
		Double reslut = param.getScore() + param.getSecondScore()
				* param.getSecondWeight() * 0.01 + param.getThirdScore()
				* param.getThirdWeight() * 0.01 + param.getFouthScore()
				* param.getFouthWeight() * 0.01;
		return reslut;
	}

}
