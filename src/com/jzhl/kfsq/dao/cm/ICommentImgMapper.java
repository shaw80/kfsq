package com.jzhl.kfsq.dao.cm;

import java.util.List;

import com.jzhl.kfsq.dataset.cm.CommentImgDataSet;
import com.jzhl.kfsq.dataset.cm.MyCommentImg;
import com.jzhl.kfsq.entity.cm.CommentImg;

public interface ICommentImgMapper {

	public List<CommentImg> findCommentImg(CommentImg commentImg);

	public void insertCommentImg(CommentImg commentImg);

	/**
	 * 根据评论编号查询评论图片
	 * 
	 * @param commentId
	 *            评论编号
	 * @return 评论图片结果集
	 */
	public List<CommentImgDataSet> findCommentImgByCommentId(int commentId);
	/**
	 * 代理商根据评论编号保存评论图片
	 * 
	 * @param CommentImg
	 *            评论编号
	 * 
	 */
	public void insertAgentCommentImg(CommentImg commentImg);

	// 根据评论ID删除评论图片路径
	public void deleteImg(Integer commentId);
	
	/**
	 * 根据评论编号查询对应图片
	 * @param commentId
	 * @return
	 */
	public List<MyCommentImg> findMyCommentImgByCommentId(Integer commentId);
}
