package com.jzhl.kfsq.dao.sm;

import java.util.List;
import java.util.Map;

import com.jzhl.kfsq.dataset.sm.PushInfoDataSet;
import com.jzhl.kfsq.entity.sm.PushInfo;

/**
 * 消息推送列表接口
 * 
 * @author zhouzy
 *
 */
public interface IPushInfoMapper {

	/**
	 * 消息推送列表
	 */
	public List<PushInfo> findPushInfoList(Map<String, Object> map);

	/**
	 * 消息推送列表总数
	 */
	public int getPushInfoDataCount(Map<String, Object> map);

	/**
	 * 新增信息推送
	 */
	public void insertPushInfo(PushInfo pushInfo);

	/**
	 * 分页查询所有会员（手机普通用户）的推送信息
	 * 
	 * @param map
	 * @return
	 */
	public List<PushInfoDataSet> findMemberPushInfos(Map<String, Object> map);

	/**
	 * 统计推送给会员的信息总数
	 * 
	 * @return
	 */
	public Integer countMemberPushInfo(int memberId);

	/**
	 * 根据推送编号查询推送信息
	 * 
	 * @param pushId
	 * @return
	 */
	public PushInfoDataSet getPushInfoDataSet(int pushId);

	/**
	 * 查询未推送成功的消息列表
	 */
	public List<PushInfo> findNoSendList();

	/**
	 * 定时推送，推送成功后，更新状态
	 */
	public void updatePushInfo(PushInfo pushInfo);

}
