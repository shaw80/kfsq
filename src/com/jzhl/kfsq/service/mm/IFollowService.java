package com.jzhl.kfsq.service.mm;

import java.util.List;

import com.jzhl.kfsq.entity.mm.Follow;


public interface IFollowService {

	public Follow insertFollow(Follow follow);

	public void updateFollow(Follow follow);

	public List<Follow> findFollow(Follow follow);

}
