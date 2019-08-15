package com.jzhl.kfsq.dao.fm;

import java.util.List;

import com.jzhl.kfsq.entity.fm.CommentEnvelopeChance;

/**
 * 红包管理-评论红包
 * 
 * @author zhouzy
 *
 */
public interface ICommentEnvelopeChanceMapper {

	/**
	 * 评论红包添加
	 */
	public void insertCommentEnvelopeChance(CommentEnvelopeChance commentEnvelopeChance);

	/**
	 * 评论红包编辑
	 */
	public void updateCommentEnvelopeChance(CommentEnvelopeChance commentEnvelopeChance);

	/**
	 * 评论红包规则列表
	 * 
	 */
	public List<CommentEnvelopeChance> findCommentEnvelopeChanceList(CommentEnvelopeChance commentEnvelopeChance);

}
