package com.jzhl.kfsq.dto.sc;

import java.io.Serializable;
import java.sql.Date;

/**
 * 系统参数实体类
 * 
 * @author zhouzy
 *
 */
public class ConfigInfoDto implements Serializable {

	private static final long serialVersionUID = 3892320519857480543L;// 序列化

	private Integer configId;// 配置编号

	private Integer configType;// 配置类型（0：首页价格参数）

	private String configTypeName;// 配置类型名称

	private String configKey;// 配置关键字

	private String configValue;// 配置内容

	private Integer creatorUserId;// 创建人编号

	private Date createTime;// 创建时间

	private Integer updateUserId;// 更新人编号

	private Date updateTime;// 更新时间

	public Integer getConfigId() {
		return configId;
	}

	public void setConfigId(Integer configId) {
		this.configId = configId;
	}

	public Integer getConfigType() {
		return configType;
	}

	public void setConfigType(Integer configType) {
		this.configType = configType;
	}

	public String getConfigTypeName() {
		return configTypeName;
	}

	public void setConfigTypeName(String configTypeName) {
		this.configTypeName = configTypeName;
	}

	public String getConfigKey() {
		return configKey;
	}

	public void setConfigKey(String configKey) {
		this.configKey = configKey;
	}

	public String getConfigValue() {
		return configValue;
	}

	public void setConfigValue(String configValue) {
		this.configValue = configValue;
	}

	public Integer getCreatorUserId() {
		return creatorUserId;
	}

	public void setCreatorUserId(Integer creatorUserId) {
		this.creatorUserId = creatorUserId;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Integer getUpdateUserId() {
		return updateUserId;
	}

	public void setUpdateUserId(Integer updateUserId) {
		this.updateUserId = updateUserId;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	@Override
	public String toString() {
		return "ConfigInfoDto [configId=" + configId + ", configType=" + configType + ", configTypeName=" + configTypeName + ", configKey="
				+ configKey + ", configValue=" + configValue + ", creatorUserId=" + creatorUserId + ", createTime=" + createTime
				+ ", updateUserId=" + updateUserId + ", updateTime=" + updateTime + "]";
	}

}
