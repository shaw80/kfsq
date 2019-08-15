package com.jzhl.kfsq.service.mm.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jzhl.kfsq.dao.mm.IMemberMapper;
import com.jzhl.kfsq.dao.pm.IPlanDtoMapper;
import com.jzhl.kfsq.dataset.mm.AchievementDataSet;
import com.jzhl.kfsq.dataset.pm.PlanQueryDataSet;
import com.jzhl.kfsq.dto.pm.PlanQueryDto;
import com.jzhl.kfsq.entity.mm.Member;
import com.jzhl.kfsq.service.mm.IAchievementService;

@Service
public class AchievementServiceImpl implements IAchievementService {
	
	@Autowired
	private IPlanDtoMapper planDtoDao;
	
	@Autowired
	private IMemberMapper memberDao;
	
	@Override
	public List<AchievementDataSet> findAchievement(int userId) {
		
		List<AchievementDataSet> result = new ArrayList<AchievementDataSet>();
		
		Member member = new Member();
		member.setMemberId(userId);
		member = memberDao.getMember(member);
		
		PlanQueryDto planQueryDto = new PlanQueryDto();
		planQueryDto.setCreatorUserId(userId);
		planQueryDto.setFlag(1);
		List<PlanQueryDataSet> planDataSets = planDtoDao.findPlans(planQueryDto);
		
		AchievementDataSet dataset = new AchievementDataSet();
		for(PlanQueryDataSet dataSet : planDataSets) {
			dataset = new AchievementDataSet();
			dataset.setAction("您看了");
			dataset.setBuildingName(dataSet.getBuildingName());
			dataset.setActionTime(dataSet.getAppointmentTime());
			dataset.setBanner(dataSet.getBanner());
			result.add(dataset);
		}
		dataset = new AchievementDataSet();
		dataset.setAction("您第一次加入我们的大家庭");
		Date createDate = member.getCreateTime();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		dataset.setActionTime(sdf.format(createDate));
		result.add(dataset);
		
		return result;
		
	}

}
