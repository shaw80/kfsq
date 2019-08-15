package com.jzhl.kfsq.controller.sm;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jzhl.kfsq.common.base.ListResult;
import com.jzhl.kfsq.common.base.ResponseBean;
import com.jzhl.kfsq.dataset.sm.BuildingStatisticalDataSet;
import com.jzhl.kfsq.dto.sm.BranchDto;
import com.jzhl.kfsq.entity.sm.Branch;
import com.jzhl.kfsq.service.fm.IEnvelopeRechargeService;
import com.jzhl.kfsq.service.sm.IBranchService;
import com.jzhl.kfsq.service.sm.IUserService;

/**
 * 代理商对外接口类
 * 
 * @author zhouzy
 *
 */
@Controller
public class BranchController {

	@Autowired
	private IBranchService ibranchService;

	@Autowired
	private IUserService userService;

	@Autowired
	private IEnvelopeRechargeService envelopeRechargeService;

	/**
	 * 获取代理商权限列表
	 * 
	 * @param
	 * @return ResponseBean
	 */
	@SuppressWarnings({ "rawtypes" })
	@RequestMapping(value = "/serv/branch/branchlist", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean findBranchList(BranchDto branchDto) throws Exception {
		// 分页查询参数
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("rowstart", branchDto.getRowStart());
		map.put("offset", branchDto.getOffset());
		List<Branch> branchList = ibranchService.getBranchListPage(map);

		// 分页返回
		ListResult listResult = new ListResult();
		listResult.setDataList(branchList);

		// 总页数
		int dataCount = ibranchService.getBranchDataCount();
		listResult.setDataCount(dataCount);

		ResponseBean<ListResult> result = new ResponseBean<ListResult>(listResult);
		result.operateSuccess();
		return result;
	}

	/**
	 * 查询代理商详情
	 * 
	 * @param branchId
	 * @return ResponseBean
	 */
	@SuppressWarnings({ "rawtypes" })
	@RequestMapping(value = "/serv/branch/branchinfo", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean getBranchInfo(BranchDto branchDto) throws Exception {
		Branch branch = new Branch();
		BeanUtils.copyProperties(branchDto, branch);
		Branch queryResult = ibranchService.getBranch(branch);
		ResponseBean<Branch> result = new ResponseBean<Branch>(queryResult);
		result.operateSuccess();
		return result;
	}

	/**
	 * 开通、关闭所代理的城市
	 * 
	 * @param branchCityId
	 * @return ResponseBean
	 */
	@SuppressWarnings({ "rawtypes" })
	@RequestMapping(value = "/serv/branch/updatebranchcity", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean updateBranchCity(BranchDto branchDto) throws Exception {
		Branch branch = new Branch();
		BeanUtils.copyProperties(branchDto, branch);
		ibranchService.updateBranchCity(branch);
		ResponseBean result = new ResponseBean<Branch>();
		result.operateSuccess();
		return result;
	}

	/**
	 * 开通代理商
	 * 
	 * @return ResponseBean
	 */
	@SuppressWarnings({ "rawtypes" })
	@RequestMapping(value = "/serv/branch/insertbranch", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean insertBranch(BranchDto branchDto) throws Exception {
		Branch branch = new Branch();
		BeanUtils.copyProperties(branchDto, branch);

		// 代理商表插入数据
		ibranchService.insertBranch(branch, branchDto);

		ResponseBean result = new ResponseBean<Branch>();
		result.operateSuccess();
		return result;
	}

	/**
	 * 编辑代理商
	 * 
	 * @return ResponseBean
	 */
	@SuppressWarnings({ "rawtypes" })
	@RequestMapping(value = "/serv/branch/updatebranch", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean updateBranch(BranchDto branchDto) throws Exception {
		Branch branch = new Branch();
		BeanUtils.copyProperties(branchDto, branch);

		// 代理商表插入数据
		ibranchService.updateBranch(branch);

		ResponseBean result = new ResponseBean<Branch>();
		result.operateSuccess();
		return result;
	}

	/**
	 * 获取代理商代理城市楼盘个数；已充值楼盘个数；平台剩余金额；
	 */
	@SuppressWarnings({ "rawtypes" })
	@RequestMapping(value = "/serv/branch/branchbuildinginfo", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean branchBuildingInfo(BranchDto branchDto) throws Exception {
		Branch branch = new Branch();
		BeanUtils.copyProperties(branchDto, branch);

		Map<String, Object> mapb = new HashMap<String, Object>();
		mapb.put("branchId", branch.getBranchId());
		// 根据branchId 查询该代理商下所有楼盘数量
		int buildingNum = ibranchService.getBuildingCount(mapb);
		
		// 昨日新增楼盘数量
		int buildingNumYesterday = ibranchService.getBuildingCountYesterday(mapb);
		
		// 根据branchId查询已经充值楼盘数量
		int rechargeBuildingNum = envelopeRechargeService.getBuildingRechargeCount(mapb);
		
		// 昨日充值楼盘数量
		int rechargeBuildingNumYesterday = envelopeRechargeService.getBuildingRechargeCountYesterday(mapb);

		/* 平台剩余金额 */
		// 算出楼盘已赎回成功的金额
		int totalRedemptionApplicationPrice = envelopeRechargeService.totalRedemptionApplicationPrice(mapb);

		// 算出评论红包消耗金额
		int totalEnvelopeUsePrice = envelopeRechargeService.totalEnvelopeUsePrice(mapb);

		// 算出总的代理商充值金额
		mapb.put("type", 1);
		int totalBranchPrice = envelopeRechargeService.totalPrice(mapb);
		
		// 昨日代理商充值金额
		int branchRechargeYesterday = envelopeRechargeService.totalPriceYesterday(mapb);

		// 算出总的楼盘充值金额
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("branchId", branch.getBranchId());
		map.put("type", 0);
		int totalBuildingPrice = envelopeRechargeService.totalPrice(map);

		// 平台剩余金额 = 算出总的代理商充值金额 - 算出总的楼盘充值金额 + 算出楼盘已赎回成功的金额 - 算出评论红包消耗金额
		int branchBalance = totalBranchPrice - totalBuildingPrice + totalRedemptionApplicationPrice - totalEnvelopeUsePrice;

		BuildingStatisticalDataSet branchDataSet = new BuildingStatisticalDataSet();
		// 代理商下所有楼盘数量
		branchDataSet.setBuildingNum(buildingNum);
		// 昨日新增楼盘数量
		branchDataSet.setBuildingNumYesterday(buildingNumYesterday);
		// 已经充值楼盘数量
		branchDataSet.setRechargeBuildingNum(rechargeBuildingNum);
		// 昨日充值楼盘数量
		branchDataSet.setRechargeBuildingNumYesterday(rechargeBuildingNumYesterday);
		// 平台剩余金额
		branchDataSet.setBranchBalance(branchBalance);
		// 昨日代理商充值金额
		branchDataSet.setBranchRechargeYesterday(branchRechargeYesterday);
		

		ResponseBean<BuildingStatisticalDataSet> result = new ResponseBean<BuildingStatisticalDataSet>(branchDataSet);
		result.operateSuccess();
		return result;
	}
	
	
	/**
	 * 通过 城市ID获取代理商ID
	 */
	@RequestMapping(value = "/serv/branch/getAgentIdByCityId", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean<Map<String, Object>> getAgentIdByCityId(Integer cityId) {
		Map<String, Object> result = new HashMap<String, Object>();
		Integer agentId = ibranchService.getAgentIdByCityId(cityId);
		result.put("agentId", agentId);
		return new ResponseBean<Map<String, Object>>(result);
	}
	
}
