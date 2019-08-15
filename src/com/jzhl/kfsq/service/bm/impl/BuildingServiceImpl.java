package com.jzhl.kfsq.service.bm.impl;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringEscapeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jzhl.kfsq.common.base.ListResult;
import com.jzhl.kfsq.dao.ba.IBuildingQueryHistoryMapper;
import com.jzhl.kfsq.dao.bm.IBuildingAreaDtoMapper;
import com.jzhl.kfsq.dao.bm.IBuildingEnvelopeDtoMapper;
import com.jzhl.kfsq.dao.bm.IBuildingFeatureDtoMapper;
import com.jzhl.kfsq.dao.bm.IBuildingFeatureMapper;
import com.jzhl.kfsq.dao.bm.IBuildingMapper;
import com.jzhl.kfsq.dao.bm.IBuildingPriceDtoMapper;
import com.jzhl.kfsq.dao.bm.IUnitMapMapper;
import com.jzhl.kfsq.dao.fm.IEnvelopeSwitchMapper;
import com.jzhl.kfsq.dao.sm.IEnvelopeRuleMapper;
import com.jzhl.kfsq.dataset.bm.BuildingDataSet;
import com.jzhl.kfsq.dataset.bm.BuildingFeatureMsgDataSet;
import com.jzhl.kfsq.dataset.bm.BuildingInfo;
import com.jzhl.kfsq.dataset.bm.RecommendBuildingsDataSet;
import com.jzhl.kfsq.dataset.sm.BuildingStatisticalDataSet;
import com.jzhl.kfsq.dto.bm.BuildingAreaDto;
import com.jzhl.kfsq.dto.bm.BuildingDto;
import com.jzhl.kfsq.dto.bm.BuildingEnvelopeDto;
import com.jzhl.kfsq.dto.bm.BuildingFeatureDto;
import com.jzhl.kfsq.dto.bm.BuildingPriceDto;
import com.jzhl.kfsq.entity.ba.BuildingQueryHistory;
import com.jzhl.kfsq.entity.bm.Building;
import com.jzhl.kfsq.entity.bm.BuildingFeature;
import com.jzhl.kfsq.entity.bm.UnitMap;
import com.jzhl.kfsq.entity.fm.EnvelopeSwitch;
import com.jzhl.kfsq.entity.sm.EnvelopeRule;
import com.jzhl.kfsq.service.bm.IBuildingService;

@Service
public class BuildingServiceImpl implements IBuildingService {

	@Autowired
	private IBuildingPriceDtoMapper buildingPriceDto;
	@Autowired
	private IBuildingFeatureDtoMapper buildingFeatureDtoDao;
	@Autowired
	private IUnitMapMapper unitMapDao;
	@Autowired
	private IBuildingEnvelopeDtoMapper buildingEnvelopeDtoDao;
	@Autowired
	private IBuildingAreaDtoMapper buildingAreaDtoDao;
	@Autowired
	private IBuildingMapper buildingDao;
	@Autowired
	private IBuildingFeatureMapper buildingFeatureDao;
	@Autowired
	private IEnvelopeSwitchMapper envelopeSwitchDao;
	@Autowired
	private IEnvelopeRuleMapper envelopeRuleDao;
	@Autowired
	private IBuildingQueryHistoryMapper buildingQueryHistoryDao;

