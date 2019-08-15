package com.jzhl.kfsq.dao.sm;

import java.util.List;
import java.util.Map;

import com.jzhl.kfsq.dataset.sm.CommentTagDataSet;
import com.jzhl.kfsq.dataset.sm.FeatureTagDataSet;
import com.jzhl.kfsq.dataset.sm.TagDataSet;
import com.jzhl.kfsq.dto.sm.TagDto;
import com.jzhl.kfsq.entity.sm.Tag;

/**
 * 标签管理接口
 * 
 * @author zhouzy
 *
 */
public interface ITagMapper {

	/**
	 * 获取标签特色列表
	 * 
	 */
	public List<FeatureTagDataSet> findFeatureTagDataSet();

	/**
	 * 根据户型编号查询标签
	 * 
	 * @param unitMapId
	 * @return
	 */
	public List<FeatureTagDataSet> findTagByUnitMapId(int unitMapId);

	/**
	 * 获取楼盘标签列表
	 * 
	 */
	public List<CommentTagDataSet> findCommentBuildingTagDateSet(Map<String, Object> param);

	/**
	 * 获取标签列表
	 * 
	 */
	public List<TagDataSet> findTagDateSetList(Map<String, Object> param);

	/**
	 * 获取户型对应标签列表
	 * 
	 */
	public List<TagDataSet> findUnitMapTagList(Map<String, Object> param);

	/**
	 * 分页查询三级标签列表
	 * 
	 */
	public List<Tag> findThirdTags(Map<String, Object> param);

	/**
	 * 三级标签列表总页数
	 * 
	 */
	public int findThirdTagsDataCount(Map<String, Object> param);

	/**
	 * 获取标签详情
	 * 
	 */
	public TagDataSet getTagInfo(Map<String, Object> param);

	/**
	 * 编辑标签
	 * 
	 * @author zhouzy
	 */
	public void updateTagInfo(TagDto tagDto);

	/**
	 * 添加标签
	 * 
	 * @author zhouzy
	 */
	public void addTag(Tag tag);

	/**
	 * 刪除标签
	 * 
	 * @author zhouzy
	 */
	public void deleteTag(Tag tag);

	/**
	 * 所有楼盘标签特色设置为0
	 * 
	 * @author zhouzy
	 */
	public void updateTagFeature();

}
