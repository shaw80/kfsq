package com.jzhl.kfsq.dao.pm;

import java.util.List;
import java.util.Map;

import com.jzhl.kfsq.dataset.pm.NoCommentPlanReveiceDataSet;
import com.jzhl.kfsq.dataset.pm.PlanDataSet;
import com.jzhl.kfsq.dto.pm.AppointmentTimeDto;
import com.jzhl.kfsq.dto.pm.IsVisitDto;
import com.jzhl.kfsq.dto.pm.PlanDto;
import com.jzhl.kfsq.entity.pm.Plan;

/**
 * 计划数据访问层接口
 * 
 * @author Shaw
 *
 */
public interface IPlanMapper {

	public void insertPlan(Plan plan);

	public void updatePlan(Plan plan);
	
	public void updatePlanBase(Plan plan);

	/**
	 * 根据会员编号查询已看房未评论的计划结果集
	 * 
	 * @param memberId
	 * @return
	 */
	public List<NoCommentPlanReveiceDataSet> findPlanDataSetByNoComment(Map<String, Object> params);

	/**
	 * 统计已看房未评论的结果集数量
	 * 
	 * @param memberId
	 * @return
	 */
	public Integer countPlanDataSetByNoComment(Integer memberId);

	/**
	 * 根据ID查plan
	 * 
	 * @param planId
	 * @return
	 */
	public PlanDataSet getPlan(Integer planId);


	/**
	 * 根据楼盘编号和会员编号查询看房计划
	 * 
	 * @param dto
	 * @return
	 */
	public Plan getPlanIsLook(PlanDto dto);


	/**
	 * 获取所有明天看房member的phone
	 * 
	 * @author zhouzy
	 */
	public List<PlanDataSet> getPlanList();

	public int getUnappointPlanCount(int creatorUserId);
	
	/**
	 * 取消想看
	 * @param dto
	 */
	public void updatePlanV2(IsVisitDto dto);
	
	/**
	 * 设置想看时间
	 * @param dto
	 */
	public void updatePlanSetAppointmentTime(AppointmentTimeDto dto);

}
