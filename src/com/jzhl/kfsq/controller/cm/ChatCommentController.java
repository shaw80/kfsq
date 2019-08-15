package com.jzhl.kfsq.controller.cm;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jzhl.kfsq.common.base.ListResult;
import com.jzhl.kfsq.common.base.ResponseBean;
import com.jzhl.kfsq.dataset.cm.ChatCommentDataSet;
import com.jzhl.kfsq.dto.cm.ChatCommentDto;
import com.jzhl.kfsq.entity.cm.ChatComment;
import com.jzhl.kfsq.entity.cm.CommentImg;
import com.jzhl.kfsq.service.cm.IChatCommentService;

/**
 * 评论管理-问问发表
 * 
 * @author zhouzy
 */
@Controller
public class ChatCommentController {

	@Autowired
	private IChatCommentService chatCommentService;

	/**
	 * 评论管理-问问发表列表
	 * 
	 * @return ResponseBean
	 */
	@SuppressWarnings({ "rawtypes" })
	@RequestMapping(value = "/serv/chatcomment/findchatcommentlist", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean findChatCommentList(ChatCommentDto chatCommentDto) throws Exception {
		// 分页查询参数
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("rowstart", chatCommentDto.getRowStart());
		map.put("offset", chatCommentDto.getOffset());
		// 关键字
		map.put("keyword", chatCommentDto.getKeyword());
		// 审核状态
		map.put("configValue", chatCommentDto.getConfigValue());
		// 查询条件参数
		Integer isValid = chatCommentDto.getIsValid();
		map.put("isValid", isValid);
		List<ChatCommentDataSet> chatCommentList = chatCommentService.findChatCommentList(map);

		// 分页返回
		ListResult listResult = new ListResult();
		listResult.setDataList(chatCommentList);

		// 总页数
		int dataCount = chatCommentService.findChatCommentDataCount(map);
		listResult.setDataCount(dataCount);

		ResponseBean<ListResult> result = new ResponseBean<ListResult>(listResult);
		result.operateSuccess();
		return result;
	}

	/**
	 * 查询评论管理-问问发表详情
	 *
	 * @return ResponseBean
	 */
	@SuppressWarnings({ "rawtypes" })
	@RequestMapping(value = "/serv/chatcomment/getchatcommentinfo", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean getChatCommentinfo(ChatCommentDto chatCommentDto) throws Exception {
		ChatComment chatComment = new ChatComment();
		BeanUtils.copyProperties(chatCommentDto, chatComment);
		// 内容信息
		ChatCommentDataSet chatCommentInfo = chatCommentService.getChatCommentInfo(chatComment);

		// 图片列表
		List<CommentImg> commentImgList = chatCommentService.findCommentImgList(chatComment);

		Map<String, Object> queryResult = new HashMap<String, Object>();
		// 返回数据添加
		queryResult.put("chatCommentInfo", chatCommentInfo);
		queryResult.put("commentImgList", commentImgList);
		ResponseBean<Map<String, Object>> result = new ResponseBean<Map<String, Object>>(queryResult);
		result.operateSuccess();
		return result;
	}

	/**
	 * 审核通过、不通过
	 * 
	 * @return ResponseBean
	 */
	@SuppressWarnings({ "rawtypes" })
	@RequestMapping(value = "/serv/chatcomment/updatechatcomment", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean updateChatComment(ChatCommentDto chatCommentDto) throws Exception {

		ChatComment chatComment = new ChatComment();
		BeanUtils.copyProperties(chatCommentDto, chatComment);

		chatCommentService.updateChatComment(chatComment);
		ResponseBean result = new ResponseBean();
		result.operateSuccess();
		return result;
	}
}
