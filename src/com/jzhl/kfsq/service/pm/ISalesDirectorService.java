package com.jzhl.kfsq.service.pm;

import com.jzhl.kfsq.common.base.ListResult;
import com.jzhl.kfsq.dto.pm.SalesDirectorCountDto;

public interface ISalesDirectorService {

	public ListResult findVisitTeamPage(SalesDirectorCountDto salesDirectorCountDto);

}
