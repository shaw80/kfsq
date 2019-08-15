package com.jzhl.kfsq.controller.pm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jzhl.kfsq.common.base.ListResult;
import com.jzhl.kfsq.common.base.ResponseBean;
import com.jzhl.kfsq.dataset.pm.SalesManagerCountDataSet;
import com.jzhl.kfsq.dataset.pm.TeamCustomerDataSet;
import com.jzhl.kfsq.dataset.pm.UserCustomerDataSet;
import com.jzhl.kfsq.dataset.pm.VisitCommonDataSet;
import com.jzhl.kfsq.dataset.pm.VisitCommonTeamDataSet;
import com.jzhl.kfsq.dataset.sm.ManagerDataSet;
import com.jzhl.kfsq.dto.pm.CustomerDto;
import com.jzhl.kfsq.dto.pm.SalesManagerCountDto;
import com.jzhl.kfsq.dto.pm.VisitTodayPersonDto;
import com.jzhl.kfsq.service.pm.ISalesManagerCountService;

/**
 * 销售经理管理类
 * 
 * @author Shaw
 *
 */
@Controller
public class SalesManagerCountController {

	@Autowired
	private ISalesManagerCountService salesManagerCountService;

	/**
	 * 销售经理页面统计
	 * 
	 * @param userId
	 * @return
	 */
	@RequestMapping(value = "/serv/home/manager", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean<SalesManagerCountDataSet> getSalesManagerDataSet(
			SalesManagerCountDto dto) {
		SalesManagerCountDataSet dataSet = salesManagerCountService
				.getCount(dto.getUserId());
		ResponseBean<SalesManagerCountDataSet> result = new ResponseBean<SalesManagerCountDataSet>(
				dataSet);
		result.operateSuccess("查询成功");
		return result;
	}

	/**
	 * 根据销售经理编号查询所有下属的今日到访业绩及今日总到访量
	 * 
	 * @param dto
	 * @return
	 */
	@RequestMapping(value = "/serv/home/manager/visit/today", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean<VisitCommonDataSet> getVisitTodayPerson(
			VisitTodayPersonDto dto) {
		VisitCommonDataSet dataSet = salesManagerCountService
				.getVisitTodayPerson(dto.getUserId(), dto.getRowStart(),
						dto.getOffset());
		ResponseBean<VisitCommonDataSet> result = new ResponseBean<VisitCommonDataSet>(
				dataSet);
		result.operateSuccess("查询成功");
		return result;
	}

	/**
	 * 根据销售经理编号查询所有下属的本月到访业绩及本月总到访量
	 * 
	 * @param dto
	 * @return
	 */
	@RequestMapping(value = "/serv/home/manager/visit/month", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean<VisitCommonDataSet> getVisitMonthPerson(
			VisitTodayPersonDto dto) {
		VisitCommonDataSet dataSet = salesManagerCountService
				.getVisitMonthPerson(dto.getUserId(), dto.getRowStart(),
						dto.getOffset());
		ResponseBean<VisitCommonDataSet> result = new ResponseBean<VisitCommonDataSet>(
				dataSet);
		result.operateSuccess("查询成功");
		return result;
	}

	/**
	 * 根据销售经理编号查询所有下属的本月到访业绩及本月总到访量
	 * 
	 * @param dto
	 * @return
	 */
	@RequestMapping(value = "/serv/home/manager/visit/total", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean<VisitCommonDataSet> getVisitTotalPerson(
			VisitTodayPersonDto dto) {
		VisitCommonDataSet dataSet = salesManagerCountService
				.getVisitTotalPerson(dto.getUserId(), dto.getRowStart(),
						dto.getOffset());
		ResponseBean<VisitCommonDataSet> result = new ResponseBean<VisitCommonDataSet>(
				dataSet);
		result.operateSuccess("查询成功");
		return result;
	}

	/**
	 * 根据销售经理编号分页查询今天本楼盘所有团队到访业绩
	 * 
	 * @param dto
	 * @return
	 */
	@RequestMapping(value = "/serv/home/manager/visit/team/today", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean<VisitCommonTeamDataSet> getVisitTodayTeam(
			VisitTodayPersonDto dto) {
		VisitCommonTeamDataSet dataSet = salesManagerCountService
				.getVisitTodayTeam(dto.getUserId(), dto.getRowStart(),
						dto.getOffset());
		ResponseBean<VisitCommonTeamDataSet> result = new ResponseBean<VisitCommonTeamDataSet>(
				dataSet);
		result.operateSuccess("查询成功");
		return result;
	}

	/**
	 * 根据销售经理编号分页查询本月本楼盘所有团队到访业绩
	 * 
	 * @param dto
	 * @return
	 */
	@RequestMapping(value = "/serv/home/manager/visit/team/month", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean<VisitCommonTeamDataSet> getVisitMonthTeam(
			VisitTodayPersonDto dto) {
		VisitCommonTeamDataSet dataSet = salesManagerCountService
				.getVisitMonthTeam(dto.getUserId(), dto.getRowStart(),
						dto.getOffset());
		ResponseBean<VisitCommonTeamDataSet> result = new ResponseBean<VisitCommonTeamDataSet>(
				dataSet);
		result.operateSuccess("查询成功");
		return result;
	}

	/**
	 * 根据销售经理编号分页查询本楼盘所有团队总到访业绩
	 * 
	 * @param dto
	 * @return
	 */
	@RequestMapping(value = "/serv/home/manager/visit/team/total", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean<VisitCommonTeamDataSet> getVisitTotalTeam(
			VisitTodayPersonDto dto) {
		VisitCommonTeamDataSet dataSet = salesManagerCountService
				.getVisitTotalTeam(dto.getUserId(), dto.getRowStart(),
						dto.getOffset());
		ResponseBean<VisitCommonTeamDataSet> result = new ResponseBean<VisitCommonTeamDataSet>(
				dataSet);
		result.operateSuccess("查询成功");
		return result;
	}

	/**
	 * 根据置业顾问编号查询客户到访数据
	 * 
	 * @param dto
	 * @return
	 */
	@RequestMapping(value = "/serv/home/manager/saler/customer", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean<UserCustomerDataSet> getUserCustomerDataSet(
			CustomerDto dto) {
		UserCustomerDataSet dataSet = salesManagerCountService
				.getUserCustomerDataSet(dto.getUserId(), dto.getRowStart(),
						dto.getOffset());
		ResponseBean<UserCustomerDataSet> result = new ResponseBean<UserCustomerDataSet>(
				dataSet);
		result.operateSuccess("查询成功");
		return result;
	}
	
	/**
	 * 分页查询团队客户到访信息
	 * 
	 * @param dto
	 * @return
	 */
	@RequestMapping(value = "/serv/home/manager/team/customer", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean<TeamCustomerDataSet> getTeamCustomerDataSet(
			CustomerDto dto) {
		TeamCustomerDataSet dataSet = salesManagerCountService
				.findCustomerDataSet(dto.getMemberName(), dto.getLeaderId(), dto.getRowStart(),
						dto.getOffset());
		ResponseBean<TeamCustomerDataSet> result = new ResponseBean<TeamCustomerDataSet>(
				dataSet);
		result.operateSuccess("查询成功");
		return result;
	}
	
	/**
	 * 根据销售经理编号查询销售经理信息
	 * 
	 * @param dto
	 * @return
	 */
	@RequestMapping(value = "/serv/home/selfInfo", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean<ManagerDataSet> getManagerDataSet(
			CustomerDto dto) {
		ManagerDataSet dataSet = salesManagerCountService
				.getManagerDataSet(dto.getUserId());
		ResponseBean<ManagerDataSet> result = new ResponseBean<ManagerDataSet>(
				dataSet);
		result.operateSuccess("查询成功");
		return result;
	}
	
	/**
	 * 根据销售经理编号分页查询下属置业顾问信息
	 * 
	 * @param dto
	 * @return
	 */
	@RequestMapping(value = "/serv/home/manager/salers", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean<ListResult> getSalerDataSet(
			CustomerDto dto) {
		ListResult listResult = salesManagerCountService
				.findSalerDataSet(dto.getUserId(), dto.getRowStart(), dto.getOffset());
		ResponseBean<ListResult> result = new ResponseBean<ListResult>(
				listResult);
		result.operateSuccess("查询成功");
		return result;
	}

}
