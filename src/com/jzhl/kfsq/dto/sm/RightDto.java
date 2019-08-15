package com.jzhl.kfsq.dto.sm;

import java.io.Serializable;
import java.sql.Date;

/**
 * 权限实体类
 * 
 * @author zhouzy
 *
 */
public class RightDto implements Serializable {

	private static final long serialVersionUID = 8982489531140017648L;// 序列化
	
	private Integer rightId;// 权限编号
	
	private String rightName;// 权限名称
	
	private Integer status;// 状态（0：无效、1：有效）
	
	private Integer creatorUserId;// 创建者编号
	
	private Date createTime;// 创建时间

	public Integer getRightId() {
		return rightId;
	}

	public void setRightId(Integer rightId) {
		this.rightId = rightId;
	}

	public String getRightName() {
		return rightName;
	}

	public void setRightName(String rightName) {
		this.rightName = rightName;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
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

	@Override
	public String toString() {
		return "RightDto [rightId=" + rightId + ", rightName=" + rightName
				+ ", status=" + status + ", creatorUserId=" + creatorUserId
				+ ", createTime=" + createTime + "]";
	}
	
}
