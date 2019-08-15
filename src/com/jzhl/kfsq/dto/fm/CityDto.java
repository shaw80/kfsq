package com.jzhl.kfsq.dto.fm;

import java.io.Serializable;

/**
 * 根据城市编号查询看房红包信息DTO
 * 
 * @author Shaw
 *
 */
public class CityDto implements Serializable {

	private static final long serialVersionUID = 1045143288036505065L;// 序列化
	
	private String cityId;// 城市编号

	public String getCityId() {
		return cityId;
	}

	public void setCityId(String cityId) {
		this.cityId = cityId;
	}

	@Override
	public String toString() {
		return "CityDto [cityId=" + cityId + "]";
	}

}
