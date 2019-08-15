package com.jzhl.kfsq.controller.sm;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.jpush.api.JPushBusiness;
import cn.jpush.api.JPushMember;

import com.jzhl.kfsq.common.base.ListResult;
import com.jzhl.kfsq.common.base.ResponseBean;
import com.jzhl.kfsq.dataset.sm.PushInfoDataSet;
import com.jzhl.kfsq.dto.sm.PushInfoDto;
import com.jzhl.kfsq.dto.sm.PushInfoFindDto;
import com.jzhl.kfsq.dto.sm.PushInfoGetDto;
import com.jzhl.kfsq.entity.sm.PushInfo;
import com.jzhl.kfsq.service.sm.IPushInfoService;

/**
 * 消息推送列表接口类
 * 
 * @author zhouzy
 *
 */
@Controller
public class PushInfoController {

	@Autowired
	private IPushInfoService pushInfoService;

	/**
	 * 消息推送列表
	 * 
	 * @param
	 * @return ResponseBean
	 */
	@SuppressWarnings({ "rawtypes" })
	@RequestMapping(value = "/serv/pushinfo/findpushinfolist", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean findPushInfoList(PushInfoDto pushInfoDto) throws Exception {
		// 分页查询参数
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("rowstart", pushInfoDto.getRowStart());
		map.put("offset", pushInfoDto.getOffset());

		List<PushInfo> pushInfoList = pushInfoService.findPushInfoList(map);

		// 分页返回
		ListResult listResult = new ListResult();
		listResult.setDataList(pushInfoList);

		// 总页数
		int dataCount = pushInfoService.getPushInfoDataCount(map);
		listResult.setDataCount(dataCount);

		ResponseBean<ListResult> result = new ResponseBean<ListResult>(listResult);
		result.operateSuccess();
		return result;
	}

	/**
	 * 新建信息
	 * 
	 * @return ResponseBean
	 */
	@SuppressWarnings({ "rawtypes" })
	@RequestMapping(value = "/serv/pushinfo/insertpushinfo", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean insertPushInfo(PushInfoDto pushInfoDto) throws Exception {

		PushInfo pushInfo = new PushInfo();
		BeanUtils.copyProperties(pushInfoDto, pushInfo);

		// 推送内容插入数据库
		pushInfoService.insertPushInfo(pushInfo);

		boolean tag = true;

		JSONObject json = new JSONObject();
		json.put("pushType", "manualPushType");
		json.put("pushId", pushInfo.getpushId());

		// 判断是否为立即推送
		if (pushInfo.getpushType() == 0) {
			// 判断推送人群;目标人群（0：全部，1：用户端用户，2：商户端用户（售楼员，销售经理）
			if (pushInfo.gettargetGroup().equals("0")) {
				tag = JPushMember.send(pushInfoDto.getTitle(), pushInfoDto.getContent(), json.toString());
				tag = JPushBusiness.send(pushInfoDto.getTitle(), pushInfoDto.getContent(), json.toString());
			} else if (pushInfo.gettargetGroup().equals("1")) {
				tag = JPushMember.send(pushInfoDto.getTitle(), pushInfoDto.getContent(), json.toString());
			} else {
				tag = JPushBusiness.send(pushInfoDto.getTitle(), pushInfoDto.getContent(), json.toString());
			}

			// 发送成功后，把字段设置为成功1
			PushInfo updatePushInfo = new PushInfo();
			updatePushInfo.setpushId(pushInfo.getpushId());
			updatePushInfo.setIsSuccess((short) 1);
			pushInfoService.updatePushInfo(updatePushInfo);

		} else {
			// 定时推送，调用定时器；默认把字段设置为失败0
			PushInfo updatePushInfo = new PushInfo();
			updatePushInfo.setpushId(pushInfo.getpushId());
			updatePushInfo.setIsSuccess((short) 0);
			pushInfoService.updatePushInfo(updatePushInfo);
		}

		if (tag == true) {
			ResponseBean result = new ResponseBean<PushInfo>();
			result.operateSuccess();
			return result;
		} else {
			ResponseBean result = new ResponseBean<PushInfo>();
			result.operateFail("立即推送消息失败!");
			return result;
		}
	}
	
	/**
	 * 新建信息
	 * 
	 * @return ResponseBean
	 */
	@SuppressWarnings({ "rawtypes" })
	@RequestMapping(value = "/serv/pushinfo/insertaliaspushinfo", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean insertAliasPushInfo(PushInfoDto pushInfoDto) throws Exception {

		PushInfo pushInfo = new PushInfo();
		BeanUtils.copyProperties(pushInfoDto, pushInfo);

		// 推送内容插入数据库
		pushInfoService.insertPushInfo(pushInfo);
		
		ResponseBean result = new ResponseBean<PushInfo>();
		result.operateSuccess();
		return result;
	}

	/**
	 * 分页查询会员推送信息
	 * 
	 * @param dto
	 * @return
	 */
	@RequestMapping(value = "/serv/pushinfo/findMemberPushInfo", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean<ListResult> findMemberPushInfos(PushInfoFindDto dto) {

		ListResult result = pushInfoService.findMemberPushInfos(dto.getRowStart(), dto.getOffset(), dto.getMemberId());
		ResponseBean<ListResult> bean = new ResponseBean<ListResult>(result);
		bean.operateSuccess("查询成功");
		return bean;
	}

	/**
	 * 根据推送编号查询推送信息
	 * 
	 * @param dto
	 * @return
	 */
	@RequestMapping(value = "/serv/pushinfo/getPushInfo", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean<PushInfoDataSet> getPushInfo(PushInfoGetDto dto) {

		PushInfoDataSet data = pushInfoService.getPushInfoDataSet(Integer.parseInt(dto.getPushId()));
		ResponseBean<PushInfoDataSet> result = new ResponseBean<PushInfoDataSet>(data);
		result.operateSuccess("查询成功");
		return result;
	}
}
