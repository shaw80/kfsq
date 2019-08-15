package com.jzhl.kfsq.service.ba;

import java.util.List;

import com.jzhl.kfsq.dataset.ba.MemberEvaluateDataSet;
import com.jzhl.kfsq.dto.ba.MemberEvaluatePageDto;
import com.jzhl.kfsq.entity.ba.Dimension;
import com.jzhl.kfsq.entity.ba.MemberEvaluate;
import com.jzhl.kfsq.entity.cm.BuildingComment;

/**
 * 用户评价业务层接口
 * 
 * @author Shaw
 *
 */
public interface IMemberEvaluateService {

	/**
	 * 根据维度编码分页查询用户评价
	 * 
	 * @param dto
	 * @return
	 */
	public MemberEvaluateDataSet findMemberEvaluateDataSetByDimensionCode(MemberEvaluatePageDto dto);

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

}
