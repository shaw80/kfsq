package com.jzhl.kfsq.dao.bm;

import java.util.List;
import java.util.Map;

import com.jzhl.kfsq.entity.bm.BuildingAlbum;

/**
 * 楼盘相册数据访问层接口
 * 
 * @author zhouzy
 *
 */
public interface IBuildingAlbumMapper {

	/**
	 * 查询楼盘图片列表
	 */
	public List<BuildingAlbum> findBuildingAlbumList(Map<String, Object> map);

	/**
	 * 查询楼盘图片列表总数
	 */
	public int findBuildingAlbumDataCount(Map<String, Object> map);

	/**
	 * 添加图片
	 */
	public void insertBuildingAlbum(BuildingAlbum buildingAlbum);

	/**
	 * 查询图片详情
	 */
	public BuildingAlbum getBuildingAlbumInfo(BuildingAlbum buildingAlbum);

	/**
	 * 图片详情编辑
	 */
	public void updateBuildingAlbum(BuildingAlbum buildingAlbum);

}
