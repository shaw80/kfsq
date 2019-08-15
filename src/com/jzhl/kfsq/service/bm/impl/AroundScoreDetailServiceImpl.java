package com.jzhl.kfsq.service.bm.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jzhl.kfsq.dao.bm.IAroundScoreDetailMapper;
import com.jzhl.kfsq.dataset.bm.AroundInfo;
import com.jzhl.kfsq.dataset.bm.AroundScoreDataSet;
import com.jzhl.kfsq.dataset.bm.AroundScoreDetail;
import com.jzhl.kfsq.service.bm.IAroundScoreDetailService;

/**
 * 周边分数详情业务层实现类
 * 
 * @author mac
 *
 */
@Service
public class AroundScoreDetailServiceImpl implements
		IAroundScoreDetailService {

	@Autowired IAroundScoreDetailMapper aroundScoreDetailDao;
	
	/**
	 * 根据楼盘编号查询周边分数详情
	 * 
	 * @param buildingId
	 * @return
	 */
	@Override
	public AroundScoreDetail getAroundScoreDetail(int buildingId) {
		AroundScoreDetail result = aroundScoreDetailDao.getAroundScoreDetail(buildingId);
		List<AroundInfo> aroundInfos = new ArrayList<AroundInfo>();
		
		// 医疗集合
		Map<String, Object> param0 = new HashMap<String, Object>();
		param0.put("buildingId", buildingId);
		// 医院
		param0.put("type", 1);
		List<AroundScoreDataSet> hospitalList = aroundScoreDetailDao.findAroundDataSetByBuildingIdAndType(param0);
		// 卫生诊所
		param0.put("type", 2);
		List<AroundScoreDataSet> healthClinicList = aroundScoreDetailDao.findAroundDataSetByBuildingIdAndType(param0);
		// 药店
		param0.put("type", 3);
		List<AroundScoreDataSet> pharmacyList = aroundScoreDetailDao.findAroundDataSetByBuildingIdAndType(param0);
		
		// 如果医疗存在
		if (hospitalList != null || healthClinicList != null || pharmacyList != null ) {
			AroundInfo aroundInfo0 = new AroundInfo();
			aroundInfo0.setType("医疗");
			for (int i = 0; i < 10; i++) {
				// 医院
				if (i < hospitalList.size()) {
					AroundScoreDataSet hospital = hospitalList.get(i);
					hospital.setDistance("距离" + hospital.getDistance() + "m");
					aroundInfo0.getData().add(hospital);
				}
				// 诊所
				if (i < healthClinicList.size()) {
					AroundScoreDataSet healthClinic = healthClinicList.get(i);
					healthClinic.setDistance("距离" + healthClinic.getDistance() + "m");
					aroundInfo0.getData().add(healthClinic);
				}
				// 药房
				if (i < pharmacyList.size()) {
					AroundScoreDataSet pharmacy = pharmacyList.get(i);
					pharmacy.setDistance("距离" + pharmacy.getDistance() + "m");
					aroundInfo0.getData().add(pharmacy);
				}
				
			}
			if (aroundInfo0.getData().size() > 10) {
				aroundInfo0.setData(aroundInfo0.getData().subList(0, 10));
			}
			aroundInfos.add(aroundInfo0);
		}
		
		// 银行
		param0.put("type", 4);
		List<AroundScoreDataSet> bankList = aroundScoreDetailDao.findAroundDataSetByBuildingIdAndType(param0);
		if (bankList != null && bankList.size() > 0) {
			AroundInfo aroundInfo1 = new AroundInfo();
			for (AroundScoreDataSet bank : bankList) {
				aroundInfo1.setType("银行");
				bank.setDistance("距离" + bank.getDistance() + "m");
			}
			aroundInfo1.setData(bankList);
			aroundInfos.add(aroundInfo1);
		}
		// 娱乐
		param0.put("type", 5);
		List<AroundScoreDataSet> entertainmentList = aroundScoreDetailDao.findAroundDataSetByBuildingIdAndType(param0);
		if (entertainmentList != null && entertainmentList.size() > 0) {
			AroundInfo aroundInfo2 = new AroundInfo();
			for (AroundScoreDataSet entertainment : entertainmentList) {
				aroundInfo2.setType("娱乐");
				entertainment.setDistance("距离" + entertainment.getDistance() + "m");
			}
			aroundInfo2.setData(entertainmentList);
			aroundInfos.add(aroundInfo2);
		}
		// 商业
		param0.put("type", 6);
		List<AroundScoreDataSet> businessList = aroundScoreDetailDao.findAroundDataSetByBuildingIdAndType(param0);
		if (businessList != null && businessList.size() > 0) {
			AroundInfo aroundInfo3 = new AroundInfo();
			for (AroundScoreDataSet business : businessList) {
				aroundInfo3.setType("商业");
				business.setDistance("距离" + business.getDistance() + "m");
			}
			aroundInfo3.setData(businessList);
			aroundInfos.add(aroundInfo3);
		}
		// 周边环境
		param0.put("type", 7);
		List<AroundScoreDataSet> peripheryList = aroundScoreDetailDao.findAroundDataSetByBuildingIdAndType(param0);
		if (peripheryList != null && peripheryList.size() > 0) {
			AroundInfo aroundInfo4 = new AroundInfo();
			for (AroundScoreDataSet periphery : peripheryList) {
				aroundInfo4.setType("周边环境");
				periphery.setDistance("距离" + periphery.getDistance() + "m");
			}
			aroundInfo4.setData(peripheryList);
			aroundInfos.add(aroundInfo4);
		}
		
		// 不利因素
		param0.put("type", 8);
		List<AroundScoreDataSet> unfavorableList = aroundScoreDetailDao.findAroundDataSetByBuildingIdAndType(param0);
		if (unfavorableList != null && unfavorableList.size() > 0) {
			AroundInfo aroundInfo5 = new AroundInfo();
			for (AroundScoreDataSet unfavorable : unfavorableList) {
				aroundInfo5.setType("不利因素");
				unfavorable.setDistance("距离" + unfavorable.getDistance() + "m");
			}
			aroundInfo5.setData(unfavorableList);
			aroundInfos.add(aroundInfo5);
		}
		
		if(result != null){
			result.setAroundInfos(aroundInfos);
		}
		return result;
	}
	
}
