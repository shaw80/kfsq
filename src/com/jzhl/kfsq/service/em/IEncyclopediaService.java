package com.jzhl.kfsq.service.em;

import java.util.List;
import java.util.Map;

import com.jzhl.kfsq.dataset.em.EncyclopediaClassDataSet;
import com.jzhl.kfsq.dto.em.EncyclopediaDto;
import com.jzhl.kfsq.entity.em.Encyclopedia;

public interface IEncyclopediaService {

	public EncyclopediaClassDataSet findEncyclopediaClasses(String parentId);

	public List<Encyclopedia> findEncyclopedia(Encyclopedia encyclopedia);

	public EncyclopediaDto getEncyclopediaDto(EncyclopediaDto encyclopediaDto);

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

	/**
	 * 查询所有菜单列表
	 * 
	 * @author zhouzy
	 */
	public EncyclopediaClassDataSet findEncyclopediaMenuAllList(String string);

	/**
	 * 查询百科详情
	 * 
	 * @author zhouzy
	 */
	public EncyclopediaDto getEncyclopediaInfo(EncyclopediaDto encyclopediaDto);

}
