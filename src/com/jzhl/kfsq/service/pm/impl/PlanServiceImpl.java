package com.jzhl.kfsq.service.pm.impl;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.jpush.api.JPushMember;

import com.jzhl.kfsq.common.base.ListResult;
import com.jzhl.kfsq.common.util.ValidateUtil;
import com.jzhl.kfsq.dao.pm.IPlanDtoMapper;
import com.jzhl.kfsq.dao.pm.IPlanMapper;
import com.jzhl.kfsq.dataset.pm.MemberPlanDataSet;
import com.jzhl.kfsq.dataset.pm.NoCommentPlanDataSet;
import com.jzhl.kfsq.dataset.pm.NoCommentPlanReveiceDataSet;
import com.jzhl.kfsq.dataset.pm.PlanDataSet;
import com.jzhl.kfsq.dataset.pm.PlanQueryDataSet;
import com.jzhl.kfsq.dataset.pm.PlanV2DataSet;
import com.jzhl.kfsq.dto.pm.AppointmentTimeDto;
import com.jzhl.kfsq.dto.pm.IsVisitDto;
import com.jzhl.kfsq.dto.pm.MemberPlanDto;
import com.jzhl.kfsq.dto.pm.PlanDto;
import com.jzhl.kfsq.dto.pm.PlanQueryDto;
import com.jzhl.kfsq.dto.pm.PlanV2Dto;
import com.jzhl.kfsq.entity.pm.Plan;
import com.jzhl.kfsq.entity.sm.PushInfo;
import com.jzhl.kfsq.service.mm.IMemberCacheService;
import com.jzhl.kfsq.service.pm.IPlanService;
import com.jzhl.kfsq.service.sm.IPushInfoService;

@Service
public class PlanServiceImpl implements IPlanService {

	@Autowired
	private IPlanMapper planDao;
	@Autowired
	private IPlanDtoMapper planDtoDao;
	@Autowired
	private IPushInfoService pushInfoService;
	@Autowired
	private IMemberCacheService memberCacheService;

	@Override
	public void insertPlan(Plan plan) {
		planDao.insertPlan(plan);
	}

	@Override
	public void updatePlan(Plan plan) {
		planDao.updatePlan(plan);
	}
	
	@Override
	public void updatePlanBase(Plan plan){
		planDao.updatePlanBase(plan);
	}

	@Override
	public List<PlanQueryDataSet> findPlans(PlanQueryDto planQueryDto) {
		return planDtoDao.findPlans(planQueryDto);
	}

	/**
	 * 根据会员编号查询已看房未评论的计划结果集
	 */
	@Override
	public ListResult findPlanDataSetByNoComment(int memberId, int begin, int length) {

		Map<String, Object> params = new HashMap<String, Object>();

		params.put("memberId", memberId);

		params.put("begin", begin);

		params.put("length", length);

		List<NoCommentPlanReveiceDataSet> list = planDao.findPlanDataSetByNoComment(params);

		List<NoCommentPlanDataSet> dataList = new ArrayList<NoCommentPlanDataSet>();

		for (int i = 0; i < list.size(); i++) {

			NoCommentPlanDataSet data = new NoCommentPlanDataSet();

			data.setBuildingId(list.get(i).getBuildingId());

			data.setBuildingName(list.get(i).getBuildingName());

			data.setBuildingImg(list.get(i).getBuildingImg());

			SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd HH:mm");

			data.setPlanTime(sdf.format(list.get(i).getPlanTime()));

			dataList.add(data);

		}

		Integer count = planDao.countPlanDataSetByNoComment(memberId);

		ListResult result = new ListResult();

		result.setDataCount(count);

		result.setDataList(dataList);

		return result;

	}

	@Override
	public MemberPlanDataSet getMemberPlan(MemberPlanDto memberPlanDto) {
		return planDtoDao.getMemberPlan(memberPlanDto);
	}

	@Override
	public PlanDataSet getPlan(Integer planId) {
		return planDao.getPlan(planId);
	}


	/**
	 * 判断是否已看房
	 * 
	 * @param dto
	 * @return
	 */
	@Override
	public Boolean isLook(PlanDto dto) {

		Plan plan = planDao.getPlanIsLook(dto);

		if (plan == null) {
			return false;
		}
		if (plan.getStatus().equals("1") || plan.getStatus().equals("2")) {
			return true;
		}

		return false;

	}

	/**
	 * 根据楼盘编号和创建者编号查询看房计划
	 * 
	 * @param plan
	 * @return
	 */
	@Override
	public Plan getPlanBase(PlanDto dto) {
		Plan plan = planDao.getPlanIsLook(dto);
		return plan;
	}
	
	


