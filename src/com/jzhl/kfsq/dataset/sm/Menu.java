package com.jzhl.kfsq.dataset.sm;

import java.io.Serializable;

/**
 * 菜单结果集
 * 
 * @author Shaw
 *
 */
public class Menu implements Serializable {

	private static final long serialVersionUID = 5527416773129474903L;// 序列化
	
	private Integer rightId;// 权限编号
	
	private Integer parentId;// 父编号
	
	private String rightName;// 权限名称
	
	private Integer level;// 菜单级别
	
	private String menu;// 菜单地址
	
	private String imgName;// 图片名称

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

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public String getMenu() {
		return menu;
	}

	public void setMenu(String menu) {
		this.menu = menu;
	}

	public String getImgName() {
		return imgName;
	}

	public void setImgName(String imgName) {
		this.imgName = imgName;
	}

	@Override
	public String toString() {
		return "Menu [rightId=" + rightId + ", parentId=" + parentId
				+ ", rightName=" + rightName + ", level=" + level + ", menu="
				+ menu + ", imgName=" + imgName + "]";
	}

}
