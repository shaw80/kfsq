package com.jzhl.kfsq.service.bm;

import com.jzhl.kfsq.dataset.bm.AroundScoreDetail;

/**
 * 周边分数详情业务层接口
 * 
 * @author mac
 *
 */
public interface IAroundScoreDetailService {

	/**
	 * 根据楼盘编号查询周边分数详情
	 * 
	 * @param buildingId
	 * @return
	 */
	public AroundScoreDetail getAroundScoreDetail(int buildingId);

}
