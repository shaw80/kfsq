package com.jzhl.kfsq.controller.sm;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jzhl.kfsq.common.base.ListResult;
import com.jzhl.kfsq.common.base.ResponseBean;
import com.jzhl.kfsq.dto.sm.BuildingRemindInfoDto;
import com.jzhl.kfsq.entity.sm.BuildingRemindInfo;
import com.jzhl.kfsq.service.sm.IBuildingRemindInfoService;

/**
 * 楼盘提醒列表接口类
 * 
 * @author zhouzy
 *
 */
@Controller
public class BuildingRemindInfoController {

	@Autowired
	private IBuildingRemindInfoService buildingRemindInfoService;

	/**
	 * 获取楼盘提醒列表
	 * 
	 * @param
	 * @return ResponseBean
	 */
	@SuppressWarnings({ "rawtypes" })
	@RequestMapping(value = "/serv/buildingRemindInfo/findBuildingRemindInfoList", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean findBuildingRemindInfoList(BuildingRemindInfoDto buildingRemindInfoDto) throws Exception {
		// 分页查询参数
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("rowstart", buildingRemindInfoDto.getRowStart());
		map.put("offset", buildingRemindInfoDto.getOffset());
		
		// 参数输入
		map.put("branchId", buildingRemindInfoDto.getBranchId());

		// 查询提醒列表
		List<BuildingRemindInfo> buildingRemindInfoList = buildingRemindInfoService.findBuildingRemindInfoList(map);

		// 分页返回
		ListResult listResult = new ListResult();
		listResult.setDataList(buildingRemindInfoList);

		// 总页数
		int dataCount = buildingRemindInfoService.getBuildingRemindInfoDataCount(map);
		listResult.setDataCount(dataCount);

		ResponseBean<ListResult> result = new ResponseBean<ListResult>(listResult);
		result.operateSuccess();
		return result;
	}

}
