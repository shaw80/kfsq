package com.jzhl.kfsq.controller.cm;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jzhl.kfsq.common.base.ListResult;
import com.jzhl.kfsq.common.base.ResponseBean;
import com.jzhl.kfsq.dao.ba.IMemberEvaluateMapper;
import com.jzhl.kfsq.dataset.cm.AppRemindDataSet;
import com.jzhl.kfsq.dataset.cm.BuildingCommentDataSet;
import com.jzhl.kfsq.dataset.cm.BuildingCommentFollowDataSet;
import com.jzhl.kfsq.dataset.cm.ChatCommentDataSet;
import com.jzhl.kfsq.dataset.cm.NewestFollowInfoDataSet;
import com.jzhl.kfsq.dto.cm.AppRemindPageDto;
import com.jzhl.kfsq.dto.cm.BuildingCommentFollowPageDto;
import com.jzhl.kfsq.dto.cm.ChatCommentPageDto;
import com.jzhl.kfsq.dto.cm.CommentReplyDto;
import com.jzhl.kfsq.dto.cm.GiftBuildingCommentDto;
import com.jzhl.kfsq.dto.cm.MyCommentParamDto;
import com.jzhl.kfsq.entity.ba.MemberEvaluate;
import com.jzhl.kfsq.entity.cm.BuildingComment;
import com.jzhl.kfsq.entity.cm.ChatComment;
import com.jzhl.kfsq.entity.cm.CommentImg;
import com.jzhl.kfsq.service.ba.IMemberEvaluateService;
import com.jzhl.kfsq.service.cm.IBuildingCommentService;
import com.jzhl.kfsq.service.cm.ICommentService;

/**
 * 楼盘和杂谈评论（考虑到共用CM_CommentImg表，所以放到一起）
 * 
 * @author henan
 */
@Controller
public class CommentController {

	private static final Logger logger = Logger.getLogger(CommentController.class);

	@Autowired
	private ICommentService commentService;

	@Autowired
	private IBuildingCommentService buildingCommentService;

	@Autowired
	private IMemberEvaluateMapper memberEvaluateDao;

	@Autowired
	private IMemberEvaluateService memberEvaluateService;

