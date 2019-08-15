package com.jzhl.kfsq.service.cm.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jzhl.kfsq.common.base.ListResult;
import com.jzhl.kfsq.dao.ba.IDimensionMapper;
import com.jzhl.kfsq.dao.ba.IMemberEvaluateMapper;
import com.jzhl.kfsq.dao.cm.IAppRemindMapper;
import com.jzhl.kfsq.dao.cm.IBuildingCommentDtoMapper;
import com.jzhl.kfsq.dao.cm.IBuildingCommentFollowDtoMapper;
import com.jzhl.kfsq.dao.cm.IBuildingCommentMapper;
import com.jzhl.kfsq.dao.cm.IChatCommentDtoMapper;
import com.jzhl.kfsq.dao.cm.IChatCommentMapper;
import com.jzhl.kfsq.dao.cm.ICommentImgMapper;
import com.jzhl.kfsq.dataset.cm.AppRemindDataSet;
import com.jzhl.kfsq.dataset.cm.BuildingCommentDataSet;
import com.jzhl.kfsq.dataset.cm.BuildingCommentFollowDataSet;
import com.jzhl.kfsq.dataset.cm.BuildingCommentReceiveDataSet;
import com.jzhl.kfsq.dataset.cm.ChatCommentDataSet;
import com.jzhl.kfsq.dataset.cm.GiftBuildingCommentDataSet;
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
import com.jzhl.kfsq.service.cm.ICommentService;


@Service
public class CommentServiceImpl implements ICommentService {
	@Autowired
	private IBuildingCommentMapper buildingCommentDao;
	@Autowired
	private IBuildingCommentDtoMapper buildingCommentDtoDao;
	@Autowired
	private ICommentImgMapper commentImgDao;
	@Autowired
	private IChatCommentMapper chatCommentDao;
	@Autowired
	private IChatCommentDtoMapper chatCommentDtoDao;
	@Autowired
	private IAppRemindMapper appRemindDao;
	@Autowired
	private IBuildingCommentFollowDtoMapper buildingCommentFollowDtoDao;
	@Autowired
	private IMemberEvaluateMapper memberEvaluateDao;
	@Autowired
	private IDimensionMapper dimensionDao;

	@Override
	public void addBuildingComment(BuildingComment buildingComment) {
		buildingCommentDao.insertBuildingComment(buildingComment);
	}
	
	@Override
	public void addMemberEvaluate(MemberEvaluate memberEvaluate) {
		memberEvaluateDao.insertMemberEvaluate(memberEvaluate);
	}
	
	@Override
	public Dimension getDimension() {
		return dimensionDao.getDimension();
	}

	@Override
	public void addCommentImg(CommentImg commentImg) {
		commentImgDao.insertCommentImg(commentImg);
	}
	
	@Override
	public void addChatComment(ChatComment chatComment) {
		chatCommentDao.insertChatComment(chatComment);
	}
	
	@Override
	public List<CommentImg> findCommentImg(CommentImg commentImg) {
		return commentImgDao.findCommentImg(commentImg);
	}

	/**
	 * 查询楼盘评论
	 */
	@Override
	public ListResult findBuildingCommentPage(BuildingCommentPageDto buildingCommentPageDto) {
		ListResult result = new ListResult();
		List<BuildingCommentDataSet> dataList = buildingCommentDtoDao.findBuildingCommentPageByAuditStatus(buildingCommentPageDto);
		int dataCount = buildingCommentDtoDao.findBuildingCommentPageCountByAuditStatus(buildingCommentPageDto);
		result.setDataList(dataList);
		result.setDataCount(dataCount);
		return result;
	}

	@Override
	public List<ChatCommentDataSet> findChatCommentPageList(ChatCommentPageDto chatCommentPageDto) {
		return chatCommentDtoDao.findChatCommentPage(chatCommentPageDto);
	}
	
	
	@Override
	public int findChatCommentPageCount(ChatCommentPageDto chatCommentPageDto) {
		return chatCommentDtoDao.findChatCommentPageCount(chatCommentPageDto);
	}
	
