package com.jzhl.kfsq.dao.am;

import java.util.List;

import com.jzhl.kfsq.common.base.PageListCondition;
import com.jzhl.kfsq.dto.am.ExerciseDto;
import com.jzhl.kfsq.entity.am.Exercise;

public interface IExerciseMapper {

	public List<Exercise> findExercisesPage(PageListCondition pageListCondition);

	public int findExercisesPageCount(PageListCondition pageListCondition);

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
