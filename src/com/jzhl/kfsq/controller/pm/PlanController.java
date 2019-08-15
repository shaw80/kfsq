package com.jzhl.kfsq.controller.pm;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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
import com.jzhl.kfsq.dataset.pm.MemberPlanDataSet;
import com.jzhl.kfsq.dataset.pm.PlanDataSet;
import com.jzhl.kfsq.dataset.pm.PlanQueryDataSet;
import com.jzhl.kfsq.dto.pm.AppointmentTimeDto;
import com.jzhl.kfsq.dto.pm.IsVisitDto;
import com.jzhl.kfsq.dto.pm.MemberPlanDto;
import com.jzhl.kfsq.dto.pm.PlanDto;
import com.jzhl.kfsq.dto.pm.PlanNoCommentDto;
import com.jzhl.kfsq.dto.pm.PlanQueryDto;
import com.jzhl.kfsq.dto.pm.PlanV2Dto;
import com.jzhl.kfsq.entity.pm.Plan;
import com.jzhl.kfsq.service.pm.IPlanService;

@Controller
public class PlanController {

	@Autowired
	private IPlanService planService;

	private static final Logger logger = Logger.getLogger(PlanController.class);

	/**
	 * 添加看房计划
	 * 
	 * @param plan
	 * @return
	 */
	@RequestMapping(value = "/serv/plan", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean<Object> addPlan(PlanDto planDto) throws Exception {

		ResponseBean<Object> result = new ResponseBean<Object>();

		logger.debug("[添加看房计划]--添加");
		Plan plan = new Plan();
		String appointmentTime = planDto.getAppointmentTime();
		if (appointmentTime != null && !appointmentTime.isEmpty()) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			plan.setAppointmentTime(sdf.parse(appointmentTime));
		} else {
			plan.setAppointmentTime(null);
		}
		plan.setBuildingId(planDto.getBuildingId());
		plan.setCreatorUserId(planDto.getCreatorUserId());
		planService.insertPlan(plan);
		logger.debug("[添加看房计划]--添加成功");
		return result;

	}
	
	/**
	 * 取消想看
	 * @param dto
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "/serv/v2/plan/d", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean updatePlan(IsVisitDto dto){
		planService.updatePlanV2(dto);
		ResponseBean result = new ResponseBean();
		result.operateSuccess("取消成功");
		return result;
	}

	/**
	 * 更新看房计划
	 * 
	 * @param plan
	 * @return
	 */
	@RequestMapping(value = "/serv/plan/m", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean<Object> modifyPlan(PlanDto planDto) throws Exception {
		Plan plan = new Plan();
		BeanUtils.copyProperties(planDto, plan);

		String planId = planDto.getPlanId();
		if (planId != null && planId.contains(",")) {
			// 批量
			plan.setPlanIdList(planId.split(","));
			plan.setPlanId(null);
		}

		String appointmentTime = planDto.getAppointmentTime();
		if (appointmentTime != null && !appointmentTime.isEmpty()) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			plan.setAppointmentTime(sdf.parse(appointmentTime));
		}
		ResponseBean<Object> result = new ResponseBean<Object>();
		logger.debug("[修改看房计划]--修改");
		planService.updatePlan(plan);
		logger.debug("[修改看房计划]--修改成功");

		return result;

	}
	
	/**
	 * 更新看房计划
	 * 
	 * @param plan
	 * @return
	 */
	@RequestMapping(value = "/serv/planBase/m", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean<Object> modifyPlanBase(PlanDto planDto) throws Exception {
		Plan plan = new Plan();
		BeanUtils.copyProperties(planDto, plan);

		plan.setPlanId(planDto.getPlanId());
		plan.setStatus(plan.getStatus());

		String appointmentTime = planDto.getAppointmentTime();
		if (appointmentTime != null && !appointmentTime.isEmpty()) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			plan.setAppointmentTime(sdf.parse(appointmentTime));
		}
		ResponseBean<Object> result = new ResponseBean<Object>();
		logger.debug("[修改看房计划]--修改");
		planService.updatePlanBase(plan);
		logger.debug("[修改看房计划]--修改成功");

		return result;

	}

