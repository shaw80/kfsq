package com.jzhl.kfsq.dao.sm;

import java.util.List;

import com.jzhl.kfsq.entity.sm.ContentInfo;

/**
 * 内容信息数据访问层接口
 * 
 * @author Shaw
 *
 */
public interface IContentInfoMapper {

	/**
	 * 添加内容信息
	 * 
	 * @param ci
	 */
	public void insertContentInfo(ContentInfo ci);

	/**
	 * 删除内容信息
	 * 
	 * @param contentId
	 */
	public void deleteContentInfo(int contentId);

	/**
	 * 更新内容信息
	 * 
	 * @param ci
	 */
	public void updateContentInfo(ContentInfo ci);

	/**
	 * 根据内容编号查询内容信息
	 * 
	 * @param contentId
	 * @return
	 */
	public ContentInfo getContentInfo(int contentId);

	/**
	 * 根据内容类型查询内容信息
	 * 
	 * @param contentType
	 * @return
	 */
	public List<ContentInfo> findContentInfoByContentType(int contentType);

	/**
	 * 查看文本内容信息表信息
	 * 
	 * @author zhouzy
	 */
	public ContentInfo getContentInfoByObj(ContentInfo contentInfo);

}
