package com.minhtrung.services.impl;

import java.sql.Timestamp;

import javax.inject.Inject;

import com.minhtrung.daos.IOrderSaleDAO;
import com.minhtrung.models.OrderSale;
import com.minhtrung.models.SaleDetail;
import com.minhtrung.services.IOrderSaleService;

public class OrderSaleService implements IOrderSaleService{

	@Inject
	private IOrderSaleDAO dao;

	@Override
	public Long insert(OrderSale orderSale) {
		float total=0;
		for(SaleDetail sale: orderSale.getDetail()){
			total =+ sale.getPrice()*sale.getQuantity();
		}
		orderSale.setTotal(total);
		orderSale.setCreateTime(new Timestamp(System.currentTimeMillis()));
		return dao.insert(orderSale);
	}
	
}
