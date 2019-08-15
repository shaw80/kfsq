package com.jzhl.kfsq.controller.bm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jzhl.kfsq.common.base.ResponseBean;
import com.jzhl.kfsq.dataset.bm.EducationScoreDetail;
import com.jzhl.kfsq.dto.bm.UnitMapScoreDetailDto;
import com.jzhl.kfsq.service.bm.IEducationScoreDetailService;

/**
 * 教育分数详情管理类
 * 
 * @author mac
 *
 */
@Controller
public class EducationScoreDetailController {
	
	@Autowired IEducationScoreDetailService educationScoreDetailService;

	/**
	 * 根据楼盘编号查询交通分数详情
	 * 
	 * @param dto
	 * @return
	 */
	@RequestMapping(value = "/serv/educationScoreDetail", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean<EducationScoreDetail> getTrafficScoreDetail(UnitMapScoreDetailDto dto) {
		EducationScoreDetail data = educationScoreDetailService.getEducationScoreDetail(dto.getBuildingId());
		ResponseBean<EducationScoreDetail> result = new ResponseBean<EducationScoreDetail>(data);
		result.operateSuccess("查询成功");
		return result;
		
	}

}
