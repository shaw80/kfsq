package com.jzhl.kfsq.controller.bm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jzhl.kfsq.common.base.ResponseBean;
import com.jzhl.kfsq.dataset.bm.AroundScoreDetail;
import com.jzhl.kfsq.dto.bm.UnitMapScoreDetailDto;
import com.jzhl.kfsq.service.bm.IAroundScoreDetailService;

/**
 * 周边分数详情管理类
 * 
 * @author mac
 *
 */
@Controller
public class AroundScoreDetailController {
	
	@Autowired IAroundScoreDetailService aroundScoreDetailService;

	/**
	 * 根据楼盘编号查询周边分数详情
	 * 
	 * @param dto
	 * @return
	 */
	@RequestMapping(value = "/serv/aroundScoreDetail", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean<AroundScoreDetail> getAroundScoreDetail(UnitMapScoreDetailDto dto) {
		AroundScoreDetail data = aroundScoreDetailService.getAroundScoreDetail(dto.getBuildingId());
		ResponseBean<AroundScoreDetail> result = new ResponseBean<AroundScoreDetail>(data);
		result.operateSuccess("查询成功");
		return result;
	}

}
