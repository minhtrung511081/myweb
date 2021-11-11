package com.minhtrung.daos.impl;

import com.minhtrung.daos.IOrderSaleDAO;
import com.minhtrung.models.OrderSale;

public class OrderSaleDAO extends AbstractDAO<OrderSale> implements IOrderSaleDAO{

	@Override
	public Long insert(OrderSale order) {
		StringBuilder sql = new StringBuilder("insert ordersale(name,gender,phone,total,createtime,towncode,paymentscode) value(?,?,?,?,?,?,?)");
		return insert(sql.toString(), null, order.getName(), order.getGender(), order.getPhone(), order.getTotal(),order.getCreateTime(), order.getTowncode(), order.getPaymentscode());
	}
	
}
