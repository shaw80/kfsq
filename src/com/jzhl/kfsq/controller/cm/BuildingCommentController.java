package com.jzhl.kfsq.controller.cm;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jzhl.kfsq.common.base.ListResult;
import com.jzhl.kfsq.common.base.ResponseBean;
import com.jzhl.kfsq.common.util.Constant;
import com.jzhl.kfsq.dataset.cm.AllCommentDataSet;
import com.jzhl.kfsq.dataset.cm.BuildingCommentDataSet;
import com.jzhl.kfsq.dto.cm.BuildingCommentDto;
import com.jzhl.kfsq.dto.cm.MyCommentDto;
import com.jzhl.kfsq.dto.cm.MyCommentParamDto;
import com.jzhl.kfsq.dto.pm.IsVisitDto;
import com.jzhl.kfsq.entity.ba.Dimension;
import com.jzhl.kfsq.entity.ba.MemberEvaluate;
import com.jzhl.kfsq.entity.cm.BuildingComment;
import com.jzhl.kfsq.entity.cm.CommentImg;
import com.jzhl.kfsq.entity.cm.CommentType;
import com.jzhl.kfsq.service.ba.IMemberEvaluateService;
import com.jzhl.kfsq.service.cm.IBuildingCommentService;
import com.jzhl.kfsq.service.cm.ICommentTypeService;

/**
 * 评论管理-关注发表
 * 
 * @author zhouzy
 */
@Controller
public class BuildingCommentController {

	@Autowired
	private IBuildingCommentService buildingCommentService;

	@Autowired
	private ICommentTypeService commentTypeService;

	@Autowired
	private IMemberEvaluateService memberEvaluateService;