	@Override
	public ListResult findBuildingEnvelopeDto(BuildingDto dto) {
		ListResult result = new ListResult();
		// 添加默认排序,按照楼盘评分降序排列
		if (dto.getSortFlag() == null) {
			dto.setSortFlag(2);
		}

		List<BuildingEnvelopeDto> buildingEnvelopeDtoList = buildingEnvelopeDtoDao.findBuildingEnvelopeDto(dto);
		for (BuildingEnvelopeDto envelopDto : buildingEnvelopeDtoList) {
			// EnvelopeSwitch es =
			// envelopeSwitchDao.getSwitchByBuildingIdAndSwitchTypeForLookhouse(envelopDto.getBuildingId());//
			// 修改DAO层，根据代理商ID查询开关
			if (envelopDto.getSwitchStatus() == 1) {// 看房红包总开关开启
				EnvelopeRule rule = envelopeRuleDao.getRuleByBuildingId(envelopDto.getBuildingId());// 楼盘看房红包规则开关开启（已设置看房红包规则）
				if (rule != null) {
					if (envelopDto.getBalance().compareTo(new BigDecimal(envelopDto.getScancodePrice())) > 0) {// 楼盘余额大于扫码金额
						envelopDto.setHasEnvelope("true");
					}
				}
			}

			// 如果楼盘状态为待定或者售罄；则楼盘价格不显示0元；显示待定或售罄/ '销售状态（0：预售，1：在售，2：售罄）',
			if (0 == envelopDto.getSalesType() && "0".equals(envelopDto.getAveragePrice())) {
				envelopDto.setAveragePrice("待定");
			} else if (2 == envelopDto.getSalesType() && "0".equals(envelopDto.getAveragePrice())) {
				envelopDto.setAveragePrice("售罄");
			} else if (1 == envelopDto.getSalesType() && "0".equals(envelopDto.getAveragePrice())) {
				envelopDto.setAveragePrice("待定");
			} else {
				envelopDto.setAveragePrice(envelopDto.getAveragePrice() + "  元/㎡");
			}

		}

		int dataCount = buildingEnvelopeDtoDao.findBuildingEnvelopeDtoCount(dto);

		result.setDataList(buildingEnvelopeDtoList);
		result.setDataCount(dataCount);

		// v1.1 addby zhouzy 20160612 -------begin
		// 收索楼盘名称不为null时，要把收索条件持久化到BA_BuildingQueryHistory表中；
		if (dto.getBuildingName() != null) {
			BuildingQueryHistory buildingQueryHistory = new BuildingQueryHistory();
			buildingQueryHistory.setMemberId(dto.getMemberId());
			buildingQueryHistory.setUuId(dto.getUuId());
			buildingQueryHistory.setQueryString(dto.getBuildingName());
			buildingQueryHistoryDao.insertBuildingQueryHistory(buildingQueryHistory);
		}
		// v1.1 addby zhouzy 20160612 -------end

		return result;
	}

	/**
	 * 查询楼盘详情
	 */
	@Override
	public BuildingPriceDto getBuildingPriceDto(java.lang.Integer buildingId) {
		BuildingPriceDto result = buildingPriceDto.getBuildingPriceDto(buildingId);
		// TODO 添加楼盘是否有红包的判断
		BuildingDto dto = new BuildingDto();
		dto.setBuildingId("" + buildingId);
		List<BuildingEnvelopeDto> list = buildingEnvelopeDtoDao.findBuildingEnvelopeDto(dto);
		BuildingEnvelopeDto buildingEnvelopeDto = list.get(0);
		if (list.size() > 0 && list != null) {
			EnvelopeSwitch es = envelopeSwitchDao.getSwitchByBuildingIdAndSwitchTypeForLookhouse(buildingId);// 查询红包开关
			if (es.getSwitchStatus() == 1) {// 看房红包总开关开启
				EnvelopeRule rule = envelopeRuleDao.getRuleByBuildingId(buildingId);// 楼盘看房红包规则开关开启（已设置看房红包规则）
				if (rule != null) {
					if (buildingEnvelopeDto.getBalance().compareTo(new BigDecimal(result.getScancodePrice())) > 0) {// 楼盘余额大于扫码金额
						result.setHasEnvelope("true");
					} else {
						result.setHasEnvelope("false");
					}
				} else {
					result.setHasEnvelope("false");
				}
			} else {
				result.setHasEnvelope("false");
			}
		}

		if (result != null && result.getSurrounding() != null) {
			result.setSurrounding(StringEscapeUtils.unescapeHtml(result.getSurrounding()));
		}
		return result;
	}

	@Override
	public List<UnitMap> findUnitMap(UnitMap unitMap) {
		return unitMapDao.findUnitMap(unitMap);
	}

	@Override
	public List<BuildingFeatureDto> findBuildingFeatureDto(BuildingFeatureDto buildingFeatureDto) {
		return buildingFeatureDtoDao.findBuildingFeatureDto(buildingFeatureDto);
	}

	@Override
	public List<BuildingFeatureMsgDataSet> findBuildingFeatureMsgDataSet(Integer buildingId) {
		return buildingFeatureDtoDao.findBuildingFeatureMsgDataSet(buildingId);
	}

	@Override
	public List<BuildingAreaDto> findBuildingAreaDto(BuildingAreaDto buildingAreaDto) {
		return buildingAreaDtoDao.findBuildingAreaDto(buildingAreaDto);
	}

	/**
	 * 按照月份分组统计楼盘数量
	 * 
	 * @author zhouzy
	 */
	@Override
	public List<BuildingStatisticalDataSet> findBuildingStatistical(BuildingDto buildingDto) {
		return buildingAreaDtoDao.findBuildingStatistical(buildingDto);
	}

	/**
	 * 查询楼盘权限列表
	 * 
	 * @author zhouzy
	 */
	@Override
	public List<BuildingDataSet> findBuildingList(Map<String, Object> map) {
		List<BuildingDataSet> result = buildingDao.findBuildingList(map);
		return result;
	}

