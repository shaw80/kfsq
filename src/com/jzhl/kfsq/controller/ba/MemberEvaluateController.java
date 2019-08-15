package com.jzhl.kfsq.controller.ba;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jzhl.kfsq.common.base.ResponseBean;
import com.jzhl.kfsq.dataset.ba.MemberEvaluateDataSet;
import com.jzhl.kfsq.dto.ba.MemberEvaluatePageDto;
import com.jzhl.kfsq.service.ba.IMemberEvaluateService;

/**
 * 用户评价管理类
 * @author Shaw
 *
 */
@Controller
public class MemberEvaluateController {
	
	@Autowired IMemberEvaluateService memberEvaluateService;
	
	@RequestMapping(value = "/serv/memberEvaluateDataSet", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean<MemberEvaluateDataSet> findMemberEvaluateDataSetByDimensionCode(
			MemberEvaluatePageDto dto) {
		MemberEvaluateDataSet data = memberEvaluateService.findMemberEvaluateDataSetByDimensionCode(dto);
		ResponseBean<MemberEvaluateDataSet> result = new ResponseBean<MemberEvaluateDataSet>(data);
		result.operateSuccess("查询成功");
		return result;
	}

}
