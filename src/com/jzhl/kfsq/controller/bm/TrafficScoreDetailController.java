package com.jzhl.kfsq.controller.bm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jzhl.kfsq.common.base.ResponseBean;
import com.jzhl.kfsq.dataset.bm.TrafficScoreDetail;
import com.jzhl.kfsq.dto.bm.UnitMapScoreDetailDto;
import com.jzhl.kfsq.service.bm.ITrafficScoreDetailService;

/**
 * 交通分数详情管理类
 * 
 * @author Shaw
 *
 */
@Controller
public class TrafficScoreDetailController {
	
	@Autowired ITrafficScoreDetailService trafficScoreDetailService;

	/**
	 * 根据楼盘编号查询交通分数详情
	 * 
	 * @param dto
	 * @return
	 */
	@RequestMapping(value = "/serv/trafficScoreDetail", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean<TrafficScoreDetail> getTrafficScoreDetail(UnitMapScoreDetailDto dto) {
		TrafficScoreDetail data = trafficScoreDetailService.getTrafficScoreDetail(dto.getBuildingId());
		ResponseBean<TrafficScoreDetail> result = new ResponseBean<TrafficScoreDetail>(data);
		result.operateSuccess("查询成功");
		return result;
	}

}
