package com.jzhl.kfsq.dao.em;

import java.util.List;
import java.util.Map;

import com.jzhl.kfsq.entity.em.Encyclopedia;

public interface IEncyclopediaMapper {

	public List<Encyclopedia> findEncyclopedia(Encyclopedia encyclopedia);

	/**
	 * 分页查询文章列表
	 * 
	 * @author zhouzy
	 */
	public List<Encyclopedia> findEncyclopediaList(Map<String, Object> map);

	/**
	 * 分页查询文章列表总页数
	 * 
	 * @author zhouzy
	 */
	public int getEncyclopediaDataCount(Map<String, Object> map);

	/**
	 * 添加文章
	 * 
	 * @author zhouzy
	 */
	public void insertEncyclopedia(Encyclopedia encyclopedia);

	/**
	 * 编辑文章,启用、禁用
	 * 
	 * @author zhouzy
	 */
	public void updateEncyclopedia(Encyclopedia encyclopedia);

}
