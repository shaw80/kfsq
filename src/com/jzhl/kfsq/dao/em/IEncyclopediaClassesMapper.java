package com.jzhl.kfsq.dao.em;

import java.util.List;

import com.jzhl.kfsq.entity.em.EncyclopediaClasses;

public interface IEncyclopediaClassesMapper {

	public List<EncyclopediaClasses> findEncyclopediaClasses(EncyclopediaClasses encyclopediaClasses);

	/**
	 * 新增二级菜单
	 * 
	 * @author zhouzy
	 */
	public void insertEncyclopediaClassMenu(EncyclopediaClasses encyclopediaClass);

	/**
	 * 编辑二级菜单
	 * 
	 * @author zhouzy
	 */
	public void updateEncyclopediaClassMenu(EncyclopediaClasses encyclopediaClass);

}
