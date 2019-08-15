package com.jzhl.kfsq.dao.cm;

import java.util.List;

import com.jzhl.kfsq.dataset.cm.BuildingCommentDataSet;
import com.jzhl.kfsq.dataset.cm.CommentReplyDataSet;
import com.jzhl.kfsq.dto.cm.BuildingCommentPageDto;
import com.jzhl.kfsq.dto.cm.CommentReplyDto;

public interface IBuildingCommentDtoMapper {
	
	public List<BuildingCommentDataSet> findBuildingCommentPage(BuildingCommentPageDto buildingCommentPageDto);
	
	public List<BuildingCommentDataSet> findBuildingCommentPageByAuditStatus(BuildingCommentPageDto buildingCommentPageDto);

	public int findBuildingCommentPageCount(BuildingCommentPageDto buildingCommentPageDto);
	
	public int findBuildingCommentPageCountByAuditStatus(BuildingCommentPageDto buildingCommentPageDto);

	public List<CommentReplyDataSet> findBuildingCommentReplyPage(CommentReplyDto commentReplyDto);
	
	public java.lang.Integer findBuildingCommentReplyCount(CommentReplyDto commentReplyDto);

	public BuildingCommentDataSet getBuildingCommentDataSet(Integer commentId);

}
