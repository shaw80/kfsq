package com.jzhl.kfsq.dao.pm;

import java.util.List;

import com.jzhl.kfsq.dataset.pm.SalesDirectoVisitDataSet;
import com.jzhl.kfsq.dto.pm.SalesDirectorCountDto;

public interface ISalesDirectorMapper {
	
	/**
	 * 根据销售经理编号分页查询某段时间本楼盘所有团队到访业绩
	 * @param salesDirectorCountDto
	 * @return
	 */
	public List<SalesDirectoVisitDataSet> findVisitTeam(SalesDirectorCountDto salesDirectorCountDto);
	
	/**
	 * 根据营销总监编号统计本楼盘所有团队的某段时间到访业绩的数据量
	 * @param salesDirectorCountDto
	 * @return
	 */
	public Integer countVisitTeam(SalesDirectorCountDto salesDirectorCountDto);
	
}
