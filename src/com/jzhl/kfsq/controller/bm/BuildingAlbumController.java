package com.jzhl.kfsq.controller.bm;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jzhl.kfsq.common.base.ListResult;
import com.jzhl.kfsq.common.base.ResponseBean;
import com.jzhl.kfsq.dto.bm.BuildingAlbumDto;
import com.jzhl.kfsq.entity.bm.BuildingAlbum;
import com.jzhl.kfsq.service.bm.IBuildingAlbumService;

/**
 * 楼盘相册管理类
 * 
 * @author zhouzy
 *
 */
@Controller
public class BuildingAlbumController {

	@Autowired
	IBuildingAlbumService buildingAlbumService;

	/**
	 * 获取楼盘图片列表
	 * 
	 * @return ResponseBean
	 */
	@SuppressWarnings({ "rawtypes" })
	@RequestMapping(value = "/serv/buildingAlbum/findBuildingAlbumList", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean findBuildingAlbumList(BuildingAlbumDto buildingAlbumDto) throws Exception {
		// 分页查询参数
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("rowstart", buildingAlbumDto.getRowStart());
		map.put("offset", buildingAlbumDto.getOffset());

		// 查询条件参数
		// 楼盘Id
		map.put("buildingId", buildingAlbumDto.getBuildingId());
		// type '相册类型，1：效果图 2：规划图 3：实景图 4：配套图',
		map.put("type", buildingAlbumDto.getType());

		List<BuildingAlbum> buildingAlbumList = buildingAlbumService.findBuildingAlbumList(map);

		// 分页返回
		ListResult listResult = new ListResult();
		listResult.setDataList(buildingAlbumList);

		// 总页数
		int dataCount = buildingAlbumService.findBuildingAlbumDataCount(map);
		listResult.setDataCount(dataCount);

		ResponseBean<ListResult> result = new ResponseBean<ListResult>(listResult);
		result.operateSuccess();
		return result;
	}

	/**
	 * 添加图片
	 * 
	 */
	@SuppressWarnings({ "rawtypes" })
	@RequestMapping(value = "/serv/buildingAlbum/addBuildingAlbum", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean addBuildingAlbum(BuildingAlbumDto buildingAlbumDto) throws Exception {

		BuildingAlbum buildingAlbum = new BuildingAlbum();
		BeanUtils.copyProperties(buildingAlbumDto, buildingAlbum);

		// 插入数据
		buildingAlbumService.insertBuildingAlbum(buildingAlbum);

		ResponseBean result = new ResponseBean();
		result.operateSuccess();
		return result;
	}

	/**
	 * 查询图片详情
	 *
	 * @return ResponseBean
	 */
	@SuppressWarnings({ "rawtypes" })
	@RequestMapping(value = "/serv/buildingAlbum/getBuildingAlbumInfo", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean getBuildingAlbumInfo(BuildingAlbumDto buildingAlbumDto) throws Exception {
		BuildingAlbum buildingAlbum = new BuildingAlbum();
		BeanUtils.copyProperties(buildingAlbumDto, buildingAlbum);
		// 查询数据
		BuildingAlbum queryResult = buildingAlbumService.getBuildingAlbumInfo(buildingAlbum);
		ResponseBean<BuildingAlbum> result = new ResponseBean<BuildingAlbum>(queryResult);
		result.operateSuccess();
		return result;
	}

	/**
	 * 图片详情编辑
	 */
	@SuppressWarnings({ "rawtypes" })
	@RequestMapping(value = "/serv/buildingAlbum/updateBuildingAlbum", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean updateBuildingAlbum(BuildingAlbumDto buildingAlbumDto) throws Exception {

		BuildingAlbum buildingAlbum = new BuildingAlbum();
		BeanUtils.copyProperties(buildingAlbumDto, buildingAlbum);

		// 编辑
		buildingAlbumService.updateBuildingAlbum(buildingAlbum);

		ResponseBean result = new ResponseBean<BuildingAlbum>();
		result.operateSuccess();
		return result;
	}
}
