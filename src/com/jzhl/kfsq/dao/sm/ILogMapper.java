package com.jzhl.kfsq.dao.sm;

import java.util.List;

import com.jzhl.kfsq.common.base.PageListCondition;
import com.jzhl.kfsq.dto.sm.LogDto;

public interface ILogMapper {
        
	 //插入日志
		public void insert(LogDto dto);
		
	  //查询列表
		public List<LogDto> findLogList(PageListCondition page);
		
		//查询列表总数
		
		public int getNumber();
}