	/**
	 * 查询楼盘权限列表总数
	 * 
	 * @author zhouzy
	 */
	@Override
	public int getBuildingDataCount(Map<String, Object> map) {
		int dataCount = buildingDao.getBuildingDataCount(map);
		return dataCount;
	}

	/**
	 * 根据代理商userid查询其下销售总监列表
	 */
	@Override
	public List<BuildingDataSet> findBuildingUserList(Map<String, Object> map) {
		List<BuildingDataSet> result = buildingDao.findBuildingUserList(map);
		return result;
	}

	/**
	 * 更新楼盘信息
	 * 
	 * @param building
	 */
	@Override
	public void updateBuilding(Building building) {
		buildingDao.update(building);
	}

	/**
	 * 新增楼盘信息
	 * 
	 * @param building
	 */
	@Override
	public Building insertBuilding(Building building) {
		buildingDao.insert(building);
		return building;
	}

	/**
	 * 禁用楼盘
	 * 
	 * @param building
	 */
	@Override
	public void inVaildBuilding(Building building) {
		buildingDao.inVaild(building);

	}

	/**
	 * 根据条件查询楼盘信息
	 * 
	 * @param building
	 * @return
	 */
	@Override
	public List<Building> findBuilding(Building building) {
		return buildingDao.find(building);
	}

	/**
	 * 新增楼盘特色关系
	 */
	@Override
	public void insertBuildingFeature(BuildingFeature buildingFeature) {
		buildingFeatureDao.insert(buildingFeature);
	}

	/**
	 * 禁用楼盘特色关系
	 */
	@Override
	public void updateBuildingFeatureInValid(BuildingFeature buildingFeature) {
		buildingFeatureDao.inValid(buildingFeature);
	}

	/**
	 * 查询楼盘特色关系
	 */
	@Override
	public List<BuildingFeature> findBuildingFeature(BuildingFeature buildingFeature) {
		return buildingFeatureDao.findBuildingFeature(buildingFeature);
	}

	/**
	 * 添加楼盘户型图
	 * 
	 * @param unitMap
	 */
	@Override
	public void insertUnitMap(UnitMap unitMap) {
		unitMapDao.insert(unitMap);
	}

	/**
	 * 更新楼盘户型图
	 */
	@Override
	public void updateUnitMap(UnitMap unitMap) {
		unitMapDao.update(unitMap);
	}

	/**
	 * 禁用楼盘户型图
	 */
	@Override
	public void updateUnitMapInValid(UnitMap unitMap) {
		unitMapDao.inValid(unitMap);
	}

	/**
	 * 根据代理商userid查询其下楼盘列表;从楼盘列表中过滤掉已经添加过的楼盘，用于添加楼盘营销总监用，因为一个楼盘只有一个营销总监；
	 */
	@Override
	public List<BuildingDataSet> findNewBuildingList(Map<String, Object> map) {
		List<BuildingDataSet> result = buildingDao.findNewBuildingList(map);
		return result;
	}

	/**
	 * 按照月份分组统计已充值楼盘数量；
	 * 
	 * @author zhouzy 20160120;
	 * @param
	 * @return ResponseBean
	 */
	@Override
	public int getRechargeBuildingNum(BuildingDto buildingDto) {
		return buildingAreaDtoDao.getRechargeBuildingNum(buildingDto);
	}

