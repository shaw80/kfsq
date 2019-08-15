package com.jzhl.kfsq.dao.sc;

import java.util.List;

import com.jzhl.kfsq.dto.sc.ConfigInfoDto;
import com.jzhl.kfsq.entity.sc.ConfigInfo;

/**
 * 系统参数配置数据访问层接口
 * 
 * @author Shaw
 *
 */
public interface IConfigInfoMapper {

	/**
	 * 根据配置类型查询配置信息
	 * 
	 * @param configType
	 * @return
	 */
	public List<ConfigInfo> findConfigInfoByConfigType(int configType);

	/**
	 * 余额提醒设置
	 *
	 * @author zhouzy
	 */
	public void updateConfigInfo(ConfigInfo configInfo);

	/**
	 * 查看参数配置信息表信息
	 * 
	 * @author zhouzy
	 */
	public ConfigInfo getConfigInfoByObj(ConfigInfo configInfo);

	/**
	 * 查看参数配置信息列表
	 * 
	 * @author zhouzy
	 */
	public List<ConfigInfo> findConfigInfoList(ConfigInfoDto configInfoDto);

	/**
	 * 插入参数配置信息
	 * 
	 * @author zhouzy
	 */
	public void insertConfigInfo(ConfigInfo configInfo);

}
