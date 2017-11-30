package com.chenchen.base;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;

public class BaseQuery {
	
	private static final Integer PAGE = 1;
	private static final Integer ROWS = 2;
	private Integer page;
	private Integer rows;
	
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public Integer getRows() {
		return rows;
	}
	public void setRows(Integer rows) {
		this.rows = rows;
	}
	
	public PageBounds buildPageBounds() {
		if (page == null || page < 1) {
			page = PAGE;
		}
		if (rows == null || rows < 1) {
			rows = ROWS;
		}
		PageBounds pageBounds = new PageBounds(page, rows);
		return pageBounds;
	}
	
}
