package com.jzhl.kfsq.controller.fm;

import java.math.BigDecimal;
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
import com.jzhl.kfsq.dataset.fm.Amount;
import com.jzhl.kfsq.dataset.fm.EnvelopeReceiveCountDataSet;
import com.jzhl.kfsq.dataset.fm.EnvelopeReceiveWebDataSet;
import com.jzhl.kfsq.dto.fm.BuildingEnvelopeBalanceDto;
import com.jzhl.kfsq.dto.fm.EnvelopeDealDto;
import com.jzhl.kfsq.dto.fm.EnvelopeReceiveCallBackDto;
import com.jzhl.kfsq.dto.fm.EnvelopeReceiveDto;
import com.jzhl.kfsq.dto.fm.SalerTotalRedDto;
import com.jzhl.kfsq.dto.mm.MemberDto;
import com.jzhl.kfsq.entity.fm.EnvelopeReceive;
import com.jzhl.kfsq.service.fm.IEnvelopeReceiveService;

/**
 * 红包领取管理类
 * 
 * @author Shaw
 *
 */
@Controller
public class EnvelopeReceiveController {

	@Autowired
	private IEnvelopeReceiveService envelopeReceiveService;

	/**
	 * 前端app红包统计管理类
	 * 
	 * @return
	 */
	@RequestMapping(value = "/serv/envelopeReceive", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean<EnvelopeReceiveCountDataSet> countEnvelope(EnvelopeDealDto dto) throws Exception {

		ResponseBean<EnvelopeReceiveCountDataSet> result = null;

		EnvelopeReceiveCountDataSet dataSet = envelopeReceiveService.findReadyEnvelopeReceiveDataSet(dto.getMemberId(), dto.getRowStart(),
				dto.getOffset());

		result = new ResponseBean<EnvelopeReceiveCountDataSet>(dataSet);

		result.operateSuccess("查询成功");

		return result;
	}

	/**
	 * 根据会员编号分页查询交易记录红包领取信息
	 * 
	 * @param dto
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/serv/findEnvelopeDeal", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean<ListResult> findEnvelopeDeal(EnvelopeDealDto dto) throws Exception {

		ListResult list = envelopeReceiveService.findEnvelopeDealReceiveDataSet(dto.getMemberId(), dto.getRowStart(), dto.getOffset());

		ResponseBean<ListResult> result = new ResponseBean<ListResult>(list);

		result.operateSuccess("查询成功");

		return result;
	}

	/**
	 * 根据楼盘编号查询红包余额
	 * 
	 * @param dto
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/serv/getBuildingEnvelopeBalance", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean<Map<String, Object>> getBuildingEnvelopeBalance(BuildingEnvelopeBalanceDto buildingEnvelopeBalanceDto)
			throws Exception {

		BigDecimal balance = envelopeReceiveService.getBuildingEnvelopeBalance(buildingEnvelopeBalanceDto);

		Map<String, Object> map = new HashMap<String, Object>();

		map.put("balance", balance);

		return new ResponseBean<Map<String, Object>>(map);
	}

	/**
	 * 查询已发放红包总额
	 * 
	 * @param userId
	 * @param appUserType
	 *            0销售总监，1销售经理，2置业顾问
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/serv/getSalerTotalRed", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean<Map<String, Object>> getSalerTotalRed(SalerTotalRedDto salerTotalRedDto) throws Exception {

		BigDecimal totalRed = envelopeReceiveService.getSalerTotalRed(salerTotalRedDto);

		Map<String, Object> map = new HashMap<String, Object>();

		map.put("totalRed", totalRed);

		return new ResponseBean<Map<String, Object>>(map);
	}

	/**
	 * 楼盘管理后台_财务管理——红包消耗-交易记录
	 * 
	 * @author zhouzy
	 * @return ResponseBean
	 */
	@SuppressWarnings({ "rawtypes" })
	@RequestMapping(value = "/serv/envelopereceive/envelopereceivelist", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean findEnvelopeReceiveList(EnvelopeReceiveDto envelopeReceiveDto) throws Exception {

		// 分页查询参数
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("rowstart", envelopeReceiveDto.getRowStart());
		map.put("offset", envelopeReceiveDto.getOffset());
		// 条件查询参数
		map.put("userId", envelopeReceiveDto.getUserId());
		map.put("keyword", envelopeReceiveDto.getKeyword());
		map.put("dateStart", envelopeReceiveDto.getDateStart());
		map.put("dateEnd", envelopeReceiveDto.getDateEnd());

		List<EnvelopeReceive> envelopeResult = envelopeReceiveService.findEnvelopeReceiveList(map);

		// 分页返回
		ListResult listResult = new ListResult();
		listResult.setDataList(envelopeResult);

		// 总页数
		int dataCount = envelopeReceiveService.getEnvelopeReceiveDataCount(map);
		listResult.setDataCount(dataCount);

		ResponseBean<ListResult> result = new ResponseBean<ListResult>(listResult);
		result.operateSuccess();
		return result;
	}

	/**
	 * 添加红包激活信息
	 * 
	 * @param er
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "/serv/addEnvelopeReceive")
	@ResponseBody
	public ResponseBean addEnvelopeReceive(EnvelopeReceive er) {
		Integer buildingId = er.getBuildingId();
		synchronized (buildingId) {
			envelopeReceiveService.insertEnvelopeReceive(er);
			return new ResponseBean();
		}
	}

	/**
	 * 根据领取编号查询红包领取信息
	 * 
	 * @return
	 */
	@RequestMapping(value = "/serv/envelopereceive/receiveId", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean<EnvelopeReceiveWebDataSet> getEnvelopeReceive(EnvelopeReceiveDto dto) {
		EnvelopeReceive er = envelopeReceiveService.getEnvelopeReceive(dto.getReceiveId());
		EnvelopeReceiveWebDataSet data = new EnvelopeReceiveWebDataSet();
		data.setReceiveId(er.getReceiveId());
		data.setEnvelopeId(er.getEnvelopeId());
		data.setMemberId(er.getMemberId());
		data.setPrice(er.getPrice());
		data.setReceiveStatus(er.getStatus());
		data.setCreateTime(er.getCreateTime());
		data.setUpdateTime(er.getUpdateTime());
		data.setIsValid(er.getIsValid());
		ResponseBean<EnvelopeReceiveWebDataSet> result = new ResponseBean<EnvelopeReceiveWebDataSet>(data);
		result.operateSuccess("查询成功");
		return result;
	}

	/**
	 * 批量支付失败支付宝回调更新红包状态
	 * 
	 * @param dto
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "/serv/envelopereceive/m", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean updateEnvelopeReceive(EnvelopeReceiveCallBackDto dto) {
		EnvelopeReceive er = new EnvelopeReceive();
		er.setReceiveId(dto.getReceiveId());
		er.setStatus(dto.getStatus());
		envelopeReceiveService.updateEnvelopeReceive(er);
		ResponseBean result = new ResponseBean();
		result.operateSuccess("更新成功");
		return result;
	}
	
	/**
	 * 根据会员编号查询可生成红包金额
	 * @param dto
	 * @return
	 */
	@RequestMapping(value = "/serv/amount/memberId", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean<Amount> getAmountOfRedPacketsCanBeGenerated(MemberDto dto){
		Amount amount = envelopeReceiveService.getAmountOfRedPacketsCanBeGenerated(dto);
		ResponseBean<Amount> result = new ResponseBean<Amount>(amount);
		result.operateSuccess("查询成功");
		return result;
	} 

}
