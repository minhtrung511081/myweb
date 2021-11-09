package com.minhtrung.paging;

public class Sorter {
	
	
	public Sorter(String sortName, String sortBy) {
		this.sortName = sortName;
		this.sortBy = sortBy;
	}
	
	public String getSortName() {
		return sortName;
	}
	public void setSortName(String sortName) {
		this.sortName = sortName;
	}
	public String getSortBy() {
		return sortBy;
	}
	public void setSortBy(String sortBy) {
		this.sortBy = sortBy;
	}
	private String sortName;
	private String sortBy;
	
}
