package com.jzhl.kfsq.controller.sm;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jzhl.kfsq.common.base.ResponseBean;
import com.jzhl.kfsq.common.util.TimeUtil;
import com.jzhl.kfsq.dataset.fm.EnvelopeStatisticalDatoSet;
import com.jzhl.kfsq.dataset.mm.MemberStatisticalDataSet;
import com.jzhl.kfsq.dataset.sm.BranchStatisticalDataSet;
import com.jzhl.kfsq.dataset.sm.UserDataSet;
import com.jzhl.kfsq.dto.sm.StatisticalDto;
import com.jzhl.kfsq.entity.sm.Branch;
import com.jzhl.kfsq.service.fm.IEnvelopeReceiveService;
import com.jzhl.kfsq.service.fm.IEnvelopeRechargeService;
import com.jzhl.kfsq.service.mm.IMemberService;
import com.jzhl.kfsq.service.sm.IBranchService;
import com.jzhl.kfsq.service.sm.IUserService;

/**
 * 用户对外接口类
 * 
 * @author zhouzy
 *
 */
@Controller
public class StatisticalController {

	@Autowired
	private IMemberService memberService;

	@Autowired
	private IBranchService branchService;

	@Autowired
	private IEnvelopeReceiveService envelopeReceiveService;

	@Autowired
	private IUserService userService;

	@Autowired
	private IEnvelopeRechargeService envelopeRechargeService;

