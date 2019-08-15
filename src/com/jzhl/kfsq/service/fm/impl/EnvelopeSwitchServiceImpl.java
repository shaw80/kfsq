package com.jzhl.kfsq.service.fm.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jzhl.kfsq.dao.fm.IEnvelopeSwitchMapper;
import com.jzhl.kfsq.dto.fm.CityDto;
import com.jzhl.kfsq.entity.fm.EnvelopeSwitch;
import com.jzhl.kfsq.service.fm.IEnvelopeSwitchService;

/**
 * 红包开关接口
 * 
 * @author zhouzy
 *
 */
@Service
public class EnvelopeSwitchServiceImpl implements IEnvelopeSwitchService {

	@Autowired
	private IEnvelopeSwitchMapper envelopeSwitchDao;

	/**
	 * 增加红包开关接口
	 */
	@Override
	public void insertEnvelopeSwitch(EnvelopeSwitch envelopeSwitch) {
		envelopeSwitchDao.insertEnvelopeSwitch(envelopeSwitch);
	}

	/**
	 * 更新总开关状态
	 */
	@Override
	public void updateEnvelopeSwitch(EnvelopeSwitch envelopeSwitch) {
		envelopeSwitchDao.updateEnvelopeSwitch(envelopeSwitch);
	}

	/**
	 * 根据楼盘编号和开关类型查询总开关信息
	 * @param buildingId
	 * @param switchType
	 * @return
	 */
	@Override
	public EnvelopeSwitch getSwitchByBuildingIdAndSwitchType(int buildingId,
			int switchType) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("buildingId", buildingId);
		param.put("switchType", switchType);
		EnvelopeSwitch es = envelopeSwitchDao.getSwitchByBuildingIdAndSwitchType(param);
		return es;
	}

	/**
	 * 根据分站编号和开关类型查询总开关信息
	 * 
	 * @param dto
	 * @return
	 */
	@Override
	public EnvelopeSwitch getEnvelopeSwitchInfo(EnvelopeSwitch envelopeSwitch) {
		EnvelopeSwitch result = envelopeSwitchDao.getEnvelopeSwitchInfo(envelopeSwitch);
		return result;
	}

	/**
	 * 根据城市编号查询看房红包信息
	 * @param dto
	 * @return
	 */
	@Override
	public String getSwitchByCityId(CityDto dto) {
		EnvelopeSwitch es = envelopeSwitchDao.getSwitchByCityId(Integer.parseInt(dto.getCityId()));
		String isEnable = "false";
		if(es.getSwitchStatus() == 1){
			isEnable = "true";
		}
		return isEnable;
	}

}
