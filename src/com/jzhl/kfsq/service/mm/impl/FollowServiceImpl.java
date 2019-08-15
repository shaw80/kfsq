package com.jzhl.kfsq.service.mm.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jzhl.kfsq.dao.mm.IFollowMapper;
import com.jzhl.kfsq.entity.mm.Follow;
import com.jzhl.kfsq.service.mm.IFollowService;

@Service
public class FollowServiceImpl implements IFollowService {
	
	@Autowired
	private IFollowMapper followDao;

	@Override
	public Follow insertFollow(Follow follow) {
		followDao.insertFollow(follow);
		return follow;
	}
	
	@Override
	public void updateFollow(Follow follow) {
		followDao.updateFollow(follow);
	}

	@Override
	public List<Follow> findFollow(Follow follow) {
		return followDao.findFollow(follow);
	}

}
