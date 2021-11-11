package com.minhtrung.daos.impl;

import com.minhtrung.daos.ISaleDetailDAO;
import com.minhtrung.models.SaleDetail;

public class SaleDetailDAO extends AbstractDAO<SaleDetail> implements ISaleDetailDAO{

	@Override
	public Long insert(SaleDetail detail) {
		StringBuilder sql = new StringBuilder("insert saledetail(quantity, price, saleid, productid) ");
		sql.append("value(?,?,?,?)");
		return insert(sql.toString(), null, detail.getQuantity(),detail.getPrice(), detail.getSaleid() , detail.getProductid());
	}
	

}
