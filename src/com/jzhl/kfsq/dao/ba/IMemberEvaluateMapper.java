package com.jzhl.kfsq.dao.ba;

import java.util.List;

import com.jzhl.kfsq.dataset.ba.MemberEvaluateList;
import com.jzhl.kfsq.dataset.ba.MemberScoreDataSet;
import com.jzhl.kfsq.dto.ba.MemberEvaluatePageDto;
import com.jzhl.kfsq.entity.ba.Dimension;
import com.jzhl.kfsq.entity.ba.MemberEvaluate;
import com.jzhl.kfsq.entity.cm.BuildingComment;

public interface IMemberEvaluateMapper {

	/**
	 * 插入用户评价维度信息
	 * 
	 * @param memberEvaluate
	 * @return
	 */
	public void insertMemberEvaluate(MemberEvaluate memberEvaluate);

	/**
	 * 根据评论ID取得维度权重总值
	 * 
	 * @param commentId
	 * @return BigDecimal
	 */
	public Integer getDimensionWeightSumValueByCommentId(Integer commentId);

	/**
	 * 根据维度编码分页查询用户评价
	 * 
	 * @param dto
	 * @return
	 */
	public List<MemberEvaluateList> findMemberEvaluateDataSetByDimensionCode(MemberEvaluatePageDto dto);

	/**
	 * 根据维度编码统计用户评价总数
	 * 
	 * @param dto
	 * @return
	 */
	public int countMemberEvaluateDataSetByDimensionCode(MemberEvaluatePageDto dto);

	/**
	 * 根据评论ID，评论人ID查询其对该楼盘打分情况
	 * 
	 * @author zhouzy
	 * 
	 * @param buildingComment
	 */
	public List<MemberEvaluate> getMemberEvaluateList(BuildingComment buildingComment);

	/**
	 * 查询用户端维度权重
	 * 
	 * @author zhouzy
	 * 
	 */
	public List<Dimension> getDimensionList();

	/**
	 * 查询评论列表；根据楼盘ID
	 * 
	 * @author zhouzy
	 * 
	 */
	public List<MemberEvaluate> findMemberEvaluateList(Integer buildingId);

	/**
	 * 五个维度的评分
	 * 
	 * @author zhouzy
	 * 
	 */
	public List<MemberScoreDataSet> findBuildingScore(Integer commentId);

}
