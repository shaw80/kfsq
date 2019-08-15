package com.jzhl.kfsq.service.bm.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jzhl.kfsq.dao.bm.ILineInfoMapper;
import com.jzhl.kfsq.dao.bm.ITrafficScoreDetailMapper;
import com.jzhl.kfsq.dataset.bm.Station;
import com.jzhl.kfsq.dataset.bm.TrafficDataSet;
import com.jzhl.kfsq.dataset.bm.TrafficInfo;
import com.jzhl.kfsq.dataset.bm.TrafficScoreDetail;
import com.jzhl.kfsq.service.bm.ITrafficScoreDetailService;


/**
 * 交通分数详情业务层实现类
 * 
 * @author Shaw
 *
 */
@Service
public class TrafficScoreDetailServiceImpl implements
		ITrafficScoreDetailService {

	@Autowired 
	private ITrafficScoreDetailMapper trafficScoreDetailDao;
	@Autowired
	private ILineInfoMapper LineInfoDao;
	
	/**
	 * 根据楼盘编号查询交通分数详情
	 * 
	 * @param buildingId
	 * @return
	 */
	@Override
	public TrafficScoreDetail getTrafficScoreDetail(int buildingId) {
		TrafficScoreDetail result = trafficScoreDetailDao.getTrafficScoreDetail(buildingId);
		List<TrafficInfo> trafficInfos = new ArrayList<TrafficInfo>();
		Map<String, Object> param0 = new HashMap<String, Object>();
		param0.put("buildingId", buildingId);
		param0.put("type", 0);
		param0.put("distance", 1000);
		List<TrafficDataSet> list_0 = trafficScoreDetailDao.findTrafficDataSetByBuildingIdAndType(param0);
		List<Station> stations = LineInfoDao.findStationByBuildingIdAndTypeAndDistance(param0);
		if(list_0.size() > 0 && list_0 != null){
			TrafficInfo trafficInfo0 = new TrafficInfo();
			trafficInfo0.setType("公交");
			for (TrafficDataSet data : list_0) {
				data.setDistance("距离" + data.getDistance() + "m");
			}
			trafficInfo0.setData(list_0);
			trafficInfos.add(trafficInfo0);
		}
		Map<String, Object> param1 = new HashMap<String, Object>();
		param1.put("buildingId", buildingId);
		param1.put("type", 1);
		param1.put("distance", 1500);
		List<TrafficDataSet> list_1 = trafficScoreDetailDao.findTrafficDataSetByBuildingIdAndType(param1);
		List<Station> stations_metro = LineInfoDao.findStationByBuildingIdAndTypeAndDistance(param1);
		stations.addAll(stations_metro);
		if(list_1.size() > 0 && list_1 != null){
			TrafficInfo trafficInfo1 = new TrafficInfo();
			trafficInfo1.setType("地铁");
			for (TrafficDataSet data : list_1) {
				data.setDistance("距离" + data.getDistance() + "m");
			}
			trafficInfo1.setData(list_1);
			trafficInfos.add(trafficInfo1);
		}
		Map<String, Object> param2 = new HashMap<String, Object>();
		param2.put("buildingId", buildingId);
		param2.put("type", 2);
		param2.put("distance", 1500);
		List<TrafficDataSet> list_2 = trafficScoreDetailDao.findTrafficDataSetByBuildingIdAndType(param2);
		List<Station> stations_trolley = LineInfoDao.findStationByBuildingIdAndTypeAndDistance(param2);
		stations.addAll(stations_trolley);
		if(list_2.size() > 0 && list_2 != null){
			TrafficInfo trafficInfo2 = new TrafficInfo();
			trafficInfo2.setType("有轨电车");
			for (TrafficDataSet data : list_2) {
				data.setDistance("距离" + data.getDistance() + "m");
			}
			trafficInfo2.setData(list_2);
			trafficInfos.add(trafficInfo2);
		}
		if(result != null){
			result.setTrafficInfos(trafficInfos);
			result.setStations(stations);
		}
		
		return result;
	}

}
