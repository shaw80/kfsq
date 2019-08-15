package com.jzhl.kfsq.dao.bm;

import java.util.List;
import java.util.Map;

import com.jzhl.kfsq.entity.bm.UnitMapTemp;

public interface IUnitMapTempMapper {

	public void insertUnitMapTemp(UnitMapTemp unitMapTemp);
	
	public List<UnitMapTemp> findUnitMapTempList(UnitMapTemp unitMapTemp);
	
	public void updateUnitMapTemp(UnitMapTemp unitMapTemp);

	public void updateUnitMapTempInValid(Map<String, Object> map);
	
	public void updateUnitMapTempSynchronized(Integer buildingId);

}
