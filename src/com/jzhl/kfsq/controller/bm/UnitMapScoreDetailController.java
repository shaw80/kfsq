package com.jzhl.kfsq.controller.bm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jzhl.kfsq.common.base.ResponseBean;
import com.jzhl.kfsq.dataset.bm.UnitMapScoreDetail;
import com.jzhl.kfsq.dto.bm.UnitMapScoreDetailDto;
import com.jzhl.kfsq.service.bm.IUnitMapScoreDetailService;

/**
 * 户型分数详情管理类
 * 
 * @author Shaw
 *
 */
@Controller
public class UnitMapScoreDetailController {
	
	@Autowired IUnitMapScoreDetailService unitMapScoreDetailService;
	
	/**
	 * 根据楼盘编号查询户型分数详情
	 * @param dto
	 * @return
	 */
	@RequestMapping(value = "/serv/unitMapScoreDetail", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean<UnitMapScoreDetail> getUnitMapScoreDetail(UnitMapScoreDetailDto dto){
		UnitMapScoreDetail data = unitMapScoreDetailService.getUnitMapScoreDetail(dto);
		ResponseBean<UnitMapScoreDetail> result = new ResponseBean<UnitMapScoreDetail>(data);
		result.operateSuccess("查询成功");
		return result;
	}

}
