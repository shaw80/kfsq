package com.jzhl.kfsq.dataset.em;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.jzhl.kfsq.entity.em.EncyclopediaClasses;

public class EncyclopediaClassDataSet {
	private List<ClassDataSet> firstClassList = new ArrayList<ClassDataSet>();
	private List<ClassDataSet> secondClassList = new ArrayList<ClassDataSet>();
	private int currFirstClassId;
	private String currFirstClassName;
	private int current;
	
	public EncyclopediaClassDataSet() {
	}
	
	public List<ClassDataSet> getFirstClassList() {
		return firstClassList;
	}
	public void setFirstClassList(List<ClassDataSet> firstClassList) {
		this.firstClassList = firstClassList;
	}
	public List<ClassDataSet> getSecondClassList() {
		return secondClassList;
	}
	public void setSecondClassList(List<ClassDataSet> secondClassList) {
		this.secondClassList = secondClassList;
	}
	public int getCurrFirstClassId() {
		return currFirstClassId;
	}
	public void setCurrFirstClassId(int currFirstClassId) {
		this.currFirstClassId = currFirstClassId;
	}
	public String getCurrFirstClassName() {
		return currFirstClassName == null ? "" : currFirstClassName;
	}
	public void setCurrFirstClassName(String currFirstClassName) {
		this.currFirstClassName = currFirstClassName;
	}
	public int getCurrent() {
		return current;
	}
	public void setCurrent(int current) {
		this.current = current;
	}

	public void addFirstClassList(EncyclopediaClasses encyclopediaClasses) {
		ClassDataSet dataset = new ClassDataSet();
		BeanUtils.copyProperties(encyclopediaClasses, dataset);
		firstClassList.add(dataset);
	}

	public void addSecondClassList(EncyclopediaClasses encyclopediaClasses) {
		ClassDataSet dataset = new ClassDataSet();
		BeanUtils.copyProperties(encyclopediaClasses, dataset);
		secondClassList.add(dataset);
	}
	
}