	/**
	 * 自动推送 情况3:按看房规划日期，提示用户有楼盘要看。(日期前一天晚9点提醒)
	 *
	 * @author zhouzy
	 */
	@Override
	public long planPush() {
		int count = 0;
		boolean tag = false;
		JSONObject json = new JSONObject();
		json.put("pushType", "autoPushType");
		json.put("autoPushType", "2");

		// 获取所有明天看房member的phone
		List<PlanDataSet> planDateSet = planDao.getPlanList();
		String sendID = null;
		for (int i = 0; i < planDateSet.size(); i++) {
			// 按电话号个推
			// tag = JPushMember.aliasSend(planDateSet.get(i).getPhone(), "明天记得去看房哦", "明天有计划看房，早点睡吧，看房时记得扫描二维码领取红包哦。",
			// 		json.toString());
			// 使用登录token标识被推送手机
			try {
				sendID = memberCacheService.getTokenByAccount(planDateSet
						.get(i).getPhone());
			} catch (Exception e) {
				e.printStackTrace();
				continue;
			}
			if (ValidateUtil.isEmpty(sendID)) {
				continue;
			}
			tag = JPushMember.aliasSend(sendID.subSequence(0, 35).toString(), "明天记得去看房哦",
					"明天有计划看房，早点睡吧，看房时记得扫描二维码领取红包哦。", json.toString());		
			count++;
			
			if(tag){
				// 推送内容插入数据库
				PushInfo pushInfo = new PushInfo();
				pushInfo.setTitle("明天记得去看房哦");
				pushInfo.setContent("明天有计划看房，早点睡吧，看房时记得扫描二维码领取红包哦。");
				pushInfo.settargetGroup("1");
				pushInfo.setpushType((short) 1);
				pushInfo.setisOffLine((short) 0);
				pushInfo.setMemberId(planDateSet.get(i).getCreatorUserId());
				pushInfo.setIsSuccess((short) 1);
				pushInfo.setcustomTime(new Timestamp(System.currentTimeMillis()));
				pushInfoService.insertPushInfo(pushInfo);
			}
		}

		return count;
	}

	/**
	 * 获取未设置看房时间的计划条数
	 * @param creatorUserId
	 * @return
	 */
	@Override
	public int getUnappointPlanCount(int creatorUserId) {
		return planDao.getUnappointPlanCount(creatorUserId);
	}

	/**
	 * 根据会员编号查询想看列表
	 * 
	 * @param memberId
	 * @return
	 * @throws ParseException 
	 */
	@Override
	public ListResult findWantPlan(PlanV2Dto dto) throws ParseException {
		ListResult result = new ListResult();
		List<PlanV2DataSet> first = new ArrayList<PlanV2DataSet>();
		List<PlanV2DataSet> second = new ArrayList<PlanV2DataSet>();
		List<PlanV2DataSet> three = new ArrayList<PlanV2DataSet>();
		int count = planDtoDao.countWantPlan(dto);
		List<PlanV2DataSet> list = planDtoDao.wantPlan(dto);
		Date now = new Date();
		SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd");
		String nowStr = sim.format(new Date());
		for (PlanV2DataSet data : list) {
			if(data.getAveragePrice().equals(0)){
				data.setAveragePrice(null);
			}
			if(data.getAppointmentTime() != null){// 有计划时间
				Date date = sim.parse(data.getAppointmentTime());
				if(sim.parse(nowStr).after(date)){// 如果计划时间过期
					three.add(data);
				}else{// 如果时间未过期
					first.add(data);
				}
			}else{// 无计划时间
				second.add(data);
			}
		}
		if(second != null && second.size() > 0){
			sort(second);
		}
		if(three != null && three.size() > 0){
			Collections.reverse(three);
		}
		List<PlanV2DataSet> merge = new ArrayList<PlanV2DataSet>();
		merge.addAll(first);
		merge.addAll(second);
		merge.addAll(three);
		result.setDataCount(count);
		result.setDataList(merge);
		return result;
	}

	/**
	 * 根据会员编号查询已看列表
	 * 
	 * @param memberId
	 * @return
	 */
	@Override
	public ListResult findAlreadyPlan(PlanV2Dto dto) {
		ListResult result = new ListResult();
		int count = planDtoDao.countAlreadyPlan(dto);
		List<PlanV2DataSet> list = planDtoDao.alreadyPlan(dto);
		result.setDataCount(count);
		result.setDataList(list);
		return result;
	}

	/**
	 * 根据楼盘编号统计楼盘评论总数
	 * @param buildingId
	 * @return
	 */
	@Override
	public int countBuildingComment(Integer buildingId) {
		int count = planDtoDao.countBuildingComment(buildingId);
		return count;
	}

	/**
	 * 取消想看
	 * @param dto
	 */
	@Override
	public void updatePlanV2(IsVisitDto dto) {
		planDao.updatePlanV2(dto);
	}

	/**
	 * 设置想看时间
	 * 
	 * @param dto
	 */
	@Override
	public void updatePlanSetAppointmentTime(AppointmentTimeDto dto) {
		planDao.updatePlanSetAppointmentTime(dto);
	}
	
	/**
	 * 根据计划的创建时间倒序排序
	 * @param data
	 */
	private static void sort(List<PlanV2DataSet> data){
		Collections.sort(data, new Comparator<PlanV2DataSet>(){
			public int compare(PlanV2DataSet parm1, PlanV2DataSet parm2){
				Timestamp a = parm1.getCreateTime();
				Timestamp b = parm2.getCreateTime();
				return b.compareTo(a);
			}
		});
	}

}
