package com.jzhl.kfsq.dto.fm;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 红包总开关实体类
 * 
 * @author Shaw
 *
 */
public class EnvelopeSwitchDto implements Serializable {

	private static final long serialVersionUID = 7762109054916340299L;// 序列化

	private Integer switchId;// 开关编号，主键

	private Integer branchId;// 分站编号

	private Integer switchType;// 开关类型（0：评论红包，1：看房红包）

	private Integer switchStatus;// 开关状态（0：默认关闭，1：开启）

	private Integer updateUserId;// 更新者编号

	private Timestamp updateTime;// 更新时间

	private Integer isValid;// 0：无效，1：有效

	public Integer getSwitchId() {
		return switchId;
	}

	public void setSwitchId(Integer switchId) {
		this.switchId = switchId;
	}

	public Integer getBranchId() {
		return branchId;
	}

	public void setBranchId(Integer branchId) {
		this.branchId = branchId;
	}

	public Integer getSwitchType() {
		return switchType;
	}

	public void setSwitchType(Integer switchType) {
		this.switchType = switchType;
	}

	public Integer getSwitchStatus() {
		return switchStatus;
	}

	public void setSwitchStatus(Integer switchStatus) {
		this.switchStatus = switchStatus;
	}

	public Integer getUpdateUserId() {
		return updateUserId;
	}

	public void setUpdateUserId(Integer updateUserId) {
		this.updateUserId = updateUserId;
	}

	public Timestamp getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}

	public Integer getIsValid() {
		return isValid;
	}

	public void setIsValid(Integer isValid) {
		this.isValid = isValid;
	}

	@Override
	public String toString() {
		return "EnvelopeSwitchDto [switchId=" + switchId + ", branchId=" + branchId + ", switchType=" + switchType + ", switchStatus="
				+ switchStatus + ", updateUserId=" + updateUserId + ", updateTime=" + updateTime + ", isValid=" + isValid + "]";
	}

}