	@Override
	public List<AppRemindDataSet> findAppRemindPageList(AppRemindPageDto appRemindPageDto) {
		return appRemindDao.findAppRemindPage(appRemindPageDto);
	}
	
	@Override
	public int findAppRemindPageCount(AppRemindPageDto appRemindPageDto) {
		return appRemindDao.findAppRemindPageCount(appRemindPageDto);
	}
	
	@Override
	public List<BuildingCommentFollowDataSet> findBuildingCommentFollowPageList(BuildingCommentFollowPageDto buildingCommentFollowPageDto) {
		return buildingCommentFollowDtoDao.findBuildingCommentFollowPage(buildingCommentFollowPageDto);
	}
	
	@Override
	public int findBuildingCommentFollowPageCount(BuildingCommentFollowPageDto buildingCommentFollowPageDto) {
		return buildingCommentFollowDtoDao.findBuildingCommentFollowPageCount(buildingCommentFollowPageDto);
	}
	
	@Override
	public ChatCommentDataSet getChatCommentDataSet(java.lang.Integer commentId) {
		return chatCommentDtoDao.getChatCommentDataSet(commentId);
	}
	
	@Override
	public BuildingCommentDataSet getBuildingCommentDataSet(java.lang.Integer commentId) {
		return buildingCommentDtoDao.getBuildingCommentDataSet(commentId);
	}
	
	@Override
	public ListResult findChatCommentReplyDataSet(CommentReplyDto chatCommentReplyDto){
		ListResult result = new ListResult();
		result.setDataList(chatCommentDtoDao.findChatCommentReplyPage(chatCommentReplyDto));
		result.setDataCount(chatCommentDtoDao.findChatCommentReplyCount(chatCommentReplyDto));
		return result;
	}
	
	@Override
	public ListResult findBuildingCommentReplyDataSet(CommentReplyDto commentReplyDto) {
		ListResult result = new ListResult();
		result.setDataList(buildingCommentDtoDao.findBuildingCommentReplyPage(commentReplyDto));
		result.setDataCount(buildingCommentDtoDao.findBuildingCommentReplyCount(commentReplyDto));
		return result;
	}
	
	@Override
	public NewestFollowInfoDataSet getBuildingCommentFollowNewestInfo(java.lang.Integer creatorUserId) {
		return buildingCommentFollowDtoDao.getBuildingCommentFollowNewestInfo(creatorUserId);
	}

	/**
	 * 根据会员编号分页查询已发表看房有礼
	 * 
	 * @param memberId
	 * @param begin
	 * @param length
	 * @return
	 */
	@Override
	public ListResult findGiftBuildingCommentDataSet(
			int memberId, int begin, int length) {
		
		ListResult result = new ListResult();
		
		List<GiftBuildingCommentDataSet> dataList = new ArrayList<GiftBuildingCommentDataSet>();
		
		Map<String, Object> params = new HashMap<String, Object>();
		
		params.put("creatorUserId", memberId);
		
		params.put("begin", begin);
		
		params.put("length", length);
		
		List<BuildingCommentReceiveDataSet> comments = new ArrayList<BuildingCommentReceiveDataSet>();
		
		comments = buildingCommentDao.findBuildingCommentBycreatorIdByPage(params);
			
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		
		for (int i = 0; i < comments.size(); i++) {
			
			GiftBuildingCommentDataSet dataSet = new GiftBuildingCommentDataSet();
			
			dataSet.setCommentId(comments.get(i).getCommentId());
			
			dataSet.setBuildingName(comments.get(i).getBuildingName());
			
			dataSet.setContent(comments.get(i).getContent());
			
			dataSet.setCreateTime(sdf.format(comments.get(i).getCreateTime()));
			
			dataSet.setImgs(commentImgDao.findCommentImgByCommentId(comments.get(i).getCommentId()));
			
			dataList.add(dataSet);
			
		}
		
		int count = buildingCommentDao.countBuildingCommentBycreatorIdByPage(memberId);
		
		result.setDataList(dataList);
		
		result.setDataCount(count);
		
		return result;
	}

}
