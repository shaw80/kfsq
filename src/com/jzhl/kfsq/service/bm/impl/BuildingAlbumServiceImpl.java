package com.jzhl.kfsq.service.bm.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jzhl.kfsq.dao.bm.IBuildingAlbumMapper;
import com.jzhl.kfsq.entity.bm.BuildingAlbum;
import com.jzhl.kfsq.service.bm.IBuildingAlbumService;

/**
 * 楼盘相册业务层实现类
 * 
 * @author zhouzy
 *
 */
@Service
public class BuildingAlbumServiceImpl implements IBuildingAlbumService {

	@Autowired
	private IBuildingAlbumMapper buildingAlbumDto;

	/**
	 * 查询楼盘图片列表
	 */
	@Override
	public List<BuildingAlbum> findBuildingAlbumList(Map<String, Object> map) {
		List<BuildingAlbum> result = buildingAlbumDto.findBuildingAlbumList(map);
		return result;
	}

	/**
	 * 查询楼盘图片列表总数
	 */
	@Override
	public int findBuildingAlbumDataCount(Map<String, Object> map) {
		int dataCount = buildingAlbumDto.findBuildingAlbumDataCount(map);
		return dataCount;
	}

	/**
	 * 添加图片
	 */
	@Override
	public void insertBuildingAlbum(BuildingAlbum buildingAlbum) {
		buildingAlbumDto.insertBuildingAlbum(buildingAlbum);
	}

	/**
	 * 查询图片详情
	 */
	@Override
	public BuildingAlbum getBuildingAlbumInfo(BuildingAlbum buildingAlbum) {
		BuildingAlbum buildingAlbumInfo = buildingAlbumDto.getBuildingAlbumInfo(buildingAlbum);
		return buildingAlbumInfo;
	}

	/**
	 * 图片详情编辑
	 */
	@Override
	public void updateBuildingAlbum(BuildingAlbum buildingAlbum) {
		buildingAlbumDto.updateBuildingAlbum(buildingAlbum);
	}

}
