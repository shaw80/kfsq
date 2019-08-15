package com.jzhl.kfsq.controller.cm;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jzhl.kfsq.common.base.ListResult;
import com.jzhl.kfsq.common.base.ResponseBean;
import com.jzhl.kfsq.dto.cm.CommentTypeDto;
import com.jzhl.kfsq.entity.cm.CommentType;
import com.jzhl.kfsq.service.cm.ICommentTypeService;

/**
 * 评论类型表管理类
 * 
 * @author zhouzy
 */
@Controller
public class CommentTypeController {

	@Autowired
	private ICommentTypeService commentTypeService;

	/**
	 * 评论类型表列表
	 * 
	 * @return ResponseBean
	 */
	@SuppressWarnings({ "rawtypes" })
	@RequestMapping(value = "/serv/commentType/findCommentTypeList", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean findCommentTypeList(CommentTypeDto commentTypeDto) throws Exception {
		// 分页查询参数
		Map<String, Object> map = new HashMap<String, Object>();

		// 查询条件参数
		map.put("commentId", commentTypeDto.getCommentId());
		List<CommentType> commentTypeList = commentTypeService.findCommentTypeList(map);

		// 分页返回
		ListResult listResult = new ListResult();
		listResult.setDataList(commentTypeList);
		// 总页数
		listResult.setDataCount(commentTypeList.size());

		ResponseBean<ListResult> result = new ResponseBean<ListResult>(listResult);
		result.operateSuccess();
		return result;
	}

	/**
	 * 分类
	 * 
	 */
	@SuppressWarnings({ "rawtypes" })
	@RequestMapping(value = "/serv/commentType/addCommentType", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean addCommentType(CommentTypeDto commentTypeDto) {

		// 分页查询参数
		Map<String, Object> map = new HashMap<String, Object>();
		// 查询条件参数
		map.put("commentId", commentTypeDto.getCommentId());
		// 先按品论Id删除原有数据
		commentTypeService.deleteCommentTypeList(map);

		String[] commentTypeList = commentTypeDto.getCommentTypeList().split(",");

		// 插入数据
		for (int i = 0; i < commentTypeList.length; i++) {
			CommentType commentType = new CommentType();
			commentType.setCommentId(commentTypeDto.getCommentId());
			commentType.setCommentType(Integer.parseInt(commentTypeList[i]));
			commentType.setCreatorUserId(commentTypeDto.getCreatorUserId());
			// 插入数据
			commentTypeService.saveCommentType(commentType);
		}

		// 返回
		Map<String, Object> queryResult = new HashMap<String, Object>();
		ResponseBean<Map<String, Object>> result = new ResponseBean<Map<String, Object>>(queryResult);
		result.operateSuccess();
		return result;
	}
}
