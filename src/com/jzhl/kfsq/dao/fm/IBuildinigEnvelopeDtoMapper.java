package com.jzhl.kfsq.dao.fm;

import com.jzhl.kfsq.dto.fm.BuildingEnvelopeBalanceDto;
import com.jzhl.kfsq.dto.fm.SalerTotalRedDto;

public interface IBuildinigEnvelopeDtoMapper {

	/**
	 * 楼盘余额
	 * @param buildingEnvelopeBalanceDto
	 * @return
	 */
	public java.math.BigDecimal getBuildingEnvelopeBalance(BuildingEnvelopeBalanceDto buildingEnvelopeBalanceDto);
	
	/**
	 * 查询售楼员已发放红包总额
	 * @param userId
	 * @return
	 */
	public java.math.BigDecimal getSalerTotalRed(SalerTotalRedDto salerTotalRedDto);

}
