package com.jzhl.kfsq.service.cm.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jzhl.kfsq.dao.cm.ICommentTypeMapper;
import com.jzhl.kfsq.entity.cm.CommentType;
import com.jzhl.kfsq.service.cm.ICommentTypeService;

@Service
public class CommentTypeServiceImpl implements ICommentTypeService {

	@Autowired
	private ICommentTypeMapper commentTypeDao;

	/**
	 * 根据commentId获取对应数据列表
	 * 
	 */
	@Override
	public List<CommentType> findCommentTypeList(Map<String, Object> map) {
		List<CommentType> result = commentTypeDao.findCommentTypeList(map);
		return result;
	}

	/**
	 * 先按品论Id删除原有数据
	 * 
	 */
	@Override
	public void deleteCommentTypeList(Map<String, Object> map) {
		commentTypeDao.deleteCommentTypeList(map);
	}

	/**
	 * 插入数据
	 * 
	 */
	@Override
	public void saveCommentType(CommentType commentType) {
		commentTypeDao.saveCommentType(commentType);
	}

}
