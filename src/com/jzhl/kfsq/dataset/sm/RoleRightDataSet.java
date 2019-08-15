package com.jzhl.kfsq.dataset.sm;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 角色权限结果集
 * 
 * @author Shaw
 *
 */
public class RoleRightDataSet implements Serializable {

	private static final long serialVersionUID = 2596134383656803773L;
	
	private String url;// 跳转地址

	private String roleName;// 角色名称

	private List<String> rightNames = new ArrayList<String>(); // 权限名称

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public List<String> getRightNames() {
		return rightNames;
	}

	public void setRightNames(List<String> rightNames) {
		this.rightNames = rightNames;
	}

	@Override
	public String toString() {
		return "RoleRightDataSet [url=" + url + ", roleName=" + roleName
				+ ", rightNames=" + rightNames + "]";
	}

}
