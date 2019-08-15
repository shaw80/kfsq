package com.jzhl.kfsq.dataset.cm;

import java.io.Serializable;

import com.jzhl.kfsq.common.util.SystemConfig;

/**
 * 我的评价中的图片
 * 
 * @author Shaw
 *
 */
public class MyCommentImg implements Serializable {

	private static final long serialVersionUID = 5809075441702399062L;// 序列化

	private Integer imgId;// 图片编号

	private Integer commentId;// 评论编号

	private String path;// 路径

	public Integer getImgId() {
		return imgId;
	}

	public void setImgId(Integer imgId) {
		this.imgId = imgId;
	}

	public Integer getCommentId() {
		return commentId;
	}

	public void setCommentId(Integer commentId) {
		this.commentId = commentId;
	}

	public String getCommentImgPath() {
		if(path == null || "".equals(path)) {
			return "";
		}
		return SystemConfig.getHttpBasePath() + path;
	}
	
	public java.lang.String getCommentImgSmallPath() {
		if(path == null || path.isEmpty() || !path.contains(".")) {
			return "";
		}
		String imageName = path.substring(0, path.lastIndexOf("."));
		String extName = path.substring(path.lastIndexOf(".") + 1);
		return SystemConfig.getHttpBasePath() + (imageName + "_small." + extName);
	}

	public void setPath(String path) {
		this.path = path;
	}

	@Override
	public String toString() {
		return "MyCommentImg [imgId=" + imgId + ", commentId=" + commentId
				+ ", path=" + path + "]";
	}

}
