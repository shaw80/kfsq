package com.jzhl.kfsq.dao.mm;

import java.util.List;

import com.jzhl.kfsq.entity.mm.Follow;

public interface IFollowMapper {

	public void insertFollow(Follow follow);
	
	public void updateFollow(Follow follow);

	public List<Follow> findFollow(Follow follow);

}
