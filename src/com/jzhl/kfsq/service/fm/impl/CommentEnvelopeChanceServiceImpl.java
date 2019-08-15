package com.jzhl.kfsq.service.fm.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jzhl.kfsq.dao.fm.ICommentEnvelopeChanceMapper;
import com.jzhl.kfsq.entity.fm.CommentEnvelopeChance;
import com.jzhl.kfsq.service.fm.ICommentEnvelopeChanceService;

/**
 * 红包管理-评论红包
 * 
 * @author zhouzy
 *
 */
@Service
public class CommentEnvelopeChanceServiceImpl implements ICommentEnvelopeChanceService {

	@Autowired
	private ICommentEnvelopeChanceMapper commentEnvelopeChanceDao;

	/**
	 * 评论红包规则添加
	 */
	@Override
	public void insertCommentEnvelopeChance(CommentEnvelopeChance commentEnvelopeChance) {
		commentEnvelopeChanceDao.insertCommentEnvelopeChance(commentEnvelopeChance);
	}

	/**
	 * 评论红包规则编辑
	 */
	@Override
	public void updateCommentEnvelopeChance(CommentEnvelopeChance commentEnvelopeChance) {
		commentEnvelopeChanceDao.updateCommentEnvelopeChance(commentEnvelopeChance);
	}

	/**
	 * 评论红包规则列表
	 * 
	 */
	@Override
	public List<CommentEnvelopeChance> findCommentEnvelopeChanceList(CommentEnvelopeChance commentEnvelopeChance) {
		List<CommentEnvelopeChance> result = commentEnvelopeChanceDao.findCommentEnvelopeChanceList(commentEnvelopeChance);
		return result;
	}
}
