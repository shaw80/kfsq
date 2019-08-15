package com.jzhl.kfsq.dataset.bm;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 教育结果集
 * 
 * @author mac
 *
 */
public class EducationInfo implements Serializable {

	private static final long serialVersionUID = 3167239617177450852L;

	private String type;// 教育类型
	
	private List<EducationScoreDataSet> data = new ArrayList<EducationScoreDataSet>();// 教育集合

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<EducationScoreDataSet> getData() {
		return data;
	}

	public void setData(List<EducationScoreDataSet> data) {
		this.data = data;
	}

}
