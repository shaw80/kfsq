package com.jzhl.kfsq.controller.pm;

import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jzhl.kfsq.common.base.ListResult;
import com.jzhl.kfsq.common.base.ResponseBean;
import com.jzhl.kfsq.dataset.pm.FavoriteDataSet;
import com.jzhl.kfsq.dataset.pm.VisitCommonDataSet;
import com.jzhl.kfsq.dataset.pm.VisitDataSet;
import com.jzhl.kfsq.dataset.pm.VisitMonthDataSet;
import com.jzhl.kfsq.dto.pm.FavoriteDBDto;
import com.jzhl.kfsq.dto.pm.FavoriteDto;
import com.jzhl.kfsq.dto.pm.SalerCustomerDto;
import com.jzhl.kfsq.dto.pm.VisitQueryDto;
import com.jzhl.kfsq.dto.pm.VisitTodayPersonDto;
import com.jzhl.kfsq.entity.pm.SalerCustomer;
import com.jzhl.kfsq.service.pm.ISalerService;

@Controller
public class SalerController {
	
	@Autowired
	private ISalerService salerService;
	
	private static final Logger logger = Logger.getLogger(SalerController.class);
	
	/**
	 * 查询一段时间内的访问量
	 * appUserType为0：销售总监，appUserType为2：售楼员
	 * @return
	 */
	@RequestMapping(value="serv/getVisitCount", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean<Map<String, Object>> getVisitCount(VisitQueryDto visitQueryDto) {
		logger.debug("[查询到访量]--查询条件："+ visitQueryDto.getUserId() +","+ visitQueryDto.getBeginDate() +","+ visitQueryDto.getEndDate());
		java.lang.Integer visitCount = salerService.getVisitCount(visitQueryDto);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("visitCount", visitCount);
		logger.debug("[查询到访量]--查询结果："+ visitCount);
		return new ResponseBean<Map<String, Object>>(map);
	}
	
	/**
	 * 查询一段时间内每天的访问量
	 * appUserType为0：销售总监，appUserType为2：售楼员
	 * @return
	 * @throws ParseException 
	 */
	@RequestMapping(value="serv/getDayVisitCount", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean<Map<String, Object>> getDayVisitCount(VisitQueryDto visitQueryDto) throws ParseException {
		String beginDate = visitQueryDto.getBeginDate();
		String endDate = visitQueryDto.getEndDate();
		logger.debug("[查询每天到访量]--查询条件："+ visitQueryDto.getUserId() +","+ beginDate +","+ endDate);
		List<VisitDataSet> dataList = salerService.getDayVisitCountList(visitQueryDto);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("dataList", dataList);
		logger.debug("[查询每天到访量]--查询完成.");
		return new ResponseBean<Map<String, Object>>(map);
	}
	
	/**
	 * 查询一段时间内每月的访问量
	 * appUserType为0：销售总监，appUserType为2：售楼员
	 * @return
	 * @throws ParseException 
	 */
	@RequestMapping(value="serv/getMonthVisitCount", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean<Map<String, Object>> getMonthVisitCount(VisitQueryDto visitQueryDto) throws ParseException {
		String beginDate = visitQueryDto.getBeginDate();
		String endDate = visitQueryDto.getEndDate();
		logger.debug("[查询每月到访量]--查询条件："+ visitQueryDto.getUserId() +","+ beginDate +","+ endDate);
		List<VisitMonthDataSet> dataList = salerService.getMonthVisitCountList(visitQueryDto);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("dataList", dataList);
		logger.debug("[查询每月到访量]--查询完成.");
		return new ResponseBean<Map<String, Object>>(map);
	}
	
	
	/**
	 * 查询到访用户列表
	 * @return
	 * @throws ParseException 
	 */
	@RequestMapping(value="serv/favorites", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean<ListResult> favorites(SalerCustomerDto salerCustomerDto) throws ParseException {
		logger.debug("[我的客户]--查询条件："+ salerCustomerDto.getMemberName() +","+ salerCustomerDto.getIsFavorites());
		ListResult result = salerService.findSalerCustomerDataSet(salerCustomerDto);
		logger.debug("[我的客户]--查询完成.");
		return new ResponseBean<ListResult>(result);
	}
	
	
	/**
	 * 收藏或取消
	 * @return
	 * @throws ParseException 
	 */
	@RequestMapping(value="serv/updateFavorite", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean<Map<String, Object>> updateFavorite(FavoriteDto dto) throws ParseException {
		
		ResponseBean<Map<String, Object>> result = new ResponseBean<Map<String, Object>>();
		SalerCustomer sc = salerService.getSalerCustomer(Integer.valueOf(dto.getSalerCustomerId()));
		if(Integer.valueOf(sc.getIsFavorite()) != Integer.valueOf(dto.getIsFavorite())){// 参数中isFavorite与数据库中的isFavorite不一致
			logger.debug("[我的客户]--收藏或取消");
			FavoriteDBDto favoriteDBDto = new FavoriteDBDto();
			favoriteDBDto.setIsFavorite(Integer.valueOf(dto.getIsFavorite()));
			favoriteDBDto.setUserId(Integer.valueOf(dto.getUserId()));
			favoriteDBDto.setSalerCustomerId(Integer.valueOf(dto.getSalerCustomerId()));
			salerService.updateFavorite(favoriteDBDto);
			FavoriteDataSet data = new FavoriteDataSet();
			if(dto.getIsFavorite().equals("1")){
				data.setFavoriteStatus("1");
			}else{
				data.setFavoriteStatus("0");
			}
			data.setSalerCustomerId(dto.getSalerCustomerId());
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("data", data);
			result = new ResponseBean<Map<String, Object>>(map);
			result.operateSuccess("修改成功");
		}else{
			result.operateSuccess("操作失败，请求动作与上次重复");
		}
		
		return result;
	}
	
	
	/**
	 * 根据置业顾问编号查询今日到访业绩及今日总到访量
	 * （基于销售经理接口上做了修改）
	 * @param dto
	 * @return
	 */
	@RequestMapping(value = "/serv/home/saler/visit/today", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean<VisitCommonDataSet> getVisitTodayPerson(
			VisitTodayPersonDto dto) {
		VisitCommonDataSet dataSet = salerService
				.getVisitTodayPerson(dto.getUserId(), dto.getRowStart(),
						dto.getOffset());
		ResponseBean<VisitCommonDataSet> result = new ResponseBean<VisitCommonDataSet>(
				dataSet);
		result.operateSuccess("查询成功");
		return result;
	}

	
	/**
	 * 根据置业顾问编号查询本月到访业绩及本月总到访量
	 * （基于销售经理接口上做了修改）
	 * @param dto
	 * @return
	 */
	@RequestMapping(value = "/serv/home/saler/visit/month", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean<VisitCommonDataSet> getVisitMonthPerson(
			VisitTodayPersonDto dto) {
		VisitCommonDataSet dataSet = salerService
				.getVisitMonthPerson(dto.getUserId(), dto.getRowStart(),
						dto.getOffset());
		ResponseBean<VisitCommonDataSet> result = new ResponseBean<VisitCommonDataSet>(
				dataSet);
		result.operateSuccess("查询成功");
		return result;
	}

	
	/**
	 * 根据置业顾问编号查询本月到访业绩及本月总到访量
	 * （基于销售经理接口上做了修改）
	 * @param dto
	 * @return
	 */
	@RequestMapping(value = "/serv/home/saler/visit/total", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean<VisitCommonDataSet> getVisitTotalPerson(
			VisitTodayPersonDto dto) {
		VisitCommonDataSet dataSet = salerService
				.getVisitTotalPerson(dto.getUserId(), dto.getRowStart(),
						dto.getOffset());
		ResponseBean<VisitCommonDataSet> result = new ResponseBean<VisitCommonDataSet>(
				dataSet);
		result.operateSuccess("查询成功");
		return result;
	}
	
	
	/**
	 * 添加售楼员用户到访记录
	 * @param salerCustomer
	 */
	@RequestMapping(value = "/serv/addSalerCustomer", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean<SalerCustomer> addSalerCustomer(SalerCustomer salerCustomer) {
		SalerCustomer sc = salerService.addSalerCustomer(salerCustomer);
		ResponseBean<SalerCustomer> result = new ResponseBean<SalerCustomer>(sc);
		result.operateSuccess("插入成功");
		return result;
	}
	
	
	/**
	 * 添加售楼员用户到访记录
	 * @param salerCustomer
	 */
	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "/serv/modifySalerCustomer", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean modifySalerCustomer(SalerCustomer salerCustomer) {
		salerService.modifySalerCustomer(salerCustomer);
		return new ResponseBean();
	}
	
	
	/**
	 * 获取用户最后到访记录
	 * @param salerCustomer
	 * @return
	 */
	@RequestMapping(value = "/serv/getCustomerLastCome", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean<SalerCustomer> getCustomerLastTime(SalerCustomer salerCustomer) {
		SalerCustomer lastSalerCustomer = salerService.getCustomerLastTime(salerCustomer);
		return new ResponseBean<SalerCustomer>(lastSalerCustomer);
	}
}
