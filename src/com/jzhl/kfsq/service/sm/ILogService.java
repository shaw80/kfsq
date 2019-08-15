package com.jzhl.kfsq.service.sm;

import java.util.List;

import com.jzhl.kfsq.common.base.PageListCondition;
import com.jzhl.kfsq.dto.sm.LogDto;

public interface ILogService {
 //插入日志
	public void insert(LogDto dto);
	
  //查询列表
	public List<LogDto> findLogList(PageListCondition page);
  //获得总数
	public int getCount();
}
