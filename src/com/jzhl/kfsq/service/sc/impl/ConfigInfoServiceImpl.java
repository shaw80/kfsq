package com.jzhl.kfsq.service.sc.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jzhl.kfsq.dao.sc.IConfigInfoMapper;
import com.jzhl.kfsq.dto.sc.ConfigInfoDto;
import com.jzhl.kfsq.entity.sc.ConfigInfo;
import com.jzhl.kfsq.service.sc.IConfigInfoService;

/**
 * 系统参数配置业务层实现类
 * 
 * @author Shaw
 *
 */
@Service
public class ConfigInfoServiceImpl implements IConfigInfoService {

	@Autowired
	private IConfigInfoMapper configInfoDao;

	/**
	 * 根据配置类型查询配置信息
	 * 
	 * @param configType
	 * @return
	 */
	@Override
	public List<ConfigInfo> findConfigInfoByConfigType(int configType) {
		List<ConfigInfo> result = configInfoDao.findConfigInfoByConfigType(configType);
		return result;
	}

	/**
	 * 余额提醒设置
	 *
	 * @author zhouzy
	 */
	@Override
	public void updateConfigInfo(ConfigInfo configInfo) {
		configInfoDao.updateConfigInfo(configInfo);
	}

	/**
	 * 查看参数配置信息表信息
	 * 
	 * @author zhouzy
	 */
	@Override
	public ConfigInfo getConfigInfoByObj(ConfigInfo configInfo) {
		ConfigInfo result = configInfoDao.getConfigInfoByObj(configInfo);
		return result;
	}

	/**
	 * 查看参数配置信息列表
	 * 
	 * @author zhouzy
	 */
	@Override
	public List<ConfigInfo> findConfigInfoList(ConfigInfoDto configInfoDto) {
		List<ConfigInfo> result = configInfoDao.findConfigInfoList(configInfoDto);
		return result;
	}

	/**
	 * 插入参数配置信息
	 * 
	 * @author zhouzy
	 */
	@Override
	public void insertConfigInfo(ConfigInfo configInfo) {
		configInfoDao.insertConfigInfo(configInfo);
	}

}
