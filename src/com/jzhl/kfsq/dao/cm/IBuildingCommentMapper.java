package com.jzhl.kfsq.dao.cm;

import java.util.List;
import java.util.Map;

import com.jzhl.kfsq.dataset.cm.AgentCommentDataSet;
import com.jzhl.kfsq.dataset.cm.BuildingCommentDataSet;
import com.jzhl.kfsq.dataset.cm.BuildingCommentReceiveDataSet;
import com.jzhl.kfsq.dataset.cm.BuildingCommentV3DataSet;
import com.jzhl.kfsq.dataset.cm.MyComment;
import com.jzhl.kfsq.dto.cm.BuildingCommentPageDto;
import com.jzhl.kfsq.dto.cm.MyCommentDto;
import com.jzhl.kfsq.dto.cm.MyCommentParamDto;
import com.jzhl.kfsq.dto.pm.IsVisitDto;
import com.jzhl.kfsq.entity.ba.MemberEvaluate;
import com.jzhl.kfsq.entity.cm.BuildingComment;
import com.jzhl.kfsq.entity.cm.CommentImg;

public interface IBuildingCommentMapper {

	// public List<BuildingComment> findBuildingComment(BuildingComment
	// buildingComment);

	public List<BuildingComment> findBuildingComment(BuildingComment buildingComment);

	public void insertBuildingComment(BuildingComment buildingComment);

	public List<BuildingComment> findBuildingCommentPage(BuildingCommentPageDto buildingCommentPageDto);

	public int findBuildingCommentPageCount(BuildingCommentPageDto buildingCommentPageDto);

	public void insertMemberEvaluate(MemberEvaluate memberEvaluate);

	/**
	 * 根据创建者编号分页查询看房圈评论
	 * 
	 * @param creatorUserId
	 * @return
	 */
	public List<BuildingCommentReceiveDataSet> findBuildingCommentBycreatorIdByPage(Map<String, Object> params);

	/**
	 * 根据创建者编号统计查询看房圈评论总数
	 * 
	 * @param memberId
	 * @return
	 */
	public Integer countBuildingCommentBycreatorIdByPage(int memberId);

	/**
	 * 评论管理-关注发表列表
	 * 
	 * @author zhouzy
	 */
	public List<BuildingCommentDataSet> findBuildingCommentList(Map<String, Object> map);

	/**
	 * 评论管理-关注发表列表总数
	 * 
	 * @author zhouzy
	 */
	public int findBuildingCommentDataCount(Map<String, Object> map);

	/**
	 * 评论管理-查看详情
	 * 
	 * @author zhouzy
	 */
	public BuildingCommentDataSet getBuildingCommentInfo(BuildingComment buildingComment);

	/**
	 * 评论管理-查看详情-commentId 查看图片
	 * 
	 * @author zhouzy
	 */
	public List<CommentImg> findCommentImgList(BuildingComment buildingComment);

	/**
	 * 审核通过、不通过
	 * 
	 * @author zhouzy
	 */
	public void updateBuildingComment(BuildingComment buildingComment);

	// public List<BuildingComment>
	// findBuildingCommentPage(BuildingCommentPageDto buildingCommentPageDto);

	// public int findBuildingCommentPageCount(BuildingCommentPageDto
	// buildingCommentPageDto);

	/**
	 * 代理添加评论
	 * 
	 * @author chih
	 */
	public int saveAgentComment(BuildingComment buildingcomment);

	/**
	 * 代理修改评论
	 * 
	 * @author chih
	 */
	public void updateAgentComment(BuildingComment buildingcomment);

	/**
	 * 查询代理评论列表
	 * */
	public List<AgentCommentDataSet> findAgentCommentList(Map<String, Object> map);

	/**
	 * 查询代理评论列表总条数
	 * */
	public int findAgentCommentCount(Map<String, Object> map);

	/**
	 * 修改评论
	 * */
	public AgentCommentDataSet getAgentComment(BuildingComment buildingcomment);

	/**
	 * 根据楼盘编号和创建者编号查询评论
	 * 
	 * @param dto
	 * @return
	 */
	public List<BuildingComment> findBuildingCommentByBuildingIdAndCreatorUserId(IsVisitDto dto);

	/**
	 * 根据楼盘编号和创建者会员编号查询评论（楼盘评价-我的评价）
	 * 
	 * @param dto
	 * @return
	 */
	public List<MyComment> findMyCommentByBuildingIdAndCreatorId(MyCommentParamDto dto);

	/**
	 * 统计根据楼盘编号和创建者会员编号查询评论总数（楼盘评价-我的评价）
	 * 
	 * @param dto
	 * @return
	 */
	public Integer countMyCommentByBuildingIdAndCreatorId(MyCommentParamDto dto);

	/**
	 * 根据创建者会员编号查询评论（我的-我的评价）
	 * 
	 * @param dto
	 * @return
	 */
	public List<MyComment> findMyCommentByCreatorId(MyCommentParamDto dto);

	/**
	 * 统计根据创建者会员编号查询评论总数（我的-我的评价）
	 * 
	 * @param dto
	 * @return
	 */
	public Integer countMyCommentByCreatorId(MyCommentParamDto dto);

	/**
	 * 楼盘评价-全部评价
	 * 
	 * @param dto
	 * @return
	 */
	public List<MyComment> findAllCommentByBuildingIdAndMemberId(MyCommentParamDto dto);

	/**
	 * 统计楼盘评价-全部评价的评论数
	 * 
	 * @param dto
	 * @return
	 */
	public Integer countAllCommentByBuildingIdAndMemberId(MyCommentParamDto dto);

	/**
	 * 根据评论类型查询评论数
	 * 
	 * @param dto
	 * @return
	 */
	public Integer countCommentByBuildingIdAndMemberIdAndCommentType(MyCommentDto dto);

	/**
	 * 根据比较值查询评论数 好评，差评
	 * 
	 * @param dto
	 * @return
	 */
	public Integer countCommentByBuildingIdAndMemberIdAndComparisonValue(MyCommentDto dto);

	/**
	 * 根据比较值返回列表 好评，差评
	 * 
	 * @param dto
	 * @return
	 */
	public List<MyComment> findCommentByBuildingIdAndMemberIdAndComparType(MyCommentDto dto);

	/**
	 * 根据评论类型返回列表
	 * 
	 * @param dto
	 * @return
	 */
	public List<MyComment> findCommentByBuildingIdAndMemberIdAndCommentType(MyCommentDto dto);

	/**
	 * 楼盘详情，根据楼盘编号查询一条时间最近的评论
	 * 
	 * @param buildingId
	 * @return
	 */
	public BuildingCommentV3DataSet getBuildingCommentV3DataSet(int buildingId);

	/**
	 * 根据评论编号计算评论分数
	 * 
	 * @param commentId
	 * @return
	 */
	public Integer getCommentScore(int commentId);

	/**
	 * 根据评论编号,memberId 算出回复数
	 * 
	 * @param commentId
	 *            ，memberId
	 * @return
	 */
	public int findReplyCount(MyCommentParamDto myCommentParamDto);

}