	@RequestMapping(value = "/serv/plans", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean<Map<String, Object>> findPlan(PlanQueryDto queryDto)
			throws Exception {

		Map<String, Object> queryResult = new HashMap<String, Object>();
		ResponseBean<Map<String, Object>> result = new ResponseBean<Map<String, Object>>(
				queryResult);

		logger.debug("[获取看房计划]--获取");
		List<PlanQueryDataSet> list = planService.findPlans(queryDto);
		queryResult.put("dataList", list);
		queryResult.put("dataCount", list.size());
		logger.debug("[获取看房计划]--获取成功");

		return result;

	}

	@RequestMapping(value = "/serv/getPlan", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean<PlanDataSet> getPlan(Integer planId) {
		logger.debug("[查询看房计划]--获取");
		PlanDataSet plan = planService.getPlan(planId);
		return new ResponseBean<PlanDataSet>(plan);
	}

	/**
	 * 根据会员编号查询已看房未评论的计划结果集
	 * 
	 * @param dto
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/serv/NoCommentPlans", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean<ListResult> findPlanDataSetByNoComment(
			PlanNoCommentDto dto) throws Exception {

		ListResult dataList = planService.findPlanDataSetByNoComment(
				dto.getMemberId(), dto.getRowStart(), dto.getOffset());

		ResponseBean<ListResult> result = new ResponseBean<ListResult>(dataList);

		result.operateSuccess("查询成功");

		return result;

	}

	/**
	 * 查询售楼员扫一扫信息
	 * 
	 * @param memberPlanDto
	 * @return
	 */
	@RequestMapping(value = "/serv/getMemberPlan", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean<MemberPlanDataSet> getMemberPlan(
			MemberPlanDto memberPlanDto) {
		MemberPlanDataSet memberPlanDataSet = planService
				.getMemberPlan(memberPlanDto);
		return new ResponseBean<MemberPlanDataSet>(memberPlanDataSet);
	}

	/**
	 * 查询是否已看房
	 * 
	 * @param dto
	 * @return
	 */
	@RequestMapping(value = "/serv/isLook", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean<Map<String, Object>> getIsLook(PlanDto dto) {
		Boolean isLook = planService.isLook(dto);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("isLook", isLook);
		ResponseBean<Map<String, Object>> result = new ResponseBean<Map<String, Object>>(map);
		result.operateSuccess("查询成功");
		return result;
	}
	
	/**
	 * 根据楼盘编号和创建者编号查询看房计划
	 * 
	 * @param plan
	 * @return
	 */
	@RequestMapping(value = "/serv/getPlanBase", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean<Map<String, Object>> getPlan(PlanDto dto) {
		Plan plan = planService.getPlanBase(dto);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("plan", plan);
		ResponseBean<Map<String, Object>> result = new ResponseBean<Map<String, Object>>(map);
		result.operateSuccess("查询成功");
		return result;
	}
	
	
	@RequestMapping(value = "/serv/v2/plan/getUnappointCount", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean<Map<String, Object>> getUnappointPlanCount(Integer creatorUserId) {
		logger.debug("[看房计划]--获取未设置看房时间的计划条数");
		int dataCount = planService.getUnappointPlanCount(creatorUserId);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("dataCount", dataCount);
		return new ResponseBean<Map<String, Object>>(map);
	}
	
	/**
	 * 想看列表
	 * @param memberId
	 * @return
	 * @throws ParseException 
	 */
	@RequestMapping(value = "/serv/v2/wantPlan", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean<ListResult> getWantPlan(PlanV2Dto dto) throws ParseException{
		dto.setOffset(20);
		ListResult listResult = planService.findWantPlan(dto);
		ResponseBean<ListResult> result = new ResponseBean<ListResult>(listResult);
		result.operateSuccess("查询成功");
		return result;
	}
	
	/**
	 * 已看列表
	 * @param memberId
	 * @return
	 */
	@RequestMapping(value = "/serv/v2/alreadyPlan", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean<ListResult> getAlreadyPlan(PlanV2Dto dto){
		dto.setOffset(20);
		ListResult listResult = planService.findAlreadyPlan(dto);
		ResponseBean<ListResult> result = new ResponseBean<ListResult>(listResult);
		result.operateSuccess("查询成功");
		return result;
	}
	
//	/**
//	 * 根据楼盘编号统计评论数量
//	 * @param buildingId
//	 * @return
//	 */
//	@RequestMapping(value = "/serv/v2/countComment", method = RequestMethod.POST)
//	@ResponseBody
//	public ResponseBean<Map<String, Object>> countBuildingComment(Integer buildingId){
//		int count = planService.countBuildingComment(buildingId);
//		Map<String, Object> map = new HashMap<String, Object>();
//		map.put("count", count);
//		ResponseBean<Map<String, Object>> result = new ResponseBean<Map<String, Object>>(map);
//		result.operateSuccess("查询成功");
//		return result;
//	}
	
	/**
	 * 设置想看时间
	 * 
	 * @param dto
	 */
	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "/serv/v2/plan/appointmentTime", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean updatePlanSetAppointmentTime(AppointmentTimeDto dto){
		planService.updatePlanSetAppointmentTime(dto);
		ResponseBean result = new ResponseBean<>();
		result.operateSuccess("修改成功");
		return result;
	}

}
