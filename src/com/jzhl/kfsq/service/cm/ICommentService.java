package com.jzhl.kfsq.service.cm;

import java.util.List;

import com.jzhl.kfsq.common.base.ListResult;
import com.jzhl.kfsq.dataset.cm.AppRemindDataSet;
import com.jzhl.kfsq.dataset.cm.BuildingCommentDataSet;
import com.jzhl.kfsq.dataset.cm.BuildingCommentFollowDataSet;
import com.jzhl.kfsq.dataset.cm.ChatCommentDataSet;
import com.jzhl.kfsq.dataset.cm.NewestFollowInfoDataSet;
import com.jzhl.kfsq.dto.cm.AppRemindPageDto;
import com.jzhl.kfsq.dto.cm.BuildingCommentFollowPageDto;
import com.jzhl.kfsq.dto.cm.BuildingCommentPageDto;
import com.jzhl.kfsq.dto.cm.ChatCommentPageDto;
import com.jzhl.kfsq.dto.cm.CommentReplyDto;
import com.jzhl.kfsq.entity.ba.Dimension;
import com.jzhl.kfsq.entity.ba.MemberEvaluate;
import com.jzhl.kfsq.entity.cm.BuildingComment;
import com.jzhl.kfsq.entity.cm.ChatComment;
import com.jzhl.kfsq.entity.cm.CommentImg;

public interface ICommentService {

	/**
	 * 添加楼盘评论
	 * 
	 * @param buildingComment
	 */
	public void addBuildingComment(BuildingComment buildingComment);
	
	/**
	 * 添加用户维度评价
	 * 
	 * @param memberEvaluate
	 */
	public void addMemberEvaluate(MemberEvaluate memberEvaluate);
	
	/**
	 * 查询维度字典表
	 * 
	 * @param 
	 * @return Dimension
	 */
	public Dimension getDimension();

	/**
	 * 添加评论图片
	 * 
	 * @param commentImg
	 */
	public void addCommentImg(CommentImg commentImg);
	
	/**
	 * 添加杂谈评论
	 * 
	 * @param chatComment
	 */
	public void addChatComment(ChatComment chatComment);

	/**
	 * 分页查询楼盘评论
	 * 
	 * @param BuildingComment
	 * @return
	 */
	public ListResult findBuildingCommentPage(
			BuildingCommentPageDto buildingCommentPageDto);

	/**
	 * 查询楼盘评论图片
	 * 
	 * @param CommentImg
	 * @return
	 */
	public List<CommentImg> findCommentImg(CommentImg commentImg);


	// /**
	// * 分页查询杂谈评论
	// * @param chatCommentPageDto
	// * @return
	// */
	// public ListResult findChatCommentPage(ChatCommentPageDto
	// chatCommentPageDto);

	/**
	 * 分页查询杂谈评论（仅查询数据，不查询条数）
	 * 
	 * @param chatCommentPageDto
	 * @return
	 */
	public List<ChatCommentDataSet> findChatCommentPageList(
			ChatCommentPageDto chatCommentPageDto);

	/**
	 * 查询杂谈评论条数
	 * 
	 * @param chatCommentPageDto
	 * @return
	 */
	public int findChatCommentPageCount(ChatCommentPageDto chatCommentPageDto);

	// /**
	// * 分页查询提醒
	// * @param appRemindQueryDto
	// * @return ListResult
	// */
	// public ListResult findAppRemindPage(AppRemindQueryDto appRemindQueryDto);

	/**
	 * 分页查询提醒（仅查询数据，不查询条数）
	 * 
	 * @param appRemindQueryDto
	 * @return List<AppRemindDataSet>
	 */
	public List<AppRemindDataSet> findAppRemindPageList(
			AppRemindPageDto appRemindQueryDto);

	/**
	 * 查询提醒条数
	 * 
	 * @param appRemindQueryDto
	 * @return
	 */
	public int findAppRemindPageCount(AppRemindPageDto appRemindPageDto);

	/**
	 * 分页查询关注
	 * 
	 * @param buildingCommentFollowPageDto
	 * @return
	 */
	public List<BuildingCommentFollowDataSet> findBuildingCommentFollowPageList(
			BuildingCommentFollowPageDto buildingCommentFollowPageDto);

	/**
	 * 分页关注数目
	 * 
	 * @param buildingCommentFollowPageDto
	 * @return
	 */
	public int findBuildingCommentFollowPageCount(
			BuildingCommentFollowPageDto buildingCommentFollowPageDto);

	/**
	 * 根据会员编号分页查询已发表看房有礼
	 * 
	 * @param memberId
	 * @param begin
	 * @param length
	 * @return
	 */
	public ListResult findGiftBuildingCommentDataSet(
			int memberId, int begin, int length);

	/**
	 * 根据Id查询杂谈
	 * @param commentId
	 * @return
	 */
	public ChatCommentDataSet getChatCommentDataSet(java.lang.Integer commentId);
	
	/**
	 * 根据Id查询楼盘评论
	 * @param commentId
	 * @return
	 */
	public BuildingCommentDataSet getBuildingCommentDataSet(Integer commentId);

	/**
	 * 获取关注楼盘的最新评论时间
	 * @param creatorUserId
	 * @return
	 */
	public NewestFollowInfoDataSet getBuildingCommentFollowNewestInfo(Integer creatorUserId);

	/**
	 * 查询杂谈评论详情
	 * @param commentId
	 * @return
	 */
	public ListResult findChatCommentReplyDataSet(CommentReplyDto chatCommentReplyDto);

	/**
	 * 查询楼盘评论
	 * @param commentReplyDto
	 * @return
	 */
	public ListResult findBuildingCommentReplyDataSet(CommentReplyDto commentReplyDto);
	
}
