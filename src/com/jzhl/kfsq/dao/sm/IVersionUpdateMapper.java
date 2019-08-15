package com.jzhl.kfsq.dao.sm;

import java.util.List;
import java.util.Map;

import com.jzhl.kfsq.dto.sm.VersionAppDto;
import com.jzhl.kfsq.entity.sm.VersionUpdate;

/**
 * 版本更新接口
 * 
 * @author zhouzy
 *
 */
public interface IVersionUpdateMapper {

	/**
	 * 查询各端app版本列表
	 * 
	 */
	public List<VersionUpdate> findVersionUpdateList(Map<String, Object> map);

	/**
	 * 添加版本更新
	 */
	public void insertVersionUpdate(VersionUpdate versionUpdate);

	/**
	 * 把其他版本设置为无效
	 */
	public void updateVersionIsValid(VersionUpdate versionUpdate);

	/**
	 * 查询有效版本
	 */
	public VersionUpdate selectByisValid(VersionUpdate versionUpdate);

	/**
	 * 版本更新
	 */
	public void updateVersionUpdate(VersionUpdate versionUpdate);
	
	
	/**
	 * 根据版本编号和客户端类型查询版本更新信息
	 * 
	 * @param dto
	 * @return
	 */
	public List<VersionUpdate> findVersionsByCodeAndType(VersionAppDto dto);



}
