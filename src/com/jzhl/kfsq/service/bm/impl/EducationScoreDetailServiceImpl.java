package com.jzhl.kfsq.service.bm.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jzhl.kfsq.dao.bm.IEducationScoreDetailMapper;
import com.jzhl.kfsq.dataset.bm.EducationInfo;
import com.jzhl.kfsq.dataset.bm.EducationScoreDataSet;
import com.jzhl.kfsq.dataset.bm.EducationScoreDetail;
import com.jzhl.kfsq.service.bm.IEducationScoreDetailService;

/**
 * 教育分数详情业务层实现类
 * 
 * @author mac
 *
 */
@Service
public class EducationScoreDetailServiceImpl implements
		IEducationScoreDetailService {

	@Autowired IEducationScoreDetailMapper educationScoreDetailDao;
	
	/**
	 * 根据楼盘编号查询教育分数详情
	 * 
	 * @param buildingId
	 * @return
	 */
	@Override
	public EducationScoreDetail getEducationScoreDetail(int buildingId) {
		EducationScoreDetail result = educationScoreDetailDao.getEducationScoreDetail(buildingId);
		List<EducationInfo> educationInfos = new ArrayList<EducationInfo>();
		
		Map<String, Object> param0 = new HashMap<String, Object>();
		param0.put("buildingId", buildingId);
		param0.put("type", 0);
		param0.put("distance", 1000);
		List<EducationScoreDataSet> list_0 = educationScoreDetailDao.findEducationDataSetByBuildingIdAndType(param0);
		if(list_0.size() > 0 && list_0 != null){
			EducationInfo educationInfo0 = new EducationInfo();
			educationInfo0.setType("幼儿园");
			for (EducationScoreDataSet data : list_0) {
				data.setDistance("距离" + data.getDistance() + "m");
			}
			educationInfo0.setData(list_0);
			educationInfos.add(educationInfo0);
		}
		
		Map<String, Object> param1 = new HashMap<String, Object>();
		param1.put("buildingId", buildingId);
		List<EducationScoreDataSet> list_1 = educationScoreDetailDao.findNormalSchoolDataSetBybuildingId(param1);
		if(list_1.size() > 0 && list_1 != null){
			EducationInfo educationInfo1 = new EducationInfo();
			educationInfo1.setType("普通小学");
			for (EducationScoreDataSet data : list_1) {
				data.setDistance("距离" + data.getDistance() + "m");
			}
			educationInfo1.setData(list_1);
			educationInfos.add(educationInfo1);
		}
		
		Map<String, Object> param2 = new HashMap<String, Object>();
		param2.put("buildingId", buildingId);
		List<EducationScoreDataSet> list_2 = educationScoreDetailDao.findHighQualitySchoolDataSetBybuildingId(param2);
		if(list_2.size() > 0 && list_2 != null){
			EducationInfo educationInfo2 = new EducationInfo();
			educationInfo2.setType("优质小学");
			for (EducationScoreDataSet data : list_2) {
				data.setDistance("距离" + data.getDistance() + "m");
			}
			educationInfo2.setData(list_2);
			educationInfos.add(educationInfo2);
		}
		
		Map<String, Object> param3 = new HashMap<String, Object>();
		param3.put("buildingId", buildingId);
		param3.put("type", 2);
		param3.put("distance", 2000);
		List<EducationScoreDataSet> list_3 = educationScoreDetailDao.findEducationDataSetByBuildingIdAndType(param3);
		if(list_3.size() > 0 && list_3 != null){
			EducationInfo educationInfo3 = new EducationInfo();
			educationInfo3.setType("中学");
			for (EducationScoreDataSet data : list_3) {
				data.setDistance("距离" + data.getDistance() + "m");
			}
			educationInfo3.setData(list_3);
			educationInfos.add(educationInfo3);
		}
		
		Map<String, Object> param4 = new HashMap<String, Object>();
		param4.put("buildingId", buildingId);
		param4.put("type", 3);
		param4.put("distance", 2000);
		List<EducationScoreDataSet> list_4 = educationScoreDetailDao.findEducationDataSetByBuildingIdAndType(param4);
		if(list_4.size() > 0 && list_4 != null){
			EducationInfo educationInfo4 = new EducationInfo();
			educationInfo4.setType("大学");
			for (EducationScoreDataSet data : list_4) {
				data.setDistance("距离" + data.getDistance() + "m");
			}
			educationInfo4.setData(list_4);
			educationInfos.add(educationInfo4);
		}
		
		if(result != null){
			result.setEducationInfos(educationInfos);
		}
		return result;
	}

}
