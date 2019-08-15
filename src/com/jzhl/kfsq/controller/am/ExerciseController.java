package com.jzhl.kfsq.controller.am;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jzhl.kfsq.common.base.ListResult;
import com.jzhl.kfsq.common.base.PageListCondition;
import com.jzhl.kfsq.common.base.ResponseBean;
import com.jzhl.kfsq.dto.am.ExerciseDto;
import com.jzhl.kfsq.service.am.IExerciseService;

@Controller
public class ExerciseController {

	@Autowired
	private IExerciseService exercisesService;

	/**
	 * 分页查询活动
	 * 
	 * @return
	 */
	@RequestMapping(value = "/serv/exercises", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean<ListResult> findExercises(PageListCondition condition) {

		ListResult listResult = exercisesService.findExercisesPage(condition);

		return new ResponseBean<ListResult>(listResult);
	}

	/**
	 * 添加新活动
	 * 
	 * @author zhouzy
	 * @return ResponseBean
	 */
	@SuppressWarnings({ "rawtypes" })
	@RequestMapping(value = "/serv/exercise/insertexercise", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean insertExercise(ExerciseDto exerciseDto) throws Exception {

		// 新增活动插入数据
		exercisesService.insertExercise(exerciseDto);

		ResponseBean result = new ResponseBean();
		result.operateSuccess();
		return result;
	}

	/**
	 * 启动、关闭活动
	 * 
	 * @author zhouzy
	 * @return ResponseBean
	 */
	@SuppressWarnings({ "rawtypes" })
	@RequestMapping(value = "/serv/exercise/updateexercise", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean updateExercise(ExerciseDto exerciseDto) throws Exception {

		exercisesService.updateExercise(exerciseDto);

		ResponseBean result = new ResponseBean();
		result.operateSuccess();
		return result;
	}

	/**
	 * 查询活动详情
	 * 
	 * @author zhouzy
	 * @return ResponseBean
	 */
	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "/serv/exercise/exerciseinfo", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean getExerciseInfo(ExerciseDto exerciseDto) throws Exception {
		ExerciseDto queryResult = exercisesService.getExerciseInfo(exerciseDto);
		ResponseBean<ExerciseDto> result = new ResponseBean<ExerciseDto>(queryResult);
		result.operateSuccess();
		return result;
	}

}
