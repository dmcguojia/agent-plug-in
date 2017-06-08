package cn.com.agent.utils;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("all")
public class Page<T> {

	/**
     * 页码，从1开始
     */
    private int pageNum = 1;
    /**
     * 页面大小
     */
    private int pageSize = 10;
    private int totalCount;
    private int totalPage;
    public Page(int pageNum, int pageSize) {
		super();
		this.pageNum = pageNum;
		this.pageSize = pageSize;
	}

	private List<T> list = new ArrayList<T>();

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
		   if (pageSize > 0) {
	            totalPage = totalCount / pageSize + ((totalCount % pageSize == 0) ? 0 : 1);
	        } else {
	        	totalPage = 0;
	        }
	}

	public int getTotalPage() {
		
		return totalPage;
	}

	private void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}


	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}
	
}