	/**
	 * 用户统计
	 * 
	 * @param
	 * @return ResponseBean
	 */
	@SuppressWarnings({ "rawtypes" })
	@RequestMapping(value = "/serv/statistical/memberStatistical", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean getMemberStatistical(StatisticalDto statisticalDto) {

		// // 参数
		// String dateStart = statisticalDto.getDateStart();
		// String dateEnd = statisticalDto.getDateEnd();
		//
		// // 增加参数
		// Map<String, Object> mapp = new HashMap<String, Object>();
		// mapp.put("dateStart", dateStart);
		// mapp.put("dateEnd", dateEnd);
		// // 用户统计
		// MemberStatisticalDataSet memberStatistical =
		// memberService.getMemberStatistical(mapp);

		// 获取时间横坐标；近12个月
		List<String> monthList = TimeUtil.dataResult();

		// 按照月份分组查询用户数量
		List<MemberStatisticalDataSet> smemberNumList = memberService.findMemberNumList(statisticalDto);
		// 查询近12月的数据后，把为null的月份添加默认数据
		List<MemberStatisticalDataSet> memberNumList = new ArrayList<MemberStatisticalDataSet>();
		for (int i = 0; i < monthList.size(); i++) {
			MemberStatisticalDataSet memberNumDataSet = new MemberStatisticalDataSet();
			memberNumDataSet.setMonth(monthList.get(i));
			if (smemberNumList.size() == 0) {
				memberNumDataSet.setMemberNum(0);
			} else {
				for (int j = 0; j < smemberNumList.size(); j++) {
					if (smemberNumList.get(j).getMonth().equals(monthList.get(i))) {
						memberNumDataSet.setMemberNum(smemberNumList.get(j).getMemberNum());
						break;
					} else {
						memberNumDataSet.setMemberNum(0);
					}
				}
			}

			memberNumList.add(memberNumDataSet);
		}

		// 按照月份分组查询加入计划数量
		List<MemberStatisticalDataSet> splanNumList = memberService.findPlanNumList(statisticalDto);
		// 查询近12月的数据后，把为null的月份添加默认数据
		List<MemberStatisticalDataSet> planNumList = new ArrayList<MemberStatisticalDataSet>();
		for (int i = 0; i < monthList.size(); i++) {
			MemberStatisticalDataSet planNumDataSet = new MemberStatisticalDataSet();
			planNumDataSet.setMonth(monthList.get(i));
			if (splanNumList.size() == 0) {
				planNumDataSet.setPlanNum(0);
			} else {
				for (int j = 0; j < splanNumList.size(); j++) {
					if (splanNumList.get(j).getMonth().equals(monthList.get(i))) {
						planNumDataSet.setPlanNum(splanNumList.get(j).getPlanNum());
						break;
					} else {
						planNumDataSet.setPlanNum(0);
					}
				}
			}
			planNumList.add(planNumDataSet);
		}

		// 按照月份分组查询到访数量
		List<MemberStatisticalDataSet> svisitNumList = memberService.findVisitNumList(statisticalDto);
		// 查询近12月的数据后，把为null的月份添加默认数据
		List<MemberStatisticalDataSet> visitNumList = new ArrayList<MemberStatisticalDataSet>();
		for (int i = 0; i < monthList.size(); i++) {
			MemberStatisticalDataSet visitNumDataSet = new MemberStatisticalDataSet();
			visitNumDataSet.setMonth(monthList.get(i));
			if (svisitNumList.size() == 0) {
				visitNumDataSet.setVisitNum(0);
			} else {
				for (int j = 0; j < svisitNumList.size(); j++) {
					if (svisitNumList.get(j).getMonth().equals(monthList.get(i))) {
						visitNumDataSet.setVisitNum(svisitNumList.get(j).getVisitNum());
						break;
					} else {
						visitNumDataSet.setVisitNum(0);
					}
				}
			}
			visitNumList.add(visitNumDataSet);
		}

		// 按照月份分组查询加入看房圈关注数量
		List<MemberStatisticalDataSet> sfollowNumList = memberService.findFollowNumList(statisticalDto);
		// 查询近12月的数据后，把为null的月份添加默认数据
		List<MemberStatisticalDataSet> followNumList = new ArrayList<MemberStatisticalDataSet>();
		for (int i = 0; i < monthList.size(); i++) {
			MemberStatisticalDataSet followNumDataSet = new MemberStatisticalDataSet();
			followNumDataSet.setMonth(monthList.get(i));
			if (sfollowNumList.size() == 0) {
				followNumDataSet.setFollowNum(0);
			} else {
				for (int j = 0; j < sfollowNumList.size(); j++) {
					if (sfollowNumList.get(j).getMonth().equals(monthList.get(i))) {
						followNumDataSet.setFollowNum(sfollowNumList.get(j).getFollowNum());
						break;
					} else {
						followNumDataSet.setFollowNum(0);
					}
				}
			}
			followNumList.add(followNumDataSet);
		}

		// 按照月份分组查询看房圈总评论数量
		List<MemberStatisticalDataSet> sbuildingCommentNumList = memberService.findBuildingCommentNumList(statisticalDto);
		// 查询近12月的数据后，把为null的月份添加默认数据
		List<MemberStatisticalDataSet> buildingCommentNumList = new ArrayList<MemberStatisticalDataSet>();
		for (int i = 0; i < monthList.size(); i++) {
			MemberStatisticalDataSet buildingCommentNumDataSet = new MemberStatisticalDataSet();
			buildingCommentNumDataSet.setMonth(monthList.get(i));
			if (sbuildingCommentNumList.size() == 0) {
				buildingCommentNumDataSet.setBuildingCommentNum(0);
			} else {
				for (int j = 0; j < sbuildingCommentNumList.size(); j++) {
					if (sbuildingCommentNumList.get(j).getMonth().equals(monthList.get(i))) {
						buildingCommentNumDataSet.setBuildingCommentNum(sbuildingCommentNumList.get(j).getBuildingCommentNum());
						break;
					} else {
						buildingCommentNumDataSet.setBuildingCommentNum(0);
					}
				}
			}
			buildingCommentNumList.add(buildingCommentNumDataSet);
		}

		Map<String, Object> queryResult = new HashMap<String, Object>();
		// 返回数据添加
		queryResult.put("memberNumList", memberNumList);
		queryResult.put("planNumList", planNumList);
		queryResult.put("visitNumList", visitNumList);
		queryResult.put("buildingCommentNumList", buildingCommentNumList);
		queryResult.put("followNumList", followNumList);
		ResponseBean<Map<String, Object>> result = new ResponseBean<Map<String, Object>>(queryResult);
		result.operateSuccess();
		return result;
	}

	/**
	 * 代理商统计
	 * 
	 * @param
	 * @return ResponseBean
	 */
	@SuppressWarnings({ "rawtypes" })
	@RequestMapping(value = "/serv/statistical/branchStatistical", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean getBranchStatistical() throws Exception {
		// 代理商统计
		Map<String, Object> mapl = new HashMap<String, Object>();
		List<Branch> branch = branchService.getBranchList(mapl);
		List<BranchStatisticalDataSet> branchResult = new ArrayList<BranchStatisticalDataSet>();
		// 把所有代理商姓名，旗下楼盘数返回前台
		for (int i = 0; i < branch.size(); i++) {
			Map<String, Object> mapb = new HashMap<String, Object>();
			mapb.put("branchId", branch.get(i).getBranchId());

			// changby zhouzy ---begin
			// 根据branchId 查询该代理商下所有楼盘数量
			// int buildingNum = branchService.getBuildingCount(mapb);
			// 根据branchId查询已经充值楼盘数量
			int buildingNum = envelopeRechargeService.getBuildingRechargeCount(mapb);
			// changby zhouzy ---end

			// 代理商信息
			BranchStatisticalDataSet branchStatistical = new BranchStatisticalDataSet();
			branchStatistical.setComanyName(branch.get(i).getComanyName());
			branchStatistical.setBuildingNum(buildingNum);
			branchStatistical.setAreaName(branch.get(i).getAreaName());
			branchStatistical.setCreateTime(branch.get(i).getCreateTime());
			branchResult.add(branchStatistical);
		}
		// 返回数据添加
		Map<String, Object> queryResult = new HashMap<String, Object>();
		queryResult.put("dataList", branchResult);
		ResponseBean<Map<String, Object>> result = new ResponseBean<Map<String, Object>>(queryResult);
		result.operateSuccess();
		return result;
	}

	/**
	 * Admin_红包消耗统计
	 * 
	 * @param
	 * @return ResponseBean
	 */
	@SuppressWarnings({ "rawtypes" })
	@RequestMapping(value = "/serv/statistical/envelopeStatistical", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean getEnvelopeStatistical() throws Exception {
		// 代理商统计
		Map<String, Object> mapl = new HashMap<String, Object>();
		List<Branch> branch = branchService.getBranchList(mapl);
		// 红包消耗统计
		List<EnvelopeStatisticalDatoSet> envelopeResult = new ArrayList<EnvelopeStatisticalDatoSet>();
		for (int i = 0; i < branch.size(); i++) {
			Map<String, Object> mapb = new HashMap<String, Object>();
			mapb.put("branchId", branch.get(i).getBranchId());
			// 加入计划数量
			Integer planNum = envelopeReceiveService.getPlanNum(mapb);
			// 到访数量
			Integer visitNum = envelopeReceiveService.getVisitNum(mapb);
			// 根据branchId 查询该代理商下所有楼盘消耗红包数量
			BigDecimal sumPriceNum = envelopeReceiveService.getSumPriceNum(mapb);

			// 红包消耗统计信息
			EnvelopeStatisticalDatoSet envelopeStatistical = new EnvelopeStatisticalDatoSet();
			envelopeStatistical.setAreaName(branch.get(i).getAreaName());
			envelopeStatistical.setPlanNum(planNum);
			envelopeStatistical.setVisitNum(visitNum);
			envelopeStatistical.setSumPriceNum(sumPriceNum);
			envelopeResult.add(envelopeStatistical);
		}
		// 返回数据添加
		Map<String, Object> queryResult = new HashMap<String, Object>();
		queryResult.put("dataList", envelopeResult);

		ResponseBean<Map<String, Object>> result = new ResponseBean<Map<String, Object>>(queryResult);
		result.operateSuccess();
		return result;
	}

	/**
	 * 楼盘管理后台-首页-用户到访统计
	 * 
	 * @param
	 * @return ResponseBean
	 */
	@SuppressWarnings({ "rawtypes" })
	@RequestMapping(value = "/serv/statistical/buildingStatistical", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean getBuildingStatistical(StatisticalDto statisticalDto) {

		// 获取时间横坐标；近7天年月日
		List<String> dayList = TimeUtil.dayResult();
		// 获取本月的日期横坐标；本月
		List<String> dayForThisMonthList = TimeUtil.dayForThisMonthResult();
		// 获取时间横坐标；近6个月
		List<String> monthList = TimeUtil.monthResult();

		// 某楼盘一个星期内按天分组查询到访数量
		List<MemberStatisticalDataSet> svisitNumByDayList = memberService.findVisitNumByDayList(statisticalDto);
		// 查询近7天的数据后，把为null的日期添加默认数据
		List<MemberStatisticalDataSet> visitNumByDayList = new ArrayList<MemberStatisticalDataSet>();
		for (int i = 0; i < dayList.size(); i++) {
			MemberStatisticalDataSet visitNumByDayDataSet = new MemberStatisticalDataSet();
			visitNumByDayDataSet.setDays(dayList.get(i));
			if (svisitNumByDayList.size() == 0) {
				visitNumByDayDataSet.setVisitNum(0);
			} else {
				for (int j = 0; j < svisitNumByDayList.size(); j++) {
					if (svisitNumByDayList.get(j).getDays().equals(dayList.get(i))) {
						visitNumByDayDataSet.setVisitNum(svisitNumByDayList.get(j).getVisitNum());
						break;
					} else {
						visitNumByDayDataSet.setVisitNum(0);
					}
				}
			}
			visitNumByDayList.add(visitNumByDayDataSet);
		}

		// 某楼盘本月内按天分组查询到访数量
		List<MemberStatisticalDataSet> svisitNumByWeekList = memberService.findVisitNumByWeekList(statisticalDto);
		// 查询本月的数据后，把为null的日期添加默认数据
		List<MemberStatisticalDataSet> visitNumByWeekList = new ArrayList<MemberStatisticalDataSet>();
		for (int i = 0; i < dayForThisMonthList.size(); i++) {
			MemberStatisticalDataSet visitNumByWeekDataSet = new MemberStatisticalDataSet();
			visitNumByWeekDataSet.setWeeks(dayForThisMonthList.get(i));
			if (svisitNumByDayList.size() == 0) {
				visitNumByWeekDataSet.setVisitNum(0);
			} else {
				for (int j = 0; j < svisitNumByWeekList.size(); j++) {
					if (svisitNumByWeekList.get(j).getWeeks().equals(dayForThisMonthList.get(i))) {
						visitNumByWeekDataSet.setVisitNum(svisitNumByWeekList.get(j).getVisitNum());
						break;
					} else {
						visitNumByWeekDataSet.setVisitNum(0);
					}
				}
			}
			visitNumByWeekList.add(visitNumByWeekDataSet);
		}

		// 某楼盘6个月内按月分组查询到访数量
		List<MemberStatisticalDataSet> svisitNumByMonthList = memberService.findVisitNumByMonthList(statisticalDto);
		// 查询近6月的数据后，把为null的月份添加默认数据
		List<MemberStatisticalDataSet> visitNumByMonthList = new ArrayList<MemberStatisticalDataSet>();
		for (int i = 0; i < monthList.size(); i++) {
			MemberStatisticalDataSet visitNumByMonthDataSet = new MemberStatisticalDataSet();
			visitNumByMonthDataSet.setMonth(monthList.get(i));
			if (svisitNumByMonthList.size() == 0) {
				visitNumByMonthDataSet.setVisitNum(0);
			} else {
				for (int j = 0; j < svisitNumByMonthList.size(); j++) {
					if (svisitNumByMonthList.get(j).getMonth().equals(monthList.get(i))) {
						visitNumByMonthDataSet.setVisitNum(svisitNumByMonthList.get(j).getVisitNum());
						break;
					} else {
						visitNumByMonthDataSet.setVisitNum(0);
					}
				}
			}
			visitNumByMonthList.add(visitNumByMonthDataSet);
		}

		Map<String, Object> queryResult = new HashMap<String, Object>();
		// 返回数据添加
		queryResult.put("visitNumByDayList", visitNumByDayList);
		queryResult.put("visitNumByWeekList", visitNumByWeekList);
		queryResult.put("visitNumByMonthList", visitNumByMonthList);

		ResponseBean<Map<String, Object>> result = new ResponseBean<Map<String, Object>>(queryResult);
		result.operateSuccess();
		return result;
	}

	/**
	 * 楼盘管理后台-首页-销售团队业绩统计
	 * 
	 * @param
	 * @return ResponseBean
	 */
	@SuppressWarnings({ "rawtypes" })
	@RequestMapping(value = "/serv/statistical/saleperformancestatistical", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean getSalePerformanceStatistical(StatisticalDto statisticalDto) {

		// 查询登录销售总监旗下的所有销售经理列表-每个销售团队
		List<UserDataSet> saleLeaderList = userService.findSaleLeaderList(statisticalDto);

		List<UserDataSet> userResult = new ArrayList<UserDataSet>();
		// 遍历所有销售团队，查旗下所有售楼员接待用户总量
		for (int i = 0; i < saleLeaderList.size(); i++) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("userId", saleLeaderList.get(i).getUserId());
			map.put("dateStart", statisticalDto.getDateStart());
			map.put("dateEnd", statisticalDto.getDateEnd());
			// 根据userId 查旗下所有售楼员接待用户总量
			int memberNum = userService.getMemberCount(map);

			// 代理商信息
			UserDataSet memberCount = new UserDataSet();
			memberCount.setUserId(saleLeaderList.get(i).getUserId()); // 经理userID
			memberCount.setName(saleLeaderList.get(i).getName()); // 经理名称；团队名称
			memberCount.setMemberNum(memberNum); // 团队接待客户总数

			userResult.add(memberCount);
		}
		// 返回数据添加
		Map<String, Object> queryResult = new HashMap<String, Object>();
		queryResult.put("dataList", userResult);
		ResponseBean<Map<String, Object>> result = new ResponseBean<Map<String, Object>>(queryResult);
		result.operateSuccess();
		return result;
	}

	/**
	 * 楼盘管理后台_财务管理——红包消耗统计-按月分组显示当年红包消耗情况
	 * 
	 * @param
	 * @return ResponseBean
	 */
	@SuppressWarnings({ "rawtypes" })
	@RequestMapping(value = "/serv/statistical/buildingenvelopestatistical", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean findBuildingEnvelopeStatistical(StatisticalDto statisticalDto) throws Exception {

		// 某楼盘一年内按月分组，查询红包消耗统计
		List<EnvelopeStatisticalDatoSet> envelopeResult = envelopeReceiveService.findBuildingEnvelopeStatistical(statisticalDto);

		// 返回数据添加
		Map<String, Object> queryResult = new HashMap<String, Object>();
		queryResult.put("dataList", envelopeResult);

		ResponseBean<Map<String, Object>> result = new ResponseBean<Map<String, Object>>(queryResult);
		result.operateSuccess();
		return result;
	}

}
