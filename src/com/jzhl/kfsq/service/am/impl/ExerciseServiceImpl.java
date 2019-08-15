package com.jzhl.kfsq.service.am.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jzhl.kfsq.common.base.ListResult;
import com.jzhl.kfsq.common.base.PageListCondition;
import com.jzhl.kfsq.dao.am.IExerciseMapper;
import com.jzhl.kfsq.dto.am.ExerciseDto;
import com.jzhl.kfsq.entity.am.Exercise;
import com.jzhl.kfsq.service.am.IExerciseService;

@Service
public class ExerciseServiceImpl implements IExerciseService {

	@Autowired
	private IExerciseMapper exerciseDao;

	@Override
	public ListResult findExercisesPage(PageListCondition pageListCondition) {

		List<Exercise> dataList = exerciseDao.findExercisesPage(pageListCondition);

		int dataCount = exerciseDao.findExercisesPageCount(pageListCondition);

		ListResult result = new ListResult();

		result.setDataList(dataList);

		result.setDataCount(dataCount);

		return result;
	}

	/**
	 * 添加新活动
	 * 
	 * @author zhouzy
	 */
	@Override
	public void insertExercise(ExerciseDto exercise) {
		exerciseDao.insertExercise(exercise);
	}

	/**
	 * 启动、关闭活动
	 * 
	 * @author zhouzy
	 */
	@Override
	public void updateExercise(ExerciseDto exerciseDto) {
		exerciseDao.updateExercise(exerciseDto);
	}

	/**
	 * 查看活动详情
	 * 
	 * @author zhouzy
	 */
	@Override
	public ExerciseDto getExerciseInfo(ExerciseDto exerciseDto) {
		ExerciseDto exerciseInfo = exerciseDao.getExerciseInfo(exerciseDto);
		return exerciseInfo;
	}

}
