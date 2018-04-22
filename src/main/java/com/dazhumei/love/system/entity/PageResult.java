package com.dazhumei.love.system.entity;

import java.io.Serializable;
import java.util.List;

public class PageResult<T> implements Serializable {

	private int total;
	
	private List<T> rows;

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public List<T> getRows() {
		return rows;
	}

	public void setRows(List<T> rows) {
		this.rows = rows;
	}

	
}
