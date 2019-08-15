package com.jzhl.kfsq.service.bm;

import com.jzhl.kfsq.dataset.bm.CommunityQualityDataSet;
import com.jzhl.kfsq.dto.bm.CommunityQualityDto;
import com.jzhl.kfsq.entity.bm.CommunityQuality;

/**
 * 社区品质业务接口
 * 
 * @author zhouzy
 *
 */
public interface ICommunityQualityService {

	/**
	 * 获取社区品质详情
	 * 
	 * @param buildingId
	 * @return
	 */
	public CommunityQualityDataSet getCommunityQuality(CommunityQualityDto dto);

	/**
	 * 更新社区品质信息
	 * 
	 */
	public void updateCommunityQuality(CommunityQuality communityQuality);

	/**
	 * 新增社区品质信息
	 * 
	 */
	public void insertCommunityQuality(CommunityQuality communityQuality);

}
