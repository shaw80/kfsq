package com.jzhl.kfsq.service.ba.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jzhl.kfsq.common.base.ListResult;
import com.jzhl.kfsq.common.util.Constant;
import com.jzhl.kfsq.dao.ba.IMemberEvaluateMapper;
import com.jzhl.kfsq.dataset.ba.MemberEvaluateDataSet;
import com.jzhl.kfsq.dataset.ba.MemberEvaluateList;
import com.jzhl.kfsq.dto.ba.MemberEvaluatePageDto;
import com.jzhl.kfsq.entity.ba.Dimension;
import com.jzhl.kfsq.entity.ba.MemberEvaluate;
import com.jzhl.kfsq.entity.cm.BuildingComment;
import com.jzhl.kfsq.service.ba.IMemberEvaluateService;

/**
 * 用户评价业务层实现类
 * 
 * @author Shaw
 *
 */
@Service
public class MemberEvaluateServiceImpl implements IMemberEvaluateService {

	@Autowired
	IMemberEvaluateMapper memberEvaluatedao;

	/**
	 * 根据维度编码分页查询用户评价
	 * 
	 * @param dto
	 * @return
	 */
	@Override
	public MemberEvaluateDataSet findMemberEvaluateDataSetByDimensionCode(MemberEvaluatePageDto dto) {
		if (dto.getDimensionCode().equals("1")) {
			dto.setDimensionCode(Constant.UNITMAP);
		} else if (dto.getDimensionCode().equals("2")) {
			dto.setDimensionCode(Constant.COMMUNITYQUALITY);
		} else if (dto.getDimensionCode().equals("3")) {
			dto.setDimensionCode(Constant.EDUCATION);
		} else if (dto.getDimensionCode().equals("4")) {
			dto.setDimensionCode(Constant.AROUND);
		} else {
			dto.setDimensionCode(Constant.TRAFFIC);
		}
		dto.setOffset(20);
		MemberEvaluateDataSet result = new MemberEvaluateDataSet();
		List<MemberEvaluateList> list = memberEvaluatedao.findMemberEvaluateDataSetByDimensionCode(dto);
		int count = memberEvaluatedao.countMemberEvaluateDataSetByDimensionCode(dto);
		ListResult listResult = new ListResult();
		listResult.setDataCount(count);
		listResult.setDataList(list);
		result.setCount(count);
		result.setListResult(listResult);
		return result;
	}

	/**
	 * 根据评论ID，评论人ID查询其对该楼盘打分情况
	 * 
	 * @author zhouzy
	 * 
	 * @param buildingComment
	 */
	@Override
	public List<MemberEvaluate> getMemberEvaluateList(BuildingComment buildingComment) {
		List<MemberEvaluate> result = memberEvaluatedao.getMemberEvaluateList(buildingComment);
		return result;
	}

	/**
	 * 查询用户端维度权重
	 * 
	 * @author zhouzy
	 * 
	 */
	@Override
	public List<Dimension> getDimensionList() {
		List<Dimension> result = memberEvaluatedao.getDimensionList();
		return result;
	}
}
