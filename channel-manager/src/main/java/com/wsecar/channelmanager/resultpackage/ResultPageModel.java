package com.wsecar.channelmanager.resultpackage;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * 分页请求结果封装
 */
public class ResultPageModel implements Serializable {

    private Integer currentPage;        // 当前页

    private Integer pageSize;           // 每页条目数

    private List<Map<String, Object>> body;     // 列表

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public List<Map<String, Object>> getBody() {
        return body;
    }

    public void setBody(List<Map<String, Object>> body) {
        this.body = body;
    }
}
