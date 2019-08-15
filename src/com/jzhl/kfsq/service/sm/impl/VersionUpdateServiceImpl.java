package com.jzhl.kfsq.service.sm.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jzhl.kfsq.common.base.RedisOperator;
import com.jzhl.kfsq.common.constant.RedisConstant;
import com.jzhl.kfsq.dao.sm.IVersionUpdateMapper;
import com.jzhl.kfsq.dataset.sm.VersionUpdateDataSet;
import com.jzhl.kfsq.dto.sm.VersionAppDto;
import com.jzhl.kfsq.entity.sm.VersionUpdate;
import com.jzhl.kfsq.service.sm.IVersionUpdateService;

/**
 * 版本更新
 * 
 * @author zhouzy
 *
 */
@Service
public class VersionUpdateServiceImpl implements IVersionUpdateService {

	@Autowired
	private IVersionUpdateMapper versionUpdateDao;

	/**
	 * 查询各端app版本列表
	 * 
	 */
	@Override
	public List<VersionUpdate> findVersionUpdateList(Map<String, Object> map) {
		List<VersionUpdate> result = versionUpdateDao.findVersionUpdateList(map);
		return result;
	}

	/**
	 * 新增更新版本
	 */
	@Override
	public void insertVersionUpdate(VersionUpdate versionUpdate) {

		// 查看当前编辑信息原信息
		VersionUpdate versionInfoOld = versionUpdateDao.selectByisValid(versionUpdate);

		// 如果updateCode升级编码不变，则默认为当前版本编辑；只更新提交内容
		if (versionInfoOld.getUpdateCode().equals(versionUpdate.getUpdateCode())) {
			versionUpdateDao.updateVersionUpdate(versionUpdate);
		} else {
			// 如果updateCode升级编码改变，则认为版本升级，向数据库中插入信息；并且把其他版本置为无效；
			versionUpdate.setVersionId(null);
			versionUpdateDao.insertVersionUpdate(versionUpdate);

			// 并且把其他版本置为无效；
			versionUpdateDao.updateVersionIsValid(versionUpdate);

			// 保存成功后，在Redis中加缓存；类型（1：iOS C端，2：iOS B端，3：android C端，4：android B端）
			if (versionUpdate.getType().equals(1)) {
				RedisOperator.addOrUpdateValue(RedisConstant.KEY_IOS_C_LAST_VERSION, versionUpdate.getUpdateCode());
			} else if (versionUpdate.getType().equals(2)) {
				RedisOperator.addOrUpdateValue(RedisConstant.KEY_IOS_B_LAST_VERSION, versionUpdate.getUpdateCode());
			} else if (versionUpdate.getType().equals(3)) {
				RedisOperator.addOrUpdateValue(RedisConstant.KEY_ANDROID_C_LAST_VERSION, versionUpdate.getUpdateCode());
			} else if (versionUpdate.getType().equals(4)) {
				RedisOperator.addOrUpdateValue(RedisConstant.KEY_ANDROID_B_LAST_VERSION, versionUpdate.getUpdateCode());
			}
		}
	}

	@Override
	public VersionUpdate selectByisValid(VersionUpdate versionUpdate) {
		return versionUpdateDao.selectByisValid(versionUpdate);
	}

	/**
	 * 根据版本编号和客户端类型查询版本更新信息
	 * 
	 * @param dto
	 * @return
	 */
	@Override
	public VersionUpdateDataSet findVersionsByCodeAndType(VersionAppDto dto) {
		List<VersionUpdate> list = versionUpdateDao.findVersionsByCodeAndType(dto);// 根据版本编号和客户端类型查询高于此版本编号的版本列表，版本编号倒序排列
		VersionUpdateDataSet result = new VersionUpdateDataSet();
		if (list.size() > 0 && list != null) {
			for (VersionUpdate versionUpdate : list) {
				if (versionUpdate.getIsUpdate().equals(1)) {// 遍历集合，如果有版本为强制更新，则退出循环，把结果集中是否强制更新改为1
					result.setIsUpdate(1);
					break;
				} else {
					result.setIsUpdate(0);
				}
			}
			VersionUpdate vu = list.get(0);// 获取集合中第一个元素，集合中为版本编号倒序排列，故：获得的元素为版本号最高的最新版本
			result.setVersionNum(vu.getVersionNum());
			result.setUpdateCode(vu.getUpdateCode());
			result.setVersionTitle(vu.getVersionTitle());
			result.setVersionInfo(vu.getVersionInfo());
			result.setFilePath(vu.getFilePath());
			result.setFileSize(vu.getFileSize());
		}
		return result;
	}

}
