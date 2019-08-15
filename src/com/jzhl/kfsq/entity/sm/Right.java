package com.jzhl.kfsq.entity.sm;

import java.io.Serializable;
import java.sql.Date;

/**
 * 权限实体类
 * 
 * @author Shaw
 *
 */
public class Right implements Serializable {

	private static final long serialVersionUID = 8982489531140017648L;// 序列化
	
	private Integer rightId;// 权限编号
	
	private Integer parentId;// 父编号
	
	private String rightName;// 权限名称
	
	private String menu;// 菜单
	
	private String imgName;// 图片名称
	
	private String managerType;// 管理端类型（0：admin后台，1：楼盘后台，2：代理商后台）
	
	private Integer isValid;// 状态（0：无效、1：有效）
	
	private Integer creatorUserId;// 创建者编号
	
	private Date createTime;// 创建时间
	
	private String isMenu;// 是否是菜单（0：不是，1：是）

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

	public Integer getIsValid() {
		return isValid;
	}

	public void setIsValid(Integer isValid) {
		this.isValid = isValid;
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

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public String getMenu() {
		return menu;
	}

	public void setMenu(String menu) {
		this.menu = menu;
	}

	public String getManagerType() {
		return managerType;
	}

	public void setManagerType(String managerType) {
		this.managerType = managerType;
	}

	public String getIsMenu() {
		return isMenu;
	}

	public void setIsMenu(String isMenu) {
		this.isMenu = isMenu;
	}

	public String getImgName() {
		return imgName;
	}

	public void setImgName(String imgName) {
		this.imgName = imgName;
	}

	@Override
	public String toString() {
		return "Right [rightId=" + rightId + ", parentId=" + parentId
				+ ", rightName=" + rightName + ", menu=" + menu + ", imgName="
				+ imgName + ", managerType=" + managerType + ", isValid="
				+ isValid + ", creatorUserId=" + creatorUserId
				+ ", createTime=" + createTime + ", isMenu=" + isMenu + "]";
	}
	
}
