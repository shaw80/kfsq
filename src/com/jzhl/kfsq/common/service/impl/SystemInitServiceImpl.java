package com.jzhl.kfsq.common.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jzhl.kfsq.common.base.RedisOperator;
import com.jzhl.kfsq.common.constant.RedisConstant;
import com.jzhl.kfsq.common.service.ISystemInitService;
import com.jzhl.kfsq.common.util.ValidateUtil;
import com.jzhl.kfsq.dao.sm.IVersionUpdateMapper;
import com.jzhl.kfsq.entity.sm.VersionUpdate;

/**
 * 系统初始化处理服务类。<br/>
 * <br/>
 * 
 * 【功能详细】<br/>
 * <ol>
 * <li>系统初始化处理服务类。</li>
 * <p>
 * 1.装载最新的手机端程序版本信息到缓存。
 * </p>
 * </ol>
 * 
 * @author jzhl haojr
 * @version V1.0 2015/11/11 haojr<br/>
 */
@Service
public class SystemInitServiceImpl implements ISystemInitService {
	
	@Autowired
	private IVersionUpdateMapper versionUpdateDao;

	/**
	 * 装载最新的手机端程序版本信息到缓存
	 */
	@Override
	public void loadVersionCache() throws Exception {

		Map<String, Object> params = new HashMap<String, Object>();
		List<VersionUpdate> result = this.versionUpdateDao
				.findVersionUpdateList(params);
		if (ValidateUtil.isNotEmpty(result)) {
			for (VersionUpdate unit : result) {
				if (unit.getType().equals(1)) {
					RedisOperator.addOrUpdateValue(
							RedisConstant.KEY_IOS_C_LAST_VERSION,
							String.valueOf(unit.getUpdateCode()));
				} else if (unit.getType().equals(2)) {
					RedisOperator.addOrUpdateValue(
							RedisConstant.KEY_IOS_B_LAST_VERSION,
							String.valueOf(unit.getUpdateCode()));
				} else if (unit.getType().equals(3)) {
					RedisOperator.addOrUpdateValue(
							RedisConstant.KEY_ANDROID_C_LAST_VERSION,
							String.valueOf(unit.getUpdateCode()));
				} else if (unit.getType().equals(4)) {
					RedisOperator.addOrUpdateValue(
							RedisConstant.KEY_ANDROID_B_LAST_VERSION,
							String.valueOf(unit.getUpdateCode()));
				}
			}
		}

	}

}
