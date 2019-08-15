package com.jzhl.kfsq.controller.fm;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jzhl.kfsq.common.base.ListResult;
import com.jzhl.kfsq.common.base.ResponseBean;
import com.jzhl.kfsq.dto.fm.CommentEnvelopeChanceDto;
import com.jzhl.kfsq.entity.fm.CommentEnvelopeChance;
import com.jzhl.kfsq.service.fm.ICommentEnvelopeChanceService;
import com.jzhl.kfsq.service.fm.IEnvelopeRechargeService;

/**
 * 红包管理-评论红包规则接口类
 * 
 * @author zhouzy
 *
 */
@Controller
public class CommentEnvelopeChanceController {

	@Autowired
	private ICommentEnvelopeChanceService commentEnvelopeChanceService;

	@Autowired
	private IEnvelopeRechargeService envelopeRechargeService;

	/**
	 * 新增评论红包规则
	 */
	@SuppressWarnings({ "rawtypes" })
	@RequestMapping(value = "/serv/commentenvelopechance/insertcommentenvelopechance", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean insertCommentEnvelopeChance(CommentEnvelopeChanceDto commentEnvelopeChanceDto) throws Exception {

		CommentEnvelopeChance commentEnvelopeChance = new CommentEnvelopeChance();
		BeanUtils.copyProperties(commentEnvelopeChanceDto, commentEnvelopeChance);

		// 插入红包规则
		commentEnvelopeChanceService.insertCommentEnvelopeChance(commentEnvelopeChance);

		ResponseBean result = new ResponseBean();
		result.operateSuccess();
		return result;
	}

	/**
	 * 编辑评论红包规则
	 */
	@SuppressWarnings({ "rawtypes" })
	@RequestMapping(value = "/serv/commentenvelopechance/updatecommentenvelopechance", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean updateCommentEnvelopeChance(CommentEnvelopeChanceDto commentEnvelopeChanceDto) throws Exception {

		CommentEnvelopeChance commentEnvelopeChance = new CommentEnvelopeChance();
		BeanUtils.copyProperties(commentEnvelopeChanceDto, commentEnvelopeChance);

		// 编辑红包规则
		commentEnvelopeChanceService.updateCommentEnvelopeChance(commentEnvelopeChance);

		ResponseBean result = new ResponseBean();
		result.operateSuccess();
		return result;
	}

	/**
	 * 评论红包规则列表
	 * 
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "/serv/commentenvelopechance/commentenvelopechancelist", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean findCommentEnvelopeChanceList(CommentEnvelopeChanceDto commentEnvelopeChanceDto) throws Exception {

		CommentEnvelopeChance commentEnvelopeChance = new CommentEnvelopeChance();
		BeanUtils.copyProperties(commentEnvelopeChanceDto, commentEnvelopeChance);

		List<CommentEnvelopeChance> commentEnvelopeChanceList = commentEnvelopeChanceService
				.findCommentEnvelopeChanceList(commentEnvelopeChance);

		// 分页返回
		ListResult listResult = new ListResult();
		listResult.setDataList(commentEnvelopeChanceList);

		// 总条数
		listResult.setDataCount(commentEnvelopeChanceList.size());

		ResponseBean<ListResult> result = new ResponseBean<ListResult>(listResult);
		result.operateSuccess();
		return result;
	}
}
