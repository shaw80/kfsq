package com.jzhl.kfsq.service.fm;

import java.util.List;
import java.util.Map;

import com.jzhl.kfsq.common.base.ListResult;
import com.jzhl.kfsq.dataset.fm.CashDetailDataSet;
import com.jzhl.kfsq.dto.fm.CashAgentDto;
import com.jzhl.kfsq.dto.fm.CashApplicationInsertDto;
import com.jzhl.kfsq.entity.fm.CashApplication;

/**
 * 提现申请业务层接口
 * 
 * @author Shaw
 *
 */
public interface ICashApplicationService {

	/**
	 * 添加提现申请
	 * 
	 * @param ca
	 * @throws Exception
	 */
	public void insertCashApplication(CashApplicationInsertDto dto)
			throws Exception;

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
	 * 支付宝回调函数更新提现申请
	 * 
	 * @param ca
	 */
	public void callBackUpdateCash(CashApplication ca);

	/**
	 * 批量支付更新提现申请
	 * 
	 * @param ca
	 */
	public void batchPayUpdateCash(CashApplication ca);

	/**
	 * 根据申请编号查询提现详情结果集
	 * 
	 * @param applicationId
	 * @return 提现申请
	 */
	public CashDetailDataSet getCashDetailDataSet(String applicationId);

	/**
	 * 根据会员编号分页查询提现申请
	 * 
	 * @param param
	 * @return
	 */
	public ListResult findCashAppliByMemberIdByPage(int memberId, int begin,
			int length);

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
	 * 代理商后台-财务管理-评论消耗
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
	public ListResult findCashDateSet(CashAgentDto dto);

	/**
	 * 根据申请编号查询待处理的申请
	 * 
	 * @param appliIds
	 * @return
	 */
	public List<CashApplication> findCashByCashIdAndStatus(String[] arr);

}
