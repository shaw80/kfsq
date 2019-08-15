package com.jzhl.kfsq.service.am;

import com.jzhl.kfsq.common.base.ListResult;
import com.jzhl.kfsq.common.base.PageListCondition;
import com.jzhl.kfsq.dto.am.ExerciseDto;

public interface IExerciseService {

	ListResult findExercisesPage(PageListCondition condition);

	/**
	 * 添加新活动
	 * 
	 * @author zhouzy
	 */
	public void insertExercise(ExerciseDto exercise);

	/**
	 * 启动、关闭活动
	 * 
	 * @author zhouzy
	 */
	public void updateExercise(ExerciseDto exerciseDto);

	/**
	 * 查看活动详情
	 * 
	 * @author zhouzy
	 */
	public ExerciseDto getExerciseInfo(ExerciseDto exerciseDto);

}
