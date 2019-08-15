package com.jzhl.kfsq.service.sm.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.jpush.api.JPushBusiness;
import cn.jpush.api.JPushMember;

import com.jzhl.kfsq.common.base.ListResult;
import com.jzhl.kfsq.common.util.TimeUtil;
import com.jzhl.kfsq.dao.sm.IPushInfoMapper;
import com.jzhl.kfsq.dataset.sm.PushInfoDataSet;
import com.jzhl.kfsq.entity.sm.PushInfo;
import com.jzhl.kfsq.service.sm.IPushInfoService;

/**
 * 消息推送
 * 
 * @author zhouzy
 *
 */
@Service
public class PushInfoServiceImpl implements IPushInfoService {

	@Autowired
	private IPushInfoMapper pushInfoDao;

	/**
	 * 消息推送列表
	 */
	@Override
	public List<PushInfo> findPushInfoList(Map<String, Object> map) {
		List<PushInfo> result = pushInfoDao.findPushInfoList(map);
		return result;
	}

	/**
	 * 消息推送列表总数
	 */
	@Override
	public int getPushInfoDataCount(Map<String, Object> map) {
		int dataCount = pushInfoDao.getPushInfoDataCount(map);
		return dataCount;
	}

	/**
	 * 新增信息推送
	 */
	@Override
	public void insertPushInfo(PushInfo pushInfo) {
		pushInfoDao.insertPushInfo(pushInfo);

	}

	/**
	 * 分页查询会员推送信息
	 * 
	 * @param begin
	 * @param length
	 * @return
	 */
	@Override
	public ListResult findMemberPushInfos(int begin, int length, int memberId) {

		ListResult result = new ListResult();

		Map<String, Object> params = new HashMap<String, Object>();

		params.put("begin", begin);

		params.put("length", length);
		
		params.put("memberId", memberId);

		List<PushInfoDataSet> dataList = pushInfoDao.findMemberPushInfos(params);

		result.setDataList(dataList);

		Integer count = pushInfoDao.countMemberPushInfo(memberId);

		result.setDataCount(count);

		return result;
	}

	/**
	 * 根据推送编号查询推送信息
	 * 
	 * @param pushId
	 * @return
	 */
	@Override
	public PushInfoDataSet getPushInfoDataSet(int pushId) {

		PushInfoDataSet result = pushInfoDao.getPushInfoDataSet(pushId);

		return result;
	}

	/**
	 * 定时推送
	 * 
	 * @author zhouzy
	 */
	@Override
	public long timingPush() {

		// 查询没有发送成功的推送消息
		List<PushInfo> noSentpushInfoList = pushInfoDao.findNoSendList();
		long count = 0;
		boolean tag = true;
		for (PushInfo pushInfo : noSentpushInfoList) {
			if (TimeUtil.before(pushInfo.getcustomTime())) {

				// 推送类型： key: pushType ；json: value: 0：自动推送; 1：手动推送
				JSONObject json = new JSONObject();
				json.put("pushType", "manualPushType");
				json.put("pushId", pushInfo.getpushId());

				// 判断推送人群;目标人群（0：全部，1：用户端用户，2：商户端用户（售楼员，销售经理）
				if (pushInfo.gettargetGroup().equals("0")) {
					tag = JPushMember.send(pushInfo.getTitle(), pushInfo.getContent(), json.toString());
					tag = JPushBusiness.send(pushInfo.getTitle(), pushInfo.getContent(), json.toString());
				} else if (pushInfo.gettargetGroup().equals("1")) {
					tag = JPushMember.send(pushInfo.getTitle(), pushInfo.getContent(), json.toString());
				} else {
					tag = JPushBusiness.send(pushInfo.getTitle(), pushInfo.getContent(), json.toString());
				}

				// 如果发送成功；更新数据库
				if (tag == true) {
					count++;
					// 发送成功后，把字段设置为成功1
					pushInfo.setIsSuccess((short) 1);
					pushInfoDao.updatePushInfo(pushInfo);
				}
			}
		}

		return count;
	}

	/**
	 * 推送状态更改
	 * 
	 * @author zhouzy
	 */
	@Override
	public void updatePushInfo(PushInfo updatePushInfo) {
		pushInfoDao.updatePushInfo(updatePushInfo);
	}
}
