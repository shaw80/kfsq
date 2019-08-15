package com.jzhl.kfsq.dao.bm;

import com.jzhl.kfsq.dataset.bm.UnitMapScoreDetail;

/**
 * 户型分数详情数据访问层接口
 * 
 * @author Shaw
 *
 */
public interface IUnitMapScoreDetailMapper {
	
	/**
	 * 根据楼盘编号查询户型分数详情
	 * 
	 * @param buildingId
	 * @return
	 */
	public UnitMapScoreDetail getUnitMapScoreDetail(int buildingId);

}
