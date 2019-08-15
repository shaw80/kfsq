package com.jzhl.kfsq.service.bm;

import com.jzhl.kfsq.dataset.bm.EducationScoreDetail;

/**
 * 教育分数详情业务层接口
 * 
 * @author mac
 *
 */
public interface IEducationScoreDetailService {

	/**
	 * 根据楼盘编号查询教育分数详情
	 * 
	 * @param buildingId
	 * @return
	 */
	public EducationScoreDetail getEducationScoreDetail(int buildingId);

}
