package com.jzhl.kfsq.dataset.sm;

import java.io.Serializable;

/**
 * WEB端权限结果集
 * 
 * @author Shaw
 *
 */
public class RightDataSet implements Serializable {

	private static final long serialVersionUID = -457025879201736087L;// 序列化
	
	private Integer rightId;// 权限编号
	
	private Integer parentId;// 父编号
	
	private String rightName;// 权限名称
	
	private boolean permission = false;// 是否拥有此权限（true：有，false：没有）

	public Integer getRightId() {
		return rightId;
	}

	public void setRightId(Integer rightId) {
		this.rightId = rightId;
	}

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public String getRightName() {
		return rightName;
	}

	public void setRightName(String rightName) {
		this.rightName = rightName;
	}

	public boolean isPermission() {
		return permission;
	}

	public void setPermission(boolean permission) {
		this.permission = permission;
	}

	@Override
	public String toString() {
		return "RightDataSet [rightId=" + rightId + ", parentId=" + parentId
				+ ", rightName=" + rightName + ", permission=" + permission
				+ "]";
	}

}
