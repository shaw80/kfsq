package com.jzhl.kfsq.dao.cm;

import java.util.List;

import com.jzhl.kfsq.dataset.cm.AppRemindDataSet;
import com.jzhl.kfsq.dto.cm.AppRemindPageDto;

public interface IAppRemindMapper {
	
	public List<AppRemindDataSet> findAppRemindPage(AppRemindPageDto appRemindPageDto);

	public int findAppRemindPageCount(AppRemindPageDto appRemindPageDto);
	
}
