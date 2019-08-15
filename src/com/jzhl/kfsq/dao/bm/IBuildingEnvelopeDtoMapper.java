package com.jzhl.kfsq.dao.bm;

import java.util.List;

import com.jzhl.kfsq.dto.bm.BuildingDto;
import com.jzhl.kfsq.dto.bm.BuildingEnvelopeDto;


public interface IBuildingEnvelopeDtoMapper {

	public List<BuildingEnvelopeDto> findBuildingEnvelopeDto(BuildingDto dto);

	public int findBuildingEnvelopeDtoCount(BuildingDto dto);

}
