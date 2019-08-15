package com.jzhl.kfsq.service.bm;

import com.jzhl.kfsq.dataset.bm.TrafficScoreDetail;

/**
 * 交通分数详情业务层接口
 * 
 * @author Shaw
 *
 */
public interface ITrafficScoreDetailService {

	/**
	 * 根据楼盘编号查询交通分数详情
	 * 
	 * @param buildingId
	 * @return
	 */
	public TrafficScoreDetail getTrafficScoreDetail(int buildingId);

}
