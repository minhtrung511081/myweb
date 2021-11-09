package com.minhtrung.paging;

public class PageRequest implements Pageble{
	private Integer page;
	private Integer limit;
	private Sorter sorter;
	
	public PageRequest(Integer page, Integer limit, Sorter sorter) {
		this.page = page;
		this.limit = limit;
		this.sorter = sorter;
	}

	@Override
	public Integer getPage() {
		return page;
	}

	@Override
	public Integer getOffset() {
		if(page!=null & limit!=null) {
			return (this.page-1)*this.limit;
		}
		return null;
	}

	@Override
	public Integer getLimit() {
		return limit;
	}

	@Override
	public Sorter getSorter() {
		return sorter;
	}

}
