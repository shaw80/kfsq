package com.jzhl.kfsq.dataset.sm;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 一二级菜单结果集
 * 
 * @author Shaw
 *
 */
public class Menus implements Serializable {

	private static final long serialVersionUID = 5527416773129474903L;// 序列化
	
	private Menu first;
	
	private List<Menu> second = new ArrayList<Menu>();

	public Menu getFirst() {
		return first;
	}

	public void setFirst(Menu first) {
		this.first = first;
	}

	public List<Menu> getSecond() {
		return second;
	}

	public void setSecond(List<Menu> second) {
		this.second = second;
	}

	@Override
	public String toString() {
		return "Menus [first=" + first + ", second=" + second + "]";
	}
	
}
