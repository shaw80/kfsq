package com.jzhl.kfsq.service.sm.impl;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jzhl.kfsq.dao.sm.IBranchCityMapper;
import com.jzhl.kfsq.dao.sm.IBranchMapper;
import com.jzhl.kfsq.dao.sm.IRoleMapper;
import com.jzhl.kfsq.dataset.bm.BuildingInfo;
import com.jzhl.kfsq.dto.sm.BranchDto;
import com.jzhl.kfsq.entity.fm.EnvelopeRecharge;
import com.jzhl.kfsq.entity.fm.EnvelopeSwitch;
import com.jzhl.kfsq.entity.sc.ConfigInfo;
import com.jzhl.kfsq.entity.sm.Branch;
import com.jzhl.kfsq.entity.sm.BranchCity;
import com.jzhl.kfsq.entity.sm.BuildingRemindInfo;
import com.jzhl.kfsq.entity.sm.RemindInfo;
import com.jzhl.kfsq.entity.sm.Role;
import com.jzhl.kfsq.entity.sm.User;
import com.jzhl.kfsq.service.bm.IBuildingService;
import com.jzhl.kfsq.service.fm.IEnvelopeRechargeService;
import com.jzhl.kfsq.service.fm.IEnvelopeSwitchService;
import com.jzhl.kfsq.service.sc.IConfigInfoService;
import com.jzhl.kfsq.service.sm.IBranchService;
import com.jzhl.kfsq.service.sm.IBuildingRemindInfoService;
import com.jzhl.kfsq.service.sm.IRemindInfoService;
import com.jzhl.kfsq.service.sm.IUserService;

/**
 * 代理商实现类
 * 
 * @author zhouzy
 *
 */
@Service
public class BranchServiceImpl implements IBranchService {

	@Autowired
	private IBranchMapper branchDao;

	@Autowired
	private IBranchCityMapper branchCityDao;

	@Autowired
	private IUserService userService;

	@Autowired
	private IEnvelopeSwitchService envelopeSwitchService;

	@Autowired
	private IEnvelopeRechargeService envelopeRechargeService;

	@Autowired
	private IConfigInfoService configInfoService;

	@Autowired
	private IRemindInfoService remindInfoService;

	@Autowired
	private IBuildingRemindInfoService buildingRemindInfoService;

	@Autowired
	private IRoleMapper roleDao;

	@Autowired
	private IBuildingService buildingService;

	/**
	 * 代理商城市开通、禁用
	 * 
	 */
	@Override
	public void updateBranchCity(Branch Branch) {
		branchDao.updateBranchCity(Branch);
	}

	/**
	 * 根据用户编号查询代理商信息
	 * 
	 * @return 代理商实体类
	 */

	@Override
	public Branch getBranch(Branch param) {
		Branch Branch = branchDao.getBranch(param);
		return Branch;
	}

	/**
	 * 获取代理商权限列表
	 * 
	 * @return 代理商集合
	 */
	@Override
	public List<Branch> getBranchList(Map<String, Object> map) {
		List<Branch> result = branchDao.getBranchList(map);
		return result;
	}

	/**
	 * 获取楼盘数量
	 */
	@Override
	public int getBuildingCount(Map<String, Object> map) {
		int buildingCount = branchDao.getBuildingCount(map);
		return buildingCount;
	}

