package com.jzhl.kfsq.service.cm.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jzhl.kfsq.common.base.ListResult;
import com.jzhl.kfsq.common.util.Constant;
import com.jzhl.kfsq.dao.ba.IMemberEvaluateMapper;
import com.jzhl.kfsq.dao.cm.IBuildingCommentMapper;
import com.jzhl.kfsq.dao.cm.ICommentImgMapper;
import com.jzhl.kfsq.dataset.cm.AllCommentDataSet;
import com.jzhl.kfsq.dataset.cm.BuildingCommentDataSet;
import com.jzhl.kfsq.dataset.cm.MyComment;
import com.jzhl.kfsq.dataset.cm.MyCommentImg;
import com.jzhl.kfsq.dto.cm.MyCommentDto;
import com.jzhl.kfsq.dto.cm.MyCommentParamDto;
import com.jzhl.kfsq.dto.pm.IsVisitDto;
import com.jzhl.kfsq.entity.cm.BuildingComment;
import com.jzhl.kfsq.entity.cm.CommentImg;
import com.jzhl.kfsq.service.cm.IBuildingCommentService;

@Service
public class BuildingCommentServiceImpl implements IBuildingCommentService {

	@Autowired
	private IBuildingCommentMapper buildingCommentDao;

	@Autowired
	private IMemberEvaluateMapper memberEvaluateDao;

	@Autowired
	private ICommentImgMapper commentImgDao;

	/**
	 * 评论管理-关注发表列表
	 */
	@Override
	public List<BuildingCommentDataSet> findBuildingCommentList(Map<String, Object> map) {
		List<BuildingCommentDataSet> result = buildingCommentDao.findBuildingCommentList(map);
		return result;
	}

	/**
	 * 评论管理-关注发表列表总数
	 */
	@Override
	public int findBuildingCommentDataCount(Map<String, Object> map) {
		int buildingCommentCount = buildingCommentDao.findBuildingCommentDataCount(map);
		return buildingCommentCount;
	}

	/**
	 * 评论管理-查看详情
	 */
	@Override
	public BuildingCommentDataSet getBuildingCommentInfo(BuildingComment buildingComment) {
		BuildingCommentDataSet result = buildingCommentDao.getBuildingCommentInfo(buildingComment);
		return result;
	}

	/**
	 * 评论管理-查看详情-commentId 查看图片
	 */
	@Override
	public List<CommentImg> findCommentImgList(BuildingComment buildingComment) {
		List<CommentImg> result = buildingCommentDao.findCommentImgList(buildingComment);
		return result;
	}

	/**
	 * 审核通过、不通过
	 */
	@Override
	public void updateBuildingComment(BuildingComment buildingComment) {
		buildingCommentDao.updateBuildingComment(buildingComment);
	}

	/**
	 * 根据会员编号和楼盘编号，判断是否未发表过评论
	 * 
	 * @param dto
	 * @return
	 */
	@Override
	public Boolean isNoComment(IsVisitDto dto) {
		Boolean isNoComment = false;
		List<BuildingComment> list = buildingCommentDao.findBuildingCommentByBuildingIdAndCreatorUserId(dto);
		if (list.size() == 0) {
			isNoComment = true;
		}
		return isNoComment;
	}

	/**
	 * 根据会员编号和楼盘编号查询我的评价（楼盘评价-我的评价）
	 * 
	 * @param dto
	 * @return
	 */
	@Override
	public ListResult findMyCommentByMemberIdAndBuildingId(MyCommentParamDto dto) {
		ListResult result = new ListResult();
		int count = buildingCommentDao.countMyCommentByBuildingIdAndCreatorId(dto);
		List<MyComment> list = buildingCommentDao.findMyCommentByBuildingIdAndCreatorId(dto);
		for (MyComment myComment : list) {
			List<MyCommentImg> imgs = commentImgDao.findMyCommentImgByCommentId(myComment.getCommentId());
			myComment.setImgs(imgs);
		}
		result.setDataCount(count);
		result.setDataList(list);
		return result;
	}

	/**
	 * 根据会员编号查询我的评价（我的-我的评价）
	 * 
	 * @param dto
	 * @return
	 */
	@Override
	public ListResult findMyCommentByMemberId(MyCommentParamDto dto) {
		ListResult result = new ListResult();
		int count = buildingCommentDao.countMyCommentByCreatorId(dto);
		List<MyComment> list = buildingCommentDao.findMyCommentByCreatorId(dto);
		getComentImgAndDimenValue(list);
		result.setDataCount(count);
		result.setDataList(list);
		return result;
	}

	/**
	 * 统计全部评价的数量
	 * 
	 * @param dto
	 * @return
	 */
	@Override
	public Integer countComment(MyCommentParamDto dto) {
		Integer count = buildingCommentDao.countAllCommentByBuildingIdAndMemberId(dto);
		return count;
	}

	/**
	 * 根据评价类型返回的数量
	 * 
	 * @param dto
	 * @return
	 */
	@Override
	public Integer countCommentByCommentType(MyCommentDto dto) {
		Integer count = buildingCommentDao.countCommentByBuildingIdAndMemberIdAndCommentType(dto);
		return count;
	}

	/**
	 * 根据比较值查询评论数 好评，差评
	 * 
	 * @param dto
	 * @return
	 */
	@Override
	public Integer countCommentByComparValue(MyCommentDto dto) {
		Integer count = buildingCommentDao.countCommentByBuildingIdAndMemberIdAndComparisonValue(dto);
		if (count == null) {
			return 0;
		}
		return count;
	}