	/**
	 * 添加楼盘评论
	 * 
	 * @param BuildingComment
	 * @return
	 */
	@RequestMapping(value = "/serv/addBuildingComment", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean<BuildingComment> addBuildingComment(BuildingComment buildingComment) {
		logger.debug("[添加楼盘评论]--");
		commentService.addBuildingComment(buildingComment);
		logger.debug("[添加楼盘评论]--成功");
		return new ResponseBean<BuildingComment>(buildingComment);
	}

	/**
	 * 添加杂谈评论
	 * 
	 * @param ChatComment
	 * @return
	 */
	@RequestMapping(value = "/serv/addChatComment", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean<ChatComment> addChatComment(ChatComment chatComment) {
		commentService.addChatComment(chatComment);
		return new ResponseBean<ChatComment>(chatComment);
	}

	/**
	 * 添加用户维度评价
	 * 
	 * @param MemberEvaluate
	 * @return
	 */
	@RequestMapping(value = "/serv/addMemberEvaluate", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean<MemberEvaluate> addMemberEvaluate(MemberEvaluate memberEvaluate) {
		logger.debug("[添加用户评价]--");
		commentService.addMemberEvaluate(memberEvaluate);
		logger.debug("[添加用户评价]--成功");
		return new ResponseBean<MemberEvaluate>(memberEvaluate);
	}

	/**
	 * 添加评论图片
	 * 
	 * @param BuildingComment
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "/serv/addCommentImg", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean addCommentImg(CommentImg commentImg) {
		logger.debug("[添加评论图片]--");
		ResponseBean result = new ResponseBean();
		commentService.addCommentImg(commentImg);
		result.operateSuccess();
		return result;
	}

	/**
	 * 查询楼盘评论图片
	 * 
	 * @param commentImg
	 */
	@RequestMapping(value = "/serv/findCommentImg", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean<Map<String, Object>> findBuildingCommentImg(CommentImg commentImg) {

		List<CommentImg> commentImgList = commentService.findCommentImg(commentImg);

		Map<String, Object> param = new HashMap<String, Object>();
		param.put("dataList", commentImgList);

		return new ResponseBean<Map<String, Object>>(param);
	}

	/**
	 * 分页查询楼盘评论
	 * 
	 * @param buildingComment
	 */
	@RequestMapping(value = "/serv/findBuildingCommentPage", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean<ListResult> findBuildingCommentPage(MyCommentParamDto dto) {
		ListResult result = buildingCommentService.findAllCommentByBuildingIdAndMemberId(dto);
		return new ResponseBean<ListResult>(result);
	}

	/**
	 * 分页查询杂谈评论（看房圈-问问） （仅查询数据，不查询条数）
	 * 
	 * @param chatCommentPageDto
	 * @return
	 */
	@RequestMapping(value = "/serv/findChatCommentPage", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean<Map<String, Object>> findChatCommentPageList(ChatCommentPageDto chatCommentPageDto) {
		List<ChatCommentDataSet> dataList = commentService.findChatCommentPageList(chatCommentPageDto);
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("dataList", dataList);
		return new ResponseBean<Map<String, Object>>(result);
	}

	/**
	 * 查询杂谈评论条数（看房圈-问问）
	 * 
	 * @param chatCommentPageDto
	 * @return
	 */
	@RequestMapping(value = "/serv/findChatCommentCount", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean<Map<String, Object>> findChatCommentPageCount(ChatCommentPageDto chatCommentPageDto) {
		int dataCount = commentService.findChatCommentPageCount(chatCommentPageDto);
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("dataCount", dataCount);
		return new ResponseBean<Map<String, Object>>(result);
	}

	/**
	 * 分页查询提醒（看房圈-提醒）（仅查询数据，不查询条数）
	 * 
	 * @param chatCommentPageDto
	 * @return
	 */
	@RequestMapping(value = "/serv/findAppRemindPage", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean<Map<String, Object>> findAppRemindPageList(AppRemindPageDto appRemindPageDto) {
		List<AppRemindDataSet> dataList = commentService.findAppRemindPageList(appRemindPageDto);
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("dataList", dataList);
		return new ResponseBean<Map<String, Object>>(result);
	}

	/**
	 * 查询提醒条数（看房圈-提醒）
	 * 
	 * @param chatCommentPageDto
	 * @return
	 */
	@RequestMapping(value = "/serv/findAppRemindCount", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean<Map<String, Object>> findAppRemindPageCount(AppRemindPageDto appRemindPageDto) {
		int dataCount = commentService.findAppRemindPageCount(appRemindPageDto);
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("dataCount", dataCount);
		return new ResponseBean<Map<String, Object>>(result);
	}

	/**
	 * 分页查询关注（看房圈-关注）（仅查询数据，不查询条数）
	 * 
	 * @param appRemindPageDto
	 * @return
	 */
	@RequestMapping(value = "/serv/findBuildingCommentFollowPage", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean<Map<String, Object>> findBuildingCommentFollowPageList(BuildingCommentFollowPageDto buildingCommentFollowPageDto) {
		List<BuildingCommentFollowDataSet> dataList = commentService.findBuildingCommentFollowPageList(buildingCommentFollowPageDto);
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("dataList", dataList);
		return new ResponseBean<Map<String, Object>>(result);
	}

	/**
	 * 查询关注条数（看房圈-关注）
	 * 
	 * @param appRemindPageDto
	 * @return
	 */
	@RequestMapping(value = "/serv/findBuildingCommentFollowCount", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean<Map<String, Object>> findBuildingCommentFollowPageCount(BuildingCommentFollowPageDto buildingCommentFollowPageDto) {
		int dataCount = commentService.findBuildingCommentFollowPageCount(buildingCommentFollowPageDto);
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("dataCount", dataCount);
		return new ResponseBean<Map<String, Object>>(result);
	}

	/**
	 * 根据ID查询杂谈信息
	 * 
	 * @param commentId
	 * @return
	 */
	@RequestMapping(value = "/serv/getChatComment", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean<ChatCommentDataSet> getChatCommentDataSet(java.lang.Integer commentId) {
		logger.debug("[查询杂谈信息]--");
		ChatCommentDataSet chatCommentDataSet = commentService.getChatCommentDataSet(commentId);
		return new ResponseBean<ChatCommentDataSet>(chatCommentDataSet);
	}

	/**
	 * 根据ID查询楼盘信息
	 * 
	 * @param commentId
	 * @return
	 */
	@RequestMapping(value = "/serv/getBuildingComment", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean<BuildingCommentDataSet> getBuildingCommentDataSet(java.lang.Integer commentId) {
		logger.debug("[查询杂谈信息]--");
		BuildingCommentDataSet buildingCommentDataSet = commentService.getBuildingCommentDataSet(commentId);
		
		// 返回权重总值
		Integer dimenWeightSumValue = memberEvaluateDao.getDimensionWeightSumValueByCommentId(commentId);
		if (dimenWeightSumValue != null) {
			buildingCommentDataSet.setDimenWeightSumValue(String.valueOf(dimenWeightSumValue));
		}

		return new ResponseBean<BuildingCommentDataSet>(buildingCommentDataSet);
	}

	/**
	 * 获取关注楼盘最新的评论时间
	 * 
	 * @param creatorUserId
	 * @return
	 */
	@RequestMapping(value = "/serv/getBuildingCommentFollowNewestInfo", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean<NewestFollowInfoDataSet> getBuildingCommentFollowNewestInfo(Integer creatorUserId) {
		NewestFollowInfoDataSet newestFollowInfoDataSet = commentService.getBuildingCommentFollowNewestInfo(creatorUserId);
		return new ResponseBean<NewestFollowInfoDataSet>(newestFollowInfoDataSet);
	}

	/**
	 * 获取杂谈评论
	 * 
	 * @param commentId
	 * @return
	 */
	@RequestMapping(value = "/serv/findChatCommentReplyDataSet", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean<Map<String, Object>> findChatCommentReplyDataSet(CommentReplyDto commentReplyDto) {
		ListResult listResult = commentService.findChatCommentReplyDataSet(commentReplyDto);
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("dataList", listResult.getDataList());
		result.put("dataCount", listResult.getDataCount());
		return new ResponseBean<Map<String, Object>>(result);
	}

	/**
	 * 获取楼盘评论
	 * 
	 * @param commentId
	 * @return
	 */
	@RequestMapping(value = "/serv/findBuildingCommentReplyDataSet", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean<Map<String, Object>> findBuildingCommentReplyDataSet(CommentReplyDto commentReplyDto) {
		ListResult listResult = commentService.findBuildingCommentReplyDataSet(commentReplyDto);
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("dataList", listResult.getDataList());
		result.put("dataCount", listResult.getDataCount());
		return new ResponseBean<Map<String, Object>>(result);
	}

	/**
	 * 根据会员编号查询看房有礼已发表的看房圈评论
	 * 
	 * @param dto
	 * @return
	 */
	@RequestMapping(value = "/serv/findGiftBuildingComments", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean<ListResult> findGiftBuildingComments(GiftBuildingCommentDto dto) {

		ListResult dataList = commentService.findGiftBuildingCommentDataSet(Integer.parseInt(dto.getMemberId()), dto.getRowStart(),
				dto.getOffset());

		ResponseBean<ListResult> result = new ResponseBean<ListResult>(dataList);

		result.operateSuccess("查询成功");

		return result;
	}

}
