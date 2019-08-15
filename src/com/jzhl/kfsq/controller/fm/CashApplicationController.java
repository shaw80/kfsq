package com.jzhl.kfsq.controller.fm;

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
import com.jzhl.kfsq.dataset.fm.CashDetailDataSet;
import com.jzhl.kfsq.dto.fm.CashAgentDto;
import com.jzhl.kfsq.dto.fm.CashAppliQueryDto;
import com.jzhl.kfsq.dto.fm.CashApplicationDto;
import com.jzhl.kfsq.dto.fm.CashApplicationInsertDto;
import com.jzhl.kfsq.dto.fm.CashDetailDto;
import com.jzhl.kfsq.entity.fm.CashApplication;
import com.jzhl.kfsq.service.fm.ICashApplicationService;

/**
 * 提现申请管理类
 * 
 * @author Shaw
 *
 */
@Controller
public class CashApplicationController {

	@Autowired
	private ICashApplicationService cashApplicationService;

	/**
	 * 添加提现申请
	 * 
	 * @param ca
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings({ "rawtypes" })
	@RequestMapping(value = "/serv/cashApplication", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean insertCashAppli(CashApplicationInsertDto dto) throws Exception {

		cashApplicationService.insertCashApplication(dto);

		ResponseBean result = new ResponseBean();

		result.operateSuccess("保存成功");

		return result;
	}

	/**
	 * 根据提现编号修改提现信息
	 * 
	 * @param ca
	 * @return
	 */
	@SuppressWarnings({ "rawtypes" })
	@RequestMapping(value = "/serv/cashApplication/m", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean updateCashAppli(CashApplication ca) throws Exception {

		cashApplicationService.updateCashApplication(ca);

		ResponseBean result = new ResponseBean();

		result.operateSuccess("更新成功");

		return result;
	}
	
	/**
	 * 批量支付更新提现申请
	 * 
	 * @param ca
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "/serv/cashApplication/callback/m", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean callBackUpdateCash(CashApplication ca) throws Exception {

		cashApplicationService.batchPayUpdateCash(ca);

		ResponseBean result = new ResponseBean();

		result.operateSuccess("更新成功");

		return result;
	}

	/**
	 * 批量支付更新提现申请
	 * 
	 * @param ca
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "/serv/cashApplication/batchPay/m", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean batchPayUpdateCash(CashApplication ca) throws Exception {

		cashApplicationService.batchPayUpdateCash(ca);

		ResponseBean result = new ResponseBean();

		result.operateSuccess("更新成功");

		return result;
	}

	/**
	 * 根据申请编号查询提现详情
	 * 
	 * @param dto
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/serv/getCashApplication", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean<CashDetailDataSet> getCashApplication(CashDetailDto dto) throws Exception {

		CashDetailDataSet data = cashApplicationService.getCashDetailDataSet(dto.getApplicationId());

		ResponseBean<CashDetailDataSet> result = new ResponseBean<CashDetailDataSet>(data);

		result.operateSuccess("查询成功");

		return result;
	}

	/**
	 * 分页查询当前会员提现申请
	 * 
	 * @param dto
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/serv/findCashByPage", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean<ListResult> findCashAppliByPage(CashAppliQueryDto dto) throws Exception {

		ListResult cashs = cashApplicationService.findCashAppliByMemberIdByPage(dto.getMemberId(), dto.getRowStart(), dto.getOffset());

		ResponseBean<ListResult> result = new ResponseBean<ListResult>(cashs);

		result.operateSuccess("查询成功");

		return result;
	}

	/**
	 * 代理商后台-财务管理-红包消耗
	 * 
	 * @author zhouzy
	 * @return ResponseBean
	 */
	@SuppressWarnings({ "rawtypes" })
	@RequestMapping(value = "/serv/cashapplication/cashapplicationlist", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean findCashApplicationList(CashApplicationDto cashApplicationDto) {

		// 分页查询参数
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("rowstart", cashApplicationDto.getRowStart());
		map.put("offset", cashApplicationDto.getOffset());
		// 条件查询参数
		map.put("userId", cashApplicationDto.getUserId());
		map.put("dateStart", cashApplicationDto.getDateStart());
		map.put("dateEnd", cashApplicationDto.getDateEnd());
		map.put("keyword", cashApplicationDto.getKeyword());
		map.put("isDownFlag", cashApplicationDto.getIsDownFlag());

		List<CashApplication> cashapplicationlist = cashApplicationService.findCashApplicationList(map);

		// 分页返回
		ListResult listResult = new ListResult();
		listResult.setDataList(cashapplicationlist);

		// 总页数
		int dataCount = cashApplicationService.findCashApplicationDataCount(map);
		listResult.setDataCount(dataCount);

		ResponseBean<ListResult> result = new ResponseBean<ListResult>(listResult);
		result.operateSuccess();
		return result;
	}

	/**
	 * 代理商后台-财务管理-评论消耗
	 * 
	 * @author zhouzy
	 * @return ResponseBean
	 */
	@SuppressWarnings({ "rawtypes" })
	@RequestMapping(value = "/serv/cashapplication/buildingcommentcashapplicationlist", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean findBuildingCommentCashApplicationList(CashApplicationDto cashApplicationDto) {

		// 分页查询参数
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("rowstart", cashApplicationDto.getRowStart());
		map.put("offset", cashApplicationDto.getOffset());
		// 条件查询参数
		map.put("userId", cashApplicationDto.getUserId());
		map.put("dateStart", cashApplicationDto.getDateStart());
		map.put("dateEnd", cashApplicationDto.getDateEnd());
		map.put("keyword", cashApplicationDto.getKeyword());
		map.put("isDownFlag", cashApplicationDto.getIsDownFlag());

		List<CashApplication> cashapplicationlist = cashApplicationService.findBuildingCommentCashApplicationList(map);

		// 分页返回
		ListResult listResult = new ListResult();
		listResult.setDataList(cashapplicationlist);

		// 总页数
		int dataCount = cashApplicationService.findBuildingCommentCashApplicationDataCount(map);
		listResult.setDataCount(dataCount);

		ResponseBean<ListResult> result = new ResponseBean<ListResult>(listResult);
		result.operateSuccess();
		return result;
	}

	/**
	 * 代理商页面，根据多条件筛选代理商下属的会员提现记录
	 * 
	 * @param dto
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/serv/cashapplication/cashDataSet", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean<ListResult> findCashDataSet(CashAgentDto dto) throws Exception {
		ListResult ListResult = cashApplicationService.findCashDateSet(dto);
		ResponseBean<ListResult> result = new ResponseBean<ListResult>(ListResult);
		result.operateSuccess("查询成功");
		return result;
	}

	/**
	 * 根据申请编号查询待处理的申请
	 * 
	 * @return
	 */
	@RequestMapping(value = "/serv/batchPay/cashs", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean<Map<String, Object>> findCashByCashIdAndStatus(CashDetailDto dto) throws Exception {
		String[] appliIds = dto.getApplicationId().split(",");
		List<CashApplication> cashs = cashApplicationService.findCashByCashIdAndStatus(appliIds);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("cashs", cashs);
		ResponseBean<Map<String, Object>> result = new ResponseBean<Map<String, Object>>(map);
		result.operateSuccess("查询成功");
		return result;
	}
}
