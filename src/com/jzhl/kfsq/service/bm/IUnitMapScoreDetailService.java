package com.jzhl.kfsq.service.bm;

import com.jzhl.kfsq.dataset.bm.UnitMapScoreDetail;
import com.jzhl.kfsq.dto.bm.UnitMapScoreDetailDto;

/**
 * 户型分数详情业务接口
 * 
 * @author Shaw
 *
 */
public interface IUnitMapScoreDetailService {
	
	/**
	 * 根据楼盘编号查询户型分数详情
	 * 
	 * @param buildingId
	 * @return
	 */
	public UnitMapScoreDetail getUnitMapScoreDetail(UnitMapScoreDetailDto dto);

}
