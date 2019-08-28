package com.szxs.utils;

import java.util.List;

public class Pager<T> {
	/**
	 * 当前页码
	 */
	private int pageNo;
	/**
	 * 页大小
	 */
	private int pageSize;
	/**
	 * 总行数
	 */
	private int totalRows;
	/**
	 * 总页数
	 */
	private int totalPage;
	/*
	 * 分页查询后的数据集合
	 */
    private List<T> datas;

    public List<T> getDatas() {
        return datas;
    }

    public void setDatas(List<T> datas) {
        this.datas = datas;
    }

    public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalRows() {
		return totalRows;
	}

	public void setTotalRows(int totalRows) {
		this.totalRows = totalRows;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

}
