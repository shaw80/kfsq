package com.jzhl.kfsq.service.bm.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jzhl.kfsq.dao.bm.ICommunityQualityMapper;
import com.jzhl.kfsq.dataset.bm.CommunityQualityDataSet;
import com.jzhl.kfsq.dto.bm.CommunityQualityDto;
import com.jzhl.kfsq.entity.bm.CommunityQuality;
import com.jzhl.kfsq.service.bm.ICommunityQualityService;

/**
 * 社区品质业务接口
 * 
 * @author zhouzy
 *
 */
@Service
public class CommunityQualityServiceImpl implements ICommunityQualityService {

	@Autowired
	private ICommunityQualityMapper communityQualityDao;

	/**
	 * 获取社区品质详情
	 * 
	 * @param buildingId
	 * @return
	 */
	@Override
	public CommunityQualityDataSet getCommunityQuality(CommunityQualityDto dto) {
		CommunityQualityDataSet result = communityQualityDao.getCommunityQuality(dto);
		return result;
	}

	/**
	 * 更新社区品质信息
	 * 
	 */
	@Override
	public void updateCommunityQuality(CommunityQuality communityQuality) {
		communityQualityDao.updateCommunityQuality(communityQuality);

	}

	/**
	 * 新增社区品质信息
	 * 
	 */
	@Override
	public void insertCommunityQuality(CommunityQuality communityQuality) {
		communityQualityDao.insertCommunityQuality(communityQuality);
	}

}
