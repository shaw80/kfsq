package com.jzhl.kfsq.dao.cm;

import java.util.List;

import com.jzhl.kfsq.dataset.cm.ChatCommentDataSet;
import com.jzhl.kfsq.dataset.cm.CommentReplyDataSet;
import com.jzhl.kfsq.dto.cm.ChatCommentPageDto;
import com.jzhl.kfsq.dto.cm.CommentReplyDto;

public interface IChatCommentDtoMapper {

	public List<ChatCommentDataSet> findChatCommentPage(ChatCommentPageDto chatCommentPageDto);

	public int findChatCommentPageCount(ChatCommentPageDto chatCommentPageDto);
	
	public ChatCommentDataSet getChatCommentDataSet(java.lang.Integer commentId);
	
	public List<CommentReplyDataSet> findChatCommentReplyPage(CommentReplyDto chatCommentReplyDto);
	
	public java.lang.Integer findChatCommentReplyCount(CommentReplyDto chatCommentReplyDto);

}
