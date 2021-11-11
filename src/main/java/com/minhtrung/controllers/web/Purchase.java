package com.minhtrung.controllers.web;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.minhtrung.models.OrderSale;
import com.minhtrung.models.SaleDetail;
import com.minhtrung.services.IOrderSaleService;
import com.minhtrung.services.ISaleDetail;
import com.minhtrung.utils.HttpUtils;

@WebServlet(urlPatterns = "/api/purchase")
public class Purchase extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private IOrderSaleService service;

	@Inject
	private ISaleDetail saleDetail;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		OrderSale invoice=HttpUtils.of(request.getReader()).toModel(OrderSale.class);
		Long id = service.insert(invoice);
		invoice.setId(id);
		
		for(SaleDetail detail: invoice.getDetail()) {
			detail.setSaleid(id);
		}
		
		for(SaleDetail detail: invoice.getDetail()) {
			saleDetail.insert(detail);
		}
		ObjectMapper mapper = new ObjectMapper();
		response.setContentType("application/json");
		mapper.writeValue(response.getOutputStream(), id);
		
		
	}
	
}
