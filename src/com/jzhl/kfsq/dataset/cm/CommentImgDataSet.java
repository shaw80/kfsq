package com.jzhl.kfsq.dataset.cm;

import java.io.Serializable;

import com.jzhl.kfsq.common.util.SystemConfig;

/**
 * 评论图片结果集
 * 
 * @author Shaw
 *
 */
public class CommentImgDataSet implements Serializable {
	
	private static final long serialVersionUID = 5828317937071474087L;// 序列化
	
	private String path;// 图片路径

	public String getPath() {
		if(path == null || path.isEmpty()) {
			return "";
		}
		return SystemConfig.getHttpBasePath() + path;
	}
	
	public String getSmallPath() {
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
		return "CommentImgDataSet [path=" + path + "]";
	}

}
