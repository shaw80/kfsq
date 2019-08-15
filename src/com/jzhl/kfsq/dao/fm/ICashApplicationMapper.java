package com.jzhl.kfsq.dao.fm;

import java.util.List;
import java.util.Map;

import com.jzhl.kfsq.dataset.fm.CashDealReceiveDataSet;
import com.jzhl.kfsq.dataset.fm.CashDetailReceiveDataSet;
import com.jzhl.kfsq.dataset.fm.CashReceiveDataSet;
import com.jzhl.kfsq.dto.fm.CashParamDto;
import com.jzhl.kfsq.entity.fm.CashApplication;

/**
 * 提现申请数据访问层接口
 * 
 * @author Shaw
 *
 */
public interface ICashApplicationMapper {

	/**
	 * 添加提现申请
	 * 
	 * @param ca
	 */
	public void insertCashApplication(CashApplication ca);

	/**
	 * 删除提现申请
	 * 
	 * @param applicationId
	 */
	public void deleteCashApplication(String applicationId);

	/**
	 * 更新提现申请
	 * 
	 * @param ca
	 */
	public void updateCashApplication(CashApplication ca);

	/**
	 * 批量更新提现申请
	 * 
	 * @param list
	 */
	public void updateBatchCash(List<CashApplication> list);

	/**
	 * 根据申请编号查询提现详情结果集
	 * 
	 * @param applicationId
	 * @return 提现申请
	 */
	public CashDetailReceiveDataSet getCashDetailReceiveDataSet(
			String applicationId);

	/**
	 * 根据会员编号分页查询提现申请
	 * 
	 * @param param
	 * @return
	 */
	public List<CashDealReceiveDataSet> findCashByAppliPersonIdByPage(
			Map<String, Object> param);

	/**
	 * 根据会员编号统计处理成功的提现申请
	 * 
	 * @param param
	 * @return
	 */
	public Integer countCashByAppliPersonId(int applicationPersonId);

	/**
	 * 代理商后台-财务管理-红包消耗
	 * 
	 * @author zhouzy
	 */
	public List<CashApplication> findCashApplicationList(Map<String, Object> map);

	/**
	 * 代理商后台-财务管理-红包消耗总页数
	 * 
	 * @author zhouzy
	 */
	public int findCashApplicationDataCount(Map<String, Object> map);

	/**
	 * 代理商后台-财务管理-评论消耗列表
	 * 
	 * @author zhouzy
	 */
	public List<CashApplication> findBuildingCommentCashApplicationList(
			Map<String, Object> map);

	/**
	 * 代理商后台-财务管理-评论消耗总数
	 * 
	 * @author zhouzy
	 */
	public int findBuildingCommentCashApplicationDataCount(
			Map<String, Object> map);

	/**
	 * 根据代理商编号分页查询提现申请记录
	 * 
	 * @param map
	 * @return
	 */
	public List<CashReceiveDataSet> findCashDateSet(CashParamDto dto);

	/**
	 * 根据代理商编号统计提现申请数据量
	 * 
	 * @param userId
	 * @return
	 */
	public Integer countCashDataSet(CashParamDto dto);

	/**
	 * 根据申请编号查询待处理的申请
	 * 
	 * @param appliIds
	 * @return
	 */
	public List<CashApplication> findCashByCashIdAndStatus(String[] appliIds);

}