	/**
	 * 评论管理-关注发表列表
	 * 
	 * @return ResponseBean
	 */
	@SuppressWarnings({ "rawtypes" })
	@RequestMapping(value = "/serv/buildingcomment/findbuildingcommentlist", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean findBuildingCommentList(BuildingCommentDto buildingCommentDto) throws Exception {
		// 分页查询参数
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("rowstart", buildingCommentDto.getRowStart());
		map.put("offset", buildingCommentDto.getOffset());

		// 查询条件参数
		map.put("buildingName", buildingCommentDto.getBuildingName());
		map.put("isValid", buildingCommentDto.getIsValid());
		map.put("agentId", buildingCommentDto.getAgentId());
		map.put("auditStatus", buildingCommentDto.getAuditStatus());
		map.put("parentCommentId", buildingCommentDto.getParentCommentId());
		map.put("isCommentType", buildingCommentDto.getIsCommentType());
		map.put("unApprovedReplyNum", buildingCommentDto.getUnApprovedReplyNum());
		
		List<BuildingCommentDataSet> buildingCommentList = buildingCommentService.findBuildingCommentList(map);

		// 分页返回
		ListResult listResult = new ListResult();
		listResult.setDataList(buildingCommentList);

		// 总页数
		int dataCount = buildingCommentService.findBuildingCommentDataCount(map);
		listResult.setDataCount(dataCount);

		ResponseBean<ListResult> result = new ResponseBean<ListResult>(listResult);
		result.operateSuccess();
		return result;
	}

	// 根据评论ID查询每个评论属于哪个分类
	public List<CommentType> findCommentTypeList(Integer commentId) throws Exception {
		// 分页查询参数
		Map<String, Object> map = new HashMap<String, Object>();
		// 查询条件参数
		map.put("commentId", commentId);
		List<CommentType> commentTypeList = commentTypeService.findCommentTypeList(map);

		return commentTypeList;
	}

	/**
	 * 查询评论管理-关注发表详情
	 *
	 * @return ResponseBean
	 */
	@SuppressWarnings({ "rawtypes" })
	@RequestMapping(value = "/serv/buildingcomment/getbuildingcommentinfo", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean getBuildingCommentInfo(BuildingCommentDto buildingCommentDto) throws Exception {
		BuildingComment buildingComment = new BuildingComment();
		BeanUtils.copyProperties(buildingCommentDto, buildingComment);
		// 内容信息
		BuildingCommentDataSet buildingCommentInfo = buildingCommentService.getBuildingCommentInfo(buildingComment);

		// 维度权重
		List<Dimension> dimension = memberEvaluateService.getDimensionList();
		int unitMapWeight = 0, communityQualityWeight = 0, educationWeight = 0, aroundWeight = 0, trafficWeight = 0;
		for (int i = 0; i < dimension.size(); i++) {
			if (dimension.get(i).getDimensionCode().equals("unitMap")) {
				unitMapWeight = dimension.get(i).getWeight();
			} else if (dimension.get(i).getDimensionCode().equals("communityQuality")) {
				communityQualityWeight = dimension.get(i).getWeight();
			} else if (dimension.get(i).getDimensionCode().equals("education")) {
				educationWeight = dimension.get(i).getWeight();
			} else if (dimension.get(i).getDimensionCode().equals("around")) {
				aroundWeight = dimension.get(i).getWeight();
			} else if (dimension.get(i).getDimensionCode().equals("traffic")) {
				trafficWeight = dimension.get(i).getWeight();
			}
		}

		// 评分信息
		// '维度编码（户型：unitMap，社区品质：communityQuality，教育：education，周边配套：around，交通：traffic）',
		List<MemberEvaluate> memberEvaluate = memberEvaluateService.getMemberEvaluateList(buildingComment);
		int unitMap = 0, communityQuality = 0, education = 0, around = 0, traffic = 0, sumRrade = 0;
		for (int i = 0; i < memberEvaluate.size(); i++) {
			if (memberEvaluate.get(i).getDimensionCode().equals("unitMap")) {
				unitMap = (int) (memberEvaluate.get(i).getDimensionValue() * unitMapWeight * 0.01);
			} else if (memberEvaluate.get(i).getDimensionCode().equals("communityQuality")) {
				communityQuality = (int) (memberEvaluate.get(i).getDimensionValue() * communityQualityWeight * 0.01);
			} else if (memberEvaluate.get(i).getDimensionCode().equals("education")) {
				education = (int) (memberEvaluate.get(i).getDimensionValue() * educationWeight * 0.01);
			} else if (memberEvaluate.get(i).getDimensionCode().equals("around")) {
				around = (int) (memberEvaluate.get(i).getDimensionValue() * aroundWeight * 0.01);
			} else if (memberEvaluate.get(i).getDimensionCode().equals("traffic")) {
				traffic = (int) (memberEvaluate.get(i).getDimensionValue() * trafficWeight * 0.01);
			}
		}

		// 总分
		sumRrade = unitMap + communityQuality + education + around + traffic;

		// 图片列表
		List<CommentImg> commentImgList = buildingCommentService.findCommentImgList(buildingComment);

		Map<String, Object> queryResult = new HashMap<String, Object>();
		// 返回数据添加
		queryResult.put("buildingCommentInfo", buildingCommentInfo);
		queryResult.put("commentImgList", commentImgList);
		queryResult.put("unitMap", unitMap);
		queryResult.put("communityQuality", communityQuality);
		queryResult.put("education", education);
		queryResult.put("around", around);
		queryResult.put("traffic", traffic);
		queryResult.put("sumRrade", sumRrade);
		ResponseBean<Map<String, Object>> result = new ResponseBean<Map<String, Object>>(queryResult);
		result.operateSuccess();
		return result;
	}

	/**
	 * 审核通过、不通过
	 * 
	 * @return ResponseBean
	 */
	@SuppressWarnings({ "rawtypes" })
	@RequestMapping(value = "/serv/buildingcomment/updatebuildingcomment", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean updateBuildingComment(BuildingCommentDto buildingCommentDto) throws Exception {

		BuildingComment buildingComment = new BuildingComment();
		BeanUtils.copyProperties(buildingCommentDto, buildingComment);

		buildingCommentService.updateBuildingComment(buildingComment);
		ResponseBean result = new ResponseBean();
		result.operateSuccess();
		return result;
	}

	/**
	 * 根据会员编号和楼盘编号查询是否未发表过评论
	 * 
	 * @param dto
	 * @return
	 */
	@RequestMapping(value = "/serv/isNoComment", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean<Map<String, Object>> getIsNoComment(IsVisitDto dto) {
		Boolean isNoComment = buildingCommentService.isNoComment(dto);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("isNoComment", isNoComment);
		ResponseBean<Map<String, Object>> result = new ResponseBean<Map<String, Object>>(map);
		result.operateSuccess("查询成功");
		return result;
	}

	/**
	 * 楼盘评价-全部评价
	 * 
	 * @param dto
	 * @return
	 */
	@RequestMapping(value = "/serv/mycomment/all", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean<ListResult> findAllCommentBuilding(MyCommentDto dto) {
		MyCommentParamDto pdto = new MyCommentParamDto();
		pdto.setBuildingId(Integer.parseInt(dto.getBuildingId()));
		if (dto.getMemberId() != null) {
			pdto.setMemberId(Integer.parseInt(dto.getMemberId()));
		}
		pdto.setRowStart(dto.getRowStart());
		pdto.setOffset(20);
		ListResult listResult = buildingCommentService.findAllCommentByBuildingIdAndMemberId(pdto);
		ResponseBean<ListResult> result = new ResponseBean<ListResult>(listResult);
		result.operateSuccess("查询成功");
		return result;
	}

	/**
	 * 楼盘评价-根据好评差评查询
	 * 
	 * @param dto
	 * @return
	 */
	@RequestMapping(value = "/serv/mycomment/comparComment", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean<AllCommentDataSet> findCommentBuildingByCompar(MyCommentDto dto) {
		MyCommentDto pdto = new MyCommentDto();
		AllCommentDataSet dataSet = new AllCommentDataSet();
		pdto.setBuildingId(dto.getBuildingId());
		if (dto.getMemberId() != null) {
			pdto.setMemberId(dto.getMemberId());
		}
		pdto.setRowStart(dto.getRowStart());
		pdto.setOffset(20);
		pdto.setComparisonValue(Constant.COMPARVALUE);
		pdto.setComparisonType(dto.getComparisonType());
		dataSet = buildingCommentService.findCommentTypeCount(dto);
		ListResult listResult = buildingCommentService.findCommentByBuildingIdAndMemberIdAndComparType(pdto);
		dataSet.setDataList(listResult.getDataList());

		ResponseBean<AllCommentDataSet> result = new ResponseBean<AllCommentDataSet>(dataSet);
		result.operateSuccess("查询成功");
		return result;
	}

	/**
	 * 楼盘评价-根据评论类型查询
	 * 
	 * @param dto
	 * @return
	 */
	@RequestMapping(value = "/serv/mycomment/commentType", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean<AllCommentDataSet> findCommentBuildingByCommentType(MyCommentDto dto) {
		MyCommentDto pdto = new MyCommentDto();
		AllCommentDataSet dataSet = new AllCommentDataSet();
		pdto.setBuildingId(dto.getBuildingId());
		if (dto.getMemberId() != null) {
			pdto.setMemberId(dto.getMemberId());
		}
		pdto.setRowStart(dto.getRowStart());
		pdto.setOffset(20);
		pdto.setCommentType(dto.getCommentType());
		dataSet = buildingCommentService.findCommentTypeCount(dto);
		ListResult listResult = buildingCommentService.findCommentByBuildingIdAndMemberIdAndCommentType(pdto);
		dataSet.setDataList(listResult.getDataList());
		ResponseBean<AllCommentDataSet> result = new ResponseBean<AllCommentDataSet>(dataSet);
		result.operateSuccess("查询成功");
		return result;
	}

	/**
	 * 楼盘评价
	 * 
	 * @param dto
	 * @return
	 * @author mac
	 */
	@RequestMapping(value = "/serv/v2/mycomment/all", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean<AllCommentDataSet> findAllCommentBuildingV2(MyCommentDto dto) {
		MyCommentParamDto pdto = new MyCommentParamDto();
		AllCommentDataSet dataSet = new AllCommentDataSet();
		pdto.setBuildingId(Integer.parseInt(dto.getBuildingId()));
		if (dto.getMemberId() != null) {
			pdto.setMemberId(Integer.parseInt(dto.getMemberId()));
		}
		pdto.setRowStart(dto.getRowStart());
		pdto.setOffset(20);

		ListResult listResult = buildingCommentService.findAllCommentByBuildingIdAndMemberId(pdto);
		dataSet = buildingCommentService.findCommentTypeCount(dto);
		dataSet.setDataList(listResult.getDataList());

		ResponseBean<AllCommentDataSet> result = new ResponseBean<AllCommentDataSet>(dataSet);
		result.operateSuccess("查询成功");
		return result;
	}

	/**
	 * 楼盘评价-我的评价
	 * 
	 * @param dto
	 * @return
	 */
	@RequestMapping(value = "/serv/mycomment/buildingId", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean<ListResult> findMycommentBuilding(MyCommentDto dto) {
		MyCommentParamDto pdto = new MyCommentParamDto();
		pdto.setBuildingId(Integer.parseInt(dto.getBuildingId()));
		pdto.setMemberId(Integer.parseInt(dto.getMemberId()));
		pdto.setRowStart(dto.getRowStart());
		pdto.setOffset(20);
		ListResult listResult = buildingCommentService.findMyCommentByMemberIdAndBuildingId(pdto);
		ResponseBean<ListResult> result = new ResponseBean<ListResult>(listResult);
		result.operateSuccess("查询成功");
		return result;
	}

	/**
	 * 我的-我的评价
	 * 
	 * @param dto
	 * @return
	 */
	@RequestMapping(value = "/serv/mycomment", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean<ListResult> findMyComment(MyCommentDto dto) {
		MyCommentParamDto pdto = new MyCommentParamDto();
		pdto.setMemberId(Integer.parseInt(dto.getMemberId()));
		pdto.setRowStart(dto.getRowStart());
		pdto.setOffset(20);
		ListResult listResult = buildingCommentService.findMyCommentByMemberId(pdto);
		ResponseBean<ListResult> result = new ResponseBean<ListResult>(listResult);
		result.operateSuccess("查询成功");
		return result;
	}

	/**
	 * 根据楼盘编号统计评论数量
	 * 
	 * @param buildingId
	 * @return
	 */
	@RequestMapping(value = "/serv/v2/countComment", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean<Map<String, Object>> countBuildingComment(MyCommentParamDto dto) {
		int count = buildingCommentService.countComment(dto);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("count", count);
		ResponseBean<Map<String, Object>> result = new ResponseBean<Map<String, Object>>(map);
		result.operateSuccess("查询成功");
		return result;
	}

}
