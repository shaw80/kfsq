package com.jzhl.kfsq.service.sm.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jzhl.kfsq.dao.sm.ITagMapper;
import com.jzhl.kfsq.dataset.sm.CommentTagDataSet;
import com.jzhl.kfsq.dataset.sm.FeatureTagDataSet;
import com.jzhl.kfsq.dataset.sm.TagDataSet;
import com.jzhl.kfsq.dto.sm.TagDto;
import com.jzhl.kfsq.entity.sm.Tag;
import com.jzhl.kfsq.service.sm.ITagService;

/**
 * 标签管理
 * 
 * @author zhouzy
 *
 */
@Service
public class TagServiceImpl implements ITagService {

	@Autowired
	private ITagMapper tagDao;

	/**
	 * 获取标签特色列表
	 * 
	 */
	@Override
	public List<FeatureTagDataSet> findFeatureTagDataSet() {
		List<FeatureTagDataSet> result = tagDao.findFeatureTagDataSet();
		return result;
	}

	/**
	 * 获取楼盘首页标签列表
	 * 
	 */
	@Override
	public List<CommentTagDataSet> findCommentBuildingTagDateSet(Map<String, Object> param) {
		List<CommentTagDataSet> result = tagDao.findCommentBuildingTagDateSet(param);
		return result;
	}

	/**
	 * 获取标签列表
	 * 
	 */
	@Override
	public List<TagDataSet> findTagDateSetList(Map<String, Object> param) {
		List<TagDataSet> result = tagDao.findTagDateSetList(param);
		return result;
	}

	/**
	 * 获取户型对应标签列表
	 * 
	 */
	@Override
	public List<TagDataSet> findUnitMapTagList(Map<String, Object> param) {
		List<TagDataSet> result = tagDao.findUnitMapTagList(param);
		return result;
	}

	/**
	 * 分页查询三级标签列表
	 * 
	 */
	@Override
	public List<Tag> findThirdTags(Map<String, Object> param) {
		List<Tag> result = tagDao.findThirdTags(param);
		return result;
	}

	/**
	 * 三级标签列表总页数
	 * 
	 */
	@Override
	public int findThirdTagsDataCount(Map<String, Object> param) {
		int dataCount = tagDao.findThirdTagsDataCount(param);
		return dataCount;
	}

	/**
	 * 获取标签详情
	 * 
	 */
	@Override
	public TagDataSet getTagInfo(Map<String, Object> param) {
		TagDataSet result = tagDao.getTagInfo(param);
		return result;
	}

	/**
	 * 编辑标签
	 * 
	 * @author zhouzy
	 */
	@Override
	public void updateTagInfo(TagDto tagDto) {
		tagDao.updateTagInfo(tagDto);
	}

	/**
	 * 添加标签
	 * 
	 * @author zhouzy
	 */
	@Override
	public void addTag(Tag tag) {
		tagDao.addTag(tag);
	}

	/**
	 * 刪除标签
	 * 
	 * @author zhouzy
	 */
	@Override
	public void deleteTag(Tag tag) {
		tagDao.deleteTag(tag);
	}

	/**
	 * 所有楼盘标签特色设置为0
	 * 
	 * @author zhouzy
	 */
	@Override
	public void updateTagFeature() {
		tagDao.updateTagFeature();
	}

}
