package com.jzhl.kfsq.controller.bm;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jzhl.kfsq.common.base.ResponseBean;
import com.jzhl.kfsq.dataset.bm.BuildingDetail;
import com.jzhl.kfsq.dataset.bm.BuildingInfoDataSet;
import com.jzhl.kfsq.dto.pm.IsVisitDto;
import com.jzhl.kfsq.service.bm.IBuildingDetailService;

/**
 * 楼盘详情管理类
 * 
 * @author Shaw
 *
 */
@Controller
public class BuildingDetailController {
	
	private static final Logger logger = Logger.getLogger(BuildingDetailController.class);

	@Autowired
	IBuildingDetailService buildingDetailService;

	/**
	 * 根据楼盘编号查询楼盘详情
	 * 
	 * @param buildingId
	 * @return
	 */
	@RequestMapping(value = "/serv/buildingDetail", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean<BuildingDetail> getBuildingDetail(IsVisitDto dto) {
		BuildingDetail data = buildingDetailService.getBuildingDetail(dto);

		// 如果楼盘状态为待定或者售罄；则楼盘价格不显示0元；显示待定或售罄/ '销售状态（0：预售，1：在售，2：售罄）',
		if (data.getSalesType() == 0 && data.getAveragePrice().equals("0")) {
			data.setAveragePrice("待定");
		} else if (data.getSalesType() == 2 && data.getAveragePrice().equals("0")) {
			data.setAveragePrice("售罄");
		} else if (data.getSalesType() == 1 && data.getAveragePrice().equals("0")) {
			data.setAveragePrice("待定");
		} else {
			data.setAveragePrice(data.getAveragePrice() + "  元/㎡");
		}

		ResponseBean<BuildingDetail> result = new ResponseBean<BuildingDetail>(data);
		logger.debug("楼盘详情查询成功--" + result);
		result.operateSuccess("查询成功");
		return result;
	}

	/**
	 * 根据楼盘编号查询楼盘详情
	 * 
	 * @param buildingId
	 * @return
	 */
	@RequestMapping(value = "/serv/buildingInfo", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean<BuildingInfoDataSet> getBuildingInfo(int buildingId) {
		BuildingInfoDataSet data = buildingDetailService.getBuildingInfoDataSet(buildingId);
		ResponseBean<BuildingInfoDataSet> result = new ResponseBean<BuildingInfoDataSet>(data);
		result.operateSuccess("查询成功");
		return result;
	}

}
