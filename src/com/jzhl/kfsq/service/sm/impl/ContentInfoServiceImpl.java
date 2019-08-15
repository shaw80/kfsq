package com.jzhl.kfsq.service.sm.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jzhl.kfsq.dao.sm.IContentInfoMapper;
import com.jzhl.kfsq.entity.sm.ContentInfo;
import com.jzhl.kfsq.service.sm.IContentInfoService;

/**
 * 内容信息业务层实现类
 * 
 * @author Shaw
 *
 */
@Service
public class ContentInfoServiceImpl implements IContentInfoService {

	@Autowired
	private IContentInfoMapper contentInfoDao;

	/**
	 * 添加内容信息
	 * 
	 * @param ci
	 */
	@Override
	public void insertContentInfo(ContentInfo ci) {
		contentInfoDao.insertContentInfo(ci);
	}

	/**
	 * 删除内容信息
	 * 
	 * @param contentId
	 */
	@Override
	public void deleteContentInfo(int contentId) {
		contentInfoDao.deleteContentInfo(contentId);
	}

	/**
	 * 更新内容信息
	 * 
	 * @param ci
	 */
	@Override
	public void updateContentInfo(ContentInfo ci) {
		contentInfoDao.updateContentInfo(ci);
	}

	/**
	 * 根据内容编号查询内容信息
	 * 
	 * @param contentId
	 * @return
	 */
	@Override
	public ContentInfo getContentInfo(int contentId) {
		ContentInfo content = contentInfoDao.getContentInfo(contentId);
		return content;
	}

	/**
	 * 根据内容类型查询内容信息
	 * 
	 * @param contentType
	 * @return
	 */
	@Override
	public List<ContentInfo> findContentInfoByContentType(int contentType) {
		List<ContentInfo> result = contentInfoDao.findContentInfoByContentType(contentType);
		return result;
	}

	/**
	 * 查看文本内容信息表信息
	 * 
	 * @author zhouzy
	 */
	@Override
	public ContentInfo getContentInfoByObj(ContentInfo contentInfo) {
		ContentInfo result = contentInfoDao.getContentInfoByObj(contentInfo);
		return result;
	}

}
