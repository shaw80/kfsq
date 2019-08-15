package com.jzhl.kfsq.service.sm;

import java.util.List;
import java.util.Map;

import com.jzhl.kfsq.dataset.sm.VersionUpdateDataSet;
import com.jzhl.kfsq.dto.sm.VersionAppDto;
import com.jzhl.kfsq.entity.sm.VersionUpdate;

/**
 * 版本更新接口
 * 
 * @author zhouzy
 *
 */
public interface IVersionUpdateService {

	/**
	 * 查询各端app版本列表
	 * 
	 */
	public List<VersionUpdate> findVersionUpdateList(Map<String, Object> map);

	/**
	 * 添加账户信息
	 * 
	 */
	public void insertVersionUpdate(VersionUpdate versionUpdate);

	/**
	 * 查询有效版本
	 */
	public VersionUpdate selectByisValid(VersionUpdate versionUpdate);

	/**
	 * 根据版本编号和客户端类型查询版本更新信息
	 * 
	 * @param dto
	 * @return
	 */
	public VersionUpdateDataSet findVersionsByCodeAndType(VersionAppDto dto);
}
