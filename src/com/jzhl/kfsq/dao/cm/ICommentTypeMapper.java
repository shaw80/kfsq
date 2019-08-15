package com.jzhl.kfsq.dao.cm;

import java.util.List;
import java.util.Map;

import com.jzhl.kfsq.entity.cm.CommentType;

public interface ICommentTypeMapper {

	/**
	 * 根据commentId获取对应数据列表
	 * 
	 */
	public List<CommentType> findCommentTypeList(Map<String, Object> map);

	/**
	 * 先按品论Id删除原有数据
	 * 
	 */
	public void deleteCommentTypeList(Map<String, Object> map);

	/**
	 * 插入数据
	 * 
	 */
	public void saveCommentType(CommentType commentType);

}