	/**
	 * 查询推荐楼盘
	 * 
	 * @param buildingDto
	 * @return
	 */
	@Override
	public RecommendBuildingsDataSet getRecommendBuildings(BuildingDto dto) {
		RecommendBuildingsDataSet dataSet = new RecommendBuildingsDataSet();

		BuildingDto synthesizeDto = new BuildingDto();
		synthesizeDto.setAreaId(dto.getAreaId());
		synthesizeDto.setFeatureId(dto.getFeatureId());
		synthesizeDto.setPriceId(dto.getPriceId());
		synthesizeDto.setBuildingId(dto.getBuildingId());
		synthesizeDto.setIsComprehensive("1");
		synthesizeDto.setRowStart(dto.getRowStart());
		synthesizeDto.setOffset(dto.getOffset());
		synthesizeDto.setIsPage("1");

		BuildingDto areaDto = new BuildingDto();
		areaDto.setAreaId(dto.getAreaId());
		areaDto.setBuildingId(dto.getBuildingId());
		areaDto.setRowStart(dto.getRowStart());
		areaDto.setOffset(dto.getOffset());
		areaDto.setIsPage("1");

		BuildingDto priceDto = new BuildingDto();
		priceDto.setPriceId(dto.getPriceId());
		priceDto.setBuildingId(dto.getBuildingId());
		priceDto.setRowStart(dto.getRowStart());
		priceDto.setOffset(dto.getOffset());
		priceDto.setIsPage("1");

		BuildingDto featureDto = new BuildingDto();
		featureDto.setFeatureId(dto.getFeatureId());
		featureDto.setBuildingId(dto.getBuildingId());
		featureDto.setRowStart(dto.getRowStart());
		featureDto.setOffset(dto.getOffset());
		featureDto.setIsPage("1");

		if (dto.getMemberId() != null) {
			synthesizeDto.setMemberId(dto.getMemberId());
			areaDto.setMemberId(dto.getMemberId());
			priceDto.setMemberId(dto.getMemberId());
			featureDto.setMemberId(dto.getMemberId());
		}

		// List<BuildingEnvelopeDto> synthesize =
		// buildingEnvelopeDtoDao.findBuildingEnvelopeDto(synthesizeDto);// 查询综合
		// dataSet.setSynthesize(synthesize);
		List<BuildingEnvelopeDto> area = buildingEnvelopeDtoDao.findBuildingEnvelopeDto(areaDto);// 查询同地段
		for (BuildingEnvelopeDto envelopDto : area) {
			EnvelopeSwitch es = envelopeSwitchDao.getSwitchByBuildingIdAndSwitchTypeForLookhouse(envelopDto.getBuildingId());// 修改DAO层，根据代理商ID查询开关
			if (es.getSwitchStatus() == 1) {// 看房红包总开关开启
				EnvelopeRule rule = envelopeRuleDao.getRuleByBuildingId(envelopDto.getBuildingId());// 楼盘看房红包规则开关开启（已设置看房红包规则）
				if (rule != null) {
					if (envelopDto.getBalance().compareTo(new BigDecimal(envelopDto.getScancodePrice())) > 0) {// 楼盘余额大于扫码金额
						envelopDto.setHasEnvelope("true");
					} else {
						envelopDto.setHasEnvelope("false");
					}
				} else {
					envelopDto.setHasEnvelope("false");
				}
			} else {
				envelopDto.setHasEnvelope("false");
			}
		}
		dataSet.setArea(area);
		List<BuildingEnvelopeDto> price = buildingEnvelopeDtoDao.findBuildingEnvelopeDto(priceDto);// 查询同价位
		for (BuildingEnvelopeDto envelopDto : price) {
			EnvelopeSwitch es = envelopeSwitchDao.getSwitchByBuildingIdAndSwitchTypeForLookhouse(envelopDto.getBuildingId());// 修改DAO层，根据代理商ID查询开关
			if (es.getSwitchStatus() == 1) {// 看房红包总开关开启
				EnvelopeRule rule = envelopeRuleDao.getRuleByBuildingId(envelopDto.getBuildingId());// 楼盘看房红包规则开关开启（已设置看房红包规则）
				if (rule != null) {
					if (envelopDto.getBalance().compareTo(new BigDecimal(envelopDto.getScancodePrice())) > 0) {// 楼盘余额大于扫码金额
						envelopDto.setHasEnvelope("true");
					} else {
						envelopDto.setHasEnvelope("false");
					}
				} else {
					envelopDto.setHasEnvelope("false");
				}
			} else {
				envelopDto.setHasEnvelope("false");
			}
		}
		dataSet.setPrice(price);
		List<BuildingEnvelopeDto> feature = buildingEnvelopeDtoDao.findBuildingEnvelopeDto(featureDto);// 查询同特色
		for (BuildingEnvelopeDto envelopDto : feature) {
			EnvelopeSwitch es = envelopeSwitchDao.getSwitchByBuildingIdAndSwitchTypeForLookhouse(envelopDto.getBuildingId());// 修改DAO层，根据代理商ID查询开关
			if (es.getSwitchStatus() == 1) {// 看房红包总开关开启
				EnvelopeRule rule = envelopeRuleDao.getRuleByBuildingId(envelopDto.getBuildingId());// 楼盘看房红包规则开关开启（已设置看房红包规则）
				if (rule != null) {
					if (envelopDto.getBalance().compareTo(new BigDecimal(envelopDto.getScancodePrice())) > 0) {// 楼盘余额大于扫码金额
						envelopDto.setHasEnvelope("true");
					} else {
						envelopDto.setHasEnvelope("false");
					}
				} else {
					envelopDto.setHasEnvelope("false");
				}
			} else {
				envelopDto.setHasEnvelope("false");
			}
		}
		dataSet.setFeature(feature);

		return dataSet;
	}

	/**
	 * 根据营销总监userId查询buildingInfo信息，包含楼盘名称和楼盘余额
	 * 
	 * @param userId
	 * @return
	 */
	@Override
	public BuildingInfo getBuildingInfo(int userId) {
		BuildingInfo dataSet = buildingDao.getBuildingInfo(userId);
		return dataSet;
	}

}
