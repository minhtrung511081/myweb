package com.minhtrung.services.impl;

import javax.inject.Inject;

import com.minhtrung.daos.ISaleDetailDAO;
import com.minhtrung.models.SaleDetail;
import com.minhtrung.services.ISaleDetail;

public class SaleDetailService implements ISaleDetail{
	
	@Inject
	private ISaleDetailDAO dao;

	@Override
	public Long insert(SaleDetail detail) {
		return dao.insert(detail);
	}
	
}
