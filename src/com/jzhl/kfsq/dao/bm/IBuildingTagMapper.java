package com.jzhl.kfsq.dao.bm;

import java.util.List;
import java.util.Map;

import com.jzhl.kfsq.dataset.bm.BuildingTagDataSet;
import com.jzhl.kfsq.entity.bm.BuildingTag;

/**
 * 楼盘标签数据访问层接口
 * 
 * @author Shaw
 *
 */
public interface IBuildingTagMapper {

	/**
	 * 根据楼盘编号和显示状态查询楼盘标签信息
	 * 
	 * @param params
	 * @return
	 */
	public List<BuildingTagDataSet> findBuildingTagDataSet(
			Map<String, Object> params);

	/**
	 * 根据楼盘ID删除楼盘ID关联标签列表
	 * 
	 * @author zhouzy
	 * 
	 */
	public void deleteTag(Map<String, Object> param);

	/**
	 * 新增楼盘ID关联标签
	 * 
	 */
	public void saveBuildingTag(BuildingTag buildingTag);

	/**
	 * 根据楼盘编号查询楼盘标签
	 * 
	 * @param buildingId
	 * @return
	 */
	public List<String> findTagByBuildingId(int buildingId);

}
