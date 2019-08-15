package com.jzhl.kfsq.dao.fm;

import java.util.Map;

import com.jzhl.kfsq.entity.fm.EnvelopeSwitch;

/**
 * 红包开关接口
 * 
 * @author zhouzy
 *
 */
public interface IEnvelopeSwitchMapper {

	/**
	 * 增加红包开关接口
	 */
	public void insertEnvelopeSwitch(EnvelopeSwitch envelopeSwitch);

	/**
	 * 更新总开关状态
	 */
	public void updateEnvelopeSwitch(EnvelopeSwitch envelopeSwitch);

	/**
	 * 根据楼盘编号和开关类型查询总开关信息
	 * 
	 * @param param
	 * @return
	 */
	public EnvelopeSwitch getSwitchByBuildingIdAndSwitchType(Map<String, Object> param);

	/**
	 * 根据分站编号和开关类型查询总开关信息
	 * 
	 * @param dto
	 * @return
	 */
	public EnvelopeSwitch getEnvelopeSwitchInfo(EnvelopeSwitch envelopeSwitch);
	
	/**
	 * 根据楼盘编号和开关类型查询看房红包总开关信息
	 * @param param
	 * @return
	 */
	public EnvelopeSwitch getSwitchByBuildingIdAndSwitchTypeForLookhouse(int buildingId);
	
	/**
	 * 根据城市编号查询看房红包信息
	 * @param cityId
	 * @return
	 */
	public EnvelopeSwitch getSwitchByCityId(int cityId);

}
