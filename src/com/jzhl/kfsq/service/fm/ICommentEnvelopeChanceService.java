package com.jzhl.kfsq.service.fm;

import java.util.List;

import com.jzhl.kfsq.entity.fm.CommentEnvelopeChance;

/**
 * 红包管理-评论红包
 * 
 * @author zhouzy
 *
 */
public interface ICommentEnvelopeChanceService {

	/**
	 * 添加紅包规则
	 * 
	 */
	public void insertCommentEnvelopeChance(CommentEnvelopeChance CommentEnvelopeChance);

	/**
	 * 编辑红包规则
	 * 
	 */
	public void updateCommentEnvelopeChance(CommentEnvelopeChance CommentEnvelopeChance);

	/**
	 * 评论红包规则列表
	 * 
	 */
	public List<CommentEnvelopeChance> findCommentEnvelopeChanceList(CommentEnvelopeChance commentEnvelopeChance);

}
