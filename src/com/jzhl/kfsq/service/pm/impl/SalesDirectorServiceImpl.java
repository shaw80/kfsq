package com.jzhl.kfsq.service.pm.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jzhl.kfsq.common.base.ListResult;
import com.jzhl.kfsq.dao.pm.ISalesDirectorMapper;
import com.jzhl.kfsq.dataset.pm.SalesDirectoVisitDataSet;
import com.jzhl.kfsq.dto.pm.SalesDirectorCountDto;
import com.jzhl.kfsq.service.pm.ISalesDirectorService;

@Service
public class SalesDirectorServiceImpl implements ISalesDirectorService {
	
	@Autowired
	private ISalesDirectorMapper salesDirectorDao;
	
	@Override
	public ListResult findVisitTeamPage(SalesDirectorCountDto salesDirectorCountDto) {
		ListResult result = new ListResult();
		int dataCount = salesDirectorDao.countVisitTeam(salesDirectorCountDto);
		List<SalesDirectoVisitDataSet> dataList = salesDirectorDao.findVisitTeam(salesDirectorCountDto);
		
		for (int i = 0; i < dataList.size(); i++) {
			dataList.get(i).setRank(salesDirectorCountDto.getRowStart() + i + 1);
			dataList.get(i).setUserName(
					dataList.get(i).getUserName() + "的团队");
		}
		
		result.setDataList(dataList);
		result.setDataCount(dataCount);
		return result;
	}
	
	
	
}
