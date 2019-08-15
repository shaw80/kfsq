package com.jzhl.kfsq.service.cm;

import java.util.List;
import java.util.Map;

import com.jzhl.kfsq.dataset.cm.ChatCommentDataSet;
import com.jzhl.kfsq.entity.cm.ChatComment;
import com.jzhl.kfsq.entity.cm.CommentImg;

public interface IChatCommentService {

	/**
	 * 评论管理-问问发表列表
	 */
	public List<ChatCommentDataSet> findChatCommentList(Map<String, Object> map);

	/**
	 * 评论管理-问问发表列表总数
	 */
	public int findChatCommentDataCount(Map<String, Object> map);

	/**
	 * 评论管理-查看详情
	 */
	public ChatCommentDataSet getChatCommentInfo(ChatComment chatComment);

	/**
	 * 评论管理-查看详情-commentId 查看图片
	 */
	public List<CommentImg> findCommentImgList(ChatComment chatComment);

	/**
	 * 审核通过、不通过
	 */
	public void updateChatComment(ChatComment chatComment);

}