	/**
	 * 根据好评 差评查询列表
	 * 
	 * @param dto
	 * @return
	 */
	@Override
	public ListResult findCommentByBuildingIdAndMemberIdAndComparType(MyCommentDto dto) {

		ListResult result = new ListResult();
		Integer count = buildingCommentDao.countCommentByBuildingIdAndMemberIdAndComparisonValue(dto);
		if (count == null) {
			count = 0;
		}
		List<MyComment> list = buildingCommentDao.findCommentByBuildingIdAndMemberIdAndComparType(dto);
		getComentImgAndDimenValue(list);
		result.setDataCount(count);
		result.setDataList(list);
		return result;

	}

	/**
	 * 查询所有类型评论数
	 * 
	 * @param dto
	 * @return
	 */
	public AllCommentDataSet findCommentTypeCount(MyCommentDto dto) {

		AllCommentDataSet dataSet = new AllCommentDataSet();
		MyCommentParamDto pdto = new MyCommentParamDto();
		pdto.setBuildingId(Integer.valueOf(dto.getBuildingId()));

		if (dto.getMemberId() != null) {
			pdto.setMemberId(Integer.valueOf(dto.getMemberId()));
		}

		// 全部数
		dto.setComparisonValue(Constant.COMPARVALUE);
		Integer dataCount = countComment(pdto);
		// 好评数
		dto.setComparisonType(Constant.POSITIVE);
		Integer positiveCount = countCommentByComparValue(dto);
		// 差评数
		dto.setComparisonType(Constant.NAGETIVE);
		Integer negativeCount = countCommentByComparValue(dto);
		// 户型数
		dto.setCommentType(Constant.APARTMENTTYPE);
		Integer apartmentCount = countCommentByCommentType(dto);
		// 社区品质数
		dto.setCommentType(Constant.COMMUNITYQUALITYTYPE);
		Integer communityQualityCount = countCommentByCommentType(dto);
		// 教育数
		dto.setCommentType(Constant.EDUCATIONTYPE);
		Integer educationCount = countCommentByCommentType(dto);
		// 交通数
		dto.setCommentType(Constant.TRAFFICTYPE);
		Integer trafficCount = countCommentByCommentType(dto);
		// 周边配套数
		dto.setCommentType(Constant.PERIPHERALSUPPORTTYPE);
		Integer peripheralSupportCount = countCommentByCommentType(dto);

		dataSet.setDataCount(dataCount);
		dataSet.setPositiveCount(String.valueOf(positiveCount));
		dataSet.setNegativeCount(String.valueOf(negativeCount));
		dataSet.setApartmentCount(String.valueOf(apartmentCount));
		dataSet.setCommunityQualityCount(String.valueOf(communityQualityCount));
		dataSet.setEducationCount(String.valueOf(educationCount));
		dataSet.setTrafficCount(String.valueOf(trafficCount));
		dataSet.setPeripheralSupportCount(String.valueOf(peripheralSupportCount));

		return dataSet;
	}

	/**
	 * 根据评论类型查询列表
	 * 
	 * @param dto
	 * @return
	 */
	@Override
	public ListResult findCommentByBuildingIdAndMemberIdAndCommentType(MyCommentDto dto) {
		ListResult result = new ListResult();
		Integer count = buildingCommentDao.countCommentByBuildingIdAndMemberIdAndCommentType(dto);
		if (count == null) {
			count = 0;
		}
		List<MyComment> list = buildingCommentDao.findCommentByBuildingIdAndMemberIdAndCommentType(dto);
		getComentImgAndDimenValue(list);
		result.setDataCount(count);
		result.setDataList(list);
		return result;

	}

	/**
	 * 楼盘评价-我的评价
	 * 
	 * @param dto
	 * @return
	 */
	@Override
	public ListResult findAllCommentByBuildingIdAndMemberId(MyCommentParamDto dto) {
		ListResult result = new ListResult();
		int count = buildingCommentDao.countAllCommentByBuildingIdAndMemberId(dto);
		List<MyComment> list = buildingCommentDao.findAllCommentByBuildingIdAndMemberId(dto);

		// 遍历所有评论，查询该条评论回复数；当本人登录时，无论回复的内容是否审批，都能看见
		for (int i = 0; i < list.size(); i++) {
			MyCommentParamDto myCommentParamDto = new MyCommentParamDto();
			myCommentParamDto.setCommentId(list.get(i).getCommentId());
			myCommentParamDto.setMemberId(dto.getMemberId());
			int replyCount = buildingCommentDao.findReplyCount(myCommentParamDto);
			list.get(i).setCount(replyCount);
		}

		getComentImgAndDimenValue(list);
		result.setDataCount(count);
		result.setDataList(list);
		return result;
	}

	/**
	 * 设置图片路径与权重值
	 * 
	 * @param dto
	 * @return
	 */
	private List<MyComment> getComentImgAndDimenValue(List<MyComment> myCommentList) {

		for (MyComment myComment : myCommentList) {
			List<MyCommentImg> imgs = commentImgDao.findMyCommentImgByCommentId(myComment.getCommentId());
			myComment.setImgs(imgs);
			// 返回权重总值
			Integer dimensionWeightSumValue = memberEvaluateDao.getDimensionWeightSumValueByCommentId(myComment.getCommentId());
			if (dimensionWeightSumValue != null) {
				myComment.setDimensionWeightSumValue(String.valueOf(dimensionWeightSumValue));
			}
		}

		return myCommentList;
	}

}
