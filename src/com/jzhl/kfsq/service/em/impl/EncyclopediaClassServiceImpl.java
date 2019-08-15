package com.jzhl.kfsq.service.em.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jzhl.kfsq.dao.em.IEncyclopediaClassesMapper;
import com.jzhl.kfsq.entity.em.EncyclopediaClasses;
import com.jzhl.kfsq.service.em.IEncyclopediaClassService;

@Service
public class EncyclopediaClassServiceImpl implements IEncyclopediaClassService {

	@Autowired
	private IEncyclopediaClassesMapper encyclopediaClassesDao;

	/**
	 * 新增二级菜单
	 * 
	 * @author zhouzy
	 */
	@Override
	public void insertEncyclopediaClassMenu(EncyclopediaClasses encyclopediaClass) {
		encyclopediaClassesDao.insertEncyclopediaClassMenu(encyclopediaClass);
	}

	/**
	 * 编辑二级菜单
	 * 
	 * @author zhouzy
	 */
	@Override
	public void updateEncyclopediaClassMenu(EncyclopediaClasses encyclopediaClass) {
		encyclopediaClassesDao.updateEncyclopediaClassMenu(encyclopediaClass);
	}

}
