package com.jzhl.kfsq.service.fm;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.jzhl.kfsq.common.base.ListResult;
import com.jzhl.kfsq.dataset.fm.Amount;
import com.jzhl.kfsq.dataset.fm.EnvelopeReceiveCountDataSet;
import com.jzhl.kfsq.dataset.fm.EnvelopeStatisticalDatoSet;
import com.jzhl.kfsq.dto.fm.BuildingEnvelopeBalanceDto;
import com.jzhl.kfsq.dto.fm.SalerTotalRedDto;
import com.jzhl.kfsq.dto.mm.MemberDto;
import com.jzhl.kfsq.dto.sm.StatisticalDto;
import com.jzhl.kfsq.entity.fm.EnvelopeReceive;

/**
 * 红包领取业务层接口
 * 
 * @author Shaw
 *
 */
public interface IEnvelopeReceiveService {

	/**
	 * 添加红包领取信息
	 * 
	 * @param er
	 *            红包领取实体类
	 */
	public void insertEnvelopeReceive(EnvelopeReceive er);

	/**
	 * 删除红包领取信息
	 * 
	 * @param receiveId
	 *            领取编号
	 */
	public void deleteEnvelopeReceive(int receiveId);

	/**
	 * 修改红包领取信息
	 * 
	 * @param er
	 *            红包领取实体类
	 */
	public void updateEnvelopeReceive(EnvelopeReceive er);

	/**
	 * 根据领取编号查询红包领取信息
	 * 
	 * @param receiveId
	 *            领取编号
	 * @return 红包领取实体类
	 */
	public EnvelopeReceive getEnvelopeReceive(int receiveId);

	/**
	 * 根据会员编号查询红包领取DTO
	 * 
	 * @param memberId
	 *            会员编号
	 * @return dto
	 */
	public EnvelopeReceiveCountDataSet getCountDataSet(int memberId);

	/**
	 * 按城市查询红包消耗总量
	 * 
	 * @param map
	 * 
	 * @return BigDecimal
	 */
	public BigDecimal getSumPriceNum(Map<String, Object> map);

	/**
	 * 按城市查询计划总数
	 */
	public Integer getPlanNum(Map<String, Object> map);

	/**
	 * 按城市查询到访总数
	 */
	public Integer getVisitNum(Map<String, Object> map);

	/**
	 * 根据会员编号分页查询交易记录红包领取信息
	 * 
	 * @param params
	 * @return
	 */

	public ListResult findEnvelopeDealReceiveDataSet(int memberId, int begin, int length);

	/**
	 * 现金红包统计及收入
	 * 
	 * @param params
	 * @return
	 */
	public EnvelopeReceiveCountDataSet findReadyEnvelopeReceiveDataSet(int memberId, int begin, int length);

	/**
	 * 查楼盘红包余额
	 * 
	 * @param buildingId
	 * @return
	 */
	public BigDecimal getBuildingEnvelopeBalance(BuildingEnvelopeBalanceDto buildingEnvelopeBalanceDto);

	/**
	 * 获取售楼员已发放红包金额
	 * 
	 * @param userId
	 * @return
	 */
	public BigDecimal getSalerTotalRed(SalerTotalRedDto salerTotalRedDto);

	/**
	 * 楼盘管理后台_财务管理——红包消耗统计-按月分组显示当年红包消耗情况
	 * 
	 * @author zhouzy
	 */
	public List<EnvelopeStatisticalDatoSet> findBuildingEnvelopeStatistical(StatisticalDto statisticalDto);

	/**
	 * 楼盘管理后台_财务管理——红包消耗-交易记录
	 * 
	 * @author zhouzy
	 */
	public List<EnvelopeReceive> findEnvelopeReceiveList(Map<String, Object> map);

	/**
	 * 楼盘管理后台_财务管理——红包消耗-交易记录总页数
	 * 
	 * @author zhouzy
	 */
	public int getEnvelopeReceiveDataCount(Map<String, Object> map);
	
	/**
	 * 根据会员编号查询可生成红包金额
	 * @param dto
	 * @return
	 */
	public Amount getAmountOfRedPacketsCanBeGenerated(MemberDto dto);

}
