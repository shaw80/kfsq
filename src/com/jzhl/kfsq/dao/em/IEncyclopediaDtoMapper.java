package com.jzhl.kfsq.dao.em;

import com.jzhl.kfsq.dto.em.EncyclopediaDto;

public interface IEncyclopediaDtoMapper {
	
	public EncyclopediaDto getEncyclopediaDto(EncyclopediaDto encyclopediadto);

	/**
	 * 查询百科详情
	 * 
	 * @author zhouzy
	 */
	public EncyclopediaDto getEncyclopediaInfo(EncyclopediaDto encyclopediaDto);
	
}
