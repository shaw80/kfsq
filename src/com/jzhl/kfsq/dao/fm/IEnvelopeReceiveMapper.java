package com.jzhl.kfsq.dao.fm;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.jzhl.kfsq.dataset.fm.Amount;
import com.jzhl.kfsq.dataset.fm.EnvelopeDealReceiveDataSet;
import com.jzhl.kfsq.dataset.fm.EnvelopeReceiveCountDataSet;
import com.jzhl.kfsq.dataset.fm.EnvelopeStatisticalDatoSet;
import com.jzhl.kfsq.dataset.fm.ReadyEnvelopeReceiveDataSet;
import com.jzhl.kfsq.dto.fm.SalerMemberDto;
import com.jzhl.kfsq.dto.sm.StatisticalDto;
import com.jzhl.kfsq.entity.fm.EnvelopeReceive;

/**
 * 红包领取数据访问层接口
 * 
 * @author Shaw
 *
 */
public interface IEnvelopeReceiveMapper {

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
	 * 获取红包消耗总数
	 * 
	 * @param map
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
	public List<EnvelopeDealReceiveDataSet> findEnvelopeDealReceiveDataSet(Map<String, Object> params);

	/**
	 * 统计根据会员编号查询交易记录红包领取信息条目数
	 * 
	 * @param memberId
	 * @return
	 */
	public Integer countEnvelopeDealReceiveDataSet(int memberId);

	/**
	 * 根据会员编号分页查询现金红包领取信息
	 * 
	 * @param params
	 * @return
	 */
	public List<ReadyEnvelopeReceiveDataSet> findReadyEnvelopeReceiveDataSet(Map<String, Object> params);

	/**
	 * 统计根据会员编号查询现金红包领取条目数
	 * 
	 * @param memberId
	 * @return
	 */
	public Integer countReadyEnvelopeReceiveDataSet(int memberId);

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
	 * 手机端提现申请_根据会员编号和提现状态查询红包领取表信息
	 * @param memberId
	 * @return
	 */
	public List<EnvelopeReceive> findEnvelopeReceiveByMemberIdAndStatus(int memberId);
	
	/**
	 * 根据会员编号和楼盘编号查询领取信息--用于判断楼盘是否有红包给到用户
	 * @param params
	 * @return
	 */
	public List<EnvelopeReceive> findEnvelopeReceiveByMemberAndBuildingId(Map<String, Object> params);
	
	/**
	 * 根据会员编号查询可生成红包金额
	 * @param memberId
	 * @return
	 */
	public Amount getAmountOfRedPacketsCanBeGenerated(Integer memberId);
	
	/**
	 * 查询置业顾问的客户红包
	 * @return
	 */
	public Amount getEnvelopeBySalerAndMember(SalerMemberDto dto);

}
