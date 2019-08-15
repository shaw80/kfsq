package com.jzhl.kfsq.controller.sm;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jzhl.kfsq.common.base.ResponseBean;
import com.jzhl.kfsq.dto.sm.ContentInfoDto;
import com.jzhl.kfsq.entity.sm.ContentInfo;
import com.jzhl.kfsq.service.sm.IContentInfoService;

/**
 * 内容信息管理类
 * 
 * @author Shaw
 *
 */
@Controller
public class ContentInfoController {

	@Autowired
	private IContentInfoService contentInfoService;

	/**
	 * 根据内容类型查询内容信息
	 * 
	 * @return
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/serv/findContent", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean findContentInfo(String contentType) {

		List<ContentInfo> contents = contentInfoService.findContentInfoByContentType(Integer.parseInt(contentType));

		ResponseBean result = new ResponseBean();

		result.operateSuccess("查询成功");

		Map<String, Object> map = new HashMap<String, Object>();

		map.put("bean", contents);

		result.setJsonData(map);

		return result;
	}

	/**
	 * 启动页；设置跳转链接;设置启动页图片
	 * 
	 * @author zhouzy
	 */
	@SuppressWarnings({ "rawtypes" })
	@RequestMapping(value = "/serv/contentinfo/updatecontentinfo", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean updateContentInfo(ContentInfoDto contentInfoDto) throws Exception {
		ContentInfo contentInfo = new ContentInfo();
		BeanUtils.copyProperties(contentInfoDto, contentInfo);
		contentInfoService.updateContentInfo(contentInfo);
		ResponseBean result = new ResponseBean<>();
		result.operateSuccess();
		return result;
	}

	/**
	 * 查看文本内容信息表信息
	 * 
	 * @author zhouzy
	 */
	@SuppressWarnings({ "rawtypes" })
	@RequestMapping(value = "/serv/contentinfo/getcontentinfobyobj", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean getContentInfoByObj(ContentInfoDto contentInfoDto) throws Exception {
		ContentInfo contentInfo = new ContentInfo();
		BeanUtils.copyProperties(contentInfoDto, contentInfo);
		ContentInfo contentInfoResult = contentInfoService.getContentInfoByObj(contentInfo);
		ResponseBean<ContentInfo> result = new ResponseBean<ContentInfo>(contentInfoResult);
		result.operateSuccess();
		return result;
	}
}