	/**
	 * 新增代理商
	 */
	@Override
	public void insertBranch(Branch branch, BranchDto branchDto) {
		// 代理商表中插入数据
		branchDao.insertBranch(branch);

		// SM_BranchCity 表中插入数据 开通代理商城市
		BranchCity branchCity = new BranchCity();
		branchCity.setCreatorUserId(branchDto.getCreatorUserId());
		branchCity.setBranchCityId(branchDto.getBranchCityId());
		branchCityDao.insertBranchCity(branchCity);

		// 用户表插入数据
		User user = new User();
		user.setAccount(branchDto.getAccount());
		user.setBranchId(branch.getBranchId());
		user.setName(branchDto.getLeadName());
		user.setPassword(branchDto.getPassword());
		user.setUserType(0); // '0.运营平台用户 1.B端用户'
		user.setMobilePhone(branchDto.getPhone());
		user.setIsValid(1);

		// 根据代理商code查询代理商ID
		Role role = roleDao.getRoleByRoleCode("agent");
		user.setRoleId(role.getRoleId());// 代理商ID
		user.setIDCardImg(branchDto.getIDCardImg());
		user.setCreatorUserId(branchDto.getCreatorUserId());
		userService.insertUser(user);

		// 添加代理商红包总开关数据
		EnvelopeSwitch envelopeSwitch = new EnvelopeSwitch();
		envelopeSwitch.setBranchId(branch.getBranchId());
		envelopeSwitch.setSwitchStatus(0); // '开关状态（0：默认关闭，1：开启）',
		envelopeSwitch.setUpdateUserId(branchDto.getCreatorUserId());
		envelopeSwitch.setSwitchType(0); // '开关类型（0：评论红包，1：看房红包）',
		envelopeSwitchService.insertEnvelopeSwitch(envelopeSwitch);

		envelopeSwitch.setSwitchType(1); // '开关类型（0：评论红包，1：看房红包）',
		envelopeSwitchService.insertEnvelopeSwitch(envelopeSwitch);

		// SC_ConfigInfo 表，代理商对楼盘余额提醒设置额度添加；
		ConfigInfo configInfo = new ConfigInfo();
		configInfo.setConfigType(7); // 7为固定值；代理对楼盘的余额提醒类型；
		configInfo.setConfigTypeName("城市ID_" + branchDto.getBranchCityId() + "_代理余额提醒");
		configInfo.setConfigKey(branch.getBranchId().toString()); // 代理商ID
		configInfo.setConfigValue("10000"); // 提醒余额额度暂定10000
		configInfo.setCreatorUserId(branchDto.getCreatorUserId());
		configInfoService.insertConfigInfo(configInfo);

	}

	/**
	 * 获取代理商权限列表数量
	 */
	@Override
	public int getBranchDataCount() {
		int dataCount = branchDao.getBranchDataCount();
		return dataCount;
	}

	/**
	 * 编辑代理商
	 */
	@Override
	public void updateBranch(Branch branch) throws Exception {
		// 更新代理商表
		branchDao.updateBranch(branch);

		// 更新user表
		User user = new User();
		user.setUserId(branch.getUserId());
		user.setName(branch.getLeadName());
		user.setMobilePhone(branch.getPhone());
		user.setIDCardImg(branch.getIDCardImg());
		user.setUpdateUserId(branch.getUpdateUserId());
		userService.updateUser(user);
	}

	/**
	 * 分页获取代理商权限列表
	 * 
	 * @return 代理商集合
	 */
	@Override
	public List<Branch> getBranchListPage(Map<String, Object> map) {
		List<Branch> result = branchDao.getBranchListPage(map);
		return result;
	}

	/**
	 * 代理商余额提醒
	 */
	public long remindInfoInsert() {
		long count = 0;

		// 插入数据前，先清空表SM_RemindInfo
		remindInfoService.deleteData();

		// 查询所有的代理商列表
		Map<String, Object> map = new HashMap<String, Object>();
		List<Branch> branchList = getBranchList(map);

		// 遍历所有代理商
		for (int i = 0; i < branchList.size(); i++) {
			// 查询每个代理商余额，并且与提醒金额比较
			int branchBalance = branchBalance(branchList.get(i).getBranchId());

			// 查询代理商余额提醒额度；
			int remindPrice = 0;

			ConfigInfo configInfo = new ConfigInfo();
			configInfo.setConfigType(1); // 提醒余额类型；固定为1
			configInfo.setConfigKey("balanceWarn"); // 提醒余额key；固定为balanceWarn
			ConfigInfo configResult = configInfoService.getConfigInfoByObj(configInfo);
			if (configResult != null) {
				remindPrice = Integer.parseInt(configResult.getConfigValue());
			}

			// 如果余额小于提醒额度；则插入数据
			if (branchBalance < remindPrice) {
				// 插入数据
				RemindInfo remindInfo = new RemindInfo();
				remindInfo.setbranchId(branchList.get(i).getBranchId());
				remindInfo.setcontent("的余额已经低于" + remindPrice + "元，请您及时缴费！");
				remindInfoService.insertData(remindInfo);
				count++;
			}
		}

		return count;
	}

