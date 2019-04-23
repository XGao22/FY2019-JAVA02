package com.neuedu.user;

import java.util.List;

public class PageModel<T> {

	private int totalPage;
	private int currentPage;
	private boolean hasBefore;
	private boolean hasNext;
	private List<T> data;
	
	
	public PageModel(int totalPage, int currentPage, boolean hasBefore, boolean hasNext, List<T> data) {
		super();
		this.totalPage = totalPage;
		this.currentPage = currentPage;
		this.hasBefore = hasBefore;
		this.hasNext = hasNext;
		this.data = data;
	}


	public PageModel() {}


	public int getTotalPage() {
		return totalPage;
	}


	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}


	public int getCurrentPage() {
		return currentPage;
	}


	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}


	public boolean isHasBefore() {
		return hasBefore;
	}


	public void setHasBefore(boolean hasBefore) {
		this.hasBefore = hasBefore;
	}


	public boolean isHasNext() {
		return hasNext;
	}


	public void setHasNext(boolean hasNext) {
		this.hasNext = hasNext;
	}


	public List<T> getData() {
		return data;
	}


	public void setData(List<T> data) {
		this.data = data;
	}
	
	
	
	
}
