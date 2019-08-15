package com.jzhl.kfsq.controller.fm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jzhl.kfsq.common.base.ListResult;
import com.jzhl.kfsq.common.base.ResponseBean;
import com.jzhl.kfsq.dataset.fm.BillingDetailDataSet;
import com.jzhl.kfsq.dto.fm.BillingDto;
import com.jzhl.kfsq.dto.fm.PayInfoDto;
import com.jzhl.kfsq.service.fm.IPayInfoService;

/**
 * 支付信息管理类
 * 
 * @author Shaw
 *
 */
@Controller
public class PayInfoController {

	@Autowired
	private IPayInfoService payInfoService;

	/**
	 * 根据用户编号分页查询支付信息
	 * 
	 * @param dto
	 * @return
	 */
	@RequestMapping(value = "/serv/payInfo/payInfoDataSet", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean<ListResult> findPayInfoDataSet(PayInfoDto dto) {
		ListResult ListResult = payInfoService.findPayInfoByUserId(dto);
		ResponseBean<ListResult> result = new ResponseBean<ListResult>(ListResult);
		result.operateSuccess("查询成功");
		return result;
	}
	
	/**
	 * 根据流水号查询账单明细
	 * @return
	 */
	@RequestMapping(value = "/serv/billingDetail", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean<BillingDetailDataSet> getBillingDetail(BillingDto dto){
		BillingDetailDataSet dataSet = payInfoService.getBillingDetalilDataSet(dto);
		ResponseBean<BillingDetailDataSet> result = new ResponseBean<BillingDetailDataSet>(dataSet);
		result.operateSuccess("查询成功");
		return result;
	}

}
