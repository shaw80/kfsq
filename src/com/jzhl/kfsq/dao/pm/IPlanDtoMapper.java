package com.jzhl.kfsq.dao.pm;

import java.util.List;

import com.jzhl.kfsq.dataset.pm.MemberPlanDataSet;
import com.jzhl.kfsq.dataset.pm.PlanQueryDataSet;
import com.jzhl.kfsq.dataset.pm.PlanV2DataSet;
import com.jzhl.kfsq.dto.pm.MemberPlanDto;
import com.jzhl.kfsq.dto.pm.PlanQueryDto;
import com.jzhl.kfsq.dto.pm.PlanV2Dto;

public interface IPlanDtoMapper {

	/**
	 * 
	 * @param planDto
	 * @param flag
	 *            "0"代表status取值全部;1代表status取值1,2
	 * @return
	 */
	public List<PlanQueryDataSet> findPlans(PlanQueryDto planDto);

	/**
	 * 查询售楼员扫一扫信息
	 * 
	 * @param memberPlanDto
	 * @return
	 */
	public MemberPlanDataSet getMemberPlan(MemberPlanDto memberPlanDto);

	/**
	 * 根据会员编号查询想看列表
	 * 
	 * @param memberId
	 * @return
	 */
	public List<PlanV2DataSet> wantPlan(PlanV2Dto dto);
	
	/**
	 * 统计想看列表总数
	 * @param memberId
	 * @return
	 */
	public Integer countWantPlan(PlanV2Dto dto);
	
	/**
	 * 根据会员编号查询已看列表
	 * @param memberId
	 * @return
	 */
	public List<PlanV2DataSet> alreadyPlan(PlanV2Dto dto);
	
	/**
	 * 统计已看列表总数
	 * @param memberId
	 * @return
	 */
	public Integer countAlreadyPlan(PlanV2Dto dto);
	
	/**
	 * 根据楼盘编号统计楼盘评论总数
	 * @param buildingId
	 * @return
	 */
	public Integer countBuildingComment(Integer buildingId);

}
