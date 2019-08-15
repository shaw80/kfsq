package com.jzhl.kfsq.entity.sm;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 首页价格信息实体类
 * 
 * @author Shaw
 *
 */
public class PriceInfo implements Serializable {

	private static final long serialVersionUID = 5345315776643942127L;// 序列化

	private Integer priceId;// 价格编号，主键

	private Integer minPrice;// 价格最小值

	private Integer maxPrice;// 价格最大值

	private Timestamp createTime;// 创建时间

	private Timestamp updateTime;// 更新时间

	private Integer isValid;// 0：无效，1：有效

	public Integer getPriceId() {
		return priceId;
	}

	public void setPriceId(Integer priceId) {
		this.priceId = priceId;
	}

	public Integer getMinPrice() {
		return minPrice;
	}

	public void setMinPrice(Integer minPrice) {
		this.minPrice = minPrice;
	}

	public Integer getMaxPrice() {
		return maxPrice;
	}

	public void setMaxPrice(Integer maxPrice) {
		this.maxPrice = maxPrice;
	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
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
		return "PriceInfo [priceId=" + priceId + ", minPrice=" + minPrice + ", maxPrice=" + maxPrice + ", createTime=" + createTime
				+ ", updateTime=" + updateTime + ", isValid=" + isValid + "]";
	}

}
