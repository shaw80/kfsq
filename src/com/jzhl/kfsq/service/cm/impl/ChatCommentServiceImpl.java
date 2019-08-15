package com.jzhl.kfsq.service.cm.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jzhl.kfsq.dao.cm.IChatCommentMapper;
import com.jzhl.kfsq.dataset.cm.ChatCommentDataSet;
import com.jzhl.kfsq.entity.cm.ChatComment;
import com.jzhl.kfsq.entity.cm.CommentImg;
import com.jzhl.kfsq.service.cm.IChatCommentService;

@Service
public class ChatCommentServiceImpl implements IChatCommentService {

	@Autowired
	private IChatCommentMapper chatCommentDao;

	/**
	 * 评论管理-问问发表列表
	 */
	@Override
	public List<ChatCommentDataSet> findChatCommentList(Map<String, Object> map) {
		List<ChatCommentDataSet> result = chatCommentDao.findChatCommentList(map);
		return result;
	}

	/**
	 * 评论管理-问问发表列表总数
	 */
	@Override
	public int findChatCommentDataCount(Map<String, Object> map) {
		int ChatCommentCount = chatCommentDao.findChatCommentDataCount(map);
		return ChatCommentCount;
	}

	/**
	 * 评论管理-查看详情
	 */
	@Override
	public ChatCommentDataSet getChatCommentInfo(ChatComment ChatComment) {
		ChatCommentDataSet result = chatCommentDao.getChatCommentInfo(ChatComment);
		return result;
	}

	/**
	 * 评论管理-查看详情-commentId 查看图片
	 */
	@Override
	public List<CommentImg> findCommentImgList(ChatComment ChatComment) {
		List<CommentImg> result = chatCommentDao.findCommentImgList(ChatComment);
		return result;
	}

	/**
	 * 审核通过、不通过
	 */
	@Override
	public void updateChatComment(ChatComment ChatComment) {
		chatCommentDao.updateChatComment(ChatComment);
	}

	

}
