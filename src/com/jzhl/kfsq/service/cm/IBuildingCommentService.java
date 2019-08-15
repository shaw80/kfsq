package com.jzhl.kfsq.service.cm;

import java.util.List;
import java.util.Map;

import com.jzhl.kfsq.common.base.ListResult;
import com.jzhl.kfsq.dataset.cm.AllCommentDataSet;
import com.jzhl.kfsq.dataset.cm.BuildingCommentDataSet;
import com.jzhl.kfsq.dto.cm.MyCommentDto;
import com.jzhl.kfsq.dto.cm.MyCommentParamDto;
import com.jzhl.kfsq.dto.pm.IsVisitDto;
import com.jzhl.kfsq.entity.cm.BuildingComment;
import com.jzhl.kfsq.entity.cm.CommentImg;

public interface IBuildingCommentService {

	/**
	 * 评论管理-关注发表列表
	 */
	public List<BuildingCommentDataSet> findBuildingCommentList(
			Map<String, Object> map);

	/**
	 * 评论管理-关注发表列表总数
	 */
	public int findBuildingCommentDataCount(Map<String, Object> map);

	/**
	 * 评论管理-查看详情
	 */
	public BuildingCommentDataSet getBuildingCommentInfo(
			BuildingComment buildingComment);

	/**
	 * 评论管理-查看详情-commentId 查看图片
	 */
	public List<CommentImg> findCommentImgList(BuildingComment buildingComment);

	/**
	 * 审核通过、不通过
	 */
	public void updateBuildingComment(BuildingComment buildingComment);

	/**
	 * 根据会员编号和楼盘编号，判断是否未发表过评论
	 * 
	 * @param dto
	 * @return
	 */
	public Boolean isNoComment(IsVisitDto dto);

	/**
	 * 根据会员编号和楼盘编号查询我的评价
	 * 
	 * @param dto
	 * @return
	 */
	public ListResult findMyCommentByMemberIdAndBuildingId(MyCommentParamDto dto);
	
	/**
	 * 楼盘详情统计评论数
	 * @param dto
	 * @return
	 */
	public Integer countComment(MyCommentParamDto dto);
	
	/**
	 * 根据评价类型返回的数量
	 * 
	 * @param dto
	 * @return
	 */
	public Integer countCommentByCommentType(MyCommentDto dto);
	
	/**
	 * 根据好评、差评查询评论数
	 * @param dto
	 * @return
	 */
	public Integer countCommentByComparValue(MyCommentDto dto);
	
	/**
	 * 根据好评、差评查询列表
	 * 好评，差评
	 * @param dto
	 * @return ListResult
	 */
	public ListResult findCommentByBuildingIdAndMemberIdAndComparType(MyCommentDto dto);
	
	/**
	 * 根据评论类型查询列表
	 * @param dto
	 * @return
	 */
	public ListResult findCommentByBuildingIdAndMemberIdAndCommentType(MyCommentDto dto);
	
	/**
	 * 根据楼盘编号查询我的评价（我的-我的评价）
	 * 
	 * @param dto
	 * @return
	 */
	public ListResult findMyCommentByMemberId(MyCommentParamDto dto);
	
	/**
	 * 楼盘评价-全部评价
	 * @param dto
	 * @return
	 */
	public ListResult findAllCommentByBuildingIdAndMemberId(MyCommentParamDto dto);
	
	/**
	 * 查询所有类型评论数
	 * @param dto
	 * @return
	 */
	public AllCommentDataSet findCommentTypeCount(MyCommentDto dto);
	
}
