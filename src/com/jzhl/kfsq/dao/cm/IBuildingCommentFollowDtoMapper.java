package com.jzhl.kfsq.dao.cm;

import java.util.List;

import com.jzhl.kfsq.dataset.cm.BuildingCommentFollowDataSet;
import com.jzhl.kfsq.dataset.cm.NewestFollowInfoDataSet;
import com.jzhl.kfsq.dto.cm.BuildingCommentFollowPageDto;

public interface IBuildingCommentFollowDtoMapper {

	public List<BuildingCommentFollowDataSet> findBuildingCommentFollowPage(BuildingCommentFollowPageDto buildingCommentFollowPageDto);

	public int findBuildingCommentFollowPageCount(BuildingCommentFollowPageDto buildingCommentFollowPageDto);
	
	public NewestFollowInfoDataSet getBuildingCommentFollowNewestInfo(java.lang.Integer creatorUserId);
	
}