	// 平台余额
	public int branchBalance(int branchId) {

		int branchBalance = 0;

		Map<String, Object> mapb = new HashMap<String, Object>();
		mapb.put("branchId", branchId);
		// 算出楼盘已赎回成功的金额
		int totalRedemptionApplicationPrice = envelopeRechargeService.totalRedemptionApplicationPrice(mapb);

		// 算出评论红包消耗金额
		int totalEnvelopeUsePrice = envelopeRechargeService.totalEnvelopeUsePrice(mapb);

		// 算出总的代理商充值金额
		mapb.put("type", 1);
		int totalBranchPrice = envelopeRechargeService.totalPrice(mapb);

		// 算出总的楼盘充值金额
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("branchId", branchId);
		map.put("type", 0);
		int totalBuildingPrice = envelopeRechargeService.totalPrice(map);

		// 平台剩余金额 = 算出总的代理商充值金额 - 算出总的楼盘充值金额 + 算出楼盘已赎回成功的金额 - 算出评论红包消耗金额
		branchBalance = totalBranchPrice - totalBuildingPrice + totalRedemptionApplicationPrice - totalEnvelopeUsePrice;

		return branchBalance;
	}

	/**
	 * 通过 城市ID获取代理商ID
	 */
	@Override
	public Integer getAgentIdByCityId(Integer cityId) {
		return branchDao.getAgentIdByCityId(cityId);
	}

	/**
	 * 获取昨日新增楼盘总数
	 * 
	 * @author zhouzy
	 */
	@Override
	public int getBuildingCountYesterday(Map<String, Object> map) {
		int buildingCountYesterday = branchDao.getBuildingCountYesterday(map);
		return buildingCountYesterday;
	}

	/**
	 * 楼盘余额提醒
	 */
	public long buildingRemindInfoInsert() {
		long count = 0;

		// 插入数据前，先清空表SM_BuildingRemindInfo
		buildingRemindInfoService.deleteData();

		// 查询所有的代理商列表
		Map<String, Object> map = new HashMap<String, Object>();
		List<Branch> branchList = getBranchList(map);

		// 遍历所有代理商
		for (int i = 0; i < branchList.size(); i++) {

			// 查询代理商旗下所有充值楼盘
			Map<String, Object> mapp = new HashMap<String, Object>();
			mapp.put("branchId", branchList.get(i).getBranchId());
			List<EnvelopeRecharge> buildingList = getEnvelopeBuildingList(mapp);

			// 查询每个代理商旗下每个楼盘余额，并且与提醒金额比较
			for (int j = 0; j < buildingList.size(); j++) {

				// 根据楼盘ID获取楼盘余额
				int buildingBalance = buildingBalance(buildingList.get(j).getBuildingId());

				// 查询代理商余额提醒额度；
				int remindPrice = 0;

				ConfigInfo configInfo = new ConfigInfo();
				configInfo.setConfigType(7); // 楼盘提醒余额类型；固定为7
				configInfo.setConfigKey(branchList.get(i).getBranchId().toString()); // 提醒余额key；固定为代理商ID
				ConfigInfo configResult = configInfoService.getConfigInfoByObj(configInfo);
				if (configResult != null) {
					remindPrice = Integer.parseInt(configResult.getConfigValue());
				}

				// 如果余额小于提醒额度；则插入数据
				if (buildingBalance < remindPrice) {
					// 插入数据
					BuildingRemindInfo buildingRemindInfo = new BuildingRemindInfo();
					buildingRemindInfo.setBranchId(buildingList.get(j).getBranchId());
					buildingRemindInfo.setBuildingId(buildingList.get(j).getBuildingId());
					buildingRemindInfo.setContent("的余额已经低于" + remindPrice + "元，请您及时缴费！");
					buildingRemindInfoService.insertData(buildingRemindInfo);
					count++;
				}
			}
		}

		return count;
	}

	// 楼盘余额
	public int buildingBalance(Integer buildingId) {

		// 根据楼盘Id获取营销总监userId
		Integer userId = userService.getUserIdByBuildingId(buildingId);

		// 根据楼盘营销总监userId获取楼盘余额
		BuildingInfo buildingInfo = buildingService.getBuildingInfo(userId);

		// 楼盘余额
		BigDecimal buildingBalance = buildingInfo.getBalance();
		return buildingBalance.intValue();
	}

	// 根据代理商ID获取旗下所有充值楼盘列表
	private List<EnvelopeRecharge> getEnvelopeBuildingList(Map<String, Object> mapp) {
		List<EnvelopeRecharge> result = envelopeRechargeService.getEnvelopeBuildingList(mapp);
		return result;
	}

}
