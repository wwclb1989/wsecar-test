package com.wsecar.channelmanager.argspackage;

import java.io.Serializable;
import java.util.Map;

/**
 * 分页请求参数打包
 */
public class PageModel implements Serializable{

	private int currentPage = 1;		// 当前页数

    private int pageSize = 15;			// 每页显示数

    //请求参数body
    private Map<String, Object> body;

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public Map<String, Object> getBody() {
		return body;
	}

	public void setBody(Map<String, Object> body) {
		this.body = body;
	}
}
