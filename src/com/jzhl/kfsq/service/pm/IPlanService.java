package com.jzhl.kfsq.service.pm;

import java.text.ParseException;
import java.util.List;

import com.jzhl.kfsq.common.base.ListResult;
import com.jzhl.kfsq.dataset.pm.MemberPlanDataSet;
import com.jzhl.kfsq.dataset.pm.PlanDataSet;
import com.jzhl.kfsq.dataset.pm.PlanQueryDataSet;
import com.jzhl.kfsq.dto.pm.AppointmentTimeDto;
import com.jzhl.kfsq.dto.pm.IsVisitDto;
import com.jzhl.kfsq.dto.pm.MemberPlanDto;
import com.jzhl.kfsq.dto.pm.PlanDto;
import com.jzhl.kfsq.dto.pm.PlanQueryDto;
import com.jzhl.kfsq.dto.pm.PlanV2Dto;
import com.jzhl.kfsq.entity.pm.Plan;

/**
 * 计划业务层接口
 * 
 * @author Shaw
 *
 */
public interface IPlanService {

	public void insertPlan(Plan plan);

	public void updatePlan(Plan plan);

	public List<PlanQueryDataSet> findPlans(PlanQueryDto planQueryDto);

	/**
	 * 根据会员编号查询已看房未评论的计划结果集
	 * 
	 * @param memberId
	 * @return
	 */
	public ListResult findPlanDataSetByNoComment(int memberId, int begin,
			int length);

	/**
	 * 查询售楼员扫一扫信息
	 * 
	 * @param memberPlanDto
	 * @return
	 */
	public MemberPlanDataSet getMemberPlan(MemberPlanDto memberPlanDto);

	/**
	 * 通过id查plan
	 * 
	 * @param planId
	 * @return
	 */
	public PlanDataSet getPlan(Integer planId);

	/**
	 * 判断是否已看房
	 * 
	 * @param dto
	 * @return
	 */
	public Boolean isLook(PlanDto dto);

	/**
	 * 根据楼盘编号和创建者编号查询看房计划
	 * 
	 * @param plan
	 * @return
	 */
	public Plan getPlanBase(PlanDto dto);

	public void updatePlanBase(Plan plan);

	/**
	 * 自动推送 情况3:按看房规划日期，提示用户有楼盘要看。(日期前一天晚9点提醒)
	 *
	 * @author zhouzy
	 */
	public long planPush();

	/**
	 * 获取未设置看房时间的计划条数
	 * 
	 * @param creatorUserId
	 * @return
	 */
	public int getUnappointPlanCount(int creatorUserId);

	/**
	 * 根据会员编号查询想看列表
	 * 
	 * @param memberId
	 * @return
	 * @throws ParseException 
	 */
	public ListResult findWantPlan(PlanV2Dto dto) throws ParseException;

	/**
	 * 根据会员编号查询已看列表
	 * 
	 * @param memberId
	 * @return
	 */
	public ListResult findAlreadyPlan(PlanV2Dto dto);

	/**
	 * 根据楼盘编号统计楼盘评论总数
	 * 
	 * @param buildingId
	 * @return
	 */
	public int countBuildingComment(Integer buildingId);

	/**
	 * 取消想看
	 * 
	 * @param dto
	 */
	public void updatePlanV2(IsVisitDto dto);

	/**
	 * 设置想看时间
	 * 
	 * @param dto
	 */
	public void updatePlanSetAppointmentTime(AppointmentTimeDto dto);

}
