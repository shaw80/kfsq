package com.jzhl.kfsq.service.fm;

import com.jzhl.kfsq.dto.fm.CityDto;
import com.jzhl.kfsq.entity.fm.EnvelopeSwitch;

/**
 * 红包开关接口
 * 
 * @author zhouzy
 *
 */
public interface IEnvelopeSwitchService {

	/**
	 * 增加总开关
	 */
	public void insertEnvelopeSwitch(EnvelopeSwitch envelopeSwitch);

	/**
	 * 更新总开关状态
	 */
	public void updateEnvelopeSwitch(EnvelopeSwitch envelopeSwitch);

	/**
	 * 根据楼盘编号和开关类型查询总开关信息
	 * 
	 * @param buildingId
	 * @param switchType
	 * @return
	 */
	public EnvelopeSwitch getSwitchByBuildingIdAndSwitchType(int buildingId, int switchType);

	/**
	 * 根据分站编号和开关类型查询总开关信息
	 * 
	 * @param dto
	 * @return
	 */
	public EnvelopeSwitch getEnvelopeSwitchInfo(EnvelopeSwitch envelopeSwitch);
	
	/**
	 * 根据城市编号查询看房红包信息
	 * @param dto
	 * @return
	 */
	public String getSwitchByCityId(CityDto dto);

}
