package com.jzhl.kfsq.service.sm;

import java.util.List;
import java.util.Map;

import com.jzhl.kfsq.common.base.ListResult;
import com.jzhl.kfsq.dataset.sm.PushInfoDataSet;
import com.jzhl.kfsq.entity.sm.PushInfo;

/**
 * 信息推送列表接口
 * 
 * @author zhouzy
 *
 */
public interface IPushInfoService {

	/**
	 * 信息推送列表
	 * 
	 * @return 信息推送列表
	 */
	public List<PushInfo> findPushInfoList(Map<String, Object> map);

	/**
	 * 信息推送列表总数
	 */
	public int getPushInfoDataCount(Map<String, Object> map);

	/**
	 * 新增信息推送
	 */
	public void insertPushInfo(PushInfo pushInfo);

	/**
	 * 分页查询会员推送信息
	 * 
	 * @param begin
	 * @param length
	 * @return
	 */
	public ListResult findMemberPushInfos(int begin, int length, int memberId);

	/**
	 * 根据推送编号查询推送信息
	 * 
	 * @param pushId
	 * @return
	 */
	public PushInfoDataSet getPushInfoDataSet(int pushId);

	/**
	 * 定时推送
	 * 
	 * @author zhouzy
	 */
	public long timingPush();

	/**
	 * 推送状态更改
	 * 
	 * @author zhouzy
	 */
	public void updatePushInfo(PushInfo updatePushInfo);

}
